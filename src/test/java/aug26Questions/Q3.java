package aug26Questions;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Q3 {
	WebDriver driver;
	By contShoppBtn = By.className("a-button-text");

  @Test
  public void f() {
	  Q3SearchProduct Q3Obj = new Q3SearchProduct(driver);
	  Q3Obj.search("laptop");
	  Q3Obj.displayElements(5);
	  
  }
  @BeforeMethod
  public void beforeMethod() {
	  WebDriverManager.chromiumdriver().setup();
	  driver = new ChromeDriver();
	  driver.get("https://www.amazon.in/");
	  try{
		  WebElement ele = driver.findElement(contShoppBtn);
		  if(ele.isDisplayed()) {
			 ele.click();
		  }
	  } catch(NoSuchElementException e) {
		  //e.printStackTrace();
		 
	  }
	 
  }

  @AfterMethod
  public void afterMethod() {
	 driver.quit();
  }

}
