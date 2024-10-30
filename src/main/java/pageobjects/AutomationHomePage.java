package pageobjects;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponent;

public class AutomationHomePage extends AbstractComponent{

	WebDriver driver;

	public AutomationHomePage(WebDriver driver)
	{
		super(driver);
		//initialization
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	//WebElements
	@FindBy(xpath = "//a[@href='../complicated-page']")
	WebElement lnkBigPageManyElements;	

	
	@FindBy(xpath = "//a[@href='../fake-landing-page']")
	WebElement lnkFakeLandingPage;	
	
	@FindBy(xpath = "//a[@href='../fake-pricing-page']")
	WebElement lnkFakePricingPage;	
	
	@FindBy(xpath = "//a[@href='https://ultimateqa.com/filling-out-forms/']")
	WebElement lnkFillOutForms;	
	
	@FindBy(xpath = "//a[@href='https://ultimateqa.com/sample-application-lifecycle-sprint-1/']")
	WebElement lnkLearnHowToAutomateApp;	
	
	
	@FindBy(xpath = "//a[@href='http://courses.ultimateqa.com/users/sign_in']")
	WebElement lnkLoginAutomation;
	
	@FindBy(xpath = "//a[@href='../simple-html-elements-for-automation/']")
	WebElement lnkInteractionsSimpleElements;
	
	
	
	
	public WebElement getLnkBigPageManyElements() {
		return lnkBigPageManyElements;
	}

	public WebElement getLnkFakeLandingPage() {
		return lnkFakeLandingPage;
	}

	public WebElement getLnkFakePricingPage() {
		return lnkFakePricingPage;
	}

	public WebElement getLnkFillOutForms() {
		return lnkFillOutForms;
	}

	public WebElement getLnkLearnHowToAutomateApp() {
		return lnkLearnHowToAutomateApp;
	}

	public WebElement getLnkLoginAutomation() {
		return lnkLoginAutomation;
	}

	public WebElement getLnkInteractionsSimpleElements() {
		return lnkInteractionsSimpleElements;
	}



	public Boolean islnkBigPageManyElementsDisplay() 
	{
		Boolean lnkBigPageManyElements = getLnkBigPageManyElements().isDisplayed();
		return lnkBigPageManyElements;

	}
	
	public Boolean islnkFakeLandingPageDisplay() 
	{
		Boolean lnkFakeLandingPage = getLnkFakeLandingPage().isDisplayed();
		return lnkFakeLandingPage;

	}
	
	public Boolean islnkFakePricingPageDisplay() 
	{
		Boolean lnkFakePricingPage = getLnkFakePricingPage().isDisplayed();
		return lnkFakePricingPage;

	}
	public Boolean islnkFillOutFormsDisplay() 
	{
		Boolean lnkFillOutForms = getLnkFillOutForms().isDisplayed();
		return lnkFillOutForms;

	}
	
	
	public Boolean islnkLoginAutomationDisplay() 
	{
		Boolean lnkLoginAutomation = getLnkLearnHowToAutomateApp().isDisplayed();
		return lnkLoginAutomation;

	}
	
	public Boolean islnkLearnHowToAutomateAppDisplay() 
	{
		Boolean lnkLearnHowToAutomateApp = getLnkLoginAutomation().isDisplayed();
		return lnkLearnHowToAutomateApp;

	}
	
	
	
	public Boolean islnkInteractionsSimpleElementsDisplay() 
	{
		Boolean lnkInteractionsSimpleElements = getLnkInteractionsSimpleElements().isDisplayed();
		return lnkInteractionsSimpleElements;

	}
	
	
	
	public FakePricingPage GotoFakePricingPage()
	{
		waitForWebElementToAppear(lnkFakePricingPage);
		lnkFakePricingPage.click();
		FakePricingPage fakePricingPage = new FakePricingPage(driver);
		return fakePricingPage;
	}
	
	public FillOutFormsPage GotoFillOutFormsPage()
	{
		waitForWebElementToAppear(lnkFillOutForms);
		lnkFillOutForms.click();
		FillOutFormsPage fillOutFormsPage = new FillOutFormsPage(driver);
		return fillOutFormsPage;
	}
	
	public LoginAutomationPage GotoLoginAutomationPage()
	{
		waitForWebElementToAppear(lnkLoginAutomation);
		lnkLoginAutomation.click();
		LoginAutomationPage loginAutomationPage = new LoginAutomationPage(driver);
		return loginAutomationPage;
	}
	

	
	public void goTo(String url)
	{
		driver.get(url);
	}
}
