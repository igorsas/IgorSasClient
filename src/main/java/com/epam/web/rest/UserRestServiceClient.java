package com.epam.web.rest;


import com.epam.web.UserService;
import com.epam.web.soap.*;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import java.io.IOException;
import java.util.List;

public class UserRestServiceClient implements UserService {


    public Logger LOGGER = LogManager.getLogger(UserRestServiceClient.class);

    public static final String BASE_ADDRESS = "http://localhost:8080/IgorSasService/rest/";

    private ClientConfig clientConfig;
    private Client client;

    public UserRestServiceClient() {
        clientConfig = new DefaultClientConfig();
        clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
        clientConfig = new DefaultClientConfig();
        client = Client.create(clientConfig);
    }

    public List<User> getAllUsers() {
        LOGGER.info("getAllBooks method");
        ObjectMapper mapper = new ObjectMapper();

        String uri = BASE_ADDRESS + "/users";
        LOGGER.info("path:" + uri);

        WebResource webResource = client.resource(uri);

        ClientResponse response = webResource.accept("application/json;encoding=UTF-8")
                .get(ClientResponse.class);

        String usersJson = response.getEntity(String.class);
        List<User> list = null;

        try {
            list = mapper.readValue(usersJson, new TypeReference<List<User>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }

    public List<Role> getRoles() throws ServiceException {
        LOGGER.info("get Roles for user");

        ObjectMapper mapper = new ObjectMapper();
        String uri = BASE_ADDRESS + "/role";
        LOGGER.info("path:" + uri);

        WebResource webResource = client.resource(uri);

        ClientResponse response = webResource.accept("application/json;encoding=UTF-8").type("application/json")
                .get(ClientResponse.class);

        List<Role> list = null;
        if (response.getStatus() != 200) {
            throw buildException(response, mapper);
        } else {
            String jsonRoles = response.getEntity(String.class);

            try {
                list = mapper.readValue(jsonRoles, new TypeReference<List<Role>>() {
                });
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return list;
    }

    public List<User> getUsersByRole(String role) throws ServiceException {
        LOGGER.info("get Users by Role");

        ObjectMapper mapper = new ObjectMapper();
        String uri = BASE_ADDRESS + "/role/"+role;
        LOGGER.info("path:" + uri);

        WebResource webResource = client.resource(uri);

        ClientResponse response = webResource.accept("application/json;encoding=UTF-8").type("application/json")
                .get(ClientResponse.class);

        List<User> list = null;
        if (response.getStatus() != 200) {
            throw buildException(response, mapper);
        } else {
            String jsonRoles = response.getEntity(String.class);

            try {
                list = mapper.readValue(jsonRoles, new TypeReference<List<User>>() {
                });
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return list;
    }

    public boolean addUser(User user) throws ServiceException {
        LOGGER.info("add new user");

        ObjectMapper mapper = new ObjectMapper();
        String uri = BASE_ADDRESS + "/user";
        LOGGER.info("path:" + uri);

        WebResource webResource = client.resource(uri);

        ClientResponse response = null;
        try {
            response = webResource.accept("application/json;encoding=UTF-8").type("application/json")
                    .post(ClientResponse.class, mapper.writeValueAsString(user));
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (response.getStatus() != 200) {
            throw buildException(response, mapper);
        }
        return true;
    }

    public boolean removeUser(User user) throws ServiceException {
        LOGGER.info("removeUser");

        ObjectMapper mapper = new ObjectMapper();

        String uri = BASE_ADDRESS + "/user/delete";
        LOGGER.info("path:" + uri);

        WebResource webResource = client.resource(uri);

        ClientResponse response = null;
        try {
            response = webResource.accept("application/json;encoding=UTF-8").type("application/json")
                    .delete(ClientResponse.class, mapper.writeValueAsString(user));
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (response.getStatus() != 200) {
            throw buildException(response, mapper);
        }
        return true;
    }

    public boolean logIn(LoginModel loginModel) throws ServiceException {
        LOGGER.info("loggin in user");

        ObjectMapper mapper = new ObjectMapper();
        String uri = BASE_ADDRESS + "/login";
        LOGGER.info("path:" + uri);

        WebResource webResource = client.resource(uri);

        ClientResponse response = null;
        try {
            response = webResource.accept("application/json;encoding=UTF-8").type("application/json")
                    .post(ClientResponse.class, mapper.writeValueAsString(loginModel));
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (response.getStatus() != 200) {
            throw buildException(response, mapper);
        }
        return true;
    }

    private ServiceException buildException(ClientResponse response, ObjectMapper mapper) throws ServiceException {
        LOGGER.info("getAuthorBooks");
        String jsonFaultInfo = response.getEntity(String.class);

        UserFault faultInfo = null;
        try {
            faultInfo = mapper.readValue(jsonFaultInfo, UserFault.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ServiceException(faultInfo);

    }

}