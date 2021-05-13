import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Data_Functions.*;;

public class Test {
	
	public static driverUtil util = new driverUtil();

	public static void main(String args[]) throws InterruptedException
	{
		
		
		WebDriver driver = util.chrome();
		
		driver.get("https://www.google.com");
		
		driver.findElement(By.xpath("//a[text()='Sign in']")).click();
		
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("ithikasha@unitedtechno.com");
		
		driver.findElement(By.xpath("//div[@class='VfPpkd-RLmnJb']")).click();
		
		Thread.sleep(3000);
		
		WebElement pwd = new WebDriverWait(driver,15).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='password']")));
		
		pwd.sendKeys("ithi@utis07");
		
//		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("ithi@utis07");
		
		driver.findElement(By.xpath("//div[@class='VfPpkd-RLmnJb']")).click();
		
		
//		driver.get("https://www.yahoo.com");
//		
//		driver.manage().window().maximize();
//		
//		driver.findElement(By.xpath("//a[@id='header-mail-button']")).click();
//		
//		driver.findElement(By.xpath("//input[@id='login-username']")).sendKeys("ecemovers");
//		
//		driver.findElement(By.xpath("//input[@id='login-signin']")).click();
//		
//		driver.findElement(By.xpath("//input[@id='login-passwd']")).sendKeys("indhuithikash");
//		
//		driver.findElement(By.xpath("//button[@id='login-signin']")).click();
//		
//		
//		String text = "Images";
//		
//		Actions act = new Actions(driver);
//		
//		act.keyDown(Keys.CONTROL).perform();
//		
//		act.keyDown(Keys.getKeyFromUnicode('f'));
//		
//		act.sendKeys(text);
//		
//		WebElement test = driver.findElement(By.xpath("//a[contains(text(),'"+text+"')]"));
//		
//		String color = test.getCssValue("color");
//
//		String backcolor = test.getCssValue("background-color");
//
//		System.out.println(color);
//
//		System.out.println(backcolor);
//
//		if(!color.equals(backcolor)){
//
//		System.out.println("Text is highlighted!");
//
//		}
//
//		else{
//
//		System.out.println("Text is not highlighted!");
//		}
	}
}
