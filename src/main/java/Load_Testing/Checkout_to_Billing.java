package Load_Testing;
import Data_Functions.*;
import Smoke_test.*;

public class Checkout_to_Billing {
//	Use Checkout_Billing.xlsx file
public static driverUtil util = new driverUtil();
	
	public static void main(String[] args) throws Exception {
		
		constantData data = new constantData();
	    
	    Data_smoke data_smoke = new Data_smoke();
	    		    
	    data.driver = util.chrome();
	
		data.driver.manage().window().maximize();
	
		pageElements elements = new pageElements(data.driver);
		
		Functions functions = new Functions(data,elements);
		
		data.driver.get(data.DEV_url);
		
		util.Click(elements.no);
		
		functions.CHKT_Billing();
		
		data.driver.close();

	}
}
