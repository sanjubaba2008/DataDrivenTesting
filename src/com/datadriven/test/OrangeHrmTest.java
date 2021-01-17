package com.datadriven.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.utility.TestUtil;

public class OrangeHrmTest {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","/Users/sanjubaba2020/Desktop/selenium/chromedriver" );

		driver = new ChromeDriver();

		String url = "https://www.orangehrm.com/orangehrm-30-day-trial/";
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get(url);
	}
	
	@DataProvider
	public Iterator<Object[]> getTestData() {
		
		 ArrayList<Object[]> testData = TestUtil.getDataFromExcel();
		return testData.iterator();
	}
	
	@Test(dataProvider = "getTestData")
	public void orangeHrmRegPageTest(String firstName, String lastName, String jobTitle, String email, String company, String noOfEmployees, String phoneNumber, String industry, String country) {
		
		driver.findElement(By.xpath("//*[@id=\"Form_submitForm_FirstName\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"Form_submitForm_FirstName\"]")).sendKeys(firstName);
		
		driver.findElement(By.xpath("//*[@id=\"Form_submitForm_LastName\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"Form_submitForm_LastName\"]")).sendKeys(lastName);
		
		driver.findElement(By.xpath("//*[@id=\"Form_submitForm_JobTitle\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"Form_submitForm_JobTitle\"]")).sendKeys(jobTitle);
		
		driver.findElement(By.xpath("//*[@id=\"Form_submitForm_Email\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"Form_submitForm_Email\"]")).sendKeys(email);
		
		driver.findElement(By.xpath("//*[@id=\"Form_submitForm_CompanyName\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"Form_submitForm_CompanyName\"]")).sendKeys(company);

		//driver.findElement(By.xpath("//*[@id=\"Form_submitForm_NoOfEmployees\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"Form_submitForm_NoOfEmployees\"]")).sendKeys(noOfEmployees);
		
		driver.findElement(By.xpath("//*[@id=\"Form_submitForm_Contact\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"Form_submitForm_Contact\"]")).sendKeys(phoneNumber);
		
		//driver.findElement(By.xpath("//*[@id=\"Form_submitForm_Industry\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"Form_submitForm_Industry\"]")).sendKeys(industry);
		
		//driver.findElement(By.xpath("//*[@id=\"Form_submitForm_Country\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"Form_submitForm_Country\"]")).sendKeys(country);
		driver.quit();
	}

}
