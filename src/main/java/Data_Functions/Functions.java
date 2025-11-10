package Data_Functions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Collections;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

// import com.itextpdf.text.log.SysoLogger;

import Regression.*;
import SiteMonitoring.SiteMonitoringConstantData;

import org.openqa.selenium.WebElement;
import Smoke_test.*;

public class Functions {
	

	public driverUtil util = new driverUtil();
	constantData data_obj;
	pageElements element_obj; 
	SiteMonitoringConstantData SiteData;
	//SiteMonitoring Site = new SiteMonitoring;
	
	
	

   public Functions(constantData data,pageElements elem)
   {
	   data_obj=data;
	   element_obj=elem;
//	   SiteData=site;
   }
	
	
   public static Workbook fileSetup(FileInputStream istream, String fileName) throws IOException
   {
		Workbook book = null;

		String extension = fileName.substring(fileName.indexOf("."));

		if(extension.equals(".xlsx"))
		{

			book = new XSSFWorkbook(istream);
		}

		else if(extension.equals(".xls"))
		{

			book = new HSSFWorkbook(istream);

		}
		return book;
   }
	
	
   public void bulkOrder_testing(String type) throws Exception  
   {

		DataFormatter formatter = new DataFormatter();

		File file = new File(data_obj.filePath+"\\"+data_obj.fileName);

		FileInputStream istream = new FileInputStream(file);

		Workbook book = fileSetup(istream,data_obj.fileName);

		Sheet sheet = book.getSheet(data_obj.sheetName);

		if(type=="Regression")
		{
			login();
		}
 
		for (data_obj.orderCount = 1; data_obj.orderCount < data_obj.totalOrder; data_obj.orderCount++) {

			data_obj.flag = true;
			
			Row row = sheet.getRow(data_obj.orderCount);

			element_obj.itemlist = formatter.formatCellValue(row.getCell(1)).split(",");

			element_obj.qty = formatter.formatCellValue(row.getCell(2)).split(",");
			
			element_obj.variant = formatter.formatCellValue(row.getCell(3)).split(",");

			element_obj.Address1 = formatter.formatCellValue(row.getCell(4));

			element_obj.City = formatter.formatCellValue(row.getCell(5));

			element_obj.Zip_Code = formatter.formatCellValue(row.getCell(6)); 
			
			element_obj.State = formatter.formatCellValue(row.getCell(7)); 

			element_obj.Shipping_Method = formatter.formatCellValue(row.getCell(8));

			element_obj.Payment_Method = formatter.formatCellValue(row.getCell(9));
			
			element_obj.couponCode = formatter.formatCellValue(row.getCell(17));

			System.out.println("Variable data_obj are Collected");

			data_obj.flag = selectItems();
			
			if(data_obj.flag==false)
			{
				continue;
			}

			data_obj.flag = shipping("Domestic") ;
			
			if(data_obj.flag==false)
			{
				continue;
			}

			payment() ;
			
			if(data_obj.flag==false)
			{
				continue;
			}
			
			data_obj.flag = placeOrder("Domestic") ;
			
			if(data_obj.flag==false)
			{
				continue;
			}

			orderConfirmation();
		}
		
		Logout();
		
   }
   
   public void bulkOrder_testing(String filePath, String fileName, String sheetName, int totalOrders, String type) throws Exception  
   {

		DataFormatter formatter = new DataFormatter();

		File file = new File(filePath+"\\"+fileName);

		FileInputStream istream = new FileInputStream(file);

		Workbook book = fileSetup(istream,data_obj.fileName);

		Sheet sheet = book.getSheet(sheetName);

		if(type=="Regression")
		{
			login();
		}
 
		for (data_obj.orderCount = 1; data_obj.orderCount < totalOrders; data_obj.orderCount++) {

			data_obj.flag = true;
			
			Row row = sheet.getRow(data_obj.orderCount);

			element_obj.itemlist = formatter.formatCellValue(row.getCell(1)).split(",");

			element_obj.qty = formatter.formatCellValue(row.getCell(2)).split(",");
			
			element_obj.variant = formatter.formatCellValue(row.getCell(3)).split(",");

			element_obj.Address1 = formatter.formatCellValue(row.getCell(4));

			element_obj.City = formatter.formatCellValue(row.getCell(5));

			element_obj.Zip_Code = formatter.formatCellValue(row.getCell(6)); 
			
			element_obj.State = formatter.formatCellValue(row.getCell(7)); 

			element_obj.Shipping_Method = formatter.formatCellValue(row.getCell(8));

			element_obj.Payment_Method = formatter.formatCellValue(row.getCell(9));
			
			element_obj.couponCode = formatter.formatCellValue(row.getCell(17));

//			System.out.println("Variable data_obj are Collected");

			data_obj.flag = selectItems();
			
			if(data_obj.flag==false)
			{
				continue;
			}

			data_obj.flag = shipping("Domestic") ;
			
			if(data_obj.flag==false)
			{
				continue;
			}

			payment() ;
			
			if(data_obj.flag==false)
			{
				continue;
			}
			
			data_obj.flag = placeOrder("Domestic") ;
			
			if(data_obj.flag==false)
			{
				continue;
			}

			orderConfirmation(filePath,fileName,sheetName);
		}
		
		Logout();
		
   }
   
   public boolean placeOrder(String orderType) throws InterruptedException
   {
//	   if(element_obj.Error_form.isDisplayed())
//			
//		{
//			System.out.println(element_obj.Error_form.getText());
//			return false;
//		}
	   
//	   if(orderType.equalsIgnoreCase("Domestic"))
//		{
//			element_obj.placeorder.click();
//			return true;
//		}
//		
//		else if(orderType.equalsIgnoreCase("International"))
//		{
//			
//			Thread.sleep(3000);
//			
//			util.jClick(element_obj.shpInt);
//			
//			
//			element_obj.shpInt.click();
//			
//			element_obj.placeorder.click();
//			return true;
//		}
	   if(util.Isdisplayed(element_obj.shpInt))
	   {
		   Thread.sleep(3000);
		   util.Click(element_obj.shpInt);
		   util.Click(element_obj.placeorder);
		   if(util.Isdisplayed(element_obj.shpInt))
		   {
			   util.Click(element_obj.shpInt);
			   util.Click(element_obj.placeorder);
		   }
	   }
	   else
	   {
		   util.Click(element_obj.placeorder);
	   }
	   return true;
   }
   
   public void bulkOrder_International(String type) throws Exception
   {
	   DataFormatter formatter = new DataFormatter();

		File file = new File(data_obj.filePath+"\\"+data_obj.fileName);

		FileInputStream istream = new FileInputStream(file);

		Workbook book = fileSetup(istream,data_obj.fileName);

		Sheet sheet = book.getSheet(data_obj.sheetName);

		if(type=="Regression")
		{
			login();
		}

		for (data_obj.orderCount = 1; data_obj.orderCount < data_obj.totalOrder; data_obj.orderCount++) {

			Row row = sheet.getRow(data_obj.orderCount);

			element_obj.itemlist = formatter.formatCellValue(row.getCell(1)).split(",");

			element_obj.qty = formatter.formatCellValue(row.getCell(2)).split(",");
		
			element_obj.variant = formatter.formatCellValue(row.getCell(3)).split(",");

			element_obj.Address1 = formatter.formatCellValue(row.getCell(4));

			element_obj.City = formatter.formatCellValue(row.getCell(5));

			element_obj.Zip_Code = formatter.formatCellValue(row.getCell(6));
			
			element_obj.State = formatter.formatCellValue(row.getCell(16));
		
			element_obj.Country = formatter.formatCellValue(row.getCell(7));
			
			element_obj.Shipping_Method = formatter.formatCellValue(row.getCell(8));

			element_obj.Payment_Method = formatter.formatCellValue(row.getCell(9));
			
			

			System.out.println("Variable data_obj are Collected");

			data_obj.flag = selectItems();
		
			if(!data_obj.flag)
			{
				element_obj.remove.click();
				continue;
			}

			shipping("International") ;

			payment() ;
		
			data_obj.flag = placeOrder("International") ;
			
			orderConfirmation();

		}
		
		Logout();
   }

