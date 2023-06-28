package com.clickezy.base.devices;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.clickezy.base.data.Data;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Devices extends Data {
	
	protected WebDriver driver;
	protected WebDriverWait wait;
	
	protected void lunch() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		wait= new WebDriverWait(driver, (50));
		driver.get("https://clickezy-dev.netlify.app/");
		Thread.sleep(1000);
		
	}
	
}
