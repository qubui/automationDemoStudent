package pageobjects;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponent;

public class FakePricingPage extends AbstractComponent{

	WebDriver driver;
	
	public FakePricingPage(WebDriver driver)
	{
		super(driver);
		//initialization
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	

		
		public WebElement getPurchaseColumn (int columnNumber) 
		{
			WebElement purchaseColumn = driver.findElement(By.xpath("//div[contains(@class,'et_pb_column et_pb_column_"+ columnNumber +"_3 et_pb_column_1  et_pb_css_mix_blend_mode_passthrough')]"));
			return purchaseColumn;

		}
		
		public WebElement getPurchaseNameModel (String nameOfModel) 
		{
			WebElement purchaseColumn = driver.findElement(By.xpath("//h4[@class='et_pb_pricing_title'][text()='"+nameOfModel+"']"));
			return purchaseColumn;

		}
		
		public WebElement getUnavailableBenefitsPerModel (String nameOfModel) 
		{
			WebElement purchaseColumn = driver.findElement(By.xpath("//h4[@class='et_pb_pricing_title'][text()='"+nameOfModel+"']"));
			return purchaseColumn;

		}
		
		public WebElement getUnavailableBenefitNamePerModel (int price, String nameOfBenefit) 
		{
			WebElement itemNotAvailableBenefit = driver.findElement(By.xpath("//span[text()='$"+price+"']//ancestor::div[@class='et_pb_pricing_content_top']//following::div/ul/li/span[text()='"+nameOfBenefit+"']//ancestor::li[@class='et_pb_not_available']"));
			return itemNotAvailableBenefit;
		}
		
		public WebElement getAvailableBenefitNamePerModel (int price, String nameOfBenefit) 
		{
			WebElement itemAvailableBenefit = driver.findElement(By.xpath("//span[text()='$"+price+"']//ancestor::div[@class='et_pb_pricing_content_top']//following::div/ul/li/span[text()='"+nameOfBenefit+"']//ancestor::li"));
			return itemAvailableBenefit;
		}
		public Boolean AreUnavailableBenefitsPerModel(int price, List<String> notAvailableBenefitList) 
		{
			try {
				for (String notAvailableBenefit : notAvailableBenefitList)
				{
					Boolean unavailableBenefitsPerModel = getUnavailableBenefitNamePerModel(price,notAvailableBenefit).isDisplayed();
					return unavailableBenefitsPerModel;
				}
				
				return null;
			}catch(NoSuchElementException e) {
				return false;
			}
			
			
		}
		
		public Boolean AreAvailableBenefitsPerModel(int price, List<String> availableBenefitList) 
		{
			try {
				for (String AvailableBenefit : availableBenefitList)
				{
					Boolean availableBenefitsPerModel = getAvailableBenefitNamePerModel(price,AvailableBenefit).isDisplayed();
					return availableBenefitsPerModel;
				}
				
				return null;
			}catch(NoSuchElementException e) {
				return false;
			}
			
			
		}
}
