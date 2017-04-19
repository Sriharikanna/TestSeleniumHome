package wordpresspackage;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ApachiPOI {

	XSSFWorkbook wb;
	XSSFSheet sheet;

	public ApachiPOI()

	{
		try {
			File src = new File("D:\\SeleniumExcelData\\TestData.xlsx");
			FileInputStream fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
	}

	public String getData(int sheetNumber, int row,int column) {		
		sheet = wb.getSheetAt(sheetNumber);
		String data = sheet.getRow(row).getCell(column).getStringCellValue();
		return data;
	}

	public int getRowCount(int sheetIndex) {
		int row = wb.getSheetAt(sheetIndex).getLastRowNum();
		row = row + 1;
		return row;

	}

}
