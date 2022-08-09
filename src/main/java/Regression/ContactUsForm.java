package Regression;

import java.io.IOException;

import org.openqa.selenium.support.ui.Select;


import Data_Functions.*;
import Email.SendingEmail;
import SiteMonitoring.SiteMonitoringConstantData;
import Smoke_test.Data_smoke;


public class ContactUsForm {
	
	public static driverUtil util = new driverUtil();
	
	public static constantData data = new constantData();
	
	public static SiteMonitoringConstantData SiteData = new SiteMonitoringConstantData();
	
	public static SendingEmail email = new SendingEmail();
    
    public static Data_smoke data_smoke = new Data_smoke();
    
    public static pageElements elements ;

    public static Functions functions;

	public static void main(String[] args) throws Exception 
	
	{

		data.driver = util.chrome();
	    
	    elements = new pageElements(data.driver);
	    
	    functions = new Functions(data,elements);
	
		data.driver.manage().window().maximize();
		
	    ServiceCloud();
		
//		data.driver.close();
		
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
		
		Mandatoryfields();
		
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
	
	
	public static void Mandatoryfields() throws InterruptedException
	{
		
		MandatoryfieldsValidation();
		
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
		
		util.Sendkeys(elements.TicketDescription, data.Description);
		
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
		
		if(util.Isdisplayed(elements.AddanotherReturnItem)) 
		{
			util.Click(elements.AddanotherReturnItem);
			
		}
		
		else
		{
			System.out.println("First Add Extra field link is not displayed");
			
		}
		
		if(util.Isdisplayed(elements.AddanotherReturnItem))
		{
			
			util.Click(elements.AddanotherReturnItem);
		
		}
		
		else
		{
			System.out.println("Second Add Extra field link is not displayed ");
			
		}
		if(util.Isdisplayed(elements.Extrafield)) 
		{
			System.out.println("\t\t\t"+"Extrafields in Return option validation Successful");
			
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
			
			if(util.Isdisplayed(elements.FirstRemoveExtrafield))
			{
			
			util.Click(elements.FirstRemoveExtrafield);
			
			}
			
			else
			{
				
				System.out.println("First Remove link is not displayed");
				
			}	
			
			if(util.Isdisplayed(elements.SecondRemoveExtrafield))
			{
			
			util.Click(elements.SecondRemoveExtrafield);
			
			}
			
			else
			{
				
				System.out.println("Second Remove link is not displayed");
				
			}	
			
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
			
			util.Click(elements.FirstRemoveExtrafield);
			
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
				System.out.println("\t\t\t"+"Other option from Group selection validation Successful\n\n\n");
				
				SiteData.result = true;
				
				functions.ServiceCloud(SiteData.result, 32);
					
			}
			
			else
				
			{
				System.out.println("\t\t\t"+"Other option from Group selection validation Unsuccessful\n\n\n");
				
				SiteData.result = false;
				
				functions.ServiceCloud(SiteData.result, 32);
			}
			
		}
		
		public static void MandatoryfieldsValidation() throws InterruptedException
		
		{
			
			System.out.println("Mandatory Fields Validation\n");
			
			int fail = 0;
			
			switch(1) 
			{
			
			case 1:
					
				util.Clear(elements.Ticketemail);
				
				util.Click(elements.TicketSubmit);	
				
				if(util.Isdisplayed(elements.EmailError))
				{
					
					System.out.println("\t\t\t"+"Mandatory field: Email verified Successfully");
				}
				
				else
				{
					System.out.println("\t\t\t"+"Mandatory field: Email verify Unsuccessful");
					fail++;
					
					SiteData.FailedMandatoryField.concat("Email, ");
					
				
				}
				
				
			case 2:
				
				util.Sendkeys(elements.Ticketemail, data.username);
				
				util.Clear(elements.TicketFirstname);
				
				util.Click(elements.TicketSubmit);
				
				if(util.Isdisplayed(elements.FirstnameError))
				{
					
					System.out.println("\t\t\t"+"Mandatory field: First name verified Successfully");
				}
				else
				{
					System.out.println("\t\t\t"+"Mandatory field: First name verify Unsuccessful");
					fail++;
					
					
				}
				
				
			case 3:
				
				util.Sendkeys(elements.TicketFirstname, data.firstname);
				
				util.Clear(elements.TicketLastname);
				
				util.Click(elements.TicketSubmit);
				

				if(util.Isdisplayed(elements.LastnameError))
				{
					
					System.out.println("\t\t\t"+"Mandatory field: Last name verified Successfully");
				}
				else
				{
					System.out.println("\t\t\t"+"Mandatory field: Last name verify Unsuccessful");
					fail++;
					
					
				}
				
				
			case 4:
				
				util.Sendkeys(elements.TicketLastname, data.lastname);
				
				util.Clear(elements.TicketSubject);
							
				util.Click(elements.TicketSubmit);
				
				if(util.Isdisplayed(elements.SubjectError))
				{
					
					System.out.println("\t\t\t"+"Mandatory field: Subject verified Successfully");
				}
				else
				{
					System.out.println("\t\t\t"+"Mandatory field: Subject verify Unsuccessful");
					fail++;
					
					
							
				}
				
				
			case 5:
				
				util.Sendkeys(elements.TicketSubject, data.subject);
				
				 Select General = new Select(elements.GroupDropdown);
			    
				 General.selectByVisibleText("Select");
				 
				 util.WaitAndClick(elements.TicketSubmit);
				 
				 if(util.Isdisplayed(elements.GroupDropDownError))
					{
						
						System.out.println("\t\t\t"+"Mandatory field: Group Dropdown verified Successfully");
						
						
					}
					else
					{
						System.out.println("\t\t\t"+"Mandatory field: Group Dropdown verify Unsuccessful");
						fail++;
						
						
					}
				 
			case 6:
				
				//Thread.sleep(2000);
				
				Select OrderandStoreSupport = new Select(elements.SelectGroupwithError);
			    
				 OrderandStoreSupport.selectByVisibleText("Order & Store Support");
				 
				 util.WaitAndClick(elements.TicketSubmit);
				 
				 if(util.Isdisplayed(elements.HowCanWeHelpError))
					{
						
						System.out.println("\t\t\t"+"Mandatory field: How Can We Help Dropdown verified Successfully");
					}
					else
					{
						System.out.println("\t\t\t"+"Mandatory field: How Can We Help Dropdown verify Unsuccessful");
						fail++;
						
						
					}
				
			case 7:
				
				Select Return = new Select(elements.HowCanWeHelpOptions);
				
				Return.selectByVisibleText("Return");
				
				util.Click(elements.TicketSubmit);
				
				 if(util.Isdisplayed(elements.OrderNumberError))
					{
						
						System.out.println("\t\t\t"+"Mandatory field: Order Number field in Return option verified Successfully");
					}
					else
					{
						System.out.println("\t\t\t"+"Mandatory field:  Order Number field in Return option verify Unsuccessful");
						fail++;
						
						
					}
				
			case 8:
				
				util.Sendkeys(elements.ReturnOrderNumber, data.ReturnOrderNumber);
				
				util.Click(elements.TicketSubmit);
				
				 if(util.Isdisplayed(elements.ReturnQtyFieldError))
					{
						
						System.out.println("\t\t\t"+"Mandatory field: QTY field in Return option verified Successfully");
					}
				 
				 if(util.Isdisplayed(elements.ReturnItemFieldError)) 
				 
				 {
					 
					 System.out.println("\t\t\t"+"Mandatory field: Item field in Return option verified Successfully");
					 
				 }
					else
					{
						System.out.println("\t\t\t"+"Mandatory field:  QTY and Item fields in Return option verify Unsuccessful");
						fail++;
						
						
					}
			
				
			case 9:
				
				Select Return1 = new Select(elements.HowCanWeHelpOptions);
				
				Return1.selectByVisibleText("Exchange");
				
				util.Clear(elements.ReturnOrderNumber);
				
				util.Click(elements.TicketSubmit);
				
				if(util.Isdisplayed(elements.OrderNumberError))
				{
					
					System.out.println("\t\t\t"+"Mandatory field: Order Number field in Exchange option verified Successfully");
				}
				
				else
				{
					System.out.println("\t\t\t"+"Mandatory field:  Order Number field in Exchange option verify Unsuccessful");
					fail++;
					
					
				}
				 
				
			case 10:
				
				util.Sendkeys(elements.ReturnOrderNumber, data.ReturnOrderNumber);
				
				util.Click(elements.TicketSubmit);
				
				 if(util.Isdisplayed(elements.ExchangeItemQtyFieldError))
					{
						
						System.out.println("\t\t\t"+"Mandatory field: QTY field in Exchange Item section verified Successfully");
					}
				 
				 if(util.Isdisplayed(elements.ExchangeItemITEMFieldError)) 
				 
				 {
					 
					 System.out.println("\t\t\t"+"Mandatory field: Item field in Exchange Item section verified Successfully");
					 
				 }
					else
					{
						System.out.println("\t\t\t"+"Mandatory field:  QTY and Item fields in Exchange Item Section verify Unsuccessful");
						fail++;
						
						
					}
				 
			case 11:
				
				Select General1 = new Select(elements.GroupDropdown);
			    
				 General1.selectByVisibleText("General Inquiries");
				 
				 util.Clear(elements.ClearDescriptionField);
				 
				 util.Click(elements.TicketSubmit);
				 
				 if(util.Isdisplayed(elements.DescriptionFieldError))
					{
						
						System.out.println("\t\t\t"+"Mandatory field: Description verified Successfully\n\n\n");
						
						
					}
					else
					{
						System.out.println("\t\t\t"+"Mandatory field:  Description verify Unsuccessful\n\n\n");
						fail++;
						
						
					}
				 
				 
				 Select General2 = new Select(elements.GroupDropdown);
				    
				 General2.selectByVisibleText("General Inquiries");
				 
				 util.Sendkeys(elements.InputDescription, data.Description);
				 
//				 util.Click(elements.TicketReCpatcha);
				 
//				 util.Click(elements.TicketSubmit);
				 
				 System.out.println("Validating Mandatory Fields In Return option by Adding Extra Line Items\n");
				 
				 
			case 12:
				 
				Select General3 = new Select(elements.GroupDropdown);
				    
				General3.selectByVisibleText("Order & Store Support");
				 
				Select Return2 = new Select(elements.HowCanWeHelpOptions);
				
				Return2.selectByVisibleText("Return");
				
//				util.Sendkeys(elements.ReturnOrderNumber, data.ReturnOrderNumber);
				
				util.Click(elements.AddanotherReturnItem);
				
				util.Click(elements.AddanotherReturnItem);
				
				util.Sendkeys(elements.ValueForExtraReturnQtyField, "1");	
				
				util.Sendkeys(elements.ValueForExtraReturnItemField, "RAGLAN");
				
				util.Sendkeys(elements.ValueForSecondExtraReturnQtyField, "1");	
				
				util.Sendkeys(elements.ValueForSecondExtraReturnItemField, "Watch");
				
				util.Click(elements.TicketSubmit);
				
				 if(util.Isdisplayed(elements.ReturnQtyFieldError))
					{
						
						System.out.println("\t\t\t"+"Mandatory field: QTY field in Return option verified Successfully");
					}
				 
				 if(util.Isdisplayed(elements.ReturnItemFieldError)) 
				 
				 {
					 
					 System.out.println("\t\t\t"+"Mandatory field: Item field in Return option verified Successfully");
					 
				 }
					else
					{
						System.out.println("\t\t\t"+"Mandatory field:  QTY and Item fields in Return option verify Unsuccessful");
						fail++;
						
					}
			
			case 13:
				
				util.Sendkeys(elements.ValueForReturnQtyField, "1");
				
				util.Sendkeys(elements.ValueForReturnItemField, "Shirt");
				
				util.Clear(elements.ValueForExtraReturnQtyField);
				
				util.Clear(elements.ValueForExtraReturnItemField);
				
				util.Click(elements.TicketSubmit);
				
				if(util.Isdisplayed(elements.ErrorForExtraReturnQtyField))
				{
					
					System.out.println("\t\t\t"+"Mandatory field: QTY field in First line item verified Successfully");
				}
			 
			 if(util.Isdisplayed(elements.ErrorForExtraReturnItemField)) 
			 
			 {
				 
				 System.out.println("\t\t\t"+"Mandatory field: Item field in First line item verified Successfully");
				 
			 }
				else
				{
					System.out.println("\t\t\t"+"Mandatory field: Extra QTY and Item fields First line item verify Unsuccessful");
					fail++;
					
				}
				
			
			case 14:
				
				util.Sendkeys(elements.ValueForExtraReturnQtyField, "1");
				
				util.Sendkeys(elements.ValueForExtraReturnItemField, "Shirt");
				
				util.Clear(elements.ValueForSecondExtraReturnQtyField);
				
				util.Clear(elements.ValueForSecondExtraReturnItemField);
				
				util.Click(elements.TicketSubmit);
			 
				if(util.Isdisplayed(elements.ErrorForSecondExtraReturnQtyField))
				{
					
					System.out.println("\t\t\t"+"Mandatory field: QTY field in Second line item verified Successfully");
				}
			 
			 if(util.Isdisplayed(elements.ErrorForSecondExtraReturnItemField)) 
			 
			 {
				 
				 System.out.println("\t\t\t"+"Mandatory field: Item field in Second line item verified Successfully\n\n\n");
				 
			 }
				else
				{
					System.out.println("\t\t\t"+"Mandatory field: QTY and Item fields Second line item verify Unsuccessful\n\n\n");
					fail++;
					
				}
			
			 
			 
			case 15:
				
				System.out.println("Validating Mandatory Fields In Exchange option by Adding Extra Line Items\n");
				
				System.out.println("QTY and ITEM Fields in Items To Return Section\n");
				
				Select General4 = new Select(elements.GroupDropdown);
			    
				General4.selectByVisibleText("Order & Store Support");
				 
				Select Return3 = new Select(elements.HowCanWeHelpOptions);
				
				Return3.selectByVisibleText("Exchange");
				
				util.Clear(elements.ValueForReturnQtyField);
				
				util.Clear(elements.ValueForReturnItemField);
				
				util.Click(elements.AddanotherReturnItem);
				
				util.Click(elements.AddanotherReturnItem);
				
				util.Sendkeys(elements.ValueForExtraReturnQtyField, "1");	
				
				util.Sendkeys(elements.ValueForExtraReturnItemField, "RAGLAN");
				
				util.Sendkeys(elements.ValueForSecondExtraReturnQtyField, "1");	
				
				util.Sendkeys(elements.ValueForSecondExtraReturnItemField, "Watch");
				
				util.Sendkeys(elements.ValueForQTYfieldinExchangeItemSection, "1");
				
				util.Sendkeys(elements.ValueForITEMfieldinExchangeItemSection, "Shirt");
				
				util.Click(elements.TicketSubmit);
				
				 if(util.Isdisplayed(elements.ReturnQtyFieldError))
					{
						
						System.out.println("\t\t\t"+"Mandatory fields: QTY field in Items to Return section in Exchange option verified Successfully");
					}
				 
				 if(util.Isdisplayed(elements.ReturnItemFieldError)) 
				 
				 {
					 
					 System.out.println("\t\t\t"+"Mandatory field: Item field in Items to Return section in Exchange option verified Successfully");
					 
				 }
					else
					{
						System.out.println("\t\t\t"+"Mandatory fields:  QTY and Item field in Items to Return section in Exchange option verify Unsuccessful");
						fail++;
						
				
					}
			 
			case 16:
				
				util.Sendkeys(elements.ValueForReturnQtyField, "1");
				
				util.Sendkeys(elements.ValueForReturnItemField, "Shirt");
				
				util.Clear(elements.ValueForExtraReturnQtyField);
				
				util.Clear(elements.ValueForExtraReturnItemField);
				
				util.Click(elements.TicketSubmit);
				
				if(util.Isdisplayed(elements.ErrorForExtraReturnQtyField))
				{
					
					System.out.println("\t\t\t"+"Mandatory field: QTY field in First Line Item in Items to Return section in Exchange option verified Successfully");
				}
			 
			 if(util.Isdisplayed(elements.ErrorForExtraReturnItemField)) 
			 
			 {
				 
				 System.out.println("\t\t\t"+"Mandatory field: ITEM field in First Line Item in Items to Return section in Exchange option verified Successfully");
				 
			 }
				else
				{
					System.out.println("\t\t\t"+"Mandatory fields: QTY and ITEM fields in Firt Line Item in Items to Return section in Exchange option verify Unsuccessful");
					fail++;
					
				}
								
						
			case 17:
				
				util.Sendkeys(elements.ValueForExtraReturnQtyField, "1");
				
				util.Sendkeys(elements.ValueForExtraReturnItemField, "Shirt");
				
				util.Clear(elements.ValueForSecondExtraReturnQtyField);
				
				util.Clear(elements.ValueForSecondExtraReturnItemField);
				
				util.Click(elements.TicketSubmit);
				
				if(util.Isdisplayed(elements.ErrorForSecondExtraReturnQtyField))
				{
					
					System.out.println("\t\t\t"+"Mandatory field: QTY field in Second Line Item in Items to Return section in Exchange option verified Successfully");
				}
			 
			 if(util.Isdisplayed(elements.ErrorForSecondExtraReturnItemField)) 
			 
			 {
				 
				 System.out.println("\t\t\t"+"Mandatory field: ITEM field in Second Line Item in Items to Return section in Exchange option verified Successfully\n\n\n");
				 
			 }
				else
				{
					System.out.println("\t\t\t"+"Mandatory fields: QTY and ITEM fields in Second Line Item in Items to Return section in Exchange option verify Unsuccessful\n\n\n");
					fail++;
					
				}
								
			
			case 18:
				
				
				System.out.println(" QTY and ITEM Fields in Items To Exchange Section\n");
				
				util.Sendkeys(elements.ValueForSecondExtraReturnQtyField, "1");
				
				util.Sendkeys(elements.ValueForSecondExtraReturnItemField, "RAGLAN");
				
				util.Click(elements.AddanotherExchangeItem);
				
				util.Click(elements.AddanotherExchangeItem);
				
				util.Clear(elements.ValueForQTYfieldinExchangeItemSection);
				
				util.Clear(elements.ValueForITEMfieldinExchangeItemSection);
				
				util.Sendkeys(elements.ValueForQTYfieldinExtraExchangeLineItem, "1");
				
				util.Sendkeys(elements.ValueForITEMfieldinExtraExchangeLineItem, "Slipmat");
				
				util.Sendkeys(elements.ValueForQTYfieldinSecondExtraExchangeLineItem, "1");
				
				util.Sendkeys(elements.ValueForITEMfieldinSecondExtraExchangeLineItem, "T shirt");
				
				util.Click(elements.TicketSubmit);
				
				 if(util.Isdisplayed(elements.ErrorForQTYfieldinExchangeItemSection))
					{
						
						System.out.println("\t\t\t"+"Mandatory fields: QTY field in Exchange Items section in Exchange option verified Successfully");
					}
				 
				 if(util.Isdisplayed(elements.ErrorForITEMfieldinExchangeItemSection)) 
				 
				 {
					 
					 System.out.println("\t\t\t"+"Mandatory fields: ITEM field in Exchange Items section in Exchange option verified Successfully");
					 
				 }
					else
					{
						System.out.println("\t\t\t"+"Mandatory fields: QTY and ITEM field in Exchange Items section in Exchange option verified Successfully");
						fail++;
						
				
					}
				

			case 19:
				
				util.Sendkeys(elements.ValueForQTYfieldinExchangeItemSection, "1");
				
				util.Sendkeys(elements.ValueForITEMfieldinExchangeItemSection, "Watch");
				
				util.Clear(elements.ValueForQTYfieldinExtraExchangeLineItem);
				
				util.Clear(elements.ValueForITEMfieldinExtraExchangeLineItem);
				
				util.Click(elements.TicketSubmit);
				
				 if(util.Isdisplayed(elements.ErrorForQTYfieldinExtraExchangeLineItem))
					{
						
						System.out.println("\t\t\t"+"Mandatory fields: QTY field in First Line Item in Exchange Items section in Exchange option verified Successfully");
					}
				 
				 if(util.Isdisplayed(elements.ErrorForITEMfieldinExtraExchangeLineItem)) 
				 
				 {
					 
					 System.out.println("\t\t\t"+"Mandatory fields: ITEM field in First Line Item in Exchange Items section in Exchange option verified Successfully");
					 
				 }
					else
					{
						System.out.println("\t\t\t"+"Mandatory fields: QTY and ITEM fields in First Line Item in Exchange Items section in Exchange option verified Successfully");
						fail++;
						
				
					}
				
				
			case 20:
				
				util.Sendkeys(elements.ValueForQTYfieldinExtraExchangeLineItem, "1");
				
				util.Sendkeys(elements.ValueForITEMfieldinExtraExchangeLineItem, "Watch");
				
				util.Clear(elements.ValueForQTYfieldinSecondExtraExchangeLineItem);
				
				util.Clear(elements.ValueForITEMfieldinSecondExtraExchangeLineItem);
				
				util.Click(elements.TicketSubmit);
				 
				 if(util.Isdisplayed(elements.ErrorForQTYfieldinExtraExchangeLineItem))
					{
						
						System.out.println("\t\t\t"+"Mandatory field: QTY field in Second Line Item in Exchange Items section in Exchange option verified Successfully");
					}
				 
				 if(util.Isdisplayed(elements.ErrorForITEMfieldinExtraExchangeLineItem)) 
				 
				 {
					 
					 System.out.println("\t\t\t"+"Mandatory field: ITEM field in Second Line Item in Exchange Items section in Exchange option verified Successfully");
					 
				 }
					else
					{
						System.out.println("\t\t\t"+"Mandatory fields:QTY and ITEM field in Second Line Item in Exchange Items section in Exchange option verified Successfully");
						fail++;
						
				
					}
				
			}
					
		
		}

		
}

