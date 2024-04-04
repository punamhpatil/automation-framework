package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
	    driver.get("http://localhost:8888/");
	    driver.manage().window().maximize();
	    
	   
	   
	   driver.findElement(By.linkText("Contacts")).click();
	   
	   driver.findElement(By.xpath("//a[text()=\"edit\"]")).click();
	   

	}

	
	}


