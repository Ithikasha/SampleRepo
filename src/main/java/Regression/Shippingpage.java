package Regression;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import Data_Functions.Functions;
import Data_Functions.constantData;
import Data_Functions.driverUtil;
import Data_Functions.pageElements;

public class Shippingpage {
	
	public driverUtil util = new driverUtil();
	constantData data_obj;
	pageElements element_obj;
	Functions func ;
	Data_Regression data_regression = new Data_Regression();
	
	public Shippingpage(constantData data,pageElements elem,Functions functions) throws Exception
	   {
		   data_obj=data;
		   element_obj=elem;
		   func= functions;
		   
	   }
	
	public void ValidateFields() throws Exception
	{
		
		data_regression.Address = data_regression.DAddress;
		
		data_obj.driver.get(data_regression.URL);
		
//		util.Click(element_obj.no);

		func.smoke_login(data_regression.email, data_regression.password);
		
		System.out.println("\nShipping Page");
		
		System.out.println("\tSmoke Testing: Address field validation in Shipping page");
		
		System.out.println("\t\tTestcase - 22");
		
		int fail = 0;
		
		func.Add_product(data_regression.itemlist, data_regression.qty);
			
		util.Click(element_obj.checkout);
		   
		if(util.Isdisplayed(element_obj.firstname))
		{
			System.out.println("\t\t\t"+"Firstname verified Successfully");
		}
		else
		{
			System.out.println("\t\t\t"+"Firstname verify Unsuccessfully");
			fail++;
		}

		
		if(util.Isdisplayed(element_obj.lastname))
		{
			System.out.println("\t\t\t"+"Lastname verified Successfully");
		}
		else
		{
			System.out.println("\t\t\t"+"Lastname verify Unsuccessfully");
			fail++;
		}

		
		if(util.Isdisplayed(element_obj.address1))
		{
			System.out.println("\t\t\t"+"Address Line1 verified Successfully");
		}
		else
		{
			System.out.println("\t\t\t"+"Address Line1 verify Unsuccessfully");
			fail++;
		}
		
		if(util.Isdisplayed(element_obj.address2))
		{
			System.out.println("\t\t\t"+"Address Line2 verified Successfully");
		}
		else
		{
			System.out.println("\t\t\t"+"Address Line2 verify Unsuccessfully");
			fail++;
		}

		if(util.Isdisplayed(element_obj.city))
		{
			System.out.println("\t\t\t"+"City verified Successfully");
		}
		else
		{
			System.out.println("\t\t\t"+"City verify Unsuccessfully");
			fail++;
		}
		

		if(util.Isdisplayed(element_obj.stateField))
		{
			System.out.println("\t\t\t"+"State verified Successfully");
		}
		else
		{
			System.out.println("\t\t\t"+"State verify Unsuccessfully");
			fail++;
		}
		
		if(util.Isdisplayed(element_obj.countryField))
		{
			System.out.println("\t\t\t"+"Country verified Successfully");
		}
		else
		{
			System.out.println("\t\t\t"+"Country verify Unsuccessfully");
			fail++;
		}
		
		if(util.Isdisplayed(element_obj.zipcode))
		{
			System.out.println("\t\t\t"+"Zipcode verified Successfully");
		}
		else
		{
			System.out.println("\t\t\t"+"Zipcode verify Unsuccessfully");
			fail++;
		}
		
		if(util.Isdisplayed(element_obj.phone))
		{
			System.out.println("\t\t\t"+"Phone verified Successfully");
		}
		else
		{
			System.out.println("\t\t\t"+"Phone verify Unsuccessfully");
			fail++;
		}
		
		if(util.Isdisplayed(element_obj.saveAddress))
		{
			System.out.println("\t\t\t"+"Add to Address Book checkbox verified Successfully");
		}
		else
		{
			System.out.println("\t\t\t"+"Add to Address Book checkbox verify Unsuccessfully");
			fail++;
		}
		
		if(util.Isdisplayed(element_obj.useAsBillingAddress))
		{
			util.Click(element_obj.useAsBillingAddress);
			
			System.out.println("\t\t\t"+"Use as Billing address checkbox verified Successfully");
		}
		else
		{
			System.out.println("\t\t\t"+"Use as Billing address checkbox verify Unsuccessfully");
			fail++;
		}

		if(util.Isdisplayed(element_obj.gift))
		{
			System.out.println("\t\t\t"+"Gift checkbox verified Successfully");
		}
		else
		{
			System.out.println("\t\t\t"+"Gift checkbox verify Unsuccessfully");
			fail++;
		}

		if(util.Isdisplayed(element_obj.continuebill))
		{
			System.out.println("\t\t\t"+"Continue to Billing CTA verified Successfully");
		}
		else
		{
			System.out.println("\t\t\t"+"Continue to Billing CTA verify Unsuccessfully");
			fail++;
		}
		
		util.Click(element_obj.driver.findElement(By.xpath("(//span[text()='Back to Cart'])[2]")));
		
		if(fail>0)
		{
			System.out.println("\t\t\t"+"Address field validation Unsuccessful");
			func.write_Regressiontest(false, 22);
		}
		else
		{
			System.out.println("\t\t\t"+"Address field validation Successful");
			func.write_Regressiontest(true, 22);
		}
		
	}
	
