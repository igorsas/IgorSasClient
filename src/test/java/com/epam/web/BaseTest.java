package com.epam.web;

import com.epam.listener.LoggerListener;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;

@Listeners({LoggerListener.class})
public class BaseTest {
    @DataProvider
    protected Object[] typeService(){
        return new Object[]{Service.REST, Service.SOAP};
    }
}
