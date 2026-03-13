package com.automation.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddRemovePage extends HomePage {

    public AddRemovePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath="//button[@onclick='addElement()']")
    private WebElement addElementButton;

    public void clickAddElementButton() {
        addElementButton.click();
    }

    @FindBy(xpath="//button[@class='added-manually']")
    private WebElement deleteButton;

    public void clickDeleteButton() {
        deleteButton.click();
    }

	public void DeleteButtonClick() {
		// TODO Auto-generated method stub
		
	}
}