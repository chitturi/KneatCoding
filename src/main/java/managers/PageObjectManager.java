package managers;

import org.openqa.selenium.WebDriver;
import pageObjects.HomePage;
import pageObjects.SearchResultsPage;

public class PageObjectManager {

	private WebDriver driver;
	private HomePage loginPage;
	private SearchResultsPage searchResultsPage;
	
	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}
	
	public HomePage getHomePage() {
		return (loginPage == null) ? loginPage = new HomePage(driver) : loginPage;
	}
	
	public SearchResultsPage getSearchresults() {
		return (searchResultsPage == null) ? searchResultsPage = new SearchResultsPage(driver) : searchResultsPage;
	}
}
