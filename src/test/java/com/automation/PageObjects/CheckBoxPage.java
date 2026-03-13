package com.automation.PageObjects;

import java.util.List;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckBoxPage {

    WebDriver driver;

    public CheckBoxPage(WebDriver webDriver) {
        this.driver = (WebDriver) webDriver;
        PageFactory.initElements((SearchContext) webDriver, this);
    }

    @FindBy(xpath="//input[@type='checkbox']")
    List<WebElement> checkBoxes;

    public List<WebElement> CheckBoxElements() {
        return checkBoxes;
    }
}