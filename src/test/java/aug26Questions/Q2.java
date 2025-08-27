package aug26Questions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Q2 {
	WebDriver driver;
  @Test
  public void f() {
	  
	 
	  
	  Q2Login loginObj = new Q2Login(driver);
	  loginObj.enterUsername("tomsmith");
	  loginObj.enterPassword("SuperSecretPassword!");
	  loginObj.clickLogin();
	  loginObj.verifyLoginSuccessful();
  }
  @BeforeMethod()
  public void beforeMethod() {
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
	  driver.get("https://the-internet.herokuapp.com/login");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
