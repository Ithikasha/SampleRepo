package SiteMonitoring;
import org.apache.poi.hssf.record.aggregates.DataValidityTable;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import Data_Functions.*;
import Smoke_test.Data_smoke;
public class SiteMonitoring {
	
	public static driverUtil util = new driverUtil();
	
	public static constantData data = new constantData();
    
    public static Data_smoke data_smoke = new Data_smoke();
    
    public static pageElements elements ;
	
    public static Functions functions;
	
	public static void main(String args[]) throws Exception
	{
	    		    
	    data.driver = util.chrome();
	    
	    elements = new pageElements(data.driver);
	    
	    functions = new Functions(data,elements);
	
		data.driver.manage().window().maximize();
		
//		data.driver.get(data.DEV_url);
		
//		util.Click(elements.no);
//		
//		functions.login();
		
//		ShipperHQ();
		
//	System.out.println(Avalara());
		
//		System.out.println(UPS());
//		
//		System.out.println(Loqate());
		
//		System.out.println(Cloudinary());
		
//		System.out.println(KnightLab());
		
//		System.out.println(Discourse());
		
//		System.out.println(DigitalOcean());
		
		PayPal();
		
		ApplePay();
		
	}
	
	public static boolean ShipperHQ() throws Exception
	{		
		
		if(ShipperHQ_Instock() && ShipperHQ_Preorder() && ShipperHQ_Vinyl())
		{
			return true;
		}
		else
			return false;
	}
	
	public static boolean ShipperHQ_Instock() throws Exception
	{
		
		functions.Add_product("METAL UP YOUR ASS T-SHIRT-M");
		
		util.Click(elements.checkout);
		
		util.waitForElementToLoad(elements.shipping_Container);
		
		if(util.Isdisplayed(elements.shippingmethods_shipnow))
		{
			util.Click(elements.SP_BackToCart);
			
			util.Click(elements.remove);
			
			return true;
		}
		else
		{
			util.Click(elements.SP_BackToCart);
			
			util.Click(elements.remove);
			
			return false;
		}
		
	}
	
	public static boolean ShipperHQ_Preorder() throws Exception  
	{
		functions.Add_Preorder("THE ABCS OF METALLICA BOOK");
		
		util.Click(elements.checkout);
		
		util.waitForElementToLoad(elements.shipping_Container);
		
		if(util.Isdisplayed(elements.shippingmethods_shiplater))
		{
			util.Click(elements.SP_BackToCart);
			
			util.Click(elements.remove);
			
			return true;
		}
		else
		{
			util.Click(elements.SP_BackToCart);
		
			util.Click(elements.remove);
			
			return false;
		}
		
	}
	
	public static boolean ShipperHQ_Vinyl() throws Exception
	{
		functions.Add_product("vinylclub2022-Q");
		
		util.Click(elements.checkout);
		
		util.waitForElementToLoad(elements.shipping_Container);
		
		if(util.Isdisplayed(elements.shippingmethods_vinyl))
		{
			util.Click(elements.SP_BackToCart);
			
			util.Click(elements.remove);
			
			return true;
		}
		else
		{
			util.Click(elements.SP_BackToCart);
			
			util.Click(elements.remove);
			
			return false;
		}
		
	}
	
	public static boolean Avalara() throws Exception
	{
		functions.Add_product("METAL UP YOUR ASS T-SHIRT-M");
		
		if(Avalara_TaxableDomestic()) 
		{
			if(Avalara_NonTaxableDomestic())
			{
				if(Avalara_TaxableInternational())
				{
					if(Avalara_NonTaxableInternational())
					{						
//						util.Click(elements.remove);
				
						return true;
					}
					else
					{						
						util.Click(elements.remove);
						
						return false;
					}
				}
				else
				{					
					util.Click(elements.remove);
					
					return false;
				}
			}
			else
			{		
				util.Click(elements.remove);
				
				return false;
			}
		}
		else
		{			
			util.Click(elements.remove);
		
			return false;
		}
	
	}
	
	public static boolean Avalara_TaxableDomestic() throws InterruptedException
	{
		
		util.Click(elements.checkout);

		util.Clear(elements.address1);
		
		util.Sendkeys(elements.address1,"5411 3rd St");

		util.Clear(elements.city);
		
		util.Sendkeys(elements.city,"San Francisco");
		
		Select country = new Select(elements.countryField);
		country.selectByVisibleText("United States");

		util.Clear(elements.zipcode);
		
		util.Sendkeys(elements.zipcode,"94124-2605");
		
		Select state = new Select(elements.stateField);
		state.selectByVisibleText("California");
		
		util.Clear(elements.phone);
		
		util.Sendkeys(elements.phone,"9858989588");
		
		util.WaitAndClick(elements.continuebill);
		
		if(util.Isdisplayed(elements.userAddress)) 
		{
			util.WaitAndClick(elements.userAddress);
		}
		
//		Thread.sleep(2000);
		
		util.waitForElementToLoad(elements.cardname);
		
		if(elements.BP_tax.getText().toString().strip() != "$0.00")
		{
			System.out.println("True");
						
			util.WaitAndClick(elements.EditCart);
			
			return true;
		}
		else
		{
			System.out.println("False");
			
			util.WaitAndClick(elements.EditCart);
			
			return false;
		}
			
		
	}
	
