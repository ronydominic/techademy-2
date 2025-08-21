package aug20;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TC012{
	WebDriver driver;
  @Test(dataProvider = "dp")
  public void f(String username, String password) throws InterruptedException {
		String title=driver.getTitle();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		System.out.println("The Title is:"+title);
		Thread.sleep(3000);
		
		login_pageobjects obj = new login_pageobjects(driver);
		obj.enterusername(username);
		obj.enterpassword(password);
		obj.clickonlogin();
//		driver.findElement(By.name("username")).sendKeys(username);
//		driver.findElement(By.name("password")).sendKeys(password);
//		driver.findElement(By.xpath("//button[@type='submit']")).click();
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("Before Method");
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("After Method");
	  driver.quit();
  }


  @DataProvider
  public Object[][] dp() throws IOException {
	  String[][] data = new String[3][2];
	  System.out.println("Before Class");
	  String projectpath = System.getProperty("user.dir");
	  File file1 = new File(projectpath+"\\data.xlsx");
	  FileInputStream fs = new FileInputStream(file1);
	  XSSFWorkbook workbook = new XSSFWorkbook(fs);
	  XSSFSheet worksheet = workbook.getSheetAt(0);
	  int rowcount = worksheet.getPhysicalNumberOfRows();
	  System.out.println("Rows:"+rowcount);
	  
	  for(int i=0;i<rowcount;i++) {
	  data[i][0]=worksheet.getRow(i).getCell(0).getStringCellValue();
	  data[i][1]=worksheet.getRow(i).getCell(1).getStringCellValue();
	  
	  }
	  return data;
//    return new Object[][] {
//      new Object[] { "Admin", "admin123" },
//      new Object[] { "sid", "admin123" },
    }
  
  @BeforeClass
  public void beforeClass() {
	  
	  
	  
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("After Class");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("Before test");
  }
}