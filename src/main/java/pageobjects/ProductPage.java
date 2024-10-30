package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponent;

public class ProductPage extends AbstractComponent{

	WebDriver driver;
	
	public ProductPage(WebDriver driver)
	{
		super(driver);
		//initialization
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	//WebElements


		@FindBy(xpath = "//a[@href='/enrollments']")
		WebElement lnkMyDashboard;
		
		

		@FindBy(xpath = "//input[@type='search']")
		WebElement txtSearch;
		
		@FindBy(xpath = "//a[@href='/collections/courses']")
		WebElement lnkAllCourses;


		public WebElement getLnkMyDashboard() {
			return lnkMyDashboard;
		}

		public WebElement getTxtSearch() {
			return txtSearch;
		}

		public WebElement getLnkAllCourses() {
			return lnkAllCourses;
		}
		
		public WebElement getUsername(String userName) 
		{
			WebElement userNameHeader = driver.findElement(By.xpath("//button[contains(text(),'"+userName+"')]"));
			return userNameHeader;

		}
		
		
		public Boolean isLnkMyDashboardDisplayed() 
		{
			Boolean lnkMyDashboard = getLnkMyDashboard().isDisplayed();
			return lnkMyDashboard;

		}
		
		
		public Boolean isTxtSearchDisplayed() 
		{
			Boolean txtSearch = getTxtSearch().isDisplayed();
			return txtSearch;

		}
		
		public Boolean isLnkAllCoursesDisplayed() 
		{
			Boolean lnkAllCourses = getLnkAllCourses().isDisplayed();
			return lnkAllCourses;

		}
		
		public Boolean isUserNameDisplayed(String userName) 
		{
			Boolean user = getUsername(userName).isDisplayed();
			return user;

		}
}
