package Data_Functions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
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
	
	@FindBy(xpath="(//a[@class='user-account not-logged-in header-nav-link'])[1]")
	public WebElement login;
	
	@FindBy(xpath="(//span[text()='Account'])[1]")
	public WebElement MyAccount;
	
	@FindBy(xpath="(//a[@class='user-logout menu-sub-nav-link'])")
	public WebElement Logout;
	
	@FindBy(xpath="(//a[contains(text(),'Logout')])[2]")
	public WebElement MyAccountPageLogout;
	
	@FindBy(xpath="//*[@title='Met Store']")
	public WebElement store;
	
	@FindBy(xpath="//span[text()='No']")
	public WebElement no;
	
	@FindBy(xpath="//button[@class='menu-toggle header-nav-link']")
	public WebElement srch;
	
	@FindBy(xpath="//button[@class='search-toggle']")
	public WebElement SearchBar;

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
	
	@FindBy(xpath="(//div[@class='paginationCount'])[2]")
	public WebElement pagination;
	
	@FindBy(xpath="//div[text()='Select Styles for Availability']")
	public WebElement AvailabilityW;
	
	@FindBy(xpath="//p[@class='not-available-msg']")
	public WebElement AvailabilityOOS;
	
	@FindBy(xpath="//button[@class='menu-toggle header-nav-link']")
	public WebElement MenuIcon_click;
	
	@FindBy(xpath="//nav[@id='navigation']/a[@class='navigation-close']")
	public WebElement MenuClose;
	
	@FindBy(xpath="(//i[@class='close-icon'])[2]")
	public WebElement SearchClose;
	
	@FindBy(xpath="//div[@class='header-right-icons-homepage']/a[@class='fifth-member']")
	public WebElement FifthMemberIcon;
	
	@FindBy(xpath="//a[@class='met-store']")
	public WebElement MetStoreIcon;
	
	@FindBy(xpath="(//div[@class='mini-cart-total'])[1]")
	public WebElement MinicartIcon;
	
	@FindBy(xpath="(//a[contains(text(),'Help')])")
	public WebElement HelpLink;
	
	@FindBy(xpath="(//a[contains(text(),'Returns')])")
	public WebElement ReturnLink;
	
	@FindBy(xpath="//div[@class='footer-bottom']//a[contains(text(),'Credits')]")
	public WebElement CreditsLink;
	
	@FindBy(xpath="//a[contains(text(),'Terms of Use')]")
	public WebElement TermsOfUseLink;
	
	@FindBy(xpath="//a[contains(text(),'Privacy Policy')]")
	public WebElement PrivacyPolicyLink;

	//Metstore
	
	@FindBy(xpath="(//a[@class='view-all'])[1]")
	public WebElement viewAll; 

	@FindBy(xpath="//a[@id='quickviewbutton']")
	public WebElement quickView; 
	
	@FindBy(xpath="//div[@class='col col--xs-12 search-pagination-wrap']//a[@class='page-3']")
	public WebElement page3;
	
	@FindBy(xpath="//div[@class='col col--xs-12 search-pagination-wrap']//a[@class='page-5']")
	public WebElement page5;
	
	@FindBy(xpath="//a[@title='Refine by:2XL']")
	public WebElement XXl;
	
	@FindBy(xpath="//span[contains(text(),'2XL')]//a[@title='Remove']")
	public WebElement XXLRemove;
	
	@FindBy(xpath="//a[@title='Refine by Price: $20 - $49']")
	public WebElement Price20to49;
	
	@FindBy(xpath="//span[contains(text(),'$20 - $49')]//a[@title='Remove']")
	public WebElement Price20to49Remove;
	
	@FindBy(xpath="(//select[@id='grid-sort-header'])[2]")
	public WebElement Sortby;
	
	@FindBy(xpath="(//select[@id='grid-sort-header'])[2]")
	public WebElement Most;
	
	
	
	
	
	
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
	
	@FindBy(xpath="//*[@id='preorder-add-to-cart button button--cta']")
	public WebElement preorderaddcart;
	
	@FindBy(xpath="//button[@value='Pre-order']")
	public WebElement preorder;
	
	@FindBy(xpath="//label[@for='preorder-acknowledgement']")
	public WebElement preorder_ack;
	
	@FindBy(xpath="//*[@value='Add to Cart']")
	public WebElement preorder_ATC;
	
	@FindBy(xpath="//a[@class='user-account not-logged-in']")
	public WebElement PreorderLogin;

	
	//Cart page
	
	@FindBy(xpath="(//*[@title='Checkout'])[1]")
	public WebElement miniviewcart;

	@FindBy(xpath="(//a[@class='mini-cart-close'])[1]")
	public WebElement close;

	@FindBy(xpath="(//h3[@class='cart-sub-header'])[1]")
	public WebElement ClicktoUpdatecart;
	
	@FindBy(xpath="//button[@value='Checkout']") //note 
	public WebElement checkout;
	
	@FindBy(xpath="//button[@value='Login']")
	public WebElement CP_Login;
	
	@FindBy(xpath="//div[@class='error-form ']")
	public WebElement CP_errorMessage;
	
	@FindBy(xpath="//button[@class='add-to-cart button button--cta checkout login cart-button']")
	public WebElement Cart_CO;
	
	@FindBy(xpath="//button[@class='add-to-cart button button--cta checkout guest-checkout cart-button']")
	public WebElement Guest_CO;
	
	@FindBy(xpath="//button[@value='Remove']")
	public WebElement remove;
	
	@FindBy(xpath="//li[@class='cart-row rowgiftcert']//following-sibling::button[@value='Remove']")
	public WebElement GiftRemove;

	@FindBy(xpath="(//div[@class='c-product-quantity']//child::input[@value='2'])")
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
	
	@FindBy(xpath="//div[@class='name']")
	public WebElement Product_Link;
	
	@FindBy(xpath="//h1[@class='product-name']")
	public WebElement Product_name_PDP;
	
	@FindBy(xpath="//span[contains(text(),'Remove')]")
	public List<WebElement> Multipleremove;
	
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

	@FindBy(xpath="//label[@for='dwfrm_singleshipping_shippingAddress_isGift']")
	public WebElement gift;

	@FindBy(xpath="//textarea[@id='dwfrm_singleshipping_shippingAddress_giftMessage']")
	public WebElement giftMsg;
	
	@FindBy(xpath="//input[contains(@id,'useAsBillingAddress')]") ////input[contains(@id,'useAsBillingAddress')]
	public WebElement useAsBillingAddress;

	@FindBy(xpath="//label[@for='shipping-method-shqups4-GND']")
	public WebElement ground;

	@FindBy(xpath="//label[@for='shipping-method-shqusps-Priority Mail']")
	public WebElement priorityMail;

	@FindBy(xpath="//label[@for='shipping-method-shqups-2DA']")
	public WebElement twodayAir;

	@FindBy(xpath="//label[@for='shipping-method-shqcustom-ups_mail_innovations']")
	public WebElement mailInnovation;

	@FindBy(xpath="//button[@class='add-to-cart button button--secondary']")
	public WebElement continuebill;
	
	@FindBy(xpath="//button[@id='buttonSelectAddressUser']")
	public WebElement userAddress;
	
	@FindBy(xpath="//button[@id='buttonSelectAddress0']")
	public WebElement SuggestionAddress;
	
	@FindBy(xpath="//input[contains(@id,'addToAddressBook')]")
	public WebElement saveAddress;
	
	@FindBy(xpath="//div[contains(@class,'shipping-method-container')]")
	public WebElement shippingtable;
	
	@FindBy(xpath="//div[@class='shipping-method-products']//child::span")
	public WebElement shippingtable_products;
	
	@FindBy(xpath="//div[contains(text(),'Ship Later')]")
	public WebElement shiplater_title;
	
	@FindBy(xpath="//div[@class='shipping-method-header vinylclub-shipment-header']")
	public WebElement Vinylship_title;
	
	@FindBy(xpath="//div[@class='shipping-method-header normal-shipment-header']")
	public WebElement shipnow_title;
	
	@FindBy(xpath="(//div[contains(text(),'Ship Later')]//following::label[contains(@for,'shipping-method')])[1]")
	public WebElement shippingmethods_shiplater;
	
	@FindBy(xpath="(//div[contains(text(),'Ship Now')]//following::label[contains(@for,'shipping-method')])[1]")
	public WebElement shippingmethods_shipnow;
	
	@FindBy(xpath="(//div[contains(text(),'Vinyl Club')]//following::label[contains(@for,'shipping-method')])[1]")
	public WebElement shippingmethods_vinyl;
	
	@FindBy(xpath="//p[@class='error preorder-error-msg label-inline']")
	public WebElement Preorder_Acknowledgement_Error;
	
	@FindBy(xpath="//input[@id='preorder-acknowledgement']")
	public WebElement Preorder_Acknowledgement;
	
	@FindBy(xpath="//span[contains(text(),'Back to Cart')]")
	public WebElement SP_BackToCart;
	
	@FindBy(xpath="//div[@class='address']")
	public WebElement Shippingaddress;
	
	
	//Billingpage

	@FindBy(xpath="//input[contains(@name,'dwfrm_billing_shipInt')]")
	public WebElement policyCheck;
	
	@FindBy(xpath="//select[@id='creditCardList']")
	public WebElement cardlist;

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
	
	@FindBy(xpath="//input[contains(@placeholder, \"Search 'Em All\")]")
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
	
	@FindBy(xpath="//dd[@class='order-subtotal-value js-miniCartSubtotals']") 
	public WebElement BP_subtotal;
	
	@FindBy(xpath="//dd[@class='order-value order-total-value js-estimatedTotalUpdated']") 
	public WebElement BP_total;
	
	@FindBy(xpath="//div[@class='order-sales-tax-value js-taxUpdated']") 
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
	
	@FindBy(xpath="//a[@class='section-header-note gtm-edit-cart-link']") 
	public WebElement EditCart;
	
	
	//Place order page
	
	@FindBy(xpath="//button[@value='Place Order']")
	public WebElement placeorder;
	
	@FindBy(xpath="(//span[@class='label label--desktop'])[1]")
	public WebElement POviewcart;
	
	@FindBy(xpath="(//dd[@class='order-subtotal-value js-miniCartSubtotals'])[2]") 
	public WebElement POP_subtotal;
	
	@FindBy(xpath="(//dd[@class='order-value order-total-value js-estimatedTotalUpdated'])[2]") 
	public WebElement POP_total;
	
	@FindBy(xpath="(//dd[@class='order-sales-tax-value js-taxUpdated'])[2]") 
	public WebElement POP_tax;
	
	//Order Confirmation page
	
	@FindBy(xpath="(//div[@class='row orderdetails-content']//following::span)[1]") ////div[@class='order-information']//following::h3
	public WebElement GuestCheckorderNumber;
	
	@FindBy(xpath="//div[@class='order-confirmation-details col']//h1[@class='order-history-h1 account-primary-heading']//span")
	public WebElement orderNumber;
	
	@FindBy(xpath="//div[@class='order-confirmation-details col']//div[@class='order-subtotal-value js-miniCartSubtotals']")
	public WebElement Subtotal;
	
	@FindBy(xpath="//div[@class='order-confirmation-details col']//div[@class='order-shipping-value js-shippingUpdated']")
	public WebElement Shipping_cost;
	
	@FindBy(xpath="(//tr[@class='order-shipping  first ']//following::td)[2]")
	public WebElement Shipping_cost1;
	
	@FindBy(xpath="(//tr[@class='order-shipping  last']//following::td)[2]")
	public WebElement Shipping_cost2;
	
	@FindBy(xpath="(//div[@class='order-handling-value'])[2]")
	public WebElement Handling_cost; 
	
	@FindBy(xpath="//div[@class='order-confirmation-details col']//div[@class='order-sales-tax-value js-taxUpdated']") 
	public WebElement salesTax; 
	
	@FindBy(xpath="//div[@class='order-confirmation-details col']//div[@class='order-value order-total-value js-estimatedTotalUpdated']")
	public WebElement orderTotal; 
	
	@FindBy(xpath="//a[@class='continue button']")
	public WebElement ContinueShopping; 
	
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
	
	// MyAccount page
	
	@FindBy(xpath="(//a[@title='Show or update your personal information'])[1]")
	public WebElement MyAccount_PersonalInfo;
	
	@FindBy(xpath="//a[@class='user-account logged-in header-nav-link']")
	public WebElement Account_button;
	
	@FindBy(xpath="(//span[text()='Order Information']//following::a)[1]")
	public WebElement MyAccount_Order;
	
	@FindBy(xpath="(//a[contains(text(),'My Account')])[2]")
	public WebElement MyAccount_button;
	
	@FindBy(xpath="(//a[@title='Manage your billing and shipping addresses'])[1]")
	public WebElement MyAccount_Address;

	@FindBy(xpath="(//a[@title='Manage credit cards'])[1]")
	public WebElement MyAccount_Payment;

	@FindBy(xpath="(//a[@title='Manage Vinyl Club'])")
	public WebElement MyAccount_Vinylclub;

	@FindBy(xpath="(//a[@title='Manage exclusives presale codes'])[1]")
	public WebElement MyAccount_Presale;

	@FindBy(xpath="(//a[@title='Show your free downloads'])")
	public WebElement MyAccount_Freedownload;
	
	@FindBy(xpath="(//a[@title='Manage your contest entries'])")
	public WebElement MyAccount_Contest;
	
	// Cloudinary
	
	@FindBy(xpath="//title[text()='2022-05may29_Boston-Massachusetts_Jeff-Yeager_001.jpg (742×482)']")
	public WebElement CloudinaryImg;
	
	//DigitalOcean
	
	@FindBy(xpath="(//button[@type='submit'])[2]")
	public WebElement OrderDetail;
	
	@FindBy(xpath="//input[@type='submit']")
	public WebElement DigitalDownload;
	
	//ProdToms
	
	@FindBy(xpath="//input[@id='Email']")
	public WebElement TomsEmail;
	
	@FindBy(xpath="//input[@id='Password']")
	public WebElement TomsPassword;
	
	@FindBy(xpath="//input[@type='submit']")
	public WebElement TomsLogin;
	
	@FindBy(xpath="(//button[@class='btn btn-bold'])[1]")
	public WebElement AddCriterion;
	
	@FindBy(xpath="//input[@placeholder='Select Field']")
	public WebElement Paymentmethod;
	
	@FindBy(xpath="//button[text()='Select Payment Method']")
	public WebElement Selectpaypal;
	
	@FindBy(xpath="//button[@class='btn btn-bold pull-left']")
	public WebElement Search;
	
	@FindBy(xpath="(//td[@class='ng-binding'])[1]")
	public WebElement TOMS_OrderDate;
	
	@FindBy(xpath="//span[@id='recaptcha-anchor']")
	public WebElement reCAPTCHA;

	
