package com.appium.Helpers;

import java.util.Map;
import java.util.HashMap;
import org.openqa.selenium.remote.RemoteWebElement;
import io.appium.java_client.AppiumDriver;

public class GesturesManager 
{
    AppiumDriver appiumDriver;
    
    public GesturesManager(AppiumDriver appiumDriver)
    {
        this.appiumDriver = appiumDriver;
    }

    public void scroll()
    {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("direction", "down");
        //params.put("velocity", "2500");
        //params.put("element", ((RemoteWebElement) element).getId());
        appiumDriver.executeScript("mobile: scroll", params);
    }
}
