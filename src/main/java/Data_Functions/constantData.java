package Data_Functions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class constantData {
	
	
	public WebDriver driver ;
	
	public String URL ;
	
	public int orderCount ;
	
	public String DEV_url = "https://storefront:Frantic98@development.rockdevelop.com/" ;
	
	public String STG_url = "https://storefront:Frantic98@staging.rockdevelop.com/" ;
	
	public String filePath = "C:\\Users\\UNITS\\Workspace ithi\\Excel Sheets";
	
	public String username = "ithikasha@unitedtechno.com" ;
	
	public String DEV_password = "Ithi@met07" ;
	
	public String STG_password = "Ithi@utis08" ;
	
	public String fileName = "Metallica.xlsx";

	public String sheetName = "14102020I";
	
	public int totalOrder = 31;
	
	public String firstname = "Tester" ;
	
	public String lastname = "Test" ;
	
	public String country = "United States" ;
	
	public String Phone = "9854562145" ;
	
	public String email = "ithikasha@unitedtechno.com" ;
	
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

}



