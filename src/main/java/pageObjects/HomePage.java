package pageObjects;

import java.util.List;

import org.apache.log4j.Logger;
import org.mortbay.log.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import helpers.Helpers;

public class HomePage {

	Helpers helpers = new Helpers();

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//region PageElements
	private static final Logger logger = Logger.getLogger(SearchResultsPage.class);
	private static final By ACCEPT_COOKIES = By.id("onetrust-accept-btn-handler");
	
	@FindBy(how = How.ID, using = "onetrust-accept-btn-handler") 
	private WebElement accept_Cookies;
	
	@FindBy(how = How.ID, using = "ss") 
	private WebElement searchText;
	
	@FindBy(how = How.CSS, using = "ul.c-autocomplete__list li span span") 
	private WebElement searchAutoFill;
	
	@FindBy(how = How.CSS, using = ".bui-calendar__control--next svg ")
	private WebElement calenderNext;
	
	@FindBy(how = How.CSS, using = "table.bui-calendar__dates > tbody > tr:nth-of-type(4) > td:nth-of-type(1)")
	private List<WebElement> selectStartDate;
	
	@FindBy(how = How.CSS, using = "table.bui-calendar__dates > tbody > tr:nth-of-type(4) > td:nth-of-type(2)")
	private List<WebElement> selectEndDate;
	
	@FindBy(how = How.CSS, using=".sb-date-field")
	private List<WebElement> selectCheckIn;
	
	@FindBy(how = How.CSS, using="button.sb-searchbox__button")
	private WebElement searchButton;
	
	// endregion
	
	public void accept_Cookies() {
		try {
			helpers.jse.executeScript("return document.readyState").toString().equals("complete");
			helpers.safeElementWait(ACCEPT_COOKIES).isDisplayed();
			Thread.sleep(1000);
			if(accept_Cookies.isDisplayed())
			{
				accept_Cookies.click();
			}
			else
			{
				logger.info("Accept cookies is not displayed in homepage");
			}
		}
		catch(Exception e)
		{
			logger.info("Error in finding element: "+e);
		}		
	}

	public void searchCity(String city)
	{
		helpers.wait.until(ExpectedConditions.elementToBeClickable(searchText));
		searchText.clear();
		searchText.sendKeys(city);
		searchAutoFill.click();
	}
	
	public void selectDates() throws InterruptedException
	{
		helpers.wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".bui-calendar__control--next svg ")));
		calenderNext.click();
		selectStartDate.get(1).click();
		selectEndDate.get(1).click();
	}

	public void clickOnSearchButton()
	{
		searchButton.click();
	}
}

