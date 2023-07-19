package com.clickezy.onBord.test;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import com.clickezy.base.base;

public class SignUp extends base {
	@Test
	protected void Signup() throws ElementNotInteractableException, Exception {
		driver.get("https://frontend.staging.clickezy.com/onboard/");
		wait.until(ExpectedConditions.visibilityOfElementLocated(createAc)).click();
		
		
	}

}