   public void bulkOrder_International(String filePath, String fileName, String sheetName, int totalOrders, String type) throws Exception
   {
	   DataFormatter formatter = new DataFormatter();

		File file = new File(filePath+"\\"+fileName);

		FileInputStream istream = new FileInputStream(file);

		Workbook book = fileSetup(istream,fileName);

		Sheet sheet = book.getSheet(sheetName);

		if(type=="Regression")
		{
			login();
		}

		for (data_obj.orderCount = 1; data_obj.orderCount < totalOrders; data_obj.orderCount++) {

			Row row = sheet.getRow(data_obj.orderCount);

			element_obj.itemlist = formatter.formatCellValue(row.getCell(1)).split(",");

			element_obj.qty = formatter.formatCellValue(row.getCell(2)).split(",");
		
			element_obj.variant = formatter.formatCellValue(row.getCell(3)).split(",");

			element_obj.Address1 = formatter.formatCellValue(row.getCell(4));

			element_obj.City = formatter.formatCellValue(row.getCell(5));

			element_obj.Zip_Code = formatter.formatCellValue(row.getCell(6));
			
			element_obj.State = formatter.formatCellValue(row.getCell(16));
		
			element_obj.Country = formatter.formatCellValue(row.getCell(7));
			
			element_obj.Shipping_Method = formatter.formatCellValue(row.getCell(8));

			element_obj.Payment_Method = formatter.formatCellValue(row.getCell(9));

			data_obj.flag = selectItems();
		
			if(!data_obj.flag)
			{
				element_obj.remove.click();
				continue;
			}

			shipping("International") ;

			payment() ;
		
			data_obj.flag = placeOrder("International") ;
			
			orderConfirmation(filePath,fileName,sheetName);

		}
		
		Logout();
   }
	

public void orderConfirmation() throws Exception {
	
//	util.Click(data_obj.driver.findElement(By.xpath("//a[@title='Order History']")));
//	
//	util.Click(data_obj.driver.findElement(By.xpath("(//button[@value='Order Details'])[1]")));
//	
	System.out.println("Order"+(data_obj.orderCount));

	element_obj.itemlist = null;

	element_obj.qty = null;
	
	data_obj.preorder_flag = 0;

	data_obj.orderNumber = element_obj.orderNumber.getText().toString();

	System.out.println(data_obj.orderNumber.substring(15));
	
	data_obj.subTotal = element_obj.Subtotal.getText().toString();

	System.out.println(data_obj.subTotal);
	
	if(util.Isdisplayed(element_obj.Shipping_cost)) {
	
		data_obj.shippinging_cost = element_obj.Shipping_cost.getText().toString();
	}

	else{
	
		data_obj.shippinging_cost1 = element_obj.Shipping_cost1.getText().toString();
	
		data_obj.shippinging_cost2 = element_obj.Shipping_cost2.getText().toString();
	
		data_obj.shippinging_cost = data_obj.shippinging_cost1.concat("+"+data_obj.shippinging_cost2);
	}

	data_obj.handling_cost = element_obj.Handling_cost.getText().toString();

	System.out.println(data_obj.handling_cost);

	data_obj.salesTax = element_obj.salesTax.getText().toString();

	System.out.println(data_obj.salesTax);

	data_obj.orderTotal = element_obj.orderTotal.getText().toString();

	System.out.println(data_obj.orderTotal);

	writeOrderDetail(data_obj.orderCount, data_obj.orderNumber, data_obj.handling_cost, data_obj.salesTax, data_obj.orderTotal, data_obj.shippinging_cost,data_obj.subTotal);

	//util.snapShots(data_obj.driver,"C:\\Users\\UNITS\\Documents\\Metallica_orders\\Order"+data_obj.orderCount+".png");
}

public void orderConfirmation(String filePath, String fileName, String sheetName) throws Exception {
	
//	util.Click(data_obj.driver.findElement(By.xpath("//a[@title='Order History']")));
//	
//	util.Click(data_obj.driver.findElement(By.xpath("(//button[@value='Order Details'])[1]")));
//	
	System.out.println("Order"+(data_obj.orderCount));

	element_obj.itemlist = null;

	element_obj.qty = null;
	
	data_obj.preorder_flag = 0;

	data_obj.orderNumber = element_obj.orderNumber.getText().toString();

	System.out.println(data_obj.orderNumber.substring(15));
	
	data_obj.subTotal = element_obj.Subtotal.getText().toString();

	System.out.println(data_obj.subTotal);
	
	if(util.Isdisplayed(element_obj.Shipping_cost)) {
	
		data_obj.shippinging_cost = element_obj.Shipping_cost.getText().toString();
	}

	else{
	
		data_obj.shippinging_cost1 = element_obj.Shipping_cost1.getText().toString();
	
		data_obj.shippinging_cost2 = element_obj.Shipping_cost2.getText().toString();
	
		data_obj.shippinging_cost = data_obj.shippinging_cost1.concat("+"+data_obj.shippinging_cost2);
	}

	data_obj.handling_cost = element_obj.Handling_cost.getText().toString();

	System.out.println(data_obj.handling_cost);

	data_obj.salesTax = element_obj.salesTax.getText().toString();

	System.out.println(data_obj.salesTax);

	data_obj.orderTotal = element_obj.orderTotal.getText().toString();

	System.out.println(data_obj.orderTotal);

	writeOrderDetail(data_obj.orderCount, data_obj.orderNumber, data_obj.handling_cost, data_obj.salesTax, data_obj.orderTotal, data_obj.shippinging_cost,data_obj.subTotal,filePath,fileName,sheetName);

	util.snapShots(data_obj.driver,"C:\\Users\\UNITS\\Documents\\Metallica_orders\\Order"+data_obj.orderCount+".png");
}


public boolean selectItems() throws InterruptedException, Exception 
{
	
	for(int j = 0; j < element_obj.itemlist.length; j++)
	{
			
		Thread.sleep(2000);
				
		util.Click(element_obj.srch);
		
		util.Click(element_obj.SearchBar);
			
		util.Sendkeys(element_obj.srchIP,element_obj.itemlist[j]);

		element_obj.srchTxt.submit();
		
//		No such product
//		Out of stock
			
//		if(element_obj.variant[j]!="0") 
//		{
//			
//			size(element_obj.variant[j]);
////			No available variant
//		}
			
		
		if(util.Isdisplayed(element_obj.PDP_quantity)) 
		{
					
//			util.Clear(element_obj.PDP_quantity);
//					
//			util.AcceptAlertifPresent(data_obj.driver);
//					
//			util.Clear(element_obj.PDP_quantity);
//					
//			util.AcceptAlertifPresent(data_obj.driver);
//					
//			util.Sendkeys(element_obj.PDP_quantity,element_obj.qty[j]);	
//			
			if(util.Isdisplayed(element_obj.preorder))
			{
				util.Click(element_obj.preorder);
				
				util.Click(element_obj.preorder_ack);
				
				util.Click(element_obj.preorder_ATC);
				
				data_obj.preorder_flag++;
				
			}
			
			else
			{
				util.Click(element_obj.addcart);
			}
			
			
			//Capturing Product price

		}

		else 
		{

			System.out.println("Quantity is not displayed");
			
			if(util.Isdisplayed(element_obj.preorder))
			{
				util.Click(element_obj.preorder);
				
				util.Click(element_obj.preorder_ack);
				
				util.Click(element_obj.preorder_ATC);
				
				data_obj.preorder_flag++;
				
			}
			
			else
			{
				util.Click(element_obj.addcart);
			}
					
	//		util.Click(element_obj.addcart);
		}

				
		util.Click(element_obj.miniviewcart);
			
//		System.out.println("Product "+(j+1)+" is added");
				
	}
	
//	util.Sendkeys(element_obj.coupon, element_obj.couponCode);  //Coupon apply
//	
//	util.Click(element_obj.Coupon_apply);
	
	util.WaitAndClick(element_obj.checkout);
	
//	System.out.println("Cart is ready");
			
	return true;

}
   
	
	public void cartCheckout() throws InterruptedException 
	{
		
		registeredUserCheckout();
		
		//signupCheckout();
		
		guestCheckout("");
		
	}
	
