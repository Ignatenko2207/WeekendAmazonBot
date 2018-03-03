package org.itstep.service;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ShowFlowOfTest {

	String testString;
	
	static String staticTestString;
	
	@BeforeClass
	public static void setDataBeforeClass() {
//		testString = "test string";
		staticTestString = "static test string before class";
		
//		System.out.println(testString);
		System.out.println(staticTestString);
	}
	
	@Before
	public void setDataBeforeMethod() {
		testString = "test string before method";
		staticTestString = "static test string before method";
		
		System.out.println(testString);
		System.out.println(staticTestString);
	}
	
	@Test
	public void testGetWebDriver() {
//		WebDriverManager wdm = new WebDriverManager();
		System.out.println("method 1");
	}

	@Test
	public void testRegisterAccount() {
		System.out.println("method 2");
	}
	
	@After
	public void setDataAfterMethod() {
		testString = "test string after method";
		staticTestString = "static test string after method";
		
		System.out.println(testString);
		System.out.println(staticTestString);
	}

	@AfterClass
	public static void setDataAfterClass() {
//		testString = "test string after class";
		staticTestString = "static test string after class";
		
//		System.out.println(testString);
		System.out.println(staticTestString);
	}
}
