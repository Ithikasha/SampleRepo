package Load_Testing;

import Data_Functions.Functions;
import Data_Functions.constantData;
import Data_Functions.driverUtil;
import Data_Functions.pageElements;
import Smoke_test.Data_smoke;

public class createAccount {
	
	public static driverUtil util = new driverUtil();
	
	public static void main(String[] args) throws Exception {
		
		constantData data = new constantData();
		
		Data_smoke data_smoke = new Data_smoke();
		
		data.driver = util.chrome();
		
		data.driver.manage().window().maximize();
	
		pageElements elements = new pageElements(data.driver);
		
		Functions functions = new Functions(data,elements, data_smoke);
		
		data.driver.get(data.DEV_url);
		
		util.Click(elements.no);
		
		functions.createAccount();
		
	}

}
