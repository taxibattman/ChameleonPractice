package com.orasi.core;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.orasi.core.interfaces.Listbox;
import com.orasi.core.interfaces.impl.ListboxImpl;
import com.orasi.utils.TestEnvironment;

public class TestListbox extends TestEnvironment{
    @BeforeTest(groups ={"regression", "interfaces", "listbox", "dev"})
    @Parameters({ "runLocation", "browserUnderTest", "browserVersion",
	    "operatingSystem", "environment" })
    public void setup(@Optional String runLocation, String browserUnderTest,
	    String browserVersion, String operatingSystem, String environment) {
	setApplicationUnderTest("Test Site");
	setBrowserUnderTest(browserUnderTest);
	setBrowserVersion(browserVersion);
	setOperatingSystem(operatingSystem);
	setRunLocation(runLocation);
	setTestEnvironment(environment);
	setPageURL("http://orasi.github.io/Selenium-Java-Core/sites/unitTests/orasi/core/interfaces/listbox.html");
	testStart("TestListbox");
    }
    
    @AfterTest(groups ={"regression", "interfaces", "listbox", "dev"})
    public void close(){
	endTest("TestListbox");
    }

      
    @Test(groups ={"regression", "interfaces", "listbox"})
    public void isMultiple(){
	Listbox listbox= new ListboxImpl(getDriver().findElement(By.id("multiSelect")));
	Assert.assertTrue(listbox.isMultiple());
    }
    
    @Test(groups ={"regression", "interfaces", "listbox"})
    public void select(){
	Listbox listbox= new ListboxImpl(getDriver().findElement(By.id("singleSelect")));
	listbox.select("Sports");
	Assert.assertTrue(listbox.getFirstSelectedOption().getText().equals("Sports"));
    }
    
    @Test(groups ={"regression", "interfaces", "listbox"}, dependsOnMethods="select")
    public void getAllSelectedOptions(){
	Listbox listbox= new ListboxImpl(getDriver().findElement(By.id("singleSelect")));
	Assert.assertTrue(listbox.getAllSelectedOptions().get(0).getText().equals("Sports"));
    }
    
    @Test(groups ={"regression", "interfaces", "listbox"}, dependsOnMethods="getAllSelectedOptions")
    public void isSelected(){
	Listbox listbox= new ListboxImpl(getDriver().findElement(By.id("singleSelect")));
	Assert.assertTrue(listbox.isSelected("Sports"));
    }
    
    @Test(groups ={"regression", "interfaces", "listbox"}, dependsOnMethods="isSelected")
    public void deselectByVisibleText(){
	Listbox listbox= new ListboxImpl(getDriver().findElement(By.id("multiSelect")));
	listbox.select("Baseball");
	Assert.assertTrue(listbox.isSelected("Baseball"));
	listbox.deselectByVisibleText("Baseball");
	Assert.assertFalse(listbox.isSelected("Baseball"));
    }
    
    @Test(groups ={"regression", "interfaces", "listbox"}, dependsOnMethods="deselectByVisibleText")
    public void deselectAll(){
	Listbox listbox= new ListboxImpl(getDriver().findElement(By.id("multiSelect")));
	listbox.select("Basketball");
	listbox.select("Soccer");
	listbox.deselectAll();
	Assert.assertNull(listbox.getFirstSelectedOption());
    }
    
}
