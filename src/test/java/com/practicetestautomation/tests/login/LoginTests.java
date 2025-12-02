package com.practicetestautomation.tests.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests {
    @Test(groups = {"positive", "regression", "smoke"})
    public void testLoginFunctionality(){
        // Open page
        // Type username student into Username field
        // Type password Password123 into Password field
        // Push Submit button
        WebDriver driver = new FirefoxDriver();
        driver.get("https://practicetestautomation.com/practice-test-login/");
        WebElement usernameInput = driver.findElement(By.id("username"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement submitBtn = driver.findElement(By.id("submit"));
        usernameInput.sendKeys("student");
        passwordInput.sendKeys("Password123");
        submitBtn.click();

        // Verify new page URL contains practicetestautomation.com/logged-in-successfully/
        String expectedUrl = "https://practicetestautomation.com/logged-in-successfully/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl);

        // Verify new page contains expected text ('Congratulations' or 'successfully logged in')
        String expectedMessage = "Congratulations student. You successfully logged in!";
        String pageSource = driver.getPageSource();
        Assert.assertTrue(pageSource.contains(expectedMessage));

        // Verify button Log out is displayed on the new page
        WebElement logOutBtn = driver.findElement(By.linkText("Log out"));
        Assert.assertTrue(logOutBtn.isDisplayed());

        driver.quit();
    }

    @Test(groups = {"negative", "regression"})
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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("error")));
        Assert.assertTrue(errorMessage.isDisplayed());

        // Verify error message text is Your username is invalid!
        String expectedErrorMessage = "Your username is invalid!";
        String actualErrorMsg = errorMessage.getText();
        Assert.assertEquals(actualErrorMsg, expectedErrorMessage);

        driver.quit();
    }

    @Test(groups = {"negative", "regression"})
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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("error")));
        Assert.assertTrue(errorMessage.isDisplayed());

        // Verify error message text is Your password is invalid!
        String expectedErrorMsg = "Your password is invalid!";
        String actualErrorMsg = errorMessage.getText();
        Assert.assertEquals(actualErrorMsg, expectedErrorMsg);

        driver.quit();
    }
}
