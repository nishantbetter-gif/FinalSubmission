package com.automation.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//a[text()='Add/Remove Elements']")
    WebElement AddRemoveLink;

    public void AddRemoveClick() {
        AddRemoveLink.click();
    }

    @FindBy(xpath="//a[text()='Basic Auth']")
    WebElement BasicAuthLink;

    public String BasicAuthClick() {
        return BasicAuthLink.getAttribute("href");
    }

    @FindBy(xpath="//a[@href='/add_remove_elements/']")
    WebElement AddElementLink;

    public void AddElementLinkClick() {
        AddElementLink.click();
    }

    @FindBy(xpath="//a[@href='/dropdown']")
    WebElement DropDownLink;

    public void DropDownClick() {
        DropDownLink.click();
    }

    @FindBy(xpath="//a[@href='/checkboxes']")
    WebElement CheckBoxLink;

    public void CheckBoxLinkClick() {
        CheckBoxLink.click();
    }

    @FindBy(xpath="//a[@href='/drag_and_drop']")
    WebElement DragAndDropLink;

    public void DragAndDropLinkClick() {
        DragAndDropLink.click();
    }
}