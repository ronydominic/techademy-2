package aug16;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC008_Alert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https:letcode.in/alert");
		driver.findElement(By.id("accept")).click();
		Alert sAlert = driver.switchTo().alert();
		System.out.println("The message is: " + sAlert.getText());
		sAlert.accept();
		driver.findElement(By.id("confirm")).click();
		Alert cAlert = driver.switchTo().alert();
		System.out.println("Confirm alert: " + cAlert.getText());
		cAlert.dismiss();
		
		
		driver.findElement(By.id("prompt")).click();
		Alert pAlert = driver.switchTo().alert();
		System.out.println("Prompt alert: " + pAlert.getText());
		pAlert.accept();
	}

}
