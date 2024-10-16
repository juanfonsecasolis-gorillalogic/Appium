package com.appium.Pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

public abstract class CatalogElementPage extends PageBase {

    public CatalogElementPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }
    
    public String getHeader()
    {
        return appiumDriver.findElement(
            AppiumBy.className("XCUIElementTypeStaticText")
        ).getText();
    }
}
