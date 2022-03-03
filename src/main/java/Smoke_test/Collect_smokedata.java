package Smoke_test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import Data_Functions.Functions;
import Data_Functions.constantData;
import Data_Functions.driverUtil;
import Data_Functions.pageElements;

public class Collect_smokedata {
	
	public driverUtil util = new driverUtil();
	constantData data_obj;
	pageElements element_obj;
	Functions func ;
	Data_smoke smoke_data = new Data_smoke();
	
	public Collect_smokedata(constantData data,pageElements elem,Functions functions)
	   {
		   data_obj=data;
		   element_obj=elem;
		   func= functions;
	   }
	
	public void collectdata(int testCount) throws Exception
	{
		DataFormatter formatter = new DataFormatter();

		File file = new File(smoke_data.filePath+"\\"+smoke_data.fileName);

		FileInputStream istream = new FileInputStream(file);

		Workbook book = func.fileSetup(istream,smoke_data.fileName);

		Sheet sheet = book.getSheet(smoke_data.Input_sheetName);
			
			Row row = sheet.getRow(testCount);

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

			System.out.println("Variable data_obj are Collected");
	}
}