	public void guestCheckout(String email) throws InterruptedException 
	{
		
		util.Sendkeys(element_obj.email, email);
		
		util.Click(element_obj.Guest_chkBox);
		
		util.WaitAndClick(element_obj.Guest_CO);
		
	}

	public void registeredUserCheckout() throws InterruptedException 
	{
		
		util.Sendkeys(element_obj.email, data_obj.username);

		util.Sendkeys(element_obj.password, data_obj.DEV_password);
		
		util.Click(element_obj.checkout);
		
	}
	
	public void login() throws InterruptedException {
		
		util.Click(element_obj.login);
		
		util.Sendkeys(element_obj.email, data_obj.username);
	
		util.Sendkeys(element_obj.password, data_obj.DEV_password);
	
		util.Click(element_obj.login_button);
		
//		System.out.println("User is Logged in");
		
//		util.Click(element_obj.Metallica);

	}

	public void PRD_login() throws InterruptedException {
		
		util.Click(element_obj.login);
		
		util.Sendkeys(element_obj.email, data_obj.username);
	
		util.Sendkeys(element_obj.password, data_obj.DEV_password);
	
		util.Click(element_obj.login_button);
		
//		System.out.println("User is Logged in");
		
//		util.Click(element_obj.Metallica);

	}

	
public void smoke_login(String email, String password) throws InterruptedException {
		
		util.Click(element_obj.login);
		
		util.Sendkeys(element_obj.email, email);
	
		util.Sendkeys(element_obj.password, password);
	
		util.Click(element_obj.login_button);
		
//		System.out.println("User is Logged in");
		
//		util.Click(element_obj.Metallica);

	}

public void Logout() throws InterruptedException {
	
//	util.Click(element_obj.Metallica);
	
	util.Click(element_obj.MyAccount);
	
	util.Click(element_obj.Logout);
	
}
	
	public void Validate_Login() throws InterruptedException, IOException {
		
		DataFormatter formatter = new DataFormatter();

		File file = new File(data_obj.filePath+"\\"+data_obj.fileName);

		FileInputStream istream = new FileInputStream(file);

		Workbook book = fileSetup(istream,data_obj.fileName);

		Sheet sheet = book.getSheet(data_obj.sheetName);
 
		for (data_obj.orderCount = 1; data_obj.orderCount < data_obj.totalOrder; data_obj.orderCount++) 
		{
			
			Row row = sheet.getRow(data_obj.orderCount);
			
			String id = formatter.formatCellValue(row.getCell(1));
					
			String pwd = formatter.formatCellValue(row.getCell(2));
			
			String eUsername = formatter.formatCellValue(row.getCell(3));
		
			util.Click(element_obj.login);
		
			util.Sendkeys(element_obj.email, id);
	
			util.Sendkeys(element_obj.password, pwd);
	
			util.Click(element_obj.login_button);

			util.WaitAndClick(element_obj.MyAccount);
		
			System.out.println("Login Successful for "+eUsername);
							
			util.WaitAndClick(element_obj.Logout);
		
//			String aUsername = data_obj.driver.findElement(By.xpath("//h1[@class='overview-header']")).getText();
//		
//			if(aUsername.contains(eUsername))
//			{
//				
//				
//			}
		}
		
		
		

	}

	public boolean shipping(String orderType) throws Exception
	{
		//no.click()
		
		util.Clear(element_obj.firstname);

		util.Sendkeys(element_obj.firstname,data_obj.firstname);
		
		util.Clear(element_obj.lastname);

		util.Sendkeys(element_obj.lastname,data_obj.lastname);

		util.Clear(element_obj.address1);
		
		util.Sendkeys(element_obj.address1,element_obj.Address1);

		util.Clear(element_obj.city);
		
		util.Sendkeys(element_obj.city,element_obj.City);

		util.Clear(element_obj.zipcode);
		
		util.Sendkeys(element_obj.zipcode,element_obj.Zip_Code);

		if(orderType.equalsIgnoreCase("Domestic"))
		{
			Select state = new Select(element_obj.stateField);
			state.selectByVisibleText(element_obj.State);
			
			util.Clear(element_obj.phone);
			
			util.Sendkeys(element_obj.phone,data_obj.Phone);
		}
				
		if(orderType.equalsIgnoreCase("International"))
		{
			Select country = new Select(element_obj.countryField);
			country.selectByVisibleText(element_obj.Country);
			
			
			switch(element_obj.Country)
			{
			case "United Kingdom":
				
				util.Clear(element_obj.phone);
				
				util.Sendkeys(element_obj.phone,"9856475245255");
				
				break;
				
			case "France":
				
				util.Clear(element_obj.phone);
				
				util.Sendkeys(element_obj.phone,"06457894141");
				
				break;
				
			case "Canada":
				
				Thread.sleep(2000);
				
				Select state = new Select(element_obj.CAstateField);
				state.selectByVisibleText(element_obj.State);
				
				break;
				
			default:
				
				util.Clear(element_obj.phone);
				
				util.Sendkeys(element_obj.phone,data_obj.Phone);
				
				break;
			}		
			
		}

		

//		util.Click(element_obj.useAsBillingAddress); //check-box to keep shipping address as billing address
//
//		shipMethod(element_obj.Shipping_Method);
//		
//		if(data_obj.flag == false)
//		{
//			return false;
//		}
//		Thread.sleep(5000);
		
//		captureShippingMethod();
//		
//		if(!element_obj.shipping_Container.isDisplayed())
//		{
//			System.out.println("Shipping method table missing");
//			System.exit(0);
//		}
		
		if(data_obj.preorder_flag > 1)
		{
			util.Click(element_obj.preorder_ack);
		}

		util.WaitAndClick(element_obj.continuebill);
		
		if(util.Isdisplayed(element_obj.userAddress)) 
		{
			util.WaitAndClick(element_obj.userAddress);
		}
		
		return true;

	}

	public void captureShippingMethod() throws Exception {
		
		
		while(!element_obj.continuebill.isEnabled())
		{
			//System.out.println("Waiting for Shipping method");
		}
		
		
		List<WebElement>  ShippingMethod = data_obj.driver.findElements(By.xpath("//div[@class='form-row form-indent label-inline shipping-method']/label"));
		
		int SMcount = ShippingMethod.size();
			
	
//		int SMcount = data_obj.driver.findElements(By.xpath("//div[@class='form-row form-indent label-inline shipping-method']/label")).size() ;
		
		for(int i=0; i < SMcount; i++)
		{	
			
			element_obj.SMlabel.add(ShippingMethod.get(i).getText());
			
			System.out.println(element_obj.SMlabel.get(i).toString());
			
//			WebElement SmethodLabel = data_obj.driver.findElement(By.xpath("(//div[@class='form-row form-indent label-inline shipping-method'])["+i+"]//label"));
//			
//			System.out.println(SmethodLabel.getText());	
//			
//			WebElement SmethodPrice = data_obj.driver.findElement(By.xpath("(//div[@class='form-row form-indent label-inline shipping-method'])["+i+"]//span"));
//			
//			System.out.println(SmethodPrice.getText());
			
		}
		
		writeSMlabel();
		
		element_obj.SMlabel.clear();
			
	}


