package com.appium;

import java.io.File;
import java.net.URL;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Tests {
    
    AppiumDriver appiumDriver;

    @BeforeMethod()
    public void setUp() throws Exception
    {
        ChromeOptions caps = new ChromeOptions();
        caps.setCapability("platformName", "iOS");
        caps.setCapability("appium:automationName", "XCUITest");
        caps.setCapability("appium:deviceName", "iPhone 15");
        caps.setCapability("appium:udid", "3B5EB227-9C4D-4EA8-8621-37544D56C1C9");
        String appPath = System.getProperty("user.dir") 
            + File.separator 
            + "src"
            + File.separator
            + "test"
            + File.separator
            + "resources"
            + File.separator
            + "UIKitCatalog-iphonesimulator.app";
        caps.setCapability("appium:app", appPath);

        appiumDriver = new IOSDriver(
            new URL("http://127.0.0.1:4723/"), 
            caps);

        Reporter.log("Session ID: " + appiumDriver.getSessionId());
    }

    @AfterMethod()
    public void tearDown() throws Exception{
        Thread.sleep(10000);
        appiumDriver.quit();
    }

    @Test
    public void SimpleTest() throws InterruptedException
    {
        // assert component text
        WebElement activityIndicatorElement =
            appiumDriver.findElement(AppiumBy.accessibilityId(
                "Activity Indicators"
            ));
        Assert.assertEquals(activityIndicatorElement.getText(),"Activity Indicators");
    
        // click component and verify the Activity Indicators page opens
        activityIndicatorElement.click();
        WebElement pageHeaderElement =
            appiumDriver.findElement(AppiumBy.className(
                "XCUIElementTypeStaticText"
            ));
        Assert.assertEquals(pageHeaderElement.getText(), "Activity Indicators");
    }

}
