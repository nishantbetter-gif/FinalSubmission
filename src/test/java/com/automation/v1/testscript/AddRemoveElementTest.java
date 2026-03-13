package com.automation.v1.testscript;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.automation.PageObjects.AddRemovePage;
import com.automation.PageObjects.HomePage;
import com.automation.v1.BaseClass.BaseClass;
import com.automation.v1.utilities.ScreenShotUtils;

public class AddRemoveElementTest extends BaseClass {

    @Test(description = "Add Remove Elements", groups = {"Master","Regression"})
    public void testAddRemoveElements() {

        HomePage homePage = new HomePage(getDriver());
        homePage.AddElementLinkClick();

        AddRemovePage addRemovePage = new AddRemovePage(getDriver());
        addRemovePage.AddElementLinkClick();
        addRemovePage.DeleteButtonClick();

        ScreenShotUtils.ClickPicture(getDriver(), this.getClass().getSimpleName());
    }
}