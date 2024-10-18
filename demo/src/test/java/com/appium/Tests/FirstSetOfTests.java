package com.appium.Tests;

import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.appium.Pages.CatalogElementPage;
import com.appium.Pages.HomePage;
import com.appium.Pages.TextFieldsPage;
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

        Assert.assertEquals(
            ((HomePage) currentPage).getCatalogElementMenuItem(
                CatalogElementType.Buttons).getText(),
            "Buttons");
    }
    
    @Test
    public void verifyHeadersOfActivityIndicatorPage() throws Exception
    {
        currentPage = ((HomePage) currentPage).openCatalogElementMenuItem(
                CatalogElementType.ActivityIndicators);

        Assert.assertEquals(
            ((CatalogElementPage)currentPage).getHeader(),
            "Activity Indicators");
    }

    @Test
    public void verifyTextFieldsPage() throws Exception
    {
        // arrange
        currentPage = ((HomePage) currentPage).openCatalogElementMenuItem(
                CatalogElementType.TextFields);

        TextFieldsPage textFieldsPage = (TextFieldsPage) currentPage;
        String expectedText = "Testing 123...";
        
        // act
        textFieldsPage.enterTextInAllFields(expectedText);
        List<String> currentTextFieldsText = textFieldsPage.getTextInAllTextFields();

        // asssert
        Assert.assertEquals(
            currentTextFieldsText.size(),
            currentTextFieldsText
                .stream()
                .map(x -> x.equals(expectedText))
                .count(),
                "Not all text fields contain the string " + expectedText
        );
    }
}
