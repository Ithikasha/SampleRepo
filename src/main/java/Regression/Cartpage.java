package Regression;

import java.util.Collections;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import Data_Functions.constantData;
import Data_Functions.driverUtil;
import Data_Functions.pageElements;
import Smoke_test.Data_smoke;
import Data_Functions.Functions;

public class Cartpage {
	
	public driverUtil util = new driverUtil();
	constantData data_obj;
	pageElements element_obj;
	Functions func ;
	Data_Regression data_regression = new Data_Regression();
	
	public Cartpage(constantData data,pageElements elem,Functions functions)
	   {
		   data_obj=data;
		   element_obj=elem;
		   func= functions;
	   }

  
   public void cart_test() throws Exception {
	   
	   	System.out.println("\nCart Page");
	   	
		data_obj.driver.get(data_regression.URL);
		
//		if(element_obj.no.isDisplayed())
//		{
//		
//		util.Click(element_obj.no);
//		
//		}
	   
//	   func.login();
	   
	   for(int j = 0; j < data_regression.itemlist.length; j++)
		{
					
			util.Click(element_obj.srch);
			
			util.Click(element_obj.SearchBar);
				
			util.Sendkeys(element_obj.srchIP,data_regression.itemlist[j]);

			element_obj.srchTxt.submit();
					
//			if(smoke_data.qty[j] != "0") 
//			{
						
//				util.Clear(element_obj.PDP_quantity);
//						
//				util.AcceptAlertifPresent(data_obj.driver);
//						
//				util.Clear(element_obj.PDP_quantity);
//						
//				util.AcceptAlertifPresent(data_obj.driver);
//						
//				util.Sendkeys(element_obj.PDP_quantity,smoke_data.qty[j]);	
				
				//Capturing Product price
				
				String prc = element_obj.driver.findElement(By.xpath("//div[@class='product-price']//child::span[@class='price-sales']")).getText();
				
				data_regression.PDP_price.add(j, prc);
				
				String nme = element_obj.driver.findElement(By.xpath("//h1[@class='product-name']")).getAttribute("innerText");
								
				data_regression.PDP_prdName.add(j, nme);
				
				if(util.Isdisplayed(element_obj.preorder))
				{
					util.Click(element_obj.preorder);
					
					util.Click(element_obj.preorder_ack);
					
					util.Click(element_obj.preorder_ATC);
					
					data_regression.preorder_flag++;
					
				}
				
				else
				{
					util.Click(element_obj.addcart);
				}
//			}

//			else 
//			{
//
//				System.out.println("Quantity is not displayed");
//						
//				util.Click(element_obj.addcart);
//			}
				Thread.sleep(2000);
					
			util.Click(element_obj.miniviewcart);
		}
		
		for(int i = 1; i <= data_regression.itemlist.length; i++)
		{
			data_regression.CP_prdName.add(i-1, element_obj.driver.findElement(By.xpath("(//div[@class='name']//child::a)["+i+"]")).getText());
			
			data_regression.CP_price.add(i-1, element_obj.driver.findElement(By.xpath("(//div[@class='item-total item-info-col']//child::span)["+i+"]")).getText());
			
		}
		
		Collections.sort(data_regression.CP_prdName);
		
		Collections.sort(data_regression.CP_price);
		
		Collections.sort(data_regression.PDP_prdName);
		
		Collections.sort(data_regression.PDP_price);
		
//		System.out.println(smoke_data.CP_prdName);
//		
//		System.out.println(smoke_data.PDP_prdName);
		
		System.out.println("\tSmoke Testing: Product list and Price in Cartpage");
	   	
	   	System.out.println("\t\tTestcase - 25");
	   	
	   	int fail = 0;
	   	
		for(int i = 0; i < data_regression.itemlist.length; i++)
		{
			if(data_regression.PDP_prdName.contains(data_regression.CP_prdName.get(i).toUpperCase()))
			{
				System.out.println("\t\t\t"+" Product "+(i+1)+" Name Validation Successful");
			}
			else
			{
				System.out.println("\t\t\t"+"Product "+(i+1)+" Name Validation Unsuccessful");
				fail++;
			}
			
			if(data_regression.PDP_price.contains(data_regression.CP_price.get(i)))
			{
				System.out.println("\t\t\t"+" Product "+(i+1)+" Price Validation Successful");
			}
			else
			{
				System.out.println("\\t\\t\\t\"+\"Product"+(i+1)+" Price Validation Unsuccessful");
				fail++;
			}
		}
	   	
		
		if(fail>0)
		{
			func.write_Regressiontest(false, 25);
		}
		else
		{
			func.write_Regressiontest(true, 25);
		}
		
//		Update qty
		
		System.out.println("\tSmoke Testing: Update Quantity in Cartpage");
		
		System.out.println("\t\tTestcase - 26");
		
		fail = 0;
		
		System.out.println("\t\t\t"+"Total products: "+data_regression.itemlist.length);
		
		for(int c = 1; c <= data_regression.itemlist.length; c++)
		{			
			if(data_obj.driver.findElement(By.xpath("(//div[@class='name']//child::a)["+c+"]")).getText().contains("Digital Download"))
			{
				System.out.println("\t\t\t"+"Digital Product quantity should not be more than 1 - Successful");
			}
			else
			{
				data_obj.driver.findElement(By.xpath("(//div[@class='c-product-quantity']//child::input)["+c+"]")).clear();
				
				data_obj.driver.findElement(By.xpath("(//div[@class='c-product-quantity']//child::input)["+c+"]")).sendKeys("2");
										
				//Scroll and click
				
//				int elementPosition = element_obj.updatecart.getLocation().getY();
//				String js = String.format("window.scroll(0, %s)", elementPosition);
//				((JavascriptExecutor)data_obj.driver).executeScript(js);
				element_obj.ClicktoUpdatecart.click();
				
				
							
				if(util.Isdisplayed(element_obj.CP_quantity))
				{
					System.out.println("\t\t\t"+"Product "+c+" updated Successfully");
				}
				else
				{
					System.out.println("\t\t\t"+"Product "+c+" update Unsuccessfully");
					fail++;
				}
			}
			
		}
		if(fail>0)
		{
			func.write_Regressiontest(false, 26);
		}
		else
		{
			func.write_Regressiontest(true, 26);
		}
		
//		Remove prd
		
		System.out.println("\tSmoke Testing: Remove Product in Cartpage");
		
		System.out.println("\t\tTestcase - 27");
		
		System.out.println("\t\t\tTotal products: "+data_regression.itemlist.length);
		
		for(int c = 1; c <= data_regression.itemlist.length; c++)
		{
			
			util.WaitAndClick(element_obj.remove);
			
			System.out.println("\t\t\tProduct "+c+" removed successfully");
		}
		
		func.write_Regressiontest(true, 27);
		
//		util.WaitAndClick(element_obj.checkout);
		
//		data_obj.driver.close();
	   
   }
   
