package com.automation.v1.utilities;

import java.util.*;

import org.openqa.selenium.WebElement;

public class CheckBoxActionDriver {

	public static void CheckBoxElement(List<WebElement> Elements) throws InterruptedException {
		System.out.println(Elements.size());
		for(WebElement el:Elements) {
			ClickElement(el);
		}
		
	}
	
	public static void ClickElement(WebElement el) throws InterruptedException {
		 
			el.click();
			Thread.sleep(3000);
		
		
	}
	
}
