package com.epam.web;

import com.epam.listener.LoggerListener;
import com.epam.utils.parser.JsonParser;
import com.epam.web.soap.ServiceException;
import com.epam.web.soap.User;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.List;

@Listeners({LoggerListener.class})
public class GetUsersTest extends BaseTest {
    private Logger LOGGER = LogManager.getLogger(GetUsersTest.class);

    @Test(dataProvider = "typeService")
    public void getAllUsersTest(String typeService){
        LOGGER.info("get all users by " + typeService);
        UserService service = ServiceFactory.getUserService(typeService);
        List<User> users = service.getAllUsers();
        LOGGER.info("users: " + users);
        Assert.assertFalse(users.isEmpty(), "user list isn't empty");
    }

    @Test(dataProvider = "typeService", expectedExceptions = ServiceException.class)
    public void getUsersByIncorrectRoleTest(String typeService) throws ServiceException {
        LOGGER.info("get users by incorrect role " + typeService);
        UserService service = ServiceFactory.getUserService(typeService);
        service.getUsersByRole(JsonParser.getInvalidRole().getName());
    }

    @Test(dataProvider = "typeService")
    public void getUsersByRole(String typeService) throws ServiceException {
        LOGGER.info("get users by incorrect role " + typeService);
        UserService service = ServiceFactory.getUserService(typeService);
        List<User> users = service.getUsersByRole(JsonParser.getValidRole().getName());
        LOGGER.info("users: " + users);
        Assert.assertFalse(users.isEmpty(), "user list isn't empty");
    }
}
