package SiteMonitoring;

import java.io.File;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.hssf.record.aggregates.DataValidityTable;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import Data_Functions.*;
import Email.SendingEmail;
import Regression.ContactUsForm;
import Regression.Homepage;
import Smoke_test.Data_smoke;
public class SiteMonitoring {
	
	public static driverUtil util = new driverUtil();
	
	public static constantData data = new constantData();
	
	public static SiteMonitoringConstantData SiteData = new SiteMonitoringConstantData();
	
	public static SendingEmail email = new SendingEmail();
    
    public static Data_smoke data_smoke = new Data_smoke();
    
    public static ContactUsForm ContactUs = new ContactUsForm();
       
    public static pageElements elements ;
	
    public static Functions functions;
    
    public static String Email="";
	
	public static void main(String args[]) throws Exception
	
	{
		
		data.driver = util.chrome();
	    
	    elements = new pageElements(data.driver);
	    
	    functions = new Functions(data,elements);
	
		data.driver.manage().window().maximize();
		
//		Email = Email.concat("First line\n");
//		
//		Email = Email.concat("Second line");
//		
//		System.out.println(Email);
		
		data.driver.get(data.Prod_url);
		
		util.Click(elements.no);
		
		functions.PRD_login();
		
		ShipperHQ();
		
		Avalara();
		
		UPS();
		
		Loqate();
		
		ApplePay();
		
		PayPal();
		
		Cloudinary();
		
		KnightLab();
		
		DigitalOcean();
		
		Discourse();	
		
//		ServiceCloud();
		
		MiniCartOverlay();  
		
		ContactUs.main(args);
		
		data.driver.close();
		
	}
	
	public static void ShipperHQ() throws Exception
	
	{		
//		System.out.println("ShipperHQ");
		
//		System.out.println("\tShipperHQ_Instock Testing");
		
		ShipperHQ_Instock();
		
//		System.out.println("\tShipperHQ_Pre-Order Testing");
		
		ShipperHQ_Preorder();
		
//		System.out.println("\tShipperHQ_VinylclubSubscription Testing");
		
//		ShipperHQ_Vinyl();
		
	}
	
	public static void ShipperHQ_Instock() throws Exception
	{
			
		functions.Add_product("BUFFALO 2022 TOUR T-SHIRT - MEDIUM");
		
		util.Click(elements.checkout);
		
		util.waitForElementToLoad(elements.shipping_Container);
		
		if(util.Isdisplayed(elements.shippingmethods_shipnow))
		{
			util.Click(elements.SP_BackToCart);
			
			util.Click(elements.remove);
			
			System.out.println("\t\t\t"+"ShipperHQ_Instock validation successful");
			
			SiteData.result = true;
					
			functions.write_SiteMonitoring(SiteData.result, 1);
			
		}
		else
		{
			util.Click(elements.SP_BackToCart);
			
			util.Click(elements.remove);
			
			System.out.println("\t\t\t"+"ShipperHQ_Instock validation unsuccessful");
			
			SiteData.result = false;
			
			functions.write_SiteMonitoring(SiteData.result, 1);
			
			Email = Email.concat("Shipper HQ_Instock failed");
			
//			data.email(Email);
		}
		
		
		
		
		
	}
	
	public static void ShipperHQ_Preorder() throws Exception  
	{
		functions.Add_Preorder("LIVE METALLICA: HELPING HANDS BENEFIT CONCERT IN LOS ANGELES CA - DECEMBER 16 2022 (2CD)");
		
		util.Click(elements.checkout);
		
		util.waitForElementToLoad(elements.shipping_Container);
		
		if(util.Isdisplayed(elements.shippingmethods_shiplater))
		{
			util.Click(elements.SP_BackToCart);
			
			util.Click(elements.remove);
			
			System.out.println("\t\t\t"+"ShipperHQ_Pre-Order validation successful");
			
			SiteData.result = true;
					
			functions.write_SiteMonitoring(SiteData.result, 2);
		}
		else
		{
			util.Click(elements.SP_BackToCart);
		
			util.Click(elements.remove);
			
			System.out.println("\t\t\t"+"ShipperHQ_Pre-Order validation unsuccessful");
			
			SiteData.result = false;
			
			functions.write_SiteMonitoring(SiteData.result, 2);
		}
		
	}
	
