package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class readDatafromPropertyFile {

	public static void main(String[] args) throws IOException {
		//step 1: Open the document in java readable format
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\commondata.properties");
		
		//step2: Create object of Properties class from java.util
		Properties p = new Properties();
		
		//step3:Load File Input stream to Properties
		p.load(fis);
		
		//step4: get key Fetch the value
		String value = p.getProperty("url");
		System.out.println(value);
		
		String username = p.getProperty("username");
		System.out.println(username);
		
		String password = p.getProperty("password");
		System.out.println(password);
		
		

	}

}
