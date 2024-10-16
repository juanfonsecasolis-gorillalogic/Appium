package com.appium.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.appium.Pages.CatalogElementPage;
import com.appium.Pages.HomePage;
import com.appium.Pages.HomePage.CatalogElementType;

public class FirstSetOfTests extends TestBase
{
    @Test
    public void verifySystemDisplaysMenuItems() throws Exception
    {
        Assert.assertEquals(
            ((HomePage) currentPage).getCatalogElementMenuItem(
                CatalogElementType.ActivityIndicators).getText(),
            "Activity Indicators");

        Assert.assertEquals(
            ((HomePage) currentPage).getCatalogElementMenuItem(
                CatalogElementType.AlertViews).getText(),
            "Alert Views");
    }
    
    @Test
    public void verifySystemOpensActivityIndicatorsPage() throws Exception
    {
        currentPage = ((HomePage) currentPage).openCatalogElementMenuItem(
                CatalogElementType.ActivityIndicators);

        Assert.assertEquals(
            ((CatalogElementPage)currentPage).getHeader(),
            "Activity Indicators");
    }
}
