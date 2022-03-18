package Regression;

import org.openqa.selenium.By;

import Data_Functions.Functions;
import Data_Functions.constantData;
import Data_Functions.driverUtil;
import Data_Functions.pageElements;

public class MyAccount_page {
	
	public driverUtil util = new driverUtil();
	constantData data_obj;
	pageElements element_obj;
	Functions func ;
	Data_Regression data_regression = new Data_Regression();
	
	public MyAccount_page(constantData data,pageElements elem,Functions functions)
	{
		   data_obj=data;
		   element_obj=elem;
		   func= functions;
	}
	
	public void MyAccount_Links() throws Exception
	{
		System.out.println("MyAccount Page");
		
		System.out.println("\tRegression Testing: Personal Information Link");
		
		System.out.println("\t\tTestcase - 5");

		int fail = 0;
		
		func.smoke_login(data_regression.email, data_regression.password);
		
		util.Click(element_obj.MyAccount_PersonalInfo); // Personal Info
		
		if(util.Isdisplayed(element_obj.driver.findElement(By.xpath("(//h1[@class='edit-account-header'])"))))
		{
			System.out.println("\t\t\t"+"Personal Information link verification Successful");
			
			data_regression.result = true;
			
			func.write_Smoketest(data_regression.result, 5);
		}
		else
		{
			System.out.println("\t\t\t"+"Personal Information link verification UnSuccessful");
			
			data_regression.result = false;
			
			func.write_Smoketest(data_regression.result, 5);
		}
		
		System.out.println("\tRegression Testing: Address Link");
		
		System.out.println("\t\tTestcase - 6");
		
		util.Click(element_obj.MyAccount_Address); // Address
		
		if(util.Isdisplayed(element_obj.driver.findElement(By.xpath("(//a[@title='ADD NEW ADDRESS'])"))))
		{
			System.out.println("\t\t\t"+"Address link verification Successful");
			
			data_regression.result = true;
			
			func.write_Smoketest(data_regression.result, 6);
		}
		else
		{
			System.out.println("\t\t\t"+"Address link verification UnSuccessful");
			
			data_regression.result = false;
			
			func.write_Smoketest(data_regression.result, 6);
		}
		
		System.out.println("\tRegression Testing: Payment Link");
		
		System.out.println("\t\tTestcase - 7");
		
		util.Click(element_obj.MyAccount_Payment); // Payment
		
		if(util.Isdisplayed(element_obj.driver.findElement(By.xpath("(//a[@title='Add a credit card to this account'])"))))
		{
			System.out.println("\t\t\t"+"Payment link verification Successful");
			
			data_regression.result = true;
			
			func.write_Smoketest(data_regression.result, 7);
		}
		else
		{
			System.out.println("\t\t\t"+"Payment link verification UnSuccessful");
			
			data_regression.result = false;
			
			func.write_Smoketest(data_regression.result, 7);
		}
		
		System.out.println("\tSmoke Testing: Presale Link");

		System.out.println("\t\tTestcase - 8");
		
		util.Click(element_obj.MyAccount_Presale); // Presale
		
		if(util.Isdisplayed(element_obj.driver.findElement(By.xpath("(//h1[@class='presale-header'])"))))
		{
			System.out.println("\t\t\t"+"Presale link verification Successful");
		
			data_regression.result = true;
			
			func.write_Smoketest(data_regression.result, 8);
		}
		else
		{
			System.out.println("\t\t\t"+"Presale link verification UnSuccessful");
			
			data_regression.result = false;
			
			func.write_Smoketest(data_regression.result, 8);
		}
		
		System.out.println("\tSmoke Testing: Free Download Link");
		
		System.out.println("\t\tTestcase - 9");
		
		util.Click(element_obj.MyAccount_Freedownload); // Free Download
		
		if(util.Isdisplayed(element_obj.driver.findElement(By.xpath("(//h1[@class='freedownloads-header'])"))))
		{
			System.out.println("\t\t\t"+"Free Download link verification Successful");
		
			data_regression.result = true;
			
			func.write_Smoketest(data_regression.result, 9);
		}
		else
		{
			System.out.println("\t\t\t"+"Free Download link verification UnSuccessful");
			
			data_regression.result = false;
			
			func.write_Smoketest(data_regression.result, 9);
		}
		
		System.out.println("\tSmoke Testing: Contest Link");
		
		System.out.println("\t\tTestcase - 10");
		
		util.Click(element_obj.MyAccount_Contest); // Contest
		
		if(util.Isdisplayed(element_obj.driver.findElement(By.xpath("(//h1[@class='account-contests-header'])"))))
		{
			System.out.println("\t\t\t"+"Contests link verification Successful");
		
			data_regression.result = true;
			
			func.write_Smoketest(data_regression.result, 10);
		}
		else
		{
			System.out.println("\t\t\t"+"Contests link verification UnSuccessful");
			
			data_regression.result = false;
			
			func.write_Smoketest(data_regression.result, 10);
		}
		
		System.out.println("\tSmoke Testing: Vinyl Club Link");
		
		System.out.println("\t\tTestcase - 11");
		
		util.Click(element_obj.MyAccount_Vinylclub); // Vinyl Club
		
		if(util.Isdisplayed(element_obj.driver.findElement(By.xpath("(//h1[@class='subscriptionHeader'])"))))
		{
			System.out.println("\t\t\t"+"Vinyl Club link verification Successful");
			
			data_regression.result = true;
			
			func.write_Smoketest(data_regression.result, 11);
		}
		else
		{
			System.out.println("\t\t\t"+"Vinyl Club link verification UnSuccessful");
			
			data_regression.result = false;
			
			func.write_Smoketest(data_regression.result, 11);
		}
		
		System.out.println("\tSmoke Testing: Order History Link");
		
		System.out.println("\t\tTestcase - 12");
		
		util.Click(element_obj.MyAccount_Order); // Order History
		
		if(util.Isdisplayed(element_obj.driver.findElement(By.xpath("(//h1[@class='order-history-h1'])"))))
		{
			System.out.println("\t\t\t"+"Order History link verification Successful");
			
			data_regression.result = true;
			
			func.write_Smoketest(data_regression.result, 12);
		}
		else
		{
			System.out.println("\t\t\t"+"Order History link verification UnSuccessful");
			
			data_regression.result = true;
			
			func.write_Smoketest(data_regression.result, 12);
		}
		
		util.WaitAndClick(element_obj.MyAccount);
		
		util.WaitAndClick(element_obj.Logout);
	}

}
