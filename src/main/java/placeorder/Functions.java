package placeorder;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.function.Function;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
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

		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum() ;

		for (int i = 1; i < rowCount; i++) {

			Row row = sheet.getRow(i);

			element_obj.itemlist = formatter.formatCellValue(row.getCell(1)).split(",");

			element_obj.qty = formatter.formatCellValue(row.getCell(2)).split(",");

			selectItems() ;

			element_obj.Address1 = formatter.formatCellValue(row.getCell(3)) ;

			element_obj.City = formatter.formatCellValue(row.getCell(4)) ;

			element_obj.Zip_Code = formatter.formatCellValue(row.getCell(5)) ; 
			
			element_obj.State = formatter.formatCellValue(row.getCell(6)) ; 

			element_obj.Shipping_Method = formatter.formatCellValue(row.getCell(7)) ;

			element_obj.Payment_Method = formatter.formatCellValue(row.getCell(8)) ;

			System.out.println("Variable data_obj are Collected");

			checkout() ;

			shipping() ;

			payment() ;

			//element_obj.placeorder.click();

			Date date = new Date();

			util.snapShots(data_obj.driver,"C:\\Users\\UNITS\\Documents\\Metallica_orders");

			System.out.println("Order"+(i));

			element_obj.itemlist = null;

			element_obj.qty = null;
		}
	}

	

	public void selectItems() throws InterruptedException, Exception {

					
			for(int j = 0; j < element_obj.itemlist.length; j++)
		
			{
				util.Click(element_obj.srch);
			
				util.Sendkeys(element_obj.srchIP,element_obj.itemlist[j]);

				element_obj.srchTxt.submit();
			
				if(element_obj.sizeM.isEnabled())
				{
					element_obj.sizeM.click();
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
		

	}
	
	public void cartCheckout() throws InterruptedException {
		
		registeredUserCheckout();
		
		signupCheckout();
		
		guestCheckout();
		
	}
	
	
	
	private void guestCheckout() {
		
	}


	public void registeredUserCheckout() throws InterruptedException {
		
		util.Sendkeys(element_obj.email, data_obj.username);

		util.Sendkeys(element_obj.password, data_obj.password);
		
		util.Click(element_obj.checkout);
		
	}
	
	
	public void signupCheckout() {
		
	}

	public void checkout() throws InterruptedException {

		util.Sendkeys(element_obj.email, data_obj.username);

		util.Sendkeys(element_obj.password, data_obj.password);
		
		util.Click(element_obj.checkout);

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
		
		util.Click(element_obj.userAddress);

	}

	public void shipMethod(String shipping) throws InterruptedException
	{

		switch(shipping)
		{
		case "1" :

			util.Click(element_obj.ground);
			break ;

		case "2":

			util.Click(element_obj.priorityMail);
			break ;

		case "3" :

			util.Click(element_obj.twodayAir);
			break ;

		case "4" :

			Thread.sleep(3000);
			util.Click(element_obj.nxtdayAir);
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

			util.Sendkeys(element_obj.cardname,data_obj.firstname);

			util.Sendkeys(element_obj.cardnumber,data_obj.Visa_number);

			Select card_month = new Select(element_obj.cardmonth);
			card_month.selectByValue(data_obj.Visa_month);

			element_obj.cardyear.sendKeys(data_obj.Visa_year);

			element_obj.cardcvn.sendKeys(data_obj.Visa_cvv);

			//			continueorder.click();

			break;

		case "Amex":

			element_obj.cardname.sendKeys(data_obj.firstname);

			element_obj.cardnumber.sendKeys(data_obj.Amex_number);

			element_obj.cardmonth.sendKeys(data_obj.Amex_month);

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

	public void size() throws InterruptedException
	{
		if(element_obj.sizeM.isDisplayed())
		{
			element_obj.sizeM.click();
		}
		else
		{
			System.out.println("No Size");
		}
	}




}
