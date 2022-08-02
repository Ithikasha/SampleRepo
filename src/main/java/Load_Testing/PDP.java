package Load_Testing;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import Data_Functions.Functions;
import Data_Functions.constantData;
import Data_Functions.driverUtil;
import Data_Functions.pageElements;
import Regression.*;

public class PDP {
	
	public driverUtil util = new driverUtil();
	constantData data_obj;
	pageElements element_obj;
	Functions func ;
	Data_Regression data_Regression = new Data_Regression();
	
	public PDP(constantData data,pageElements elem,Functions functions)
	{
		   data_obj=data;
		   element_obj=elem;
		   func= functions;
	}
	
	public void PDP_Testing() throws Exception
	{
		
//		data_obj.driver.get(data_Regression.URL);
//		
//		if(util.Isdisplayed(element_obj.no))
//		{
//			util.Click(element_obj.no);
//		}
//		
		util.Click(element_obj.srch);
			
		util.Sendkeys(element_obj.srchIP, data_Regression.instock1);

		element_obj.srchTxt.submit();
			
		System.out.println("Product Detail Page");
		
		System.out.println("\tSmoke Testing: Product Detail Page_Image and Description");
			
		System.out.println("\t\tTestcase - 23");
			
		int fail = 0;
			
		if(util.Isdisplayed(element_obj.driver.findElement(By.xpath("//div[@class='product-primary-image']"))))
		{
			System.out.println("\t\t\t"+"Image verification Successful");
		}
		else
		{
			System.out.println("\t\t\t"+"Image verification Unsuccessful");
			fail++;
		}
		
		if(util.Isdisplayed(element_obj.driver.findElement(By.xpath("//div[@class='short-description']"))))
		{
			System.out.println("\t\t\t"+"Description verification Successful");
		}
		else
		{
			System.out.println("\t\t\t"+"Description verification Unsuccessful");
			fail++;
		}
			
		if(fail<=0)
		{
			System.out.println("\t\t\t"+"Image and Description verification Successful");
				
			data_Regression.result = true;
				
			func.write_Regressiontest(data_Regression.result, 23);
		}
		else
		{
			System.out.println("Image and Description verification Unsuccessful");
				
			data_Regression.result = false;
				
			func.write_Regressiontest(data_Regression.result, 23);
				
		}
			
		fail = 0;
		
		System.out.println("\tSmoke Testing: Einstein Product Suggestion");
		
		System.out.println("\t\tTestcase - 24");
		
//		int elementPosition = element_obj.driver.findElement(By.xpath("//div[@class='slick-track']")).getLocation().getY();
//		String js = String.format("window.scroll(0, %s)", elementPosition);
//		((JavascriptExecutor)data_obj.driver).executeScript(js);
//		element_obj.driver.findElement(By.xpath("//div[@class='slick-track']")).click();
		
		if(util.Isdisplayed(element_obj.driver.findElement(By.xpath("//div[@class='slick-track']"))))
		{
			System.out.println("Einstein Product suggestion successful");
				
			data_Regression.result = true;
				
			func.write_Regressiontest(data_Regression.result, 24);
		}
		else
		{
			System.out.println("Einstein Product suggestion Unsuccessful");
				
			data_Regression.result = false;
				
			func.write_Regressiontest(data_Regression.result, 24);
				
		}
			
		System.out.println("\tSmoke Testing: Shared Links ");
		
		System.out.println("\t\tTestcase - 25");
		
		if(util.Isdisplayed(element_obj.driver.findElement(By.xpath("//i[@class='pinterest-follow-white-icon']"))))
		{
			System.out.println("\t\t\t"+"Pinterest Link verification Successful");
		}
		else
		{
			System.out.println("\t\t\t"+"Pinterest Link verification Unsuccessful");
			fail++;
		}
		
		if(util.Isdisplayed(element_obj.driver.findElement(By.xpath("//i[@class='twitter-follow-white-icon']"))))
		{
			System.out.println("\t\t\t"+"Twitter Link verification Successful");
		}
		else
		{
			System.out.println("\t\t\t"+"Twitter Link verification Unsuccessful");
			fail++;
		}
		
		if(util.Isdisplayed(element_obj.driver.findElement(By.xpath("//i[@class='facebook-follow-white-icon']"))))
		{
			System.out.println("\t\t\t"+"Facebook Link verification Successful");
		}
		else
		{
			System.out.println("\t\t\t"+"Facebook Link verification Unsuccessful");
			fail++;
		}
		
		if(fail<=0)
		{
			System.out.println("\t\t\t"+"Shared Links verification Successful");
				
			data_Regression.result = true;
				
			func.write_Regressiontest(data_Regression.result, 25);
		}
		else
		{
			System.out.println("\t\t\t"+"Shared Links verification Unsuccessful");
				
			data_Regression.result = false;
				
			func.write_Regressiontest(data_Regression.result, 25);
				
		}
			
		fail = 0;
		
		System.out.println("\tSmoke Testing: Product Quantity");
			
		System.out.println("\t\tTestcase - 26");
			
		util.Clear(element_obj.PDP_quantity);
			
		util.AcceptAlertifPresent(data_obj.driver);
					
		util.Clear(element_obj.PDP_quantity);
					
		util.AcceptAlertifPresent(data_obj.driver);
					
		util.Sendkeys(element_obj.PDP_quantity,"2");
		
		util.Click(element_obj.addcart);
			
		util.Click(element_obj.miniviewcart);
		
//		String temp = element_obj.CP_quantity.getAttribute("value").strip();
		
//		System.out.println(element_obj.CP_quantity.getAttribute("value").strip());
		
		if(element_obj.CP_quantity.getAttribute("value").equals("2"))
		{
			System.out.println("\t\t\t"+"Product Update Successful");
			
			data_Regression.result = true;
			
			func.write_Regressiontest(data_Regression.result, 26);
		}
		else
		{
			System.out.println("\t\t\t"+"Product Update Unsuccessful");
			
			data_Regression.result = false;
			
			func.write_Regressiontest(data_Regression.result, 26);
		}
		
		util.Click(element_obj.driver.findElement(By.xpath("(//tr[@class='cart-row']//following-sibling::button[@value='Remove'])[2]")));
		
		System.out.println("\tSmoke Testing: Pre-order Product");
		
		System.out.println("\t\tTestcase - 27");
		
		util.Click(element_obj.srch);
		
		util.Sendkeys(element_obj.srchIP,"LIVE METALLICA: WERCHTER, BELGIUM - JULY 1, 2022 (2CD)");

		element_obj.srchTxt.submit();
		
//		element_obj.PreorderLogin.click();
//		
//		func.smoke_login(data_Regression.email, data_Regression.password);
//		
//		util.Click(element_obj.srch);
//		
//		util.Sendkeys(element_obj.srchIP,"LIVE METALLICA: WERCHTER, BELGIUM - JULY 1, 2022 (2CD)");
//
//		element_obj.srchTxt.submit();
		
		if(util.Isdisplayed(element_obj.One_year))
		{
			System.out.println("Pre-order button is unavailable");
		}
	
		else
		{
			
		util.Isdisplayed(element_obj.preorder);
			
		util.Click(element_obj.preorder);
				
		util.Click(element_obj.preorder_ack);
				
		util.Click(element_obj.preorder_ATC);			
			
		util.Click(element_obj.addcart);
		
		if(util.Isdisplayed(element_obj.miniviewcart))
		{
			System.out.println("\t\t\t"+"Pre-order Product Validation Successful");
			
			util.Click(element_obj.miniviewcart);
			
			util.Click(element_obj.driver.findElement(By.xpath("(//tr[@class='cart-row']//following-sibling::button[@value='Remove'])[2]")));
			
			data_Regression.result = true;
			
			func.write_Regressiontest(data_Regression.result, 27);
		}
		else
		{
			System.out.println("\t\t\t"+"Pre-order Product Validation Unsuccessful");
			
			data_Regression.result = false;
			
			func.write_Regressiontest(data_Regression.result, 27);
		}
		
		fail = 0;
		
//		util.WaitAndClick(element_obj.MyAccount);
//		
//		util.WaitAndClick(element_obj.Logout);
			
		}		
	
	}

}
