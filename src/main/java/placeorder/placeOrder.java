package placeorder;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.sikuli.script.FindFailed;
import placeorder.pageElements;
import placeorder.driverUtil;

public class placeOrder {
	
	public static driverUtil util = new driverUtil();
	

	public static void main(String[] args) throws Exception {
		
		    constantData data = new constantData();
		    
		    data.driver = util.chrome();
		
			data.driver.manage().window().maximize();
		
			pageElements elements = new pageElements(data.driver);
			
			Functions functions = new Functions(data,elements);
			
			data.driver.get(data.DEV_url);
			
			util.Click(elements.no);
			
			functions.bulkOrder_testing();
			
			data.driver.close();	
			
	}


}
