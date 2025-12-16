package com.practicetestautomation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SuccessfulLoginPage extends BasePage{
    private By logOutBtnLocator = By.linkText("Log out");

    public SuccessfulLoginPage(WebDriver driver){
        super(driver);
    }

    public boolean isLogOutBtnDisplayed(){
        return isDisplayed(logOutBtnLocator);
    }
}
