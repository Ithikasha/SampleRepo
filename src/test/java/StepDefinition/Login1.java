package StepDefinition;

// import com.itextpdf.text.log.SysoLogger;

import Data_Functions.Functions;
import Data_Functions.constantData;
import Data_Functions.driverUtil;
import Data_Functions.pageElements;
import SiteMonitoring.SiteMonitoringConstantData;
import Smoke_test.Data_smoke;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login1 {
	
	public static driverUtil util = new driverUtil();
	
	public static constantData data = new constantData();
	
	public static SiteMonitoringConstantData SiteData = new SiteMonitoringConstantData();
    
    public static Data_smoke data_smoke = new Data_smoke();
    
    public static pageElements elements ;
	
    public static Functions functions;
	
	@Given("I am on homepage")
	
	public void i_am_on_homepage() throws InterruptedException {
	   
		data.driver = util.chrome();
	    
	    elements = new pageElements(data.driver);
	    
	    functions = new Functions(data,elements);
	
		data.driver.manage().window().maximize();
		
		data.driver.get(data.DEV_url);
		
		util.Click(elements.no);
		   
		
	}

	@When("I click Login button in homepage")
	public void i_click_login_button_in_homepage() throws InterruptedException {
			
		util.Click(elements.login);
	   
	}

	@Then("I should see login page")
	public void i_should_see_login_page() {
	   
		System.out.println("Login Page successful");
			
	}
	
	@And("I enter valid username and password")
	public void i_enter_valid_username_and_password() throws InterruptedException {
		
		util.Sendkeys(elements.email, data.username);
		
		util.Sendkeys(elements.password, data.DEV_password);
	
		util.Click(elements.login_button);
		
	}
		
	@Then("I should see user able to login with valid credentials")	
	public void i_should_see_user_able_to_login_with_valid_credentials(){
		
		
	System.out.println("User able to login with valid credentials");
	
		
		
	}
	
}
