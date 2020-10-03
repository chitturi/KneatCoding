package stepdefs;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.openqa.selenium.JavascriptExecutor;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helpers.DriverFactory;
import helpers.Helpers;
import managers.PageObjectManager;
import runner.TestRunner;

public class CommonStepDefinitions {
	
	private static final Logger logger = Logger.getLogger(CommonStepDefinitions.class);
	PageObjectManager pageObjectManager = new PageObjectManager(TestRunner.driver);

	@Given("^I am on Booking home page$")
	public void i_am_on_Booking_home_page() throws Throwable {
	   TestRunner.driver.get("https://www.booking.com");
	   pageObjectManager.getHomePage().accept_Cookies();
	}

	@And("^I Enter Limerick as City$")
	public void i_Enter_Limerick_as_City() throws Throwable {
	    pageObjectManager.getHomePage().searchCity("Lim");
	}

	@And("^I Enter dates for one night from (\\d+) months$")
	public void i_Enter_dates_for_one_night_from_months(int arg1) throws Throwable {
		 pageObjectManager.getHomePage().selectDates();
	}

	@When("^I click on Search Button$")
	public void i_click_on_Search_Button() throws Throwable {
		 pageObjectManager.getHomePage().clickOnSearchButton();
	}

	@Then("^I can see All types of rentals are loaded with filter options$")
	public void i_can_see_All_types_of_rentals_are_loaded_with_filter_options() throws Throwable {
	    Assert.assertEquals(true, pageObjectManager.getSearchresults().is_ResultsPage_Displayed());
	}
	
	@Given("^User is on search results page$")
	public void user_is_on_search_results_page() throws Throwable {
		pageObjectManager.getSearchresults().is_searchResultsPage_Displayed();
	}
	
	@And("^I checked if any filters are activated and cleared$")
	public void i_checked_if_any_filters_are_activated_and_cleared() throws Throwable {
		pageObjectManager.getSearchresults().is_checkedBoxesCleared();
	}
	
	@And("^The Savoy hotel is shown in filtered results$")
	public void the_Savoy_hotel_is_shown_in_filtered_results() throws Throwable {
		Assert.assertEquals(true,pageObjectManager.getSearchresults().isSavoyhotelDisplayed());
	}
	
	@And("^George Limerick hotel is not shown in filtered results$")
	public void george_Limerick_hotel_is_not_shown_in_filtered_results() throws Throwable {
		Assert.assertEquals(false,pageObjectManager.getSearchresults().isLimerickhotelDisplayed());
	}
	
	@Then("^George Limerick hotel is shown in filtered results$")
	public void george_Limerick_hotel_is_shown_in_filtered_results() throws Throwable {
		Assert.assertEquals(true,pageObjectManager.getSearchresults().isLimerickhotelDisplayed());
	}
}
