package Data_Functions;

import java.util.ArrayList;
import java.util.List;

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
	
	@FindBy(xpath="//span[text()='Account']")
	public WebElement MyAccount;
	
	@FindBy(xpath="(//a[@title='Go to: Logout'])[2]")
	public WebElement Logout;
	
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
	
	@FindBy(xpath="//div[@id='ext-gen17']")
	public WebElement sitePreview;
	
	@FindBy(xpath="//a[@id='ext-gen43']")
	public WebElement SP_link;
	
	@FindBy(xpath="//input[@id='controlsTime']")
	public WebElement SP_time;
	
	@FindBy(xpath="//input[@id='controlsDate']")
	public WebElement SP_date;
	
	@FindBy(xpath="//input[@id='controlsOk']")
	public WebElement SP_ok;
	
	@FindBy(xpath="//button[@class='menu-toggle']")
	public WebElement menu;
	
	@FindBy(xpath="//a[@href='https://development.rockdevelop.com/tour/past/']")
	public WebElement pastShow;
	
	
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

	@FindBy(xpath="//a[contains(@title,'Small')]")
	public WebElement sizeS;

	@FindBy(xpath="//a[contains(@title,'Medium')]")//input[@name='Quantity']
	public WebElement sizeM;
	
	@FindBy(xpath="//a[contains(@title,'Small')]")
	public WebElement S;
	
	@FindBy(xpath="//a[@title='Select Size: M']")
	public WebElement M;
	
	@FindBy(xpath="//a[contains(@title,'Large')]")
	public WebElement L;

	@FindBy(xpath="//a[contains(@title,'Large')]")
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
	
	@FindBy(xpath="//button[@value='Pre-order']")
	public WebElement preorder;
	
	@FindBy(xpath="//label[@for='preorder-acknowledgement']")
	public WebElement preorder_ack;
	
	@FindBy(xpath="//*[@value='Add to Cart']")
	public WebElement preorder_ATC;

	
	//Cart page
	
	@FindBy(xpath="(//*[@title='Go to Cart'])[1]")
	public WebElement miniviewcart;

	@FindBy(xpath="(//a[@class='mini-cart-close'])[1]")
	public WebElement close;

	@FindBy(xpath="//*[@id='update-cart']")
	public WebElement updatecart;
	
	@FindBy(xpath="//button[@value='Checkout']") //note 
	public WebElement checkout;
	
	@FindBy(xpath="//button[@value='Login']")
	public WebElement CP_Login;
	
	@FindBy(xpath="//div[@class='error-form ']")
	public WebElement CP_errorMessage;
	
	@FindBy(xpath="//button[@class='add-to-cart button button--cta checkout login']")
	public WebElement Cart_CO;
	
	@FindBy(xpath="//button[@class='add-to-cart button button--cta checkout guest-checkout']")
	public WebElement Guest_CO;
	
	@FindBy(xpath="//span[text()='Remove']")
	public WebElement remove;

	@FindBy(xpath="(//td[@class='item-quantity']//child::input[@value='2'])")
	public WebElement CP_quantity;
	
	@FindBy(xpath="(//span[@class='product-quantity-error error'])[1]")
	public WebElement CP_quantityerror;
	
	
	@FindBy(xpath="//div[@class='name']//child::a")
	public WebElement CP_prdName;
	
	@FindBy(xpath="")
	public WebElement CP_price;
	
	@FindBy(xpath="")
	public WebElement CP_priceTotal;
	
	@FindBy(xpath="")
	public WebElement CP_subTotal;
	
	@FindBy(xpath="//label[@for='guest-checkout']")
	public WebElement Guest_chkBox;
	
	
	//Shipping page
	
	@FindBy(xpath="//input[contains(@id,'firstName')]")
	public WebElement firstname;

	@FindBy(xpath="//input[contains(@id,'lastName')]")
	public WebElement lastname;

	@FindBy(xpath="//input[contains(@id,'address1')]")
	public WebElement address1;

	@FindBy(xpath="//input[contains(@id,'address2')]")
	public WebElement address2;

	@FindBy(xpath="//input[contains(@id,'city')]")
	public WebElement city;

	@FindBy(xpath="//input[contains(@id,'postal')]")
	public WebElement zipcode;

	@FindBy(xpath="//input[contains(@id,'phone')]")
	public WebElement phone;
	

	@FindBy(xpath="//select[@name='dwfrm_singleshipping_shippingAddress_addressFields_states_state']")
	public WebElement stateField;
	
	@FindBy(xpath="//select[contains(@id,'castates')]")
	public WebElement CAstateField;
	
	@FindBy(xpath="//input[contains(@id,'otherstates')]")
	public WebElement IstateField;
	
	@FindBy(xpath="//select[contains(@id,'country')]")
	public WebElement countryField;

	@FindBy(xpath="//input[@id='dwfrm_singleshipping_shippingAddress_isGift']")
	public WebElement gift;

	@FindBy(xpath="//textarea[@id='dwfrm_singleshipping_shippingAddress_giftMessage']")
	public WebElement giftMsg;
	
	@FindBy(xpath="//label[contains(@for,'useAsBillingAddress')]") ////input[contains(@id,'useAsBillingAddress')]
	public WebElement useAsBillingAddress;

	@FindBy(xpath="//label[@for='shipping-method-shqups-GND']")
	public WebElement ground;

	@FindBy(xpath="//label[@for='shipping-method-shqusps-Priority Mail']")
	public WebElement priorityMail;

	@FindBy(xpath="//label[@for='shipping-method-shqups-2DA']")
	public WebElement twodayAir;

	@FindBy(xpath="//label[@for='shipping-method-shqcustom-ups_mail_innovations']")
	public WebElement mailInnovation;

	@FindBy(xpath="//button[@class='add-to-cart button button--cta']")
	public WebElement continuebill;
	
	@FindBy(xpath="//button[@id='buttonSelectAddressUser']")
	public WebElement userAddress;
	
	@FindBy(xpath="//input[contains(@id,'addToAddressBook')]")
	public WebElement saveAddress;
	
	@FindBy(xpath="//div[contains(@class,'shipping-method-container')]")
	public WebElement shippingtable;
	
	@FindBy(xpath="//div[@class='shipping-method-products']//child::span")
	public WebElement shippingtable_products;
	
	@FindBy(xpath="//div[contains(text(),'Ship Later')]")
	public WebElement shiplater_title;
	
	@FindBy(xpath="//div[contains(text(),'Ship Later')]//following::label[contains(@for,'shipping-method')]")
	public WebElement shippingmethods_shiplater;
	
	@FindBy(xpath="")
	public WebElement shippingmethods_shipnow;
	
	
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
	
	@FindBy(xpath="//label[contains(@for,'dwfrm_vatdisclaimer_shipInt')]")
	public WebElement shpInt;
	
	@FindBy(xpath="//div[@class='billing-coupon-giftcard-toggle']")
	public WebElement giftcard_coupon_toggle;
	
	@FindBy(xpath="//input[@name='dwfrm_billing_giftCertCode']")
	public WebElement giftcard;
	
	@FindBy(xpath="//button[@id='check-giftcert']")
	public WebElement GC_checkbalance;
	
	@FindBy(xpath="//button[@id='add-giftcert']")
	public WebElement GC_apply;
	
	@FindBy(xpath="//div[@class='success giftcert-pi']")
	public WebElement GC_successmsg;
	
	@FindBy(xpath="//input[@name='dwfrm_cart_couponCode']")
	public WebElement coupon;
	
	@FindBy(xpath="//button[@id='add-coupon']")
	public WebElement Coupon_apply;
	
	@FindBy(xpath="//select[@name='dwfrm_billing_billingAddress_addressFields_states_state']")
	public WebElement Bill_stateField;
	
	@FindBy(xpath="//label[contains(@for,'saveCard')]") 
	public WebElement savecard;
	
	@FindBy(xpath="(//tr[@class='order-subtotal']//child::td)[2]") 
	public WebElement BP_subtotal;
	
	@FindBy(xpath="(//tr[@class='order-total']//child::td)[2]") 
	public WebElement BP_total;
	
	@FindBy(xpath="(//tr[@class='order-sales-tax']//child::td)[2]") 
	public WebElement BP_tax;
	
	@FindBy(xpath="//img[@class='paypal-logo']") 
	public WebElement Paypal_chkbx;
	
	@FindBy(xpath="//div[@class='paypal-button-label-container']") 
	public WebElement Paypal_btn;
	
	@FindBy(xpath="//button[@id='createAccount']") 
	public WebElement Paypal_guestpay;
	
	@FindBy(xpath="//input[@id='cardNumber']") 
	public WebElement Paypal_CC_number;
	
	@FindBy(xpath="//input[@id='cardExpiry']") 
	public WebElement Paypal_CC_date;
	
	@FindBy(xpath="//input[@id='cardCvv']") 
	public WebElement Paypal_CC_CVV;
	
	@FindBy(xpath="//input[@id='email']") 
	public WebElement Paypal_email;
	
	@FindBy(xpath="//input[@id='telephone']") 
	public WebElement Paypal_phone;
	
	@FindBy(xpath="//button[text()='Continue']']") 
	public WebElement Paypal_confirm;
	
	@FindBy(xpath="//button[@track-input='Pay_Now']") 
	public WebElement Paypal_pay;
	
	@FindBy(xpath="//input[@id='firstName']") 
	public WebElement Paypal_firstName;
	
	@FindBy(xpath="//input[@id='lastName']") 
	public WebElement Paypal_lastName;
	
	@FindBy(xpath="//input[@id='billingLine1']") 
	public WebElement Paypal_address;
	
	@FindBy(xpath="//input[@id='billingCity']") 
	public WebElement Paypal_city;
	
	@FindBy(xpath="//select[@id='billingState']") 
	public WebElement Paypal_state;
	
	@FindBy(xpath="//input[@id='billingPostalCode']") 
	public WebElement Paypal_zipcode;
	
	
	//Place order page
	
	@FindBy(xpath="//button[@value='Place Order']")
	public WebElement placeorder;
	
	@FindBy(xpath="(//span[@class='label'])[1]")
	public WebElement POviewcart;
	
	@FindBy(xpath="(//tr[@class='order-subtotal']//child::td)[4]") 
	public WebElement POP_subtotal;
	
	@FindBy(xpath="(//tr[@class='order-total']//child::td)[4]") 
	public WebElement POP_total;
	
	@FindBy(xpath="(//tr[@class='order-sales-tax']//child::td)[4]") 
	public WebElement POP_tax;
	
	//Order Confirmation page
	
	@FindBy(xpath="//div[@class='orderdetails']//following::h3") ////div[@class='order-information']//following::h3
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
	
	
// Registration page
	
	@FindBy(xpath="//button[@value='Create Account']")
	public WebElement CreateAccount;
	
	@FindBy(xpath="//input[@id='dwfrm_profile_customer_firstname']")
	public WebElement Reg_FName;
	
	@FindBy(xpath="//input[@id='dwfrm_profile_customer_lastname']")
	public WebElement Reg_LName;
	
	@FindBy(xpath="//input[@id='dwfrm_profile_customer_username']")
	public WebElement Reg_UName;
	
	@FindBy(xpath="//input[@id='dwfrm_profile_customer_email']")
	public WebElement Reg_Email;
	
	@FindBy(xpath="//input[@id='dwfrm_profile_customer_emailconfirm']")
	public WebElement Reg_CnfEmail;
	
	@FindBy(xpath="//input[contains(@id,'dwfrm_profile_login_password_')]")
	public WebElement Reg_Pwd;
	
	@FindBy(xpath="//input[contains(@id,'dwfrm_profile_login_passwordconfirm')]")
	public WebElement Reg_CnfPwd;
	
	@FindBy(xpath="//input[@id='dwfrm_profile_customer_birthday']")
	public WebElement Reg_DOB;
	
	@FindBy(xpath="//select[@id='dwfrm_profile_customer_gender']")
	public WebElement Reg_Gender;
	
	@FindBy(xpath="//select[@id='dwfrm_profile_customer_country']")
	public WebElement Reg_Country;
	
	@FindBy(xpath="//input[@id='dwfrm_profile_customer_postal']")
	public WebElement Reg_zipcode;
	
	@FindBy(xpath="//label[@for='dwfrm_profile_customer_addtoemaillist']")
	public WebElement Reg_NewsTeller;
	
	@FindBy(xpath="//span[@id='recaptcha-anchor']")
	public WebElement Reg_recaptcha;
	
	@FindBy(xpath="//button[@value='Apply']")
	public WebElement Reg_Apply;
	
	@FindBy(xpath="//div[contains(@class,'error-form')]")
	public WebElement Error_form;
	
	@FindBy(xpath="//div[contains(@class,'shipping-method-container')]")
	public WebElement shipping_Container;
	
	@FindBy(xpath="//div[contains(@class,'error-message')]")
	public WebElement Error_message;
	
	@FindBy(xpath="//span[contains(@class,'error')]")
	public WebElement Error_span;
	
	
	
	String Address1;
	
	String City;
	
	String State; 
	
	String Country; 
	
	String Zip_Code; 
	
	String Shipping_Method;
	
	String Payment_Method;
	
	String couponCode;
	
	public String[] itemlist;
	
	public String[] qty;
	
	String[] variant;
	
	List<String> SMlabel = new ArrayList<>();
	

}
