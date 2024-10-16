package com.appium;

import org.openqa.selenium.WebElement;
import io.appium.java_client.AppiumBy;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Tests extends TestBase{

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
