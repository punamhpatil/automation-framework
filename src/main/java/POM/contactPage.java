package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class contactPage {
	
	@FindBy(xpath = "//img[@title=\"Create Contact...\"]")
	private WebElement img1;
	
	public contactPage(WebDriver driver)
	   {
		   PageFactory.initElements(driver, this);
	   }

	public WebElement getImg1() {
		return img1;
	}
	
	public void createContactLookupImage()
	{
		img1.click();
	}
	

}
