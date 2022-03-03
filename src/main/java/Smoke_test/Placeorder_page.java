package Smoke_test;

import java.sql.Array;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Data_Functions.Functions;
import Data_Functions.constantData;
import Data_Functions.driverUtil;
import Data_Functions.pageElements;

public class Placeorder_page {
	
	public driverUtil util = new driverUtil();
	constantData data_obj;
	pageElements element_obj;
	Functions func ;
	Data_smoke smoke_data = new Data_smoke();
	
	public Placeorder_page(constantData data,pageElements elem,Functions functions) throws Exception
	   {
		   data_obj=data;
		   element_obj=elem;
		   func= functions;
		   
	   }
	
	public void Validate_orderdetails() throws Exception
	{
		System.out.println("\nPlace Order Page");
		
		System.out.println("\tSmoke Testing: Validate Order Details");
		
		System.out.println("\t\tTestcase - 20");
		
		int fail = 0;
		
		for(int i = 1; i <= smoke_data.itemlist.length; i++)
		{
			smoke_data.POP_prdName.add(i-1, element_obj.driver.findElement(By.xpath("(//div[@class='name']//child::a)["+i+"]")).getText());
			
			smoke_data.POP_price.add(i-1, element_obj.driver.findElement(By.xpath("(//div[@class='item-price'])["+i+"]")).getAttribute("innerText").strip());
			
			smoke_data.POP_qty.add(i-1, element_obj.driver.findElement(By.xpath("(//div[@class='item-qty'])["+i+"]")).getAttribute("innerText").strip());
			
		}
		
//		Collections.sort(smoke_data.POP_prdName);
//		
//		Collections.sort(smoke_data.POP_price);
//		
//		Collections.sort(smoke_data.POP_qty);
		
		
		
		for(int i = 0; i < smoke_data.itemlist.length; i++)
		{
			
			if(smoke_data.BP_prdName.get(i).equalsIgnoreCase(smoke_data.POP_prdName.get(i)))
			{
				System.out.println("\t\t\t"+smoke_data.PDP_prdName.get(i)+" Product name Validation Successfully");
			}
			else
			{
				System.out.println("\t\t\t"+smoke_data.PDP_prdName.get(i)+" Product name Validation Unsuccessfully");
				fail++;
			}
			
			if(smoke_data.BP_price.get(i).equalsIgnoreCase(smoke_data.POP_price.get(i)))
			{
				System.out.println("\t\t\t"+smoke_data.POP_price.get(i)+" Price Validation Successfully");
			}
			else
			{
				System.out.println("\t\t\t"+smoke_data.POP_price.get(i)+" Price Validation Unsuccessfully");
				fail++;
			}
			
			if(smoke_data.BP_qty.get(i).equalsIgnoreCase(smoke_data.POP_qty.get(i)))
			{
				System.out.println("\t\t\t"+smoke_data.POP_qty.get(i)+" Quantity Validation Successfully");
			}
			else
			{
				System.out.println("\t\t\t"+smoke_data.POP_qty.get(i)+" Quantity Validation Unsuccessfully");
				fail++;
			}
		}
		
		if(fail>0)
		{
			func.write_Smoketest(false, 20);
		}
		else
		{
			func.write_Smoketest(true, 20);
		}
	}
	
