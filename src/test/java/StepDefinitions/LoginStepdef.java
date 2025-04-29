package StepDefinitions;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.SinginPage;
import Utilities.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepdef {

	private LoginPage _loginPage;
	private SinginPage _singinPage;
	private HomePage _homepage;
	
	@Before
	public void setUp() {
		
		_loginPage = new LoginPage();
		_singinPage =  new SinginPage();
		_homepage = new HomePage();
	}

	@Given("User Navigate to the Application")
	public void user_navigate_to_the_application() {

		_loginPage.launchApplication();

	}

	@When("User Enter {string} and {string}")
	public void user_enter_and(String username, String password) {

		_singinPage.getPageTitle();
		_singinPage.clickOnSignIn();
		_singinPage.enterUsername(username);
		_singinPage.enterPassword(password);

	}

	@Then("User Verify user account and Title of the page")
	public void user_verify_user_account_and_title_of_the_page() {

		_homepage.verifyUserAccount();

	}

	@After
	public void tearDown() {
		BaseClass.tearDown();
	}
}
