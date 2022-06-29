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
	
	public String Cloudinary_Url ="https://metallica-res.cloudinary.com/image/upload/w_371,h_241,f_auto,q_auto:best,c_fill,dpr_2.0,e_sharpen:60,g_auto:subject/v1653964160/Photos/Live%20Photos/2022-05may29_Boston-Massachusetts/2022-05may29_Boston-Massachusetts_Jeff-Yeager_001.jpg";
	
	public String Knightlab_Url="https://www.metallica.com/band-timeline.html";
	
	public String Discourse_Url="https://forums.metallica.com/ ";
	
	public String ProdTomsUrl ="https://toms03.tejassoftware.com/Account/Login?ReturnUrl=%2F";
	
	public String ProdTomsusername = "ithikasha@unitedtechno.com";
	
	public String ProdTomspassword = "Ithi@toms03june";
	
	public String STG_url = "https://ithikasha@unitedtechno.com:Ithi@sfcc07feb@staging.rockdevelop.com/";
	
	public String DEV03_url = "https://dev03-na01-metallica.demandware.net/s/Metallica/home/";
	
	public String filePath = "C:\\Users\\UTIS LAPTOP 38\\Desktop";
	
	public String username = "ithikasha@unitedtechno.com"; //ithikasha@unitedtechno.com , qatest0975@gmail.com
	
	public String DEV_password = "Ithi@met07";  //Ithi@met07 , Qatest@met07
	
	public String PRD_password = "Ithi@utis07";
	
	public String fileName = "Metallica.xls";

	public String sheetName = "032422";
	
	public int totalOrder = 30;
	
	public String firstname = "Tester" ;
	
	public String lastname = "Test" ;
	
	public static String Int_Address1 = "";
	
	public static String Int_City = "";
	
	public static String Int_State = ""; 
	
	public static String Int_Zip_Code = "";
	
	public static String Dom_Address1 = "";
	
	public static String Dom_City = "";
	
	public static String Dom_State = ""; 
	
	public static String Dom_Zip_Code = "";
		
	public static String paymentMethod = "Visa";
	
	public static String Int_Country = "United Kingdom"; 
	
	public String Dom_Country = "United States" ;
	
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