//Contact Us form
	
	@FindBy(xpath="//a[@class='button']")
	public WebElement CreateNewSupportTicket_Button;
	
	@FindBy(xpath="//input[@id='email']")
	public WebElement Ticketemail;
	
	@FindBy(xpath="//input[@id='00N3t0000057P6T']")
	public WebElement TicketFirstname;
	
	@FindBy(xpath="//input[@id='00N3t0000057P6Y']")
	public WebElement TicketLastname;
	
	@FindBy(xpath="//input[@id='subject']")
	public WebElement TicketSubject;
	
	@FindBy(xpath="//textarea[@class='input-text required']")
	public WebElement TicketDescription;
	
	@FindBy(xpath="//select[@class='input-select required valid']")
	public WebElement GroupDropdown;
	
	@FindBy(xpath="//option[@value='General Inquiries']")
	public WebElement GeneralInquiries;
	
	@FindBy(xpath="//option[@value='Order & Store Support']")
	public WebElement OrderandStoreSupport;
	
	@FindBy(xpath="//span[contains(text(),'How can we help')]")
	public WebElement HowCanWeHelp;
	
	@FindBy(xpath="//select[@id='Order_Store_Support_Reason__c']")
	public WebElement HowCanWeHelpOptions;
	
	@FindBy(xpath="//option[@value='Order Support']")
	public WebElement OrderSupport;
	
	@FindBy(xpath="//option[@value='Shipping']")
	public WebElement Shipping;
	
	@FindBy(xpath="//option[@value='Return']")
	public WebElement Return;
	
	@FindBy(xpath="//option[@value='Exchange']")
	public WebElement Exchange;
	
	@FindBy(xpath="//option[@value='Vinyl Club']")
	public WebElement VinylClub;
	
	@FindBy(xpath="//option[@value='Other']")
	public WebElement Other;
	
	@FindBy(xpath="(//select[@class='input-select valid'])[1]")
	public WebElement Didyoualreadyplacedyourorder;
	
	@FindBy(xpath="(//input[@id='Order_Number__c'])[2]")
	public WebElement OrderNumberField;
	
	@FindBy(xpath="//span[contains(text(),'Description')]")
	public WebElement DescriptionField;
	
	@FindBy(xpath="//select[@id='ordersupport-shippinganswer']")
	public WebElement Hasyourorderalreadyshipped;
	
	@FindBy(xpath="//input[@id='Tracking_Number__c']")
	public WebElement Trackingnumberfield;
	
	@FindBy(xpath="(//input[@id='Order_Number__c'])[1]")
	public WebElement OrderNumber;
	
	@FindBy(xpath="//select[@id='Reason_for_Returning__c']")
	public WebElement ReasonforReturn;
	
	@FindBy(xpath="(//input[@id='00N3t00000GO6Mo'])[1]")
	public WebElement QtyField;
	
	@FindBy(xpath="//input[@id='00N3t00000GO6Mt']")
	public WebElement Itemfield;
	
	@FindBy(xpath="//input[@id='00N3t00000GO6My']")
	public WebElement Sizefield;
	
	@FindBy(xpath="//a[@class='addReturn-js']")
	public WebElement AddanotherReturnItem;
	
	@FindBy(xpath="//input[@id='00N3t00000GO6Xh']")
	public WebElement AddExtrafield;
	
	@FindBy(xpath="(//input[@id='00N3t00000GO6Xw'])[1]")
	public WebElement Extrafield;
	
	@FindBy(xpath="(//div[@class='form-row remove-rline-js'])[1]")
	public WebElement FirstRemoveExtrafield;
	
	
	@FindBy(xpath="(//div[@class='form-row remove-rline-js'])[2]")
	public WebElement SecondRemoveExtrafield;
	
	@FindBy(xpath="//input[@id='00N3t0000057LgS']")
	public WebElement ReasonforExchange;
	
	@FindBy(xpath="//input[@id='00N3t00000GO6O6']")
	public WebElement ExchangeItems_Qty;
	
	@FindBy(xpath="//input[@id='00N3t00000GO6O1']")
	public WebElement ExchangeItems_Item;
	
	@FindBy(xpath="//input[@id='00N3t00000GO6OB']")
	public WebElement ExchangeItems_Size;
	
	@FindBy(xpath="//a[@class='addExchange-js']")
	public WebElement AddanotherExchangeItem;
	
	@FindBy(xpath="//input[@id='00N3t00000GO6YB']")
	public WebElement AddExtraExchangeField;
	
	@FindBy(xpath="(//div[@class='form-row remove-xline-js'])[1]")
	public WebElement RemoveExtraExchangeField;
	
	@FindBy(xpath="//span[@id='email-error']")
	public WebElement EmailError;
	
	@FindBy(xpath="//span[@id='00N3t0000057P6T-error']")
	public WebElement FirstnameError;
	
	@FindBy(xpath="//span[@id='00N3t0000057P6Y-error']")
	public WebElement LastnameError;
	
	@FindBy(xpath="//span[@id='subject-error']")
	public WebElement SubjectError;
	
	@FindBy(xpath="//span[@id='00N3t0000057LgD-error']")
	public WebElement GroupDropDownError;
	
	@FindBy(xpath="//select[@class='input-select required error']")
	public WebElement SelectGroupwithError;
	
	@FindBy(xpath="//span[@id='Order_Store_Support_Reason__c-error']")
	public WebElement HowCanWeHelpError;
	
	@FindBy(xpath="//span[@id='Order_Number__c-error']")
	public WebElement OrderNumberError;
	
	@FindBy(xpath="//input[@id='Order_Number__c']")
	public WebElement ReturnOrderNumber;
	
	@FindBy(xpath="//span[@id='00N3t00000GO6Mo-error']")
	public WebElement ReturnQtyFieldError;
	
	@FindBy(xpath="//span[@id='00N3t00000GO6Mt-error']")
	public WebElement ReturnItemFieldError;
	
	@FindBy(xpath="//span[@id='00N3t00000GO6O6-error']")
	public WebElement ExchangeItemQtyFieldError;
	
	@FindBy(xpath="//span[@id='00N3t00000GO6O1-error']")
	public WebElement ExchangeItemITEMFieldError;
	
	@FindBy(xpath="//textarea[@class='input-text required valid']")
	public WebElement ClearDescriptionField;
	
	@FindBy(xpath="//span[@id='description-error']")
	public WebElement DescriptionFieldError;
	
	@FindBy(xpath="//textarea[@class='input-text required error']")
	public WebElement InputDescription;
	
	@FindBy(xpath="//input[@id='00N3t00000GO6Mo']")
	public WebElement ValueForReturnQtyField;
	
	@FindBy(xpath="//input[@id='00N3t00000GO6Mt']")
	public WebElement ValueForReturnItemField;
	
	@FindBy(xpath="//input[@id='00N3t00000GO6Xh']")
	public WebElement ValueForExtraReturnQtyField;
	
	@FindBy(xpath="//input[@id='00N3t00000GO6XX']")
	public WebElement ValueForExtraReturnItemField;
	
	@FindBy(xpath="//input[@id='00N3t00000GO6Xw']")
	public WebElement ValueForSecondExtraReturnQtyField;
	
	@FindBy(xpath="//input[@id='00N3t00000GO6Xr']")
	public WebElement ValueForSecondExtraReturnItemField;
	
	@FindBy(xpath="//span[@id='00N3t00000GO6Xh-error']")
	public WebElement ErrorForExtraReturnQtyField;
	
	@FindBy(xpath="//span[@id='00N3t00000GO6XX-error']")
	public WebElement ErrorForExtraReturnItemField;
	
	@FindBy(xpath="//span[@id='00N3t00000GO6Xw-error']")
	public WebElement ErrorForSecondExtraReturnQtyField;
	
	@FindBy(xpath="//span[@id='00N3t00000GO6Xr-error']")
	public WebElement ErrorForSecondExtraReturnItemField;
	
	@FindBy(xpath="//input[@id='00N3t00000GO6O6']")
	public WebElement ValueForQTYfieldinExchangeItemSection;
	
	@FindBy(xpath="//input[@id='00N3t00000GO6O1']")
	public WebElement ValueForITEMfieldinExchangeItemSection;
	
	@FindBy(xpath="//input[@id='00N3t00000GO6YB']")
	public WebElement ValueForQTYfieldinExtraExchangeLineItem;
	
	@FindBy(xpath="//input[@id='00N3t00000GO6Y6']")
	public WebElement ValueForITEMfieldinExtraExchangeLineItem;
	
	@FindBy(xpath="//input[@id='00N3t00000GO6YQ']")
	public WebElement ValueForQTYfieldinSecondExtraExchangeLineItem;
	
	@FindBy(xpath="//input[@id='00N3t00000GO6YL']")
	public WebElement ValueForITEMfieldinSecondExtraExchangeLineItem;
	
	@FindBy(xpath="//span[@id='00N3t00000GO6O6-error']")
	public WebElement ErrorForQTYfieldinExchangeItemSection;
	
	@FindBy(xpath="//span[@id='00N3t00000GO6O1-error']")
	public WebElement ErrorForITEMfieldinExchangeItemSection;
	
	@FindBy(xpath="//span[@id='00N3t00000GO6YB-error']")
	public WebElement ErrorForQTYfieldinExtraExchangeLineItem;
	
	@FindBy(xpath="//span[@id='00N3t00000GO6Y6-error']")
	public WebElement ErrorForITEMfieldinExtraExchangeLineItem;
	
	@FindBy(xpath="//span[@id='00N3t00000GO6YQ-error']")
	public WebElement ErrorForQTYfieldinSecondExtraExchangeLineItem;
	
	@FindBy(xpath="//span[@id='00N3t00000GO6YL-error']")
	public WebElement ErrorForITEMfieldinSecondExtraExchangeLineItem;
	
	@FindBy(xpath="//div[@class='g-recaptcha']")
	public WebElement TicketReCpatcha;
	
	@FindBy(xpath="//input[@class='button button--cta js-contact-submit']")
	public WebElement TicketSubmit;
	
	@FindBy(xpath="//iframe[@src='https://cdn.knightlab.com/libs/timeline3/latest/embed/index.html?source=1lHHq-yOZUoAli9ESa-Cbxwd0Tn9W1MbAW6wxLBKeE2Y&font=Default&lang=en&initial_zoom=7&height=650&start_at_end=true']")
	public WebElement KnightLab;
	
	
