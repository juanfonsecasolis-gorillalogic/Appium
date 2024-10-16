package com.appium;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import io.appium.java_client.AppiumDriver;

public class TestBase {
    
    AppiumDriver appiumDriver;

    @BeforeMethod()
    public void setUp() throws Exception
    {
        appiumDriver = DriverSessionCreator.getDriver();
    }

    @AfterMethod()
    public void tearDown() throws Exception{
        Thread.sleep(10000);
        appiumDriver.quit();
    }

}
