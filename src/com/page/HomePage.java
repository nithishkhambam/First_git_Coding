package com.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;

public class HomePage extends BasePage {
	
	//WebElement userIdWebElement = driver.findElement(By.id("userId"));
	//WebElement passwordWebElement = driver.findElement(By.id("password"));
	WebElement searchTextBox= driver.findElement(By.id("lst-ib"));
	
	public void verifyTitle(){
		 Assert.assertEquals(driver.getTitle(), "Google");
		 //Assert.assertSame(driver.getTitle(), "Google");
		 Reporter.log("Google page is verified");
	}
	
	public void searchText(String text) throws InterruptedException
	{
		searchTextBox.sendKeys(text);
		searchTextBox.sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		Reporter.log("Search term is entered");
	}
	
	public void validateSearchResult() throws InterruptedException
	{

		int x = driver.findElement(By.id("navcnt")).getLocation().getX();
		int y = driver.findElement(By.id("navcnt")).getLocation().getX();
		/*((JavascriptExecutor)driver).executeScript("window.scrollBy("+x+","+y+");");
		*/
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.id("navcnt")));
		Thread.sleep(5000);
	}

}
