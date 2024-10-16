package com.appium.Pages;

import org.openqa.selenium.WebElement;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

public class HomePage extends PageBase 
{
    public enum CatalogElementType
    {
        ActivityIndicators, AlertViews
    }
    
    public HomePage(AppiumDriver appiumDriver)
    {
        super(appiumDriver);
    }

    public WebElement getCatalogElementMenuItem(
        CatalogElementType catalogElementType) throws Exception
    {
        switch (catalogElementType) {
            case ActivityIndicators:
                // accessibility ID
                return appiumDriver.findElement(AppiumBy.accessibilityId(
                    "Activity Indicators"
                ));
            case AlertViews:
                // iOS Predicate
                return appiumDriver.findElement(
                    AppiumBy.iOSNsPredicateString(
                        "name == \"Alert Views\""
                ));
            default:
                throw new Exception("Unknown type " + catalogElementType);
        }
    }

    public PageBase openCatalogElementMenuItem(
        CatalogElementType catalogElementType) throws Exception 
    {
        switch (catalogElementType) {
            case ActivityIndicators:
                getCatalogElementMenuItem(catalogElementType).click();
                return new ActivityIndicatorsCatalogElementPage(appiumDriver);    
            default:
                throw new Exception("Not implemented" + catalogElementType);
        }    
    }
}
