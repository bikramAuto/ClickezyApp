package com.clickezy.test;

import org.testng.TestNG;

import com.clickezy.test.user.BookNow;

public class TestRunner {
	
	static TestNG testNg;
	public static final String VERSION = "1.0";

	public static void main(String[] args) {
		testNg = new TestNG();
		testNg.setTestClasses(new Class[] { BookNow.class });
		for(int i=0; i>2; i++) {
			testNg.run();
		}
		

	}

}
