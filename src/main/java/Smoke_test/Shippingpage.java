package Smoke_test;

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
	Data_smoke smoke_data = new Data_smoke();
	
	public Shippingpage(constantData data,pageElements elem,Functions functions) throws Exception
	   {
		   data_obj=data;
		   element_obj=elem;
		   func= functions;
		   
	   }
	
	public void ValidateFields() throws Exception
	{
		data_obj.driver.get(smoke_data.URL);
		
//		util.Click(element_obj.no);

		func.smoke_login(smoke_data.email, smoke_data.password);
		
		System.out.println("\nShipping Page");
		
		System.out.println("\tSmoke Testing: Address field validation in Shipping page");
		
		System.out.println("\t\tTestcase - 8");
		
		func.Add_product(smoke_data.itemlist, smoke_data.qty);
			
		util.Click(element_obj.checkout);
		   
		if(util.Isdisplayed(element_obj.firstname))
		{
			System.out.println("\t\t\t"+"Firstname verified Successfully");
		}
		else
		{
			System.out.println("\t\t\t"+"Firstname verify Unsuccessfully");
		}

		
		if(util.Isdisplayed(element_obj.lastname))
		{
			System.out.println("\t\t\t"+"Lastname verified Successfully");
		}
		else
		{
			System.out.println("\t\t\t"+"Lastname verify Unsuccessfully");
		}

		
		if(util.Isdisplayed(element_obj.address1))
		{
			System.out.println("\t\t\t"+"Address Line1 verified Successfully");
		}
		else
		{
			System.out.println("\t\t\t"+"Address Line1 verify Unsuccessfully");
		}
		
		if(util.Isdisplayed(element_obj.address2))
		{
			System.out.println("\t\t\t"+"Address Line2 verified Successfully");
		}
		else
		{
			System.out.println("\t\t\t"+"Address Line2 verify Unsuccessfully");
		}

		if(util.Isdisplayed(element_obj.city))
		{
			System.out.println("\t\t\t"+"City verified Successfully");
		}
		else
		{
			System.out.println("\t\t\t"+"City verify Unsuccessfully");
		}
		
		if(util.Isdisplayed(element_obj.stateField))
		{
			System.out.println("\t\t\t"+"State verified Successfully");
		}
		else
		{
			System.out.println("\t\t\t"+"State verify Unsuccessfully");
		}
		
		if(util.Isdisplayed(element_obj.countryField))
		{
			System.out.println("\t\t\t"+"Country verified Successfully");
		}
		else
		{
			System.out.println("\t\t\t"+"Country verify Unsuccessfully");
		}
		
		if(util.Isdisplayed(element_obj.zipcode))
		{
			System.out.println("\t\t\t"+"Zipcode verified Successfully");
		}
		else
		{
			System.out.println("\t\t\t"+"Zipcode verify Unsuccessfully");
		}
		
		if(util.Isdisplayed(element_obj.phone))
		{
			System.out.println("\t\t\t"+"Phone verified Successfully");
		}
		else
		{
			System.out.println("\t\t\t"+"Phone verify Unsuccessfully");
		}
		
		if(util.Isdisplayed(element_obj.saveAddress))
		{
			System.out.println("\t\t\t"+"Add to Address Book checkbox verified Successfully");
		}
		else
		{
			System.out.println("\t\t\t"+"Add to Address Book checkbox verify Unsuccessfully");
		}
		
		if(util.Isdisplayed(element_obj.useAsBillingAddress))
		{
			util.Click(element_obj.useAsBillingAddress);
			
			System.out.println("\t\t\t"+"Use as Billing address checkbox verified Successfully");
		}
		else
		{
			System.out.println("\t\t\t"+"Use as Billing address checkbox verify Unsuccessfully");
		}

		if(util.Isdisplayed(element_obj.gift))
		{
			System.out.println("\t\t\t"+"Gift checkbox verified Successfully");
		}
		else
		{
			System.out.println("\t\t\t"+"Gift checkbox verify Unsuccessfully");
		}

		if(util.Isdisplayed(element_obj.continuebill))
		{
			System.out.println("\t\t\t"+"Continue to Billing CTA verified Successfully");
		}
		else
		{
			System.out.println("\t\t\t"+"Continue to Billing CTA verify Unsuccessfully");
		}
		
		
	}
	
	public void Validate_mandatoryfields() throws Exception
	{
		System.out.println("\tSmoke Testing: Validate the Mandatory fields");
		
		System.out.println("\t\tTestcase - 12");
		
		switch(1)
		{
			case 1:
				
				util.Clear(element_obj.firstname);

//				util.Sendkeys(element_obj.firstname,smoke_data.firstname);
				
				util.Clear(element_obj.lastname);

				util.Sendkeys(element_obj.lastname,smoke_data.lastname);

				util.Clear(element_obj.address1);
				
				util.Sendkeys(element_obj.address1,smoke_data.Address1);

				util.Clear(element_obj.city);
				
				util.Sendkeys(element_obj.city,smoke_data.City);

				util.Clear(element_obj.zipcode);
				
				util.Sendkeys(element_obj.zipcode,smoke_data.Zip_Code);
				
				Select C1_state = new Select(element_obj.stateField);
				C1_state.selectByVisibleText(smoke_data.State);
				
				util.Clear(element_obj.phone);
				
				util.Sendkeys(element_obj.phone,smoke_data.phone);
				
				util.WaitAndClick(element_obj.continuebill);
				
				if(util.Isdisplayed(element_obj.driver.findElement(By.xpath("(//span[@class='error'])[1]"))))
				{
					System.out.println("\t\t\t"+"Mandatory field: First Name verified Sucessfully");
				}
				else
				{
					System.out.println("\t\t\t"+"Mandatory field: First Name verify Unsucessful");
				}
				
			case 2:
				
//				util.Clear(element_obj.firstname);

				util.Sendkeys(element_obj.firstname,smoke_data.firstname);
				
				util.Clear(element_obj.lastname);

//				util.Sendkeys(element_obj.lastname,smoke_data.lastname);

				util.Clear(element_obj.address1);
				
				util.Sendkeys(element_obj.address1,smoke_data.Address1);

				util.Clear(element_obj.city);
				
				util.Sendkeys(element_obj.city,smoke_data.City);

				util.Clear(element_obj.zipcode);
				
				util.Sendkeys(element_obj.zipcode,smoke_data.Zip_Code);
				
				Select C2_state = new Select(element_obj.stateField);
				C2_state.selectByVisibleText(smoke_data.State);
				
				util.Clear(element_obj.phone);
				
				util.Sendkeys(element_obj.phone,smoke_data.phone);
				
				util.WaitAndClick(element_obj.continuebill);
				
				if(util.Isdisplayed(element_obj.driver.findElement(By.xpath("(//span[@class='error'])[2]"))))
				{
					System.out.println("\t\t\t"+"Mandatory field: Last Name verified Sucessfully");
				}
				else
				{
					System.out.println("\t\t\t"+"Mandatory field: Last Name verify Unsucessful");
				}
				
			case 3:
				
				util.Clear(element_obj.firstname);

				util.Sendkeys(element_obj.firstname,smoke_data.firstname);
				
//				util.Clear(element_obj.lastname);

				util.Sendkeys(element_obj.lastname,smoke_data.lastname);

				util.Clear(element_obj.address1);
				
//				util.Sendkeys(element_obj.address1,smoke_data.Address1);

				util.Clear(element_obj.city);
				
				util.Sendkeys(element_obj.city,smoke_data.City);

				util.Clear(element_obj.zipcode);
				
				util.Sendkeys(element_obj.zipcode,smoke_data.Zip_Code);
				
				Select C3_state = new Select(element_obj.stateField);
				C3_state.selectByVisibleText(smoke_data.State);
				
				util.Clear(element_obj.phone);
				
				util.Sendkeys(element_obj.phone,smoke_data.phone);
				
				util.WaitAndClick(element_obj.continuebill);
				
				if(util.Isdisplayed(element_obj.driver.findElement(By.xpath("(//span[@class='error'])[3]"))))
				{
					System.out.println("\t\t\t"+"Mandatory field: Address1 verified Sucessfully");
				}
				else
				{
					System.out.println("\t\t\t"+"Mandatory field: Address1 verify Unsucessful");
				}
				
			case 4:
				
				util.Clear(element_obj.firstname);

				util.Sendkeys(element_obj.firstname,smoke_data.firstname);
				
				util.Clear(element_obj.lastname);

				util.Sendkeys(element_obj.lastname,smoke_data.lastname);

//				util.Clear(element_obj.address1);
				
				util.Sendkeys(element_obj.address1,smoke_data.Address1);

				util.Clear(element_obj.city);
				
//				util.Sendkeys(element_obj.city,smoke_data.City);

				util.Clear(element_obj.zipcode);
				
				util.Sendkeys(element_obj.zipcode,smoke_data.Zip_Code);
				
				Select C4_state = new Select(element_obj.stateField);
				C4_state.selectByVisibleText(smoke_data.State);
				
				util.Clear(element_obj.phone);
				
				util.Sendkeys(element_obj.phone,smoke_data.phone);
				
				util.WaitAndClick(element_obj.continuebill);
				
				if(util.Isdisplayed(element_obj.driver.findElement(By.xpath("(//span[@class='error'])[4]"))))
				{
					System.out.println("\t\t\t"+"Mandatory field: City verified Sucessfully");
				}
				else
				{
					System.out.println("\t\t\t"+"Mandatory field: City verify Unsucessful");
				}
				
			case 5:
				
				util.Clear(element_obj.firstname);

				util.Sendkeys(element_obj.firstname,smoke_data.firstname);
				
				util.Clear(element_obj.lastname);

				util.Sendkeys(element_obj.lastname,smoke_data.lastname);

				util.Clear(element_obj.address1);
				
				util.Sendkeys(element_obj.address1,smoke_data.Address1);

//				util.Clear(element_obj.city);
				
				util.Sendkeys(element_obj.city,smoke_data.City);

				util.Clear(element_obj.zipcode);
				
				util.Sendkeys(element_obj.zipcode,""); //smoke_data.Zip_Code
				
				Select C5_state = new Select(element_obj.stateField);
				C5_state.selectByVisibleText(smoke_data.State);
				
				util.Clear(element_obj.phone);
				
				util.Sendkeys(element_obj.phone,smoke_data.phone);
				
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
					}
				}
				
				
				
			case 6:
				
				util.Clear(element_obj.firstname);

				util.Sendkeys(element_obj.firstname,smoke_data.firstname);
				
				util.Clear(element_obj.lastname);

				util.Sendkeys(element_obj.lastname,smoke_data.lastname);

				util.Clear(element_obj.address1);
				
				util.Sendkeys(element_obj.address1,smoke_data.Address1);

				util.Clear(element_obj.city);
				
				util.Sendkeys(element_obj.city,smoke_data.City);

				util.Clear(element_obj.zipcode);
				
				util.Sendkeys(element_obj.zipcode,smoke_data.Zip_Code);
				
				Select C6_state = new Select(element_obj.stateField);
				C6_state.selectByVisibleText("Select...");
				
				util.Clear(element_obj.phone);
				
				util.Sendkeys(element_obj.phone,smoke_data.phone);
				
				if(!element_obj.driver.findElement(By.xpath("//button[@class='add-to-cart button button--cta']")).isEnabled()) //element_obj.driver.findElement(By.xpath("(//span[@class='error'])"
				{
					System.out.println("\t\t\t"+"Mandatory field: State verified Sucessfully");
				}
				else
				{
					util.WaitAndClick(element_obj.continuebill);
					
					util.AcceptAlertifPresent(data_obj.driver);
					
					util.AcceptAlertifPresent(data_obj.driver);
					
					util.AcceptAlertifPresent(data_obj.driver);
					
					if(util.Isdisplayed(element_obj.driver.findElement(By.xpath("(//span[@class='error'])[5]"))))
					{
						System.out.println("\t\t\t"+"Mandatory field: State verified Sucessfully");
					}
					else
					{
						System.out.println("\t\t\t"+"Mandatory field: State verify Unsucessful");
					}
				
				}
				
			case 7:
				
				util.Clear(element_obj.firstname);

				util.Sendkeys(element_obj.firstname,smoke_data.firstname);
				
				util.Clear(element_obj.lastname);

				util.Sendkeys(element_obj.lastname,smoke_data.lastname);

				util.Clear(element_obj.address1);
				
				util.Sendkeys(element_obj.address1,smoke_data.Address1);

				util.Clear(element_obj.city);
				
				util.Sendkeys(element_obj.city,smoke_data.City);

				util.Clear(element_obj.zipcode);
				
				util.Sendkeys(element_obj.zipcode,smoke_data.Zip_Code);
				
				Select C7_state = new Select(element_obj.stateField);
				C7_state.selectByVisibleText(smoke_data.State);
				
				util.Clear(element_obj.phone);
				
