package com.automation.v1.testscript;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.automation.PageObjects.CheckBoxPage;
import com.automation.PageObjects.HomePage;
import com.automation.v1.BaseClass.BaseClass;
import com.automation.v1.utilities.CheckBoxActionDriver;
import com.automation.v1.utilities.ScreenShotUtils;

public class CheckBoxTest extends BaseClass {

    @Test(description="CheckBox", groups={"Master","Sanity","Regression"})
    public void testCheckBox() throws InterruptedException {

        HomePage homePage = new HomePage(getDriver());
        homePage.CheckBoxLinkClick();

        CheckBoxPage checkBoxPage = new CheckBoxPage(getDriver());

        List<WebElement> checkBoxes = checkBoxPage.CheckBoxElements();

        CheckBoxActionDriver.CheckBoxElement(checkBoxes);

        ScreenShotUtils.ClickPicture(getDriver(), this.getClass().getSimpleName());
    }
}