//Gmail
	
	@FindBy(xpath="(//input[@class='whsOnd zHQkBf'])[1]")
	public WebElement Emailid;
	
	@FindBy(xpath="(//div[@class='VfPpkd-Jh9lGc'])[2]")
	public WebElement Next;
	
	@FindBy(xpath="(//input[@class='whsOnd zHQkBf'])[1]")
	public WebElement EmailPassword;
	
	@FindBy(xpath="//button[@class='by7 T-I']")
	public WebElement MobileNotificationNo;
	
	@FindBy(xpath="//input[@placeholder='Search in mail']")
	public WebElement SearchinMail;
	
	@FindBy(xpath="//button[@class='gb_mf gb_nf']")
	public WebElement SearchButton;
	
	@FindBy(xpath="(//div[@class='yW'])[1]")
	public WebElement Currentmail;
	
	@FindBy(xpath="//span[@id=':ot']")
	public WebElement CurrentDateandTime;
	
	@FindBy(xpath="(//div[@id='wrapper']//following::div[@class='js-nav-overlay nav-overlay'])")
	public WebElement Overlay;
	
	@FindBy(xpath="//a[@id='quickviewbutton']")
	public WebElement Quickview;
	
	@FindBy(xpath="(//img[@class='js-blazy b-loaded'])[1]")
	public WebElement Product;
	
	@FindBy(xpath="(//a[contains(@title,'Small')])[2]")
	public WebElement SizeSmall;
	
	@FindBy(xpath="(//a[contains(@title,'Select Size: Medium')])")
	public WebElement SizeMedium;
	
	@FindBy(xpath="(//a[contains(@title,'Select Size: Large')])")
	public WebElement SizeLarge;
	
	@FindBy(xpath="(//a[contains(@title,'Select Size: Gildan Large')])")
	public WebElement GildanSizeLarge;
	
	//span[@title='Mon, Jul 11, 2022, 3:04 PM']

	
