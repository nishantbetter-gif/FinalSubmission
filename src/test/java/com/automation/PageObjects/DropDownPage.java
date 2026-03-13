package com.automation.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DropDownPage extends HomePage {

    public DropDownPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath="//select[@id='dropdown']")
    private WebElement dropDown;

    public WebElement getDropDownElement() {
        return dropDown;
    }
}