	public static void ShipperHQ_Vinyl() throws Exception
	{
		functions.Add_product("vinylclub2022-Q");
		
		util.Click(elements.checkout);
		
		util.waitForElementToLoad(elements.shipping_Container);
		
		if(util.Isdisplayed(elements.shippingmethods_vinyl))
		{
			util.Click(elements.SP_BackToCart);
			
			util.Click(elements.remove);
			
			System.out.println("\t\t\t"+"ShipperHQ_Vinylclub validation successful");
			
			SiteData.result = true;
					
			functions.write_SiteMonitoring(SiteData.result, 3);
		}
		else
		{
			util.Click(elements.SP_BackToCart);
			
			util.Click(elements.remove);
			
			System.out.println("\t\t\t"+"ShipperHQ_Vinylclub validation unsuccessful");
			
			SiteData.result = false;
			
			functions.write_SiteMonitoring(SiteData.result, 3);
		}
		
	}
	
	public static void Avalara() throws Exception
	{
		
		functions.Add_product("BUFFALO 2022 TOUR T-SHIRT - MEDIUM");
		
//		System.out.println("\tAvalara_TaxableDomestic Testing");
		
		Avalara_TaxableDomestic();
		
//		System.out.println("\tAvalara_NonTaxableDomestic Testing");
		
		Avalara_NonTaxableDomestic();
		
//		System.out.println("\tAvalara_TaxableInternational Testing");
		
		Avalara_TaxableInternational();
		
//		System.out.println("\tAvalara_NonTaxableInternational Testing");
		
		Avalara_NonTaxableInternational();
		
	}
	
	public static void Avalara_TaxableDomestic() throws Exception
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
			
			System.out.println("\t\t\t"+"Avalara_TaxableDomestic validation successful");
			
			SiteData.result = true;
					
