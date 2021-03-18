import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import Data_Functions.*;;

public class Test {
	
	public static driverUtil util = new driverUtil();

	public static void main(String args[])
	{
		
		
		WebDriver driver = util.chrome();
		
		driver.get("https://www.google.com");
		
		driver.manage().window().maximize();
		
		String text = "Images";
		
		Actions act = new Actions(driver);
		
		act.keyDown(Keys.CONTROL).perform();
		
		act.keyDown(Keys.getKeyFromUnicode('f'));
		
		act.sendKeys(text);
		
		WebElement test = driver.findElement(By.xpath("//a[contains(text(),'"+text+"')]"));
		
		String color = test.getCssValue("color");

		String backcolor = test.getCssValue("background-color");

		System.out.println(color);

		System.out.println(backcolor);

		if(!color.equals(backcolor)){

		System.out.println("Text is highlighted!");

		}

		else{

		System.out.println("Text is not highlighted!");
		}
	}
}
