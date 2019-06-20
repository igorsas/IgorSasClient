package com.epam.web;

import com.epam.listener.LoggerListener;
import com.epam.web.soap.LoginModel;
import com.epam.web.soap.Role;
import com.epam.web.soap.ServiceException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.List;

@Listeners({LoggerListener.class})
public class LogInTest {
    private Logger LOGGER = LogManager.getLogger(LogInTest.class);

    @DataProvider
    private Object[] typeService(){
        return new Object[]{ServiceFactory.REST, ServiceFactory.SOAP};
    }

    @Test(dataProvider = "typeService", expectedExceptions = ServiceException.class)
    public void incorrectLogInTest(String typeService) throws ServiceException {
        LOGGER.info("logging in by incorrect credentials " + typeService);
        UserService service = ServiceFactory.getUserService(typeService);
        LoginModel loginModel = new LoginModel();
        loginModel.setUsername("?donaldTrump");
        loginModel.setPassword("012-321");
        service.logIn(loginModel);
    }

    @Test(dataProvider = "typeService")
    public void logInTest(String typeService) throws ServiceException {
        LOGGER.info("logging in by correct credentials " + typeService);
        UserService service = ServiceFactory.getUserService(typeService);
        LoginModel loginModel = new LoginModel();
        loginModel.setUsername("igor99");
        loginModel.setPassword("qwerty");
        Assert.assertTrue(service.logIn(loginModel), "logging in");
        LOGGER.info("getting roles for current user");
        List<Role> roles = service.getRoles();
        LOGGER.info("roles for current user: " + roles);
        Assert.assertFalse(roles.isEmpty(), "list of role for user isn't empty");
    }
}
