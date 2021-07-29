package Testcases;

import org.testng.annotations.Test;

import Data_Functions.Functions;
import Data_Functions.constantData;
import Data_Functions.driverUtil;
import Data_Functions.pageElements;
import Smoke_test.Data_smoke;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

public class Login_TNG {
  @Test(dataProvider = "loginpage")
  public void loginPage(String username, String password) throws Exception {
	  
	  driverUtil util = new driverUtil();
	  constantData data_obj = new constantData();
	  data_obj.driver = util.chrome();
	  pageElements element_obj = new pageElements(data_obj.driver);
	  Data_smoke smoke_data = new Data_smoke();
	  Functions func = new Functions(data_obj, element_obj, smoke_data);
	 
	  try
	  {
	  data_obj.driver.get(smoke_data.URL);
		
	  if(util.Isdisplayed(element_obj.no))
	  {
		  util.Click(element_obj.no);
	  }
		
	  func.smoke_login(username, password);
		
	  if(util.Isdisplayed(data_obj.driver.findElement(By.xpath("//h1[@class='overview-header']"))))
	  {
		  System.out.println("\t\t\tLoginpage - Login Successful for "+smoke_data.email);
	  }
		
	  else
	  {
		  System.out.println("\t\t\tLoginpage - Login Unsuccessful for "+smoke_data.password);
	  }

	  util.WaitAndClick(element_obj.MyAccount);
						
	  util.WaitAndClick(element_obj.Logout);
	  
	  data_obj.driver.close();
	  }
	  
	  catch (Exception ex)
	  {
		  ex.printStackTrace();
	  }
  }
  
  @Test(dataProvider = "cartpage")
  public void cartPage(String product, String username, String password) throws Exception {
	  
	  driverUtil util = new driverUtil();
	  constantData data_obj = new constantData();
	  data_obj.driver = util.chrome();
	  pageElements element_obj = new pageElements(data_obj.driver);
	  Data_smoke smoke_data = new Data_smoke();
	  Functions func = new Functions(data_obj, element_obj, smoke_data);
	  
	  try
	  {
	  data_obj.driver.get(smoke_data.URL);
		
	  if(util.Isdisplayed(element_obj.no))
	  {
		  util.Click(element_obj.no);
	  }
		
	  func.Add_product(product);
		
		element_obj.email.clear();
		
		element_obj.email.sendKeys(username);
		
		element_obj.password.clear();
		
		element_obj.password.sendKeys(password);
		
		util.WaitAndClick(element_obj.Cart_CO);
		
		if(util.Isdisplayed(data_obj.driver.findElement(By.xpath("//div[@class='shipping-header']"))))
		{
			System.out.println("\t\t\tCartpage - Login Successful for "+username);
		}
		else
		{
			System.out.println("\t\t\tCartpage - Login Unsuccessful for "+username);
		}
		
		element_obj.POviewcart.click();
		
		data_obj.driver.findElement(By.xpath("(//tr[@class='cart-row']//following-sibling::button[@value='Remove'])[2]")).click();

		util.WaitAndClick(element_obj.MyAccount);
		
		util.WaitAndClick(element_obj.Logout);
		
		data_obj.driver.close();
	  }
	  
	  catch (Exception ex)
	  {
		  ex.printStackTrace();
	  }
	  	  
  }
  @BeforeClass
  public void beforeClass() {
  }
  
  @DataProvider(name = "loginpage")
  
  public static Object[][] loginPage() {
 
        return new Object[][] { { "qatest0975@gmail.com", "Qatest@met07" }, { "ithikasha@unitedtechno.com", "Ithi@met07" }};
 
  }
  
@DataProvider(name = "cartpage")
  
  public static Object[][] cartPage() {
 
        return new Object[][] { { "JT3HW9WR_L","qatest0975@gmail.com", "Qatest@met07" }, { "JT3HW9WR_L","ithikasha@unitedtechno.com", "Ithi@met07" }};
 
  }
  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod() {
  }

  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

}
