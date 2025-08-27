package aug26Questions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Q7 {
	WebDriver driver;
  @Test
  public void f() {
	  Q7Object obj = new Q7Object(driver);
	  obj.readTable();
	  obj.printNames();
	  obj.findEmail("Jason");
	  
  }
  
  
  @BeforeMethod
  public void beforeMethod() {
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
	  driver.get("https://the-internet.herokuapp.com/tables");
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10000));
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
