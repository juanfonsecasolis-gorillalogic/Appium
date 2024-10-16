package com.appium.Tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.appium.Helpers.DriverSessionCreator;
import com.appium.Helpers.DriverSessionCreator.DriverType;
import com.appium.Pages.HomePage;
import com.appium.Pages.PageBase;
import io.appium.java_client.AppiumDriver;

public class TestBase {
    
    protected AppiumDriver appiumDriver;
    protected PageBase currentPage;

    @BeforeMethod()
    public void setUp() throws Exception
    {
        appiumDriver = DriverSessionCreator.getDriver(DriverType.IOS);
        currentPage = new HomePage(appiumDriver);
    }

    @AfterMethod()
    public void tearDown() throws Exception{
        appiumDriver.quit();
    }

}
