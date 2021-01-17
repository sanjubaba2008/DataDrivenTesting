package com.test.utility;

import java.util.ArrayList;

import com.excel.lib.util.Xls_Reader;

public class TestUtil {
	
	static Xls_Reader reader;
	
	public static ArrayList<Object[]> getDataFromExcel() {
		
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		try {
			
			reader = new Xls_Reader("/Users/sanjubaba2020/Desktop/datadrivenFramework/src/com/testData/orangehrmTestData.xlsx");
		}
		catch (Exception e ){
			
			e.printStackTrace();
		}
		
		for (int rowCount = 2; rowCount <= reader.getRowCount("registrationtestdata")-1; rowCount++) {
			
			
				
				String firstName = reader.getCellData("registrationtestdata", "firstname", rowCount);
				String lastName = reader.getCellData("registrationtestdata", "lastname", rowCount);
				String jobTitle = reader.getCellData("registrationtestdata", "jobTitle", rowCount);
				String email = reader.getCellData("registrationtestdata", "email", rowCount);
				String company= reader.getCellData("registrationtestdata", "company", rowCount);
				String noOfEmployees = reader.getCellData("registrationtestdata", "noOfEmployees", rowCount);
				String phoneNumber = reader.getCellData("registrationtestdata", "phoneNumber", rowCount);
				String industry = reader.getCellData("registrationtestdata", "industry", rowCount);
				String country = reader.getCellData("registrationtestdata", "country", rowCount);
				
				Object [] obj =  {firstName,lastName,jobTitle,email,company,noOfEmployees,phoneNumber,industry,country};
				myData.add(obj);
			}
			
		return myData;
		
		}

}