	public void Validate_orderTotalsplit() throws Exception
	{
		System.out.println("\tSmoke Testing: Validate Order Total");
		
		System.out.println("\t\tTestcase - 21");
		
		int fail = 0;
		
		smoke_data.POP_subtotal = element_obj.POP_subtotal.getText();
		
		smoke_data.POP_tax = element_obj.POP_tax.getText();
		
		smoke_data.POP_total = element_obj.POP_total.getText();
		
		if(smoke_data.POP_subtotal.equalsIgnoreCase(smoke_data.BP_subtotal))
		{
			System.out.println("\t\t\t"+smoke_data.BP_subtotal+" Order Sub-Total Validation Successfully");
		}
		else
		{
			System.out.println("\t\t\t"+smoke_data.BP_subtotal+" Order Sub-Total Validation Unsuccessfully");
		}
		
		if(smoke_data.POP_tax.equalsIgnoreCase(smoke_data.BP_tax))
		{
			System.out.println("\t\t\t"+smoke_data.BP_tax+" Tax Validation Successfully");
		}
		else
		{
			System.out.println("\t\t\t"+smoke_data.BP_tax+" Tax Validation Unsuccessfully");
		}
		if(smoke_data.POP_total.equalsIgnoreCase(smoke_data.BP_total))
		{
			System.out.println("\t\t\t"+smoke_data.BP_total+" Order Total Validation Successfully");
		}
		else
		{
			System.out.println("\t\t\t"+smoke_data.BP_total+" Order Total Validation Unsuccessfully");
		}
		
		if(fail>0)
		{
			func.write_Smoketest(false, 21);
		}
		else
		{
			func.write_Smoketest(true, 21);
		}
		
		System.out.println("\tSmoke Testing: Tax Return validation");
		
		System.out.println("\t\tTestcase - 22");
		
		if(smoke_data.Country.equalsIgnoreCase("United States"))
		{
			if(smoke_data.POP_tax.contains("$0.00"))
			{
				System.out.println("\t\t\t"+"Tax not Returned - Unsuccessful");
				func.write_Smoketest(false, 22);
			}
			else
			{
				System.out.println("\t\t\t"+"Tax Return - Successful");
				func.write_Smoketest(true, 22);
			}
		}
		else if(smoke_data.Country.equalsIgnoreCase("United Kingdom"))
		{
			if(smoke_data.POP_tax.contains("$0.00"))
			{
				System.out.println("\t\t\t"+"Tax not Returned - Unsuccessful");
				func.write_Smoketest(false, 22);
			}
			else
			{
				System.out.println("\t\t\t"+"Tax Return - Successful");
				func.write_Smoketest(true, 22);
			}
		}
		else
		{
			if(smoke_data.POP_tax.contains("$0.00"))
			{
				System.out.println("\t\t\t"+"Tax Return - Successful");
				func.write_Smoketest(true, 22);
				
			}
			else
			{
				System.out.println("\t\t\t"+"Invalid Tax Return - Unsuccessful");
				func.write_Smoketest(false, 22);
			}
			
		}
		
		
		smoke_data.POP_Shipaddress = element_obj.driver.findElement(By.xpath("(//div[@class='address']//child::div)[2]")).getAttribute("innerText").concat("\n"+element_obj.driver.findElement(By.xpath("(//div[@class='address']//child::div)[3]")).getAttribute("innerText").concat("\n"+element_obj.driver.findElement(By.xpath("(//div[@class='address']//child::div)[4]")).getAttribute("innerText")));
		
		smoke_data.POP_Billaddress = element_obj.driver.findElement(By.xpath("(//div[@class='address']//child::div)[6]")).getAttribute("innerText").concat("\n"+element_obj.driver.findElement(By.xpath("(//div[@class='address']//child::div)[7]")).getAttribute("innerText").concat("\n"+element_obj.driver.findElement(By.xpath("(//div[@class='address']//child::div)[8]")).getAttribute("innerText")));
		
//		System.out.println(smoke_data.POP_Shipaddress);
//		
//		System.out.println(smoke_data.POP_Billaddress);
		
	}
	
