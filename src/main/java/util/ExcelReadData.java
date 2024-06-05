package util;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;

public class ExcelReadData {
	
	
	public void getDataFromExcel() throws IOException {
		
	FileInputStream fis = new FileInputStream("C:\\\\Users\\\\admin\\\\eclipse-workspace\\\\selenium\\\\testdata.xlsx");
	XSSFWorkbook workbook = new XSSFWorkbook(fis);
	XSSFSheet sheet= workbook.getSheetAt(0);
	XSSFRow cell ;
	
		for (int i = 1; i <=sheet.getLastRowNum() ; i++) {
					
			// import the data from the cell to load username
		cell = sheet.getRow(i);
				 
		  String user=cell.getCell(0).getStringCellValue();
			System.out.println(user);
							// import the data from the cell to load username
		
			 // import the data from the cell to load password
				String paswrd=cell.getCell(1).getStringCellValue();
				System.out.println(paswrd);
					}
				
			}
	
}