	public void shipMethod(String shipping) throws Exception
	{
		
		Thread.sleep(2000);

			switch(shipping)
			{
			case "Ground" :

				util.WaitAndClick(element_obj.ground);
				break ;

			case "Priority":

				util.WaitAndClick(element_obj.priorityMail);
				break ;

			case "Twoday" :

				util.WaitAndClick(element_obj.twodayAir);
				break ;

			case "Mail" :

				util.WaitAndClick(element_obj.mailInnovation);
				break;

			default :
				
				data_obj.flag = false;
				break;
			}
		

	}

	public void payment() throws Exception
	{
		switch(element_obj.Payment_Method) 
		{

		case "Visa":

			
			util.Sendkeys(element_obj.cardnumber, data_obj.Visa_number);
			
			Select card_month = new Select(element_obj.cardmonth);
			
			card_month.selectByValue(data_obj.Visa_month);

			element_obj.cardyear.sendKeys(data_obj.Visa_year);

			element_obj.cardcvn.sendKeys(data_obj.Visa_cvv);
			
			element_obj.cardname.sendKeys(data_obj.firstname);
//			
//			if(element_obj.Error_message.isDisplayed())
//			{
//				System.out.println(element_obj.Error_message.toString());
//				return false;
//			}
//			
//			else if(element_obj.Error_span.isDisplayed())
//			{
//				System.out.println(element_obj.Error_span.toString());
//				return false;
//			}
			
			break;

		case "Amex":

						
			element_obj.cardname.sendKeys(data_obj.firstname);
			
			element_obj.cardnumber.sendKeys(data_obj.Amex_number);

			Select AmexCard_month = new Select(element_obj.cardmonth);
			AmexCard_month.selectByValue(data_obj.Amex_month);

			element_obj.cardyear.sendKeys(data_obj.Amex_year);
			
			element_obj.cardcvn.sendKeys(data_obj.Amex_cvv);

//			if(element_obj.Error_message.isDisplayed())
//			{
//				System.out.println(element_obj.Error_message.toString());
//				return false;
//			}
//			
//			else if(element_obj.Error_span.isDisplayed())
//			{
//				System.out.println(element_obj.Error_span.toString());
//				return false;
//			}
			
			break;
			
		case "Dis":
			
			element_obj.cardname.sendKeys(data_obj.firstname);
			
			element_obj.cardnumber.sendKeys(data_obj.Dis_number);

			Select Dis_month = new Select(element_obj.cardmonth);
			Dis_month.selectByValue(data_obj.Dis_month);

			element_obj.cardyear.sendKeys(data_obj.Dis_year);
			
			element_obj.cardcvn.sendKeys(data_obj.Dis_cvv);
			
			break;
			
		case "Mas":
			
			element_obj.cardname.sendKeys(data_obj.firstname);
			
			element_obj.cardnumber.sendKeys(data_obj.Mas_number);

			Select Mas_month = new Select(element_obj.cardmonth);
			Mas_month.selectByValue(data_obj.Mas_month);

			element_obj.cardyear.sendKeys(data_obj.Mas_year);
			
			element_obj.cardcvn.sendKeys(data_obj.Mas_cvv);
			
			break;

		case "Paypal":

			paypal();

			break;

		default:

			System.out.println("Give a Valid Payment Method");
			break;
		}
		
		element_obj.continuePlaceorder.click();

	}
	
	public void smoke_payment(String card) throws Exception
	{
		switch(card) 
		{

		case "Visa":

			
			util.Sendkeys(element_obj.cardnumber, data_obj.Visa_number);
			
			Select card_month = new Select(element_obj.cardmonth);
			card_month.selectByValue(data_obj.Visa_month);

			element_obj.cardyear.sendKeys(data_obj.Visa_year);

			element_obj.cardcvn.sendKeys(data_obj.Visa_cvv);
			
			element_obj.cardname.sendKeys(data_obj.firstname);
//			
//			if(element_obj.Error_message.isDisplayed())
//			{
//				System.out.println(element_obj.Error_message.toString());
//				return false;
//			}
//			
//			else if(element_obj.Error_span.isDisplayed())
//			{
//				System.out.println(element_obj.Error_span.toString());
//				return false;
//			}
			
			break;

		case "Amex":

						
			element_obj.cardname.sendKeys(data_obj.firstname);
			
			element_obj.cardnumber.sendKeys(data_obj.Amex_number);

			Select AmexCard_month = new Select(element_obj.cardmonth);
			AmexCard_month.selectByValue(data_obj.Amex_month);

			element_obj.cardyear.sendKeys(data_obj.Amex_year);
			
			element_obj.cardcvn.sendKeys(data_obj.Amex_cvv);

//			if(element_obj.Error_message.isDisplayed())
//			{
//				System.out.println(element_obj.Error_message.toString());
//				return false;
//			}
//			
//			else if(element_obj.Error_span.isDisplayed())
//			{
//				System.out.println(element_obj.Error_span.toString());
//				return false;
//			}
			
			break;
			
		case "Dis":
			
			element_obj.cardname.sendKeys(data_obj.firstname);
			
			element_obj.cardnumber.sendKeys(data_obj.Dis_number);

			Select Dis_month = new Select(element_obj.cardmonth);
			Dis_month.selectByValue(data_obj.Dis_month);

			element_obj.cardyear.sendKeys(data_obj.Dis_year);
			
			element_obj.cardcvn.sendKeys(data_obj.Dis_cvv);
			
			break;

		case "Paypal":

			paypal();

			break;

		default:

			System.out.println("Give a Valid Payment Method");
			break;
		}
	}
	
		
	public void paypal() throws Exception {
		
		util.Click(element_obj.Paypal_chkbx);
		
		util.Click(element_obj.useAsBillingAddress);
		
		WebElement iframe = new WebDriverWait(element_obj.driver,15).until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//iframe[@class='zoid-component-frame zoid-visible'])[1]")));
		
		element_obj.driver.switchTo().frame(iframe);
		
		util.WaitAndClick(element_obj.Paypal_btn);
		
		util.SwitchtoLatestWindow(element_obj.driver);
		
//		util.Sendkeys(element_obj.driver.findElement(By.xpath("//input[@id='email']")), smoke_data.email);
		
		util.WaitAndClick(element_obj.driver.findElement(By.xpath("//button[@id='acceptAllButton']")));
		
		util.Click(element_obj.Paypal_guestpay);
		
		util.Sendkeys(element_obj.Paypal_CC_number, data_obj.Visa_number);
		
		util.Sendkeys(element_obj.Paypal_CC_date, data_obj.Visa_month+data_obj.Visa_year.substring(2));
		
		util.Sendkeys(element_obj.Paypal_CC_CVV, data_obj.Visa_cvv);
		
		util.Sendkeys(element_obj.Paypal_email, data_obj.email);
		
		util.Click(element_obj.Paypal_confirm);
		
		data_obj.driver.wait(5000);
		
		util.Sendkeys(element_obj.Paypal_CC_number, data_obj.Visa_number);
		
		util.Sendkeys(element_obj.Paypal_CC_date, data_obj.Visa_month+data_obj.Visa_year.substring(2));
		
		util.Sendkeys(element_obj.Paypal_CC_CVV, data_obj.Visa_cvv);
		
//		util.Sendkeys(element_obj.Paypal_firstName, smoke_data.firstname);
//		
//		util.Sendkeys(element_obj.Paypal_lastName, smoke_data.lastname);
//		
//		util.Sendkeys(element_obj.Paypal_address, smoke_data.Address1);
//		
//		util.Sendkeys(element_obj.Paypal_city, smoke_data.City);
//		
//		util.Sendkeys(element_obj.Paypal_zipcode, smoke_data.Zip_Code);
//		
//		util.Sendkeys(element_obj.Paypal_phone, smoke_data.phone);
		
		util.Sendkeys(element_obj.Paypal_email, data_obj.email);
		
		util.Click(element_obj.Paypal_pay);	
		
		util.SwitchtoWindowByTitle(element_obj.driver, " Checkout - Order Review | 103.1.9 - controllers");

	}

