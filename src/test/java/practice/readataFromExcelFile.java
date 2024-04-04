package practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class readataFromExcelFile {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		//step1:OPen the document in java readable format:
		FileInputStream fis = new FileInputStream("D:\\advance automation\\Contact.xlsx");
		
		 //step2:Create a  WorkBook
	Workbook book = WorkbookFactory.create(fis);
	
	//step no.3 =  navigate to required sheet               
	Sheet sheet = book.getSheet("Contact");
	
	//step no4: Navigate to required row
	      Row row = sheet.getRow(1);
	 
	      //step no.5:navigate to required cell
	       Cell cell = row.getCell(2);
	       String value = cell.getStringCellValue();
	       
	       //step no.6: fetch the data
	       System.out.println(value);
	       
	       Row row1 = sheet.getRow(4);
	       Cell cell1 = row1.getCell(3);
	       String value1 = cell1.getStringCellValue();
	       
	       System.out.println(value1);
	       
	       //step no.7: close the book
	       book.close();
	}

}
