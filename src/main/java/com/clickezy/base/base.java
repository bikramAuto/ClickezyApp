package com.clickezy.base;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.clickezy.base.data.Data;

import io.github.bonigarcia.wdm.WebDriverManager;

public class base extends Data {
	protected WebDriver driver;
	protected WebDriverWait wait;
	protected By city = By.xpath("//p[@class='text-lg text-gray-900 truncate dark:text-white']");
	protected By credential = By.xpath("//*[@id=\"__next\"]/main/div/header[1]/div/div[3]/a[3]");
	protected By createAc = By.xpath("//a[@class='flex-grow-0 flex-shrink-0 text-base font-medium text-center text-white']");
	protected By newMail = By.xpath("//input[@name='email_number']");
	protected By checkbox = By.xpath("//input[@type='checkbox']");
	protected By resend = By.xpath("//button[text()='resend']");
	protected By sup = By.xpath("//button[text()='Signup']");
	
	protected void MailSAC() throws InterruptedException {
		WebDriver drive;
		String otp;
		WebDriverManager.chromedriver().setup();
		drive= new ChromeDriver();
		drive.get("https://mailsac.com/");
		drive.findElement(By.xpath
				("//input[@ng-model='myinbox']")).sendKeys(NewID);
		drive.findElement(By.xpath
				("//button[@ng-click='navToInbox(myinbox, postfix)']")).click();
		drive.findElement(By.xpath
				("/html/body/div/div[3]/div[1]/div/div[2]/div/table/tbody/tr[2]"))
						.click();
		try {
			otp = drive.findElement(By.xpath
					("//div[@ng-if='msg.body']")).getText();
			otp = otp.replaceAll("[^0-9]", "");
			otp = StringUtils.left(otp, 6);
			System.out.println("the otp is: "+otp);
			drive.quit();
		}catch(Exception e) {		
			for(int i=0; i<25; i++) {
				if(i==6 || i==12) {
					driver.findElement(resend).click();
				}
				if (i<20) {
					drive.navigate().back();
					drive.navigate().refresh();
				}else if(i>=20) {
					Thread.sleep(1000);
					drive.navigate().refresh();
				}				
				Thread.sleep(1000);
				drive.findElement(By.xpath
						("//input[@ng-model='myinbox']")).sendKeys(NewID);
				drive.findElement(By.xpath
						("//button[@ng-click='navToInbox(myinbox, postfix)']")).click();
				drive.findElement(By.xpath
						("/html/body/div/div[3]/div[1]/div/div[2]/div/table/tbody/tr[2]"))
							.click();
				Thread.sleep(1000);
				try {
					Boolean element = drive.findElement(By.xpath
							("//div[@ng-if='msg.body']")).isDisplayed();
					System.out.println("elements: "+element);
					if(element.equals(true)) {
						otp = drive.findElement(By.xpath
								("//div[@ng-if='msg.body']")).getText();
						otp = otp.replaceAll("[^0-9]", "");
						otp = StringUtils.left(otp, 6);
						System.out.println("the otp is: "+otp);
						driver.quit();
						break;
					}				
				}catch(Exception o) {
					System.out.println("please wait not complited");
				}
			}
		}
	}
	
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
	
	
	
	protected void SignIn() {
		
		
	}

}
