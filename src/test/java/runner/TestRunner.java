package runner;
import org.mortbay.log.Log;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import helpers.DriverFactory;

@CucumberOptions(
		features = "src/test/resources/features",
		glue = {"stepdefs"},
		tags = {"~@Ignore"},
		 format = {
	                "pretty",
	                "html:target/cucumber-reports/cucumber-pretty",
	                "json:target/cucumber-reports/json-reports/CucumberTestReport.json",
	                "rerun:target/cucumber-reports/rerun-reports/rerun.txt"})
public class TestRunner extends AbstractTestNGCucumberTests {

	public static WebDriver driver;
	private TestNGCucumberRunner testNGCucumberRunner;

	@BeforeClass(alwaysRun = true)
	public void setUpClass() throws Exception {
		testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
		String browserType = System.getProperty("browserType");
		if(browserType == null)
		{
			driver = DriverFactory.createDriverInstance("chrome");
		}else
		{
			driver = DriverFactory.createDriverInstance(browserType);
		}
		DriverFactory.getInstance().setDriver(driver);
		driver = DriverFactory.getInstance().getDriver();
	}

	@Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "features")
	public void feature(CucumberFeatureWrapper cucumberFeature) {
		testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
	}
	@Override
	@DataProvider
	public Object[][] features() {
		return testNGCucumberRunner.provideFeatures();
	}

	@AfterClass(alwaysRun = true)
	public void tearDownClass() throws Exception {
		testNGCucumberRunner.finish();
		driver.quit();
		Log.info("Browser is closed.....");
	}
}
