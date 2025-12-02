package com.practicetestautomation.tests.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTests {
    @Test
    public void incorrectUsernameTest(){
        // Open page
        // Type username incorrectUser into Username field
        // Type password Password123 into Password field
        // Push Submit button
        WebDriver driver = new ChromeDriver();
        driver.get("https://practicetestautomation.com/practice-test-login/");
        WebElement usernameInput = driver.findElement(By.id("username"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement submitBtn = driver.findElement(By.id("submit"));
        usernameInput.sendKeys("incorrectUser");
        passwordInput.sendKeys("Password123");
        submitBtn.click();

        // Verify error message is displayed
        WebElement errorMessage = driver.findElement(By.id("error"));
        Assert.assertTrue(errorMessage.isDisplayed());

        // Verify error message text is Your username is invalid!
        String expectedErrorMessage = "Your username is invalid!";
        String actualErrorMsg = errorMessage.getText();
        Assert.assertEquals(actualErrorMsg, expectedErrorMessage);

        driver.quit();
    }

    @Test
    public void incorrectPasswordTest(){
        // Open page
        WebDriver driver = new ChromeDriver();
        driver.get("https://practicetestautomation.com/practice-test-login/");

        // Type username student into Username field
        // Type password incorrectPassword into Password field
        // Push Submit button
        WebElement usernameInput = driver.findElement(By.id("username"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement submitBtn = driver.findElement(By.id("submit"));
        usernameInput.sendKeys("student");
        passwordInput.sendKeys("incorrectPassword");
        submitBtn.click();

        // Verify error message is displayed
        WebElement errorMessage = driver.findElement(By.id("error"));
        Assert.assertTrue(errorMessage.isDisplayed());

        // Verify error message text is Your password is invalid!
        String expectedErrorMsg = "Your password is invalid!";
        String actualErrorMsg = errorMessage.getText();
        Assert.assertEquals(actualErrorMsg, expectedErrorMsg);

        driver.quit();
    }
}
