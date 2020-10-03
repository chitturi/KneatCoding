package stepdefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import helpers.DriverFactory;
import managers.PageObjectManager;
import runner.TestRunner;
import cucumber.api.java.en.Then;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import cucumber.api.java.en.And;

public class SpaStepDefinitions {

	//TestRunner testRunner;
   // WebDriver driver = DriverFactory.getInstance().getDriver();
	PageObjectManager pageObjectManager = new PageObjectManager(TestRunner.driver);

	@When("^I click on Spa filter$")
	public void i_click_on_Spa_filter() throws Throwable {
		pageObjectManager.getSearchresults().filterSpa();
	}

	@When("^I click on Suana filter$")
	public void i_click_on_Suana_filter() throws Throwable {
		pageObjectManager.getSearchresults().filterSpa();
		pageObjectManager.getSearchresults().filterSuana();
	}
	
	@Then("^I see all Hotels are filtered with Suana option$")
	public void i_see_all_Hotels_are_filtered_with_Suana_option() throws Throwable {
		Assert.assertEquals(true, pageObjectManager.getSearchresults().is_SaunaResultsPage_Displayed());
	}
	
	@Then("^I see all Hotels are filtered with Spa option$")
	public void i_see_all_Hotels_are_filtered_with_Spa_option() throws Throwable {
		Assert.assertEquals(true, pageObjectManager.getSearchresults().is_SpaResultsPage_Displayed());
	}
	
	@Then("^Absolute Hotel Limerick is shown in filtered results$")
	public void absolute_Hotel_Limerick_is_shown_in_filtered_results() throws Throwable {
		Assert.assertEquals(true,pageObjectManager.getSearchresults().isAbsoluteLimerickhotelDisplayed());
	}
	
	@Then("^Limerick Strand hotel is shown in filtered results$")
	public void limerick_Strand_hotel_is_shown_in_filtered_results() throws Throwable {
		Assert.assertEquals(true,pageObjectManager.getSearchresults().isLimerickStrandHotelDisplayed());
	}
}

