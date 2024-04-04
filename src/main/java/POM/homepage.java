package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_Utility.seleniumUtility;

public class homepage extends seleniumUtility {

	 @FindBy(linkText = "Contacts")
	  private WebElement Contactslink;
	   
	   @FindBy(xpath = "//img[@src=\"themes/softed/images/btnL3Add.gif\"]")
	   private WebElement image;
	   
	   @FindBy(xpath = "//a[@href=\"index.php?module=Users&action=Logout\"]")
	   private WebElement sign;
	   
	   public homepage(WebDriver driver)
	   {
		   PageFactory.initElements(driver, this);
	   }

	public WebElement getContactslink() {
		return Contactslink;
	}

	public WebElement getImage() {
		return image;
	}

	public WebElement getSign() {
		return sign;
	}
	public void clickoncontactlink()
	{
		Contactslink.click();
	}
	
	public void logoutApp(WebDriver driver) throws InterruptedException
	{
		mouseoverAction(driver, image);
	       Thread.sleep(10000);
		sign.click();
	}

	   
}
