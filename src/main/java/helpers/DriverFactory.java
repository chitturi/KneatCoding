package helpers;

import org.apache.commons.lang.SystemUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.util.concurrent.TimeUnit;

public class DriverFactory {

	private static DriverFactory instance = null;
	static ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();

	private DriverFactory() {

	}

	public static DriverFactory getInstance() {
		if (instance == null) {
			instance = new DriverFactory();

		}
		return instance;
	}

	public static WebDriver createDriverInstance(String browser) throws Exception {

		WebDriver driver = null;
		DesiredCapabilities caps = null;
		switch (browser) {
		case "chrome":
			caps = DesiredCapabilities.chrome();
			if (SystemUtils.IS_OS_MAC || SystemUtils.IS_OS_LINUX) 
			{				
				System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "//chromedriver//chromedriver");
			}else
			{
				System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "\\chromedriver\\chromedriver.exe");
			}
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().deleteAllCookies();
			break;
		case "firefox":
			caps = DesiredCapabilities.firefox();
			if (SystemUtils.IS_OS_MAC || SystemUtils.IS_OS_LINUX) 
			{				
				System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir") + "//firefoxdriver//geckodriver");
			}else
			{
				System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir") + "\\firefoxdriver\\geckodriver.exe");
			}
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().deleteAllCookies();
			break;
		case "IE11":
			caps = DesiredCapabilities.edge();
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "//IEDriver//IEDriverdriverServer");
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().deleteAllCookies();
			break;
		default:
			throw new Exception("Cant instantiate Webdriver");
		}
		return driver;
	}

	public static void setDriver(WebDriver driverParam)
	{
		webDriver.set(driverParam);
	}

	public WebDriver getDriver() {
		return webDriver.get();
	}

	public void removeDriver() {
		try {
			webDriver.get().quit();
			webDriver.remove();
		} catch(Exception e)
		{
			e.printStackTrace();
		}

	}
}
