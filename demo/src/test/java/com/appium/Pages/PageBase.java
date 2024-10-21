package com.appium.Pages;

import com.appium.Helpers.GesturesManager;
import io.appium.java_client.AppiumDriver;

public class PageBase 
{
    protected AppiumDriver appiumDriver;
    protected GesturesManager gesturesManager;

    public PageBase(AppiumDriver appiumDriver)
    {
        this.appiumDriver = appiumDriver;
        gesturesManager = new GesturesManager(appiumDriver);
    }
}
