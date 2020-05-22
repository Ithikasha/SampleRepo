package Load_Testing;

import org.openqa.selenium.By;

import Data_Functions.*;

public class placeOrder {
	
	public static driverUtil util = new driverUtil();
	

	public static void main(String[] args) throws Exception {
		
		    constantData data = new constantData();
		    
		   // data.URL = data.STG_url ; // Setting to DEV or STG for testing 
		    
		    data.driver = util.chrome();
		
			data.driver.manage().window().maximize();
		
			pageElements elements = new pageElements(data.driver);
			
			Functions functions = new Functions(data,elements);
			
			data.driver.get(data.DEV_url);
			
//			data.driver.findElement(By.xpath("//button[@id='details-button']")).click();
//			
//			data.driver.findElement(By.xpath("//a[@id='proceed-link']")).click();
//			
//			data.STG_advanced.click();
//			
//			data.STG_proceed.click();
			
//			if(data.URL == data.STG_url)
//			{
////				util.Click(data.STG_advanced);
////				
////				util.Click(data.STG_proceed);
//				}
			
			util.Click(elements.no);
			
			functions.bulkOrder_testing();
			
			data.driver.close();	
			
	}


}
