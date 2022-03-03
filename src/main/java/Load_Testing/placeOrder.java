package Load_Testing;

import Data_Functions.Functions;
import Data_Functions.constantData;
import Data_Functions.driverUtil;
import Data_Functions.pageElements;
import Smoke_test.*;




public class placeOrder {
	
	public static driverUtil util = new driverUtil();
	

	public static void main(String args[]) throws Exception {
		
		    constantData data = new constantData();
		    
		    Data_smoke data_smoke = new Data_smoke();
		    		    
		    data.driver = util.chrome();
		
			data.driver.manage().window().maximize();
		
			pageElements elements = new pageElements(data.driver);
			
			Functions functions = new Functions(data,elements);
			
			data.driver.get(data.DEV_url);
			
			
//			data.driver.findElement(By.xpath("//button[@id='details-button']")).click();
//			
//			data.driver.findElement(By.xpath("//a[@id='proceed-link']")).click();
//			
//			
//			if(data.URL == data.STG_url)
//			{
//				util.Click(data.STG_advanced);
				
//				util.Click(data.STG_proceed);
//				}
//			
			util.Click(elements.no);
			
//			functions.InventoryCheck();
			
//			functions.PDPTesting(data.Prod_url);;
//			
//			functions.Date_Time();
//			
//			functions.bulkOrder_testing("Regression");
			
			functions.bulkOrder_testing("C:\\Users\\UNITS\\Workspace ithi\\Excel Sheets","Browser1D","28022022",10,"Regression");

			
			functions.bulkOrder_International("Regression");
			
			data.driver.close();	
			
	}


}