	public void Validate_MandatoryFields() throws Exception
	{
		
		
		util.Click(element_obj.checkout);
		
//		smoke_data.readAddress();
		
		data_regression.Address = data_regression.DAddress;
		
		System.out.println("\tSmoke Testing: Validate the Mandatory fields");
		
		System.out.println("\t\tTestcase - 23");
		
		int fail = 0;
		
		switch(1)
		{
			case 1:
				
				util.Clear(element_obj.firstname);

//				util.Sendkeys(element_obj.firstname,smoke_data.firstname);
				
				util.Clear(element_obj.lastname);

				util.Sendkeys(element_obj.lastname,data_regression.lastname);

				util.Clear(element_obj.address1);
				
				util.Sendkeys(element_obj.address1,data_regression.Address.get("Address1"));
				
				Select Country1 = new Select(element_obj.countryField);
				Country1.selectByVisibleText(data_regression.Address.get("Country"));

				util.Clear(element_obj.city);
				
				util.AcceptAlertifPresent(element_obj.driver);
				
				util.Sendkeys(element_obj.city,data_regression.Address.get("City"));

				util.Clear(element_obj.zipcode);
				
				util.Sendkeys(element_obj.zipcode,data_regression.Address.get("Zipcode")); 
				
				switch(data_regression.Address.get("Country"))
				{
					case "United States":
						Select US_state = new Select(element_obj.stateField);
						US_state.selectByVisibleText(data_regression.Address.get("State"));
						break;
					
					case "Canada":
						Select CA_state = new Select(element_obj.CAstateField);
						CA_state.selectByVisibleText(data_regression.Address.get("State"));
						break;
					
					default:
						util.Clear(element_obj.IstateField);
						util.Sendkeys(element_obj.IstateField, data_regression.Address.get("State"));
						break;
				}
				
				util.Clear(element_obj.phone);
				
				util.Sendkeys(element_obj.phone,data_regression.Address.get("PhoneNumber"));
				
				util.AcceptAlertifPresent(element_obj.driver);
				
				util.WaitAndClick(element_obj.continuebill);
				
				if(util.Isdisplayed(element_obj.driver.findElement(By.xpath("(//span[@class='error'])[1]"))))
				{
					System.out.println("\t\t\t"+"Mandatory field: First Name verified Sucessfully");
				}
				else
				{
					System.out.println("\t\t\t"+"Mandatory field: First Name verify Unsucessful");
					fail++;
				}
				
			case 2:
				
//				util.Clear(element_obj.firstname);

				util.Sendkeys(element_obj.firstname,data_regression.firstname);
				
				util.Clear(element_obj.lastname);

//				util.Sendkeys(element_obj.lastname,smoke_data.lastname);

				util.Clear(element_obj.address1);
				
				util.Sendkeys(element_obj.address1,data_regression.Address.get("Address1"));
				
				Select Country2 = new Select(element_obj.countryField);
				
				Country2.selectByVisibleText(data_regression.Address.get("Country"));

				util.Clear(element_obj.city);
				
				util.Sendkeys(element_obj.city,data_regression.Address.get("City"));

				util.Clear(element_obj.zipcode);
				
				util.Sendkeys(element_obj.zipcode,data_regression.Address.get("Zipcode"));
				
				switch(data_regression.Address.get("Country"))
				{
					case "United States":
						Select US_state = new Select(element_obj.stateField);
						US_state.selectByVisibleText(data_regression.Address.get("State"));
						break;
					
					case "Canada":
						Select CA_state = new Select(element_obj.CAstateField);
						CA_state.selectByVisibleText(data_regression.Address.get("State"));
						break;
					
					default:
						util.Clear(element_obj.IstateField);
						util.Sendkeys(element_obj.IstateField, data_regression.Address.get("State"));
						break;
				}
				
				util.Clear(element_obj.phone);
				
				util.Sendkeys(element_obj.phone,data_regression.Address.get("PhoneNumber"));
				
				util.WaitAndClick(element_obj.continuebill);
				
				if(util.Isdisplayed(element_obj.driver.findElement(By.xpath("(//span[@class='error'])[2]"))))
				{
					System.out.println("\t\t\t"+"Mandatory field: Last Name verified Sucessfully");
				}
				else
				{
					System.out.println("\t\t\t"+"Mandatory field: Last Name verify Unsucessful");
					fail++;
				}
				
			case 3:
				
				util.Clear(element_obj.firstname);

				util.Sendkeys(element_obj.firstname,data_regression.firstname);
				
//				util.Clear(element_obj.lastname);

				util.Sendkeys(element_obj.lastname,data_regression.lastname);

				util.Clear(element_obj.address1);
				
//				util.Sendkeys(element_obj.address1,smoke_data.Address.get("Address1"));
				
				Select Country3 = new Select(element_obj.countryField);
				
				Country3.selectByVisibleText(data_regression.Address.get("Country"));

				util.Clear(element_obj.city);
				
				util.Sendkeys(element_obj.city,data_regression.Address.get("City"));

				util.Clear(element_obj.zipcode);
				
				util.Sendkeys(element_obj.zipcode,data_regression.Address.get("Zipcode"));
				
				switch(data_regression.Address.get("Country"))
				{
					case "United States":
						Select US_state = new Select(element_obj.stateField);
						US_state.selectByVisibleText(data_regression.Address.get("State"));
						break;
					
					case "Canada":
						Select CA_state = new Select(element_obj.CAstateField);
						CA_state.selectByVisibleText(data_regression.Address.get("State"));
						break;
					
					default:
						util.Clear(element_obj.IstateField);
						util.Sendkeys(element_obj.IstateField, data_regression.Address.get("State"));
						break;
				}
				
				util.Clear(element_obj.phone);
				
				util.Sendkeys(element_obj.phone,data_regression.Address.get("PhoneNumber"));
				
				util.WaitAndClick(element_obj.continuebill);
				
				if(util.Isdisplayed(element_obj.driver.findElement(By.xpath("(//span[@class='error'])[3]"))))
				{
					System.out.println("\t\t\t"+"Mandatory field: Address1 verified Sucessfully");
				}
				else
				{
					System.out.println("\t\t\t"+"Mandatory field: Address1 verify Unsucessful");
					fail++;
				}
				
			case 4:
				
				util.Clear(element_obj.firstname);

				util.Sendkeys(element_obj.firstname,data_regression.firstname);
				
				util.Clear(element_obj.lastname);

				util.Sendkeys(element_obj.lastname,data_regression.lastname);

//				util.Clear(element_obj.address1);
				
				util.Sendkeys(element_obj.address1,data_regression.Address.get("Address1"));
				
				Select Country4 = new Select(element_obj.countryField);
				
				Country4.selectByVisibleText(data_regression.Address.get("Country"));

				util.Clear(element_obj.city);
				
//				util.Sendkeys(element_obj.city,smoke_data.Address.get("City"));

				util.Clear(element_obj.zipcode);
				
				util.Sendkeys(element_obj.zipcode,data_regression.Address.get("Zipcode"));
				
				switch(data_regression.Address.get("Country"))
				{
					case "United States":
						Select US_state = new Select(element_obj.stateField);
						US_state.selectByVisibleText(data_regression.Address.get("State"));
						break;
					
					case "Canada":
						Select CA_state = new Select(element_obj.CAstateField);
						CA_state.selectByVisibleText(data_regression.Address.get("State"));
						break;
					
					default:
						util.Clear(element_obj.IstateField);
						util.Sendkeys(element_obj.IstateField, data_regression.Address.get("State"));
						break;
				}
				
				util.Clear(element_obj.phone);
				
				util.AcceptAlertifPresent(element_obj.driver);
				
				util.AcceptAlertifPresent(element_obj.driver);
				
				util.AcceptAlertifPresent(element_obj.driver);
				
				util.Sendkeys(element_obj.phone,data_regression.Address.get("PhoneNumber"));
				
				util.AcceptAlertifPresent(element_obj.driver);
				
				util.AcceptAlertifPresent(element_obj.driver);
				
				util.WaitAndClick(element_obj.continuebill);
				
				
				if(util.Isdisplayed(element_obj.driver.findElement(By.xpath("(//span[@class='error'])[4]"))))
				{
					System.out.println("\t\t\t"+"Mandatory field: City verified Sucessfully");
				}
				else
				{
					System.out.println("\t\t\t"+"Mandatory field: City verify Unsucessful");
					fail++;
				}
				
			case 5:
				
				util.Clear(element_obj.firstname);

				util.Sendkeys(element_obj.firstname,data_regression.firstname);
				
				util.Clear(element_obj.lastname);

				util.Sendkeys(element_obj.lastname,data_regression.lastname);

				util.Clear(element_obj.address1);
				
				util.Sendkeys(element_obj.address1,data_regression.Address.get("Address1"));
				
				Select Country5 = new Select(element_obj.countryField);
				
				Country5.selectByVisibleText(data_regression.Address.get("Country"));

//				util.Clear(element_obj.city);
				
				util.Sendkeys(element_obj.city,data_regression.Address.get("City"));

				util.Clear(element_obj.zipcode);
				
				util.AcceptAlertifPresent(data_obj.driver);
				
				util.AcceptAlertifPresent(data_obj.driver);
				
				util.Sendkeys(element_obj.zipcode,""); //smoke_data.Address.get("Zipcode")
				
				util.AcceptAlertifPresent(data_obj.driver);
				
				switch(data_regression.Address.get("Country"))
				{
					case "United States":
						Select US_state = new Select(element_obj.stateField);
						US_state.selectByVisibleText(data_regression.Address.get("State"));
						break;
					
					case "Canada":
						Select CA_state = new Select(element_obj.CAstateField);
						CA_state.selectByVisibleText(data_regression.Address.get("State"));
						break;
					
					default:
						util.Clear(element_obj.IstateField);
						util.Sendkeys(element_obj.IstateField, data_regression.Address.get("State"));
						break;
				}
				
				util.Clear(element_obj.phone);
				
				util.Sendkeys(element_obj.phone,data_regression.Address.get("PhoneNumber"));
				
				if(!element_obj.driver.findElement(By.xpath("//button[@class='add-to-cart button button--cta']")).isEnabled()) //element_obj.driver.findElement(By.xpath("(//span[@class='error'])"
				{
					System.out.println("\t\t\t"+"Mandatory field: Zipcode verified Sucessfully");
				}
				else
				{
					util.WaitAndClick(element_obj.continuebill);
					
					util.AcceptAlertifPresent(data_obj.driver);
					
					util.AcceptAlertifPresent(data_obj.driver);
					
					util.AcceptAlertifPresent(data_obj.driver);
					
					if(util.Isdisplayed(element_obj.driver.findElement(By.xpath("(//span[@class='error'])[5]"))))
					{
						System.out.println("\t\t\t"+"Mandatory field: Zipcode verified Sucessfully");
					}
					else
					{
						System.out.println("\t\t\t"+"Mandatory field: Zipcode verify Unsucessful");
						fail++;
					}
				}
				
			case 6:
				
				util.Clear(element_obj.firstname);

				util.Sendkeys(element_obj.firstname,data_regression.firstname);
				
				util.Clear(element_obj.lastname);

				util.Sendkeys(element_obj.lastname,data_regression.lastname);

				util.Clear(element_obj.address1);
				
				util.Sendkeys(element_obj.address1,data_regression.Address.get("Address1"));
				
				util.AcceptAlertifPresent(data_obj.driver);
				
				util.AcceptAlertifPresent(data_obj.driver);
				
				Select Country6 = new Select(element_obj.countryField);
				
				Country6.selectByVisibleText(data_regression.Address.get("Country"));
				
				util.AcceptAlertifPresent(data_obj.driver);
				
				util.AcceptAlertifPresent(data_obj.driver);

				util.Clear(element_obj.city);
				
				util.Sendkeys(element_obj.city,data_regression.Address.get("City"));

				util.Clear(element_obj.zipcode);

				util.AcceptAlertifPresent(data_obj.driver);
				
				util.Sendkeys(element_obj.zipcode,data_regression.Address.get("Zipcode"));
				
				util.AcceptAlertifPresent(data_obj.driver);
				
				switch(data_regression.Address.get("Country"))
				{
					case "United States":
						Select US_state = new Select(element_obj.stateField);
						US_state.selectByVisibleText(data_regression.Address.get("State"));
						break;
					
					case "Canada":
						Select CA_state = new Select(element_obj.CAstateField);
						CA_state.selectByVisibleText(data_regression.Address.get("State"));
						break;
					
					default:
						util.Clear(element_obj.IstateField);
						util.Sendkeys(element_obj.IstateField, data_regression.Address.get("State"));
						break;
				}
				
				util.Clear(element_obj.phone);
				
//				util.Sendkeys(element_obj.phone,smoke_data.phone);
				
				util.WaitAndClick(element_obj.continuebill);
				
				if(util.Isdisplayed(element_obj.driver.findElement(By.xpath("(//span[@class='error'])[2]"))))
				{
					System.out.println("\t\t\t"+"Mandatory field: Phone verified Sucessfully");
					
					util.Sendkeys(element_obj.phone,data_regression.Address.get("PhoneNumber"));
				}
				else
				{
					System.out.println("\t\t\t"+"Mandatory field: Phone verify Unsucessful");
					fail++;
				}
		}
		
		util.Click(element_obj.driver.findElement(By.xpath("(//span[text()='Back to Cart'])[2]")));
		
		if(fail>0)
		{
			System.out.println("\t\t\t"+"Mandatory fields validation Unsuccessful");
			func.write_Regressiontest(false, 23);
		}
		else
		{
			System.out.println("\t\t\t"+"Mandatory fields validation Successful");
			func.write_Regressiontest(true, 23);
		}
	}
	
