package Smoke_test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;

import Data_Functions.Functions;
import Data_Functions.constantData;
import Data_Functions.driverUtil;
import Data_Functions.pageElements;

public class Smoke_test
{
	public static driverUtil util = new driverUtil();
	

	public static void main(String[] args) throws Exception {
		
		    constantData data = new constantData();
		    
		    data.driver = util.chrome();
		
			data.driver.manage().window().maximize();
		
			pageElements elements = new pageElements(data.driver);
			
			Functions functions = new Functions(data,elements);
			
			Data_smoke smoke_data = new Data_smoke();
			
			Cartpage cp = new Cartpage(data,elements,functions);
			
			Login_smoke lp = new Login_smoke(data,elements,functions);
			
			Shippingpage sp = new Shippingpage(data,elements,functions);
			
			Billingpage bp = new Billingpage(data,elements,functions);
			
			Placeorder_page pop = new Placeorder_page(data,elements,functions);
			
			Orderconfirmation oc = new Orderconfirmation(data,elements,functions);
			
			File file = new File("C:\\Users\\UNITS\\Desktop\\out.txt"); //Your file
			
			FileOutputStream fos = new FileOutputStream(file);
			
			PrintStream ps = new PrintStream(fos);
			
			System.setOut(ps);
			
			System.setErr(ps);
			
			System.out.println("\t\t\t\t\t\t\t\t\tSmoke Test Suite");
			
			lp.Login_Loginpage();
			
			lp.Login_Cartpage();
			
			lp.Check_Orderstatus(smoke_data.Orderstatus_Ordernumber, smoke_data.Orderstatus_email,smoke_data.Orderstatus_zipcode);
			
			cp.cart_test();
			
			cp.guestCheckout();
			
			sp.ValidateFields();
						
			sp.Validate_Shippingtable();
			
			sp.Validate_mandatoryfields();
			
			bp.ValidateFields();
			
			bp.Invalid_creditcard();
			
//			bp.Redeem_GC(smoke_data.GC);
			
			bp.ValidatePayment();
			
			pop.Validate_orderdetails();
			
			pop.Validate_orderTotalsplit();
			
			pop.Validate_editlink();
			
			oc.Productdetail();
			
			oc.Shippingdetails();
			
			oc.Billingdetails();
			
			System.out.println("\n\n\n\t\t\t\t\t\t\t\tTest Completed!!!");
			
			data.driver.close();
			
	}
	
}