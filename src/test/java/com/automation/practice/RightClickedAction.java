package com.automation.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class RightClickedAction {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://the-internet.herokuapp.com");
		driver.findElement(By.xpath("//a[@href='/context_menu']")).click();
		
		WebElement ContextMenu=driver.findElement(By.xpath("//div[@id='hot-spot']"));
		
		Actions act=new Actions(driver);
		
		act.contextClick(ContextMenu).build().perform();
		
		Thread.sleep(3000);
		
		driver.switchTo().alert().accept();

	}

}
