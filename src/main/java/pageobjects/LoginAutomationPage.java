package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponent;

public class LoginAutomationPage extends AbstractComponent{

	WebDriver driver;
	
	public LoginAutomationPage(WebDriver driver)
	{
		super(driver);
		//initialization
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	//WebElements


		@FindBy(xpath = "//input[@id='user[email]']")
		WebElement txtEmail;
		
		@FindBy(xpath = "//input[@id='user[password]']")
		WebElement txtPassword;
		
		@FindBy(xpath = "//button[@type='submit']")
		WebElement btnSubmit;
		
		@FindBy(xpath = "//div[@id='notice']/ul/li[@class='form-error__list-item']")
		WebElement ErrorMessage;
		
		@FindBy(xpath = "//a[@href='/users/sign_up']")
		WebElement lnkCreateNewAccount;
		
		
		public WebElement getErrorMessage() {
			return ErrorMessage;
		}

		public ProductPage LoginSuccessfully(String email, String password)
		{
			waitForWebElementToAppear(txtEmail);
			txtEmail.sendKeys(email);
			txtPassword.sendKeys(password);
			btnSubmit.click();
			ProductPage productPage = new ProductPage(driver);
			return productPage;
		}
		
		public void LoginUnsuccessfully(String email, String password)
		{
			waitForWebElementToAppear(txtEmail);
			txtEmail.sendKeys(email);
			txtPassword.sendKeys(password);
			btnSubmit.click();
			waitForWebElementToAppear(ErrorMessage);
		}
		
		public String getErrorText()
		{
			String message = getErrorMessage().getText().toString();
			return message;
		}
		
		public CreateNewAccountPage GotoCreateNewAccountPage()
		{
			waitForWebElementToAppear(lnkCreateNewAccount);
			lnkCreateNewAccount.click();
			CreateNewAccountPage createNewAccountPage = new CreateNewAccountPage(driver);
			return createNewAccountPage;
		}
	
}
