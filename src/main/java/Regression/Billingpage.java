package Regression;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import Data_Functions.Functions;
import Data_Functions.constantData;
import Data_Functions.driverUtil;
import Data_Functions.pageElements;

public class Billingpage {
	
	public driverUtil util = new driverUtil();
	constantData data_obj;
	pageElements element_obj;
	Functions func ;
	Data_Regression data_Regression = new Data_Regression();
	
	public Billingpage(constantData data,pageElements elem,Functions functions) throws Exception
	   {
		   data_obj=data;
		   element_obj=elem;
		   func= functions;
		   
	   }
	
	public void ValidateFields() throws Exception
	{
//		data_obj.driver.get(data_obj.DEV_url);
//		
//		util.Click(element_obj.no);
//
//		func.login();
		
		
		
		func.Add_product(data_Regression.itemlist, data_Regression.qty);
			
		util.WaitAndClick(element_obj.checkout);
		
		util.WaitAndClick(element_obj.useAsBillingAddress);
		
		System.out.println("\nBilling Page");
		
		util.WaitAndClick(element_obj.continuebill);
		
		if(util.Isdisplayed(element_obj.userAddress)) 
		{
			util.WaitAndClick(element_obj.userAddress);
		}
		
		System.out.println("\tSmoke Testing: Address field validation in Billing page");
		
		System.out.println("\t\tTestcase - 43");
		
		int fail = 0;
		
		util.AcceptAlertifPresent(element_obj.driver);
		
		util.AcceptAlertifPresent(element_obj.driver);
		
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
		
		if(util.Isdisplayed(element_obj.Bill_stateField))
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
			
			System.out.println("\t\t\t"+"Use as Billing address checkbox verified Successfully");
		}
		else
		{
			System.out.println("\t\t\t"+"Use as Billing address checkbox verify Unsuccessfully");
			fail++;
		}
		
//		if(smoke_data.Country != "United States")
//		{
//			if(util.Isdisplayed(element_obj.policyCheck))
//			{
//				
//				System.out.println("\t\t\t"+"Policy checkbox verified Successfully");
//			}
//			else
//			{
//				System.out.println("\t\t\t"+"Policy checkbox verify Unsuccessfully");
//				fail++;
//			}
//		}
		
