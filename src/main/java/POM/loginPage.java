package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage { // Rule 1: Create a seperate pom class for every web page
	
    //Rule2 : Identify web element by @findBy annotation
	   @FindBy(name = "user_name")
	  private WebElement usenameedt;
	   
	   @FindBy(name = "user_password")
	   private WebElement passwordedt;
	   
	   @FindBy(id = "submitButton")
	   private WebElement button;
	   
	   //Rule 3 : create a constructor to initialise
	   
	   public loginPage(WebDriver driver)
	   {
		   PageFactory.initElements(driver, this);
	   }
  
	    // Rule 4 : add getter to access
	public WebElement getUsenameedt() {
		return usenameedt;
	}

	public WebElement getPassword() {
		return passwordedt;
	}

	public WebElement getButton() {
		return button;
	}
	   
	   //business library:
	 public void loginToApp(String username,  String password)
	 {
		 usenameedt.sendKeys(username); 
		 passwordedt.sendKeys(password);
		 button.click();
	 }
	   
}
