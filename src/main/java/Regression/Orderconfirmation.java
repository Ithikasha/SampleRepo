package Regression;

import org.openqa.selenium.By;

import Data_Functions.Functions;
import Data_Functions.constantData;
import Data_Functions.driverUtil;
import Data_Functions.pageElements;

public class Orderconfirmation {
	
	public driverUtil util = new driverUtil() ;
	constantData data_obj ;
	pageElements element_obj ;
	Functions func ;
	Data_Regression data_regression = new Data_Regression() ;
	
	public Orderconfirmation(constantData data,pageElements elem,Functions functions) throws Exception
	   {
		   data_obj=data;
		   element_obj=elem;
		   func= functions;		   
	   }
	
	public void Productdetail() throws Exception
	{
		
		System.out.println("\nOrder Confirmation page");
		
		System.out.println("\tSmoke Testing: Order Number validation");
		
		System.out.println("\t\tTestcase - 52");
		
		for(int i = 1; i <= data_regression.itemlist.length; i++)
		{
			data_regression.OC_prdName.add(i-1, element_obj.driver.findElement(By.xpath("(//div[@class='name']//child::a)["+i+"]")).getText());
			
			data_regression.OC_price.add(i-1, element_obj.driver.findElement(By.xpath("(//div[@class='line-item-price'])["+i+"]")).getAttribute("innerText").strip());
			
			data_regression.OC_qty.add(i-1, element_obj.driver.findElement(By.xpath("(//div[@class='line-item-quantity'])["+i+"]")).getAttribute("innerText").strip());
			
		}
		
		if(util.Isdisplayed(element_obj.orderNumber))
		{
			data_regression.orderNumber = element_obj.orderNumber.getText().toString();
			
			System.out.println("\t\t\t"+data_regression.orderNumber.substring(15));
			
			System.out.println("\t\t\t"+"Order Number displayed Successfully");
			func.write_Regressiontest(true, 52);
		}
		else
		{
			System.out.println("\t\t\t"+"Order Number display Unsuccessfully");
			func.write_Regressiontest(false, 52);
		}
		
		System.out.println("\tSmoke Testing: Order Details validation");
		
		System.out.println("\t\tTestcase - 53");
		
		int fail = 0;
		
		for(int i = 0; i < data_regression.itemlist.length; i++)
		{
			
			
			if(data_regression.OC_prdName.contains(data_regression.POP_prdName.get(i)))
			{
				System.out.println("\t\t\t"+"Product: "+data_regression.PDP_prdName.get(i)+" Product name Validation Successfully");
			}
			else
			{
				System.out.println("\t\t\t"+"Product: "+data_regression.PDP_prdName.get(i)+" Product name Validation Unsuccessfully");
				fail++;
			}
			
			if(data_regression.OC_price.contains(data_regression.POP_price.get(i)))
			{
				System.out.println("\t\t\t"+"Price: "+data_regression.POP_price.get(i)+data_regression.OC_price.get(i)+" Price Validation Successfully");
			}
			else
			{
				System.out.println("\t\t\t"+"Price: "+data_regression.POP_price.get(i)+" Price Validation Unsuccessfully");
				fail++;
			}
			
			if(data_regression.OC_qty.contains(data_regression.POP_qty.get(i)))
			{
				System.out.println("\t\t\t"+"Quantity: "+data_regression.POP_qty.get(i)+" Quantity Validation Successfully");
			}
			else
			{
				System.out.println("\t\t\t"+"Quantity: "+data_regression.POP_qty.get(i)+" Quantity Validation Unsuccessfully");
				fail++;
			}
		}
		
		String Shipping_address = element_obj.driver.findElement(By.xpath("(//p[text()='Shipping Address']//following::address)[1]")).getAttribute("innerText");
		
//		System.out.println(Shipping_address);
		
		if(Shipping_address.contains(data_regression.POP_Shipaddress)) 
		{
			System.out.println("\t\t\t"+"Shipping details in Order confirmation page verified Successfully");
		}
		else
		{
			System.out.println("\t\t\t"+"Shipping details in Order confirmation page verified Unsuccessfully");
			fail++;
		}
		
		String Billing_address = element_obj.driver.findElement(By.xpath("//p[text()='Billing Address']//following::address")).getAttribute("innerText");
		
		if(Billing_address.contains(data_regression.POP_Billaddress))
		{
			System.out.println("\t\t\t"+"Billing details in Order confirmation page verified Successfully");
		}
		else
		{
			System.out.println("\t\t\t"+"Billing details in Order confirmation page verified Unsuccessfully");
			fail++;
		}
		
		if(fail>0)
		{
			func.write_Regressiontest(false, 53);
		}
		else
		{
			func.write_Regressiontest(true, 53);
		}
		
	}
	
	public void Shippingdetails()
	{
		String Shipping_address = element_obj.driver.findElement(By.xpath("(//p[text()='Shipping Address']//following::address)[1]")).getAttribute("innerText");
		
//		System.out.println(Shipping_address);
		
		if(Shipping_address.contains(data_regression.POP_Shipaddress)) 
		{
			System.out.println("\t\t\t"+"Shipping details in Order confirmation page verified Successfully");
		}
		else
		{
			System.out.println("\t\t\t"+"Shipping details in Order confirmation page verified Unsuccessfully");
		}
	}
	
	public void Billingdetails()
	{
		String Billing_address = element_obj.driver.findElement(By.xpath("//p[text()='Billing Address']//following::address")).getAttribute("innerText");
		
		if(Billing_address.contains(data_regression.POP_Billaddress))
		{
			System.out.println("\t\t\t"+"Billing details in Order confirmation page verified Successfully");
		}
		else
		{
			System.out.println("\t\t\t"+"Billing details in Order confirmation page verified Unsuccessfully");
		}
	
	}

}
