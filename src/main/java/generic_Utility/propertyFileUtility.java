package generic_Utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/** 
 * This class consist of generic method related to property file
 * @author poonam
 * 
 */
public class propertyFileUtility {
	
	/**
	 * this method read the data from property file and return value to the caller method.
	 * @param key
	 * @return
	 * @throws IOException
	 */
	
	public String readDataFromPropertFile(String key) throws IOException 
	{
	
FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\commondata.properties");
		Properties p = new Properties();
		p.load(fis);
			String value = p.getProperty(key);
			return value;
			
	}
	

}
