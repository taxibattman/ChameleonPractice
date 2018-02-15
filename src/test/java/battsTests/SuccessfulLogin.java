package battsTests;

import org.testng.annotations.Test;
import com.orasi.utils.TestReporter;
import com.orasi.web.WebBaseTest;

import bluesource.LoginPage;
import bluesource.TopNavigationBar;

public class SuccessfulLogin extends WebBaseTest{
	@Test
	public void testSuccessfulLogin() {
		TestReporter.setDebugLevel(2);
		TestReporter.logScenario("Verify a successful login to BlueSource.");
		TestReporter.logStep("Login to BlueSource using role: company.admin");
		setPageURL("https://bluesourcestaging.herokuapp.com");
		testStart("Successful Login");
		
		LoginPage loginPage = new LoginPage();
		loginPage.login();
		TopNavigationBar topNav = new TopNavigationBar();
		
		TestReporter.logStep("Verify login");
		TestReporter.assertTrue(topNav.verifyLogin(), "Login Success");
		
		TestReporter.logStep("Logout");
		topNav.logout();
		
		TestReporter.logStep("Verify logout");
		TestReporter.assertTrue(loginPage.verifyLogout(), "Logout Success");
		
	}
	
}
