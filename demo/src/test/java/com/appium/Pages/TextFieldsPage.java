package com.appium.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

public class TextFieldsPage extends CatalogElementPage {
    
    By textFieldsLocator = AppiumBy.className("XCUIElementTypeTextField");
    
    public TextFieldsPage(AppiumDriver appiumDriver)
    {
        super(appiumDriver);
    }

    public void enterTextInAllFields(String inputText) {
        List<WebElement> inputTextElements = appiumDriver.findElements(
            textFieldsLocator
        );

        for(WebElement inputTextElement : inputTextElements)
        {
            inputTextElement.sendKeys(inputText);
        }
    }

    public List<String> getTextInAllTextFields() 
    {
        return appiumDriver
            .findElements(textFieldsLocator)
            .stream()
            .map(x -> x.getText())
            .toList();   
    }

}
