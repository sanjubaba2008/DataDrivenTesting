package com.datadriven.test;

import com.excel.lib.util.Xls_Reader;

public class ExcelOperations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Xls_Reader reader = new Xls_Reader("/Users/sanjubaba2020/Desktop/datadrivenFramework/src/com/testData/orangehrmTestData.xlsx");
		
		
		if(!reader.isSheetExist("Homepage")) {
		   
			reader.addSheet("Homepage");
		}
		int columnCount = reader.getColumnCount("registrationtestdata");
		System.out.println("Total column present = "+columnCount);
		
		System.out.println(reader.getCellRowNum("registrationtestdata", "lastname", "saran"));


	}

}
