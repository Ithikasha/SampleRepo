package placeorder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.WebDriver;

import com.itextpdf.text.log.SysoLogger;

public class junk {
	
	public static void main(String args[]) throws IOException
	{
		constantData data_obj = new constantData();
		
		driverUtil util = new driverUtil();
		
		WebDriver driver = util.chrome();
		
		pageElements element_obj = new pageElements(driver);
		
		Functions func = new Functions(data_obj, element_obj);
		
		DataFormatter formatter = new DataFormatter();

		File file = new File(data_obj.filePath+"\\"+data_obj.fileName);

		FileInputStream istream = new FileInputStream(file);

		Workbook book = func.fileSetup(istream,data_obj.fileName);

		Sheet sheet = book.getSheet(data_obj.orderDetailsSheet);

		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum() ;
		
		Row row = sheet.getRow(0);
		
		Row newRow = sheet.createRow(1);
		
		Cell cell = newRow.createCell(10);
		
		cell.setCellType(cell.CELL_TYPE_STRING);

	    cell.setCellValue("Order number");
	    
	    istream.close(); 
	    	    
	    FileOutputStream outputstream = new FileOutputStream(data_obj.filePath+"\\"+data_obj.fileName);
		
	    book.write(outputstream);
	    
	    outputstream.close();
	    
	    System.out.println(row.getCell(1));



	}

//	public void selectProduct(String PID, int count) throws InterruptedException, FindFailed
//	{
//		if(count == 0) {
//			srchW.click();
//		}
//		else {
//			srchB.click();
//		}
//		
//		srchTxt.sendKeys(PID);
//		
//		srchTxt.submit();
//		
//		if(addcart.isEnabled()) {
//		
//			addcart.click();
//		}
//		
//		else {
//			
//			sizeM.click();
//			
//			Thread.sleep(2000);
//			
//			addcart.click();
//		}
//			
//		Thread.sleep(2000);
//		
//		close.click();
//		
//	}
	
}
