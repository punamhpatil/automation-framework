package practice;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class TestCase1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method 
		//step1:launching browser
		WebDriver driver = new ChromeDriver();
		
	    driver.get("http://localhost:8888/");
	    driver.manage().window().maximize();
	    //step2:login to application
	    
	   driver.findElement(By.name("user_name")).sendKeys("admin");
	   driver.findElement(By.name("user_password")).sendKeys("admin");
	   driver.findElement(By.id("submitButton")).click();
	   
	   Thread.sleep(2000);
	   //step3:nevigate to contact link
	   driver.findElement(By.linkText("Contacts")).click();
	   
	   //step4: click on create contact lookup image
	   driver.findElement(By.xpath("//img[@title=\"Create Contact...\"]")).click();
	   
	   //step5:create contact with mandatory fields and save:
	   driver.findElement(By.name("firstname")).sendKeys("Punam");
	   driver.findElement(By.name("lastname")).sendKeys("Patil");
	   driver.findElement(By.xpath("//input[@class=\"crmButton small save\"]")).click();
	   
	   //step no.6:validate for contact:
	   
	  String ele = driver.findElement(By.xpath("//span[@class=\"dvHeaderText\"]")).getText();
	  System.out.println(ele);
	  if(ele.contains("Punam"))
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
