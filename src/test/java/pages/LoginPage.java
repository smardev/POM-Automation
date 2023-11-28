package pages;

import api.abstraction.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import helper.Config;

public class LoginPage extends BasePage {

	private By usernameField = By.xpath("//input[@id='username']");
	private By passwordField = By.xpath("//input[@id='password']");
	private By loginButton = By.xpath("//button[@id='doLogin']");

	public LoginPage() {
		super(Config.driver);
	}

	public void connect(String username, String password) {
		fill(usernameField, username);
		fill(passwordField, password);
		click(loginButton);
	}


	// Additional methods...
	// In LoginPage.java
	public boolean isLoginButtonPresent() {
		// Replace with actual locator of the login button
		return driver.findElements(loginButton).size() > 0;
	}
}
