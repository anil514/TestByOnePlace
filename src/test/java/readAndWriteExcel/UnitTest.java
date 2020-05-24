package readAndWriteExcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class UnitTest {
	
	@Test
	public void differentNumberOfSheets() throws EncryptedDocumentException, IOException
	{
		String userDir = System.getProperty("user.dir");
		File file1 = new File(userDir+"\\src\\test\\java\\readAndWriteExcel\\TestData.xlsx");
		FileInputStream fis1 = new FileInputStream(file1);		
		XSSFWorkbook wb1 = new XSSFWorkbook(fis1);
		File file2 = new File(userDir+"\\src\\test\\java\\readAndWriteExcel\\TestData1.xlsx");
		FileInputStream fis2 = new FileInputStream(file2);		
		XSSFWorkbook wb2 = new XSSFWorkbook(fis2);
		CompareExcel mse_CompareExcelFiles = new CompareExcel();
		mse_CompareExcelFiles.verifyIfExcelFilesHaveSameNumberAndNameOfSheets(wb1, wb2);
		
	}
	
	@Test
	public void differentNumberOfSheets1() throws EncryptedDocumentException, IOException
	{
		String userDir = System.getProperty("user.dir");
		Workbook wb1 = WorkbookFactory.create(new File(userDir+"\\src\\test\\java\\readAndWriteExcel\\TestData.xlsx"));
		Workbook wb2 = WorkbookFactory.create(new File(userDir+"\\src\\test\\java\\readAndWriteExcel\\TestData1.xlsx"));
		CompareExcel mse_CompareExcelFiles = new CompareExcel();
		mse_CompareExcelFiles.verifyIfExcelFilesHaveSameNumberAndNameOfSheets(wb1, wb2);
		
	}
	
	@Test
	public void sameNumberOfSheets() throws EncryptedDocumentException, IOException
	{
		String userDir = System.getProperty("user.dir");
		Workbook wb1 = WorkbookFactory.create(new File(userDir+"\\src\\test\\java\\readAndWriteExcel\\TestData.xlsx"));
		Workbook wb2 = WorkbookFactory.create(new File(userDir+"\\src\\test\\java\\readAndWriteExcel\\TestData1.xlsx"));
		CompareExcel mse_CompareExcelFiles = new CompareExcel();
		mse_CompareExcelFiles.verifyIfExcelFilesHaveSameNumberAndNameOfSheets(wb1, wb2);
	}
	

	@Test
	public void differentNumberOfRows() throws EncryptedDocumentException, IOException
	{
		String userDir = System.getProperty("user.dir");
		Workbook wb1 = WorkbookFactory.create(new File(userDir+"\\src\\test\\java\\readAndWriteExcel\\TestData.xlsx"));
		Workbook wb2 = WorkbookFactory.create(new File(userDir+"\\src\\test\\java\\readAndWriteExcel\\TestData1.xlsx"));
		CompareExcel mse_CompareExcelFiles = new CompareExcel();
		mse_CompareExcelFiles.verifySheetsInExcelFilesHaveSameRowsAndColumns(wb1, wb2);
	}
	
	@Test
	public void differentNumberOfColumns() throws EncryptedDocumentException, IOException
	{
		String userDir = System.getProperty("user.dir");
		Workbook wb1 = WorkbookFactory.create(new File(userDir+"\\src\\test\\java\\readAndWriteExcel\\TestData.xlsx"));
		Workbook wb2 = WorkbookFactory.create(new File(userDir+"\\src\\test\\java\\readAndWriteExcel\\TestData1.xlsx"));
		CompareExcel mse_CompareExcelFiles = new CompareExcel();
		mse_CompareExcelFiles.verifySheetsInExcelFilesHaveSameRowsAndColumns(wb1, wb2);
	}
	
	@Test
	public void sameContentOfExcelFiles() throws EncryptedDocumentException, IOException {
		String userDir = System.getProperty("user.dir");
		Workbook wb1 = WorkbookFactory.create(new File(userDir+"\\src\\test\\java\\readAndWriteExcel\\TestData.xlsx"));
		Workbook wb2 = WorkbookFactory.create(new File(userDir+"\\src\\test\\java\\readAndWriteExcel\\TestData1.xlsx"));
		CompareExcel mse_CompareExcelFiles = new CompareExcel();
		mse_CompareExcelFiles.verifyIfExcelFilesHaveSameNumberAndNameOfSheets(wb1, wb2);
		mse_CompareExcelFiles.verifySheetsInExcelFilesHaveSameRowsAndColumns(wb1, wb2);
		mse_CompareExcelFiles.verifyDataInExcelBookAllSheets(wb1, wb2);
	
	}

}
