package aug26Questions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Q9 {
	WebDriver driver;
  @Test
  public void f() throws IOException {
	  Q9ScreenShotObject obj = new Q9ScreenShotObject(driver);
	  obj.takeScreenShot();
  }
  
  
  @BeforeMethod
  public void beforeMethod() {
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
	  driver.get("https://wikipedia.org/");
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
