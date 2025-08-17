package aug16;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC009_WindowHandling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://letcode.in/window");
		driver.findElement(By.id("home")).click();
		String pWindow = driver.getWindowHandle();
		System.out.println("Parent window: " + pWindow);
		System.out.println("url is: " + driver.getCurrentUrl());
		
		

	}

}
