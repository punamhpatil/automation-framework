package generic_Utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * this class class consist of generic method related to Excel file
 * @author punam
 */

public class genericUtilityforExcelfile {
	
/**
 * this method read the data from excel file and return value to the caller method.
 * @param name
 * @param row
 * @param cell
 * @return
 * @throws EncryptedDocumentException
 * @throws IOException
 */
	 
	public String readDatafromExcelFil(String name, int row, int cell) throws EncryptedDocumentException, IOException
	 {
		 FileInputStream fis = new FileInputStream("D:\\\\advance automation\\\\Contact.xlsx");
		 Workbook book = WorkbookFactory.create(fis);
	              String sheet1 = book.getSheet(name).getRow(row).getCell(cell).getStringCellValue();
	              return sheet1;
		
	}

}
