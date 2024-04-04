package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import generic_Utility.genericUtilityforExcelfile;
import generic_Utility.propertyFileUtility;
import generic_Utility.seleniumUtility;

public class scenario3withDDTandutility {

	public static void main(String[] args) throws IOException, InterruptedException {
		propertyFileUtility putil = new propertyFileUtility();
		genericUtilityforExcelfile eutil = new genericUtilityforExcelfile(); 
		seleniumUtility sutil = new seleniumUtility();
		
		
		String url = putil.readDataFromPropertFile("url");
		String username = putil.readDataFromPropertFile("username");
		String password = putil.readDataFromPropertFile("password");
		
		
		String lastname = eutil.readDatafromExcelFil("Contact", 1, 2, password);
		  
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
			    
			   driver.findElement(By.linkText("Punam")).click();
			   
			   driver.findElement(By.xpath("//input[@name=\"Delete\"]")).click();
			   Thread.sleep(2000);
			   sutil.acceptAlert(driver);
	}

}
