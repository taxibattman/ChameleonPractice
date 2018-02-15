package battsTests;

import org.testng.annotations.Test;

import com.orasi.utils.TestReporter;
import com.orasi.web.WebBaseTest;

import bluesource.LoginPage;
import bluesource.TitlesPage;
import bluesource.TopNavigationBar;

public class SuccessfulTitleEdit extends WebBaseTest{
	@Test
	public void testSuccessfulTitleEdit() {
		TestReporter.setDebugLevel(2);
		TestReporter.logScenario("Verify a successful title edit");
		setPageURL("https://bluesourcestaging.herokuapp.com");
		testStart("Successful Title Edit");
		LoginPage loginPage = new LoginPage();
		
		TestReporter.logStep("Login");
		loginPage.login();
		TopNavigationBar topNav = new TopNavigationBar();
		
		TestReporter.logStep("Verify Login");
		topNav.verifyLogin();
		
		TestReporter.logStep("Navigate to Titles page");
		topNav.adminClk();
		topNav.titleClk();
		TitlesPage titlesPage = new TitlesPage();
		
		TestReporter.logStep("Verify Successful navigation to Titles page");
		titlesPage.verifyTitleClk();
		
		TestReporter.logStep("Click edit icon");
		
		
		TestReporter.logStep("Verify successful navigation to Edit Title page");
		
		TestReporter.logStep("Edit title");
		
		TestReporter.logStep("Verify title was edited");
		
		TestReporter.logStep("Logout");
		
		TestReporter.logStep("Verify Logout");

		
	}
}
