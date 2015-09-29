package com.orasi.core;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.orasi.core.interfaces.Button;
import com.orasi.core.interfaces.Link;
import com.orasi.core.interfaces.impl.ButtonImpl;
import com.orasi.core.interfaces.impl.ElementImpl;
import com.orasi.core.interfaces.impl.LinkImpl;
import com.orasi.utils.Sleeper;
import com.orasi.utils.TestEnvironment;


public class TestLink extends TestEnvironment {
    
    @BeforeTest(groups ={"regression", "interfaces", "link", "dev"})
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
	setPageURL("http://orasi.github.io/Selenium-Java-Core/sites/unitTests/orasi/core/interfaces/link.html");
	testStart("TestLink");
    }
    
    @AfterTest(groups ={"regression", "interfaces", "link", "dev"})
    public void close(){
	endTest("TestLink");
    }

    @Test(groups ={"regression", "interfaces", "link"}, dependsOnMethods="getURL")
    public void click(){
	Link link= new LinkImpl(getDriver().findElement(By.xpath("//a[@href='testLinks.html']")));
	link.click();
	Assert.assertTrue(new ElementImpl(getDriver().findElement(By.xpath("//a[@href='link.html']"))).syncVisible(getDriver()));
	}
    
    @Test(groups ={"regression", "interfaces", "link"}, dependsOnMethods="click")
    public void jsClick(){
	Link link= new LinkImpl(getDriver().findElement(By.xpath("//a[@href='link.html']")));
	link.jsClick(getDriver());
	Assert.assertTrue(new ElementImpl(getDriver().findElement(By.xpath("//a[@href='testLinks.html']"))).syncVisible(getDriver()));
    }
    
    @Test(groups ={"regression", "interfaces", "link"})
    public void getURL(){
	Link link= new LinkImpl(getDriver().findElement(By.xpath("//a[@href='testLinks.html']")));
	Assert.assertTrue(link.getURL().contains("testLinks.html"));
    }
}
