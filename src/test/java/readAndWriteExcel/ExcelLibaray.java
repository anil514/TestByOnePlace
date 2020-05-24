package readAndWriteExcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelLibaray {
	XSSFWorkbook wb;
	XSSFSheet sheet;
	
	public ExcelLibaray() throws IOException {
		String excelPath = "D:\\WorkSpace_V001\\TestByOnePlace\\src\\test\\java\\readAndWriteExcel\\TestData.xlsx";
		File file= new File(excelPath);
		FileInputStream fis = new FileInputStream(file);		
		wb = new XSSFWorkbook(fis);
	}
	
	public String readData(String sheetName, int row, int col) {
		sheet = wb.getSheet(sheetName);
		String data = sheet.getRow(row).getCell(col).getStringCellValue();
		return data;
	}

}