	public void size(String variant) throws Exception
	{
		
		WebDriverWait wait = new WebDriverWait(data_obj.driver,6);
		
		try
		{
			switch(variant)
			{
			
			case "mp3":
				
				if(element_obj.Mp3.isEnabled())
				{
					element_obj.Mp3.click();
				}
				else
				{
					data_obj.flag = false;
				}
				break;
				
			case "flac":
				if(element_obj.Flac.isEnabled())
				{
					element_obj.Flac.click();;
				}
				else
				{
					
					data_obj.flag = false;
				}
				break;
					
			case "flac-hd":
				
				element_obj.Flac_HD.click();
				break;
				
			case "alac":
				
				element_obj.Alac.click();;
				break;
				
			case "alac-hd":
				
				element_obj.Alac_HD.click();
				break;
				
			case "small":
				
				element_obj.sizeS.click();
				break;
				
			case "medium":
				
				element_obj.sizeM.click();
				break;
				
			case "large":
				
//				if(wait.until(ExpectedConditions.elementToBeClickable(element_obj.sizeL)) == null)
				if(!element_obj.sizeL.isEnabled())
				{
					
					element_obj.sizeL.click();
				}
				else
				{
					data_obj.flag = false;
				}
				break;
				
			case "S":
				
				element_obj.S.click();
				break;
				
			case "M":
				
				element_obj.M.click();
				break;
				
			case "L":
				
				element_obj.L.click();
				break;
			
				
			default:
				
				element_obj.L.click();
				System.out.println("Invalid format");
				break;
			
			}
		}
		
		catch(NoSuchElementException ex)
		{
			System.out.println("The Product is not available in "+variant+" size");
			data_obj.errorType = "sizeVariant";
			data_obj.flag = false;
			writeExcelComment(data_obj.errorType);
		}	
			
	}
	
	@SuppressWarnings("static-access")
	public void writeOrderDetail(int rowNumber, String orderNumber, String handling_cost, String salesTax, String orderTotal, String shippinging_cost, String subtotal) throws IOException
	{
		File file = new File(data_obj.filePath+"\\"+data_obj.fileName);

		FileInputStream istream = new FileInputStream(file);

		Workbook book = fileSetup(istream,data_obj.fileName);

		Sheet sheet = book.getSheet(data_obj.sheetName);

		Row row = sheet.getRow(rowNumber);
		
		Cell orderNumber_cell = row.createCell(10);
		
		orderNumber_cell.setCellType(orderNumber_cell.CELL_TYPE_STRING);

		orderNumber_cell.setCellValue(orderNumber.substring(14));
	    
	    Cell shippingCost_cell = row.createCell(11);
		
	    shippingCost_cell.setCellType(shippingCost_cell.CELL_TYPE_STRING);

	    shippingCost_cell.setCellValue(shippinging_cost);
	    
	    Cell handlingCost_cell = row.createCell(12);
		
	    handlingCost_cell.setCellType(handlingCost_cell.CELL_TYPE_STRING);

	    handlingCost_cell.setCellValue(handling_cost);
	    
	    Cell salesTax_cell = row.createCell(13);
		
	    salesTax_cell.setCellType(shippingCost_cell.CELL_TYPE_STRING);

	    salesTax_cell.setCellValue(salesTax);
	    
	    Cell orderTotal_cell = row.createCell(14);
		
	    orderTotal_cell.setCellType(orderTotal_cell.CELL_TYPE_STRING);

	    orderTotal_cell.setCellValue(orderTotal);
	    
	    Cell subtotal_cell = row.createCell(17);
		
	    subtotal_cell.setCellType(subtotal_cell.CELL_TYPE_STRING);

	    subtotal_cell.setCellValue(subtotal);
	    
	    
	    istream.close(); 
	    	    
	    FileOutputStream outputstream = new FileOutputStream(data_obj.filePath+"\\"+data_obj.fileName);
		
	    book.write(outputstream);
	    
	    outputstream.close();
	    
//	    System.out.println(row.getCell(10));
		

	}
	
	public void writeOrderDetail(int rowNumber, String orderNumber, String handling_cost, String salesTax, String orderTotal, String shippinging_cost, String subtotal,String filePath, String fileName, String sheetName) throws IOException
	{
		File file = new File(filePath+"\\"+fileName);

		FileInputStream istream = new FileInputStream(file);

		Workbook book = fileSetup(istream,fileName);

		Sheet sheet = book.getSheet(sheetName);

		Row row = sheet.getRow(rowNumber);
		
		Cell orderNumber_cell = row.createCell(10);
		
		orderNumber_cell.setCellType(orderNumber_cell.CELL_TYPE_STRING);

		orderNumber_cell.setCellValue(orderNumber.substring(14));
	    
	    Cell shippingCost_cell = row.createCell(11);
		
	    shippingCost_cell.setCellType(shippingCost_cell.CELL_TYPE_STRING);

	    shippingCost_cell.setCellValue(shippinging_cost);
	    
	    Cell handlingCost_cell = row.createCell(12);
		
	    handlingCost_cell.setCellType(handlingCost_cell.CELL_TYPE_STRING);

	    handlingCost_cell.setCellValue(handling_cost);
	    
	    Cell salesTax_cell = row.createCell(13);
		
	    salesTax_cell.setCellType(shippingCost_cell.CELL_TYPE_STRING);

	    salesTax_cell.setCellValue(salesTax);
	    
	    Cell subtotal_cell = row.createCell(14);
		
	    subtotal_cell.setCellType(subtotal_cell.CELL_TYPE_STRING);

	    subtotal_cell.setCellValue(subtotal);
	    
	    Cell orderTotal_cell = row.createCell(15);
		
	    orderTotal_cell.setCellType(orderTotal_cell.CELL_TYPE_STRING);

	    orderTotal_cell.setCellValue(orderTotal);
	        
	    istream.close(); 
	    	    
	    FileOutputStream outputstream = new FileOutputStream(filePath+"\\"+fileName);
		
	    book.write(outputstream);
	    
	    outputstream.close();
	    
//	    System.out.println(row.getCell(10));
		

	}
	
	public void writeExcelComment(String error) throws IOException
	{
		File file = new File(data_obj.filePath+"\\"+data_obj.fileName);

		FileInputStream istream = new FileInputStream(file);

		Workbook book = fileSetup(istream,data_obj.fileName);

		Sheet sheet = book.getSheet(data_obj.sheetName);
 
		Row row = sheet.getRow(data_obj.orderCount);
		
		data_obj.errorType = error;
		
		switch(data_obj.errorType)
		{
				
		case "sizeVariant":
			
			data_obj.errorMessage = "The Product required is not available in required size";
			break;
			
		case "excessQuantity":
			
			data_obj.errorMessage = "The Product required is not available in the required quantity";
			break;
			
		case "noShippingMethod":
			
			data_obj.errorMessage = "The Given Shipping method was not displayed";
			break;
			
		default:
			
		}	
		
		Cell orderNumber_cell = row.createCell(15);
		
		orderNumber_cell.setCellType(orderNumber_cell.CELL_TYPE_STRING);

		orderNumber_cell.setCellValue(data_obj.errorMessage);
		
		istream.close(); 
 	    
		FileOutputStream outputstream = new FileOutputStream(data_obj.filePath+"\\"+data_obj.fileName);
			
		book.write(outputstream);
		    
		outputstream.close();
		
	}
	