		if(fail>0)
		{
			func.write_Regressiontest(false, 43);
		}
		else
		{
			func.write_Regressiontest(true, 43);
		}

	}
	
	public void Invalid_creditcard() throws Exception
	{
		
		System.out.println("\tSmoke Testing: Invalid Credit Card Validation");
		
		System.out.println("\t\tTestcase - 44");
		
//		util.WaitAndClick(element_obj.continuebill);
//		
//		if(util.Isdisplayed(element_obj.SuggestionAddress)) 
//		{
//			util.WaitAndClick(element_obj.SuggestionAddress);
//		}		
		
		util.Sendkeys(element_obj.cardnumber, "41111111111111111");
		
		Select card_month = new Select(element_obj.cardmonth);
		
		card_month.selectByValue(data_obj.Visa_month);

		element_obj.cardyear.sendKeys("2021");

		element_obj.cardcvn.sendKeys("1234");
		
		element_obj.cardname.sendKeys(data_obj.firstname);
		
		if(data_Regression.testCount == 2)
		{
			util.Click(element_obj.shpInt);
		}
		
		element_obj.continuePlaceorder.click();
		
		if(util.Isdisplayed(element_obj.continuePlaceorder))
		{
			System.out.println("\t\t\t"+"Invalid Credit card NOT Accepted Sucessfully");
			func.write_Regressiontest(true, 44);
		}
		else
		{
			System.out.println("\t\t\t"+"Invalid Credit card Accepted - Unsucessful");
			func.write_Regressiontest(false, 44);
		}
		
		
	}
	
	public void Redeem_GC(String gc) throws Exception
	{
		
		System.out.println("\tSmoke Testing: Redeeming Gift certificate");
		
		System.out.println("\t\tTestcase - 45");
		
		util.Click(element_obj.giftcard_coupon_toggle);
		
		util.Clear(element_obj.giftcard);
		
		util.Sendkeys(element_obj.giftcard, gc);
		
		util.Click(element_obj.GC_apply);
		
		if(util.Isdisplayed(element_obj.GC_successmsg))
		{
			System.out.println("\t\t\t"+"The E-Gift card redeemed Successfully");
			func.write_Regressiontest(true, 45);
		}
		else
		{
			System.out.println("\t\t\t"+"The E-Gift card redeem Unsuccessfully");
			func.write_Regressiontest(false, 45);
		}
	}
	
	
	public void ValidatePayment() throws Exception
	{
		
		System.out.println("\tSmoke Testing: Payment using Credit card");
		
		System.out.println("\t\tTestcase - 46");
		
		switch("Visa") 
		{

		case "Visa":
			
			element_obj.cardnumber.clear();

			util.Sendkeys(element_obj.cardnumber, data_obj.Visa_number);
				
			Select card_month = new Select(element_obj.cardmonth);
			card_month.selectByValue(data_obj.Visa_month);

			element_obj.cardyear.sendKeys(data_obj.Visa_year);

			element_obj.cardcvn.clear();
			
			element_obj.cardcvn.sendKeys(data_obj.Visa_cvv);
						
			element_obj.cardname.clear();
			
			element_obj.cardname.sendKeys(data_obj.firstname);
			
			util.Click(element_obj.useAsBillingAddress);
			
		case "Amex":
			
			element_obj.cardname.clear();
			
			element_obj.cardname.sendKeys(data_obj.firstname);
			
			element_obj.cardnumber.clear();
			
			element_obj.cardnumber.sendKeys(data_obj.Amex_number);

			Select AmexCard_month = new Select(element_obj.cardmonth);
			
			AmexCard_month.selectByValue(data_obj.Amex_month);

			element_obj.cardyear.sendKeys(data_obj.Amex_year);
			
			element_obj.cardcvn.clear();
			
			element_obj.cardcvn.sendKeys(data_obj.Amex_cvv);
			
			util.Click(element_obj.useAsBillingAddress);
			
			util.Click(element_obj.continuePlaceorder);
			
			util.Click(element_obj.driver.findElement(By.xpath("//a[@title='Billing']")));
						
		case "Dis":
			
			element_obj.cardname.clear();
			
			element_obj.cardname.sendKeys(data_obj.firstname);
			
			element_obj.cardnumber.sendKeys(data_obj.Dis_number);

			Select Dis_month = new Select(element_obj.cardmonth);
			Dis_month.selectByValue(data_obj.Dis_month);

			element_obj.cardyear.sendKeys(data_obj.Dis_year);
			
			element_obj.cardcvn.sendKeys(data_obj.Dis_cvv);
			
			util.Click(element_obj.useAsBillingAddress);
			
			break;
			
		case "Paypal":

			func.paypal();

			break;

		default:

			System.out.println("\t\t\t"+"Give a Valid Payment Method");
			break;
		}
		
		
		data_Regression.BP_subtotal = element_obj.BP_subtotal.getText();
		
		data_Regression.BP_tax = element_obj.BP_tax.getText();
		
		data_Regression.BP_total = element_obj.BP_total.getText();
		
		for(int i = 1; i <= data_Regression.itemlist.length; i++)
		{
			
			data_Regression.BP_prdName.add(i-1, element_obj.driver.findElement(By.xpath("(//div[@class='mini-cart-name']//child::a)["+i+"]")).getText());
			
			data_Regression.BP_price.add(i-1, element_obj.driver.findElement(By.xpath("(//span[@class='mini-cart-price'])["+i+"]")).getText());
				
			data_Regression.BP_qty.add(i-1, element_obj.driver.findElement(By.xpath("(//div[@class='mini-cart-quantity']//child::span[@class='value'])["+i+"]")).getText());
			
		}
		
		if(util.Isdisplayed(element_obj.shpInt))
		{
			Thread.sleep(3000);
			
			element_obj.shpInt.click();
		}
		
		util.WaitAndClick(element_obj.continuePlaceorder);
		
		if(util.Isdisplayed(element_obj.policyCheck))
		{
			util.Click(element_obj.shpInt);	
			util.WaitAndClick(element_obj.continuePlaceorder);

		}
		
		if(util.Isdisplayed(element_obj.driver.findElement(By.xpath("//h2[text()='Place Order']"))))
		{
			System.out.println("\t\t\t"+"Payment using Credit card is Successful");
			func.write_Regressiontest(true, 46);
		}
		else
		{
			System.out.println("\t\t\t"+"Payment using Credit card is Unsuccessful");
			func.write_Regressiontest(false, 46);
		}

	}
	

}
