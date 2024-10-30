package tests;


import org.testng.annotations.Test;
import TestComponents.BaseTest;
import pageobjects.AutomationHomePage;
import pageobjects.FakePricingPage;


import java.util.Arrays;
import java.util.List;

import org.testng.Assert;

public class FakePricingPageTest extends BaseTest {

	public static final String invalidMessage = "email or password is invalid675765767";
	@Test
	public void VerifyNotAvailableBenefitForEachModel() throws InterruptedException
	{
		List<String> UnavailableBenefitsForFreeTrial = Arrays.asList("Labore et dolore magna aliqu", "Ut enim ad minim veniam", "Quis nostrud exe adipiscing");
		List<String> UnavailableBenefitsForBasic = Arrays.asList("Ut enim ad minim veniam", "Quis nostrud exe adipiscing");
		List<String> BenefitsForEnterprise = Arrays.asList("Lorem ipsum dolor sit amet","Consectetur adipiscin do","Eiusmod tempor incididunt ut","Labore et dolore magna aliqu","Ut enim ad minim veniam","Quis nostrud exe adipiscing");
		AutomationHomePage automationHomePage = new AutomationHomePage(driver);
		FakePricingPage fakePricingPage = automationHomePage.GotoFakePricingPage();
		Assert.assertTrue(fakePricingPage.AreUnavailableBenefitsPerModel(0, UnavailableBenefitsForFreeTrial));
		Assert.assertTrue(fakePricingPage.AreUnavailableBenefitsPerModel(80, UnavailableBenefitsForBasic));
		Assert.assertTrue(fakePricingPage.AreAvailableBenefitsPerModel(900, BenefitsForEnterprise));

	}
	
}
