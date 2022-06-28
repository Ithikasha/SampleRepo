package Load_Testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.*;
import org.testng.annotations.Test;

import Data_Functions.Functions;
import Data_Functions.constantData;
import Data_Functions.driverUtil;
import Data_Functions.pageElements;
import Smoke_test.Data_smoke;

public class NewTest {
	
	public static driverUtil util = new driverUtil();
    
	@Test
    public void ChromeTest1() throws Exception 
    {	 
		constantData data = new constantData();
	    
	    Data_smoke data_smoke = new Data_smoke();
	    		    
	    data.driver = util.chrome();
	
		data.driver.manage().window().maximize();
	
		pageElements elements = new pageElements(data.driver);
		
		Functions functions = new Functions(data,elements);
		
		data.driver.get(data.DEV_url);
		
		util.Click(elements.no);
		
		functions.smoke_login("ithikasha@unitedtechno.com","Ithi@met07");
		
		functions.bulkOrder_testing("Excelsheets","Browser1D.xlsx","07032022",30,"MultiBrowser");
		
//		functions.bulkOrder_International("C:\\Users\\UNITS\\Workspace ithi\\Excel Sheets","Browser1I","28022022",10,"MultiBrowser");
		
		data.driver.close();	
		
    }
    
 
    @Test
 	public void ChromeTest2() throws Exception
 	{ 
    	constantData data = new constantData();
	    
	    Data_smoke data_smoke = new Data_smoke();
	    		    
	    data.driver = util.chrome();
	
		data.driver.manage().window().maximize();
	
		pageElements elements = new pageElements(data.driver);
		
		Functions functions = new Functions(data,elements);
		
		data.driver.get(data.DEV_url);
	
		util.Click(elements.no);
		
		functions.smoke_login("qatest0975@gmail.com","Qatest@met07");
				
//		functions.bulkOrder_testing();
		
		functions.bulkOrder_testing("Excelsheets","Browser2I.xlsx","07032022",30,"MultiBrowser");
		
		data.driver.close();	
 	}
}
