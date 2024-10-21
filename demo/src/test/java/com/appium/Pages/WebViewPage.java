package com.appium.Pages;

import org.openqa.selenium.By;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

public class WebViewPage extends CatalogElementPage {
    
    By textFieldsLocator = AppiumBy.className("XCUIElementTypeTextField");
    
    public WebViewPage(AppiumDriver appiumDriver)
    {
        super(appiumDriver);
    }
}
