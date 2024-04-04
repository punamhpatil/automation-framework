package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_Utility.seleniumUtility;

public class createNewContact extends seleniumUtility{
	
	@FindBy(name = "lastname")
	private WebElement nametxt;
	
	@FindBy(xpath = "//select[@name=\\\"leadsource\\\"]")
	private WebElement dropdown;
	
	@FindBy(xpath = "//input[@class=\"crmButton small save\"]")
	private WebElement save;
	
	public createNewContact(WebDriver driver)
	   {
		   PageFactory.initElements(driver, this);
	   }

	public WebElement getNametxt() {
		return nametxt;
	}

	public WebElement getSave() {
		return save;
	}
	
	public void createnewContact(String lastname)
	{
		nametxt.sendKeys(lastname);
		save.click();
	}
	
	public void createnewContact(String lastname, String leadsource)
	{
		nametxt.sendKeys(lastname);
		handleDropdown(dropdown, leadsource);
		save.click();
	}
	

}
