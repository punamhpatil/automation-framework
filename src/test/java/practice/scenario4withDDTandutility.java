package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import generic_Utility.genericUtilityforExcelfile;
import generic_Utility.propertyFileUtility;
import generic_Utility.seleniumUtility;

public class scenario4withDDTandutility {

	public static void main(String[] args) throws IOException {
		propertyFileUtility putil = new propertyFileUtility();
		genericUtilityforExcelfile eutil = new genericUtilityforExcelfile(); 
		seleniumUtility sutil = new seleniumUtility();
		
		
		String url = putil.readDataFromPropertFile("url");
		String username = putil.readDataFromPropertFile("username");
		String password = putil.readDataFromPropertFile("password");
		
		
		String lastname = eutil.readDatafromExcelFil("Contact", 1, 2, passwor);
		  
		        //step1:launching browser
		
				WebDriver driver = new ChromeDriver();
				sutil.maximizeWindow(driver);
				sutil.addimpliciwait(driver);
			    driver.get(url);
			  
			    
			    //step2:login to application
			    
			   driver.findElement(By.name("user_name")).sendKeys(username);
			   driver.findElement(By.name("user_password")).sendKeys(password);
			   driver.findElement(By.id("submitButton")).click();
			   
			  
			   //step3:nevigate to contact link
			   driver.findElement(By.linkText("Contacts")).click();
			   
			   //step4:nevigate to created contact:
			    
			   //step5:Nevigate to contact you created already:
			   driver.findElement(By.linkText("Spiderman")).click();
      
			    //step6: click on duplicate button:
			   driver.findElement(By.name("Duplicate")).click();
			   
			    // step7: save the duplicate:
			    driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();

	}

}
