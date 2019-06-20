package com.epam.web;

import com.epam.listener.LoggerListener;
import com.epam.utils.parser.JsonParser;
import com.epam.web.soap.Role;
import com.epam.web.soap.ServiceException;
import com.epam.web.soap.User;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.List;

@Listeners({LoggerListener.class})
public class UpdateUsersTest extends BaseTest {
    private Logger LOGGER = LogManager.getLogger(UpdateUsersTest.class);

    @Test(dataProvider = "typeService", expectedExceptions = ServiceException.class)
    public void addUserWhichAlreadyExistTest(Service typeService) throws ServiceException {
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
    public void addNewUserTest(Service typeService) throws ServiceException {
        LOGGER.info("adding user which already exist test");
        UserService service = ServiceFactory.getUserService(typeService);
        User user = new User();
        Role role = JsonParser.getValidRole();
        user.setUsername(String.valueOf(service.getClass().hashCode()));
        user.setPassword(String.valueOf(service.getClass().hashCode()));
        user.setRole(role);
        Assert.assertTrue(service.addUser(user), "user was not added to service");
        LOGGER.info("get all users by " + typeService);
        LOGGER.debug("User: " + user);
        List<User> users = service.getAllUsers();
        LOGGER.debug("All users: " + users);
        Assert.assertTrue(users.contains(user), "user isn't exist in system");
    }

    @Test(dataProvider = "typeService", expectedExceptions = ServiceException.class)
    public void deleteUserWhichIsNotExist(Service typeService) throws ServiceException {
        LOGGER.info("deleting user which isn't exist in system " + typeService);
        UserService service = ServiceFactory.getUserService(typeService);
        User user = JsonParser.getInvalidUser();
        service.removeUser(user);
    }

    @Test(dataProvider = "typeService")
    public void deleteUserTest(Service typeService) throws ServiceException {
        LOGGER.info("deleting user test");
        UserService service = ServiceFactory.getUserService(typeService);
        LOGGER.info("get all users by " + typeService);
        List<User> users = service.getAllUsers();
        User userFromService = users.get(users.size()-1);
        //we need delete user without non-null field roles, because of in csv file we haven't got that one field
        User correctedForRemovingUser = new User();
        correctedForRemovingUser.setUsername(userFromService.getUsername());
        correctedForRemovingUser.setPassword(userFromService.getPassword());
        correctedForRemovingUser.setRole(userFromService.getRole());
        Assert.assertTrue(service.removeUser(correctedForRemovingUser), "user " + correctedForRemovingUser + "was not deleted");
        LOGGER.info("get all users by " + typeService);
        users = service.getAllUsers();
        Assert.assertFalse(users.contains(correctedForRemovingUser), "user " + correctedForRemovingUser + " exist in the system");
    }
}
