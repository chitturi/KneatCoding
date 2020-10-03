package pageObjects;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import helpers.Helpers;

public class SearchResultsPage {

	Helpers helpers = new Helpers();
	private static final Logger logger = Logger.getLogger(SearchResultsPage.class);

	public SearchResultsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//region PageElements
	@FindBy(how = How.CSS, using = ".sr_header")
	private WebElement resultsPage;

	@FindBy(how = How.CSS, using = ".bui-breadcrumb__text")
	private WebElement searchResults;

	@FindBy(how = How.CSS, using = ".bui-checkbox__input.js-bui-checkbox__input")
	private List<WebElement> checkBoxes;

	@FindBy(how = How.CSS, using = ".filter_label")
	private List<WebElement> filterLabels;

	@FindBy(how = How.CSS, using = ".bui-rating.bui-rating--smaller")
	private List<WebElement> fiveStarRatings;	

	@FindBy(how = How.CSS, using = ".sr-hotel__name")
	private List<WebElement> fiveStarRatingHotelNames;	

	@FindBy(how = How.CSS, using = ".collapsed_partly_link")
	private List<WebElement> showMorebutton;

	@FindBy(how = How.CSS, using = ".bui-button__text.bui-f-font-body")
	private List<WebElement> clearFilters;
	
	@FindBy(how = How.CSS, using = ".facility-badge__wrapper")
	private List<WebElement> spaIcon;

	// endregion


	public boolean is_ResultsPage_Displayed()
	{
		helpers.wait.until(ExpectedConditions.visibilityOf(resultsPage));
		if(resultsPage.isDisplayed())
		{
			return true;
		}
		return false;
	}
	
	public boolean is_SpaResultsPage_Displayed() throws InterruptedException
	{
		if(spaIcon.get(0).isDisplayed())
		{
			return true;
		}
		return false;
	}
	
	public boolean is_SaunaResultsPage_Displayed() throws InterruptedException
	{
		helpers.jse.executeScript("arguments[0].scrollIntoView(true);", clearFilters.get(1));
		helpers.wait.until(ExpectedConditions.visibilityOf(searchResults));
		if(clearFilters.get(1).isDisplayed())
		{
			return true;
		}
		return false;
	}

	public boolean is_searchResultsPage_Displayed()
	{
		helpers.wait.until(ExpectedConditions.visibilityOf(searchResults));
		if(resultsPage.isDisplayed())
		{
			return true;
		}
		return false;
	}

	public void is_checkedBoxesCleared() throws InterruptedException
	{
		try {
			for (WebElement checkbox : checkBoxes) {
				if (checkbox.isSelected()) {
					for (WebElement filterLabel : filterLabels) {

						if (filterLabel.getText().contains("5 stars")) {
							filterLabel.click();
						}}
				}}}
		catch(StaleElementReferenceException e)
		{
			logger.info("Element is not visible");
		}
	}

	public void filter5StarLabel()
	{
		try {
			for (WebElement filterLabel : filterLabels) {
				if (filterLabel.getText().contains("5 stars")) {
					helpers.actions.moveToElement(filterLabel);
					filterLabel.click();
				}}
		}
		catch(StaleElementReferenceException e)
		{
			logger.info("StaleElementException Handled");
		}
	}

	public void filterSpa()
	{
		showMorebutton.get(2).click();
		try {
			for (WebElement filterLabel : filterLabels) {
				if (filterLabel.getText().contains("Spa")) {
					helpers.actions.moveToElement(filterLabel);
					filterLabel.click();
				}}
		}
		catch(StaleElementReferenceException e)
		{
			logger.info("StaleElementException Handled");
		}
	}

	public void filterSuana() throws InterruptedException
	{
		try {
			for (WebElement filterLabel : filterLabels) {
				if (filterLabel.getText().contains("Sauna")) {
					helpers.actions.moveToElement(filterLabel);
					filterLabel.click();
				}}
		}
		catch(StaleElementReferenceException e)
		{
			logger.info("StaleElementException Handled");
		}
	}

	public void filter4StarLabel() throws InterruptedException
	{
		is_checkedBoxesCleared();
		try {
			for (WebElement filterLabel : filterLabels) {

				if (filterLabel.getText().contains("4 stars")) {
					helpers.wait.until(ExpectedConditions.elementToBeClickable(filterLabel));
					filterLabel.click();
				}}
		}
		catch(StaleElementReferenceException e)
		{
			logger.info("StaleElementException Handled");
		}
	}

	public boolean isSavoyhotelDisplayed()
	{
		for (WebElement fiveStarRatingHotelName : fiveStarRatingHotelNames) {
			if (fiveStarRatingHotelName.getText().contains("The Savoy Hotel")) {
				return true;
			}
		}
		return false;
	}

	public boolean isAbsoluteLimerickhotelDisplayed()
	{		
		for (WebElement fiveStarRatingHotelName : fiveStarRatingHotelNames) {
			if (fiveStarRatingHotelName.getText().contains("Absolute Hotel Limerick")) {
				return true;
			}
		}
		return false;
	}

	public boolean isLimerickStrandHotelDisplayed() throws InterruptedException
	{
		//helpers.jse.executeScript("arguments[0].scrollIntoView(true);", clearFilters.get(2)); 
		Thread.sleep(1000);
		clearFilters.get(2).click();
		for (WebElement fiveStarRatingHotelName : fiveStarRatingHotelNames) {
			if (fiveStarRatingHotelName.getText().contains("Limerick Strand Hotel")) {
				return true;
			}
		}
		return false;
	}


	public boolean isLimerickhotelDisplayed()
	{
		for (WebElement fiveStarRatingHotelName : fiveStarRatingHotelNames) {
			if (fiveStarRatingHotelName.getText().contains("George Limerick Hotel")) {
				return true;
			}
		}
		return false;
	}

	public boolean fiveStarRatingHotelsLoaded()
	{
		helpers.wait.until(ExpectedConditions.visibilityOfAllElements(fiveStarRatings));
		for (WebElement fiveStarRating : fiveStarRatings) {
			if(fiveStarRating.isDisplayed())
			{
				return true;
			}
		}
		return false;
	}
}

