package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class contactInfo {
	
	@FindBy(xpath = "//span[@class=\"dvHeaderText\"]")
	private WebElement text;
	
	public contactInfo(WebDriver driver)
	{  
		PageFactory.initElements(driver, this);
		
	}

	public WebElement getText() {
		return text;
	}
	
	public String captureHeaderText()
	{
	return	text.getText();
	}
	

}
