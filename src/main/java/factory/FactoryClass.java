package factory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
public class FactoryClass {
	public static WebDriver getDriver(String a) {
		if(a.equals("chrome"))
		{
			//System.setProperty("webdriver.chrome.driver","C:\\webdriver\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			WebDriver driver=new ChromeDriver();
			driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
			driver.manage().window().maximize();
				
			return driver;
		}
		else if(a.equalsIgnoreCase("firefox")) {
			//System.setProperty("webdriver.firefox.driver","C:\\webdriver\\geckodriver.exe");
			WebDriverManager.firefoxdriver().setup();
			WebDriver driver=new FirefoxDriver();
			driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
			driver.manage().window().maximize();
			return driver;
		}
		else {
			//System.setProperty("webdriver.edge.driver","C:\\webdriver\\edgedriver.exe");
			WebDriverManager.edgedriver().setup();
			WebDriver driver=new EdgeDriver();
			driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
			driver.manage().window().maximize();
			return driver;
		}
			
	}
}
	


