package Regression;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import Data_Functions.Functions;
import Data_Functions.constantData;
import Data_Functions.driverUtil;
import Data_Functions.pageElements;
import Load_Testing.PDP;
import Load_Testing.placeOrder;

public class Regression_test

{
	public static driverUtil util = new driverUtil();
	
	public static void main(String[] args) throws Exception {
		
//		    placeOrder.placeorder();
		
		    constantData data = new constantData();
		    
		    data.driver = util.chrome();
		
			data.driver.manage().window().maximize();
		
			pageElements elements = new pageElements(data.driver);
			
			Data_Regression Regression_data = new Data_Regression();
			
			Functions functions = new Functions(data,elements);
			
			Collect_smokedata collect = new Collect_smokedata(data,elements,functions);
			
			MyAccount_page ma = new MyAccount_page(data, elements, functions);
			
			PDP pdp = new PDP(data, elements, functions);
			
			Cartpage cp = new Cartpage(data,elements,functions);
			
			Login_smoke lp = new Login_smoke(data,elements,functions);
			
			Shippingpage sp = new Shippingpage(data,elements,functions);
			
			Billingpage bp = new Billingpage(data,elements,functions);
			
			Placeorder_page pop = new Placeorder_page(data,elements,functions);
			
			Orderconfirmation oc = new Orderconfirmation(data,elements,functions);
			
			Homepage hp = new Homepage(data,elements,functions);
			
			ContactUsForm ContactUS = new ContactUsForm();
			
//			File file = new File("C:\\Users\\UTIS LAPTOP 38\\Desktop\\Dev_Output"); //Your file
//			
//			FileOutputStream fos = new FileOutputStream(file);
//			
//			PrintStream ps = new PrintStream(fos);
//			
//			System.setOut(ps);
//			
//			System.setErr(ps);
		
			System.out.println("\t\t\t\t\t\t\t\t\tSmoke Test Suite"); 
			
			Regression_data.readTaxableCountries();
			
			Regression_data.readInputs();
			
			hp.Homepage_Links();  
			
			lp.Login_Loginpage();
			
			lp.Login_Invalid();
			
			lp.Login_Cartpage();
//			
//			lp.Check_Orderstatus(Regression_data.Orderstatus_Ordernumber,Regression_data.Orderstatus_email,Regression_data.Orderstatus_zipcode);
			
			ma.MyAccount_Links();
			
			pdp.PDP_Testing();
			
			cp.cart_test();
			
			cp.guestCheckout(); 
			
			sp.ValidateFields(); 
		
			sp.Validate_MandatoryFields(); 
			
			sp.Validate_Table(); 
			
			sp.Validate_ProductTitle(); 
					
			sp.Validate_SavedAddress(); 
			
			sp.Gift_message(); 
			
			sp.UseAddress_checkbox(); 
			
			sp.Preorder_Validation(); 
			
//			sp.VC_Validation(); 
			
			bp.ValidateFields();  
			
			bp.Invalid_creditcard();
			
//          bp.Redeem_GC(smoke_data.GC); 
			
			bp.ValidatePayment(); 
			
			pop.Validate_orderdetails(); 
			
			pop.Validate_orderTotalsplit(); 
			
			boolean flag = true; 
			
			flag = pop.Validate_editlink();  
			
			if(flag)
			{
				oc.Productdetail();					
			}
			
			else
		    
			{
				elements.POviewcart.click();
			}
			
			
//		    System.out.println("\n\n\n\t\t\t\t\t\t\t\tTest-"+smoke_data.testCount+" Completed!!!");
			
			
			util.WaitAndClick(elements.MyAccount); 
			
			util.WaitAndClick(elements.Logout); 
			
			Regression_data.itemlist = null; 
			
			Regression_data.qty = null; 
			
			Regression_data.variant = null; 
						           			
//			System.out.println("Domestic Orders");
			
//			functions.bulkOrder_testing(smoke_data.filePath, smoke_data.Result_fileName, "Regression_DomesticOrders",smoke_data.DOrders);
//			
//			System.out.println();
//			
//			System.out.println("International Orders");
//			
//			functions.bulkOrder_International(smoke_data.filePath, smoke_data.Result_fileName, "Regression_InternationalOrders",smoke_data.IOrders);
//	
			data.driver.close(); 
			
			ContactUS.main(args);
		
	}
	
}
