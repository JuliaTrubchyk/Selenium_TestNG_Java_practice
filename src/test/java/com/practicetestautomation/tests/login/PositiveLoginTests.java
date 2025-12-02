package com.practicetestautomation.tests.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveLoginTests {
    @Test
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
}
