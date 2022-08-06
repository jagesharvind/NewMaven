package com.handson;

import java.io.File;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.base.Base_Class;

public class Downloading extends Base_Class{
	
	public static void main(String[] args) {
		
		File location = new File("G:\\Downloads");
		File[] totalfiles =location.listFiles();
		
		for (File file : totalfiles) {
			if (file.getName().equalsIgnoreCase("0x0.jpg")) {
				System.out.println("file downloaded");
			break;
			}
					
			else {
				System.out.println("file not downloaded");
			}	
	}
}
}
