package com.epam.web;

import org.testng.annotations.DataProvider;

public class BaseTest {
    @DataProvider
    protected Object[] typeService(){
        return new Object[]{ServiceFactory.REST, ServiceFactory.SOAP};
    }
}