	public void Validate_Table() throws Exception
	{

		System.out.println("\tSmoke Testing: Validate Shipping method Table");
		
		System.out.println("\t\tTestcase - 24");
		
//		smoke_data.readAddress();
		
		data_regression.Address = data_regression.DAddress;
				
		util.Click(element_obj.checkout);
		
		util.Clear(element_obj.firstname);

		util.Sendkeys(element_obj.firstname,data_regression.firstname);
		
		util.Clear(element_obj.lastname);

		util.Sendkeys(element_obj.lastname,data_regression.lastname);

		util.Clear(element_obj.address1);
		
		util.Sendkeys(element_obj.address1,data_regression.Address.get("Address1"));
		
		Select Country = new Select(element_obj.countryField);
		Country.selectByVisibleText(data_regression.Address.get("Country"));

		util.Clear(element_obj.city);
		
		util.Sendkeys(element_obj.city,data_regression.Address.get("City"));

		util.Clear(element_obj.zipcode);
		
		util.Sendkeys(element_obj.zipcode,data_regression.Address.get("Zipcode"));
		
		switch(data_regression.Address.get("Country"))
		{
			case "United States":
				Select US_state = new Select(element_obj.stateField);
				US_state.selectByVisibleText(data_regression.Address.get("State"));
				break;
			
			case "Canada":
				Select CA_state = new Select(element_obj.CAstateField);
				CA_state.selectByVisibleText(data_regression.Address.get("State"));
				break;
			
			default:
				util.Clear(element_obj.IstateField);
				util.Sendkeys(element_obj.IstateField, data_regression.Address.get("State"));
				break;
		}
		
		util.Clear(element_obj.phone);
		
		util.Sendkeys(element_obj.phone,data_regression.Address.get("PhoneNumber"));
		
		if(util.Isdisplayed(element_obj.shippingtable))
		{
			System.out.println("\t\t\t"+"Shipping Method table displayed after entering address - Successfully");
			func.write_Regressiontest(true, 24);
		}
		else
		{
			System.out.println("\t\t\t"+"Shipping Method table not displayed - Unsuccessful");
			func.write_Regressiontest(false, 24);
		}
		
	}
		