   public void guestCheckout() throws Exception
   {
	   System.out.println("\tSmoke Testing: Guest Checkout from Cartpage");
		
	   System.out.println("\t\tTestcase - 28");
	   
	   System.out.println("\nCart Page");
	   	
//		data_obj.driver.get(data_regression.URL);
//		
//		util.Click(element_obj.no);
	   
	   func.Add_product(data_regression.itemlist, data_regression.qty);
	   
	   func.guestCheckout(data_regression.email);
	   
	   if(util.Isdisplayed(element_obj.driver.findElement(By.xpath("(//h2[text()='1. Shipping'])[2]"))))
	   {
		   System.out.println("\t\t\tGuest checkout verified Successfully");
		   
		   func.write_Regressiontest(true, 28);
		   
		   util.Click(element_obj.POviewcart);
		   
		   for(int c = 1; c <= data_regression.itemlist.length; c++)
			{
			   
				util.WaitAndClick(element_obj.remove);
			   
			}
	   }
	   else
	   {
		   System.out.println("\t\t\tGuest checkout Unsuccessful");
		   
		   func.write_Regressiontest(false, 28);
		   
		   for(int c = 1; c <= data_regression.itemlist.length; c++)
			{
				util.WaitAndClick(element_obj.remove);
			}
	   }
	   
   }
   

}
