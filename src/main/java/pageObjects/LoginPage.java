package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import helpers.Helpers;

public class LoginPage {

	Helpers helpers = new Helpers();

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//region PageElements
	@FindBy(how = How.ID, using = "login") 
	private WebElement loginContext;

	@FindBy(how = How.ID, using = "email") 
	private WebElement email_Text;

	@FindBy(how = How.ID, using = "btnNext") 
	private WebElement nextButton;

	@FindBy(how = How.ID, using = "password") 
	private WebElement password_Text;

	@FindBy(how = How.ID, using = "btnLogin") 
	private WebElement loginButton;

	@FindBy(how = How.CSS, using = "p.notification.notification-critical") 
	private WebElement loginError;

	@FindBy(how = How.CSS, using = "#emailErrorMessage p.emptyError") 
	private WebElement emailError;

	@FindBy(how = How.CSS, using = "#passwordErrorMessage p.emptyError") 
	private WebElement passwordError;
	// endregion

	public void enter_Email(String email)
	{
		email_Text.sendKeys(email);
	}

	public void clear_Email()
	{
		email_Text.clear();
	}

	public void enter_Password(String password)
	{
		password_Text.sendKeys(password);
	}

	public void click_Nextbutton()
	{
		nextButton.click();
	}

	public void click_Loginbutton()
	{
		loginButton.click();
	}

	public boolean login_Page()
	{
		if(loginContext.isDisplayed())
		{
			return true;
		}
		return false;			
	}

	public boolean is_PasswordFieldDisplayed()
	{
		helpers.wait.until(ExpectedConditions.elementToBeClickable(password_Text));
		if(password_Text.isDisplayed())
		{
			return true;
		}
		return false;
	}

	public String getLoginErrorText()
	{
		String text = loginError.getText();
		return text;
	}


	public boolean is_EmailRequiredMessage_Displayed()
	{
		helpers.wait.until(ExpectedConditions.visibilityOf(emailError));
		if(emailError.isDisplayed())
		{
			return true;
		}
		return false;
	}

	public boolean is_PasswordRequiredMessage_Displayed()
	{
		if(passwordError.isDisplayed())
		{
			return true;
		}
		return false;
	}
}

