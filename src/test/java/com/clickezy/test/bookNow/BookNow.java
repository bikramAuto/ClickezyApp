package com.clickezy.test.bookNow;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import com.clickezy.test.signup.Signup;

public class BookNow extends Signup {
	
	@Test
	protected void bookNow() throws Exception {
		signup();
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(BookNow)).click();
		
	}
}
