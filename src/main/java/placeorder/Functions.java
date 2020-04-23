package placeorder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.function.Function;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import com.itextpdf.text.log.SysoLogger;

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

		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
		
		login();

		for (int i = 1; i < 5; i++) {

			Row row = sheet.getRow(i);

			element_obj.itemlist = formatter.formatCellValue(row.getCell(1)).split(",");

			element_obj.qty = formatter.formatCellValue(row.getCell(2)).split(",");
			
			element_obj.variant = formatter.formatCellValue(row.getCell(3)).split(",");

			element_obj.Address1 = formatter.formatCellValue(row.getCell(4)) ;

			element_obj.City = formatter.formatCellValue(row.getCell(5)) ;

			element_obj.Zip_Code = formatter.formatCellValue(row.getCell(6)) ; 
			
			element_obj.State = formatter.formatCellValue(row.getCell(7)) ; 

			element_obj.Shipping_Method = formatter.formatCellValue(row.getCell(8)) ;

			element_obj.Payment_Method = formatter.formatCellValue(row.getCell(9)) ;

			System.out.println("Variable data_obj are Collected");

			selectItems() ;

			shipping() ;

			payment() ;

			element_obj.placeorder.click();

			System.out.println("Order"+(i));

			element_obj.itemlist = null;

			element_obj.qty = null;
			
			data_obj.orderNumber = element_obj.orderNumber.getText().toString();
			
			System.out.println(data_obj.orderNumber.substring(15));
			
			writeExcel(i, data_obj.orderNumber);
			
			util.snapShots(data_obj.driver,"C:\\Users\\UNITS\\Documents\\Metallica_orders"+i+".png");
		}
		
	}

	

	public void selectItems() throws InterruptedException, Exception {

					
			for(int j = 0; j < element_obj.itemlist.length; j++)
		
			{
				util.Click(element_obj.srch);
			
				util.Sendkeys(element_obj.srchIP,element_obj.itemlist[j]);

				element_obj.srchTxt.submit();
			
				if(element_obj.variant[j]!="0") {
					
					size(element_obj.variant[j]);
				}
			
			
				if(util.Isdisplayed(element_obj.quantity)) 
				{
					
					util.Clear(element_obj.quantity);
					
					util.AcceptAlertifPresent(data_obj.driver);
					
					util.Clear(element_obj.quantity);
					
					util.AcceptAlertifPresent(data_obj.driver);
					
					util.Sendkeys(element_obj.quantity,element_obj.qty[j]);	
					
					util.Click(element_obj.addcart);
				}

				else {

					System.out.println("Quantity is not displayed");
					util.Click(element_obj.addcart);
				}

			
				if(j != (element_obj.itemlist.length-1)) 
				{
					util.Click(element_obj.close);
				}
			
				else if(j == (element_obj.itemlist.length-1))
				{
					util.Click(element_obj.miniviewcart);
				}

				System.out.println("Product "+(j+1)+" is added");
			}

			System.out.println("Cart is ready");
			
			util.Click(element_obj.checkout);

	}
	
	public void cartCheckout() throws InterruptedException {
		
		registeredUserCheckout();
		
		signupCheckout();
		
		guestCheckout();
		
	}
	
	
	
	private void guestCheckout() throws InterruptedException {
		
		util.Sendkeys(element_obj.email, data_obj.username);
		util.Click(element_obj.checkout);
		
	}


	public void registeredUserCheckout() throws InterruptedException {
		
		util.Sendkeys(element_obj.email, data_obj.username);

		util.Sendkeys(element_obj.password, data_obj.password);
		
		util.Click(element_obj.checkout);
		
		
	}
	
	
	public void signupCheckout() {
		
	}

	public void login() throws InterruptedException {
		
		util.Click(element_obj.login);

		util.Sendkeys(element_obj.email, data_obj.username);
	
		util.Sendkeys(element_obj.password, data_obj.password);
	
		util.Click(element_obj.login_button);
		
		System.out.println("User is Logged in");
		
		util.Click(element_obj.Metallica);

	}

	public void shipping() throws InterruptedException
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
//		shipMethod(element_obj.Shipping_Method);

		util.WaitAndClick(element_obj.continuebill);
		
		if(util.Isdisplayed(element_obj.userAddress)) {
			
			util.Click(element_obj.userAddress);
		}

	}

	public void shipMethod(String shipping) throws InterruptedException
	{

		switch(shipping)
		{
		case "Ground" :

			util.Click(element_obj.ground);
			break ;

		case "Priority":

			util.Click(element_obj.priorityMail);
			break ;

		case "Twoday" :

			util.Click(element_obj.twodayAir);
			break ;

		case "Mail" :

			Thread.sleep(3000);
			util.Click(element_obj.mailInnovation);
			break;

		default :

			util.Click(element_obj.ground);
			break;

		}


	}

	public void payment() throws InterruptedException
	{
		switch(element_obj.Payment_Method) 
		{

		case "Visa":

			element_obj.cardname.sendKeys(data_obj.firstname);

			element_obj.cardnumber.sendKeys(data_obj.Visa_number);

			Select card_month = new Select(element_obj.cardmonth);
			card_month.selectByValue(data_obj.Visa_month);

			element_obj.cardyear.sendKeys(data_obj.Visa_year);

			element_obj.cardcvn.sendKeys(data_obj.Visa_cvv);
			
			if(data_obj.Visa_number.isEmpty()) {
				
				util.Sendkeys(element_obj.cardnumber,data_obj.Visa_number);
			}

			//			continueorder.click();

			break;

		case "Amex":

			util.Sendkeys(element_obj.cardname, data_obj.firstname);

			element_obj.cardnumber.sendKeys(data_obj.Amex_number);

			Select AmexCard_month = new Select(element_obj.cardmonth);
			AmexCard_month.selectByValue(data_obj.Amex_month);

			element_obj.cardyear.sendKeys(data_obj.Amex_year);

			element_obj.cardcvn.sendKeys(data_obj.Amex_cvv);

			//			continueorder.click();

			break;

		case "Paypal":

			paypal();

			break;

		default:

			System.out.println("Give a Valid Payment Method");
		}

		element_obj.continueShipping.click();
	}

	public static void paypal() {

	}

	public void size(String variant) throws InterruptedException
	{
		
		
		switch(variant)
		{
			
			case "mp3":
				
				util.Click(element_obj.Mp3);
				break;
				
			case "flac":
				
				util.Click(element_obj.Flac);
				break;
					
			case "flac-hd":
				
				util.Click(element_obj.Flac_HD);
				break;
				
			case "alac":
				
				util.Click(element_obj.Alac);
				break;
				
			case "alac-hd":
				
				util.Click(element_obj.Alac_HD);
				break;
				
			case "small":
				
				util.Click(element_obj.sizeS);
				break;
				
			case "medium":
				
				util.Click(element_obj.sizeM);
				break;
				
			case "large":
				
				util.Click(element_obj.sizeS);
				break;
				
			default:
				
				System.out.println("Invalid format");
				break;
			
		}
				
	}
	
	public void writeExcel(int rowNumber, String orderNumber) throws IOException
	{
		DataFormatter formatter = new DataFormatter();

		File file = new File(data_obj.filePath+"\\"+data_obj.fileName);

		FileInputStream istream = new FileInputStream(file);

		Workbook book = fileSetup(istream,data_obj.fileName);

		Sheet sheet = book.getSheet(data_obj.sheetName);

		Row row = sheet.getRow(rowNumber);
		
		Cell cell = row.createCell(10);
		
		cell.setCellType(cell.CELL_TYPE_STRING);

	    cell.setCellValue(orderNumber.substring(15));
	    
	    istream.close(); 
	    	    
	    FileOutputStream outputstream = new FileOutputStream(data_obj.filePath+"\\"+data_obj.fileName);
		
	    book.write(outputstream);
	    
	    outputstream.close();
	    
	    System.out.println(row.getCell(10));
		

	}
}
