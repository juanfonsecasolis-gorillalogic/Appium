package com.appium.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.appium.Pages.CatalogElementPage;
import com.appium.Pages.HomePage;
import com.appium.Pages.HomePage.CatalogElementType;

public class GestureTests extends TestBase
{
    @Test
    public void verifyHeadersOfWebViewPage() throws Exception
    {
        currentPage = ((HomePage) currentPage).openCatalogElementMenuItem(
                CatalogElementType.WebView);

        Assert.assertEquals(
            ((CatalogElementPage)currentPage).getHeader(),
            "Web View");
    }
}
