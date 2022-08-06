package com.handson;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.base.Base_Class;

public class SimplePageOpen extends Base_Class {

	public static WebDriver driver = Base_Class.webBrowser("chrome");
	
		public static void main(String[] args) throws IOException, AWTException, InterruptedException{
	
			webPage("http://www.leafground.com/pages/selectable.html");
			
			List<WebElement> list = driver.findElements(By.xpath("//ol[@id='selectable']/li"));
			action.keyDown(Keys.CONTROL).click(list.get(2)).build().perform();
			action.click(list.get(5)).build().perform();
			screenCapture("selectable.png");
			//quitBrowser();
	}
}
