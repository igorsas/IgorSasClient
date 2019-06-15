package com.epam.web;

import com.epam.web.soap.Role;
import com.epam.web.soap.ServiceException;
import com.epam.web.soap.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class UpdateUsersTest {
    private Logger LOGGER = LogManager.getLogger(LogInTest.class);

    @DataProvider
    private Object[] typeService(){
        return new Object[]{ServiceFactory.REST, ServiceFactory.SOAP};
    }

    @Test(dataProvider = "typeService", expectedExceptions = ServiceException.class)
    public void addUserWhichAlreadyExistTest(String typeService) throws ServiceException {
        LOGGER.info("adding user which already exist test");
        UserService service = ServiceFactory.getUserService(typeService);
        User user = new User();
        Role role = new Role();
        role.setName("administrator");
        user.setUsername("igor99");
        user.setPassword("qwerty");
        user.setRole(role);
        service.addUser(user);
    }

    @Test(dataProvider = "typeService")
    public void addNewUserTest(String typeService) throws ServiceException {
        LOGGER.info("adding user which already exist test");
        UserService service = ServiceFactory.getUserService(typeService);
        User user = new User();
        Role role = new Role();
        role.setName("user");
        user.setUsername(String.valueOf(service.getClass().hashCode()));
        user.setPassword(String.valueOf(service.getClass().hashCode()));
        user.setRole(role);
        Assert.assertTrue(service.addUser(user), "adding new user");
        LOGGER.info("get all users by " + typeService);
        List<User> users = service.getAllUsers();
        Assert.assertTrue(users.contains(user));
    }

    @Test(dataProvider = "typeService", expectedExceptions = ServiceException.class)
    public void deleteUserWhichIsNotExist(String typeService) throws ServiceException {
        LOGGER.info("deleting user which isn't exist in system " + typeService);
        UserService service = ServiceFactory.getUserService(typeService);
        User user = new User();
        Role role = new Role();
        role.setName("user");
        user.setUsername(String.valueOf(service.getClass().hashCode()));
        user.setPassword(String.valueOf(service.getClass().hashCode()));
        user.setRole(role);
        service.removeUser(user);
    }

    @Test(dataProvider = "typeService")
    public void deleteUserTest(String typeService) throws ServiceException {
        LOGGER.info("deleting user test");
        UserService service = ServiceFactory.getUserService(typeService);
        LOGGER.info("get all users by " + typeService);
        List<User> users = service.getAllUsers();
        User user = users.get(users.size()-1);
        Assert.assertTrue(service.removeUser(user), "removing user " + user);
        LOGGER.info("get all users by " + typeService);
        users = service.getAllUsers();
        Assert.assertFalse(users.contains(user));
    }
}
