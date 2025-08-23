package aug22;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class Lab16PageObjects {
	WebDriver driver;
	
	public Lab16PageObjects(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(css = "span.caret")
	WebElement account;

	@FindBy(linkText = "Register")
	WebElement register;

	@FindBy(name="firstname")
	WebElement firstname_1;
	
	@FindBy(name="lastname")
	WebElement lastname_1;
	
	@FindBy(name="email")
	WebElement email_1;
	
	@FindBy(name="telephone")
	WebElement number_1;
	
	@FindBy(name="password")
	WebElement password_1;
	
	@FindBy(name="confirm")
	WebElement confpass_1;
	
	@FindBy(name="agree")
	WebElement newlet;
	
	@FindBy(xpath="//*[@id=\"content\"]/form/div/div/input[2]")
	WebElement confirm;
	
	@FindBy(xpath="//*[@id=\"content\"]/h1")
	WebElement sucess;
	
	
	public void accountreg() {
		account.click();
		register.click();
	}
	public void registeruser(String firstname, String lastname, String email, String phone, String password, String confpass ) {
		firstname_1.sendKeys(firstname);
		lastname_1.sendKeys(lastname);
		email_1.sendKeys(email);
		number_1.sendKeys(phone);
		password_1.sendKeys(password);
		confpass_1.sendKeys(confpass);
		newlet.click();
		confirm.click();
	}
	public void sucess()
	{
		String text = sucess.getText();
		Assert.assertEquals(text, "Your Account Has Been Created!");
		System.out.println("Account Created message Verified!");
	}

}