	public void Validate_ProductTitle() throws Exception
	{
		
		System.out.println("\tSmoke Testing: Product Title in Shipping Table");
		
		System.out.println("\t\tTestcase - 25");

		List<String> prod_list = new ArrayList<>();
		
		
		for(int i = 1; i <= data_regression.itemlist.length; i++)
		{
			util.AcceptAlertifPresent(data_obj.driver);
			prod_list.add(i-1,element_obj.driver.findElement(By.xpath("(//div[@class='shipping-method-products']//child::span)["+i+"]")).getText().substring(1));
		}
		
		Collections.sort(prod_list);
		
		
			for(int i=0; i < data_regression.itemlist.length; i++)
			{
				if(prod_list.contains(data_regression.CP_prdName.get(i).toUpperCase()))
				{
					System.out.println("\t\t\t"+data_regression.CP_prdName.get(i)+": Product name displayed in Shipping Method Table Successfully ");
					func.write_Regressiontest(true, 25);
				}
				else
				{
					System.out.println("\t\t\t"+data_regression.CP_prdName.get(i)+" Product name not displayed in Shipping Method Table - Unsuccessful");
					func.write_Regressiontest(false, 25);
				}
			}
			
	}
	
	public void Validate_SavedAddress() throws Exception
	{
		System.out.println("\tSaved Address field validation");
		
		System.out.println("\t\tTestcase - 26");		
		
		if(util.Isdisplayed(element_obj.driver.findElement(By.xpath("//select[@id='dwfrm_singleshipping_addressList']"))))
		{
			System.out.println("\t\t\t"+"Ship Later section displayed in Shipping method table Successfully");	
			func.write_Regressiontest(true, 26);
		}
		else
		{
			System.out.println("\t\t\t"+"Ship Later section NOT displayed in Shipping method table - Unsuccessful");
			func.write_Regressiontest(false, 26);
		}	
		
	}
	
