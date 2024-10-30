package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponent;

public class CreateNewAccountPage extends AbstractComponent{

	WebDriver driver;
	
	public CreateNewAccountPage(WebDriver driver)
	{
		super(driver);
		//initialization
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	//WebElements


		@FindBy(xpath = "//input[@id='user[first_name]']")
		WebElement txtFirstName;
		
		@FindBy(xpath = "//input[@id='user[last_name]']")
		WebElement txtLastName;
		
		@FindBy(xpath = "//input[@id='user[email]']")
		WebElement txtEmail;
		
		@FindBy(xpath = "//input[@id='user[password]']")
		WebElement txtPassword;
		
		@FindBy(xpath = "//input[@id='user[terms]']")
		WebElement chkTerms;
		
		@FindBy(xpath = "//button[@type='submit']")
		WebElement btnSubmit;
		

		
		public ProductPage SignUpSuccessfully(String firstname, String lastname, String email, String password)
		{
			waitForWebElementToAppear(txtFirstName);
			txtFirstName.sendKeys(firstname);
			txtLastName.sendKeys(lastname);
			txtEmail.sendKeys(email);
			txtPassword.sendKeys(password);
			chkTerms.click();
			btnSubmit.click();
			ProductPage productPage = new ProductPage(driver);
			return productPage;
		}
		
		
		
	
}