	public void writeSMlabel() throws Exception {
		
		File file = new File(data_obj.filePath+"\\"+data_obj.fileName);

		FileInputStream istream = new FileInputStream(file);

		Workbook book = fileSetup(istream,data_obj.fileName);

		Sheet sheet = book.getSheet(data_obj.sheetName);
 
		Row row = sheet.getRow(data_obj.orderCount);
		
	
		for(int i = 0; i < element_obj.SMlabel.size(); i++)
		{
			Cell orderNumber_cell = row.createCell(16+i);
			
			orderNumber_cell.setCellType(orderNumber_cell.CELL_TYPE_STRING);
			orderNumber_cell.setCellValue(element_obj.SMlabel.get(i).toString()+"\n");
		}
		
		istream.close(); 
 	    
		FileOutputStream outputstream = new FileOutputStream(data_obj.filePath+"\\"+data_obj.fileName);
			
		book.write(outputstream);
		    
		outputstream.close();
	}
	
	public void Date_Time() {
		
		data_obj.driver.switchTo().frame("DW-SFToolkit");
		
		element_obj.sitePreview.click();
		
		element_obj.SP_link.click();
		
		data_obj.driver.switchTo().frame("dwControlPanel");
		
		element_obj.SP_date.clear();
		
		element_obj.SP_date.sendKeys("17/07/2020");
		
		element_obj.SP_time.clear();
		
		element_obj.SP_time.sendKeys("10:00 am");
		
		element_obj.SP_ok.click();
	}
	
	public void createAccount() throws Exception {
		
		util.Click(element_obj.login);
		
		util.Click(element_obj.CreateAccount);
		
		String fileName = "Create_Account.xlsx";
		
		String sheetName = "25082020";
		
		DataFormatter formatter = new DataFormatter();

		File file = new File(data_obj.filePath+"\\"+fileName);

		FileInputStream istream = new FileInputStream(file);

		Workbook book = fileSetup(istream,fileName);

		Sheet sheet = book.getSheet(sheetName);
		
		for(int i = 1; i < 13; i++) {
			
			Row row = sheet.getRow(i);
			
			String FName = formatter.formatCellValue(row.getCell(1));
			
			String Email = formatter.formatCellValue(row.getCell(2));
			
			String pwd = formatter.formatCellValue(row.getCell(3));
			
			String DOB = formatter.formatCellValue(row.getCell(4));
			
			String Gender = formatter.formatCellValue(row.getCell(5));
			
			String Country = formatter.formatCellValue(row.getCell(6));
			
			String Zipcode = formatter.formatCellValue(row.getCell(7));
			
			util.Clear(element_obj.Reg_FName);
			util.Sendkeys(element_obj.Reg_FName, FName);
			
			util.Clear(element_obj.Reg_LName);
			util.Sendkeys(element_obj.Reg_LName, "QA");
			
			util.Clear(element_obj.Reg_UName);
			util.Sendkeys(element_obj.Reg_UName, Email);
			
			util.Clear(element_obj.Reg_Email);
			util.Sendkeys(element_obj.Reg_Email, Email);
			
			util.Clear(element_obj.Reg_CnfEmail);
			util.Sendkeys(element_obj.Reg_CnfEmail, Email);
			
			util.Clear(element_obj.Reg_Pwd);
			util.Sendkeys(element_obj.Reg_Pwd, pwd);
			
			util.Clear(element_obj.Reg_CnfPwd);
			util.Sendkeys(element_obj.Reg_CnfPwd, pwd);
			
//			util.Clear(element_obj.Reg_DOB);
			util.Sendkeys(element_obj.Reg_DOB, DOB);
			
			Select gender = new Select(element_obj.Reg_Gender);
			gender.selectByVisibleText(Gender);
			
			Select country = new Select(element_obj.Reg_Country);
			country.selectByVisibleText(Country);
			
			util.Clear(element_obj.Reg_zipcode);
			util.Sendkeys(element_obj.Reg_zipcode, Zipcode);
			
			Thread.sleep(3000);
			
			util.Click(element_obj.Reg_NewsTeller);
			
			Thread.sleep(5000);
			
			util.WaitAndClick(element_obj.Reg_recaptcha);
			
//			util.Click(element_obj.Reg_Apply);
			
			util.Click(element_obj.MyAccount);
			
			util.Click(element_obj.Logout);
			
			System.out.println("Account for "+Email+" is Created");
			
		}

		
	}
	
	public boolean HTTPResponse(String url) throws Exception
	{
		HttpURLConnection huc = null;
		
		int respCode = 200;
		
        huc = (HttpURLConnection)(new URL(url).openConnection());
        
        huc.setRequestMethod("HEAD");
    
        huc.connect();
    
        respCode = huc.getResponseCode();
    
        if(respCode <= 400)
    	{
        	return true;
    	}
        else
    	{
        	return false;
    	}
	}
	
	public void ImageTest(String page) throws Exception
	{
		
		String domain = "https://www.metallica.com";
		
		boolean flag;
				
		element_obj.driver.get(page);
		
		List<WebElement> image = element_obj.driver.findElements(By.xpath("//img[@src]"));
		
		System.out.println(image.size());// check count
		
		String url = "";
		
		Iterator<WebElement> it = image.iterator();
        
        while(it.hasNext())
        {
            
            url = it.next().getAttribute("src");
            
            if(!url.startsWith(domain))
            {
                
                System.out.println("Invalid - "+url);
                continue;
            }
		
            flag = HTTPResponse(url);
            
            if(flag)
            {
            	System.out.println(url+" is Valid");
            }
            else
            {
            	System.out.println("Breaking "+url);
            }
       }
        
	}
	
	public void LinkTest(String page) throws Exception
	{
		
		boolean flag;
		
		element_obj.driver.get(page);
		
		List<WebElement> link = element_obj.driver.findElements(By.xpath("//a[@href]"));
		
//		for(int i = 0; i < link.size(); i++)
//		{
//			System.out.println(link.get(i).getAttribute("href"));
//		}
		
		System.out.println(link.size());
		
		String url = "";
		
		Iterator<WebElement> it = link.iterator();
        
        while(it.hasNext())
        {
            
            url = it.next().getAttribute("href");
           
            if(url == null || url.isEmpty())
            {
            	System.out.println(it.next().getText().toString());
            	
            	System.out.println("Either not configured for anchor tag or it is empty"+url);
                continue;
            }
            
            flag = HTTPResponse(url);
            
            if(flag)
            {
            	System.out.println(url+" is Valid");
            }
            else
            {
            	System.out.println("Invalid "+url);
            }
		
       }
        
	}
	
	public void ButtonTest(String page)
	{
		List<WebElement> button = element_obj.driver.findElements(By.xpath("//button"));
		
		 for(int i = 0; i < button.size(); i++)
		 {
			 if(button.get(i).isDisplayed())
			 {
				 System.out.println(button.get(i).getAttribute("title")+" is Displayed");
				 
				 if(button.get(i).isEnabled())
				 {
					 System.out.println(button.get(i).getAttribute("title")+" is Enabled");
				 }
			 }
		 }
		
	}
	
	public void PDPTesting(String site) throws Exception
	{
		String ProductLinks = "//div[@class='product-image']//child::a";
		
		element_obj.driver.get(site+"store/?viewAll=true");
		
		List<WebElement> product = element_obj.driver.findElements(By.xpath(ProductLinks));
		
		System.out.println(product.size());// check count
		
		String url = "";
		
		Iterator<WebElement> it = product.iterator();
        
        for(int i = 0; i < product.size(); i++)
        {
        		
        	url = product.get(i).getAttribute("href");
          
        	ImageTest(url); 
          
        	System.out.println("Validated Images in PDP of -"+url);
        	
        	LinkTest(url);
            
        	System.out.println("Validated Links in PDP of -"+url);
        	
        	element_obj.driver.get(product.get(i+1).getAttribute("href"));
          
        }
        	
//		String Image_path = "//div[@class='product-image main-image' or @class='product-thumbnails ' or @class='product-image recommendation_image']//child::img";
	}
	
