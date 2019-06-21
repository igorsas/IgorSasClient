package com.epam.web;

import com.epam.utils.parser.JsonParser;
import com.epam.web.factory.Service;
import com.epam.web.factory.ServiceFactory;
import com.epam.web.factory.UserService;
import com.epam.web.soap.LoginModel;
import com.epam.web.soap.Role;
import com.epam.web.soap.ServiceException;
import com.epam.web.soap.User;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class LoggingTest extends BaseTest{
    private static final Logger LOGGER = LogManager.getLogger(LoggingTest.class);

    @Test(dataProvider = "typeService", expectedExceptions = ServiceException.class)
    public void incorrectLogInTest(Service typeService) throws ServiceException {
        LOGGER.info("logging in by incorrect credentials " + typeService);
        UserService service = ServiceFactory.getUserService(typeService);
        LoginModel loginModel = new LoginModel();
        User invalidUser = JsonParser.getInvalidUser();
        loginModel.setUsername(invalidUser.getUsername());
        loginModel.setPassword(invalidUser.getPassword());
        service.logIn(loginModel);
    }

    @Test(dataProvider = "typeService")
    public void logInTest(Service typeService) throws ServiceException {
        LOGGER.info("logging in by correct credentials " + typeService);
        UserService service = ServiceFactory.getUserService(typeService);
        LoginModel loginModel = new LoginModel();
        User user = JsonParser.getValidUser();
        loginModel.setUsername(user.getUsername());
        loginModel.setPassword(user.getPassword());
        Assert.assertTrue(service.logIn(loginModel), "can't log in");
        LOGGER.info("getting roles for current user");
        List<Role> roles = service.getRoles();
        LOGGER.info("roles for current user: " + roles);
        Assert.assertFalse(roles.isEmpty(), "list of role for user is empty");
    }

    @Test(dataProvider = "typeService")
    public void logOutTest(Service typeService) throws ServiceException {
        LOGGER.info("logging out when one user already is in system " + typeService);
        UserService service = ServiceFactory.getUserService(typeService);
        Assert.assertTrue(service.logOut(), "can't log out");
    }

    @Test(dataProvider = "typeService", expectedExceptions = ServiceException.class)
    public void logOutWhenHasNotLoggedInUsersTest(Service typeService) throws ServiceException {
        LOGGER.info("logging out when one user already is in system " + typeService);
        UserService service = ServiceFactory.getUserService(typeService);
        service.logOut();
    }
}
