package Regression;

import Data_Functions.Functions;
import Data_Functions.constantData;
import Data_Functions.driverUtil;
import Data_Functions.pageElements;
import Load_Testing.PDP;

public class Testcase_Updation 
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
			
			Brd_smoke_Test brd = new Brd_smoke_Test(data,elements,functions);
					
//			File file = new File("C:\\Users\\UTIS LAPTOP 38\\Desktop\\Dev_Output"); //Your file
//			
//			FileOutputStream fos = new FileOutputStream(file);
//			
//			PrintStream ps = new PrintStream(fos);
//			
//			System.setOut(ps);
//			
//			System.setErr(ps);
		
//			System.out.println("\t\t\t\t\t\t\t\t\tSmoke Test Suite");
			
			System.out.println("\t\t\t\t\t\t\t\t\tBRD-Site Monitoring");
			
			Regression_data.readTaxableCountries();
			
			Regression_data.readInputs();
//			
//			hp.Pagination();
//			
//			hp.ViewAll();
//			
//			hp.ApplyandRemovefilters();
//			
//			hp.SortBy();
			
			brd.Service_Cloud();
//										
}
	
}
