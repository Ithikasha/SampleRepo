package Load_Testing;

import Data_Functions.Functions;
import Data_Functions.constantData;
import Data_Functions.driverUtil;
import Data_Functions.pageElements;

public class Login {
//	Use Login.xlsx file
public static driverUtil util = new driverUtil();
	
	public static void main(String[] args) throws Exception {
		
		constantData data = new constantData();
		
		data.driver = util.chrome();
		
		data.driver.manage().window().maximize();
	
		pageElements elements = new pageElements(data.driver);
		
		Functions functions = new Functions(data,elements);
		
		data.driver.get(data.DEV_url);
		
		util.Click(elements.no);
		
		functions.Validate_Login();
		
		data.driver.close();
	
	}

}
