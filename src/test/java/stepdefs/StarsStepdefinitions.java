package stepdefs;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helpers.DriverFactory;
import managers.PageObjectManager;
import runner.TestRunner;

public class StarsStepdefinitions {

	private static final Logger logger = Logger.getLogger(SpaStepDefinitions.class);
	//TestRunner testRunner;
	//WebDriver driver = DriverFactory.getInstance().getDriver();
	PageObjectManager pageObjectManager = new PageObjectManager(TestRunner.driver);

	@When("^I click on (\\d+) Star filter$")
	public void i_click_on_Star_filter(int starRating) throws Throwable {
		if(starRating == 5)
			pageObjectManager.getSearchresults().filter5StarLabel();
		else
			pageObjectManager.getSearchresults().filter4StarLabel();
	}

	@Then("^I see all Hotels are filtered with (\\d+) Star rating$")
	public void i_see_all_Hotels_are_filtered_with_Star_rating(int arg1) throws Throwable {
		Assert.assertEquals(true, pageObjectManager.getSearchresults().fiveStarRatingHotelsLoaded());
	}

	@Then("^The Savoy hotel is not shown in filtered results$")
	public void the_Savoy_hotel_is_not_shown_in_filtered_results() throws Throwable {
		Assert.assertEquals(false,pageObjectManager.getSearchresults().isSavoyhotelDisplayed());
	}
}
