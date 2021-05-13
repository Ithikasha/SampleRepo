package Testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.itextpdf.text.log.SysoLogger;

import Data_Functions.*;


public class PDP_Testing {
	
	constantData data_obj = new constantData();
	
	driverUtil util = new driverUtil();
	
	pageElements element_obj ;
	
	Functions func_obj ;
	
	@BeforeTest
	
	public void beforeTesting() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\UNITS\\Documents\\BitBucket\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		element_obj = new pageElements(driver);
		
		func_obj = new Functions(data_obj, element_obj);
		
		driver.manage().window().maximize();
		
		driver.get(data_obj.DEV_url);
		
		driver.findElement(By.xpath("//span[text()='No']")).click();
		
//		util.Click(element_obj.no);
		
		func_obj.login();
				
	}
	
	
	@Test(dataProvider="ProductProvider")
	
	public void testcase1(String id) throws InterruptedException {
		
		util.Click(element_obj.srch);
		
		util.Sendkeys(element_obj.srchIP,id);

		element_obj.srchTxt.submit();
		
		System.out.println(element_obj.productTitle.getText().toString());
	}
	
	
	@Test(dataProvider="ProductProvider")
	
	public void testcase2(String id) throws InterruptedException {
		
		util.Click(element_obj.srch);
		
		util.Sendkeys(element_obj.srchIP,id);

		element_obj.srchTxt.submit();
		
		System.out.println(element_obj.productPrice.getText().toString());
	}
	
	
	@Test(dataProvider="ProductProvider")
	
	public void testcase3(String id) throws InterruptedException {
		
		
		util.Click(element_obj.srch);
		
		util.Sendkeys(element_obj.srchIP,id);

		element_obj.srchTxt.submit();
		
		if(element_obj.addcart.isEnabled())
		{
			System.out.println("Add to Cart Enabled");
		}
	}
		
	
	@DataProvider(name="ProductProvider")
    public Object[][] getDataFromDataprovider(){
		return new Object[][] 
    	{
            { "LYRICBOOK3RD" },
            { "T556" },
            { "5460" }
    	};
	}
	
	@AfterTest
	public void afterTesting() {
		
	
	}

}
