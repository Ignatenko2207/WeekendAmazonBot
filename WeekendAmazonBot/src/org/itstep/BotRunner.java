package org.itstep;

import org.itstep.model.Account;
import org.itstep.service.Timer;
import org.itstep.service.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class BotRunner {

	public static void main(String[] args) {
		
		WebDriverManager manager = new WebDriverManager();
		WebDriver driver = manager.getWebDriver();
		
		Account account = new Account("Alex", "Ignatenko", "Ignatenko_A_123456789@gmail.com", "123456789");
		
		driver = manager.registerAccount(driver, account);
		
		driver.quit();

	}

}
