package com.clickezy.test.signup;

import org.testng.annotations.Test;

import com.clickezy.base.base;

public class Signup extends base {
	
	@Test
	protected void signup() throws Exception {
		lunch();
		driver.findElement(credential).click();
	}
	
	
	
}
