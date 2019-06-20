package com.epam.web;

import com.epam.listener.LoggerListener;
import com.epam.web.soap.ServiceException;
import com.epam.web.soap.User;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.List;

@Listeners({LoggerListener.class})
public class GetUsersTest {
    private Logger LOGGER = LogManager.getLogger(GetUsersTest.class);

    @DataProvider
    private Object[] typeService(){
        return new Object[]{ServiceFactory.REST, ServiceFactory.SOAP};
    }

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
        String role = "humunkul";
        UserService service = ServiceFactory.getUserService(typeService);
        List<User> users = service.getUsersByRole(role);
    }

    @Test(dataProvider = "typeService")
    public void getUsersByRole(String typeService) throws ServiceException {
        LOGGER.info("get users by incorrect role " + typeService);
        String role = "user";
        UserService service = ServiceFactory.getUserService(typeService);
        List<User> users = service.getUsersByRole(role);
        LOGGER.info("users: " + users);
        Assert.assertFalse(users.isEmpty(), "user list isn't empty");
    }
}