//Guest Order Check
	
	@FindBy(xpath="//input[@id='dwfrm_ordertrack_orderNumber']")
	public WebElement GuestOrderNumber;
	
	@FindBy(xpath="//input[@id='dwfrm_ordertrack_orderEmail']")
	public WebElement GuestEmail;
	
	@FindBy(xpath="//input[@id='dwfrm_ordertrack_postalCode']")
	public WebElement GuestZipcode;
	
	@FindBy(xpath="//button[@name='dwfrm_ordertrack_findorder']")
	public WebElement GuestSubmit;
	
	
//Gift Certificate
	
	@FindBy(xpath="//a[@class='name-link']")
	public WebElement GiftCertificateProduct;
	
	@FindBy(xpath="//input[@id='dwfrm_giftcert_purchase_from']")
	public WebElement YourNameField;
	
	@FindBy(xpath="//input[@id='dwfrm_giftcert_purchase_recipient']")
	public WebElement FriendNameField;
	
	@FindBy(xpath="//input[@id='dwfrm_giftcert_purchase_recipientEmail']")
	public WebElement FriendEmailField;
	
	@FindBy(xpath="//input[@id='dwfrm_giftcert_purchase_confirmRecipientEmail']")
	public WebElement ConfirmFriendEmail;
	
	@FindBy(xpath="//textarea[@id='dwfrm_giftcert_purchase_message']")
	public WebElement MessageField;
	
	@FindBy(xpath="//input[@id='dwfrm_giftcert_purchase_amount']")
	public WebElement AmountField;
	
	@FindBy(xpath="//*[@id='AddToBasketButton']")
	public WebElement AddToCartCTA;
	
