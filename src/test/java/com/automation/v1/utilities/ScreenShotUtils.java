package com.automation.v1.utilities;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ScreenShotUtils {
	
	private static TakesScreenshot ts;
	
	public static void ClickPicture(WebDriver webDriver,String name) {
		
		ts=(TakesScreenshot)webDriver;
		
		File src=ts.getScreenshotAs(OutputType.FILE);
		
		File trg=new File("C:\\Users\\Ashish\\eclipse-workspace\\Java\\com.automation.v1\\Screenshot\\"+name+".png");
		src.renameTo(trg);
		
	}



}

//ScreenShotUtils.ClickPicture(driver);