package readAndWriteExcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadExcel {
	
	@Test
	public void readExcel() throws IOException {
		String excelPath = "D:\\WorkSpace_V001\\TestByOnePlace\\src\\test\\java\\readAndWriteExcel\\TestData.xlsx";
		String fileName = "TestData";
		String sheetName = "Test1";
		 //create the object of File class to get excel path
		File file= new File(excelPath);
		//to read the file
		FileInputStream fis = new FileInputStream(file);		
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum();
		System.out.println(rowCount);
		String cellValue = sheet.getRow(0).getCell(0).getStringCellValue();
		System.out.println(cellValue);
		for(int i = 0; i<=rowCount; i++) {
			Row row =sheet.getRow(i);
			for(int j=0; j<row.getLastCellNum(); j++) {
				String data = sheet.getRow(i).getCell(j).getStringCellValue();
				System.out.print(data+ " " );
			}
			System.out.println();
		}
		wb.close();
	}
	
	
	@Test
	public void readExcelTest() throws IOException {
		ExcelLibaray obj = new ExcelLibaray();
		String dataString = obj.readData("Test1", 1, 1);
		System.out.println("The Data is==>" +dataString);
	}

}
