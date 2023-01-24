package Regression;

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
	Data_Regression data_regression = new Data_Regression();
	
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
		
		System.out.println("\t\tTestcase - 44");
		
//		data_obj.driver.get(data_regression.URL);
//		
//		util.Click(element_obj.no);
//
//		func.smoke_login(data_regression.email, data_regression.password);
//		
//		func.Add_product(data_regression.itemlist, data_regression.qty);
//		
//		util.Click(element_obj.checkout);
		
		int fail = 0;
		
		for(int i = 1; i <= data_regression.itemlist.length; i++)
		{
			data_regression.POP_prdName.add(i-1, element_obj.driver.findElement(By.xpath("(//div[@class='name']//child::a)["+i+"]")).getText());
			
			data_regression.POP_price.add(i-1, element_obj.driver.findElement(By.xpath("(//td[@class='item-total'])[\"+i+\"]")).getAttribute("innerText").strip());
			
			data_regression.POP_qty.add(i-1, element_obj.driver.findElement(By.xpath("(//div[@class='item-qty'])["+i+"]")).getAttribute("innerText").strip());
			
		}
		
		Collections.sort(data_regression.POP_prdName);
		
		Collections.sort(data_regression.POP_price);
		
		Collections.sort(data_regression.POP_qty);
		
		
		
		for(int i = 1; i > data_regression.itemlist.length; i++)
		{
			if(data_regression.BP_prdName.contains(data_regression.POP_prdName.get(i)))
			{
				System.out.println("\t\t\t"+data_regression.PDP_prdName.get(i)+" Product name Validation Successfully");
			}
			else
			{
				System.out.println("\t\t\t"+data_regression.PDP_prdName.get(i)+" Product name Validation Unsuccessfully");
				fail++;
			}
			
			if(data_regression.BP_price.contains(data_regression.POP_price.get(i)))
			{
				System.out.println("\t\t\t"+data_regression.POP_price.get(i)+" Price Validation Successfully");
			}
			else
			{
				System.out.println("\t\t\t"+data_regression.POP_price.get(i)+" Price Validation Unsuccessfully");
				fail++;
			}
			
			if(data_regression.BP_qty.contains(data_regression.POP_qty.get(i)))
			{
				System.out.println("\t\t\t"+data_regression.POP_qty.get(i)+" Quantity Validation Successfully");
			}
			else
			{
				System.out.println("\t\t\t"+data_regression.POP_qty.get(i)+" Quantity Validation Unsuccessfully");
				fail++;
			}
		}
		
		if(fail>0)
		{
			func.write_Regressiontest(false, 44);
		}
		else
		{
			func.write_Regressiontest(true, 44);
		}
	}
	
	public void Validate_orderTotalsplit() throws Exception
	{
		System.out.println("\tSmoke Testing: Validate Order Total");
		
		System.out.println("\t\tTestcase - 45");
		
		int fail = 0;
		
		data_regression.POP_subtotal = element_obj.POP_subtotal.getText();
		
		data_regression.POP_tax = element_obj.POP_tax.getText();
		
		data_regression.POP_total = element_obj.POP_total.getText();
		
		if(data_regression.POP_subtotal.equalsIgnoreCase(data_regression.BP_subtotal))
		{
			System.out.println("\t\t\t"+data_regression.BP_subtotal+" Order Sub-Total Validation Successfully");
		}
		else
		{
			System.out.println("\t\t\t"+data_regression.BP_subtotal+" Order Sub-Total Validation Unsuccessfully");
		}
		
		if(data_regression.POP_tax.equalsIgnoreCase(data_regression.BP_tax))
		{
			System.out.println("\t\t\t"+data_regression.BP_tax+" Tax Validation Successfully");
		}
		else
		{
			System.out.println("\t\t\t"+data_regression.BP_tax+" Tax Validation Unsuccessfully");
		}
		if(data_regression.POP_total.equalsIgnoreCase(data_regression.BP_total))
		{
			System.out.println("\t\t\t"+data_regression.BP_total+" Order Total Validation Successfully");
		}
		else
		{
			System.out.println("\t\t\t"+data_regression.BP_total+" Order Total Validation Unsuccessfully");
		}
		
		if(fail>0)
		{
			func.write_Regressiontest(false, 45);
		}
		else
		{
			func.write_Regressiontest(true, 45);
		}
		
		System.out.println("\tSmoke Testing: Tax Return validation");
		
		System.out.println("\t\tTestcase - 46");
		
		if(data_regression.TaxableCountryList.contains(data_regression.Address.get("Country")))
		{
			if(data_regression.POP_tax.contains("$0.00"))
			{
				System.out.println("\t\t\t"+"Tax not Returned - Unsuccessful");
				func.write_Regressiontest(false, 46);
			}
			else
			{
				System.out.println("\t\t\t"+"Tax Return - Successful");
				func.write_Regressiontest(true, 46);
			}
		}
		else
		{
			if(data_regression.POP_tax.contains("$0.00"))
			{
				System.out.println("\t\t\t"+"Tax Return - Successful");
				func.write_Regressiontest(true, 46);
				
			}
			else
			{
				System.out.println("\t\t\t"+"Invalid Tax Return - Unsuccessful");
				func.write_Regressiontest(false, 46);
			}
			
		}
		
		
		data_regression.POP_Shipaddress = element_obj.driver.findElement(By.xpath("(//div[@class='address']//child::div)[2]")).getAttribute("innerText").concat("\n"+element_obj.driver.findElement(By.xpath("(//div[@class='address']//child::div)[3]")).getAttribute("innerText").concat("\n"+element_obj.driver.findElement(By.xpath("(//div[@class='address']//child::div)[4]")).getAttribute("innerText")));
		
		data_regression.POP_Billaddress = element_obj.driver.findElement(By.xpath("(//div[@class='address']//child::div)[6]")).getAttribute("innerText").concat("\n"+element_obj.driver.findElement(By.xpath("(//div[@class='address']//child::div)[7]")).getAttribute("innerText").concat("\n"+element_obj.driver.findElement(By.xpath("(//div[@class='address']//child::div)[8]")).getAttribute("innerText")));
		
//		System.out.println(smoke_data.POP_Shipaddress);
//		
//		System.out.println(smoke_data.POP_Billaddress);
		
	}
	
	public boolean Validate_editlink() throws Exception
	{
		System.out.println("\tSmoke Testing: Edit Link Validation");
		
		System.out.println("\t\tTestcase - 47");
		
		System.out.println("\t\tCart link");
		
		int fail = 0;
		
		util.Click(element_obj.SP_BackToCart);// Edit cart link
		
		if(util.Isdisplayed(element_obj.driver.findElement(By.xpath("//div[@class='col col--xs-12 cart__header__content']//h2"))))
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
		
		func.smoke_payment("Amex");
		
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
		
		if(util.Isdisplayed(element_obj.driver.findElement(By.xpath("//div[@class='place-order-header']//child::h2"))))
		{
			System.out.println("\t\tShipping Method link");
		}
		
		util.Click(element_obj.driver.findElement(By.xpath("(//a[text()='Edit'])[2]")));// Edit Shipping method link
		
		if(util.Isdisplayed(element_obj.driver.findElement(By.xpath("(//h2[text()='1. Shipping'])[2]"))))
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
		
		func.smoke_payment("Amex");
		
		if(util.Isdisplayed(element_obj.shpInt))
		{
			util.Click(element_obj.shpInt);
		}
		
		util.Click(element_obj.continuePlaceorder);
		
		
		if(util.Isdisplayed(element_obj.driver.findElement(By.xpath("//div[@class='place-order-header']//child::h2"))))
		{
			System.out.println("\t\tShipping Address link");
		}
		
		util.Click(element_obj.driver.findElement(By.xpath("(//div[contains(@class,'mini-shipment order-component-block')]//child::a)[1]")));// Edit Shipping address link
		
		if(util.Isdisplayed(element_obj.driver.findElement(By.xpath("(//h2[text()='1. Shipping'])[2]"))))
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
		
		func.smoke_payment("Amex");
		
		util.Click(element_obj.continuePlaceorder);
		
		if(util.Isdisplayed(element_obj.driver.findElement(By.xpath("//div[@class='place-order-header']//child::h2"))))
		{
			System.out.println("\t\tBilling Address link");
		}
		
		util.Click(element_obj.driver.findElement(By.xpath("//div[@class='mini-billing-address order-component-block']//child::a")));// Edit Billing address link
		
		if(util.Isdisplayed(element_obj.driver.findElement(By.xpath("//div[@class='billing-header']//child::h2"))))
		{
			System.out.println("\t\t\t"+"Edit Billing Address link Successful");
		}
		else
		{
			System.out.println("\t\t\t"+"Edit Billing Address link Unsuccessful");
			fail++;
		}
		
		func.smoke_payment("Amex");
		
		util.Click(element_obj.continuePlaceorder);
		
		if(util.Isdisplayed(element_obj.driver.findElement(By.xpath("//div[@class='place-order-header']//child::h2"))))
		{
			System.out.println("\t\tPayment link");
		}
		
		element_obj.driver.findElement(By.xpath("(//div[contains(@class,'mini-payment-instrument order-component-block')]//child::a)[1]")).click();// Edit Payment link
        
		if(util.Isdisplayed(element_obj.driver.findElement(By.xpath("//div[@class='billing-header']//child::h2"))))
		{
			System.out.println("\t\t\t"+"Edit Payment link Successful");
		}
		else
		{
			System.out.println("\t\t\t"+"Edit Payment link Unsuccessful");
			fail++;
		}
		
		func.smoke_payment("Amex");
		
		util.Click(element_obj.continuePlaceorder);
		
		if(fail>0)
		{
			func.write_Regressiontest(false, 47);
		}
		else
		{
			func.write_Regressiontest(true, 47);
		}
		
		if(data_regression.URL == data_obj.Prod_url)
		{
			return false;
		}
		
		System.out.println("\tSmoke Testing: Place Order validation");
		
		System.out.println("\t\tTestcase - 48");
		
		if(util.Isdisplayed(element_obj.shpInt))
		{
			util.Click(element_obj.shpInt);
		}
		
		util.Click(element_obj.placeorder);
		
		if(util.Isdisplayed(element_obj.orderNumber))
		{
			System.out.println("\t\t\t"+"Order placed Successfully");
			
			func.write_Regressiontest(true, 48);
		}
		else
		{
			System.out.println("\t\t\t"+"Order Unsuccessfully");
			func.write_Regressiontest(false, 48);
		}
		
		return true;
	}

}
