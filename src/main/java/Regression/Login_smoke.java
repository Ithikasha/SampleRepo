package Regression;

import org.openqa.selenium.By;

import Data_Functions.Functions;
import Data_Functions.constantData;
import Data_Functions.driverUtil;
import Data_Functions.pageElements;

public class Login_smoke {
	
	public driverUtil util = new driverUtil();
	constantData data_obj;
	pageElements element_obj;
	Functions func ;
	Data_Regression data_regression = new Data_Regression();
	
	public Login_smoke(constantData data,pageElements elem,Functions functions)
	   {
		   data_obj=data;
		   element_obj=elem;
		   func= functions;
	   }
	
	
	
	public void Login_Loginpage() throws Exception
	{
		System.out.println("\nLoginpage");
		
		System.out.println("\tRegression Testing: Login from Loginpage");

		System.out.println("\t\tTestcase - 9");
		
//	      data_obj.driver.get(data_regression.URL);
//		
//		  if(util.Isdisplayed(element_obj.no))
//		  {
//			util.Click(element_obj.no);
//		  }
		
		func.smoke_login(data_regression.email, data_regression.password);
		
		if(util.Isdisplayed(data_obj.driver.findElement(By.xpath("//h1[@class='overview-header account-primary-heading'] "))))
		{
			System.out.println("\t\t\tLoginpage - Login Successful for "+data_regression.email);
			
			data_regression.result = true;
			
			func.write_Regressiontest(data_regression.result, 9);
		}
		
		else
		{
			System.out.println("\t\t\tLoginpage - Login Unsuccessful for "+data_regression.password);
			
			data_regression.result = false;
			
			func.write_Regressiontest(data_regression.result, 9);
		}

//		util.WaitAndClick(element_obj.MyAccount);
						
		util.WaitAndClick(element_obj.MyAccountPageLogout);
		
//		data_obj.driver.close();
		
	}
	
	public void Login_Invalid() throws Exception
	{
		System.out.println("\tRegression Testing: Login with Invalid Credentials");
		
		System.out.println("\t\tTestcase - 10");
		
	    int fail = 0;
		
		func.smoke_login("ithikash@unitedtechno.com","Ithi@met0" );
		
		if(util.Isdisplayed(data_obj.driver.findElement(By.xpath("//div[@class='error-form']"))))
		{
			System.out.println("\t\t\tLoginpage - Login failed with Invalid Email - Successful");
			
		}
		
		else
		{
			System.out.println("\t\t\tLoginpage - Logged in with Invalid Email - UnSuccessful");
			
			fail++;
		}
		
		func.smoke_login("ithikasha@unitedtechno.com","ithi@met07" );
		
		if(util.Isdisplayed(data_obj.driver.findElement(By.xpath("//div[@class='error-form']"))))
		{
			System.out.println("\t\t\tLoginpage - Login failed with Invalid Password - Successful");
			
		}
		
		else
		{
			System.out.println("\t\t\tLoginpage - Logged in with Invalid Password - UnSuccessful");
			
			fail++;
		}
		
		func.smoke_login("ithikash@unitedtechno.com","ithi@met07" );
		
		if(util.Isdisplayed(data_obj.driver.findElement(By.xpath("//div[@class='error-form']"))))
		{
			System.out.println("\t\t\tLoginpage - Login failed with Invalid Email and Password - Successful");
			
		}
		
		else
		{
			System.out.println("\t\t\tLoginpage - Logged in with Invalid Email and Password - UnSuccessful");
			
			fail++;
		}
		
		if(fail==0)
		{
			System.out.println("\t\t\tLoginpage - Login with Invalid Credentials - Successful");
			
			data_regression.result = true;
			
			func.write_Regressiontest(data_regression.result, 10);
		}
		
		else
		{
			System.out.println("\t\t\tLoginpage - Login with Invalid Credentials - Unsuccessful");
			
			data_regression.result = false;
			
			func.write_Regressiontest(data_regression.result, 10);
		}
	}
	
	public void Login_Cartpage() throws Exception
	{
		System.out.println("\tRegression Testing: Login from Cartpage");
		
		System.out.println("\t\tTestcase - 11");
		
		data_obj.driver.get(data_regression.URL);
		
//		if(element_obj.no.isDisplayed())
//		{
//		
//		util.Click(element_obj.no);
//		
//		}
			
		func.Add_product(data_regression.itemlist, data_regression.qty);
		
//		util.WaitAndClick(element_obj.viewcart);
		
//		element_obj.viewcart.click();
		
		element_obj.email.clear();
		
		element_obj.email.sendKeys(data_regression.email);
		
		element_obj.password.clear();
		
		element_obj.password.sendKeys(data_regression.password);
		
		util.WaitAndClick(element_obj.Cart_CO);
		
		if(util.Isdisplayed(data_obj.driver.findElement(By.xpath("//div[@class='shipping-header']"))))
		{
			System.out.println("\t\t\tCartpage - Login Successful for "+data_regression.email);
			
			data_regression.result = true;
			
			func.write_Regressiontest(data_regression.result, 11);
		}
		else
		{
			System.out.println("\t\t\tCartpage - Login Unsuccessful for "+data_regression.email);
			
			data_regression.result = false;
			
			func.write_Regressiontest(data_regression.result, 11);
		}
		
		element_obj.POviewcart.click();
		

		for(int c = 1; c <= data_regression.itemlist.length; c++)
		{			
			
			util.WaitAndClick(element_obj.remove);

		}
		
		util.Click(element_obj.srch);
		
		util.Click(element_obj.Logout);
		
	}

	public void Check_Orderstatus() throws Exception
	{
		System.out.println("\tRegression Testing: Check Order Status");
		
		System.out.println("\t\tTestcase - 12");
		
		func.GuestOrderCheck("00134707", "KT15 2BQ", "ithikasha@unitedtechno.com");
		
		if(util.Isdisplayed(element_obj.GuestCheckorderNumber))
		{
			System.out.println("\t\t\tOrder Status Check Successful");
			
			data_regression.result = true;
			
			func.write_Regressiontest(data_regression.result, 12);
		}
		else
		{
			System.out.println("\t\t\tOrder Status Check Unsuccessful");
			
			data_regression.result = false;
			
			func.write_Regressiontest(data_regression.result, 12);
		}
		
		
	}
	

}
