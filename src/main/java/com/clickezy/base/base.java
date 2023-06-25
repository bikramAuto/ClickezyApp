package com.clickezy.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class base {
	WebDriver driver;
	WebDriverWait wait;
	protected By city = By.xpath("//li[@class='py-3 last:pb-0 sm:p-2 cursor-pointer hover:bg-slate-100 flex align-middle items-center rounded-md']");
	
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
	protected void SelectCity() {
		
	}
	
	protected void SignUp() {
		
		
	}
	
	protected void SignIn() {
		
		
	}

}
