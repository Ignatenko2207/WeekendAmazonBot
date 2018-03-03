package org.itstep.service;

import static org.junit.Assert.*;

import org.itstep.model.Account;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class WebDriverManagerTest {

	static WebDriverManager driverManager;

	@BeforeClass
	public static void initDriverManager() {
		driverManager = new WebDriverManager();
	}

	@Ignore
	@Test
	public void testGetWebDriver() {
		Timer.waitSec(5);
		WebDriver driver = driverManager.getWebDriver();

		assertNotNull(driver);

		driver.quit();
	}

	@Ignore
	@Test
	public void testRegisterAccount() {
		Timer.waitSec(5);
		WebDriver driver = driverManager.getWebDriver();

		Account account = new Account("Alex", "Ignatenko", "Ignatenko_A_12346666@gmail.com", "123456789");

		driver = driverManager.registerAccount(driver, account);

		assertTrue(driver.getPageSource().contains("Hello, Alex"));
		
		driver.quit();
	}
	
	@Test
	public void testAddGoodToCart() {
		WebDriver driver = driverManager.getWebDriver();
		
		Account account = new Account("Alex", "Ignatenko", "Ignatenko_A_12258822455@gmail.com", "123456789");

		driver = driverManager.registerAccount(driver, account);

		assertTrue(driver.getPageSource().contains("Hello, Alex"));
		
		if(driver.getPageSource().contains("Hello, Alex")) {
			driver = driverManager.addGoodToCartByAsin(driver, "B072JJ92NV");
			
			assertTrue(driver.getPageSource().contains("Added to Cart"));
		}
		
		driver.quit();
	}

}
