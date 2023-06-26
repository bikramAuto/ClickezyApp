package com.clickezy.base;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

public class base {
	protected WebDriver driver;
	WebDriverWait wait;
	protected By city = By.xpath("//p[@class='text-lg text-gray-900 truncate dark:text-white']");
	protected By credential = By.xpath("//*[@id=\"__next\"]/main/div/header[1]/div/div[3]/a[3]");
	
	
	protected void lunch() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		wait= new WebDriverWait(driver, (50));
		driver.get("https://clickezy-dev.netlify.app/");
		Thread.sleep(1000);
		
	}
	
	
	protected void SelectCity() throws Exception {
		wait= new WebDriverWait(driver, (50));
		List <WebElement> City = driver.findElements(city);		
		System.out.println("Citys: "+City.size());
		for(int i=0;i<City.size();i++) {
			System.out.println(City.get(i).getText());
			String cty = City.get(i).getText();
			if(cty.equals("Bhubaneswar")) {
				driver.findElement(city).click();
				break;
			}	
		}		
	}
	
	
	protected void SignUp() throws InterruptedException {
		driver.findElement(credential).click();
		
		
		Thread.sleep(2000);
		driver.quit();
		
	}
	
	protected void SignIn() {
		
		
	}

}
