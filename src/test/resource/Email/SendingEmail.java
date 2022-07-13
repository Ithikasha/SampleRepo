package Email;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.commons.mail.SimpleEmail;

import Data_Functions.Functions;
import Data_Functions.constantData;
import Data_Functions.driverUtil;
import Data_Functions.pageElements;
import SiteMonitoring.SiteMonitoringConstantData;
import Smoke_test.Data_smoke;

public class SendingEmail {
	
	public static driverUtil util = new driverUtil();
	
	public static constantData data = new constantData();
	
	public static SiteMonitoringConstantData SiteData = new SiteMonitoringConstantData();
	
	public static SendingEmail email = new SendingEmail();
    
    public static Data_smoke data_smoke = new Data_smoke();
    
    public static pageElements elements ;
	
    public static Functions functions;
    

	public static void main(String[] args) throws EmailException, InterruptedException {
		
//		HandlingGmail();
		
//		EmailwithAttachment();
		
//		SimpleEmail();
		
		HandlingGmail();
	}
	public static void SimpleEmail() throws EmailException {
		
		System.out.println("Started");
		
		Email email = new SimpleEmail();
		
		email.setHostName("smtp.gmail.com");
		
		email.setSmtpPort(587);
		
		email.setAuthenticator(new DefaultAuthenticator("ublisjacobn@unitedtechno.com", "Jacbeu@2024"));
		
		email.setFrom("ublisjacobn@unitedtechno.com");
		
		email.setSubject("TestMail");
		
		email.setSSLOnConnect(true);
		
		email.setMsg("This is a test mail ... :-)");
		
		email.addTo("ublisjacob@gmail.com");
		
		email.send();
		
		System.out.println("Ended");
		
	}

		public static void EmailwithAttachment() throws EmailException {
		
		// Attachment
		
				System.out.println("Started");
				
				EmailAttachment attachment = new EmailAttachment();
				
				attachment.setPath("Excelsheets");
				
				attachment.setDisposition(EmailAttachment.ATTACHMENT);
				
				attachment.setDescription("SiteMonitoring Results");
				
				attachment.setName("SiteMonitoring.xls");
				
				
				//Email message
				
				  MultiPartEmail email = new MultiPartEmail();
				  
				  email.setHostName("smtp.gmail.com");
				  
				  //email.setSmtpPort(587);
				  
				  email.setAuthenticator(new DefaultAuthenticator("ublisjacobn@unitedtechno.com", "Jacbeu@2024"));
				  
				  email.setFrom("ublisjacobn@unitedtechno.com");
				  
				  email.addTo("ublisjacob@gmail.com");
				  
				  email.setSubject("SiteMonitoring Results");
				  
				  email.setMsg("Attachment");

				  // add the attachment
				  email.attach(attachment);

				  // send the email
				  email.send();
				
				  System.out.println("Ended");
		
		}	

		
		public static void HandlingGmail() throws InterruptedException {
			
			data.driver = util.chrome();
		    
		    elements = new pageElements(data.driver);
		    
		    functions = new Functions(data,elements);
		
			data.driver.manage().window().maximize();
			
			data.driver.get(data.Gmail);
				
			util.Sendkeys(elements.Emailid, data.Gmailid);
			
			util.jClick(data.driver, elements.Next);
			
			Thread.sleep(2000);
			
			util.Sendkeys(elements.EmailPassword, data.Gmailpassword);
			
			util.jClick(data.driver, elements.Next);
			
//			util.Click(elements.MobileNotificationNo);
			
			Thread.sleep(2000);
			
			util.Sendkeys(elements.SearchinMail,"Reset your password");
			
			util.Click(elements.SearchButton);
			
			Thread.sleep(2000);
			
//			util.jClick(data.driver, elements.Currentmail);
			
			String Currentdateandtime = elements.CurrentDateandTime.getText().toString();
						
//			.toString().substring(0, 10).trim();
			
			System.out.println(Currentdateandtime);
			
			
			
			
		}
		
}
