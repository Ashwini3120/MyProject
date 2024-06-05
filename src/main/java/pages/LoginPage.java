package pages;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import util.UtilClass;

public class LoginPage extends UtilClass{
	WebDriver driver;
	
	@FindBy(xpath="//input[@name='username']")
	private WebElement username;

	@FindBy(xpath="//input[@name='password']")
	private WebElement paswrd;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement submit;
	
	@FindBy(xpath="//p[text()='Invalid credentials']")
	private WebElement invalid;
	
	@FindBy(xpath="//span[@class='oxd-userdropdown-tab']")
	private WebElement account;
	
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
		this.driver=driver;
	}
	
	
	public void enterUsername(String user) throws IOException {
		explicitWait(driver,username);
		username.sendKeys(user);
		
	}
	public void enterPassword(String pass) throws IOException {
		paswrd.sendKeys(pass);
		
	}

	public void ClickonSubmit() throws IOException {
		submit.click();
		
	}
	public void verifyLoginwithInvalidCredentials(String scenario) {
		
		 if(scenario.equals("bothwrong")) {
			 explicitWait(driver,invalid);
			 String txt=invalid.getText();
			Assert.assertEquals(txt, "Invalid credentials");
			 //Assert.assertTrue(invalid.isDisplayed(),"Log in not successfull");
			  System.out.println("Login not Successfull");
		 
		  }
		
		else if(scenario.equals("wrongpass")) {
			explicitWait(driver,invalid);
			String txt=invalid.getText();
			Assert.assertEquals(txt, "Invalid credentials");
			 //Assert.assertTrue(invalid.isDisplayed(),"Log in not successfull");
			  System.out.println("Login not Successfull");
			 
			  }
		 if(scenario.equals("bothcorrect")) {
			explicitWait(driver,account);
			  Assert.assertTrue(account.isDisplayed());
			  System.out.println("Login Successfull");
			 
			  }
		
		
	}

}
