package com.practicetestautomation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SuccessfulLoginPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private By logOutBtnLocator = By.linkText("Log out");

    public SuccessfulLoginPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }

    public String getPageSource(){
        return getPageSource();
    }

    public boolean isLogOutBtnDisplayed(){
        try {
            return driver.findElement(logOutBtnLocator).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }

    }
}
