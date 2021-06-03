package Testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
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
		
		data_obj.driver.get(data_obj.DEV_url);
		
		util.Click(element_obj.no);
		
		func_obj.login();
		
	}
	
	@Test
	public void testcase1() {
		
	}
	
	@Test
	public void testcase2() {
		
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
	
	
}