	public void Gift_message() throws Exception
	{
		System.out.println("\tGift Message Text box");
		
		System.out.println("\t\tTestcase - 27");		
		
		util.Click(element_obj.gift);
		
		if(util.Isdisplayed(element_obj.giftMsg))
		{
			System.out.println("\t\t\t"+"The Gift Message text box validation Successful");	
			func.write_Regressiontest(true, 27);
		}
		else
		{
			System.out.println("\t\t\t"+"The Gift Message text box validation Unsuccessful");
			func.write_Regressiontest(false, 27);
		}
	}
	
	public void UseAddress_checkbox() throws Exception
	{
		System.out.println("\tUse Shipping address as Billing address");
		
		System.out.println("\t\tTestcase - 28");
		
		if(util.Isdisplayed(element_obj.Preorder_Acknowledgement))
		{
			util.WaitAndClick(element_obj.Preorder_Acknowledgement);
			
			util.WaitAndClick(element_obj.continuebill);
		}
		
		else
		{
			util.WaitAndClick(element_obj.continuebill);
			if(util.Isdisplayed(element_obj.userAddress)) 
			{
				util.WaitAndClick(element_obj.userAddress);
			}
		}	
			
		func.smoke_payment("Visa");
		
		util.WaitAndClick(element_obj.continuePlaceorder);
		
		if(util.Isdisplayed(element_obj.driver.findElement(By.xpath("//div[@class='place-order-header']"))))
		{
			System.out.println("\t\t\t"+"Use Shipping addres as Billing address validation Successful");	
			func.write_Regressiontest(true, 28);
		}
		else
		{
			System.out.println("\t\t\t"+"Use Shipping addres as Billing address validation Unsuccessful");
			func.write_Regressiontest(false, 28);
		}
		
		util.Click(element_obj.driver.findElement(By.xpath("(//span[text()='Back to Cart'])[2]")));
		
		for(int c = 1; c <= data_regression.itemlist.length; c++)
		{
			
			util.WaitAndClick(element_obj.remove);

		}
	}
	
