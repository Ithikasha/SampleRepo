package Smoke_test;

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
	Data_smoke smoke_data = new Data_smoke();
	
	public Login_smoke(constantData data,pageElements elem,Functions functions)
	   {
		   data_obj=data;
		   element_obj=elem;
		   func= functions;
	   }
	
	public void Login_Loginpage() throws Exception
	{
		System.out.println("\nLoginpage");
		
		System.out.println("\tSmoke Testing: Login from Loginpage");

		System.out.println("\t\tTestcase - 1");
		
	   	data_obj.driver.get(smoke_data.URL);
		
		if(util.Isdisplayed(element_obj.no))
		{
			util.Click(element_obj.no);
		}
		
		func.smoke_login(smoke_data.email, smoke_data.password);
		
		if(util.Isdisplayed(data_obj.driver.findElement(By.xpath("//h1[@class='overview-header']"))))
		{
			System.out.println("\t\t\tLoginpage - Login Successful for "+smoke_data.email);
			
			smoke_data.result = true;
			
			func.write_Smoketest(smoke_data.result, 1);
		}
		
		else
		{
			System.out.println("\t\t\tLoginpage - Login Unsuccessful for "+smoke_data.password);
			
			smoke_data.result = false;
			
			func.write_Smoketest(smoke_data.result, 1);
		}

		util.WaitAndClick(element_obj.MyAccount);
						
		util.WaitAndClick(element_obj.Logout);
		
//		data_obj.driver.close();
		
	}
	
	public void Login_Cartpage() throws Exception
	{
		System.out.println("\tSmoke Testing: Login from Cartpage");
		
		System.out.println("\t\tTestcase - 2");
		
		data_obj.driver.get(smoke_data.URL);
		
		func.Add_product(smoke_data.itemlist, smoke_data.qty);
		
		element_obj.email.clear();
		
		element_obj.email.sendKeys(smoke_data.email);
		
		element_obj.password.clear();
		
		element_obj.password.sendKeys(smoke_data.password);
		
		util.WaitAndClick(element_obj.Cart_CO);
		
		if(util.Isdisplayed(data_obj.driver.findElement(By.xpath("//div[@class='shipping-header']"))))
		{
			System.out.println("\t\t\tCartpage - Login Successful for "+smoke_data.email);
			
			smoke_data.result = true;
			
			func.write_Smoketest(smoke_data.result, 2);
		}
		else
		{
			System.out.println("\t\t\tCartpage - Login Unsuccessful for "+smoke_data.email);
			
			smoke_data.result = false;
			
			func.write_Smoketest(smoke_data.result, 2);
		}
		
		element_obj.POviewcart.click();
		

		for(int c = 1; c <= smoke_data.itemlist.length; c++)
		{			
			
			data_obj.driver.findElement(By.xpath("(//tr[@class='cart-row']//following-sibling::button[@value='Remove'])[2]")).click();

		}
		
		util.WaitAndClick(element_obj.MyAccount);
		
		util.WaitAndClick(element_obj.Logout);
		
	}
	
	public void Check_Orderstatus(String number, String email, String zipcode) throws Exception
	{
		System.out.println("\tSmoke Testing: Check Order Status");
		
		System.out.println("\t\tTestcase - 3");
		
		util.Sendkeys(element_obj.driver.findElement(By.xpath("//input[@id='dwfrm_ordertrack_orderNumber']")), number);
		
		util.Sendkeys(element_obj.driver.findElement(By.xpath("//input[@id='dwfrm_ordertrack_orderEmail']")), email);
		
		util.Sendkeys(element_obj.driver.findElement(By.xpath("//input[@id='dwfrm_ordertrack_postalCode']")), zipcode);
		
		util.Click(element_obj.driver.findElement(By.xpath("//button[@value='Check Status']")));
		
		if(util.Isdisplayed(element_obj.orderNumber))
		{
			System.out.println("\t\t\tOrder Status Check Successful");
			
			smoke_data.result = true;
			
			func.write_Smoketest(smoke_data.result, 3);
		}
		else
		{
			System.out.println("\t\t\tOrder Status Check Unsuccessful");
			
			smoke_data.result = false;
			
			func.write_Smoketest(smoke_data.result, 3);
		}
	}


}
