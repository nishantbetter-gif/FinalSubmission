package com.automation.v1.utilities;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;



public class DropDownActions {

	
	//@Test
	public static void GetOptions(WebElement DropDown) {
		Select sel=new Select(DropDown);
		List<WebElement> Options=sel.getOptions();
		for(WebElement el:Options) {
			System.out.println(el.getText());
		}
		
		
		
		
	}
	
	
}
