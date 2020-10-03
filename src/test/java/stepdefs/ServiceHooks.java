package stepdefs;

import java.util.concurrent.TimeUnit;

import org.mortbay.log.Log;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.testng.annotations.BeforeClass;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import helpers.DriverFactory;
import runner.TestRunner;

public class ServiceHooks {
	
	//public static WebDriver driver = null;
	
    @Before
    public void beforeScenario(Scenario scenario) throws Exception{    
    	Log.info("Scenario is about to start: "+scenario.getName());
    }
    
   // @BeforeClass
   // public void beforeClass() throws Exception {
    	
   // } 

    @After
    public void afterScenario(Scenario scenario) {
    
    	//TestRunner.driver.manage().deleteAllCookies();
    	TestRunner.driver.manage().deleteAllCookies();
    	Log.info("Scenario is ended: "+scenario.getName());
        if (scenario.isFailed()) {
            try {
                byte[] screenshot = ((TakesScreenshot) TestRunner.driver).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png" );
                scenario.write("URL at failure: " + TestRunner.driver.getCurrentUrl());
            } catch (WebDriverException wde) {
            	scenario.write("Embed Failed " + wde.getMessage());
            } catch (ClassCastException e) {
                e.printStackTrace();
            }
        }
    }
}