//Hostek(Contests)
	
	@FindBy(xpath="//a[@class='js-expandable-menu  menu-sub-nav-link menu-sub-nav-link--l2' and contains(text(),'Contests')]")
	public WebElement ContestsLink;
	
	@FindBy(xpath="//div[@class='show contest']")
	public List<WebElement> ContestLists;
	
	@FindBy(xpath="//div[@class='show contest']//following::h4")
	public WebElement ContestsName;
	
	@FindBy(xpath="//div[@id='primary']//h1")
	public WebElement ContestPageError;
	
//Amplience(Content)

	@FindBy(xpath="//a[@class='js-expandable-menu  menu-sub-nav-link menu-sub-nav-link--l2' and contains(text(),'Past Dates')]")
	public WebElement PastDatesLink;
	
	@FindBy(xpath="//a[@class='past-show-item']")
	public List<WebElement> PastDateLists;
	
	
//Algolia(Content Search)
	
	@FindBy(xpath="//div[@class='show']")
	public List<WebElement> Pages;
	
	@FindBy(xpath="//div[@class='read-more']")
	public List<WebElement> ReadMore;
	
	@FindBy(xpath="//div[@class='error-page-message']")
	public WebElement ErrorMessage;
		
	@FindBy(xpath="//a[text()='Read More']")
	public List<WebElement> ReadMoreLinks;
	
