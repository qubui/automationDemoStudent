package pageobjects;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponent;

public class FillOutFormsPage extends AbstractComponent{

	WebDriver driver;
	
	public FillOutFormsPage(WebDriver driver)
	{
		super(driver);
		//initialization
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
		
	//WebElements

	
	@FindBy(xpath = "//input[@id='et_pb_contact_name_1']")
	WebElement txtNameWithCaptcha;
	
	@FindBy(xpath = "//textarea[@id='et_pb_contact_message_1']")
	WebElement txtCommentWithCaptcha;
	
	

	@FindBy(xpath = "//input[@name='et_pb_contactform_submit_1']//following::div/button[@type='submit']")
	WebElement btnSubmitWithCaptcha;
	
	@FindBy(xpath = "//div[@id='et_pb_contact_form_1']/div/p")
	WebElement message1;



	
	public WebElement getTxtNameWithCaptcha() {
		return txtNameWithCaptcha;
	}

	public WebElement getTxtCommentWithCaptcha() {
		return txtCommentWithCaptcha;
	}

	public WebElement getBtnSubmitWithCaptcha() {
		return btnSubmitWithCaptcha;
	}
	
	public void SubmitCapchaForm(String name, String message)
	{
		waitForWebElementToAppear(txtNameWithCaptcha);
		txtNameWithCaptcha.sendKeys(name);
		txtCommentWithCaptcha.sendKeys(message);
		btnSubmitWithCaptcha.click();
	}
	
	
	public List<String> getListOfMessage() {
		try {
			List<String> list = new ArrayList<String>();
			//List<String> list = null;
		    WebElement message1 = driver.findElement(By.xpath("//div[@id='et_pb_contact_form_1']/div/p"));
		    String msg1 = message1.getText().toString();
		    list.add(msg1);
		    List<WebElement> elementsList =  driver.findElements(By.xpath("//div[@id='et_pb_contact_form_1']/div/ul/li"));
		    for(WebElement e:elementsList) {
		        String msg = e.getText().toString();
		        list.add(msg);
		    }
		    return list;
		}catch(NoSuchElementException e) {
			return null;
		}
		
		
	}
}
