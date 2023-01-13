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
		
		System.out.println("\t\tTestcase - 15");

		int fail = 0;
		
		func.smoke_login(data_regression.email, data_regression.password);
		
		util.Click(element_obj.MyAccount_PersonalInfo); // Personal Info
		
		if(util.Isdisplayed(element_obj.driver.findElement(By.xpath("//h2[@class='edit-account-header form-heading']"))))
		{
			System.out.println("\t\t\t"+"Personal Information link verification Successful");
			
			data_regression.result = true;
			
			func.write_Regressiontest(data_regression.result, 15);
		}
		else
		{
			System.out.println("\t\t\t"+"Personal Information link verification UnSuccessful");
			
			data_regression.result = false;
			
			func.write_Regressiontest(data_regression.result, 15);
		}
		
		System.out.println("\tRegression Testing: Address Link");
		
		System.out.println("\t\tTestcase - 16");
		
		util.Click(element_obj.MyAccount_Address); // Address
		
		if(util.Isdisplayed(element_obj.driver.findElement(By.xpath("(//a[@title='ADD NEW ADDRESS'])"))))
		{
			System.out.println("\t\t\t"+"Address link verification Successful");
			
			data_regression.result = true;
			
			func.write_Regressiontest(data_regression.result, 16);
		}
		else
		{
			System.out.println("\t\t\t"+"Address link verification UnSuccessful");
			
			data_regression.result = false;
			
			func.write_Regressiontest(data_regression.result, 16);
		}
		
		System.out.println("\tRegression Testing: Payment Link");
		
		System.out.println("\t\tTestcase - 17");
		
		util.Click(element_obj.MyAccount_Payment); // Payment
		
		if(util.Isdisplayed(element_obj.driver.findElement(By.xpath("(//a[@title='Add a credit card to this account'])"))))
		{
			System.out.println("\t\t\t"+"Payment link verification Successful");
			
			data_regression.result = true;
			
			func.write_Regressiontest(data_regression.result, 17);
		}
		else
		{
			System.out.println("\t\t\t"+"Payment link verification UnSuccessful");
			
			data_regression.result = false;
			
			func.write_Regressiontest(data_regression.result, 17);
		}
		
		System.out.println("\tRegression Testing: Presale Link");

		System.out.println("\t\tTestcase - 18");
		
		util.Click(element_obj.MyAccount_Presale); // Presale
		
		if(util.Isdisplayed(element_obj.driver.findElement(By.xpath("(//h1[@class='presale-header'])"))))
		{
			System.out.println("\t\t\t"+"Presale link verification Successful");
		
			data_regression.result = true;
			
			func.write_Regressiontest(data_regression.result, 18);
		}
		else
		{
			System.out.println("\t\t\t"+"Presale link verification UnSuccessful");
			
			data_regression.result = false;
			
			func.write_Regressiontest(data_regression.result, 18);
		}
		
		System.out.println("\tRegression Testing: Free Download Link");
		
		System.out.println("\t\tTestcase - 19");
		
		util.Click(element_obj.MyAccount_Freedownload); // Free Download
		
		if(util.Isdisplayed(element_obj.driver.findElement(By.xpath("(//h1[@class='freedownloads-header'])"))))
		{
			System.out.println("\t\t\t"+"Free Download link verification Successful");
		
			data_regression.result = true;
			
			func.write_Regressiontest(data_regression.result, 19);
		}
		else
		{
			System.out.println("\t\t\t"+"Free Download link verification UnSuccessful");
			
			data_regression.result = false;
			
			func.write_Regressiontest(data_regression.result, 19);
		}
		
		System.out.println("\tRegression Testing: Contest Link");
		
		System.out.println("\t\tTestcase - 20");
		
		util.Click(element_obj.MyAccount_Contest); // Contest
		
		if(util.Isdisplayed(element_obj.driver.findElement(By.xpath("(//h1[@class='account-contests-header'])"))))
		{
			System.out.println("\t\t\t"+"Contests link verification Successful");
		
			data_regression.result = true;
			
			func.write_Regressiontest(data_regression.result, 20);
		}
		else
		{
			System.out.println("\t\t\t"+"Contests link verification UnSuccessful");
			
			data_regression.result = false;
			
			func.write_Regressiontest(data_regression.result, 20);
		}
		
		System.out.println("\tRegression Testing: Vinyl Club Link");
		
		System.out.println("\t\tTestcase - 21");
		
		util.Click(element_obj.MyAccount_Vinylclub); // Vinyl Club
		
		if(util.Isdisplayed(element_obj.driver.findElement(By.xpath("//a[contains(text(),'Read more')]"))))
		{
			System.out.println("\t\t\t"+"Vinyl Club link verification Successful");
			
			data_regression.result = true;
			
			func.write_Regressiontest(data_regression.result, 21);
		}
		else
		{
			System.out.println("\t\t\t"+"Vinyl Club link verification UnSuccessful");
			
			data_regression.result = false;
			
			func.write_Regressiontest(data_regression.result, 21);
		}
		
		System.out.println("\tRegression Testing: Order History Link");
		
		System.out.println("\t\tTestcase - 22");
		
		util.Click(element_obj.MyAccount_Order); // Order History
		
		if(util.Isdisplayed(element_obj.driver.findElement(By.xpath("(//h1[@class='order-history-h1 account-primary-heading'])"))))
		{
			System.out.println("\t\t\t"+"Order History link verification Successful");
			
			data_regression.result = true;
			
			func.write_Regressiontest(data_regression.result, 22);
		}
		else
		{
			System.out.println("\t\t\t"+"Order History link verification UnSuccessful");
			
			data_regression.result = true;
			
			func.write_Regressiontest(data_regression.result, 22);
		}
		
		util.Click(element_obj.srch);
		
		util.Click(element_obj.Logout);
	}

}
