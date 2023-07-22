package com.clickezy.test;

import org.testng.TestNG;

import com.clickezy.test.user.Signup;

public class TestRunner {
	
	static TestNG testNg;
	public static final String VERSION = "1.0";

	public static void main(String[] args) {
		testNg = new TestNG();
		testNg.setTestClasses(new Class[] { Signup.class });
		testNg.run();

	}

}
