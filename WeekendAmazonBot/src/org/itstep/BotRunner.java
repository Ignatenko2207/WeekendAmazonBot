package org.itstep;

import org.itstep.dao.AccountDAO;
import org.itstep.model.Account;
import org.itstep.service.Timer;
import org.itstep.service.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class BotRunner {

	public static void main(String[] args) {
		
//		WebDriverManager manager = new WebDriverManager();
//		WebDriver driver = manager.getWebDriver();
		
		Account account = new Account("Alex", "Ignatenko", "Ignatenko_A_12345@gmail.com", "123456789");
		
		AccountDAO.save(account);
		
//		driver = manager.registerAccount(driver, account);
//		
//		driver.quit();

	}

}
