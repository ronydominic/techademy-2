package aug26Questions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.NoSuchElementException;

public class Q2Login {
	WebDriver driver;
	private By uname = By.name("username");
	private By pass = By.name("password");
	private By loginXpath = By.xpath("//*[@id='login']/button/i");
	private By successMsg = By.cssSelector(".flash.success");
	public Q2Login(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	
	public void enterUsername(String username) {
		driver.findElement(uname).sendKeys(username);
	}
	
	public void enterPassword(String password) {
		driver.findElement(pass).sendKeys(password);
	}
	
	public void clickLogin() {
		driver.findElement(loginXpath).click();
	}
	
	public void verifyLoginSuccessful() {
		try {
		if(driver.findElement(successMsg).isDisplayed()) {
			System.out.println("Login successful");
		} 
		}
		catch(NoSuchElementException e) {
			System.out.println("Login unsuccessful");
		
	}
	}
}


