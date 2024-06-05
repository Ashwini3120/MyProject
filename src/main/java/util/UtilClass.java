package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UtilClass {
	WebDriver driver;
	public static WebElement explicitWait(WebDriver driver,WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		WebElement waitElement= wait.until(ExpectedConditions.visibilityOf(element));
		return waitElement;
	}
	
	
	public static void getDataFromExcel() throws IOException {
		
		FileInputStream fis = new FileInputStream("C:\\Users\\admin\\eclipse-workspace\\selenium\\LoginCredentials.xlsx");
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
	public static String getScreenshot(WebDriver driver,String testname) throws IOException
	{
		Date date = new Date();
		
		SimpleDateFormat f = new SimpleDateFormat("hh-mm-ss");
		
		String currentDate = f.format(date);
		
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		String path ="C:\\Users\\admin\\Screenshot\\"+testname +" img.png";
		
		File dest = new File(path);
		
		FileHandler.copy(source, dest);
		return path;
		
	}
		

}