			functions.write_SiteMonitoring(SiteData.result, 4);
		}
		else
		{
			System.out.println("False");
			
			util.WaitAndClick(elements.EditCart);
			
			System.out.println("\t\t\t"+"Avalara_TaxableDomestic validation unsuccessful");
			
			SiteData.result = false;
			
			functions.write_SiteMonitoring(SiteData.result, 4);
		}
			
		
	}
	
	public static void Avalara_NonTaxableDomestic() throws Exception
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
			
			System.out.println("\t\t\t"+"Avalara_NonTaxableDomestic validation successful");
			
			SiteData.result = true;
					
			functions.write_SiteMonitoring(SiteData.result, 5);
		}
		
		else
		{
			System.out.println("False");
			
			util.WaitAndClick(elements.EditCart);
			
			System.out.println("\t\t\t"+"Avalara_NonTaxableDomestic validation unsuccessful");
			
			SiteData.result = false;
			
			functions.write_SiteMonitoring(SiteData.result, 5);
		}
			
		
	}

	public static void Avalara_TaxableInternational() throws Exception
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
			
			System.out.println("\t\t\t"+"Avalara_TaxableInternational validation successful");
			
			SiteData.result = true;
					
			functions.write_SiteMonitoring(SiteData.result, 6);
		}
		
		else
		{
			System.out.println("False");
			
			util.WaitAndClick(elements.EditCart);
			
			System.out.println("\t\t\t"+"Avalara_TaxableInternational validation unsuccessful");
			
			SiteData.result = false;
			
			functions.write_SiteMonitoring(SiteData.result, 6);
		}
		
	}
	
	public static void Avalara_NonTaxableInternational() throws Exception
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
			
			System.out.println("\t\t\t"+"Avalara_NonTaxableInternational validation successful");
			
			SiteData.result = true;
					
			functions.write_SiteMonitoring(SiteData.result, 7);
		}
		
		else
		{
			System.out.println("False");
			
			util.WaitAndClick(elements.EditCart);
			
			System.out.println("\t\t\t"+"Avalara_NonTaxableInternational validation unsuccessful");
			
			SiteData.result = false;
			
			functions.write_SiteMonitoring(SiteData.result, 7);
		}
		
	}
	
	public static void UPS() throws Exception
	{
		
		System.out.println("\tUPS Testing");
		
		functions.Add_product("BUFFALO 2022 TOUR T-SHIRT - MEDIUM");
		
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
			
			System.out.println("\t\t\t"+"UPS validation successful");
			
			SiteData.result = true;
					
			functions.write_SiteMonitoring(SiteData.result, 8);
		}
		
		else 
		{
			
			System.out.println("\t\t\t"+"UPS validation unsuccessful");
			
			SiteData.result = false;
			
			functions.write_SiteMonitoring(SiteData.result, 8);
		
		}
	}
	
	public static void Loqate() throws Exception
	{
	
		System.out.println("\tLoqate Testing");	
		
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
		
			System.out.println("\t\t\t"+"Loqate validation successful");
			
			SiteData.result = true;
					
			functions.write_SiteMonitoring(SiteData.result, 9);		
		}	
	else
		{
		
		System.out.println("\t\t\t"+"Loqate validation unsuccessful");
		
		SiteData.result = false;
		
		functions.write_SiteMonitoring(SiteData.result, 9);
		
		}	
	}
	
	public static void ApplePay() throws Exception
	{
		data.driver.get(data.ProdTomsUrl);
		
		util.Sendkeys(elements.TomsEmail, data.ProdTomsusername);
		
		util.Sendkeys(elements.TomsPassword, data.ProdTomspassword);
		
		util.Click(elements.TomsLogin);
		
		data.driver.get(SiteData.ApplepayURL);
		
		Thread.sleep(2000);
		
		SiteData.ApplePay = elements.TOMS_OrderDate.getText().toString().substring(0, 10);
		
		System.out.println(SiteData.ApplePay+"---"+data.CurrentDate);
		
		if(SiteData.ApplePay.equals(data.CurrentDate.trim()))
		{
			System.out.println("\t\t\t"+"Applepay validation successful");
			
			SiteData.result = true;
			
			functions.write_SiteMonitoring(SiteData.result, 10);		
		}
		
		else
			
		{
			System.out.println("\t\t\t"+"Applepay validation unsuccessful");
			
			SiteData.result = false;
			
			functions.write_SiteMonitoring(SiteData.result, 10);
		}
		
	}
	
	public static void PayPal() throws Exception
	{
	
//		data.driver.get(data.ProdTomsUrl);
		
//		util.Sendkeys(elements.TomsEmail, data.ProdTomsusername);
//		
//		util.Sendkeys(elements.TomsPassword, data.ProdTomspassword);
//		
//		util.Click(elements.TomsLogin);
		
		data.driver.get(SiteData.PaypalURL);
		
		SiteData.PayPal = elements.TOMS_OrderDate.getText().toString().substring(0, 10);	
		
		System.out.println(SiteData.PayPal+"---"+data.CurrentDate);
		
		if(SiteData.PayPal.equals(data.CurrentDate.trim()))
		{
			System.out.println("\t\t\t"+"Paypal validation successful");
			
			SiteData.result = true;
			
			functions.write_SiteMonitoring(SiteData.result, 11);		
		}
		
		else
			
		{
			System.out.println("\t\t\t"+"Paypal validation unsuccessful");
			
			SiteData.result = false;
			
			functions.write_SiteMonitoring(SiteData.result, 11);
	
		}
	}
	public static void Cloudinary() throws Exception
	{
		
//	data.driver = util.chrome();	
//	
//	data.driver.manage().window().maximize();
		
	data.driver.get(data.Cloudinary_Url);
	
	if(util.Isdisplayed(elements.CloudinaryImg))
		
	{
		
		System.out.println("\t\t\t"+"Cloudinary validation successful");
		
		SiteData.result = true;
		
		functions.write_SiteMonitoring(SiteData.result, 12);	
	}
	else
	{
		System.out.println("\t\t\t"+"Cloudinary validation unsuccessful");
		
		SiteData.result = false;
		
		functions.write_SiteMonitoring(SiteData.result, 12);
		
	}
	}
	
	public static void DigitalOcean() throws InterruptedException, Exception
	{
		
//		data.driver.get(data.Prod_url);
//		
//		util.Click(elements.no);
//		
//		functions.login();
		
		util.Click(elements.Account_button);
		
		util.Click(elements.MyAccount_button);
		
		util.Click(elements.MyAccount_Order); 
		
		util.Click(elements.OrderDetail);
		
		util.Click(elements.DigitalDownload);
		
		Thread.sleep(30000);
		
		Actions action =new Actions(data.driver);
		
		action.sendKeys(Keys.ENTER);
		
		Thread.sleep(10000);
		
		File f = new File("C:\\Users\\UTIS LAPTOP 38\\Downloads\\I-DISAPPEAR_mp3.zip"); 
		
//		System.out.println(f.exists());
			
		Thread.sleep(10000);
		
		if(f.exists())
			
		{
			System.out.println("\t\t\t"+"Digital Ocean validation successful");
			
			SiteData.result = true;
			
			functions.write_SiteMonitoring(SiteData.result, 13);	
		}
		else
		{
			
			System.out.println("\t\t\t"+"Digital Ocean validation unsuccessful");
			
			SiteData.result = false;
			
			functions.write_SiteMonitoring(SiteData.result, 13);
						
		}
		
		f.delete();
	}
	
	public static void KnightLab() throws Exception
	{
		
		data.driver.get(data.Knightlab_Url);
		
//		util.Click(elements.no);
		
		Thread.sleep(5000);
		
		if(util.Isdisplayed(elements.KnightLab))
			
		{
			
			System.out.println("\t\t\t"+"KnightLab validation successful");
			
			SiteData.result = true;
			
			functions.write_SiteMonitoring(SiteData.result, 14);	
		}
	
	
		else
	
		{

			System.out.println("\t\t\t"+"KnightLab validation unsuccessful");
			
			SiteData.result = false;
			
			functions.write_SiteMonitoring(SiteData.result, 14);
			
		
		}
		
	   
	}
	
	public static void Discourse() throws Exception
	{

		data.driver.get(data.Discourse_Url);
		
		if(util.MatchPageTitle(data.driver, "Metallica Forums"))
			
		{
			
			System.out.println("\t\t\t"+"Discourse validation successful");
			
			SiteData.result = true;
			
			functions.write_SiteMonitoring(SiteData.result, 15);	
		}
	
	
		else
	
		{
			System.out.println("\t\t\t"+"Discourse validation unsuccessful");
			
			SiteData.result = false;
			
			functions.write_SiteMonitoring(SiteData.result, 15);
			
			data.driver.close();
		
		}
		
		
	}
	
	public static void MiniCartOverlay() throws Exception
	{
		
		
		data.driver.get(data.Prod_url);
		
		if(util.Isdisplayed(elements.no))
		{
			util.Click(elements.no);
		}
	
//		func.PRD_login();
		
		 util.Click(elements.MetStoreIcon);
		 
		 Actions act = new Actions(data.driver);
		 
		 act.moveToElement(elements.Product).perform();
		 
		 util.jClick(data.driver,elements.Quickview);
		 
		 if(util.Isdisplayed(elements.SizeSmall))
		 {
			 util.jClick(data.driver,elements.SizeSmall);
			 
			
		}
		 
		 
		 
			if(util.Isdisplayed(elements.preorder))
			{
				util.jClick(data.driver,elements.preorder);
				
				util.jClick(data.driver,elements.preorder_ack);
				
				util.jClick(data.driver,elements.preorder_ATC);
				
			}
			
			else
			{
				util.jClick(data.driver,elements.addcart);
			}
		  
		 	 
	
//		func.MiniCart("DON'T TREAD ON ME T-SHIRT - MEDIUM");
		 
		String opacity = elements.Overlay.getCssValue("opacity");
		 				
		System.out.println(opacity);
		
		if(opacity.equals("0.7"))
		{
			System.out.println("\t\t\t"+"Opacity = 0.7 validation successful");
			
			SiteData.result = true;
			
			functions.write_SiteMonitoring(SiteData.result, 16);
			
		}
		else
		{
			
			System.out.println("\t\t\t"+"Opacity = 0.7 validation unsuccessful");
			
			SiteData.result = true;
			
			functions.write_SiteMonitoring(SiteData.result, 16);
			
			data.driver.close();
			
		}
		
	}
	
						
}
		
		



