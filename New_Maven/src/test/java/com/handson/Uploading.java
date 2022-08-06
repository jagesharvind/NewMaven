package com.handson;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.base.Base_Class;

public class Uploading extends Base_Class {
	
	public static WebDriver driver;
	
	@BeforeTest
	public void driverInit() {
	driver = Base_Class.webBrowser("chrome");
	}
	
	@Test
		public void uploadAFile() throws AWTException, InterruptedException {
			
		Robot robo = new Robot();
				
		webPage("http://www.google.co.in/imghp?hl=en&ogbl");
		WebElement search = driver.findElement(By.xpath("(//div[@role='button'])[2]"));
		clickOnElement(search);
		
		WebElement upload = driver.findElement(By.xpath("(//a[contains(text(),'Upload')])[1]"));
		upload.click();
	
		WebElement choose = driver.findElement(By.xpath("//input[@type='file']"));
		action.click(choose).build().perform();
		
		Thread.sleep(2000);
		String file = "G:\\Downloads\\0x0.jpg";
		StringSelection path =  new StringSelection(file);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(path, null);
		
		robo.keyPress(KeyEvent.VK_CONTROL);
		robo.keyPress(KeyEvent.VK_V);
		robo.keyRelease(KeyEvent.VK_V);
		robo.keyRelease(KeyEvent.VK_CONTROL);

		
		robo.keyPress(KeyEvent.VK_ENTER);
		robo.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
	}
	
	@AfterTest
		public void screenShotResult() throws IOException{
			screenCapture("corvette.jpg");
		}
	@AfterSuite
	public void closeBrowser() {
		quitBrowser();
	}
	
	}
	
	
	


