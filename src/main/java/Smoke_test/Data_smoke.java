package Smoke_test;

import java.util.ArrayList;
import java.util.List;

import Data_Functions.constantData;

public class Data_smoke {
	
	constantData data_obj;
	
	boolean result ; 
	
	public String fileName = "Smoke_Testing.xlsx";
	
	public String filePath = "C:\\Users\\UNITS\\Workspace ithi\\Excel Sheets";
	
	public String sheetName = "result";
	
	public String Input_sheetName = "input";
			
	public String URL = "https://storefront:Frantic81@staging.rockdevelop.com/";
	
	public static String email ; //ithikasha@unitedtechno.com , qatest0975@gmail.com
	
	public static String password ;  //Ithi@met07 , Qatest@met07
	
	public static String[] itemlist;
	
	public static String[] qty;
	
	public static String[] variant;
	
	public static String firstname = "QA";
	
	public static String lastname = "Tester";
	
	public static String Address1;
	
	public static String City ;
	
	public static String State; 
	
	public static String Country ; 
	
	public static String Zip_Code;
	
	public static String phone ;
	
	public static String paymentMethod;
	
	public String Shipping_Method;
	
	public String orderType;
	
	public int testCount;
	
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
	
	public String Orderstatus_Ordernumber = "00032412" ;
	
	public String Orderstatus_zipcode = "55369-6322";
	
	public String Orderstatus_email = "qatest0975@gmail.com";

	public String orderNumber;
	
}