//Releases
	
	@FindBy(xpath="//a[@class='js-expandable-menu  menu-sub-nav-link menu-sub-nav-link--l2' and contains(text(),'Songs & Lyrics')]")
	public WebElement SongsandLyricsLink;
	
	@FindBy(xpath="//h2[@class='search-title h3']")
	public WebElement SongPageTitle;
	
	@FindBy(xpath="//span[@class='list-view']")
	public WebElement ChangeViewIcon;
	
	@FindBy(xpath="//div[@class='grid-view']")
	public List<WebElement> SongsList;
	
	@FindBy(xpath="//a[@class='h2' and contains(text(),'72 Seasons')]")
	public WebElement SeventyTwoSeasonsName;
	
	@FindBy(xpath="//li[@class='js-song song-72-seasons']//span[@class='grid-view-data-link']")
	public WebElement SeventyTwoSeasonsCount;
	
	@FindBy(xpath="(//div[@class='c-song-detail__info__content']//div[@class='c-song-detail__info__value'])[1]")
	public WebElement CountInSongsDetailPage;
	
	@FindBy(xpath="//a[@class='h2' and contains(text(),'Ain’t My Bitch')]")
	public WebElement AintMyBitchName;
	
	@FindBy(xpath="//li[@class='js-song song-aint-my-bitch']//span[@class='grid-view-data-link']")
	public WebElement AintMyBitchCount;
	
	@FindBy(xpath="//a[@class='h2' and contains(text(),'All Within My Hands')]")
	public WebElement AllWithinMyHandsName;
	
	@FindBy(xpath="//li[@class='js-song song-all-within-my-hands']//span[@class='grid-view-data-link']")
	public WebElement AllWithinMyHandsCount;
	
	@FindBy(xpath="//a[@class='h2' and contains(text(),'Enter Sandman')]")
	public WebElement EnterSandmanName;
	
	@FindBy(xpath="//li[@class='js-song song-enter-sandman']//span[@class='grid-view-data-link']")
	public WebElement EnterSandmanCount;
	
	@FindBy(xpath="//a[@class='h2' and contains(text(),'If Darkness Had a Son')]")
	public WebElement IfDarknessHadASonName;
	
	@FindBy(xpath="//li[@class='js-song song-if-darkness-had-a-son']//span[@class='grid-view-data-link']")
	public WebElement IfDarknessHadASonCount;
	
		
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
