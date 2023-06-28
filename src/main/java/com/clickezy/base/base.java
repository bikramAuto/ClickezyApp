package com.clickezy.base;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.clickezy.base.devices.Devices;

import io.github.bonigarcia.wdm.WebDriverManager;

public class base extends Devices {
	
	protected By city = By.xpath("//p[@class='text-lg text-gray-900 truncate dark:text-white']");
	protected By credential = By.xpath("//*[@id=\"__next\"]/main/div/header[1]/div/div[3]/a[3]");
	protected By createAc = By.xpath("//a[@class='flex-grow-0 flex-shrink-0 text-base font-medium text-center text-white']");
	protected By newMail = By.xpath("//input[@name='email_number']");
	protected By checkbox = By.xpath("//input[@type='checkbox']");
	protected By resend = By.xpath("//button[text()='resend']");
	protected By sup = By.xpath("//button[@type='submit']");
	protected By Sotp = By.xpath("//input[@name='otp']");
	protected By Osubmit = By.xpath("//button[text()='Confirm']");
	protected By mobile = By.xpath("//input[@name='mobile']");
	protected By name = By.xpath("//input[@name='name']");
	protected By dob = By.xpath("//input[@name='dob']");
	protected By gender = By.xpath("//select[@name='gender']");
	protected By address = By.xpath("//input[@name='address[0].address']");
	protected By landmark = By.xpath("//input[@name='address[0].landmark']");
	protected By citi = By.xpath("//input[@name='address[0].city']");
	protected By pin = By.xpath("//input[@name='address[0].zip']");
	protected By verify = By.xpath("//button[text()='click here to verify ']");
	protected By cnfm = By.xpath("//button[@type='submit']");
	protected By login = By.xpath("//button[text()='Login']");
	
	
	@Test
	protected void SignIn() throws Exception {
		lunch();
		SelectCity();
		driver.findElement(credential).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(newMail)
				).sendKeys(Lmail);
		wait.until(ExpectedConditions.visibilityOfElementLocated(login)).click();
		Sotp();
		Thread.sleep(100);
		wait.until(ExpectedConditions.visibilityOfElementLocated(Osubmit)).click();
	}
	
	protected void SignupInformation() throws Exception {
		wait.until(ExpectedConditions.visibilityOfElementLocated(mobile)).sendKeys(mob);
		wait.until(ExpectedConditions.visibilityOfElementLocated(verify)).click();		
		Sotp();
		Thread.sleep(100);
		wait.until(ExpectedConditions.visibilityOfElementLocated(Osubmit)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(name)).sendKeys(Name);
		wait.until(ExpectedConditions.visibilityOfElementLocated(dob)).sendKeys("10101999");
		Select drpCountry = new Select(driver.findElement(gender));
		drpCountry.selectByVisibleText("Male");
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,500)");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(address)).sendKeys(add);
		wait.until(ExpectedConditions.visibilityOfElementLocated(landmark)).sendKeys(lmark);
		wait.until(ExpectedConditions.visibilityOfElementLocated(citi)).sendKeys(City);
		wait.until(ExpectedConditions.visibilityOfElementLocated(pin)).sendKeys(zip);
	}
	
	protected void Sotp() throws Exception {		
		char[] otp = Otp.toCharArray();
		System.out.println("inside sOtp");
		for (int i = 0; i < otp.length; i++) {
			int a = i+1;
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("(//input[@name='otp'])["+ a +"]")))
                    .sendKeys(otp[i] + "");           
        	}		
	}
	
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
	
	
	
	
	protected void SelectCity() throws Exception {
		wait= new WebDriverWait(driver, (50));
		List <WebElement> City = driver.findElements(city);
//		List <WebElement> City = wait.until(ExpectedConditions.visibilityOfElementLocated(city));
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
	
	
	

}
