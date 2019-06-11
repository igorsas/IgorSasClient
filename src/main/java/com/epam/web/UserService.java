package com.epam.web;


import com.epam.web.soap.LoginModel;
import com.epam.web.soap.Role;
import com.epam.web.soap.ServiceException;
import com.epam.web.soap.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    List<Role> getRoles() throws ServiceException;

    List<User> getUsersByRole(String role) throws ServiceException;

    boolean addUser(User user) throws ServiceException;

    boolean removeUser(User user) throws ServiceException;

    boolean logIn(LoginModel login) throws ServiceException;
}
