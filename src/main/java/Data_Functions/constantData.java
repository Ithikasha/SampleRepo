package Data_Functions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class constantData {
	
	
	public WebDriver driver ;
	
	public String URL ;
	
	public int orderCount ;
	
	public String Prod_url = "https://www.metallica.com/";
	
	public String DEV_url = "https://ithikasha@unitedtechno.com:Ithi@sfcc07june@development.rockdevelop.com/";
	
	public String STG_url = "https://ithikasha@unitedtechno.com:Ithi@sfcc07feb@staging.rockdevelop.com/";
	
	public String DEV03_url = "https://dev03-na01-metallica.demandware.net/s/Metallica/home/";
	
	public String filePath = "Excelsheets";
	
	public String username = "ithikasha@unitedtechno.com"; //ithikasha@unitedtechno.com , qatest0975@gmail.com
	
	public String DEV_password = "Ithi@met07";  //Ithi@met07 , Qatest@met07
	
	public String STG_password = "Ithi@utis08";
	
	public String fileName = "Metallica.xls";

	public String sheetName = "032422";
	
	public int totalOrder = 30;
	
	public String firstname = "Tester" ;
	
	public String lastname = "Test" ;
	
	public String country = "United States" ;
	
	public String Phone = "9854562145" ;
	
	public String email = "ithikasha@unitedtechno.com" ;
	
	public static String subject = "Testing";
	
	public String Visa_number ="4111111111111111";
	
	public String Visa_date = "08";
	
	public String Visa_month = "12";
	
	public String Visa_year = "2022";
	
	public String Visa_cvv = "737";
	
	public String Amex_number ="378282246310005";
	
	public String Amex_date = "10";
	
	public String Amex_month = "12";
	
	public String Amex_year = "2023";
	
	public String Amex_cvv = "7373";
	
	public String Dis_number ="6011111111111117";
	
	public String Dis_date = "10";
	
	public String Dis_month = "12";
	
	public String Dis_year = "2025";
	
	public String Dis_cvv = "123";
	
	public String Mas_number = "5555555555554444";
	
	public String Mas_date = "08";
	
	public String Mas_month = "10";
	
	public String Mas_year = "2026";
	
	public String Mas_cvv = "123";
	
	public String orderNumber;
	
	public String[] orderList;

	public String handling_cost;

	public String salesTax;

	public String orderTotal;

	public String shippinging_cost;

	public String shippinging_cost1;

	public String shippinging_cost2;
	
	//error writing
	
	public String errorMessage;
	
	public String errorType;

	public boolean flag;
	
	@FindBy(xpath="//button[@class='secondary-button small-link']") //(//div[@class='nav-wrapper']//button)[3]
	public WebElement STG_advanced;
	
	@FindBy(xpath="//a[@id='proceed-link']")
	public WebElement STG_proceed;

	public String subTotal;
	
	public int preorder_flag = 0;
	
}



