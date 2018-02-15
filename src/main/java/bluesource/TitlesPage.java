package bluesource;

import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import com.orasi.DriverManager;
import com.orasi.web.OrasiDriver;
import com.orasi.web.webelements.Link;
import com.orasi.web.webelements.Webtable;
import com.orasi.web.webelements.impl.internal.ElementFactory;

public class TitlesPage {
	private OrasiDriver driver = null;
	
	@FindBy(css = "#content > table") private Webtable tblTitles;
	@FindBy(linkText = "New Title") private Link lnkNewTitle;
	
	public TitlesPage() {
		this.driver = DriverManager.getDriver();
		ElementFactory.initElements(driver, this);
	}
	
	public boolean verifyTitleClk() {
		return tblTitles.isDisplayed();
	}
	
	public void clickNewTitle() {
		lnkNewTitle.click();
	}
	
	public boolean verifyNewTitle() {
		return driver.findElement(By.cssSelector("div.alert.alert-success.alert-dismissable")).isDisplayed();
	}
	
	
	
	
	
	
}