	public void Preorder_Validation() throws Exception
	{
		func.Add_product(data_regression.preorderlist, data_regression.qty);
		
		util.WaitAndClick(element_obj.checkout);
		
		Validate_ShipLater();
		
		Preorder_Acknowledge();		
		
		util.Click(element_obj.driver.findElement(By.xpath("(//span[text()='Back to Cart'])[2]")));
		
		for(int c = 0; c < data_regression.itemlist.length; c++)
		{
			
			util.WaitAndClick(element_obj.remove);

		}
		
	}
	public void Validate_ShipLater() throws Exception
	{
		System.out.println("\tSmoke Testing: Ship Later section in Shipping Table");
		
		System.out.println("\t\tTestcase - 29");
		
		if(util.Isdisplayed(element_obj.shiplater_title))
		{
			System.out.println("\t\t\t"+"Ship Later section displayed in Shipping method table Successfully");	
			func.write_Regressiontest(true, 29);
		}
		else
		{
			System.out.println("\t\t\t"+"Ship Later section NOT displayed in Shipping method table - Unsuccessful");
			func.write_Regressiontest(false, 29);
		}
		
	}
	
	public void Preorder_Acknowledge() throws Exception
	{
		System.out.println("\tSmoke Testing: Pre-Order Acknowledgement checkbox");
		
		System.out.println("\t\tTestcase - 30");
		
		if(util.Isdisplayed(element_obj.Preorder_Acknowledgement))
		{
			System.out.println("\t\t\t"+"Pre-Order Acknowledgement checkbox displayed in Shipping page Successfully");	
			func.write_Regressiontest(true, 30);
		}
		else
		{
			System.out.println("\t\t\t"+"Pre-Order Acknowledgement checkbox not displayed in Shipping page - Unsuccessful");
			func.write_Regressiontest(false, 30);
		}
		
		System.out.println("\tSmoke Testing: Validate Pre-Order Acknowledgement");
		
		System.out.println("\t\tTestcase - 31");
		
		util.Click(element_obj.continuebill);
		
		if(util.Isdisplayed(element_obj.Preorder_Acknowledgement_Error))
		{
			System.out.println("\t\t\t"+"Pre-Order Acknowledgement checkbox validation Successful");	
			func.write_Regressiontest(true, 31);
		}
		else
		{
			System.out.println("\t\t\t"+"Pre-Order Acknowledgement checkbox validation Unsuccessful");
			func.write_Regressiontest(false, 31);
		}
	}
	
	public void VC_Validation() throws Exception
	{
		System.out.println("\tSmoke Testing: Validate Vinyl Club Ship Bucket");
		
		System.out.println("\t\tTestcase - 32");
		
		func.Add_product(data_regression.vinylA);
		
		util.WaitAndClick(element_obj.checkout);
		
		if(util.Isdisplayed(element_obj.driver.findElement(By.xpath("//div[@class='shipping-method-header vinylclub-shipment-header']"))))
		{
			System.out.println("\t\t\t"+"Vinyl club Ship bucket validation Successful");	
			func.write_Regressiontest(true, 32);
		}
		else
		{
			System.out.println("\t\t\t"+"Vinyl club Ship bucket validation Successful");
			func.write_Regressiontest(false, 32);
		}
		
		util.Click(element_obj.driver.findElement(By.xpath("(//span[text()='Back to Cart'])[2]")));
		
		util.WaitAndClick(element_obj.remove);
	}
	
}

