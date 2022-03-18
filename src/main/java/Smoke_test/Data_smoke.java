package Smoke_test;

import java.util.ArrayList;
import java.util.List;

import Data_Functions.constantData;

public class Data_smoke {
	
	constantData data_obj;
	
	public boolean result ; 
	
	public static String fileName = "Smoke_Testing.xlsx";
	
	public static String filePath = "C:\\Users\\UNITS\\Workspace ithi\\Excel Sheets";
	
	public static String sheetName = "result";
	
	public static String Input_sheetName = "input";
			
	public static String URL = "https://www.metallica.com/"; // https://www.metallica.com/ , https://storefront:Frantic81@staging.rockdevelop.com/ , https://storefront:Frantic98@development.rockdevelop.com/
	
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
	
	public static String Shipping_Method;
	
	public static String orderType;
	
	public static int testCount;
	
	public static int totalTest = 4;
	
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
	
	public static String Orderstatus_Ordernumber = "00037027" ; //00037027, 00112653
	
	public static String Orderstatus_zipcode = "4215";  //60431-4722, 4215 
	
	public static String Orderstatus_email = "ithikasha@unitedtechno.com";

	public static String orderNumber;

	public int preorder_flag = 0;
	
}