//				util.Sendkeys(element_obj.phone,smoke_data.phone);
				
				util.WaitAndClick(element_obj.continuebill);
				
				if(util.Isdisplayed(element_obj.driver.findElement(By.xpath("(//span[@class='error'])[2]"))))
				{
					System.out.println("\t\t\t"+"Mandatory field: Phone verified Sucessfully");
					
					util.Sendkeys(element_obj.phone,smoke_data.phone);
				}
				else
				{
					System.out.println("\t\t\t"+"Mandatory field: Phone verify Unsucessful");
				}
		}
	}
	
	public void Validate_Shippingtable() throws Exception
	{
		System.out.println("\tSmoke Testing: Shipping Method Table");
		
		System.out.println("\t\tTestcase - 9");
		
		if(!util.Isdisplayed(element_obj.shippingtable))
		{
			
			util.Clear(element_obj.firstname);

			util.Sendkeys(element_obj.firstname,smoke_data.firstname);
			
			util.Clear(element_obj.lastname);

			util.Sendkeys(element_obj.lastname,smoke_data.lastname);

			util.Clear(element_obj.address1);
			
			util.Sendkeys(element_obj.address1,smoke_data.Address1);

			util.Clear(element_obj.city);
			
			util.Sendkeys(element_obj.city,smoke_data.City);

			util.Clear(element_obj.zipcode);
			
			util.Sendkeys(element_obj.zipcode,smoke_data.Zip_Code);
			
			Select state = new Select(element_obj.stateField);
			state.selectByVisibleText(smoke_data.State);
			
			util.Clear(element_obj.phone);
			
			util.Sendkeys(element_obj.phone,smoke_data.phone);
			
			if(util.Isdisplayed(element_obj.shippingtable))
			{
				System.out.println("\t\t\t"+"Shipping Method table displayed after entering address - Successfully");
			}
		}
		
		else
		{
			System.out.println("\t\t\t"+"Shipping Method table Displayed without address - Unsuccessfully");
		}
		
		System.out.println("\tSmoke Testing: Product Title in Shipping Table");
		
		System.out.println("\t\tTestcase - 10");
		
		List<String> prod_list = new ArrayList<>();
		
		for(int i = 1; i <= smoke_data.itemlist.length; i++)
		{
			prod_list.add(i-1,element_obj.driver.findElement(By.xpath("(//div[@class='shipping-method-products']//child::span)["+i+"]")).getText());
		}
		
		Collections.sort(prod_list);
		
		for(int i = 0; i < smoke_data.itemlist.length; i++)
		{
			if(prod_list.get(i).contains(smoke_data.PDP_prdName.get(i)))
			{
				System.out.println("\t\t\t"+prod_list.get(i)+": Product name displayed in Shipping Method Table Successfully ");
			}
			else
			{
				System.out.println("\t\t\t"+prod_list.get(i)+" Product name displayed in Shipping Method Table Unsuccessfully");
			}
		}
		
		System.out.println("\tSmoke Testing: Ship Later section in Shipping Table");
		
		System.out.println("\t\tTestcase - 11");
		
		if(util.Isdisplayed(element_obj.shiplater_title))
		{
			System.out.println("\t\t\t"+"Ship Later section displayed in Shipping method table");		
		}
		else
		{
			System.out.println("\t\t\t"+"Ship Later section NOT displayed in Shipping method table");
		}
		
	}


}
