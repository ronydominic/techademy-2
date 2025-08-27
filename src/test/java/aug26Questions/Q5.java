package aug26Questions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Q5 {
	WebDriver driver;
	@Test
	  public void f() throws InterruptedException {
		Q5Object obj = new Q5Object(driver);
		obj.clickOnAlert();
	  }
	
	
	  @BeforeMethod
	  public void beforeMethod() {
		  WebDriverManager.chromedriver().setup();
		  driver = new ChromeDriver();
		  driver.get("https://the-internet.herokuapp.com/javascript_alerts");
	  }

	  @AfterMethod
	  public void afterMethod() {
		  driver.quit();
	  }

}
