package com.epam.web.factory;

import com.epam.web.rest.UserRestServiceClient;
import com.epam.web.soap.UserServiceImplService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class ServiceFactory {
    private static final Logger LOGGER = LogManager.getLogger(ServiceFactory.class);


    public static UserService getUserService(Service choice) {
        LOGGER.info("getUserService factory method");

        UserService service;
        if (choice.equals(Service.REST)) {
            LOGGER.info("Creating Rest user service client");
            service = new UserRestServiceClient();
        } else if (choice.equals(Service.SOAP)) {
            LOGGER.info("Creating Soap user service client");
            service = new UserServiceImplService().getUserServiceImplPort();
        } else {
            LOGGER.info("Wrong input");
            throw new RuntimeException();
        }
        return service;
    }
}
