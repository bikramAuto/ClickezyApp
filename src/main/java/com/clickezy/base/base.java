package com.clickezy.base;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class base {
	WebDriver driver;
	WebDriverWait wait;
//	Integer City;
	protected By city = By.xpath("//p[@class='text-lg text-gray-900 truncate dark:text-white']");
	
	@Test(priority=1)
	protected void lunch() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		wait= new WebDriverWait(driver, (50));
		driver.get("https://clickezy-dev.netlify.app/");
		Thread.sleep(1000);
//		driver.quit();
		
	}
	
	@Test(priority=2)
	protected void SelectCity() throws Exception {
		wait= new WebDriverWait(driver, (50));
		List <WebElement> City = driver.findElements(city);
//		City = driver.findElement(city).getText();
//		City = wait.until(ExpectedConditions.visibilityOfElementLocated(city)).getSize();
		
		
		System.out.println("Citys: "+City.size());
		for(int i=1;i<=City.size();i++) {
			System.out.println(City.get(i));
		}
		
		
//		driver.quit();
	}
	
	protected void SignUp() {
		
		
	}
	
	protected void SignIn() {
		
		
	}

}
