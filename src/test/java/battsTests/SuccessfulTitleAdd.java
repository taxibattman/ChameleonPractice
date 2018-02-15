package battsTests;

import org.testng.annotations.Test;

import com.orasi.utils.TestReporter;
import com.orasi.web.WebBaseTest;

import bluesource.CreateTitlePage;
import bluesource.LoginPage;
import bluesource.TitlesPage;
import bluesource.TopNavigationBar;

public class SuccessfulTitleAdd extends WebBaseTest{
	@Test
	public void testSuccessfulTitleAdd() {
		TestReporter.setDebugLevel(2);
		TestReporter.logScenario("Verify a successful title addition");
		setPageURL("https://bluesourcestaging.herokuapp.com");
		testStart("Successful Title Creation");

		
		TestReporter.logStep("Login with role: company.admin");
		LoginPage loginPage = new LoginPage();
		loginPage.login();
		TopNavigationBar topNav = new TopNavigationBar();
		
		TestReporter.logStep("Verify login");
		TestReporter.assertTrue(topNav.verifyLogin(), "Login Successful");
		
		TestReporter.logStep("Go to Titles page");
		topNav.adminClk();
		topNav.titleClk();
		TitlesPage titlesPage = new TitlesPage();

		TestReporter.logStep("Verify successful navigation to Titles page");
		TestReporter.assertTrue(titlesPage.verifyTitleClk(),"Successfully navigated to Titles page");
		
		TestReporter.logStep("Click 'NewTitle'");
		titlesPage.clickNewTitle();
		
		CreateTitlePage ctPage = new CreateTitlePage();
		TestReporter.logStep("Verify successful navigation to title creation page");
		TestReporter.assertTrue(ctPage.verifyNewTitleClk(), "Successfully navigated to the title creation page");
		
		TestReporter.logStep("Create new title");
		ctPage.createNewTitle();
		
		TestReporter.logStep("Verify title creation");
		TestReporter.assertTrue(titlesPage.verifyNewTitle(), "New title added");
		
		TestReporter.logStep("Logout");
		topNav.logout();
		
		TestReporter.logStep("Verify logout");
		TestReporter.assertTrue(loginPage.verifyLogout(), "Logout successful");

	}
	
}
