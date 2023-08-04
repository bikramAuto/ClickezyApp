package com.clickezy.test.user;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import com.clickezy.base.base;

public class BookNow extends base {
	
	@Test(priority=1)
	protected void bookNow() throws ElementNotInteractableException, Throwable {
		MailSignIn(wait);
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(BookNow1)).click();
		BookForm(wait);
		wait.until(ExpectedConditions.visibilityOfElementLocated(next)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(location)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(Banivihar)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(lendmark)).sendKeys("Testing");
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,500)");
		wait.until(ExpectedConditions.visibilityOfElementLocated(payNow)).click();
		driver.quit();
	}
	
	@Test(priority=2)
	protected void bookNow1() throws ElementNotInteractableException, Throwable {
		lunch();
		MobSignIn(wait);
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(BookNow1)).click();
		BookForm(wait);
		wait.until(ExpectedConditions.visibilityOfElementLocated(next)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(location)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(Banivihar)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(lendmark)).sendKeys("Testing");
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,500)");
		wait.until(ExpectedConditions.visibilityOfElementLocated(payNow)).click();
		
	}
}
