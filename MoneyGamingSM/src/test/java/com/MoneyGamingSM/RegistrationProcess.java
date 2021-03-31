package com.MoneyGamingSM;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class RegistrationProcess {

	
	
	@Test()
	public void registrationTest() {
		// Setup chrome driver using maven repository
		WebDriverManager.chromedriver().setup();
		
		//Initializing Chrome driver
		WebDriver driver = new ChromeDriver();
		
		//Application url assign to a varable
		String url = "https://moneygaming.qa.gameaccount.com/";
		
		//Navigate to website
		driver.get(url);
		
		//Maximize the chrome browser 
		driver.manage().window().maximize();
		
		//Initialize implicit wait for webelement
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//Initialize explicit wait for webdriver
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		//Locate webelement joinNow button
		WebElement joinNow=driver.findElement(By.xpath("//a[contains(@class,'newUser')]"));
		
		//Click on JoinNow button using explicit wait condition
		wait.until(ExpectedConditions.elementToBeClickable(joinNow)).click();
		
		
		//Now webdriver is navigating to registration page
		System.out.println("Landing on registration page: " + driver.getTitle());
		
		//Create title webelement
		WebElement title = driver.findElement(By.xpath("//select[@id='title']"));
		
		//Explicit wait is using for title to be clickable
		wait.until(ExpectedConditions.elementToBeClickable(title));
		
		//Declare an object of select class
		Select s = new Select(title);
		
		//Select the first index value of the select object
		s.selectByIndex(1);
		
		//Sending the value to name field
		WebElement name = driver.findElement(By.id("forename"));
		name.sendKeys("Tom");
		
		//Sending the value to surname
		WebElement surname = driver.findElement(By.name("map(lastName)"));
		surname.sendKeys("Cruise");
		
		//Create an webelement for joinNow button
		WebElement joinNowButton = driver.findElement(By.xpath("//input[@value='Join Now!']"));
		
		
		//Click on joinNow button
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		    js.executeScript("arguments[0].click();", joinNowButton);
		    
		//Create an webelement for DOB error    
		WebElement dobError = driver.findElement(By.xpath("//label[@for='dob']"));
		
		//preserve DOB actual value & expected value to  string variable
		String actualDobErrorText = dobError.getText();
		String expectedDobErrorText = "This field is required";
		
		//Asserting the actual & expected value
		Assert.assertEquals(expectedDobErrorText, actualDobErrorText);
		
		//Finally below message will be print to console if the test case executed successfully
		System.out.println("Test Case: 01 executed successfully");
	
		//Driver will close the application finally
		driver.quit();
		
		

	}

}
