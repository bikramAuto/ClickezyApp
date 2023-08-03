package com.clickezy.base;

import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.clickezy.base.devices.Devices;

import io.github.bonigarcia.wdm.WebDriverManager;

public class base extends Devices {
	
	String title;
	String actualTitle;
		
	protected By city = By.xpath("//p[@class='text-lg md:text-base text-gray-800 truncate dark:text-white']");
	protected By credential = By.xpath("//*[@id=\"__next\"]/main/div/header[1]/div/div[3]/a[3]");
	protected By createAc = By.xpath("//a[text()='Create account']");
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
	protected By login = By.xpath("//button[text()='Login']");//button[text()='Login']
	protected By sOtpTitle = By.xpath("//p[@class='flex-grow-0 flex-shrink-0 text-lg text-center text-white']");
	protected By BookNow1 = By.xpath("(//a[text()='Book Now'])[1]");
	protected By BookNow2 = By.xpath("(//a[text()='Book Now'])[3]");
	protected By BookNow3 = By.xpath("(//a[text()='Book Now'])[4]");
	protected By BookNow4 = By.xpath("(//a[text()='Book Now'])[5]");
	protected By Bookstudio = By.xpath("(//button[@class='formInput w-full flex justify-between false'])[3]");
	protected By Bookfor = By.xpath("(//button[@class='formInput w-full flex justify-between false'])[1]");
	protected By BookForCategory = By.xpath("//p[@class='flex-grow-0 flex-shrink-0 text-xs font-medium text-center text-white']");
	protected By framebook = By.xpath("//li[@class='cursor-default flex flex-col justify-center items-center flex-grow-0 flex-shrink-0 relative gap-3 text-white']");
	protected By bookingSearch = By.xpath("//input[@class='formInput w-full']");
	protected By studio = By.xpath("//li[@class='relative cursor-default select-none py-4 pl-5 pr-3 flex justify-start items-center flex-grow-0 flex-shrink-0 self-stretch border-b border-[#ffffff10] last:border-0 text-white']");
	protected By bookingTime = By.xpath("//div[@class=' css-svn9ad-control']");
	protected By bookingDay = By.xpath("//div[text()='Day']");
	protected By bookingHour = By.xpath("//div[text()='Hourly']");
	protected By selectDate = By.xpath("//input[@placeholder='Select date']");
	protected By date = By.xpath("//div[text()='20']");
	protected By selectTime = By.xpath("//input[@placeholder='Select time']");
	protected By Hrs = By.xpath("(//div[text()='"+ h +"'])[1]");
	protected By min = By.xpath("(//div[text()='"+ m +"'])[2]");
	protected By tOk = By.xpath("//span[text()='OK']");
	protected By minFream = By.xpath("(//ul[@class='ant-picker-time-panel-column'])[2]");
	protected By next = By.xpath("//button[text()='Next']");
	protected By location = By.xpath("//div[@class=' css-yrenfx-control']");
	protected By Banivihar = By.xpath("//div[text()='Vani Vihar']");
	protected By timeIncrease = By.xpath("//span[@aria-label='plus']");
	protected By lendmark = By.xpath("//input[@placeholder='Enter Land mark']");
	protected By payNow = By.xpath("//p[text()='Pay Now']");
	
