package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.junit.Assert;
import helper.Config;
import pages.LoginPage;
import pages.RoomPage;

public class LoginStepDefinition {

	private LoginPage loginPage;
	private RoomPage roomPage;

	@Before
	public void setUp() {
		Config.initializeDriver();
		loginPage = new LoginPage();
		roomPage = new RoomPage();
		Config.driver.get("https://automationintesting.online/#/admin");
	}

	@When("User try to connect with valid Admin {string} and {string} and connect")
	public void userTryToConnectWithValidAdmin(String username, String password) {
		loginPage.connect(username, password);
	}

	@Then("Admin is redirected to Home page that contains btn {string}")
	public void adminIsRedirectedToHomePageThatContainsBtn(String button) {
		Assert.assertTrue("Button not found", roomPage.isButtonPresent(button));
		// This assumes that HomePage has an isButtonPresent method to verify the button's presence.
	}

	@When("User try to connect with invalid Admin {string} and {string} and connect")
	public void userTryToConnectWithInvalidAdmin(String username, String password) {
		loginPage.connect(username, password);
	}

	@Then("User is still in login Page")
	public void userIsStillInLoginPage() {
		Assert.assertTrue("User is not on the login page", loginPage.isLoginButtonPresent());
		// This assumes that LoginPage has an isLoginButtonPresent method to verify the page state.
	}

	@After
	public void tearDown() {
		Config.tearDown();
	}
}
