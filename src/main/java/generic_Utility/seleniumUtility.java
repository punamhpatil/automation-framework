package generic_Utility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * this class consist of generic method releted to selenium Webdriver 
 * @author admin
 */

public class seleniumUtility {
	/**
	 * This method is used to maximize the window
	 * @param driver
	 */
	
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	/**
	 * This method is used to minimize the window
	 * @param driver
	 */
	
	public void minimizeWindow(WebDriver driver)
	{
		driver.manage().window().minimize();;
	}
	
	/**
	 * This method add implicit wait for 10 second
	 * @param driver
	 */
	
	public void addimpliciwait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
    
	/**
	 * this method add explicit wait for 10 second
	 * @param driver
	 * @param ele
	 */
	
     public void addexplicitwait(WebDriver driver,WebElement ele)
     {
    	 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
    	      wait.until(ExpectedConditions.visibilityOf(ele));
     }
     
     /** This method is used to handle dropdown by using index
      * 
      * @param driver
      * @param ele
      * @param index
      */
     public void handleDropdown(WebElement ele, int index)
     {
    	 Select select = new Select(ele); 
    	  select.selectByIndex(index);
     }
     
     /**
      * This method is used to handle dropdown by using vlaue
      * @param ele
      * @param value
      */
     public void handleDropdown(WebElement ele,String value)
     {
    	 Select select = new Select(ele); 
    	  select.selectByValue(value);
     }
     
     /**
      * This method is used to handle dropdown by using visibletext
      * @param visibletxt
      * @param ele
      */
     public void handleDropdown(String visibletxt,WebElement ele)
     {
    	 Select select = new Select(ele); 
    	  select.selectByVisibleText(visibletxt);
     }
     
     /**
      * This method is used to perform move to element action
      * @param driver
      * @param ele
      */
     
     public void mouseoverAction(WebDriver driver,WebElement ele)
     {
    	 Actions act = new Actions(driver);
	     act.moveToElement(ele).perform();
     }
     
     /**
      * This method is used to perform click action
      * @param driver
      * @param ele
      */
     public void doubleclickAction(WebDriver driver,WebElement ele)
     {
    	 Actions act = new Actions(driver);
    	   act.doubleClick(ele).perform();
    	   
     }
     
     /**
      *  This method is used to perform drag and drop action
      * @param driver
      * @param src
      * @param des
      */
     public void draganddrop(WebDriver driver, WebElement src,WebElement des)
     {
    	 Actions act = new Actions(driver);
    	  act.dragAndDrop(src, des).perform();	  
     }
     
     /**
      * This method is used to perform right click action
      * @param driver
      * @param ele
      */
     public void contextclick(WebDriver driver,WebElement ele)
    		 {
    	             Actions act = new Actions(driver);
    	              act.contextClick(ele).click().perform();
    		 }
     /**
      * This method is scroll until to particular web element 
      * @param driver
      * @param ele
      */
     public void scrolltoWebelement(WebDriver driver,WebElement ele)
     {
    	 Actions act = new Actions(driver);
    	     act.scrollToElement(ele).perform();
     }
     
     /**
      * this method is used to scroll down by 500 units.
      * @param driver
      */
     public void scrollDown(WebDriver driver)
     {
    	 JavascriptExecutor js = (JavascriptExecutor)driver;
    	 js.executeScript("window.scrollBy(0,500)", "");
     }
     
     /**
      * this method is used to scroll down by 500 units
      * @param driver
      */
     public void scrollUp(WebDriver driver)
     {
    	 JavascriptExecutor js = (JavascriptExecutor)driver;
    	 js.executeScript("window.scrollBy(500,0)", "");
     }
     /**
      * This method will handle frame by index
      * @param driver
      * @param index
      */
     
     public void frameHandling(WebDriver driver, int index)
     {
  	   driver.switchTo().frame(index);
		   
     }
     
     /**
      * This method will handle frame by framenameorId
      * @param driver
      * @param framenameorId
      */
     
     public void frameHandling(WebDriver driver, String framenameorId)
     {
  	   driver.switchTo().frame(framenameorId);
		   
     }
   
     
    /**
     * This method will handle frame by frameelement
     * @param driver
     * @param frameele
     */
       public void frameHandling(WebDriver driver,WebElement frameele)
       {
    	   driver.switchTo().frame(frameele);
		   
       }
       /**
        * This method is used to accept alert
        * @param driver
        */
       public void acceptAlert(WebDriver driver) 
       {
    	   driver.switchTo().alert().accept();
       }
      /**
       *  This method is used to cancel the alert
       * @param driver
       */
       public void dismissAlert(WebDriver driver)
       {
    	    driver.switchTo().alert().dismiss();
       }
      /**
       * This method is used to send text to alert
       * @param driver
       * @param name
       */
        public void sendtxtToAlert(WebDriver driver,String name)
        {
        	driver.switchTo().alert().sendKeys(name);
  	     
        }
        /**
         * This method is used get the alert text
         * @param driver
         * @return
         */
        public String getAlertText(WebDriver driver)
        {
        	return driver.switchTo().alert().getText();
        }
        /**
         * This method we used to capture the screenshot and return path to helper.
         * @param driver
         * @param ScreenshotName
         * @return
         * @throws IOException
         */
        public String captureScreenShot(WebDriver driver,String ScreenshotName) throws IOException
        {
        	  TakesScreenshot scr = (TakesScreenshot)driver;
   		   File sc = scr.getScreenshotAs(OutputType.FILE);
   		   File des = new File(".\\ScreenShots\\"+ScreenshotName+".png");
   		    Files.copy(sc, des);
   		    return des.getAbsolutePath();
        }
     } 


