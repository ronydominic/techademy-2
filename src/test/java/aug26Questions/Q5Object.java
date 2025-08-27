package aug26Questions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Q5Object {
	WebDriver driver;

	@FindBy(css = "#content > div > ul > li:nth-child(1) > button")
	WebElement alertButton;
	
	public Q5Object(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver= driver;
		PageFactory.initElements(driver,this);
	}
	
	public void clickOnAlert() throws InterruptedException {
		alertButton.click();
		Alert alert = driver.switchTo().alert();
		Thread.sleep(3000);
		alert.accept();
		Thread.sleep(3000);
		
	}

}