	public void HomepageTesting(String site) throws Exception
	{
		LinkTest(site);
		
		System.out.println("Validated Links in HomePage of -"+site);
		
		ImageTest(site);
		
		System.out.println("Validated Images in HomePage of -"+site);
		
	}
	
	public void CartpageTesting() throws Exception
	{
		if(element_obj.Error_form.isDisplayed())
		{
			System.out.println(element_obj.Error_form.getText());
			
			writeExcelComment(element_obj.Error_form.getText());
		}
		
	}
	
	public void CHKT_Billing() throws InterruptedException, Exception
	{
		DataFormatter formatter = new DataFormatter();

		File file = new File(data_obj.filePath+"\\"+data_obj.fileName);

		FileInputStream istream = new FileInputStream(file);

		Workbook book = fileSetup(istream,data_obj.fileName);

		Sheet sheet = book.getSheet(data_obj.sheetName);

		login();
 
		for (data_obj.orderCount = 1; data_obj.orderCount < data_obj.totalOrder; data_obj.orderCount++) {

			Row row = sheet.getRow(data_obj.orderCount);

			element_obj.itemlist = formatter.formatCellValue(row.getCell(1)).split(",");

			element_obj.qty = formatter.formatCellValue(row.getCell(2)).split(",");
			
			element_obj.variant = formatter.formatCellValue(row.getCell(3)).split(",");

			element_obj.Address1 = formatter.formatCellValue(row.getCell(4));

			element_obj.City = formatter.formatCellValue(row.getCell(5));

			element_obj.Zip_Code = formatter.formatCellValue(row.getCell(6)); 
			
			element_obj.State = formatter.formatCellValue(row.getCell(7)); 

			element_obj.Shipping_Method = formatter.formatCellValue(row.getCell(8));

			element_obj.Payment_Method = formatter.formatCellValue(row.getCell(9));

			System.out.println("Variable data_obj are Collected");

			data_obj.flag = selectItems();
			
			if(data_obj.flag==false)
			{
				continue;
			}

			data_obj.flag = shipping("Domestic") ;
			
			if(data_obj.flag==false)
			{
				continue;
			}

			payment() ;
			
			
			element_obj.POviewcart.click();
			
			for(int c = 1; c <= element_obj.itemlist.length; c++)
			{
				
				data_obj.driver.findElement(By.xpath("(//tr[@class='cart-row']//following-sibling::button[@value='Remove'])[2]")).click();
			}
			
			
//			
//			List<WebElement> remove = data_obj.driver.findElements(By.xpath("//tr[@class='cart-row']//following-sibling::button[@value='Remove']"));
//			
//			for(int c = 0; c < remove.size(); c++)
//			{
//				if(c%2==0)
//				{
//					remove.get(c).click();
//				}
//			}
		}
			
	}
	
	public void Validate_Store() throws InterruptedException
	{
		String ProductLinks = "//div[@class='product-image']//child::a";
		
		List<WebElement> product = element_obj.driver.findElements(By.xpath(ProductLinks));
		
		System.out.println(product.size());// check count
		
		String url;
		
		String Ename;
		
		String Aname;
		
		for(int i = 1; i <= product.size(); i++)
		{
			url = element_obj.driver.findElement(By.xpath("(//a[@class='name-link'])["+i+"]")).getAttribute("href");
			
			Ename = element_obj.driver.findElement(By.xpath("(//a[@class='name-link'])["+i+"]")).getText();
			
			System.out.println(Ename);
			
			element_obj.driver.get(url);
			 	
        	Aname = element_obj.driver.findElement(By.xpath("//h1[@class='product-name']")).getText();
        	        	
        	if(Ename.contains(Aname))
        	{
        		System.out.println(Ename+" PDP reached successfully");
        	}
        	else
        	{
        		System.out.println(Ename+" PDP not reached successfully");
        		continue;
        	}
        	
        	util.Click(element_obj.store);
        	
		}
        
	}
	
	public void Add_product(String[] prod, String[] qty) throws InterruptedException
	{
		for(int i = 0; i < prod.length; i++)
		{
			util.WaitAndClick(element_obj.srch);
			
			util.Click(element_obj.SearchBar);
			
			util.Sendkeys(element_obj.srchIP,prod[i].toString());

			element_obj.srchTxt.submit();
			
//			if(util.Isdisplayed(element_obj.driver.findElement(By.xpath("//p[@class='not-available-msg']"))))
//			{
//				System.out.println(prod[i]+" is Out of Stock");
//				System.exit(1);
//			}
			
//			if(qty[i] != "0")
//			{
//				util.Clear(element_obj.PDP_quantity);
//				
//				util.AcceptAlertifPresent(data_obj.driver);
//						
//				util.Clear(element_obj.PDP_quantity);
//						
//				util.AcceptAlertifPresent(data_obj.driver);
//						
//				util.Sendkeys(element_obj.PDP_quantity,qty[i]);
//				
//			}
			
			if(util.Isdisplayed(element_obj.preorder))
			{
				util.Click(element_obj.preorder);
				
				util.Click(element_obj.preorder_ack);
				
				util.Click(element_obj.preorder_ATC);
				
			}
			
			else
			{
				util.Click(element_obj.addcart);
			}
			
		}
		
		util.Click(element_obj.miniviewcart);

//				util.WaitAndClick(element_obj.checkout);
		
	}
	
	
	public void GuestOrderCheck(String Ordernumber,String Zipcode, String Email) throws InterruptedException
	{
		
		util.Sendkeys(element_obj.GuestOrderNumber, Ordernumber);
		
		util.Sendkeys(element_obj.GuestEmail, Email);
		
		util.Sendkeys(element_obj.GuestZipcode, Zipcode);
		
		util.Click(element_obj.GuestSubmit);		
	}
	
	public void Add_product(String prod) throws InterruptedException
	{
			util.Click(element_obj.srch);
			
			util.Click(element_obj.SearchBar);
			
			util.Sendkeys(element_obj.srchIP,prod);

			element_obj.srchTxt.submit();
			
			util.Click(element_obj.addcart);
			
			util.Click(element_obj.miniviewcart);
			
	}
	
	public void MiniCart(String prod) throws InterruptedException
	{
			util.Click(element_obj.srch);
			
			util.Sendkeys(element_obj.srchIP,prod);

			element_obj.srchTxt.submit();
			
			util.Click(element_obj.addcart);
			
	}
			
	
	
	public void Add_Preorder(String prod) throws InterruptedException
	{
			util.Click(element_obj.srch);
			
			util.Click(element_obj.SearchBar);
			
			util.Sendkeys(element_obj.srchIP,prod);

			element_obj.srchTxt.submit();
			
			util.Click(element_obj.preorder);
			
			util.Click(element_obj.preorder_ack);
			
			util.Click(element_obj.preorder_ATC);
			
			util.Click(element_obj.miniviewcart);
			
	}
	
