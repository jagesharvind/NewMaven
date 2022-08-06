package com.base;


import java.io.File;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

public class Base_Class  {
	public static WebDriver driver;
	public static Actions action;
	public static JavascriptExecutor javex;
	public static TakesScreenshot screenshot;
	
	
	
	public static WebDriver webBrowser(String browser )  {
		if (browser.equalsIgnoreCase("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\chromedriver.exe");
			ChromeOptions option = new ChromeOptions();
			option.addArguments("incognito");
			driver = new ChromeDriver(option);
			driver.manage().window().maximize();
			
			action = new Actions(driver);
			javex = (JavascriptExecutor) driver; // narrowing type casting
			screenshot = (TakesScreenshot)driver;
			
		}
		else {
			
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\chromedriver.exe");
			ChromeOptions option = new ChromeOptions();
			option.setBinary("\\C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe\\");
			option.addArguments("incognito");
			driver = new ChromeDriver(option);
			driver.manage().window().maximize();
			
			action = new Actions(driver);
			javex = (JavascriptExecutor) driver; // narrowing type casting
			screenshot = (TakesScreenshot)driver;
		}
		return driver;
	}

	public static String webPage(String webAddress) {
		driver.get(webAddress);
		return webAddress;
	}
	
	public static void pageTitle(String title) {
		driver.getTitle();
	}
	
	public static void quitBrowser() {
		driver.quit();
	}
	
	public static void navigateTo(String url) {
		driver.navigate().to(url);
	}
	
	public static void navigateForward() {
		driver.navigate().forward();
	}
	
	public static void navigateBackward() {
		driver.navigate().back();
	}
	
	public static void pageRefresh() {
		driver.navigate().refresh();
	}
	
	public static WebElement clickOnElement(WebElement element) {			//custom click method
		element.click();
		return element;
	}

	public static void inputSendKeys(WebElement element, String value) {		//custom sendKey method
		element.sendKeys(value);
	}

	public static void clearText(WebElement element) {
		element.clear();
	}
	
	public static void toolTip(WebElement element) {
		 String tooltip = element.getAttribute("title");
		 System.out.println(tooltip);
	}
	public static void mouseMove(WebElement element) {			// custom mouse move to element method
	action.moveToElement(element).build().perform();
	}
	
	public static void mouseClick(WebElement element) {			//custom mouse click
		action.moveToElement(element).click().build().perform();
	}
	
	public static void scrollToElement(WebElement element, WebDriver driver) {  		//custom scroll to element
	javex.executeScript("arguments[0].scrollIntoView(true)",element);
		}
	
	public static void screenCapture(String screenshotName) throws IOException {
		File get = screenshot.getScreenshotAs(OutputType.FILE);
		File save = new File("G:\\Downloads\\"+screenshotName);
		FileHandler.copy(get, save);
	}
	
	
}
