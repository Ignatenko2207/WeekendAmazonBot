package org.itstep.service;

import java.util.concurrent.TimeUnit;

import org.itstep.model.Account;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverManager {
	
	private static final String BASE_URL = "https://www.amazon.com";

	public WebDriver getWebDriver() {
		
		String mainDir = System.getProperty("user.dir"); // D:\workspace\WeekendAmazonBot
		String sep = System.getProperty("file.separator");
		
		System.setProperty
		("webdriver.chrome.driver", mainDir + sep +"lib" + sep +"chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		
		WebDriver driver = new ChromeDriver(options);
		
		driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(45, TimeUnit.SECONDS);
		
		Timer.waitSec(5);
		return driver;
	}
	
	public WebDriver registerAccount(WebDriver driver, Account account) {
		
		driver.get(BASE_URL);
		
		Timer.waitSec(5);
		
		WebElement registerBlock = driver.findElement(By.id("nav-flyout-ya-newCust"));
		WebElement registerLinkElement = registerBlock.findElement(By.tagName("a"));
		
		String registerLink = registerLinkElement.getAttribute("href");
		
		driver.get(registerLink);
		Timer.waitSec(25);
		
		WebElement nameElement = driver.findElement(By.id("ap_customer_name"));
		WebElement emailElement = driver.findElement(By.id("ap_email"));
		WebElement passwordElement = driver.findElement(By.id("ap_password"));
		WebElement checkPasswordElement = driver.findElement(By.id("ap_password_check"));
		WebElement submitElement = driver.findElement(By.id("continue"));
		
		nameElement.sendKeys(account.getFirstName() + " " + account.getSecondName());
		emailElement.sendKeys(account.getEmail());
		passwordElement.sendKeys(account.getPassword());
		checkPasswordElement.sendKeys(account.getPassword());
		
		submitElement.submit();
		
		String pageLink = driver.getCurrentUrl();
		Timer.waitSec(6);
		driver.get(pageLink);
		
		return driver;
	}
	
}
