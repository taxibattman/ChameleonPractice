package bluesource;

import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import com.orasi.DriverManager;
import com.orasi.web.OrasiDriver;
import com.orasi.web.webelements.Button;
import com.orasi.web.webelements.Listbox;
import com.orasi.web.webelements.Textbox;
import com.orasi.web.webelements.impl.internal.ElementFactory;

public class ProjectsPage {
	private OrasiDriver driver = null;
	
	@FindBy(name = "button") private Button btnAdd; 
	@FindBy(id = "search-bar") private Textbox txtSearch;
	@FindBy(id = "project_name") private Textbox txtProjName;
	@FindBy(id = "project_client_partner_id") private Listbox selClientPartner;
	@FindBy(id = "add-team-lead") private Button btnAddTeamLead;
	@FindBy(id = "project_status") private Listbox selProjStatus;
	@FindBy(id = "project_start_date") private Textbox txtStartDate;
	@FindBy(id = "project_end_date") private Textbox txtEndDate;
	@FindBy(name = "commit") private Button btnCreateProj;
	
	public ProjectsPage() {
		this.driver = DriverManager.getDriver();
		ElementFactory.initElements(driver, this);
	}
	
	public boolean verifyProjBtnClk() {
		return btnAdd.isDisplayed();
	}
	
	public void addClick() {
		btnAdd.click();
	}
	
	public boolean verifyAddFormDisplay() {
		return driver.findElement(By.id("new_project")).syncVisible(5);
	}
	
	public void fillForm() {
		txtProjName.sendKeys("New Project");
		selClientPartner.select("123 1234");
		selProjStatus.select("Active");
		txtStartDate.sendKeys("02192018");
		txtEndDate.sendKeys("02282018");
		btnCreateProj.click();
	}
	
	public boolean verifyNewProject() {
		return driver.findElement(By.cssSelector("div.alert.alert-success.alert-dismissable")).isDisplayed();
		
	}
	
}
