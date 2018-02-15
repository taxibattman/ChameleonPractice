package bluesource;

import org.openqa.selenium.support.FindBy;

import com.orasi.DriverManager;
import com.orasi.web.OrasiDriver;
import com.orasi.web.webelements.Button;
import com.orasi.web.webelements.Textbox;
import com.orasi.web.webelements.impl.internal.ElementFactory;

public class CreateTitlePage {
	private OrasiDriver driver = null;
	
	@FindBy(id = "title_name") private Textbox txtTitleName;
	@FindBy(css = "#new_title > div.actions > input") private Button btnCreateTitle;
	
	public CreateTitlePage() {
		this.driver = DriverManager.getDriver();
		ElementFactory.initElements(driver, this);
	}
	
	public boolean verifyNewTitleClk() {
		return txtTitleName.isDisplayed();
	}
	
	public void createNewTitle() {
		txtTitleName.sendKeys("Guardian of the Bathroom");
		btnCreateTitle.click();
	}
	
}
