package atClass.week5;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

public class FileReaderxl {
	@Test
	public void fileReader() throws InvalidFormatException, IOException {

		File src = new File("D:\\Selenium\\data\\testData.xlsx");
		
		
		XSSFWorkbook wb = new XSSFWorkbook(src);		
		XSSFSheet sheet = wb.getSheetAt(1);
		String value = sheet.getRow(1).getCell(2).getStringCellValue();
		System.out.println("The value available in the 2nd row 3rd column is: " + "\""+value+"\"");
	}
}

