package com.clickezy.test.bookNow;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import com.clickezy.base.base;

public class BookNow extends base {
	
	@Test
	protected void bookNow() throws Exception {
		MailSignIn(wait);
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(BookNow)).click();
		BookForm(wait);
	}
}
