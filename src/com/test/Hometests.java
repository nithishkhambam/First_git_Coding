package com.test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Hometests {

	private WebDriver driver;

	@BeforeMethod
	public void intializeDriver() throws MalformedURLException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\chromedriver\\chromedriver.exe");
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities = DesiredCapabilities.chrome();
		ChromeOptions options = new ChromeOptions();
		//options.addArguments("start-maximized");
		String hubUrl = "http://"+"127.0.01:4444//wd/hub";
		/*Map<String, String> mobileEmulation = new HashMap<String, String>();
		mobileEmulation.put("deviceName", "Apple iPhone 5");

		Map<String, Object> chromeOptions = new HashMap<String, Object>();
		chromeOptions.put("mobileEmulation", mobileEmulation);
		
		desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);*/
		
		
		desiredCapabilities.setCapability(ChromeOptions.CAPABILITY,options);
		driver = new RemoteWebDriver(new URL(hubUrl),desiredCapabilities);
		/*Dimension dm = new Dimension(400, 700);
		driver.manage().window().setSize(dm);*/

	}

	@Test( groups="test")
	public void Shopsears_Login_Page() throws InterruptedException {
		driver.get("https://www.google.com");
		Thread.sleep(10000);
		driver.quit();

	}

}
