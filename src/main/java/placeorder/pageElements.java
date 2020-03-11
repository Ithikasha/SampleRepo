package placeorder;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class pageElements {

	public WebDriver driver;
	public driverUtil util = new driverUtil();



	public pageElements(WebDriver driver)
	{
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}


	@FindBy(xpath="//a[@title='Met Store']")
	WebElement store;

	@FindBy(xpath="//input[@name='Quantity']")
	WebElement quantity;

	@FindBy(xpath="//a[@title='Go to Category: Clearance']")
	WebElement clearance;

	@FindBy(xpath="//span[text()='No']")
	WebElement no;

	@FindBy(xpath="(//span[text()='Close'])[14]")
	WebElement close;

	@FindBy(xpath="//input[contains(@id,'useAsBillingAddress')]")
	WebElement useAsBillingAddress;

	//	@FindBy(xpath="//span[text()='Close']")
	//	WebElement close2;
	//	
	@FindBy(xpath="(//a[@title='Go to page number: 2'])[1]")
	WebElement page2;

	@FindBy(xpath="//div[@data-itemname='S&M² Polo']")
	WebElement tee;

	@FindBy(xpath="//a[@title='Glitch Logo Thermal']")
	WebElement item1;

	//	@FindBy(xpath="//a[@title='Scary Guy And Skelly Toddler / Youth T-Shirt']")
	//	WebElement item3;

	@FindBy(xpath="//a[@title='Tangled Web Woven Patch']")
	WebElement item2;

	//	@FindBy(xpath="//a[@title='Battle Vest Toddler T-Shirt']")
	//	WebElement item5;

	@FindBy(xpath="//a[@title='Hardwired Pint Glass Set']")
	WebElement item3;

	@FindBy(xpath="(//a[contains(@title,'Garage Days Album Cover Men')])[1]")
	WebElement item4;

	//	@FindBy(xpath="(//a[contains(@title,'Blackened Whiskey Women')])[1]")
	//	WebElement item8;

	@FindBy(xpath="//a[@title='James Hetfield Live Trucker Hat']")
	WebElement item5;

	@FindBy(xpath="(//a[contains(@title,'Kill ')])[1]")
	WebElement item6;

	@FindBy(xpath="//a[@title='Ride The Lightning Hat']")
	WebElement item7;

	@FindBy(xpath="//a[@title='Master Of Puppets Hat']")
	WebElement item8;

	@FindBy(xpath="//a[@title='...And Justice For All Hat']")
	WebElement item9;

	@FindBy(xpath="//a[@title='ManUNkind T-Shirt']")
	WebElement item10;

	@FindBy(xpath="//a[@title='Guitar String Keychain']")
	WebElement item11;

	@FindBy(xpath="//a[@title='Ride The Lightning Hat']")
	WebElement p2item1;

	@FindBy(xpath="//a[@title='Guitar String Keychain']")
	WebElement p2item2;

	@FindBy(xpath="//a[@title='Master Of Puppets Hat']")
	WebElement p2item3;

	@FindBy(xpath="//a[@title='Skulls Wrapping Paper']")
	WebElement p2item4;

	@FindBy(xpath="//a[@title='...And Justice For All Hat']")
	WebElement p2item5;

	@FindBy(xpath="//a[@title='Beach Ball (48-Inch)']")
	WebElement p2item6;

	@FindBy(xpath="//a[@title='Scary Guy Stencil']")
	WebElement p2item7;

	@FindBy(xpath="(//a[contains(@title,'Kill ')])[1]")
	WebElement p2item8;

	@FindBy(xpath="//button[@id='add-to-cart']")
	WebElement addcart;

	@FindBy(xpath="(//button[@value='dwfrm_cart_updateCart'])[2]")
	WebElement updatecart;

	@FindBy(xpath="//button[@class='add-to-cart button button--cta checkout login']")
	WebElement checkout;


	@FindBy(xpath="(//a[@title='Go to Cart'])[1]")
	WebElement miniviewcart;

	@FindBy(xpath="//a[@title='View Cart']")
	WebElement minicart;

	@FindBy(xpath="//span[text()='Checkout as Guest']") 
	WebElement checkoutG;

	@FindBy(xpath="//button[@value='Place Order']")
	WebElement placeorder;

	@FindBy(xpath="//input[@name='dwfrm_singleshipping_shippingAddress_addressFields_firstName']")
	WebElement firstname;

	@FindBy(xpath="//input[@name='dwfrm_singleshipping_shippingAddress_addressFields_lastName']")
	WebElement lastname;

	@FindBy(xpath="//input[@name='dwfrm_singleshipping_shippingAddress_addressFields_address1']")
	WebElement address1;

	@FindBy(xpath="//input[@name='dwfrm_singleshipping_shippingAddress_addressFields_address2']")
	WebElement address2;

	@FindBy(xpath="//input[@name='dwfrm_singleshipping_shippingAddress_addressFields_city']")
	WebElement city;

	@FindBy(xpath="//input[@name='dwfrm_singleshipping_shippingAddress_addressFields_postal']")
	WebElement zipcode;

	@FindBy(xpath="//input[@name='dwfrm_singleshipping_shippingAddress_addressFields_phone']")
	WebElement phone;

	@FindBy(xpath="//select[@name='dwfrm_singleshipping_shippingAddress_addressFields_country']")
	WebElement country;

	@FindBy(xpath="//select[@name='dwfrm_singleshipping_shippingAddress_addressFields_states_state']")
	WebElement stateField;

	@FindBy(xpath="(//input[@type='checkbox'])[2]")
	WebElement check2;

	@FindBy(xpath="(//input[@type='checkbox'])[3]")
	WebElement check3;

	@FindBy(xpath="//input[@id='dwfrm_singleshipping_shippingAddress_isGift']")
	WebElement gift;

	@FindBy(xpath="//textarea[@id='dwfrm_singleshipping_shippingAddress_giftMessage']")
	WebElement giftMsg;

	@FindBy(xpath="(//input[@type='radio'])[1]")
	WebElement ground;

	@FindBy(xpath="(//input[@type='radio'])[2]")
	WebElement priorityMail;

	@FindBy(xpath="(//input[@type='radio'])[3]")
	WebElement twodayAir;

	@FindBy(xpath="(//input[@type='radio'])[4]")
	WebElement nxtdayAir;

	@FindBy(xpath="//button[@id='shipping-continue']")
	WebElement continuebill;

	@FindBy(xpath="(//input[contains(@id,'dwfrm_login_username')])[1]")
	WebElement email;
	
	@FindBy (xpath="//input[contains(@id,'dwfrm_login_password')]")
	WebElement password;

	@FindBy(xpath="//input[contains(@name,'dwfrm_billing_shipInt')]")
	WebElement policyCheck;

	@FindBy(xpath="//input[@id='dwfrm_billing_paymentMethods_creditCard_owner']")
	WebElement cardname;

	@FindBy(xpath="//*[@id='dwfrm_billing_paymentMethods_creditCard_type']")
	WebElement cardtype;

	@FindBy(xpath="//*[@id='dwfrm_billing_paymentMethods_creditCard_number']")
	WebElement cardnumber;

	@FindBy(xpath="//*[@id='dwfrm_billing_paymentMethods_creditCard_cvn']")
	WebElement cardcvn;

	@FindBy(xpath="//*[@id='dwfrm_billing_paymentMethods_creditCard_expiration_month']")
	WebElement cardmonth;

	@FindBy(xpath="//*[@id='dwfrm_billing_paymentMethods_creditCard_expiration_year']")
	WebElement cardyear;

	@FindBy(xpath="//*[@id='billingSubmitButton']")
	WebElement continueShipping;

	@FindBy(xpath="(//a[@title='Go to Cart'])[1]")
	WebElement viewcart;

	@FindBy(xpath="//a[@title='Go to Clearance']")
	WebElement clearance1;

	@FindBy(xpath="//i[@class='search-white-icon']")
	WebElement srchW;

	@FindBy(xpath="//i[@class='search-icon']")
	WebElement srchB;
	
	@FindBy(xpath="(//i[contains(@class,'search')])[1]")
	WebElement srch;

	@FindBy(xpath="//input[@id='q'][1]")
	WebElement srchIP;

	@FindBy(xpath="//input[@placeholder='Search Metallica.com']")
	WebElement srchTxt;

	@FindBy(xpath="//a[@title='Select Size: Small']")
	WebElement sizeS;

	@FindBy(xpath="//a[@title='Select Size: Medium']")//input[@name='Quantity']
	WebElement sizeM;

	@FindBy(xpath="//a[@title='Select Size: Large']")
	WebElement sizeL;

	@FindBy(xpath="//img[@src='https://development.rockdevelop.com/dw/image/v2/BCPJ_DEV/on/demandware.static/Sites-Metallica-Site/-/default/dw5e3da51a/images/noimagelarge.png?sw=350&sh=350&sm=cut'][1]")
	WebElement vinyl;

	@FindBy(xpath="//input[@id='guest-checkout']")
	WebElement guestCheckout;
	
	@FindBy(xpath="//button[@id='buttonSelectAddressUser']")
	WebElement userAddress;
		
	String Address1;
	
	String City;
	
	String State; 
	
	String Zip_Code; 
	
	String Shipping_Method;
	
	String Payment_Method;
	
	String[] itemlist;
	
	String[] qty;

}
