package com.epam.web.rest;


import com.epam.web.factory.UserService;
import com.epam.web.soap.*;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import java.io.IOException;
import java.util.List;

public class UserRestServiceClient implements UserService {
    private static final String BASE_ADDRESS = "http://localhost:8080/IgorSasService/rest";
    private static final Logger LOGGER = LogManager.getLogger(UserRestServiceClient.class);
    private Client client;
    private ObjectMapper mapper;

    public UserRestServiceClient() {
        client = Client.create();
        mapper = new ObjectMapper();
    }

    public List<User> getAllUsers() {
        LOGGER.info("get all users rest");
        ClientResponse response = client
                .resource(BASE_ADDRESS + "/users")
                .accept("application/json;encoding=UTF-8")
                .get(ClientResponse.class);
        try {
            return mapper.readValue(response.getEntity(String.class), new TypeReference<List<User>>() {
            });
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public List<Role> getRoles() throws ServiceException {
        LOGGER.info("get Roles for user rest");
        ClientResponse response = client
                .resource(BASE_ADDRESS + "/roles")
                .accept("application/json;encoding=UTF-8")
                .type("application/json")
                .get(ClientResponse.class);

        if (response.getStatus() != 200) {
            LOGGER.error("Can't get roles for current user. Are you logged in?");
            throw new ServiceException("HTTP Error Code: " + response.getStatus());
        } else {
            try {
                return mapper.readValue(response.getEntity(String.class), new TypeReference<List<Role>>() {
                });
            } catch (IOException e) {
                LOGGER.error(e.getMessage());
                e.printStackTrace();
                return null;
            }
        }
    }

    public List<User> getUsersByRole(String role) throws ServiceException {
        LOGGER.info("get Users by Role rest");

        ClientResponse response = client
                .resource(BASE_ADDRESS + "/role/" + role)
                .accept("application/json;encoding=UTF-8")
                .type("application/json")
                .get(ClientResponse.class);

        if (response.getStatus() != 200) {
            LOGGER.error("Can't get users by role. Please, check that role is correct");
            throw new ServiceException("HTTP Error Code: " + response.getStatus());
        } else {
            String jsonRoles = response.getEntity(String.class);
            try {
                return mapper.readValue(jsonRoles, new TypeReference<List<User>>() {
                });
            } catch (IOException e) {
                LOGGER.error(e.getMessage());
                e.printStackTrace();
                return null;
            }
        }
    }

    public boolean addUser(User user) throws ServiceException {
        LOGGER.info("add new user by rest");
        try {
            return postMethod(BASE_ADDRESS + "/user/add", mapper.writeValueAsString(user));
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public boolean removeUser(User user) throws ServiceException {
        LOGGER.info("remove User by rest");
        try {
            ClientResponse response = client
                    .resource(BASE_ADDRESS + "/user/delete")
                    .accept("application/json;encoding=UTF-8")
                    .type("application/json")
                    .delete(ClientResponse.class, mapper.writeValueAsString(user));
            if (response.getStatus() != 200) {
                throw new ServiceException("HTTP Error Code: " + response.getStatus());
            }
            return true;
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public boolean logIn(LoginModel loginModel) throws ServiceException {
        LOGGER.info("logging in user by rest");

        try {
            return postMethod(BASE_ADDRESS + "/login", mapper.writeValueAsString(loginModel));
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    private boolean postMethod(String url, String s) throws ServiceException {
        LOGGER.info("post method: " + url);
        ClientResponse response = client
                .resource(url)
                .accept("application/json;encoding=UTF-8")
                .type("application/json")
                .post(ClientResponse.class, s);
        if (response.getStatus() != 200) {
            throw new ServiceException("HTTP Error Code: " + response.getStatus());
        }
        return true;
    }
}