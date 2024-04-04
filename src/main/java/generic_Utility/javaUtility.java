package generic_Utility;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * this class consist methods related to java
 */
public class javaUtility {
	/*
	 * this method will generate system date
	 */
	
	public String getDate()
	{
		Date d = new Date();
		SimpleDateFormat f = new SimpleDateFormat("dd-mm-yyyy hh-mm-ss");
		String date = f.format(d);
		return date;
	}

}
