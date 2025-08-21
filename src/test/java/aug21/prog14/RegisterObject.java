package aug21.prog14;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterObject {
	WebDriver driver;
	private By firstName = By.id("input-firstname");
	private By lastName = By.id("input-lastname");
	private By email = By.id("input-email");
	private By phone = By.id("input-telephone");
	private By password = By.id("input-password");
	private By confirmPassword = By.id("input-confirm");
	private By news = By.name("newsletter");
	private By agree = By.name("agree");
	private By submitBtn = By.cssSelector("input.btn.btn-primary");
	private By account = By.cssSelector("span.caret");
	private By register = By.linkText("Register");
	
	public RegisterObject(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;		
	}
	
	
	public void register() throws InterruptedException {
		
		driver.findElement(account).click();
		driver.findElement(register).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}
	public void setDetails(String firstName, String lastName, String email, String phone, String password, String confirmPassword) {
		driver.findElement(this.firstName).sendKeys(firstName);
		driver.findElement(this.lastName).sendKeys(lastName);
		driver.findElement(this.email).sendKeys(email);
		driver.findElement(this.phone).sendKeys(phone);
		driver.findElement(this.password).sendKeys(password);
		driver.findElement(this.confirmPassword).sendKeys(confirmPassword);
		
		

	}
	public void submit() {
		driver.findElement(agree).click();
		driver.findElement(submitBtn).click();
		
	}
	public void subscribeNewsLetter() {
		driver.findElement(news).click();
	}

}
