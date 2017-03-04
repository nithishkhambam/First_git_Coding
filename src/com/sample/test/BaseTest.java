package com.sample.test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;

public class BaseTest implements IRetryAnalyzer{

	public static WebDriver driver;
	
	@BeforeMethod
	public void intializeDriver() throws MalformedURLException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\chromedriver\\chromedriver.exe");
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities = DesiredCapabilities.chrome();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		String hubUrl = "http://"+"127.0.0.1:4444//wd/hub";
		/*Map<String, String> mobileEmulation = new HashMap<String, String>();
		mobileEmulation.put("deviceName", "Apple iPhone 5");

		Map<String, Object> chromeOptions = new HashMap<String, Object>();
		chromeOptions.put("mobileEmulation", mobileEmulation);
		
		desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);*/
		
		
		desiredCapabilities.setCapability(ChromeOptions.CAPABILITY,options);
		driver = new RemoteWebDriver(new URL(hubUrl),desiredCapabilities);
		/*Dimension dm = new Dimension(400, 700);
		driver.manage().window().setSize(dm);*/
		//driver.manage().window().maximize();
	}
	
	protected void captureScreenShot() throws IOException
	{
		DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yy__hh_mm_ssaa");
		String destDir = "C:\\Users\\nnithis\\Desktop\\Automation Screenshots\\"
				+ "  "
				+ dateFormat.format(new Date())
				+ "  "
				+ "Sears"
				+ " "
				+ "Guest" + " " + "Flow" + " " + "Screenshots";
		File scrFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		new File(destDir).mkdirs();
		String destFile = dateFormat.format(new Date()) + ".png";
		FileUtils.copyFile(scrFile, new File(destDir + "/" + destFile));
		System.out.println("Screenshot Taken");
	}
	
	public void goToWebPage() throws InterruptedException
	{
		driver.get("https://www.google.co.in");
		//Thread.sleep(5000);
		try{
			System.out.println("One way of looking for Page Lood");
		System.out.println((String)((JavascriptExecutor) driver).executeScript("return document.readyState"));
		Thread.sleep(1000);
		System.out.println((String)((JavascriptExecutor) driver).executeScript("return document.readyState"));
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		//Explicit Wait -- Creating WebDriverWait Object to wait until Expected condition return true in 10 seconds
		//This is Alternative for Thread.Sleep
		//Each 500 seconds polling is happend by caling Expected condition
		WebElement myDynamicElement = (new WebDriverWait(driver, 10))
				  .until(ExpectedConditions.presenceOfElementLocated(By.id("hplogo")));
		
	}
	
	public static WebDriver getDriver()
	{
		return driver;
	}
	
	private int count=0; 
	private int retry=3;

	public boolean retry(ITestResult paramITestResult) {
		if(count<retry)
		{
			count++;
			return true;
		}
		return false;
	}
}
