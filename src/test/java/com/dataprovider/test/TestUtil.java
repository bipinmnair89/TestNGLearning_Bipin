package com.dataprovider.test;

import java.util.ArrayList;

import org.openqa.selenium.By;

public class TestUtil {
	static Xls_Reader reader;
	
	
	public static ArrayList<Object[]> getDataFromExcel(){

			ArrayList<Object[]> myData = new ArrayList<Object[]>();
			
			try {
				reader = new Xls_Reader("D:/Learning//ExcelGallery//AddressDetails.xlsx"); //giving the excel sheet path
			} catch (Exception e) {    //try catch block to print exception if tomm excel file is not available
				e.printStackTrace();
			}
			
			for (int rowNum = 2; rowNum <= reader.getRowCount("Sheet1"); rowNum++) { //rownum=2 as rownum 1 will be having headings
				
					String fullName = reader.getCellData("Sheet1", "Fullname", rowNum);
					String phoneNumber = reader.getCellData("Sheet1", "PhoneNumber", rowNum);
					String pincode = reader.getCellData("Sheet1", "Pincode", rowNum);
					String streetAddress = reader.getCellData("Sheet1", "Street Address", rowNum);
					String city = reader.getCellData("Sheet1", "City", rowNum);

					Object ob[] = {fullName, phoneNumber, pincode, streetAddress, city};
					myData.add(ob);
					
			}
			return myData;
	}

}

