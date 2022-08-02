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
import org.testng.Assert;

import Data_Functions.*;
import Email.SendingEmail;
import Smoke_test.Data_smoke;
public class SiteMonitoring {
	
	public static driverUtil util = new driverUtil();
	
	public static constantData data = new constantData();
	
	public static SiteMonitoringConstantData SiteData = new SiteMonitoringConstantData();
	
	public static SendingEmail email = new SendingEmail();
    
    public static Data_smoke data_smoke = new Data_smoke();
    
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
			
		functions.Add_product("DON'T TREAD ON ME T-SHIRT - MEDIUM");
		
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
		functions.Add_Preorder("LIVE METALLICA: WERCHTER, BELGIUM - JULY 1, 2022 (2CD)");
		
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
		
		functions.Add_product("DON'T TREAD ON ME T-SHIRT - MEDIUM");
		
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
		
		functions.Add_product("DON'T TREAD ON ME T-SHIRT - MEDIUM");
		
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
		
		Thread.sleep(10000);
		
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
		
		}
		
		
	}
	
	
	public static void ServiceCloud() throws Exception
	{
		Groupfield();
		
		OrderandStoreSupportoption();
		
		Ordersupport();
		
		shipping();
		
		Return();
	
		Exchange();
		
		Vinyl();
		
		Others();
		
	}
	
	
	public static void Groupfield() throws InterruptedException, IOException 
	
	{
		GroupDropdown();
		
		GeneralInquiries();
		
		OrderandStoreSupport();
					
	}
	
	
	public static void OrderandStoreSupportoption() throws InterruptedException, IOException
	{
		
		OrderandStoreSupportfields();
		
		HowCanWeHelpOptions(); 
		
	}
	
	public static void Ordersupport() throws InterruptedException, IOException
	{
		
		OrderSupport();
		
		OrderNumberFieldYes();
		
		OrderNumberFieldNo();
			
	}
	
	public static void shipping() throws InterruptedException, IOException
	{
		
		Shipping();
		
		TrackingnumberYes();
			
	}
	
	public static void Return() throws InterruptedException, IOException
	{
		
		ReturnOrderNumber();
		
		ReasonforReturn();
		
		Qtyfield();
		
		Itemfield();
		
		Sizefield();
		
		AddExtrafield();
		
		RemoveExtrafield();
		
	}
	
	public static void Exchange() throws InterruptedException, IOException
	{
		ExchangeOrderNumber();
		
		ReasonforExchange();
		
		Items_to_return_Qty();
		
		Items_to_return_Item();
		
		Items_to_return_Size();
		
		Exchange_AddExtrafield();
		
		Exchange_RemoveExtrafield();
		
		ExchangeItems_Qty();

		ExchangeItems_Item();

		ExchangeItems_Size();

		Exchange_Addanotherexchangeitem();

		Exchange_RemoveExchangeItem();
	
	}
	
	public static void Vinyl() throws InterruptedException, IOException
	{
		
		VinylClub();
		
		VinylClub_OrderNumberFieldYes();
		
	}
	
	public static void Others() throws InterruptedException, IOException
	{
		Other();
	}
	
	 public static void GroupDropdown() throws InterruptedException, IOException
	 {
		 
//		util.Click(elements.HelpLink);
		
//		util.Click(elements.CreateNewSupportTicket_Button);
		 
		 data.driver.get("https://www.metallica.com/contactus/");
		 
		 util.Click(elements.no);
		
		util.Sendkeys(elements.Ticketemail, data.username);
		
		util.Sendkeys(elements.TicketFirstname, data.firstname);
		
		util.Sendkeys(elements.TicketLastname, data.lastname);
		
		util.Sendkeys(elements.TicketSubject, data.subject);
		
		util.Click(elements.GroupDropdown);
			
		if(util.Isdisplayed(elements.GeneralInquiries))
		{
			if(util.Isdisplayed(elements.OrderandStoreSupport)) {
			
			System.out.println("\t\t\t"+"GeneralInquiries and Order & Store Support field displayed Successfully");
			
			SiteData.result = true;
			
			functions.ServiceCloud(SiteData.result, 1);
		}
		
		}
		else
			
		{
			System.out.println("\t\t\t"+"GeneralInquiries and Order & Store Support field displayed Unuccessful");
			
			SiteData.result = false;
			
			functions.ServiceCloud(SiteData.result, 1);
		}
		

	}
	 
	 public static void GeneralInquiries() throws InterruptedException, IOException
	 {
		 
		 Select General = new Select(elements.GroupDropdown);
		    
		 General.selectByVisibleText("General Inquiries");
		 
		 if(util.Isdisplayed(elements.GeneralInquiries))
			{
				
				System.out.println("\t\t\t"+"GeneralInquiries field displayed Successfully");
				
				SiteData.result = true;
				
				functions.ServiceCloud(SiteData.result, 2);
			
		
			}
			else
				
			{
				System.out.println("\t\t\t"+"GeneralInquiries field displayed Unuccessful");
				
				SiteData.result = false;
				
				functions.ServiceCloud(SiteData.result, 2);
			}
				 
	 }
	 
	 public static void OrderandStoreSupport() throws InterruptedException, IOException
	 {
		 
		 Select General = new Select(elements.GroupDropdown);
		    
		 General.selectByVisibleText("Order & Store Support");
		 
		 		if(util.Isdisplayed(elements.OrderandStoreSupport)) {
				
				System.out.println("\t\t\t"+"Order & Store Support field displayed Successfully");
				
				SiteData.result = true;
				
				functions.ServiceCloud(SiteData.result, 3);
			
			
			}
			else
				
			{
				System.out.println("\t\t\t"+"Order & Store Support field displayed Unuccessful");
				
				SiteData.result = false;
				
				functions.ServiceCloud(SiteData.result, 3);
			}
			

	 }
	 
	 
	 

	public static void OrderandStoreSupportfields() throws InterruptedException, IOException {
		
		
		 Select OrderandStoreSupport = new Select(elements.GroupDropdown);
	    
		 OrderandStoreSupport.selectByVisibleText("Order & Store Support");
		 
		 if(util.Isdisplayed(elements.HowCanWeHelp))
			{
				
				System.out.println("\t\t\t"+"OrderandStoreSupport field validation Successful");
				
				SiteData.result = true;
				
				functions.ServiceCloud(SiteData.result, 4);
			
		
			}
			else
				
			{
				System.out.println("\t\t\t"+"OrderandStoreSupport field validation Unsuccessful");
				
				SiteData.result = false;
				
				functions.ServiceCloud(SiteData.result, 4);
			}
		 
		
	}
	
	
	public static void HowCanWeHelpOptions() throws InterruptedException, IOException 
	{
		
		util.Click(elements.HowCanWeHelpOptions);
		
		if(util.Isdisplayed(elements.OrderSupport)) 
		{
			if(util.Isdisplayed(elements.Shipping))
			{
				if(util.Isdisplayed(elements.Return))
				{
					if(util.Isdisplayed(elements.Exchange))
					{
						if(util.Isdisplayed(elements.VinylClub))
						{
							if(util.Isdisplayed(elements.Other)) 
							{
								System.out.println("\t\t\t"+"How Can We Help options validation Successful");
								
								SiteData.result = true;
								
								functions.ServiceCloud(SiteData.result, 5);
									
							}
							
							else
								
							{
								System.out.println("\t\t\t"+"How Can We Help options validation Unsuccessful");
								
								SiteData.result = false;
								
								functions.ServiceCloud(SiteData.result, 5);
							}
						}
					}
				}
				
			}
			
		}
			
	}
	
	public static void OrderSupport() throws InterruptedException, IOException 
	
	{
		
		Select OrderSupport = new Select(elements.HowCanWeHelpOptions);
		
		OrderSupport.selectByVisibleText("Order Support");
		
		if(util.Isdisplayed(elements.Didyoualreadyplacedyourorder)) 
		{
			System.out.println("\t\t\t"+"Order support validation Successful");
			
			SiteData.result = true;
			
			functions.ServiceCloud(SiteData.result, 6);
				
		}
		
		else
			
		{
			System.out.println("\t\t\t"+"order support validation Unsuccessful");
			
			SiteData.result = false;
			
			functions.ServiceCloud(SiteData.result, 6);
		}
		
		
	}
	
	public static void OrderNumberFieldYes() throws InterruptedException, IOException
	{
		Select OrderNumberField = new Select(elements.Didyoualreadyplacedyourorder);
		
		OrderNumberField.selectByVisibleText("Yes");
		
		if(util.Isdisplayed(elements.OrderNumberField)) 
		{
			System.out.println("\t\t\t"+"Please provide your order number field validation Successful");
			
			SiteData.result = true;
			
			functions.ServiceCloud(SiteData.result, 7);
				
		}
		
		else
			
		{
			System.out.println("\t\t\t"+"Please provide your order number field validation Unsuccessful");
			
			SiteData.result = false;
			
			functions.ServiceCloud(SiteData.result, 7);
		}
		
			
	}

	public static void OrderNumberFieldNo() throws InterruptedException, IOException
	{
		
		Select OrderNumberField = new Select(elements.Didyoualreadyplacedyourorder);
		
		OrderNumberField.selectByVisibleText("No");
		
		if(util.Isdisplayed(elements.DescriptionField)) 
		{
			System.out.println("\t\t\t"+"Description field validation Successful");
			
			SiteData.result = true;
			
			functions.ServiceCloud(SiteData.result, 8);
				
		}
		
		else
			
		{
			System.out.println("\t\t\t"+"Description field validation Unsuccessful");
			
			SiteData.result = false;
			
			functions.ServiceCloud(SiteData.result, 8);
		}
		
		
	}
	
	public static void Shipping() throws InterruptedException, IOException
	{
		Select OrderSupport = new Select(elements.HowCanWeHelpOptions);
		
		OrderSupport.selectByVisibleText("Shipping");
		
		if(util.Isdisplayed(elements.Hasyourorderalreadyshipped)) 
		{
			System.out.println("\t\t\t"+"Shipping validation Successful");
			
			SiteData.result = true;
			
			functions.ServiceCloud(SiteData.result, 9);
				
		}
		
		else
			
		{
			System.out.println("\t\t\t"+"Shipping validation Unsuccessful");
			
			SiteData.result = false;
			
			functions.ServiceCloud(SiteData.result, 9);
		}
		
		
	}
	
	public static void TrackingnumberYes() throws InterruptedException, IOException 
	{
		Select Trackingnumberfield = new Select(elements.Hasyourorderalreadyshipped);
				
		Trackingnumberfield.selectByVisibleText("Yes");	
		
		if(util.Isdisplayed(elements.Trackingnumberfield)) 
		{
			System.out.println("\t\t\t"+"Please provide your tracking number field validation Successful");
			
			SiteData.result = true;
			
			functions.ServiceCloud(SiteData.result, 10);
				
		}
		
		else
			
		{
			System.out.println("\t\t\t"+"Please provide your tracking number field validation Unsuccessful");
			
			SiteData.result = false;
			
			functions.ServiceCloud(SiteData.result, 10);		
			
		}
		
		
	}
	
	public static void ReturnOrderNumber() throws InterruptedException, IOException
	
	{
		Select Return = new Select(elements.HowCanWeHelpOptions);
		
		Return.selectByVisibleText("Return");
		
		if(util.Isdisplayed(elements.OrderNumber)) 
		{
			System.out.println("\t\t\t"+"Order number field in Return option validation Successful");
			
			SiteData.result = true;
			
			functions.ServiceCloud(SiteData.result, 11);
				
		}
		
		else
			
		{
			System.out.println("\t\t\t"+"Order number field in Return option field validation Unsuccessful");
			
			SiteData.result = false;
			
			functions.ServiceCloud(SiteData.result, 11);
		}
	}

	public static void ReasonforReturn() throws InterruptedException, IOException
	{
		Select Return = new Select(elements.HowCanWeHelpOptions);
		
		Return.selectByVisibleText("Return");
		
		if(util.Isdisplayed(elements.ReasonforReturn)) 
		{
			System.out.println("\t\t\t"+"Reason for return field in Return option validation Successful");
			
			SiteData.result = true;
			
			functions.ServiceCloud(SiteData.result, 12);
				
		}
		
		else
			
		{
			System.out.println("\t\t\t"+"Reason for return field in Return option field validation Unsuccessful");
			
			SiteData.result = false;
			
			functions.ServiceCloud(SiteData.result, 12);
		}
		
				
	}

	public static void Qtyfield() throws InterruptedException, IOException
	{
		Select Return = new Select(elements.HowCanWeHelpOptions);
		
		Return.selectByVisibleText("Return");
		
		if(util.Isdisplayed(elements.QtyField)) 
		{
			System.out.println("\t\t\t"+"QTY field in Return option validation Successful");
			
			SiteData.result = true;
			
			functions.ServiceCloud(SiteData.result, 13);
				
		}
		
		else
			
		{
			System.out.println("\t\t\t"+"QTY field in Return option validation Unsuccessful");
			
			SiteData.result = false;
			
			functions.ServiceCloud(SiteData.result, 13);
		}
		
		
	}

	
	public static void Itemfield() throws InterruptedException, IOException
	{
		Select Return = new Select(elements.HowCanWeHelpOptions);
		
		Return.selectByVisibleText("Return");
		
		if(util.Isdisplayed(elements.Itemfield)) 
		{
			System.out.println("\t\t\t"+"Item field in Return option validation Successful");
			
			SiteData.result = true;
			
			functions.ServiceCloud(SiteData.result, 14);
				
		}
		
		else
			
		{
			System.out.println("\t\t\t"+"Item field in Return option validation Unsuccessful");
			
			SiteData.result = false;
			
			functions.ServiceCloud(SiteData.result, 14);
		}
		
		
	}
	
	
	public static void Sizefield() throws InterruptedException, IOException
	{
		Select Return = new Select(elements.HowCanWeHelpOptions);
		
		Return.selectByVisibleText("Return");
		
		if(util.Isdisplayed(elements.Sizefield)) 
		{
			System.out.println("\t\t\t"+"Size field in Return option validation Successful");
			
			SiteData.result = true;
			
			functions.ServiceCloud(SiteData.result, 15);
				
		}
		
		else
			
		{
			System.out.println("\t\t\t"+"Size field in Return option validation Unsuccessful");
			
			SiteData.result = false;
			
			functions.ServiceCloud(SiteData.result, 15);
		}
		
		
	}
	
	public static void AddExtrafield() throws InterruptedException, IOException
	{
		Select Return = new Select(elements.HowCanWeHelpOptions);
		
		Return.selectByVisibleText("Return");
		
		util.Click(elements.AddanotherReturnItem);
		
		if(util.Isdisplayed(elements.AddExtrafield)) 
		{
			System.out.println("\t\t\t"+"Extrafield in Return option validation Successful");
			
			SiteData.result = true;
			
			functions.ServiceCloud(SiteData.result, 16);
				
		}
		
		else
			
		{
			System.out.println("\t\t\t"+"Extrafield in Return option validation Unsuccessful");
			
			SiteData.result = false;
			
			functions.ServiceCloud(SiteData.result, 16);
		}
			
	}
	
		public static void RemoveExtrafield() throws InterruptedException, IOException
		{
			Select Return = new Select(elements.HowCanWeHelpOptions);
			
			Return.selectByVisibleText("Return");
			
			util.Click(elements.RemoveExtrafield);
			
			if(util.Isdisplayed(elements.QtyField)) 
			{
				System.out.println("\t\t\t"+"Extrafield in Return option removed Successfully");
				
				SiteData.result = true;
				
				functions.ServiceCloud(SiteData.result, 17);
					
			}
			
			else
				
			{
				System.out.println("\t\t\t"+"Extrafield in Return option removed Unsuccessfully");
				
				SiteData.result = false;
				
				functions.ServiceCloud(SiteData.result, 17);
			}
		
		}
	

		public static void ExchangeOrderNumber() throws InterruptedException, IOException
		
		{
			Select Return = new Select(elements.HowCanWeHelpOptions);
			
			Return.selectByVisibleText("Exchange");
			
			if(util.Isdisplayed(elements.OrderNumber)) 
			{
				System.out.println("\t\t\t"+"Order number field in Exchange option validation Successful");
				
				SiteData.result = true;
				
				functions.ServiceCloud(SiteData.result, 18);
					
			}
			
			else
				
			{
				System.out.println("\t\t\t"+"Order number field in Exchange option field validation Unsuccessful");
				
				SiteData.result = false;
				
				functions.ServiceCloud(SiteData.result, 18);
			}
		}
		
		public static void ReasonforExchange() throws InterruptedException, IOException
		{
			Select Return = new Select(elements.HowCanWeHelpOptions);
			
			Return.selectByVisibleText("Exchange");
			
			if(util.Isdisplayed(elements.ReasonforExchange)) 
			{
				System.out.println("\t\t\t"+"Reason for Exchange field in Return option validation Successful");
				
				SiteData.result = true;
				
				functions.ServiceCloud(SiteData.result, 19);
					
			}
			
			else
				
			{
				System.out.println("\t\t\t"+"Reason for Exchange field in Return option field validation Unsuccessful");
				
				SiteData.result = false;
				
				functions.ServiceCloud(SiteData.result, 19);
			}
			
		 }

		
		public static void Items_to_return_Qty() throws InterruptedException, IOException
		{
			
			Select Return = new Select(elements.HowCanWeHelpOptions);
			
			Return.selectByVisibleText("Exchange");
			
			if(util.Isdisplayed(elements.QtyField)) 
			{
				System.out.println("\t\t\t"+"QTY field in Items to return fields in Exchange option validation Successful");
				
				SiteData.result = true;
				
				functions.ServiceCloud(SiteData.result, 20);
					
			}
			
			else
				
			{
				System.out.println("\t\t\t"+"QTY field in Items to return fields in Exchange option validation Unsuccessful");
				
				SiteData.result = false;
				
				functions.ServiceCloud(SiteData.result, 20);
			}
			
			
		}
			
		public static void Items_to_return_Item() throws InterruptedException, IOException
		{
			
			Select Return = new Select(elements.HowCanWeHelpOptions);
			
			Return.selectByVisibleText("Exchange");
			
			if(util.Isdisplayed(elements.Itemfield)) 
			{
				System.out.println("\t\t\t"+"Item field in Items to return fields in Exchange option validation Successful");
				
				SiteData.result = true;
				
				functions.ServiceCloud(SiteData.result, 21);
					
			}
			
			else
				
			{
				System.out.println("\t\t\t"+"Item field in Items to return fields in Exchange option validation Unsuccessful");
				
				SiteData.result = false;
				
				functions.ServiceCloud(SiteData.result, 21);
			}
			
			
		}	
			
		
		public static void Items_to_return_Size() throws InterruptedException, IOException
		{
			
			Select Return = new Select(elements.HowCanWeHelpOptions);
			
			Return.selectByVisibleText("Exchange");
			
			if(util.Isdisplayed(elements.Sizefield)) 
			{
				System.out.println("\t\t\t"+"Size field in Items to return fields in Exchange option validation Successful");
				
				SiteData.result = true;
				
				functions.ServiceCloud(SiteData.result, 22);
					
			}
			
			else
				
			{
				System.out.println("\t\t\t"+"Size field in Items to return fields in Exchange option validation Unsuccessful");
				
				SiteData.result = false;
				
				functions.ServiceCloud(SiteData.result, 22);
			}
			
			
		}	
		
		public static void Exchange_AddExtrafield() throws InterruptedException, IOException
		{
			Select Return = new Select(elements.HowCanWeHelpOptions);
			
			Return.selectByVisibleText("Exchange");
			
			util.Click(elements.AddanotherReturnItem);
			
			if(util.Isdisplayed(elements.AddExtrafield)) 
			{
				System.out.println("\t\t\t"+"Extrafield in Exchange option validation Successful");
				
				SiteData.result = true;
				
				functions.ServiceCloud(SiteData.result, 23);
					
			}
			
			else
				
			{
				System.out.println("\t\t\t"+"Extrafield in Exchange option validation Unsuccessful");
				
				SiteData.result = false;
				
				functions.ServiceCloud(SiteData.result, 23);
			}
				
		}
		
		public static void Exchange_RemoveExtrafield() throws InterruptedException, IOException
		{
			Select Return = new Select(elements.HowCanWeHelpOptions);
			
			Return.selectByVisibleText("Exchange");
			
			util.Click(elements.RemoveExtrafield);
			
			if(util.Isdisplayed(elements.QtyField)) 
			{
				System.out.println("\t\t\t"+"Extrafield in Exchange option removed Successfully");
				
				SiteData.result = true;
				
				functions.ServiceCloud(SiteData.result, 24);
					
			}
			
			else
				
			{
				System.out.println("\t\t\t"+"Extrafield in Exchange option removed Unsuccessfully");
				
				SiteData.result = false;
				
				functions.ServiceCloud(SiteData.result, 24);
			}
		
		}
		
		public static void ExchangeItems_Qty() throws InterruptedException, IOException
		{
			
			Select Return = new Select(elements.HowCanWeHelpOptions);
			
			Return.selectByVisibleText("Exchange");
			
			if(util.Isdisplayed(elements.ExchangeItems_Qty)) 
			{
				System.out.println("\t\t\t"+"QTY field in Exchange Items validation Successful");
				
				SiteData.result = true;
				
				functions.ServiceCloud(SiteData.result, 25);
					
			}
			
			else
				
			{
				System.out.println("\t\t\t"+"QTY field in Exchange Items validation Unsuccessful");
				
				SiteData.result = false;
				
				functions.ServiceCloud(SiteData.result, 25);
			}
			
			
		}
		
		public static void ExchangeItems_Item() throws InterruptedException, IOException
		{
			
			Select Return = new Select(elements.HowCanWeHelpOptions);
			
			Return.selectByVisibleText("Exchange");
			
			if(util.Isdisplayed(elements.ExchangeItems_Item)) 
			{
				System.out.println("\t\t\t"+"Item field in Exchange Items validation Successful");
				
				SiteData.result = true;
				
				functions.ServiceCloud(SiteData.result, 26);
					
			}
			
			else
				
			{
				System.out.println("\t\t\t"+"Item field in Exchange Items validation Unsuccessful");
				
				SiteData.result = false;
				
				functions.ServiceCloud(SiteData.result, 26);
			}
			
			
		}
	
		
		public static void ExchangeItems_Size() throws InterruptedException, IOException
		{
			
			Select Return = new Select(elements.HowCanWeHelpOptions);
			
			Return.selectByVisibleText("Exchange");
			
			if(util.Isdisplayed(elements.ExchangeItems_Size)) 
			{
				System.out.println("\t\t\t"+"Size field in Exchange Items validation Successful");
				
				SiteData.result = true;
				
				functions.ServiceCloud(SiteData.result, 27);
					
			}
			
			else
				
			{
				System.out.println("\t\t\t"+"Size field in Exchange Items validation Unsuccessful");
				
				SiteData.result = false;
				
				functions.ServiceCloud(SiteData.result, 27);
			}
			
			
		}

		public static void Exchange_Addanotherexchangeitem() throws InterruptedException, IOException
		{
			Select Return = new Select(elements.HowCanWeHelpOptions);
			
			Return.selectByVisibleText("Exchange");
			
			util.Click(elements.AddanotherExchangeItem);
			
			if(util.Isdisplayed(elements.AddExtraExchangeField)) 
			{
				System.out.println("\t\t\t"+"Adding Extrafield in Exchange Items validation Successful");
				
				SiteData.result = true;
				
				functions.ServiceCloud(SiteData.result, 28);
					
			}
			
			else
				
			{
				System.out.println("\t\t\t"+"Adding Extrafield in Exchange Items validation Unsuccessful");
				
				SiteData.result = false;
				
				functions.ServiceCloud(SiteData.result, 28);
			}
				
		}

		public static void Exchange_RemoveExchangeItem() throws InterruptedException, IOException
		{
			Select Return = new Select(elements.HowCanWeHelpOptions);
			
			Return.selectByVisibleText("Exchange");
			
			util.Click(elements.RemoveExtraExchangeField);
			
			if(util.Isdisplayed(elements.ExchangeItems_Qty)) 
			{
				System.out.println("\t\t\t"+"Extra Exchange field removed Successfully");
				
				SiteData.result = true;
				
				functions.ServiceCloud(SiteData.result, 29);
					
			}
			
			else
				
			{
				System.out.println("\t\t\t"+"Extra Exchange field removed Unsuccessfully");
				
				SiteData.result = false;
				
				functions.ServiceCloud(SiteData.result, 29);
			}
		
		}

		public static void VinylClub() throws InterruptedException, IOException
		{
			Select OrderSupport = new Select(elements.HowCanWeHelpOptions);
			
			OrderSupport.selectByVisibleText("Vinyl Club");
			
			if(util.Isdisplayed(elements.Didyoualreadyplacedyourorder)) 
			{
				System.out.println("\t\t\t"+"Vinyl Club validation Successful");
				
				SiteData.result = true;
				
				functions.ServiceCloud(SiteData.result, 30);
					
			}
			
			else
				
			{
				System.out.println("\t\t\t"+"Vinyl Club validation Unsuccessful");
				
				SiteData.result = false;
				
				functions.ServiceCloud(SiteData.result, 30);
			}
			
			
		}
	
		public static void VinylClub_OrderNumberFieldYes() throws InterruptedException, IOException
		{
			Select OrderNumberField = new Select(elements.Didyoualreadyplacedyourorder);
			
			OrderNumberField.selectByVisibleText("Yes");
			
			if(util.Isdisplayed(elements.OrderNumberField)) 
			{
				System.out.println("\t\t\t"+"Please provide your order number field in Vinyl Club option validation Successful");
				
				SiteData.result = true;
				
				functions.ServiceCloud(SiteData.result, 31);
					
			}
			
			else
				
			{
				System.out.println("\t\t\t"+"Please provide your order number field in Vinyl Club option validation Unsuccessful");
				
				SiteData.result = false;
				
				functions.ServiceCloud(SiteData.result, 31);
			}
			
				
		}
	
		public static void Other() throws InterruptedException, IOException
		
		{
			Select Return = new Select(elements.HowCanWeHelpOptions);
			
			Return.selectByVisibleText("Other");
			
			if(util.Isdisplayed(elements.DescriptionField)) 
			{
				System.out.println("\t\t\t"+"Other option from Group selection validation Successful");
				
				SiteData.result = true;
				
				functions.ServiceCloud(SiteData.result, 32);
					
			}
			
			else
				
			{
				System.out.println("\t\t\t"+"Other option from Group selection validation Unsuccessful");
				
				SiteData.result = false;
				
				functions.ServiceCloud(SiteData.result, 32);
			}
			
		}
		
//		public static void Mandatoryfields()
//		
//		{
//			int fail = 0;
//			
//			switch(1) 
//			{
//			
//			case 1:
//						
//			}
					
//		}
						
}
		
		



