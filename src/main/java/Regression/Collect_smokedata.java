package Regression;

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
	Data_Regression data_regression = new Data_Regression();
	
	public Collect_smokedata(constantData data,pageElements elem,Functions functions)
	   {
		   data_obj=data;
		   element_obj=elem;
		   func= functions;
	   }
	
	public void collectdata(int testCount) throws Exception
	{
		DataFormatter formatter = new DataFormatter();

		File file = new File(data_regression.filePath+"\\"+data_regression.fileName);

		FileInputStream istream = new FileInputStream(file);

		Workbook book = func.fileSetup(istream,data_regression.fileName);

		Sheet sheet = book.getSheet(data_regression.Input_sheetName);
			
			Row row = sheet.getRow(testCount);

			data_regression.qty = formatter.formatCellValue(row.getCell(2)).split(",");
			
			data_regression.variant = formatter.formatCellValue(row.getCell(3)).split(",");

			data_regression.Address1 = formatter.formatCellValue(row.getCell(4));

			data_regression.City = formatter.formatCellValue(row.getCell(5));

			data_regression.Zip_Code = formatter.formatCellValue(row.getCell(6)); 
			
			data_regression.State = formatter.formatCellValue(row.getCell(7)); 

			data_regression.Shipping_Method = formatter.formatCellValue(row.getCell(8));

			data_regression.paymentMethod = formatter.formatCellValue(row.getCell(9));
			
			data_regression.Country = formatter.formatCellValue(row.getCell(10));
			
			data_regression.phone = formatter.formatCellValue(row.getCell(11));

			System.out.println("Variable data_obj are Collected");
	}
}
