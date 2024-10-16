package com.appium.Pages;

import io.appium.java_client.AppiumDriver;

public class PageBase 
{
    protected AppiumDriver appiumDriver;

    public PageBase(AppiumDriver appiumDriver)
    {
        this.appiumDriver = appiumDriver;
    }
}
