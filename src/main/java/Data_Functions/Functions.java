package Data_Functions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Functions {
	

	public driverUtil util = new driverUtil();
	constantData data_obj ;
	pageElements element_obj;

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

		//login();

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

			selectItems();

			shipping() ;

			payment() ;
			
			element_obj.placeorder.click();

			System.out.println("Order"+(data_obj.orderCount++));

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
			
			writeExcel(data_obj.orderCount, data_obj.orderNumber, data_obj.handling_cost, data_obj.salesTax, data_obj.orderTotal, data_obj.shippinging_cost);
			
			util.snapShots(data_obj.driver,"C:\\Users\\UNITS\\Documents\\Metallica_orders\\Order"+data_obj.orderCount+".png");
		}
		
   }

	

   public void selectItems() throws InterruptedException, Exception 
   {

					
			for(int j = 0; j < element_obj.itemlist.length; j++)
		
			{
				Thread.sleep(2000);
				
				util.Click(element_obj.srch);
			
				util.Sendkeys(element_obj.srchIP,element_obj.itemlist[j]);

				element_obj.srchTxt.submit();
			
				if(element_obj.variant[j]!="0") {
					
					size(element_obj.variant[j]);
				}
			
			
				if(util.Isdisplayed(element_obj.PDP_quantity)) 
				{
					
					util.Clear(element_obj.PDP_quantity);
					
					util.AcceptAlertifPresent(data_obj.driver);
					
					util.Clear(element_obj.PDP_quantity);
					
					util.AcceptAlertifPresent(data_obj.driver);
					
					util.Sendkeys(element_obj.PDP_quantity,element_obj.qty[j]);	
					
					util.Click(element_obj.addcart);
				}

				else {

					System.out.println("Quantity is not displayed");
					
					util.Click(element_obj.addcart);
				}

				
				util.Click(element_obj.miniviewcart);
				

				System.out.println("Product "+(j+1)+" is added");
				
				try
				{
					if(element_obj.CP_errorMessage.isDisplayed())
					{
						System.out.println("The Required Quantity of product ID"+element_obj.itemlist[j]+" is not available");
						writeExcelComment("excessQuantity");
						System.exit(1);
						data_obj.driver.close();
					}
				}
				catch(NoSuchElementException ex)
				{
					
				}
			}
			
			if(element_obj.Guest_CO.isDisplayed())
			{
				element_obj.email.sendKeys(data_obj.email);
				util.Click(element_obj.Guest_CO);
			}
			
			util.Click(element_obj.checkout);
			
			System.out.println("Cart is ready");

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
		
		util.Click(element_obj.Metallica);

	}

	public void shipping() throws Exception
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

		Select state = new Select(element_obj.stateField);
		state.selectByVisibleText(element_obj.State);

		util.Clear(element_obj.phone);
		
		util.Sendkeys(element_obj.phone,data_obj.Phone);

//		util.Click(element_obj.useAsBillingAddress); //check-box to keep shipping address as billing address
//
		shipMethod(element_obj.Shipping_Method);

		util.WaitAndClick(element_obj.continuebill);
		
		if(util.Isdisplayed(element_obj.userAddress)) {
			
			util.Click(element_obj.userAddress);
		}

	}

	public void shipMethod(String shipping) throws Exception
	{
		
		Thread.sleep(2000);

		try
		{
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

				util.Click(element_obj.ground);
				break;
			}

		}
		catch(NoSuchElementException ex)
		{
			writeExcelComment("noShippingMethod");
		}

	}

	public void payment() throws InterruptedException
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
			
			break;

		case "Amex":

						
			element_obj.cardname.sendKeys(data_obj.firstname);
			
			element_obj.cardnumber.sendKeys(data_obj.Amex_number);

			Select AmexCard_month = new Select(element_obj.cardmonth);
			AmexCard_month.selectByValue(data_obj.Amex_month);

			element_obj.cardyear.sendKeys(data_obj.Amex_year);
			
			element_obj.cardcvn.sendKeys(data_obj.Amex_cvv);

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
	

	public static void paypal() {

	}

	public void size(String variant) throws Exception
	{
		
		
		try
		{
			switch(variant)
			{
			
			case "mp3":
				
				element_obj.Mp3.click();
				break;
				
			case "flac":
				
				element_obj.Flac.click();;
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
				
				element_obj.sizeL.click();
				break;
				
			default:
				
				System.out.println("Invalid format");
				break;
			
			}
		}
		
		catch(NoSuchElementException ex)
		{
			System.out.println("The Product is not available in "+variant+" size");
			data_obj.errorType = "sizeVariant";
			writeExcelComment(data_obj.errorType);
			System.exit(1);
		}
		
			
	}
	
	@SuppressWarnings("static-access")
	public void writeExcel(int rowNumber, String orderNumber, String handling_cost, String salesTax, String orderTotal, String shippinging_cost) throws IOException
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
}