	protected By Newmail = By.xpath("//input[@name='email']");
	protected By Continue = By.xpath("//button[text()='Continue']");
	protected By phone =By.xpath("//input[@name='phone']");
	protected By Verify = By.xpath("//button[text()='Click here to verify']");
	protected By studioname = By.xpath("//input[@name='studioName']");
	protected By pName = By.xpath("//input[@name='name']");
	protected By birthDay = By.xpath("//p[text()='Birthday']");
	protected By Wedding = By.xpath("//p[text()='Wedding']");
	protected By Citi = By.xpath("//p[text()='Bhubaneswar']");
	protected By mail = By.xpath("//input[@placeholder='Enter email / mobile number']");
	
//	@Test
	protected void SnumSignin() throws ElementNotInteractableException, Exception {
		driver.get("https://frontend.staging.clickezy.com/onboard/");
		wait.until(ExpectedConditions.visibilityOfElementLocated(mail)).sendKeys(Smob);
		wait.until(ExpectedConditions.visibilityOfElementLocated(login)).click();
		sotp(wait);
		wait.until(ExpectedConditions.visibilityOfElementLocated(Osubmit)).click();
	}
	
//	@Test
	protected void StudioMailSignIn() throws ElementNotInteractableException, Exception {	
		driver.get("https://frontend.staging.clickezy.com/onboard/");
		wait.until(ExpectedConditions.visibilityOfElementLocated(mail)).sendKeys(Smail);
		wait.until(ExpectedConditions.visibilityOfElementLocated(login)).click();
		sotp(wait);
		wait.until(ExpectedConditions.visibilityOfElementLocated(Osubmit)).click();
	}
	
	
	protected void preference(WebDriverWait wait) throws ElementNotInteractableException, Exception {
		wait.until(ExpectedConditions.visibilityOfElementLocated(birthDay)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(Wedding)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(Citi)).click();
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,100)");
		
	}
	
	protected void OnbordSignupInformation(WebDriverWait wait) throws ElementNotInteractableException, Exception {
		wait.until(ExpectedConditions.visibilityOfElementLocated(phone)).sendKeys(mob);
		wait.until(ExpectedConditions.visibilityOfElementLocated(Verify)).click();		
		sotp(wait);
		wait.until(ExpectedConditions.visibilityOfElementLocated(Osubmit)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(studioname)).sendKeys(StudioName);
		wait.until(ExpectedConditions.visibilityOfElementLocated(pName)).sendKeys(NewID);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,200)");
		
	}
	
	protected void sotp(WebDriverWait wait) throws ElementNotInteractableException, Exception {		
		char[] otp = Otp.toCharArray();
		System.out.println("inside sOtp");
		for (int i = 0; i < otp.length; i++) {
			int a = i+1;
			int x = 0;
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("(//input[@name='otp'])["+ a +"]")))
                    .sendKeys(otp[x] + "");           
        	}		
	}
	
	protected void BookForm(WebDriverWait Wait) throws ElementNotInteractableException, Exception {
		wait= new WebDriverWait(driver, (30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(Bookfor)).click();		
		List <WebElement> category = driver.findElements(BookForCategory);
		System.out.println("NumberCategorys: "+category.size());
		wait.until(ExpectedConditions.visibilityOfElementLocated(bookingSearch)).sendKeys("Birthday");
		Thread.sleep(100);
		wait.until(ExpectedConditions.visibilityOfElementLocated(framebook)).click();	
		wait.until(ExpectedConditions.visibilityOfElementLocated(Bookstudio)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(bookingSearch)).sendKeys("subhamStudio");
		wait.until(ExpectedConditions.visibilityOfElementLocated(studio)).click();		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,200)");		
		wait.until(ExpectedConditions.visibilityOfElementLocated(bookingTime)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(bookingHour)).click();
		for(int i=0;i<2;i++) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(timeIncrease)).click();
		}		
		wait.until(ExpectedConditions.visibilityOfElementLocated(selectDate)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(date)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(selectTime)).click();		
		wait.until(ExpectedConditions.visibilityOfElementLocated(Hrs)).click();		
		wait.until(ExpectedConditions.visibilityOfElementLocated(minFream)).click();		
		wait.until(ExpectedConditions.visibilityOfElementLocated(min)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(tOk)).click();
		JavascriptExecutor je = (JavascriptExecutor)driver;
		je.executeScript("window.scrollBy(0,200)");
		driver.findElement(By.xpath("//textarea")).sendKeys("Testing");
		
		
		
//		System.out.println("hrs: "+hrs);
		
//		wait.until(ExpectedConditions.visibilityOfElementLocated(Booklocation)).click();
//		wait.until(ExpectedConditions.visibilityOfElementLocated(BookForCategory));
//		List <WebElement> Category = driver.findElements(BookForCategory);
//		System.out.println("NumberCategorys: "+Category.size());
//		wait.until(ExpectedConditions.visibilityOfElementLocated(bookingSearch)).sendKeys("pet");
	}
	
	
//	@Test
	protected void MobSignIn(WebDriverWait wait) throws Exception {
		driver.get("https://clickezy-dev.netlify.app/");
		SelectCity(wait);
		driver.findElement(credential).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(newMail)
				).sendKeys(Lmob);
		wait.until(ExpectedConditions.visibilityOfElementLocated(login)).click();
		Sotp(wait);
		try {
			assertEqualsMob();
		}catch(Exception e) {
			System.out.println(e.getCause());
		}
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(Osubmit)).click();
	}
	
	protected void assertEqualsMob() {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(sOtpTitle));
			title = driver.findElement(sOtpTitle).getText();
			System.out.println("title: "+title);
			actualTitle = "Confirm your phone";
			Assert.assertEquals(title,actualTitle);
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}
	}
	
//	@Test
	protected void MailSignIn(WebDriverWait wait) throws Exception {
		driver.get("https://clickezy-dev.netlify.app/");
		SelectCity(wait);
		driver.findElement(credential).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(newMail)
				).sendKeys(Lmail);
		wait.until(ExpectedConditions.visibilityOfElementLocated(login)).click();
		Sotp(wait);
		try {
			assertEquals();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}	
		Thread.sleep(100);
		wait.until(ExpectedConditions.visibilityOfElementLocated(Osubmit)).click();
	}
	
	protected void assertEquals() {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(sOtpTitle));
			title = driver.findElement(sOtpTitle).getText();
			System.out.println("title: "+title);
			actualTitle = "Confirm your email";
			Assert.assertEquals(title,actualTitle);			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}		
	}

	protected void SignupInformation() throws Exception {
		wait.until(ExpectedConditions.visibilityOfElementLocated(mobile)).sendKeys(mob);
		wait.until(ExpectedConditions.visibilityOfElementLocated(verify)).click();		
		Sotp(wait);
		wait.until(ExpectedConditions.visibilityOfElementLocated(Osubmit)).click();
		Thread.sleep(500);
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
	
	protected void Sotp(WebDriverWait wait) throws Exception {		
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
	
	
	protected void SelectCity(WebDriverWait wait) throws Exception {
		wait= new WebDriverWait(driver, (50));
		wait.until(ExpectedConditions.visibilityOfElementLocated(city));
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

}
