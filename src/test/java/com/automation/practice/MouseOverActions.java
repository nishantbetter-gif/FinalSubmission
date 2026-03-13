package com.automation.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseOverActions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
		
		WebElement ClickMe=driver.findElement(By.xpath("//button[@class='dropbtn']"));
	
		WebElement Laptop=driver.findElement(By.xpath("//a[text()='Laptops']"));
		
		Actions act=new Actions(driver);
		
		// build -- create
		
		// perform -- create and complete

		act.moveToElement(ClickMe).moveToElement(Laptop).build().perform();
		
		//driver.quit();
	}

}
