package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class scenario1withDDT {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		FileInputStream fisp = new FileInputStream(".\\src\\test\\resources\\commondata.properties");
           Properties p = new Properties();
		         p.load(fisp);
		String url = p.getProperty("url");
		String username = p.getProperty("username");
		String password = p.getProperty("password");
		
		FileInputStream fise = new FileInputStream("D:\\advance automation\\Contact.xlsx");
		Workbook book = WorkbookFactory.create(fise);
		String lastname = book.getSheet("Contact").getRow(1).getCell(2).getStringCellValue();	
		  
		        //step1:launching browser
		
				WebDriver driver = new ChromeDriver();
			    driver.get(url);
			    driver.manage().window().maximize();
			    
			    //step2:login to application
			    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			   driver.findElement(By.name("user_name")).sendKeys(username);
			   driver.findElement(By.name("user_password")).sendKeys(password);
			   driver.findElement(By.id("submitButton")).click();
			   
			  
			   //step3:nevigate to contact link
			   driver.findElement(By.linkText("Contacts")).click();
			   
			   //step4: click on create contact lookup image
			   driver.findElement(By.xpath("//img[@title=\"Create Contact...\"]")).click();
			   
			   //step5:create contact with mandatory fields and save:
			  
			   driver.findElement(By.name("lastname")).sendKeys(lastname);
			   driver.findElement(By.xpath("//input[@class=\"crmButton small save\"]")).click();
			   
			   //step no.6:validate for contact:
			   
			  String ele = driver.findElement(By.xpath("//span[@class=\"dvHeaderText\"]")).getText();
			  System.out.println(ele);
			  if(ele.contains(lastname))
			  {
				  System.out.println("Pass");
			  }
			  else
			  {
				  System.out.println("Fail");
			  }
				       
				//Step no7:Logout the application
			  
		  WebElement ele1 = driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
		           Actions act = new Actions(driver);
		          act.moveToElement(ele1).perform();
		          driver.findElement(By.linkText("Sign Out")).click();
		          
		          //step no 8:close the browser
		          driver.quit();
		         
		        
		 
	}

}
