package com.epam.web;

import com.epam.web.rest.UserRestServiceClient;
import com.epam.web.soap.UserServiceImplService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class ServiceFactory {
    private static Logger LOGGER = LogManager.getLogger(ServiceFactory.class);
    public static final String REST = "REST";
    public static final String SOAP = "SOAP";

    public static UserService getUserService(String choice) {
        LOGGER.info("getUserService factory method");

        UserService service;
        if (choice.equals(REST)) {
            LOGGER.info("Creating Rest user service client");
            service = new UserRestServiceClient();
        } else if (choice.equals(SOAP)) {
            LOGGER.info("Creating Soap user service client");
            service = new UserServiceImplService().getUserServiceImplPort();
        } else {
            LOGGER.info("Wrong input");
            throw new RuntimeException();
        }
        return service;
    }

}
