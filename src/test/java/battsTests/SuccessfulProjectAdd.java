package battsTests;

import org.testng.annotations.Test;

import com.orasi.utils.TestReporter;
import com.orasi.web.WebBaseTest;

import bluesource.LoginPage;
import bluesource.ProjectsPage;
import bluesource.TopNavigationBar;

public class SuccessfulProjectAdd extends WebBaseTest{
	@Test
	public void testSuccessfulProjectAdd() {
		TestReporter.logScenario("Verify a successful creation of a new project.");
		
		TestReporter.logStep("Login using role: company.admin");
		setPageURL("https://bluesourcestaging.herokuapp.com");
		testStart("Successful Project Creation");
		
		LoginPage loginPage = new LoginPage();
		loginPage.login();
		TopNavigationBar topNav = new TopNavigationBar();
		TestReporter.logStep("Verify login success");
		TestReporter.assertTrue(topNav.verifyLogin(), "Login Successful");
		
		TestReporter.logStep("Select 'Projects'");
		topNav.projClk();
		
		TestReporter.logStep("Verify successful click");
		ProjectsPage projPage = new ProjectsPage();
		TestReporter.assertTrue(projPage.verifyProjBtnClk(),"Successful 'Project' button click");
		
		TestReporter.logStep("Select 'Add' button");
		projPage.addClick();
		
		TestReporter.logStep("Verify successful add click");
		TestReporter.assertTrue(projPage.verifyAddFormDisplay(), "Form displayed");
		
		TestReporter.logStep("Fill out form");
		projPage.fillForm();
		TestReporter.assertTrue(projPage.verifyNewProject(), "Project Created");
		
		TestReporter.logStep("Logout");
		topNav.logout();
		
		TestReporter.logStep("Verify logout success");
		TestReporter.assertTrue(loginPage.verifyLogout(), "Logout Successful");

	}
}
