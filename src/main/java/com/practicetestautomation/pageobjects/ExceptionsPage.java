package com.practicetestautomation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ExceptionsPage extends BasePage{
    private By addBtnLocator = By.id("add_btn");
    private By editBtnLocator = By.id("edit_btn");
    private By row1SaveButton = By.xpath("//div[@id='row1']/button[@name='Save']");
    private By row2SaveButton = By.xpath("//div[@id='row2']/button[@name='Save']");
    private By row1InputField = By.xpath("//div[@id='row1']/input");
    private By row2InputField = By.xpath("//div[@id='row2']/input");
    private By successMsg = By.id("confirmation");
    private By instructionsTxt = By.id("instructions");

    public ExceptionsPage(WebDriver driver){
        super(driver);
    }

    public void visit(){
        super.visit("https://practicetestautomation.com/practice-test-exceptions/");
    }

    public void clickAddButton(){
        driver.findElement(addBtnLocator).click();
    }

    public void clickEditButton(){
        driver.findElement(editBtnLocator).click();
    }

    public void saveRow1(){
        driver.findElement(row1SaveButton).click();
    }

    public void saveRow2(){
        driver.findElement(row2SaveButton).click();
    }

    public void enterTextRow1(String txt){
        WebElement row1field = driver.findElement(row1InputField);
        row1field.clear();
        row1field.sendKeys(txt);
    }

    public void enterTextRow2(String txt){
        driver.findElement(row2InputField).sendKeys(txt);
    }

    public boolean isRowTwoDisplayedAfterWait(){
        return waitForIsDisplayed(row2InputField);
    }

    public String getSuccessMsg(){
        WebElement message = waitForElement(successMsg);
        return message.getText();
    }

    public boolean isInstructionsElementHiddenAfterWait(){
        return waitForIsHidden(instructionsTxt);
    }
}
