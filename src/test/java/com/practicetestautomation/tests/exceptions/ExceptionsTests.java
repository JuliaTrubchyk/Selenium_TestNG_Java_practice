package com.practicetestautomation.tests.exceptions;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ExceptionsTests {
    private WebDriver driver;
    private Logger logger;

    @BeforeMethod(alwaysRun = true)
    @Parameters("browser")
    public void setUp(@Optional("chrome") String browser){
        logger = Logger.getLogger(ExceptionsTests.class.getName());
        logger.setLevel(Level.INFO);
        logger.info("Running test in " + browser);
        switch (browser.toLowerCase()){
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            default:
                logger.warning("configuration for " + browser + " is missing so running tests in Chrome by defauld");
                driver = new ChromeDriver();
                break;
        }

        // tells Selenium to wait up to 10 seconds for an element to appear before throwing timing Exceptions
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

        // Open page
        driver.get("https://practicetestautomation.com/practice-test-exceptions/");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        driver.quit();
        logger.info("Browser is closed");
    }

    @Test
    public void noSuchElementExceptionTest() {
        // Click Add button
        WebElement addButton = driver.findElement(By.id("add_btn"));
        addButton.click();
        // Verify Row 2 input field is displayed

        WebElement row2InputField = driver.findElement(By.xpath("//div[@id='row2']/input"));
        Assert.assertTrue(row2InputField.isDisplayed(), "Row 2 input field is not displayed");
    }

}
