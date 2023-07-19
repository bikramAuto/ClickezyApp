package com.clickezy.test.signup;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import com.clickezy.base.base;

public class Signup extends base {
	
	@Test
	protected void signup() throws ElementNotInteractableException, Exception {
		SelectCity(wait);
		driver.findElement(credential).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(createAc)).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(newMail)
				).sendKeys(NewMail);
		wait.until(ExpectedConditions.visibilityOfElementLocated(checkbox)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(sup)).click();
		Sotp();
		wait.until(ExpectedConditions.visibilityOfElementLocated(Osubmit)).click();
		SignupInformation();
		wait.until(ExpectedConditions.visibilityOfElementLocated(cnfm)).click();
		System.out.println("New A/c: "+ NewMail);
		System.out.println("New MobNo.: "+ mob);
		driver.quit();
//		driver.findElement(checkbox).click();
//		MailSAC();
		
	}


	
	
	
}
