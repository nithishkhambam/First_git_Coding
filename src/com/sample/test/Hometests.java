package com.sample.test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.Page;
import com.page.HomePage;
import com.thoughtworks.selenium.webdriven.commands.Highlight;

public class Hometests extends BaseTest {

	@Test( groups="test")
	public void Shopsears_Login_Page() throws InterruptedException, IOException {
		goToWebPage();
		
		HomePage homePage= new HomePage();
		
		homePage.verifyTitle();
		homePage.searchText("Sears Holdings");
		homePage.validateSearchResult();
		
		captureScreenShot();	
		
		
		//driver.quit();

	}
	
	@Test( groups="test")
	public void Shopsears_Login_Page1() throws InterruptedException, IOException {
		goToWebPage();
		
		HomePage homePage= new HomePage();
		
		homePage.verifyTitle();
		homePage.searchText("Sears Holdings");
		homePage.validateSearchResult();
		
		captureScreenShot();	
		
		
		//driver.quit();

	}
	
	private String getMessage(String msg){
		return msg;
	}
	
	@org.junit.Test
	public void testMessage()
	{
		String msg="Hello";
		
		org.junit.Assert.assertEquals("Hello", getMessage(msg));
	}

}
