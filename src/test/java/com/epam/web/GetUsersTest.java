package com.epam.web;

import com.epam.utils.parser.JsonParser;
import com.epam.web.factory.Service;
import com.epam.web.factory.ServiceFactory;
import com.epam.web.factory.UserService;
import com.epam.web.soap.ServiceException;
import com.epam.web.soap.User;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class GetUsersTest extends BaseTest {
    private static final Logger LOGGER = LogManager.getLogger(GetUsersTest.class);

    @Test(dataProvider = "typeService")
    public void getAllUsersTest(Service typeService){
        LOGGER.info("get all users by " + typeService);
        UserService service = ServiceFactory.getUserService(typeService);
        List<User> users = service.getAllUsers();
        LOGGER.info("users: " + users);
        Assert.assertFalse(users.isEmpty(), "user list is empty");
    }

    @Test(dataProvider = "typeService", expectedExceptions = ServiceException.class)
    public void getUsersByIncorrectRoleTest(Service typeService) throws ServiceException {
        LOGGER.info("get users by incorrect role " + typeService);
        UserService service = ServiceFactory.getUserService(typeService);
        service.getUsersByRole(JsonParser.getInvalidRole().getName());
    }

    @Test(dataProvider = "typeService")
    public void getUsersByRoleTest(Service typeService) throws ServiceException {
        LOGGER.info("get users by incorrect role " + typeService);
        UserService service = ServiceFactory.getUserService(typeService);
        List<User> users = service.getUsersByRole(JsonParser.getValidRole().getName());
        LOGGER.info("users: " + users);
        Assert.assertFalse(users.isEmpty(), "user list is empty");
    }

    @Test(dataProvider = "typeService", expectedExceptions = ServiceException.class)
    public void getRolesWhenUserIsNotLoggedIn(Service typeService) throws ServiceException {
        LOGGER.info("get roles for not logged in user " + typeService);
        UserService service = ServiceFactory.getUserService(typeService);
        service.getRoles();
    }
}
