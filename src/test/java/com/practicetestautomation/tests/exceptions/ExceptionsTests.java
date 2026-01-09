package com.practicetestautomation.tests.exceptions;

import com.practicetestautomation.pageobjects.BasePage;
import com.practicetestautomation.pageobjects.ExceptionsPage;
import com.practicetestautomation.tests.BaseTest;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ExceptionsTests extends BaseTest {

    @Test
    public void noSuchElementExceptionTest() {
        ExceptionsPage exceptionsPage = new ExceptionsPage(driver);
        exceptionsPage.visit();
        exceptionsPage.clickAddButton();
        Assert.assertTrue(exceptionsPage.isRowTwoDisplayedAfterWait(), "Row 2 input field is not displayed");
    }

    @Test
    public void timeoutExceptionTest() {
        ExceptionsPage exceptionsPage = new ExceptionsPage(driver);
        exceptionsPage.visit();
        exceptionsPage.clickAddButton();
        Assert.assertTrue(exceptionsPage.isRowTwoDisplayedAfterWait(), "Row 2 input field is not displayed");
    }

    @Test
    public void elementNotInteractableExceptionTest(){
        ExceptionsPage exceptionsPage = new ExceptionsPage(driver);
        exceptionsPage.visit();
        exceptionsPage.clickAddButton();
        exceptionsPage.isRowTwoDisplayedAfterWait();
        exceptionsPage.enterTextRow2("test text");
        exceptionsPage.saveRow2();
        Assert.assertEquals(exceptionsPage.getSuccessMsg(), "Row 2 was saved", "Message is not expected");
    }

    @Test
    public void invalidElementStateExceptionTest(){
        ExceptionsPage exceptionsPage = new ExceptionsPage(driver);
        exceptionsPage.visit();
        exceptionsPage.clickEditButton();
        exceptionsPage.enterTextRow1("test text");
        exceptionsPage.saveRow1();
        Assert.assertEquals(exceptionsPage.getSuccessMsg(), "Row 1 was saved", "Message is not expected");
    }

    @Test
    public void staleElementReferenceExceptionTest(){
        ExceptionsPage exceptionsPage = new ExceptionsPage(driver);
        exceptionsPage.visit();
        exceptionsPage.clickAddButton();
        // Verify instruction text element is no longer displayed
        Assert.assertTrue(exceptionsPage.isInstructionsElementHiddenAfterWait(), "Instructions text is still displayed");
    }
}
