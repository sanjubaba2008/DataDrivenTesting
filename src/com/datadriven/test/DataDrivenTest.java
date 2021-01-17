package com.datadriven.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.excel.lib.util.Xls_Reader;

public class DataDrivenTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
        //get test data from excel file
		Xls_Reader reader = new Xls_Reader("/Users/sanjubaba2020/Desktop/datadrivenFramework/src/com/testData/orangehrmTestData.xlsx");
		
		String firstName = reader.getCellData("registrationtestdata","firstname" , 2);
		System.out.println(firstName);
		
		String lastName = reader.getCellData("registrationtestdata","lastname" , 2);
		System.out.println(lastName);
		
		String jobTitle = reader.getCellData("registrationtestdata","jobTitle" , 2);
		System.out.println(jobTitle);
		
		String email = reader.getCellData("registrationtestdata","email" , 2);
		System.out.println(email);
		
		String company = reader.getCellData("registrationtestdata","company" , 2);
		System.out.println(company);
		
		String noOfEmployees = reader.getCellData("registrationtestdata","noOfEmployees" , 2);
		System.out.println(noOfEmployees);
		
		String phoneNumber = reader.getCellData("registrationtestdata",6 , 2);
		System.out.println(phoneNumber);
		
		String industry = reader.getCellData("registrationtestdata","industry" , 2);
		System.out.println(industry);
		
		String country = reader.getCellData("registrationtestdata","country" , 2);
		System.out.println(country);
		
		
		
		System.setProperty("webdriver.chrome.driver","/Users/sanjubaba2020/Desktop/selenium/chromedriver" );

		WebDriver driver = new ChromeDriver();

		String url = "https://www.orangehrm.com/orangehrm-30-day-trial/";
		driver.get(url);
		
		 
		
		//Select select = new Select(driver.findElement(By.xpath("//*[@id=\"Form_submitForm_NoOfEmployees\"]")));
		//select.selectByVisibleText(noOfEmployees);
		
		
	}

}
