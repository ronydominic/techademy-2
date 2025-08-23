package aug22;

import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class Lab13
{
	login_pageobjects obj;

	WebDriver driver;
	 String projectpath=System.getProperty("user.dir")  ;
  @Test(dataProvider = "dp")
  public void Test(String username, String password) throws InterruptedException, IOException, ParserConfigurationException, SAXException {

	  
	  String title=driver.getTitle();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		System.out.println("The Title is:"+title);
		Thread.sleep(3000);
		
		login_pageobjects obj = new login_pageobjects(driver);
		obj.enterusername(username);
		obj.enterpassword(password);
		obj.clickonlogin();
		
	  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("Before Method");
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
  }
  @AfterMethod
  public void afterMethod() {
	  System.out.println("After method");
	  driver.quit();
  }


  @DataProvider
  public Object[][] dp() throws IOException {
	  
	 return new Object[][]
			 {
		 new Object[] {"Admin", "admin123"},
		 new Object[] {"aaaaa", "aaaaaa"}
			 };
    
    }
  
 
 

}