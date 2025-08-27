package aug26Questions;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Q8Object {
	WebDriver driver;
	@FindBy(xpath = "//*[@id=\"content\"]/div/a")
	WebElement newWindowBtn;
	
	public Q8Object(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void clickNewWindowBtn() {
		newWindowBtn.click();
		String parentWindow = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		for(String window: windows) {
			if(!window.equals(parentWindow)) {
				driver.switchTo().window(window);
				System.out.println("Current window is: " + driver.getTitle());
			}
		}
		driver.switchTo().window(parentWindow);
		System.out.println("Current window is : " + driver.getTitle());
	}

}
