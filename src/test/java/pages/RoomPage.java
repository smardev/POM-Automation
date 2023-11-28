package pages;

import api.abstraction.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import helper.Config;

public class RoomPage extends BasePage {

	String frontBtnXpath = "//a[@id='frontPageLink']";

	String createRoomXpath = "//button[@id='createRoom']";
	
	
	String roomIDxpath = "//input[@id='roomName']";
	
	String typeXpath = "//select[@id='type']";
	
	String xpathPrice = "//input[@id='roomPrice']";

	public RoomPage(WebDriver driver) {
		super(driver);
	}

	public RoomPage() {
		super();
	}

	public String getFrontPageText() {

		return Config.driver.findElement(By.xpath(frontBtnXpath)).getText();

	}

	public void createEmptyRoom() {

		click(By.xpath(createRoomXpath));

	}
	
	public void createRoom(String roomID, String roomTypeVisibleText, String price) {
		
		fill(By.xpath(frontBtnXpath), roomID);
		
		WebElement typeElement = Config.driver.findElement(By.xpath(typeXpath));
		
		org.openqa.selenium.support.ui.Select select = new org.openqa.selenium.support.ui.Select(typeElement);
		
		select.selectByVisibleText(roomTypeVisibleText);
		
		fill(By.id(xpathPrice), price);
		
		// pour eviter le cast j'utilise String pour le sendKeys
		
		click(By.xpath(createRoomXpath));
		
		
		
		
		
	}

	// In HomePage.java
	public boolean isButtonPresent(String button) {
		// Replace with actual locator of the button
		return driver.findElements(By.id(button)).size() > 0;
	}





}
