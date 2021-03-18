package Data_Functions;

import static org.testng.Assert.assertThrows;
import static org.testng.Assert.fail;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

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

import com.itextpdf.text.log.SysoLogger;

import org.openqa.selenium.WebElement;

public class Functions {
	

	public driverUtil util = new driverUtil();
	constantData data_obj;
	pageElements element_obj;
	private String WebElement;

   public Functions(constantData data,pageElements elem)
   {
	   data_obj=data;
	   element_obj=elem;
   }
	
	
   public Workbook fileSetup(FileInputStream istream, String fileName) throws IOException
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
	
	
   public void bulkOrder_testing() throws Exception  
   {

		DataFormatter formatter = new DataFormatter();

		File file = new File(data_obj.filePath+"\\"+data_obj.fileName);

		FileInputStream istream = new FileInputStream(file);

		Workbook book = fileSetup(istream,data_obj.fileName);

		Sheet sheet = book.getSheet(data_obj.sheetName);

		login();
 
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

			data_obj.flag = payment("Domestic") ;
			
			if(data_obj.flag==false)
			{
				continue;
			}
			
			data_obj.flag = placeOrder() ;
			
			if(data_obj.flag==false)
			{
				continue;
			}

			orderConfirmation();
		}
		
   }
   
   public boolean placeOrder()
   {
//	   if(element_obj.Error_form.isDisplayed())
//			
//		{
//			System.out.println(element_obj.Error_form.getText());
//			return false;
//		}
		element_obj.placeorder.click();
		return true;
   }
   
   public void bulkOrder_International() throws Exception
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

			payment("International") ;
		
			element_obj.placeorder.click();
			
			orderConfirmation();

		}
   }

	

public void orderConfirmation() throws Exception {
	
	System.out.println("Order"+(data_obj.orderCount));

	element_obj.itemlist = null;

	element_obj.qty = null;

	data_obj.orderNumber = element_obj.orderNumber.getText().toString();

	System.out.println(data_obj.orderNumber.substring(15));
	
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

	writeOrderDetail(data_obj.orderCount, data_obj.orderNumber, data_obj.handling_cost, data_obj.salesTax, data_obj.orderTotal, data_obj.shippinging_cost);

	util.snapShots(data_obj.driver,"C:\\Users\\UNITS\\Documents\\Metallica_orders\\Order"+data_obj.orderCount+".png");
}


public boolean selectItems() throws InterruptedException, Exception 
{

	for(int j = 0; j < element_obj.itemlist.length; j++)
	{
			
		Thread.sleep(2000);
				
		util.Click(element_obj.srch);
			
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
					
			util.Clear(element_obj.PDP_quantity);
					
			util.AcceptAlertifPresent(data_obj.driver);
					
			util.Clear(element_obj.PDP_quantity);
					
			util.AcceptAlertifPresent(data_obj.driver);
					
			util.Sendkeys(element_obj.PDP_quantity,element_obj.qty[j]);	
					
			util.Click(element_obj.addcart);
		}

		else 
		{

			System.out.println("Quantity is not displayed");
					
			util.Click(element_obj.addcart);
		}

				
			util.Click(element_obj.miniviewcart);
				

			System.out.println("Product "+(j+1)+" is added");
				
	}
	
//	if(element_obj.Error_form.isDisplayed())
//		
//	{
//		System.out.println(element_obj.Error_form.getText());
//		return false;
//	}
				
//			try
//			{
//				if(element_obj.CP_errorMessage.isDisplayed())
//				{
//					System.out.println("The Required Quantity of product ID"+element_obj.itemlist[j]+" is not available");
//					writeExcelComment("excessQuantity");
//					return false;
//				}
//			}
//			catch(NoSuchElementException ex)
//			{
//							
//			}
			
//			try
//			{
//				if(element_obj.Guest_CO.isDisplayed())
//				{
//					element_obj.email.clear();
//					element_obj.email.sendKeys(data_obj.email);
//					util.WaitAndClick(element_obj.Guest_CO);
//				}
//			}
//			catch(NoSuchElementException ex)
//			{
//				
//			}
	
//	Quantity, Non-combinable, 
	util.WaitAndClick(element_obj.checkout);
	
	System.out.println("Cart is ready");
			
	return true;

}
   
	
	public void cartCheckout() throws InterruptedException 
	{
		
		registeredUserCheckout();
		
		//signupCheckout();
		
		guestCheckout();
		
	}
	
	
	
	public void guestCheckout() throws InterruptedException 
	{
		
		util.Sendkeys(element_obj.email, data_obj.username);
		util.Click(element_obj.checkout);
		
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
		
		System.out.println("User is Logged in");
		
//		util.Click(element_obj.Metallica);

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

	public boolean payment(String orderType) throws InterruptedException
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

		case "Paypal":

			paypal();

			break;

		default:

			System.out.println("Give a Valid Payment Method");
			break;
		}
		
		if(orderType.equalsIgnoreCase("Domestic"))
		{
			element_obj.continuePlaceorder.click();
			return true;
		}
		
		else if(orderType.equalsIgnoreCase("International"))
		{
			
			Thread.sleep(3000);
			
//			util.jClick(element_obj.shpInt);
			
			
			element_obj.shpInt.click();
			
			element_obj.continuePlaceorder.click();
			return true;
		}
		
		return true;

	}
	

	public static void paypal() {

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
	public void writeOrderDetail(int rowNumber, String orderNumber, String handling_cost, String salesTax, String orderTotal, String shippinging_cost) throws IOException
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
	    
	    
	    istream.close(); 
	    	    
	    FileOutputStream outputstream = new FileOutputStream(data_obj.filePath+"\\"+data_obj.fileName);
		
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
		
		for(int i = 8; i < 13; i++) {
			
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
			
			util.Click(element_obj.Reg_recaptcha);
			
			util.Click(element_obj.Reg_Apply);
			
			util.Click(element_obj.MyAccount);
			
			util.Click(element_obj.Logout);
			
			System.out.println("Account for "+Email+" is Created");
			
		}

		
	}
}
