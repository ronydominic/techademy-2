package aug21.prog14;
import org.testng.annotations.Test;
import aug20.login_pageobjects;

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

public class LAB014
{
	RegisterObject obj;

	WebDriver driver;
	 String projectpath=System.getProperty("user.dir")  ;
  @Test(dataProvider = "dp")
  public void Test(String firstName, String lastName, String email, String phone, String password, String confirmPassword) throws InterruptedException, IOException {

	  
	    String title=driver.getTitle();
		System.out.println("The Title is:"+title);
		obj=new RegisterObject(driver);
		obj.register();
		obj.setDetails(firstName, lastName, email, phone, password, confirmPassword);
		obj.subscribeNewsLetter();
		obj.submit();
		
		//Assert.assertEquals(title, "Amazon");
		ExtentReports extent=new ExtentReports();
		String reportpath=projectpath+"\\Aug21reportlab14.html";
		ExtentSparkReporter spark=new ExtentSparkReporter(reportpath);
		extent.attachReporter(spark);
		ExtentTest test=extent.createTest("Verify the title of the page");
		if(title.equals("Your Store"))
		{
			test.pass("title is matched");
		}
		else
		{
			test.fail("title is not mathed");
			
			File scr=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			String dest=projectpath+"\\screenshot1 "+LocalDateTime.now() +".png";
			File detfile=new File(dest);
			FileUtils.copyFile(scr, detfile);
			test.addScreenCaptureFromPath(dest);
		}
		
		extent.flush();
		
	  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("Before method");
	  WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://tutorialsninja.com/demo/index.php");
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
	  
	 
	  File file1=new File(projectpath+"\\userdata.xlsx");
	  System.out.println("file path is:"+file1);
	  FileInputStream fs=new FileInputStream(file1);
	  XSSFWorkbook workbook=new XSSFWorkbook(fs);
	  XSSFSheet worksheet=workbook.getSheetAt(0);
	  int rowcount=worksheet.getPhysicalNumberOfRows();
	  String[][] data=new String[rowcount][6];
	  DataFormatter formatter = new DataFormatter();
	  System.out.println("rows:"+rowcount);
	  
	  for(int i=0;i<rowcount;i++)
	  {
		  data[i][0]=worksheet.getRow(i).getCell(0).getStringCellValue();
		  data[i][1]=worksheet.getRow(i).getCell(1).getStringCellValue();
		  data[i][2]=worksheet.getRow(i).getCell(2).getStringCellValue();
		  data[i][3]=formatter.formatCellValue(worksheet.getRow(i).getCell(3));
		  data[i][4]=worksheet.getRow(i).getCell(4).getStringCellValue();
		  data[i][5]=worksheet.getRow(i).getCell(5).getStringCellValue();

	  }
	  
	  return data;
	  
    
    }
  
 
 

}