package com.automation.v1.testscript;

import java.io.IOException;
import org.testng.annotations.Test;

import com.automation.v1.BaseClass.BaseClass;
import com.automation.v1.utilities.BrokenLinkVerification;
import com.automation.v1.utilities.ScreenShotUtils;

public class TestScript extends BaseClass {

    @Test
    public void testBrokenLinks() throws IOException {

        boolean result = BrokenLinkVerification
                .LinkVerification("https://the-internet.herokuapp.com/");

        System.out.println(result);

        ScreenShotUtils.ClickPicture(getDriver(), this.getClass().getSimpleName());
    }
}