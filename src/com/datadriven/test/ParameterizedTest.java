package com.datadriven.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.excel.lib.util.Xls_Reader;

public class ParameterizedTest {

	public static void main(String[] args) {
		//launching chrome driver
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","/Users/sanjubaba2020/Desktop/selenium/chromedriver" );

		WebDriver driver = new ChromeDriver();

		String url = "https://www.orangehrm.com/orangehrm-30-day-trial/";
		driver.get(url);
		
		//Data driven approach(parameterization)....used to create data driven framework: driving the test data from excel file
		
		Xls_Reader reader = new Xls_Reader("/Users/sanjubaba2020/Desktop/datadrivenFramework/src/com/testData/orangehrmTestData.xlsx");
		int noOfRows = reader.getRowCount("registrationtestdata");
		System.out.println(noOfRows);
		
		reader.addColumn("registrationtestdata", "status");//adding a new column in excel file
		// parameterization
		for(int i = 2; i <= noOfRows-1; i++) {
			String firstName = reader.getCellData("registrationtestdata","firstname" , i);
			System.out.println(firstName);
			
			String lastName = reader.getCellData("registrationtestdata","lastname" , i);
			System.out.println(lastName);
			
			String jobTitle = reader.getCellData("registrationtestdata","jobTitle" , i);
			System.out.println(jobTitle);
			
			String email = reader.getCellData("registrationtestdata","email" , i);
			System.out.println(email);
			
			String company = reader.getCellData("registrationtestdata","company" , i);
			System.out.println(company);
			
			String noOfEmployees = reader.getCellData("registrationtestdata","noOfEmployees" , i);
			System.out.println(noOfEmployees);
			
			String phoneNumber = reader.getCellData("registrationtestdata",6 , i);
			System.out.println(phoneNumber);
			
			String industry = reader.getCellData("registrationtestdata","industry" , i);
			System.out.println(industry);
			
			String country = reader.getCellData("registrationtestdata","country" , i);
			System.out.println(country);
			
			System.out.println();
			
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
			
			reader.setCellData("registrationtestdata", "status", i , "pass");//write the data into cell
			
		}
		//driver.close();

	}

}
