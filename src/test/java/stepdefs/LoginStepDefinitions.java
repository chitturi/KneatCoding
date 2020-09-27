package stepdefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import managers.PageObjectManager;
import runner.DingRunner;
import cucumber.api.java.en.Then;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import cucumber.api.java.en.And;

public class LoginStepDefinitions {

	PageObjectManager pageObjectManager = new PageObjectManager(DingRunner.driver);

	@Given("^I am on Paypal UK login page$")
	public void i_am_on_Paypal_UK_login_page() throws Throwable {
		DingRunner.driver.get("https://www.sandbox.paypal.com/uk/signin");
		Assert.assertEquals(pageObjectManager.getLoginPage().login_Page(),true);
	}

	@And("^I enter email \"([^\"]*)\" and click on Next button$")
	public void i_enter_email_and_click_on_Next_button(String email) throws Throwable {
		pageObjectManager.getLoginPage().enter_Email(email);
		pageObjectManager.getLoginPage().click_Nextbutton();
	}

	@And("^I see Password page with password field$")
	public void i_see_Password_page_with_password_field() throws Throwable {
		Assert.assertEquals(pageObjectManager.getLoginPage().is_PasswordFieldDisplayed(), true);
	}

	@When("^I enter wrong password \"([^\"]*)\" and click on Login$")
	public void i_enter_wrong_password_and_click_on_Login(String password) throws Throwable {
		pageObjectManager.getLoginPage().enter_Password(password);
		pageObjectManager.getLoginPage().click_Loginbutton();
	}

	@Then("^I see Login error with incorrect information$")
	public void i_see_Login_error_with_incorrect_information() throws Throwable {
		String assertion = "Some of your information isn't correct. Please try again.";
		Assert.assertEquals(pageObjectManager.getLoginPage().getLoginErrorText(),assertion);
	}

	@When("^I click on Login button with empty Email field$")
	public void i_click_on_Login_button_with_empty_Email_field() throws Throwable {
		pageObjectManager.getLoginPage().clear_Email();
		pageObjectManager.getLoginPage().click_Loginbutton();
	}

	@Then("^I see an error with information to enter Email address or mobile number$")
	public void i_see_an_error_with_information_to_enter_Email_address_or_mobile_number() throws Throwable {
		Assert.assertEquals(pageObjectManager.getLoginPage().is_EmailRequiredMessage_Displayed(),true);
	}

	@When("^Click on Login button with empty password field$")
	public void click_on_Login_button_with_empty_password_field() throws Throwable {
		pageObjectManager.getLoginPage().click_Loginbutton();
	}

	@Then("^I see an error Password is required$")
	public void i_see_an_error_Password_is_required() throws Throwable {
		Assert.assertEquals(pageObjectManager.getLoginPage().is_PasswordRequiredMessage_Displayed(),true);
	}
}
