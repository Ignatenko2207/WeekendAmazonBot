package org.itstep;

import org.itstep.service.Timer;
import org.itstep.service.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class BotRunner {

	public static void main(String[] args) {
		
		WebDriverManager manager = new WebDriverManager();
		WebDriver driver = manager.getWebDriver();
		
		
		
		
		driver.quit();

	}

}
