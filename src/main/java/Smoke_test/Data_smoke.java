package Smoke_test;

import java.util.ArrayList;
import java.util.List;

import Data_Functions.constantData;

public class Data_smoke {
	
	constantData data_obj;
	
	public String URL = "https://storefront:Frantic81@staging.rockdevelop.com/";
	
	public String[] itemlist = {"T101M","ABCBOOK"};
	
	public String[] qty = {"1","1"};
	
	public String email = "qatest0975@gmail.com"; //ithikasha@unitedtechno.com , qatest0975@gmail.com
	
	public String password = "Qatest@met07" ;  //Ithi@met07 , Qatest@met07
	
	public String firstname = "QA" ;
	
	public String lastname = "Tester" ;
	
	public String Address1 = "6255 Sycamore Ln N";
	
	public String City = "Maple Grove";
	
	public String State = "Minnesota"; 
	
	public String Country = "United States"; 
	
	public String Zip_Code = "55369";
	
	public String phone = "9566852589";
	
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
	
	public static String paymentMethod = "Visa";
	
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
