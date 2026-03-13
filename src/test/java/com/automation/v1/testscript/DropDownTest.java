package com.automation.v1.testscript;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.automation.PageObjects.DropDownPage;
import com.automation.PageObjects.HomePage;
import com.automation.v1.BaseClass.BaseClass;
import com.automation.v1.utilities.DropDownActions;
import com.automation.v1.utilities.ScreenShotUtils;

public class DropDownTest extends BaseClass {

    @Test(description="DropDown Test", groups={"Master","Sanity","Regression"})
    public void testDropDown() {

        HomePage homePage = new HomePage(getDriver());
        homePage.DropDownClick();

        DropDownPage dropDownPage = new DropDownPage(getDriver());
        WebElement dropDownElement = dropDownPage.getDropDownElement();

        DropDownActions.GetOptions(dropDownElement);

        ScreenShotUtils.ClickPicture(getDriver(), this.getClass().getSimpleName());
    }
}