	public static boolean Avalara_NonTaxableDomestic() throws InterruptedException
	{
				
		util.Click(elements.checkout);

		util.Clear(elements.address1);
		
		util.Sendkeys(elements.address1,"1667 K Street NW");

		util.Clear(elements.city);
		
		util.Sendkeys(elements.city,"Washington");
		
		Select country = new Select(elements.countryField);
		country.selectByVisibleText("United States");

		util.Clear(elements.zipcode);
		
		util.Sendkeys(elements.zipcode,"20006");
		
		Select state = new Select(elements.stateField);
		state.selectByVisibleText("Washington");
		
		util.Clear(elements.phone);
		
		util.Sendkeys(elements.phone,"9858989588");
				
		util.WaitAndClick(elements.continuebill);
		
		if(util.Isdisplayed(elements.userAddress)) 
		{
			util.WaitAndClick(elements.userAddress);
		}
		
//		Thread.sleep(2000);
		
		util.waitForElementToLoad(elements.cardname);
		
		if(elements.BP_tax.getText().toString().strip().equalsIgnoreCase("$0.00"))
			
		{
			System.out.println("True");
						
			util.WaitAndClick(elements.EditCart);
			
			return true;
		}
		
		else
		{
			System.out.println("False");
			
			util.WaitAndClick(elements.EditCart);
			
			return false;
		}
			
		
	}

	public static boolean Avalara_TaxableInternational() throws Exception
	{
		util.Click(elements.checkout);
		
		util.Clear(elements.address1);
		
		util.Sendkeys(elements.address1,"Europa-Allee 6");

		util.Clear(elements.city);
		
		util.Sendkeys(elements.city,"Frankfurt Am Main");
		
		Select country = new Select(elements.countryField);
		country.selectByVisibleText("Germany");

		util.Clear(elements.zipcode);
		
		util.Sendkeys(elements.zipcode,"60327");
		
		util.Clear(elements.phone);
		
		util.Sendkeys(elements.phone,"9858989588");
		
		util.WaitAndClick(elements.continuebill);
		
		if(util.Isdisplayed(elements.userAddress)) 
		{
			util.WaitAndClick(elements.userAddress);
		}
		
		Thread.sleep(2000);
		
		if(elements.BP_tax.getText().toString().strip() != "$0.00")
		{
			System.out.println("True");
						
			util.WaitAndClick(elements.EditCart);
			
			return true;
		}
		
		else
		{
			System.out.println("False");
			
			util.WaitAndClick(elements.EditCart);
			
			return false;
		}
		
	}
	
	public static boolean Avalara_NonTaxableInternational() throws Exception
	{
		util.Click(elements.checkout);
		
		util.Clear(elements.address1);
		
		util.Sendkeys(elements.address1,"1200 Av De Germain-Des-Prés");

		util.Clear(elements.city);
		
		util.Sendkeys(elements.city,"Quebec");
		
		Select country = new Select(elements.countryField);
		country.selectByVisibleText("Canada");

		util.Clear(elements.zipcode);
		
		util.Sendkeys(elements.zipcode,"G1V 3M7");
		
		Select state = new Select(elements.CAstateField);
		state.selectByVisibleText("Quebec");
		
		util.Clear(elements.phone);
		
		util.Sendkeys(elements.phone,"9858989588");
		
		util.WaitAndClick(elements.continuebill);
		
		if(util.Isdisplayed(elements.userAddress)) 
		{
			util.WaitAndClick(elements.userAddress);
		}
		
//		Thread.sleep(2000);
		
		util.waitForElementToLoad(elements.cardname);

		if(elements.BP_tax.getText().toString().strip().equalsIgnoreCase("$0.00"))
			
		{
			System.out.println("True");
						
			util.WaitAndClick(elements.EditCart);
			
			return true;
		}
		
		else
		{
			System.out.println("False");
			
			util.WaitAndClick(elements.EditCart);
			
			return false;
		}
		
	}
	
