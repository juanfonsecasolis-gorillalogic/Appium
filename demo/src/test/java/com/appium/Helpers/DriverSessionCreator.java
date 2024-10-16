package com.appium.Helpers;

import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import java.io.File;
import java.net.URL;

public class DriverSessionCreator {
    
    public enum DriverType
    {
        IOS,
        Android
    }
    
    public static AppiumDriver getDriver(DriverType driverType) throws Exception
    {
        AppiumDriver appiumDriver;
        ChromeOptions caps = new ChromeOptions();
        URL appiumUrl = new URL("http://127.0.0.1:4723/");

        switch (driverType) {
            case IOS:
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
        
                appiumDriver = new IOSDriver(appiumUrl, caps);
                break;
        
            default:
                throw new Exception("No driver has been implemented for " + driverType + " yet.");
        }

        Reporter.log("Session ID: " + appiumDriver.getSessionId());
        return appiumDriver;
    }

}
