package org.itstep.service;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.itstep.model.Account;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByTagName;
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
		
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
		
		Timer.waitSec(5);
		return driver;
	}
	
	public WebDriver registerAccount(WebDriver driver, Account account) {
		
		if(driver == null) {
			return driver;
		}
		
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
		Timer.waitSec(5);
		driver.get(pageLink);
		
		Timer.waitSec(5);
		return driver;
	}
	
	// driver must be with registered account page
	public WebDriver addGoodToCartByAsin(WebDriver driver, String asin) {
		
		Timer.waitSec(15);
		WebElement searchInputElement = driver.findElement(By.id("twotabsearchtextbox"));
		searchInputElement.sendKeys(asin);
		
		List<WebElement> navInputElements = driver.findElements(By.className("nav-input"));
		for (WebElement inputElement : navInputElements) {
			if(inputElement.getAttribute("value") != null && inputElement.getAttribute("value").equals("Go")) {
				inputElement.submit();
			}
		}
		Timer.waitSec(3);
		String currentUrl = driver.getCurrentUrl();
		driver.get(currentUrl);
		Timer.waitSec(5);
		
		// now it is navigation page with products
		WebElement ulElement = driver.findElement(By.id("s-results-list-atf"));
		List<WebElement> productsList = ulElement.findElements(By.tagName("li"));
		String productLink = "";
		boolean productLinkNotFound = true;
		for (WebElement liElement : productsList) {
			if(productLinkNotFound) {
				if(liElement.getAttribute("data-asin")!=null && liElement.getAttribute("data-asin").equals(asin)) {
					List<WebElement> linkElements = liElement.findElements(By.tagName("a"));
					for (WebElement linkElement : linkElements) {
						if(linkElement.getAttribute("class")!=null && linkElement.getAttribute("class").startsWith("a-link-normal")) {
							productLink = liElement.getAttribute("href");
							productLinkNotFound = false;
							break;
						}
					}
				}
			}
		}
		Timer.waitSec(10);
		if(productLink.isEmpty()) {
			return driver;
		}
		driver.get(productLink);
		Timer.waitSec(5);
		
		WebElement addToCart = driver.findElement(By.id("add-to-cart-button"));
		addToCart.submit();
		
		Timer.waitSec(5);
		currentUrl = driver.getCurrentUrl();
		driver.get(currentUrl);
		
		Timer.waitSec(8);
		
		return driver;
	}
	
	

}
