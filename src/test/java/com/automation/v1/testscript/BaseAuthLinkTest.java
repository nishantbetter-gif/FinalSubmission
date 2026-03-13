package com.automation.v1.testscript;
import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import com.automation.PageObjects.HomePage;
import com.automation.v1.BaseClass.BaseClass;
import com.automation.v1.utilities.ScreenShotUtils;
public class BaseAuthLinkTest {
	
	@Test(description="auth Verification",groups={"Master,Sanity,Regression"})
	public void Test(){
		WebDriver driver =new ChromeDriver();
		WebDriverWait mywait=new WebDriverWait(driver,Duration.ofSeconds(10));
		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
		
		WebElement text=mywait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[contains(text(),'Congratulations! You must have the proper credentials.')]")));
		
		Assert.assertTrue(text.isDisplayed());
		
		//ScreenShotUtils.ClickPicture(driver,this.getClass().getSimpleName());
		
		driver.quit();
	}

}
