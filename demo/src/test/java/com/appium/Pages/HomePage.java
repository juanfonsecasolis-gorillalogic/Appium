package com.appium.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class HomePage extends PageBase 
{
    public enum CatalogElementType
    {
        ActivityIndicators, 
        AlertViews, 
        Buttons, TextFields, WebView
    }

    @FindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Buttons\"]")
    WebElement buttonsMenuElement;

    @iOSXCUITFindBy(accessibility = "Activity Indicators")
    WebElement activityIndicator;

    public HomePage(AppiumDriver appiumDriver)
    {
        super(appiumDriver);
        PageFactory.initElements(
            new AppiumFieldDecorator(appiumDriver), 
            this);
    }

    public WebElement getCatalogElementMenuItem(
        CatalogElementType catalogElementType) throws Exception
    {
        switch (catalogElementType) {
            case ActivityIndicators:
                return activityIndicator;   // accessibility ID
            case AlertViews:
                // iOS Predicate
                return appiumDriver.findElement(
                    AppiumBy.iOSNsPredicateString(
                        "name == \"Alert Views\""
                ));
            case Buttons:
                return buttonsMenuElement;  // xpath
            case TextFields:
                return appiumDriver.findElement(AppiumBy.accessibilityId("Text Fields"));
            case WebView:
                return appiumDriver.findElement(AppiumBy.accessibilityId("Web View"));
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
                return new ActivityIndicatorsPage(appiumDriver);    
            case TextFields:
                getCatalogElementMenuItem(catalogElementType).click();
                return new TextFieldsPage(appiumDriver);
            case WebView:
                gesturesManager.scroll();
                getCatalogElementMenuItem(catalogElementType).click();
                return new WebViewPage(appiumDriver);
            default:
                throw new Exception("Not implemented" + catalogElementType);
        }    
    }
}
