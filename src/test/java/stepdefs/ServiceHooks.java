package stepdefs;

import org.mortbay.log.Log;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import runner.DingRunner;

public class ServiceHooks {
	
    @Before
    public void initializeTest(Scenario scenario){
    	Log.info("Scenario is about to start: "+scenario.getName());
    }

    @After
    public void embedScreenshot(Scenario scenario) {
    
    	Log.info("Scenario is ended: "+scenario.getName());
        if (scenario.isFailed()) {
            try {
                byte[] screenshot = ((TakesScreenshot) DingRunner.driver).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png" );
                scenario.write("URL at failure: " + DingRunner.driver.getCurrentUrl());
            } catch (WebDriverException wde) {
            	scenario.write("Embed Failed " + wde.getMessage());
            } catch (ClassCastException e) {
                e.printStackTrace();
            }
        }
    }
}
