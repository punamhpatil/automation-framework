package generic_Utility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import POM.homepage;
import POM.loginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class baseClass {
  public genericUtilityforExcelfile eUtil = new genericUtilityforExcelfile();
  public propertyFileUtility putil = new propertyFileUtility();
  public  seleniumUtility   sutil = new seleniumUtility();
  public WebDriver driver;
  
  public static WebDriver Sdriver;
  
  @BeforeSuite(groups = "SmokeSuite")
  
	public void bsConfig()
	{
	  System.out.println("DB connection successful");
	}
  
 // @Parameters("Browser")
 // @BeforeTest
 
 @BeforeClass(alwaysRun = true)
  
  public void bcConfig(/*String browser*/) throws IOException
  {
	String url = putil.readDataFromPropertFile("url");
	
	  // if(browser.equals("egde"))
	  // {
		  // driver = new EdgeDriver();
	  // }
	  // else if (browser.equals("chrome"))
	  // {
		 WebDriverManager.chromedriver().setup();
		   driver = new ChromeDriver();
	 //  }
	   //else
	  // {
		  // driver = new EdgeDriver();  
	  // }
	
	
	//driver = new ChromeDriver();
			sutil.maximizeWindow(driver);
	        sutil.addimpliciwait(driver);
	        
	        driver.get(url);
	        
	        Sdriver = driver;
	        
	        System.out.println("browser lounch successful");
  }
  
 @BeforeMethod(alwaysRun = true)
 public void bmConfig() throws IOException
 {
	 String username = putil.readDataFromPropertFile("username");
		String password = putil.readDataFromPropertFile("password");
		  loginPage lp = new loginPage(driver);
	      lp.loginToApp(username, password);
	      System.out.println("login to app successful");
	    
 }
 
 @AfterMethod(alwaysRun = true)
 
 public void amConfig() throws InterruptedException
 {
	 homepage hp = new homepage(driver);
	 hp.logoutApp(driver);
	 System.out.println("logout to app successful");
 }
 
 //@AfterTest
@AfterClass(alwaysRun = true)
 
public void acConfig()
{
	driver.quit();
	System.out.println("browser closer successful");
}

@AfterSuite(alwaysRun = true)

public void asConfig()
{
	System.out.println("DB closure successful");
}
 
 
}
