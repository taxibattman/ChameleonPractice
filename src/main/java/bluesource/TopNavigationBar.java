package bluesource;


import org.openqa.selenium.support.FindBy;

import com.orasi.DriverManager;
import com.orasi.web.OrasiDriver;
import com.orasi.web.webelements.Link;
import com.orasi.web.webelements.impl.internal.ElementFactory;

public class TopNavigationBar {
	private OrasiDriver driver = null;
	@FindBy(linkText = "Admin") private Link lnkAdmin;
	@FindBy(linkText = "Titles") private Link lnkTitles;
	@FindBy(linkText = "Message Center") private Link msgCenter;
	@FindBy(linkText = "Calendar") private Link calendar;
	@FindBy(linkText = "Directory") private Link directory;
	@FindBy(linkText = "Projects") private Link lnkProjects;
	@FindBy(linkText = "Employees") private Link employees;
	@FindBy(linkText = "Logout") private Link lnkLogout;
	
	public TopNavigationBar() {
		this.driver = DriverManager.getDriver();
		ElementFactory.initElements(driver, this);
	}
	
	public boolean verifyLogin() {
		return lnkLogout.isDisplayed();	
	}
	
	public void logout() {
		lnkLogout.click();
	}
	
	public void projClk() {
		lnkProjects.click();
	}
	
	public void adminClk() {
		lnkAdmin.click();
	}
	
	public void titleClk() {
		lnkTitles.click();
	}
}
