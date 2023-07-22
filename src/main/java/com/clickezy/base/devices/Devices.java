package com.clickezy.base.devices;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;

import com.clickezy.base.data.Data;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Devices extends Data {
	
	protected WebDriver driver;
	protected WebDriverWait wait;
	
	@BeforeTest
	protected void lunch() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		Map<String, Object> prefs = new HashMap<String, Object>();
		//Pass the argument 1 to allow and 2 to block
		prefs.put("profile.default_content_setting_values.notifications", 1);
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);		
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		wait= new WebDriverWait(driver, (50));
		
//		Thread.sleep(1000);
		
	}
	
}
