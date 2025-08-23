package aug22;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LAB015
{
	RegisterObject obj;

	WebDriver driver;
	 String projectpath=System.getProperty("user.dir")  ;
  @Test(dataProvider = "dp")
  public void Test(String firstName, String lastName, String email, String phone, String password, String confirmPassword) throws InterruptedException, IOException {

	  
	    String title=driver.getTitle();
		System.out.println("The Title is:"+title);
		obj=new RegisterObject(driver);
		obj.goToRegisterPage();
		obj.setDetails(firstName, lastName, email, phone, password, confirmPassword);
		obj.subscribeToNewsletter();
		obj.submitForm();
		
		//Assert.assertEquals(title, "Amazon");
		ExtentReports extent=new ExtentReports();
		String reportpath=projectpath+"\\Aug22reportlab15.html";
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
  public Object[][] dp() throws IOException, CsvException {
      String csvFile = projectpath + "\\userdataCSV.csv";
      CSVReader csvReader = new CSVReader(new FileReader(csvFile));
      List<String[]> data = csvReader.readAll();	

      // Create array with rows = data.size() and cols = data.get(0).length
      String[][] data1 = new String[data.size()][data.get(0).length];

      for (int i = 0; i < data.size(); i++) {
          for (int j = 0; j < data.get(i).length; j++) {
              data1[i][j] = data.get(i)[j];
          }
      }

      return data1;
  }

  
 
 

}