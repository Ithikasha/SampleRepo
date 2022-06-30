package Regression;

import org.openqa.selenium.By;

import Data_Functions.Functions;
import Data_Functions.constantData;
import Data_Functions.driverUtil;
import Data_Functions.pageElements;

public class Brd_smoke_Test {

	public driverUtil util = new driverUtil() ;
	constantData data_obj ;
	pageElements element_obj ;
	Functions func ;
	Data_Regression data_regression = new Data_Regression() ;
	
	
	public Brd_smoke_Test(constantData data,pageElements elem,Functions functions) throws Exception
	   {
		   data_obj=data;
		   element_obj=elem;
		   func= functions;		   
	   }
	
	
	public void Service_Cloud() throws Exception {
		
		
		System.out.println("Service Cloud ticket");
		
		System.out.println("\tService Cloud ticket Testing");
		
		System.out.println("\t\tTest - 1");
		
		 data_obj.driver.get(data_regression.URL);
			
			if(util.Isdisplayed(element_obj.no))
			{
				util.Click(element_obj.no);
			}
			
			int fail=0 ;
			
			util.Click(element_obj.HelpLink);
			
			util.Click(element_obj.CreateNewSupportTicket_Button);
			
			util.Sendkeys(element_obj.Ticketemail, data_obj.username);
			
			util.Sendkeys(element_obj.TicketFirstname, data_obj.firstname);
			
			util.Sendkeys(element_obj.TicketLastname, data_obj.lastname);
			
			util.Sendkeys(element_obj.TicketSubject, data_obj.subject);
			
			util.Click(element_obj.TicketReCpatcha);
			
			util.Click(element_obj.TicketSubmit);
			
			Thread.sleep(2000);
			
			if(util.Isdisplayed(element_obj.driver.findElement(By.xpath("//button[@class='button button--cta']"))))
			{
				System.out.println("\t\t\t"+"Service Cloud ticket submitted successfully");
				
				data_regression.result = true;
				
				func.write_Regressiontest(data_regression.result, 1);
			}
			
			else
				
			{
				System.out.println("\t\t\t"+"Service Cloud ticket submission unsuccessful");
				
				data_regression.result = false;
				
				func.write_Regressiontest(data_regression.result, 1);
			}
		
		
		
	}
	
	
	
	
	
}
