package practice;

import static org.testng.Assert.fail;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import POM.contactInfo;
import POM.contactPage;
import POM.createNewContact;
import POM.homepage;
import POM.loginPage;
import generic_Utility.baseClass;
import generic_Utility.genericUtilityforExcelfile;
import generic_Utility.propertyFileUtility;
import generic_Utility.seleniumUtility;
@Listeners(generic_Utility.listnerImplementation.class)
public class scenario1withDDTandutility extends baseClass {
@Test(groups = "SmokeSuite ")
	public void createContactwithmandatoryfields() throws IOException, InterruptedException {
	
		
		
		
		
		String lastname = eUtil.readDatafromExcelFil("Contact", 1, 2);
		  
			    
			    
			   //step3:nevigate to contact link
			      homepage hp = new homepage(driver);
			      hp.clickoncontactlink();
			
			   
			   //step4: click on create contact lookup image
			      contactPage cp = new contactPage(driver);
			      cp.createContactLookupImage();
			   
			   
			   //step5:create contact with mandatory fields and save:
			  
			       createNewContact crp = new createNewContact(driver);
			    		   crp.createnewContact(lastname);
			    		   
			    		  Assert.fail();
			   
			   //step no.6:validate for contact:
			     contactInfo ci = new contactInfo(driver);
			    	String htext =	ci.captureHeaderText();
	
			    	Assert.assertTrue(htext.contains(lastname));
			    	
			    	
			  System.out.println(htext);
			 
				       
				
		        

	}

@Test

public void sample()
{
	  System.out.println("sample for test");
		 
}

}