	public boolean Validate_editlink() throws Exception
	{
		System.out.println("\tSmoke Testing: Edit Link Validation");
		
		System.out.println("\t\tTestcase - 23");
		
		System.out.println("\t\tCart link");
		
		int fail = 0;
		
		util.Click(element_obj.driver.findElement(By.xpath("//a[@class='section-header-note gtm-edit-cart-link']")));// Edit cart link
		
		if(util.Isdisplayed(element_obj.driver.findElement(By.xpath("//h2[text()='Cart']"))))
		{
			System.out.println("\t\t\t"+"Edit Cart link Successful");
		}
		else
		{
			System.out.println("\t\t\t"+"Edit Cart link Unsuccessful");
			fail++;
		}
		
		util.Click(element_obj.checkout);
		
		util.WaitAndClick(element_obj.continuebill);
		
		if(util.Isdisplayed(element_obj.userAddress)) 
		{
			util.WaitAndClick(element_obj.userAddress);
		}
		
		func.smoke_payment(smoke_data.paymentMethod);
		
		if(util.Isdisplayed(element_obj.shpInt))
		{
			util.Click(element_obj.shpInt);
		}
		
		util.Click(element_obj.continuePlaceorder);
		
		if(util.Isdisplayed(element_obj.userAddress)) 
		{
			util.WaitAndClick(element_obj.userAddress);
			util.WaitAndClick(element_obj.continuePlaceorder);

		}
		
		if(util.Isdisplayed(element_obj.driver.findElement(By.xpath("//h2[text()='Place Order']"))))
		{
			System.out.println("\t\tShipping Method link");
		}
		
		util.Click(element_obj.driver.findElement(By.xpath("(//a[text()='Edit'])[2]")));// Edit Shipping method link
		
		if(util.Isdisplayed(element_obj.driver.findElement(By.xpath("//h2[text()='Shipping']"))))
		{
			System.out.println("\t\t\t"+"Edit Shipping Method link Successful");
		}
		else
		{
			System.out.println("\t\t\t"+"Edit Shipping Method link Unsuccessful");
			fail++;
		}
		
		util.WaitAndClick(element_obj.continuebill);
		
		if(util.Isdisplayed(element_obj.userAddress)) 
		{
			util.WaitAndClick(element_obj.userAddress);
		}
		
		func.smoke_payment(smoke_data.paymentMethod);
		
		if(util.Isdisplayed(element_obj.shpInt))
		{
			util.Click(element_obj.shpInt);
		}
		
		util.Click(element_obj.continuePlaceorder);
		
		
		if(util.Isdisplayed(element_obj.driver.findElement(By.xpath("//h2[text()='Place Order']"))))
		{
			System.out.println("\t\tShipping Address link");
		}
		
		util.Click(element_obj.driver.findElement(By.xpath("(//div[contains(@class,'mini-shipment order-component-block')]//child::a)[1]")));// Edit Shipping address link
		
		if(util.Isdisplayed(element_obj.driver.findElement(By.xpath("//h2[text()='Shipping']"))))
		{
			System.out.println("\t\t\t"+"Edit Shipping Address link Successful");
		}
		else
		{
			System.out.println("\t\t\t"+"Edit Shipping Address link Unsuccessful");
			fail++;
		}
		
		util.WaitAndClick(element_obj.continuebill);
		
		if(util.Isdisplayed(element_obj.userAddress)) 
		{
			util.WaitAndClick(element_obj.userAddress);
		}
		
		func.smoke_payment(smoke_data.paymentMethod);
		
		util.Click(element_obj.continuePlaceorder);
		
		if(util.Isdisplayed(element_obj.driver.findElement(By.xpath("//h2[text()='Place Order']"))))
		{
			System.out.println("\t\tBilling Address link");
		}
		
		util.Click(element_obj.driver.findElement(By.xpath("//div[@class='mini-billing-address order-component-block']//child::a")));// Edit Billing address link
		
		if(util.Isdisplayed(element_obj.driver.findElement(By.xpath("//h2[text()='Billing']"))))
		{
			System.out.println("\t\t\t"+"Edit Billing Address link Successful");
		}
		else
		{
			System.out.println("\t\t\t"+"Edit Billing Address link Unsuccessful");
			fail++;
		}
		
		func.smoke_payment(smoke_data.paymentMethod);
		
		util.Click(element_obj.continuePlaceorder);
		
		if(util.Isdisplayed(element_obj.driver.findElement(By.xpath("//h2[text()='Place Order']"))))
		{
			System.out.println("\t\tPayment link");
		}
		
		element_obj.driver.findElement(By.xpath("(//div[contains(@class,'mini-payment-instrument order-component-block')]//child::a)[1]")).click();// Edit Payment link
        
		if(util.Isdisplayed(element_obj.driver.findElement(By.xpath("//h2[text()='Billing']"))))
		{
			System.out.println("\t\t\t"+"Edit Payment link Successful");
		}
		else
		{
			System.out.println("\t\t\t"+"Edit Payment link Unsuccessful");
			fail++;
		}
		
		func.smoke_payment(smoke_data.paymentMethod);
		
		util.Click(element_obj.continuePlaceorder);
		
		if(fail>0)
		{
			func.write_Smoketest(false, 23);
		}
		else
		{
			func.write_Smoketest(true, 23);
		}
		
		if(smoke_data.URL == data_obj.Prod_url)
		{
			return false;
		}
		
		System.out.println("\tSmoke Testing: Place Order validation");
		
		System.out.println("\t\tTestcase - 24");
		
		if(util.Isdisplayed(element_obj.shpInt))
		{
			util.Click(element_obj.shpInt);
		}
		
		util.Click(element_obj.placeorder);
		
		if(util.Isdisplayed(element_obj.orderNumber))
		{
			System.out.println("\t\t\t"+"Order placed Successfully");
			func.write_Smoketest(true, 24);
		}
		else
		{
			System.out.println("\t\t\t"+"Order Unsuccessfully");
			func.write_Smoketest(false, 24);
		}
		
		return true;
	}

}
