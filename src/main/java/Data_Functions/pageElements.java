package Data_Functions;

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

	
	//Homepage
	@FindBy(xpath="(//a[@title='Metallica Home'])[1]")
	public WebElement Metallica;
	
	@FindBy(xpath="//a[@class='user-account not-logged-in']")
	public WebElement login;
	
	@FindBy(xpath="//*[@title='Met Store']")
	public WebElement store;
	
	@FindBy(xpath="//span[text()='No']")
	public WebElement no;
	
	@FindBy(xpath="//button[@class='search-toggle']")
	public WebElement srch;

	@FindBy(xpath="//input[@id='q'][1]")
	public WebElement srchIP;
	
	@FindBy(xpath="//*[@title='View Cart']")
	public WebElement minicart;
	
	//Loginpage
	@FindBy(xpath="//button[@value='Login']")
	public WebElement login_button;
	
	@FindBy(xpath="(//input[contains(@id,'dwfrm_login_username')])[1]")
	public WebElement email;
	
	@FindBy (xpath="//input[contains(@id,'dwfrm_login_password')]")
	public WebElement password;
	
	//PDP
	
	@FindBy(xpath="(//*[@class='product-name'])[1]")
	public WebElement productTitle;
		
	@FindBy(xpath="(//span[@class='price-sales'])[1]")
	public WebElement productPrice;

	@FindBy(xpath="//a[@title='Select Size: Small']")
	public WebElement sizeS;

	@FindBy(xpath="//a[@title='Select Size: Medium']")//input[@name='Quantity']
	public WebElement sizeM;

	@FindBy(xpath="//a[@title='Select Size: Large']")
	public WebElement sizeL;

	@FindBy(xpath="//*[@title='Select Format: MP3']")
	public WebElement Mp3;
		
	@FindBy(xpath="//*[@title='Select Format: FLAC']")
	public WebElement Flac;
		
	@FindBy(xpath="//*[@title='Select Format: ALAC']")
	public WebElement Alac;
		
	@FindBy(xpath="//*[@title='Select Format: FLAC-HD']")
	public WebElement Flac_HD;
		
	@FindBy(xpath="//*[@title='Select Format: ALAC-HD']")
	public WebElement Alac_HD;
	
	@FindBy(xpath="//*[@title='Select Size: 18-24 Mo.']")
	public WebElement Two_year;
	
	@FindBy(xpath="//*[@title='Select Size: 12-18 Mo.']")
	public WebElement Onehalf_year;
	
	@FindBy(xpath="//*[@title='Select Size: 6-12 Mo.']")
	public WebElement One_year;
	
	@FindBy(xpath="//*[@title='Select Size: 3-6 Mo.']")
	public WebElement Half_year;
		
	@FindBy(xpath="//input[@name='Quantity']")
	public WebElement PDP_quantity;
		
	@FindBy(xpath="//*[@id='add-to-cart']")
	public WebElement addcart;
	
	//Cart page
	
	@FindBy(xpath="(//*[@title='Go to Cart'])[1]")
	public WebElement miniviewcart;

	@FindBy(xpath="(//a[@class='mini-cart-close'])[1]")
	public WebElement close;

	@FindBy(xpath="//*[@id='update-cart']")
	public WebElement updatecart;
	
	@FindBy(xpath="//span[text()='Checkout']") 
	public WebElement checkout;
	
	@FindBy(xpath="//div[@class='error-form ']")
	public WebElement CP_errorMessage;
	
	@FindBy(xpath="//input[@id='guest-checkout']")
	public WebElement Guest_CO;
	
	@FindBy(xpath="")
	public WebElement CP_quantity;
	
	@FindBy(xpath="")
	public WebElement CP_price;
	
	@FindBy(xpath="")
	public WebElement CP_priceTotal;
	
	@FindBy(xpath="")
	public WebElement CP_subTotal;
	
	
	//Shipping page
	
	@FindBy(xpath="//input[@name='dwfrm_singleshipping_shippingAddress_addressFields_firstName']")
	public WebElement firstname;

	@FindBy(xpath="//input[@name='dwfrm_singleshipping_shippingAddress_addressFields_lastName']")
	public WebElement lastname;

	@FindBy(xpath="//input[@name='dwfrm_singleshipping_shippingAddress_addressFields_address1']")
	public WebElement address1;

	@FindBy(xpath="//input[@name='dwfrm_singleshipping_shippingAddress_addressFields_address2']")
	public WebElement address2;

	@FindBy(xpath="//input[@name='dwfrm_singleshipping_shippingAddress_addressFields_city']")
	public WebElement city;

	@FindBy(xpath="//input[@name='dwfrm_singleshipping_shippingAddress_addressFields_postal']")
	public WebElement zipcode;

	@FindBy(xpath="//input[@name='dwfrm_singleshipping_shippingAddress_addressFields_phone']")
	public WebElement phone;

	@FindBy(xpath="//select[@name='dwfrm_singleshipping_shippingAddress_addressFields_country']")
	public WebElement country;

	@FindBy(xpath="//select[@name='dwfrm_singleshipping_shippingAddress_addressFields_states_state']")
	public WebElement stateField;

	@FindBy(xpath="//input[@id='dwfrm_singleshipping_shippingAddress_isGift']")
	public WebElement gift;

	@FindBy(xpath="//textarea[@id='dwfrm_singleshipping_shippingAddress_giftMessage']")
	public WebElement giftMsg;
	
	@FindBy(xpath="//input[contains(@id,'useAsBillingAddress')]")
	public WebElement useAsBillingAddress;

	@FindBy(xpath="//label[@for='shipping-method-shqups-GND']")
	public WebElement ground;

	@FindBy(xpath="//label[@for='shipping-method-shqusps-Priority Mail']")
	public WebElement priorityMail;

	@FindBy(xpath="//label[@for='shipping-method-shqups-2DA']")
	public WebElement twodayAir;

	@FindBy(xpath="//label[@for='shipping-method-shqcustom-ups_mail_innovations']")
	public WebElement mailInnovation;

	@FindBy(xpath="//button[@id='shipping-continue']")
	public WebElement continuebill;
	
	@FindBy(xpath="//button[@id='buttonSelectAddressUser']")
	public WebElement userAddress;
	
	//Billingpage

	@FindBy(xpath="//input[contains(@name,'dwfrm_billing_shipInt')]")
	public WebElement policyCheck;

	@FindBy(xpath="//input[@id='dwfrm_billing_paymentMethods_creditCard_owner']")
	public WebElement cardname;

	@FindBy(xpath="//*[@id='dwfrm_billing_paymentMethods_creditCard_type']")
	public WebElement cardtype;

	@FindBy(xpath="//*[@id='dwfrm_billing_paymentMethods_creditCard_number']")
	public WebElement cardnumber;

	@FindBy(xpath="//*[@id='dwfrm_billing_paymentMethods_creditCard_cvn']")
	public WebElement cardcvn;

	@FindBy(xpath="//*[@id='dwfrm_billing_paymentMethods_creditCard_expiration_month']")
	public WebElement cardmonth;

	@FindBy(xpath="//*[@id='dwfrm_billing_paymentMethods_creditCard_expiration_year']")
	public WebElement cardyear;

	@FindBy(xpath="//*[@id='billingSubmitButton']")
	public WebElement continuePlaceorder;

	@FindBy(xpath="(//a[@title='Go to Cart'])[1]")
	public WebElement viewcart;
	
	@FindBy(xpath="//input[@placeholder='Search Metallica.com']")
	public WebElement srchTxt;
	
	//Place order page
	
	@FindBy(xpath="//button[@value='Place Order']")
	public WebElement placeorder;
	
	//Order Confirmation page
	
	@FindBy(xpath="//div[@class='order-information']//following::h3")
	public WebElement orderNumber;
	
	@FindBy(xpath="(//tr[@class='order-subtotal']//following::td)[2]")
	public WebElement Subtotal;
	
	@FindBy(xpath="(//tr[@class='order-shipping']//following::td)[2]")
	public WebElement Shipping_cost;
	
	@FindBy(xpath="(//tr[@class='order-shipping  first ']//following::td)[2]")
	public WebElement Shipping_cost1;
	
	@FindBy(xpath="(//tr[@class='order-shipping  last']//following::td)[2]")
	public WebElement Shipping_cost2;
	
	@FindBy(xpath="(//tr[@class='order-handling']//following::td)[2]")
	public WebElement Handling_cost;
	
	@FindBy(xpath="(//tr[@class='order-sales-tax']//following::td)[2]")
	public WebElement salesTax;
	
	@FindBy(xpath="//td[@class='order-value']")
	public WebElement orderTotal;
	
	String Address1;
	
	String City;
	
	String State; 
	
	String Zip_Code; 
	
	String Shipping_Method;
	
	String Payment_Method;
	
	String[] itemlist;
	
	String[] qty;
	
	String[] variant;

}
