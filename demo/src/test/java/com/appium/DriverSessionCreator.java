package com.appium;

import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class DriverSessionCreator {
    
    public static AppiumDriver getDriver() throws MalformedURLException
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

        AppiumDriver appiumDriver = new IOSDriver(
            new URL("http://127.0.0.1:4723/"), 
            caps);

        Reporter.log("Session ID: " + appiumDriver.getSessionId());
        return appiumDriver;
    }

}
