package com.practicetestautomation.tests.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PositiveLoginTests {
    public void testLoginFunctionality(){
        // Open page
        // Type username student into Username field
        // Type password Password123 into Password field
        // Push Submit button
        // Verify new page URL contains practicetestautomation.com/logged-in-successfully/
        // Verify new page contains expected text ('Congratulations' or 'successfully logged in')
        // Verify button Log out is displayed on the new page
        WebDriver driver = new ChromeDriver();
        driver.get("https://practicetestautomation.com/practice-test-login/");
        WebElement usernameInput = driver.findElement(By.id("username"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement submitBtn = driver.findElement(By.id("submit"));
        usernameInput.sendKeys("student");
        passwordInput.sendKeys("Password123");
        submitBtn.click();
        driver.quit();
    }
}
