package aug26Questions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Q1 {
	WebDriver driver;
  @Test
  public void f() {
	  String title = driver.getTitle();
	  System.out.println("Title of the page "  + title);
	  
	  
  }
  
  @BeforeMethod
  public void before() {
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
	  driver.get("https://google.com");
  }
  
  @AfterMethod
  public void after() { 
	  driver.quit();
  }
}
