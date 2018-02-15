package battsTests;

import org.testng.annotations.Test;

import com.orasi.utils.TestReporter;
import com.orasi.web.WebBaseTest;

import bluesource.LoginPage;

public class UnsuccessfulLogin extends WebBaseTest {
	@Test
	public void testUnsuccessfulLogin() {
		TestReporter.setDebugLevel(2);
		TestReporter.logScenario("Verify an unsuccessful login to BlueSource.");
		TestReporter.logStep("Login using invalid credentials");
		setPageURL("https://bluesourcestaging.herokuapp.com");
		testStart("Unsuccessful Login");
		
		LoginPage loginPage = new LoginPage();
		loginPage.loginFail();
		
		TestReporter.logStep("Verify login failure");
		TestReporter.assertTrue(loginPage.verifyLoginFailure(), "Login failed, Test passed");
	}
}
