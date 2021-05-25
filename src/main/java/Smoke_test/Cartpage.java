package Smoke_test;

import java.util.Collections;

import org.openqa.selenium.By;

import Data_Functions.constantData;
import Data_Functions.driverUtil;
import Data_Functions.pageElements;
import Data_Functions.Functions;

public class Cartpage {
	
	public driverUtil util = new driverUtil();
	constantData data_obj;
	pageElements element_obj;
	Functions func ;
	Data_smoke smoke_data = new Data_smoke();
	
	public Cartpage(constantData data,pageElements elem,Functions functions)
	   {
		   data_obj=data;
		   element_obj=elem;
		   func= functions;
	   }

  
   public void cart_test() throws InterruptedException {
	   
	   	System.out.println("\nCart Page");
	   	
		data_obj.driver.get(smoke_data.URL);
		
//		util.Click(element_obj.no);
	   
//	   func.login();
	   
	   for(int j = 0; j < smoke_data.itemlist.length; j++)
		{
					
			util.Click(element_obj.srch);
				
			util.Sendkeys(element_obj.srchIP,smoke_data.itemlist[j]);

			element_obj.srchTxt.submit();
					
			if(util.Isdisplayed(element_obj.PDP_quantity)) 
			{
						
				util.Clear(element_obj.PDP_quantity);
						
				util.AcceptAlertifPresent(data_obj.driver);
						
				util.Clear(element_obj.PDP_quantity);
						
				util.AcceptAlertifPresent(data_obj.driver);
						
				util.Sendkeys(element_obj.PDP_quantity,smoke_data.qty[j]);	
				
				//Capturing Product price
				
				String prc = element_obj.driver.findElement(By.xpath("//div[@class='product-price']//child::span[@class='price-sales']")).getText();
				
				smoke_data.PDP_price.add(j, prc);
				
				String nme = element_obj.driver.findElement(By.xpath("//h1[@class='product-name']")).getAttribute("innerText");
				
				smoke_data.PDP_prdName.add(j, nme);
				
				util.Click(element_obj.addcart);
			}

			else 
			{

				System.out.println("Quantity is not displayed");
						
				util.Click(element_obj.addcart);
			}

					
			util.Click(element_obj.miniviewcart);
		}
		
		for(int i = 1; i <= smoke_data.itemlist.length; i++)
		{
			smoke_data.CP_prdName.add(i-1, element_obj.driver.findElement(By.xpath("(//div[@class='name']//child::a)["+i+"]")).getText());
			
			smoke_data.CP_price.add(i-1, element_obj.driver.findElement(By.xpath("(//td[@class='item-price']//child::span)["+i+"]")).getText());
			
		}
		
		Collections.sort(smoke_data.CP_prdName);
		
		Collections.sort(smoke_data.CP_price);
		
		Collections.sort(smoke_data.PDP_prdName);
		
		Collections.sort(smoke_data.PDP_price);
		
		System.out.println("\tSmoke Testing: Product list and Price in Cartpage");
	   	
	   	System.out.println("\t\tTestcase - 4");
	   	
		for(int i = 0; i < smoke_data.itemlist.length; i++)
		{
			if(smoke_data.PDP_prdName.get(i).equalsIgnoreCase(smoke_data.CP_prdName.get(i)))
			{
				System.out.println("\t\t\t"+smoke_data.PDP_prdName.get(i)+" Product name Validation Successfully");
			}
			else
			{
				System.out.println("\t\t\t"+smoke_data.PDP_prdName.get(i)+" Product name Validation Unsuccessfully");
			}
			
			if(smoke_data.PDP_price.get(i).equalsIgnoreCase(smoke_data.CP_price.get(i)))
			{
				System.out.println("\t\t\t"+smoke_data.PDP_price.get(i)+" Price Validation Successfully");
			}
			else
			{
				System.out.println("\t\t\t"+smoke_data.PDP_price.get(i)+" Price Validation Unsuccessfully");
			}
		}
		
//		Update qty
		
		System.out.println("\tSmoke Testing: Update Quantity in Cartpage");
		
		System.out.println("\t\tTestcase - 5");
		
		System.out.println("\t\t\t"+"Total products: "+smoke_data.itemlist.length);
		
		for(int c = 1; c <= smoke_data.itemlist.length; c++)
		{			
			
			data_obj.driver.findElement(By.xpath("(//td[@class='item-quantity']//child::input)["+c+"]")).clear();
			
			data_obj.driver.findElement(By.xpath("(//td[@class='item-quantity']//child::input)["+c+"]")).sendKeys("2");
			
			util.Click(element_obj.updatecart);
			
//			String value = data_obj.driver.findElement(By.xpath("(//td[@class='item-quantity']//child::input)["+c+"]")).getAttribute("value");
			
			if(util.Isdisplayed(data_obj.driver.findElement(By.xpath("(//td[@class='item-quantity']//child::input[@value='2'])"))))
			{
				System.out.println("\t\t\t"+"Product "+c+" updated Successfully");
			}
			else
			{
				System.out.println("\t\t\t"+"Product "+c+" update Unsuccessfully");
			}
			
		}
		
//		Remove prd
		
		System.out.println("\tSmoke Testing: Remove Product in Cartpage");
		
		System.out.println("\t\tTestcase - 6");
		
		System.out.println("\t\t\tTotal products: "+smoke_data.itemlist.length);
		
		for(int c = 1; c <= smoke_data.itemlist.length; c++)
		{
			
			data_obj.driver.findElement(By.xpath("(//tr[@class='cart-row']//following-sibling::button[@value='Remove'])[2]")).click();
			
			System.out.println("\t\t\tProduct "+c+" removed successfully");
		}
		
//		util.WaitAndClick(element_obj.checkout);
		
//		data_obj.driver.close();
	   
   }
   
   public void guestCheckout() throws Exception
   {
	   System.out.println("\tSmoke Testing: Guest Checkout from Cartpage");
		
	   System.out.println("\t\tTestcase - 7");
	   
	   func.Add_product(smoke_data.itemlist, smoke_data.qty);
	   
	   func.guestCheckout(smoke_data.email);
	   
	   if(util.Isdisplayed(element_obj.driver.findElement(By.xpath("//h2[text()='Shipping']"))))
	   {
		   System.out.println("\t\t\tGuest checkout verified Successfully");
		   
		   util.Click(element_obj.POviewcart);
		   
		   for(int c = 1; c <= smoke_data.itemlist.length; c++)
			{
				data_obj.driver.findElement(By.xpath("(//tr[@class='cart-row']//following-sibling::button[@value='Remove'])[2]")).click();
			}
	   }
	   else
	   {
		   System.out.println("\t\t\tGuest checkout Unsuccessful");
		   
		   for(int c = 1; c <= smoke_data.itemlist.length; c++)
			{
				data_obj.driver.findElement(By.xpath("(//tr[@class='cart-row']//following-sibling::button[@value='Remove'])[2]")).click();
			}
	   }
	   
   }
   

}
