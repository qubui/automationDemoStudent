package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import TestComponents.BaseTest;
import pageobjects.AutomationHomePage;
import pageobjects.CreateNewAccountPage;
import pageobjects.FillOutFormsPage;
import pageobjects.LoginAutomationPage;
import pageobjects.ProductPage;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import org.testng.Assert;

public class LoginAutomationTest extends BaseTest {


	@Test
	public void VerifyLoginWithEmptyUserNameAndPassword()
	{
		AutomationHomePage automationHomePage = new AutomationHomePage(driver);
		LoginAutomationPage loginAutomationPage = automationHomePage.GotoLoginAutomationPage();
		loginAutomationPage.LoginUnsuccessfully("retrt@gmail.com","tret");
		assertEquals(loginAutomationPage.getErrorText(), "Invalid email or password.");
	}
	
	
	@Test
	public void VerifySignUpSuccessfully()
	{
		String randomFirstname = generateRandomUsername();
		String randomEmail = generateRandomEmail();
		String lastname = "User";
		String pass = "123456678";
		AutomationHomePage automationHomePage = new AutomationHomePage(driver);
		LoginAutomationPage loginAutomationPage = automationHomePage.GotoLoginAutomationPage();
		CreateNewAccountPage createNewAccountPage = loginAutomationPage.GotoCreateNewAccountPage();

		ProductPage productPage = createNewAccountPage.SignUpSuccessfully(randomFirstname, lastname, randomEmail, pass);
		Assert.assertTrue(productPage.isLnkMyDashboardDisplayed());
		Assert.assertTrue(productPage.isTxtSearchDisplayed());
		Assert.assertTrue(productPage.isLnkAllCoursesDisplayed());
		Assert.assertTrue(productPage.isUserNameDisplayed(randomFirstname + " "+"U"));
	}
	
}