package Testcases;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Data_Functions.*;
import Smoke_test.Data_smoke;

public class Cart_testing {
	
	constantData data_obj = new constantData();
	
	Data_smoke data_smoke = new Data_smoke();
	
	driverUtil util = new driverUtil();
	
	WebDriver driver = util.chrome();
	
	pageElements element_obj = new pageElements(driver);
	
	Functions func_obj = new Functions(data_obj, element_obj,data_smoke);
	
	@BeforeTest
	public void beforeTesting() throws InterruptedException {
		
		driver.manage().window().maximize();
		
		driver.get("https://storefront:Frantic98@development.rockdevelop.com/");
		
		util.Click(element_obj.no);
		
		
	}
	
	@Test
	public void testcase1() throws InterruptedException {
		
		func_obj.smoke_login("ithikasha@unitedtechno.com", "Ithi@met07");
		assertTrue(driver.findElement(By.xpath("//h1[@class='overview-header']")).isDisplayed());
		func_obj.Logout();		
	}
	
	@Test
	public void testcase2() throws Exception {
		
		func_obj.smoke_login("ithikasha@unitedtechno.com", "Ithi@met7");
		assertTrue(driver.findElement(By.xpath("//div[@class='error-form']")).isDisplayed());
		
	}
	
	@Test
	public void testcase3() {
		
	}
	
	@Test
	public void testcase4() {
		
	}
	
	@Test
	public void testcase5() {
		
	}
	
//	@DataProvider(name="address")
//	public Object[][] testData()
//	{
//		Object[][] obj = new Object[3][3];
//		
//		obj[0][0] ="";
//		obj[0][0] ="";
//		obj[0][0] ="";
//		obj[0][0] ="";
//		obj[0][0] ="";
//		obj[0][0] ="";
//		obj[0][0] ="";
//		obj[0][0] ="";
//	}
	
}