	public void PreorderPopupScroll(String prod) throws InterruptedException
	{
		
		util.Click(element_obj.srch);
		
		util.Sendkeys(element_obj.srchIP,prod);

		element_obj.srchTxt.submit();
		
		util.Click(element_obj.preorder);
		
	}
	
	
	public void write_Smoketest(boolean result, int number) throws Exception
	{
		
		File file = new File(Smoke_test.Data_smoke.filePath+"\\"+Smoke_test.Data_smoke.fileName);

		FileInputStream istream = new FileInputStream(file);

		Workbook book = fileSetup(istream,Smoke_test.Data_smoke.fileName);

		Sheet sheet = book.getSheet(Smoke_test.Data_smoke.sheetName);
 
		Row row = sheet.getRow(number);
		
		String value ;
		
		if(result)
		{
			value = "PASS";
		}
		else
		{
			value = "FAIL";
		}
		
		switch(Smoke_test.Data_smoke.URL)
		{
			case "https://storefront:Frantic98@development.rockdevelop.com/":
				
				Cell DEVresult_cell = row.createCell(4);
				
				DEVresult_cell.setCellType(DEVresult_cell.CELL_TYPE_STRING);

				DEVresult_cell.setCellValue(value);
				
				istream.close(); 
		 	    
				FileOutputStream DEV_outputstream = new FileOutputStream(Smoke_test.Data_smoke.filePath+"\\"+Smoke_test.Data_smoke.fileName);
					
				book.write(DEV_outputstream);
				    
				DEV_outputstream.close();
				
				break;
				
			case "https://storefront:Frantic81@staging.rockdevelop.com/":
				
				Cell STGresult_cell = row.createCell(5);
				
				STGresult_cell.setCellType(STGresult_cell.CELL_TYPE_STRING);

				STGresult_cell.setCellValue(value);
				
				istream.close(); 
		 	    
				FileOutputStream STG_outputstream = new FileOutputStream(Smoke_test.Data_smoke.filePath+"\\"+Smoke_test.Data_smoke.fileName);
					
				book.write(STG_outputstream);
				    
				STG_outputstream.close();
				
				break;
				
			case "https://www.metallica.com/":
				
				Cell PRDresult_cell = row.createCell(6);
				
				PRDresult_cell.setCellType(PRDresult_cell.CELL_TYPE_STRING);

				PRDresult_cell.setCellValue(value);
				
				istream.close(); 
		 	    
				FileOutputStream PRD_outputstream = new FileOutputStream(Smoke_test.Data_smoke.filePath+"\\"+Smoke_test.Data_smoke.fileName);
					
				book.write(PRD_outputstream);
				    
				PRD_outputstream.close();
				
				break;
				
			default:
				System.out.println("\t\t\tInvalid URL - "+Smoke_test.Data_smoke.URL);
				
				break;
		}		
		
	}
	
	public void write_Regressiontest(boolean result, int number) throws Exception
	{
		File file = new File(Regression.Data_Regression.filePath+"\\"+Regression.Data_Regression.Result_fileName);

		FileInputStream istream = new FileInputStream(file);

		Workbook book = fileSetup(istream,Regression.Data_Regression.Result_fileName);

		Sheet sheet = book.getSheet(Regression.Data_Regression.Result_sheetName);
 
		Row row = sheet.getRow(number);
		
		String value ;
		
		if(result)
		{
			value = "PASS";
		}
		else
		{
			value = "FAIL";
		}
				
		Cell result_cell = row.createCell(4);
				
		result_cell.setCellType(result_cell.CELL_TYPE_STRING);

		result_cell.setCellValue(value);
				
		istream.close(); 
		 	    
		FileOutputStream outputstream = new FileOutputStream(Regression.Data_Regression.filePath+"\\"+Regression.Data_Regression.Result_fileName);
					
		book.write(outputstream);
			    
		outputstream.close();
	}
	
	
	public void write_SiteMonitoring(boolean result,int number) throws IOException
	{
		File file = new File(SiteData.filePath+"\\"+SiteData.Result_fileName);

		FileInputStream istream = new FileInputStream(file);

		Workbook book = fileSetup(istream,SiteData.Result_fileName);

		Sheet sheet = book.getSheet(SiteData.Result_sheetName);
 
		Row row = sheet.getRow(number);
		
		String value ;
		
		if(result)
		{
			value = "PASS";
		}
		else
		{
			value = "FAIL";
			
			if(number == 10) 
			{
				Cell result_cell = row.createCell(5);
				
				result_cell.setCellType(result_cell.CELL_TYPE_STRING);

				result_cell.setCellValue("Last Order was placed on: "+SiteData.ApplePay);
			}
			
			if(number == 11)
				{
					Cell result_cell = row.createCell(5);
					
					result_cell.setCellType(result_cell.CELL_TYPE_STRING);

					result_cell.setCellValue("Last Order was placed on: "+SiteData.PayPal);
				}
		}
				
		Cell result_cell = row.createCell(4);
				
		result_cell.setCellType(result_cell.CELL_TYPE_STRING);

		result_cell.setCellValue(value);
				
		istream.close(); 
		 	    
		FileOutputStream outputstream = new FileOutputStream(SiteMonitoring.SiteMonitoringConstantData.filePath+"\\"+SiteMonitoring.SiteMonitoringConstantData.Result_fileName);
					
		book.write(outputstream);
			    
		outputstream.close();
	}
	
	public void ServiceCloud(boolean result,int number) throws IOException, NullPointerException
	{
		File file = new File(SiteData.ServiceCloud_filepath+"\\"+SiteData.ServiceCloud_Result_filename);

		FileInputStream istream = new FileInputStream(file);

		Workbook book = fileSetup(istream,SiteData.ServiceCloud_Result_filename);

		Sheet sheet = book.getSheet(SiteData.ServiceCloud_Result_sheetname);
 
		Row row = sheet.getRow(number);
		
		String value ;
		
		if(result)
		{
			value = "PASS";
		}
		else
		{
			value = "FAIL";
			
			if( number == 33 )
				
			{
				Cell result_cell = row.createCell(5);
				
				result_cell.setCellType(result_cell.CELL_TYPE_STRING);
				
//				result_cell.setCellValue(" Failed Mandatory Fields: "+SiteData.FailedMandatoryField);
				
				if(SiteData.FailedMandatoryField == null)
				{

					result_cell.setCellValue(" Failed Mandatory Fields: "+SiteData.FailedMandatoryField);
					
				
				}
				
				else
				{
					
					SiteData.FailedMandatoryField = SiteData.FailedMandatoryField.substring(0,SiteData.FailedMandatoryField.length() -1);
					
					
					
					result_cell.setCellValue(" Failed Mandatory Fields: "+SiteData.FailedMandatoryField);
				}
					
			}	
			
			
		}
		
				
		Cell result_cell = row.createCell(4);
				
		result_cell.setCellType(result_cell.CELL_TYPE_STRING);

		result_cell.setCellValue(value);
				
		istream.close(); 
		 	    
		FileOutputStream outputstream = new FileOutputStream(SiteData.ServiceCloud_filepath+"\\"+SiteData.ServiceCloud_Result_filename);
					
		book.write(outputstream);
			    
		outputstream.close();
		
	}
			
	
	public void InventoryCheck() throws Exception
	{
		util.Click(element_obj.store);
		
//		util.Click(element_obj.viewAll);
//		
//		Thread.sleep(30000);
		
//		while(!element_obj.pagination.getText().contains(" Showing 1 - 705 of 705 ")) 
//		{
//			
//		}
		
//		util.WaitAndClick(element_);
		
		List<WebElement> products = data_obj.driver.findElements(By.xpath("//a[@class='name-link']"));
		
		for(int i = 0; i < products.size(); i++)
		{
			data_obj.driver.get(products.get(i).getAttribute("href"));
			
			if(util.Isdisplayed(element_obj.AvailabilityW))
			{
				List<WebElement> sizeList = data_obj.driver.findElements(By.xpath("//a[@class='swatchanchor']"));
				
				for(int j = 0; j < sizeList.size(); j++)
				{
					if(sizeList.get(j).getAttribute("title").contentEquals("not available"))
					{
						System.out.println(products.get(i).getAttribute("href"));
						System.out.println(sizeList.get(j).getAttribute("title"));
					}
							
				}
			}
			else if(util.Isdisplayed(element_obj.AvailabilityOOS))
			{
				System.out.println(products.get(i).getAttribute("href"));
				System.out.println(element_obj.AvailabilityOOS.getText());
			}
		}
		
		System.out.println(products.size());
		
	}
	

	
	public void writeInventory()
	{
		
	}
	
	public void ShippingpageTesting()
	{
		
	}
	
	
	public void BillingpageTesting()
	{
		
	}
	
	public void PlaceorderpageTesting()
	{
		
	}
}
