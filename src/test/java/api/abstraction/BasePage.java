package api.abstraction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import helper.Config;

import java.time.Duration;

public abstract class BasePage {
	protected WebDriver driver;
	protected WebDriverWait wait;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Adjust the timeout as needed
	}

	public BasePage() {

	}

	protected void fill(By by, String text) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(by)).sendKeys(text);
	}

	protected void click(By by) {
		wait.until(ExpectedConditions.elementToBeClickable(by)).click();
	}


	public void goToUrl(String url){

		Config.driver.get(url);


	}
}
