package Smoke_test;

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
	Data_smoke smoke_data = new Data_smoke() ;
	
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
		
		System.out.println("\t\tTestcase - 25");
		
		for(int i = 1; i <= smoke_data.itemlist.length; i++)
		{
			smoke_data.OC_prdName.add(i-1, element_obj.driver.findElement(By.xpath("(//div[@class='name']//child::a)["+i+"]")).getText());
			
			smoke_data.OC_price.add(i-1, element_obj.driver.findElement(By.xpath("(//div[@class='line-item-price'])["+i+"]")).getAttribute("innerText").strip());
			
			smoke_data.OC_qty.add(i-1, element_obj.driver.findElement(By.xpath("(//div[@class='line-item-quantity'])["+i+"]")).getAttribute("innerText").strip());
			
		}
		
		if(util.Isdisplayed(element_obj.orderNumber))
		{
			smoke_data.orderNumber = element_obj.orderNumber.getText().toString();
			
			System.out.println("\t\t\t"+smoke_data.orderNumber.substring(15));
			
			System.out.println("\t\t\t"+"Order Number displayed Successfully");
			func.write_Smoketest(true, 25);
		}
		else
		{
			System.out.println("\t\t\t"+"Order Number display Unsuccessfully");
			func.write_Smoketest(false, 25);
		}
		
		System.out.println("\tSmoke Testing: Order Details validation");
		
		System.out.println("\t\tTestcase - 26");
		
		int fail = 0;
		
		for(int i = 0; i < smoke_data.itemlist.length; i++)
		{
			
			
			if(smoke_data.OC_prdName.get(i).equalsIgnoreCase(smoke_data.POP_prdName.get(i)))
			{
				System.out.println("\t\t\t"+"Product: "+smoke_data.PDP_prdName.get(i)+" Product name Validation Successfully");
			}
			else
			{
				System.out.println("\t\t\t"+"Product: "+smoke_data.PDP_prdName.get(i)+" Product name Validation Unsuccessfully");
				fail++;
			}
			
			if(smoke_data.OC_price.get(i).equalsIgnoreCase(smoke_data.POP_price.get(i)))
			{
				System.out.println("\t\t\t"+"Price: "+smoke_data.POP_price.get(i)+" Price Validation Successfully");
			}
			else
			{
				System.out.println("\t\t\t"+"Price: "+smoke_data.POP_price.get(i)+" Price Validation Unsuccessfully");
				fail++;
			}
			
			if(smoke_data.OC_qty.get(i).equalsIgnoreCase(smoke_data.POP_qty.get(i)))
			{
				System.out.println("\t\t\t"+"Quantity: "+smoke_data.POP_qty.get(i)+" Quantity Validation Successfully");
			}
			else
			{
				System.out.println("\t\t\t"+"Quantity: "+smoke_data.POP_qty.get(i)+" Quantity Validation Unsuccessfully");
				fail++;
			}
		}
		
		String Shipping_address = element_obj.driver.findElement(By.xpath("(//p[text()='Shipping Address']//following::address)[1]")).getAttribute("innerText");
		
//		System.out.println(Shipping_address);
		
		if(Shipping_address.contains(smoke_data.POP_Shipaddress)) 
		{
			System.out.println("\t\t\t"+"Shipping details in Order confirmation page verified Successfully");
		}
		else
		{
			System.out.println("\t\t\t"+"Shipping details in Order confirmation page verified Unsuccessfully");
			fail++;
		}
		
		String Billing_address = element_obj.driver.findElement(By.xpath("//p[text()='Billing Address']//following::address")).getAttribute("innerText");
		
		if(Billing_address.contains(smoke_data.POP_Billaddress))
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
			func.write_Smoketest(false, 26);
		}
		else
		{
			func.write_Smoketest(true, 26);
		}
		
	}
	
	public void Shippingdetails()
	{
		String Shipping_address = element_obj.driver.findElement(By.xpath("(//p[text()='Shipping Address']//following::address)[1]")).getAttribute("innerText");
		
//		System.out.println(Shipping_address);
		
		if(Shipping_address.contains(smoke_data.POP_Shipaddress)) 
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
		
		if(Billing_address.contains(smoke_data.POP_Billaddress))
		{
			System.out.println("\t\t\t"+"Billing details in Order confirmation page verified Successfully");
		}
		else
		{
			System.out.println("\t\t\t"+"Billing details in Order confirmation page verified Unsuccessfully");
		}
	
	}

}
