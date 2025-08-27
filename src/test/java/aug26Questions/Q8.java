package aug26Questions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Q8 {
	WebDriver driver;
  @Test
  public void f() {
	  Q8Object obj = new Q8Object(driver);
	  obj.clickNewWindowBtn();
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
	  driver.get("https://the-internet.herokuapp.com/windows");
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
