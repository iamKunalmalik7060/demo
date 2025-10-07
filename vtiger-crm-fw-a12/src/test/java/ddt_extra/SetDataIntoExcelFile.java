package ddt_extra;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class SetDataIntoExcelFile {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
	FileInputStream fis=new FileInputStream("./src/test/resources/testscriptDatacreatetion.xlsx");
	Workbook wb=WorkbookFactory.create(fis);
	Sheet sh=wb.getSheet("InsertData");
	Row row=sh.createRow(1);   //getRow(1)
	Cell cell=row.createCell(1);
	cell.setCellValue("Google_");
	
	// Save the changes
	FileOutputStream fos=new FileOutputStream("./src/test/resources/testscriptDatacreatetion.xlsx");
	wb.write(fos);
	wb.close();
	}
}
