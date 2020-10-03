package helpers;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import runner.TestRunner;
import stepdefs.CommonStepDefinitions;

public class Helpers {
	
	private static final Logger logger = Logger.getLogger(Helpers.class);

	public WebDriverWait wait = new WebDriverWait(TestRunner.driver, 10);
	public JavascriptExecutor jse = (JavascriptExecutor)TestRunner.driver;
	public Actions actions = new Actions(TestRunner.driver);

	public WebElement safeElementWait(final By selector) throws Exception {
		logger.info("Waiting for an element: " + selector.toString());
		WebElement element = null;
		try {
			FluentWait<WebDriver> wait = new FluentWait<>(TestRunner.driver)
					.withTimeout(14, TimeUnit.SECONDS)
					.pollingEvery(2, TimeUnit.SECONDS)
					.ignoring(NoSuchElementException.class)
					.ignoring(StaleElementReferenceException.class);

			element = wait.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					WebElement el = driver.findElement(selector);
					return (el.isDisplayed()) ? el : null;
				}
			});
		} catch (Exception e) {
			final StackTraceElement[] ste = Thread.currentThread().getStackTrace();
			String callerPlace = ste[2].getMethodName() + "@" + ste[2].getFileName() + ":" + ste[2].getLineNumber();
			throw new Exception("Timed out waiting for web element <" + selector + "> after 14 s. Called from " + callerPlace);
		} finally {
			TestRunner.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		return element;
	}
}
