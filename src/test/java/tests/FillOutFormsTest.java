package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import TestComponents.BaseTest;
import pageobjects.AutomationHomePage;
import pageobjects.FakePricingPage;
import pageobjects.FillOutFormsPage;

import java.io.IOException;
import java.util.List;

import org.testng.Assert;

public class FillOutFormsTest extends BaseTest {


	@Test
	public void VerirySubmitEmtryDataForCaptchaForm() throws InterruptedException
	{
		AutomationHomePage automationHomePage = new AutomationHomePage(driver);
		FillOutFormsPage fillOutFormsPage = automationHomePage.GotoFillOutFormsPage();	
		fillOutFormsPage.SubmitCapchaForm("1", "");
		List<String> actualListOfMessage = fillOutFormsPage.getListOfMessage();
		Assert.assertEquals(actualListOfMessage.get(0), "Please, fill in the following fields:");
		Assert.assertEquals(actualListOfMessage.get(1), "Message");
		Assert.assertEquals(actualListOfMessage.get(2), "Captcha");
	}
	
	
	
}