	public static boolean UPS() throws InterruptedException
	{
		
		functions.Add_product("METAL UP YOUR ASS T-SHIRT-M");
		
		util.Click(elements.checkout);

		util.Clear(elements.address1);
		
		util.Sendkeys(elements.address1,"1667 K Street NW");

		util.Clear(elements.city);
		
		util.Sendkeys(elements.city,"Washington");
		
		Select country = new Select(elements.countryField);
		country.selectByVisibleText("United States");

		util.Clear(elements.zipcode);
		
		util.Sendkeys(elements.zipcode,"20006");
		
		Select state = new Select(elements.stateField);
		state.selectByVisibleText("Washington");
		
		util.Clear(elements.phone);
		
		util.Sendkeys(elements.phone,"9858989588");
				
		util.WaitAndClick(elements.continuebill);
		
		if(util.Isdisplayed(elements.userAddress)) 
			
		{
			util.WaitAndClick(elements.userAddress);
			
			util.WaitAndClick(elements.EditCart);
			
		   // System.out.println("True");
			
			return true;
		}
		
		else 
		{
			
		return false;
		
		}
	}
	
	public static boolean Loqate() throws InterruptedException
	{
	
	util.Click(elements.checkout);
	
	util.Clear(elements.address1);
	
	util.Sendkeys(elements.address1,"Europa-Allee 6");

	util.Clear(elements.city);
	
	util.Sendkeys(elements.city,"Frankfurt Am Main");
	
	Select country = new Select(elements.countryField);
	country.selectByVisibleText("Germany");

	util.Clear(elements.zipcode);
	
	util.Sendkeys(elements.zipcode,"60327");
	
	util.Clear(elements.phone);
	
	util.Sendkeys(elements.phone,"9858989588");
	
	util.WaitAndClick(elements.continuebill);
	
	if(util.Isdisplayed(elements.userAddress)) 
		{
			util.WaitAndClick(elements.userAddress);
		
			util.WaitAndClick(elements.EditCart);
		
//			data.driver.close();
		
			return true;
		
		}	
	else
		{
		
			return false;
		
		}	
	}
	
	public static void ApplePay() throws InterruptedException
	{
//		data.driver.get(data.ProdTomsUrl);
		
		util.Sendkeys(elements.TomsEmail, data.ProdTomsusername);
		
		util.Sendkeys(elements.TomsPassword, data.ProdTomspassword);
		
		util.Click(elements.TomsLogin);
		
		data.driver.get("https://toms03.tejassoftware.com/Order/Search#?page=1&pageSize=50&criteria=F.PaymentMethodId.in.29");
		
		String ApplePayOrderDate = elements.TOMS_OrderDate.getText().toString();	
		
	}
	
	public static void PayPal() throws InterruptedException
	{
	
//		data.driver.get(data.ProdTomsUrl);
		
//		util.Sendkeys(elements.TomsEmail, data.ProdTomsusername);
//		
//		util.Sendkeys(elements.TomsPassword, data.ProdTomspassword);
//		
//		util.Click(elements.TomsLogin);
		
		data.driver.get("https://toms03.tejassoftware.com/Order/Search#?page=1&pageSize=50&criteria=F.PaymentMethodId.in.8");
		
		String PayPalOrderDate = elements.TOMS_OrderDate.getText().toString();	
	
	}
	
	public static boolean Cloudinary() throws InterruptedException
	{
		
//	data.driver = util.chrome();	
//	
//	data.driver.manage().window().maximize();
		
	data.driver.get(data.Cloudinary_Url);
	
	if(util.Isdisplayed(elements.CloudinaryImg))
		
	{
		
		return true;
	}
	else
	{
		return false;
		
	}
	}
	
	public static boolean DigitalOcean() throws InterruptedException
	{
		
		data.driver.get(data.Prod_url);
		
		util.Click(elements.no);
		
		functions.login();
		
		util.Click(elements.MyAccount_Order); 
		
		util.Click(elements.OrderDetail);
		
		util.Click(elements.DigitalDownload);
		
		return false;
		
		
	}
	
	public static boolean KnightLab() throws InterruptedException
	{
		
		data.driver.get(data.Knightlab_Url);
		
		if(util.MatchPageTitle(data.driver, "Band Timeline | Metallica.com"))
			
		{
			
			return true;
		}
	
	
		else
	
		{
			return false;
		
		}
		
	   
	}
	
	public static void ServiceCloud()
	{
		
	}
	
	public static boolean Discourse()
	{

		data.driver.get(data.Discourse_Url);
		
		if(util.MatchPageTitle(data.driver, "Metallica Forums"))
			
		{
			
			return true;
		}
	
	
		else
	
		{
			return false;
		
		}
		
		
	}
	
}
