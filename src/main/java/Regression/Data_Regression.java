package Regression;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

import Data_Functions.Functions;
import Data_Functions.constantData;

public class Data_Regression {
	
	constantData data_obj;
	
	public boolean result ; 
	
	public static String Result_fileName = "Regression_Results.xlsx";
	
	public String fileName = "Regression_Testing.xlsx";
	
	public String filePath = "C:\\Users\\UNITS\\Workspace ithi\\Excel Sheets";
	
	public static String Result_sheetName = "result";
	
	public String Input_sheetName = "input";
			
	public String URL = "https://www.metallica.com/"; // https://www.metallica.com/ , https://storefront:Frantic81@staging.rockdevelop.com/ , https://storefront:Frantic98@development.rockdevelop.com/
	
	public static String email = "ithikasha@unitedtechno.com " ; //ithikasha@unitedtechno.com , qatest0975@gmail.com
	
	public static String password = "Ithi@utis07" ;  //Ithi@met07 , Qatest@met07
	
	public static String instock1;
	
	public static String instock2;
	
	public static String preorder1;
	
	public static String preorder2;
	
	public static String vinylQ;
	
	public static String vinylA;
	
	public static String Digital1;
	
	public static String Digital2;
	
	public static String[] itemlist;
	
	public static String[] preorderlist;
	
	public static String[] qty = {"1","1"};
	
	public static String[] variant;
	
	public static String firstname = "QA";
	
	public static String lastname = "Tester";
	
	public static String Address1;
	
	public static String City;
	
	public static String State; 
	
	public static String Country; 
	
	public static String Zip_Code;
	
	public static String phone;
	
	public static String paymentMethod;
	
	public String Shipping_Method;
	
	public String orderType;
	
	public int testCount;
	
	public static int DOrders = 3;
	
	public static int IOrders = 3;
	
	public int totalTest = 4;
	
	public static List<String> PDP_price = new ArrayList<>();

	public static List<String> PDP_prdName = new ArrayList<>() ;
	
	public static List<String> CP_price = new ArrayList<>();

	public static List<String> CP_prdName = new ArrayList<>() ;
	
	public static List<String> POP_price = new ArrayList<>();

	public static List<String> POP_prdName = new ArrayList<>() ;
	
	public static List<String> POP_qty = new ArrayList<>() ;
	
	public static List<String> BP_price = new ArrayList<>();

	public static List<String> BP_prdName = new ArrayList<>() ;
	
	public static List<String> BP_qty = new ArrayList<>() ;
	
	public static List<String> OC_price = new ArrayList<>();

	public static List<String> OC_prdName = new ArrayList<>() ;
	
	public static List<String> OC_qty = new ArrayList<>() ;
	
	public String GC = "OQRMKWOSGTZZHDIP";
	
	public static String BP_subtotal;
	
	public static String BP_tax;
	
	public static String BP_total;
	
	public static String POP_subtotal;
	
	public static String POP_tax;
	
	public static String POP_total;
	
	public static String POP_Shipaddress;
	
	public static String POP_Billaddress;
	
	public String Orderstatus_Ordernumber = "00112653" ; //00037027, 00112653
	
	public String Orderstatus_zipcode = "60431-4722";  //60431-4722, 4215 
	
	public String Orderstatus_email = "ithikasha@unitedtechno.com";

	public String orderNumber;

	public int preorder_flag = 0;
	
	public String[] TaxableCountries = {"United States", "United Kingdom", "Germany", "Italy", "Bulgaria", "Croatia"};
	
	public static List<String> TaxableCountryList = new ArrayList<>() ;
	
	public static HashMap<String, String> DAddress = new HashMap<String, String>();
	
	public static HashMap<String, String> IAddress = new HashMap<String, String>();    
	
	public static HashMap<String, String> Address = new HashMap<String, String>();
	
	public static HashMap<String, String> TaxableAddress = new HashMap<String, String>();

	public static HashMap<String, String> NonTaxableAddress = new HashMap<String, String>();

	
	public void readTaxableCountries()
	{
		for(int i = 0; i < TaxableCountries.length; i++)
		{
			TaxableCountryList.add(TaxableCountries[i]);
		}
	}
	
	public void readInputs() throws IOException 
	{
		DataFormatter formatter = new DataFormatter();
		
		File file1 = new File(filePath+"\\"+fileName);
		
		FileInputStream istream = new FileInputStream(file1);
		
		Workbook book = Functions.fileSetup(istream,fileName);
		
		Sheet Address = book.getSheet("Address");
							
		Row Address_row = Address.getRow(1);
		
		DAddress.put("Address1", formatter.formatCellValue(Address_row.getCell(0)));
		
		DAddress.put("City", formatter.formatCellValue(Address_row.getCell(1)));
						
		DAddress.put("Zipcode", formatter.formatCellValue(Address_row.getCell(2)));
		
		DAddress.put("State", formatter.formatCellValue(Address_row.getCell(3)));
		
		DAddress.put("Country", formatter.formatCellValue(Address_row.getCell(4)));
		
		DAddress.put("PhoneNumber", formatter.formatCellValue(Address_row.getCell(5)));
		
		Address_row = Address.getRow(2);
				
		IAddress.put("Address1", formatter.formatCellValue(Address_row.getCell(0)));
		
		IAddress.put("City", formatter.formatCellValue(Address_row.getCell(1)));
		
		IAddress.put("Zipcode", formatter.formatCellValue(Address_row.getCell(2)));
		
		IAddress.put("State", formatter.formatCellValue(Address_row.getCell(3)));
		
		IAddress.put("Country", formatter.formatCellValue(Address_row.getCell(4)));
		
		IAddress.put("PhoneNumber", formatter.formatCellValue(Address_row.getCell(5)));				
						
		Sheet Products = book.getSheet("Products");
		
		Row Products_row = Products.getRow(1);
		
		
		instock1 = formatter.formatCellValue(Products_row.getCell(1));
		
		instock2 = formatter.formatCellValue(Products_row.getCell(2));
		
		Products_row = Products.getRow(2);
		
		preorder1 = formatter.formatCellValue(Products_row.getCell(1));
		
		preorder2 = formatter.formatCellValue(Products_row.getCell(2));
		
		Products_row = Products.getRow(3);
		
		Digital1 = formatter.formatCellValue(Products_row.getCell(1));
		
		Digital2 = formatter.formatCellValue(Products_row.getCell(2));
		
		Products_row = Products.getRow(4);
		
		vinylQ = formatter.formatCellValue(Products_row.getCell(1));
		
		vinylA = formatter.formatCellValue(Products_row.getCell(2));
		
		itemlist[0] = instock1;
		
		itemlist[1] = preorder1;
		
		preorderlist[0] = (preorder1);
		
		preorderlist[1] = (preorder2);
		
	}
	public void readAddresss()
	{
		   
		DAddress.put("Address1", "3610 N Clark St");
		
		DAddress.put("City", "Chicago");
		
		DAddress.put("State", "Illinois");
		
		DAddress.put("Country", "United States");
		
		DAddress.put("Zipcode", "60613-3808");
		
		DAddress.put("PhoneNumber", "9588778855");
				
		IAddress.put("Address1", "407 15th Ave SE");
		
		IAddress.put("City", "Kassel");
		
		IAddress.put("State", "");
		
		IAddress.put("Country", "Germany");
		
		IAddress.put("Zipcode", "34117");
		
		IAddress.put("PhoneNumber", "9588778855");
	}
		
}
