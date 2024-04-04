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
import org.testng.annotations.Test;

public class ScenarioForDelete {
@Test
	public void deleteContact() throws IOException, InterruptedException {
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
			   
			   //step4:nevigate to created contact:
			    
			   driver.findElement(By.linkText("Punam")).click();
			   
			   driver.findElement(By.xpath("//input[@name=\"Delete\"]")).click();
			   Thread.sleep(2000);
			   Alert alt = driver.switchTo().alert();
			    alt.accept();
	}

}
