package Smoke_test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import Data_Functions.Functions;
import Data_Functions.constantData;
import Data_Functions.driverUtil;
import Data_Functions.pageElements;

public class Smoke_test
{
	public static driverUtil util = new driverUtil();
	

	public static void main(String[] args) throws Exception {
		
		    constantData data = new constantData();
		    
		    data.driver = util.chrome();
		
			data.driver.manage().window().maximize();
		
			pageElements elements = new pageElements(data.driver);
			
			Data_smoke smoke_data = new Data_smoke();
			
			Functions functions = new Functions(data,elements,smoke_data);
			
			Collect_smokedata collect = new Collect_smokedata(data,elements,functions);
			
			Cartpage cp = new Cartpage(data,elements,functions);
			
			Login_smoke lp = new Login_smoke(data,elements,functions);
			
			Shippingpage sp = new Shippingpage(data,elements,functions);
			
			Billingpage bp = new Billingpage(data,elements,functions);
			
			Placeorder_page pop = new Placeorder_page(data,elements,functions);
			
			Orderconfirmation oc = new Orderconfirmation(data,elements,functions);
			
//			File file = new File("C:\\Users\\UNITS\\Desktop\\PRO_output.txt"); //Your file
//			
//			FileOutputStream fos = new FileOutputStream(file);
//			
//			PrintStream ps = new PrintStream(fos);
//			
//			System.setOut(ps);
//			
//			System.setErr(ps);
//			
			System.out.println("\t\t\t\t\t\t\t\t\tSmoke Test Suite");
			
			
			for(smoke_data.testCount = 1; smoke_data.testCount < smoke_data.totalTest; smoke_data.testCount++)
			{
				System.out.println("\n\n\n\t\t\t\t\t\t\t\tTest-"+smoke_data.testCount+" Begins");
				
				DataFormatter formatter = new DataFormatter();

				File file1 = new File(smoke_data.filePath+"\\"+smoke_data.fileName);

				FileInputStream istream = new FileInputStream(file1);

				Workbook book = functions.fileSetup(istream,smoke_data.fileName);

				Sheet sheet = book.getSheet(smoke_data.Input_sheetName);
					
				Row row = sheet.getRow(smoke_data.testCount);

				smoke_data.itemlist = formatter.formatCellValue(row.getCell(1)).split(",");

				smoke_data.qty = formatter.formatCellValue(row.getCell(2)).split(",");
					
				smoke_data.variant = formatter.formatCellValue(row.getCell(3)).split(",");

				smoke_data.Address1 = formatter.formatCellValue(row.getCell(4));

				smoke_data.City = formatter.formatCellValue(row.getCell(5));

				smoke_data.Zip_Code = formatter.formatCellValue(row.getCell(6)); 
					
				smoke_data.State = formatter.formatCellValue(row.getCell(7)); 

				smoke_data.Shipping_Method = formatter.formatCellValue(row.getCell(8));

				smoke_data.paymentMethod = formatter.formatCellValue(row.getCell(9));
				
				smoke_data.Country = formatter.formatCellValue(row.getCell(10));
				
				smoke_data.phone = formatter.formatCellValue(row.getCell(11));
				
				smoke_data.email = formatter.formatCellValue(row.getCell(12));
				
				smoke_data.password = formatter.formatCellValue(row.getCell(13));


				System.out.println("Variable data objects are Collected");
				
				boolean flag = true;

				lp.Login_Loginpage();
					
				lp.Login_Cartpage();
					
//				lp.Check_Orderstatus(smoke_data.Orderstatus_Ordernumber, smoke_data.Orderstatus_email,smoke_data.Orderstatus_zipcode);
					
				cp.cart_test();
				
				cp.guestCheckout();
				
				sp.ValidateFields();
							
				sp.Validate_Shippingtable();
				
				sp.Validate_mandatoryfields();
				
				bp.ValidateFields();
				
				bp.Invalid_creditcard();
				
//				bp.Redeem_GC(smoke_data.GC);
				
				bp.ValidatePayment();
				
				pop.Validate_orderdetails();
				
				pop.Validate_orderTotalsplit();
				
				flag = pop.Validate_editlink();
				
				if(flag)
				{
					oc.Productdetail();					
				}
				
				else
				{
					elements.POviewcart.click();
				}
				
				System.out.println("\n\n\n\t\t\t\t\t\t\t\tTest-"+smoke_data.testCount+" Completed!!!");
				
				util.WaitAndClick(elements.MyAccount);
				
				util.WaitAndClick(elements.Logout);
				
				smoke_data.itemlist = null;
				
				smoke_data.qty = null;
				
				smoke_data.variant = null;

			}
			
						
			data.driver.close();
			
	}
	
}