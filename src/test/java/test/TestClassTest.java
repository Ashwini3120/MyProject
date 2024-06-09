package test;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import factory.FactoryClass;
import pages.LoginPage;
import util.UtilClass;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;

public class TestClassTest {
	WebDriver driver;
	LoginPage lp;
	
	static ExtentSparkReporter reporter;
	static ExtentTest test;
	static ExtentReports report;
	
	@Parameters({"browser"})
	@BeforeClass
	  public void beforeClass(@Optional("browser")String a) {
	
		driver=FactoryClass.getDriver(a);
		reporter=new  ExtentSparkReporter("ExtendReports.html");
		report = new ExtentReports();
	   report.attachReporter(reporter);
	   test= report.createTest("LoginTest");
	  }
	
	 @BeforeMethod
	  public void beforeMethod() {
	  
	 lp=new LoginPage(driver);
	 
	 }
	 
//	 @DataProvider(name="dataset")
//	  public String[][] data() {
//		 String[][] data= {{"bothwrong","adm","admin"},{"wrongpass","Admin","Admin@20"},{"bothcorrect","Admin","admin123"}};
//		  
//		return data;
//	   	      
//	  }
	 
  
  
// public void verifyUserCanLogin(String scenario,String user,String password) throws IOException { 
//	  lp.enterUsername(user);
//	  lp.enterPassword(password);
  @Test
	 public void verifyUserCanLogin(String user) throws IOException {
	  lp.enterUsername(user);
  }
  @Test
  public void verifyUserpas(String password) throws IOException {
  	  lp.enterPassword(password);
  }
  @Test
  public void sub() throws IOException {
	  lp.ClickonSubmit();
	 // lp.verifyLoginwithInvalidCredentials(scenario);
	  UtilClass.getScreenshot(driver,"login");
	  
  }
 

  @AfterMethod
  public void afterMethod(ITestResult result) {
	  if(result.getStatus()==ITestResult.FAILURE) {
		  test.log(Status.FAIL, "VerifyLoginFunctionality");
		  
	  }
	  else {
		  test.log(Status.PASS,"Unsuccessfully");
	  }
  
  }

  @AfterClass
  public void afterClass() {
	  report.flush();
  }

}
