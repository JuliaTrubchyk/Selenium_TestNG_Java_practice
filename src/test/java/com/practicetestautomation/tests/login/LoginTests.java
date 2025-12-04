package com.practicetestautomation.tests.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import java.time.Duration;

public class LoginTests {
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    @Parameters("browser")
    public void setUp(@Optional("chrome") String browser){
        System.out.println("Running test in " + browser);
        switch (browser.toLowerCase()){
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            default:
                System.out.println("configuration for " + browser + " is missing so running tests in Chrome by defauld");
                driver = new ChromeDriver();
                break;
        }
        // Open page
        driver = new ChromeDriver();
        driver.get("https://practicetestautomation.com/practice-test-login/");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }

    @Test(groups = {"positive", "regression", "smoke"})
    public void testLoginFunctionality(){
        // Type username student into Username field
        // Type password Password123 into Password field
        // Push Submit button
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
    }

    @Parameters({"username", "password", "expectedErrorMessage"})
    @Test(groups = {"negative", "regression"})
    public void negativeLoginTest(String username, String password, String expectedErrorMessage){
        // Type username incorrectUser into Username field
        // Type password Password123 into Password field
        // Push Submit button
        WebElement usernameInput = driver.findElement(By.id("username"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement submitBtn = driver.findElement(By.id("submit"));
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        submitBtn.click();

        // Verify error message is displayed
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("error")));
        Assert.assertTrue(errorMessage.isDisplayed());

        // Verify error message text is Your username is invalid!
        String actualErrorMsg = errorMessage.getText();
        Assert.assertEquals(actualErrorMsg, expectedErrorMessage);
    }
}
