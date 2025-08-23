package aug22;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterObject {
    WebDriver driver;

    private By firstNameField = By.id("input-firstname");
    private By lastNameField = By.id("input-lastname");
    private By emailField = By.id("input-email");
    private By phoneField = By.id("input-telephone");
    private By passwordField = By.id("input-password");
    private By confirmPasswordField = By.id("input-confirm");
    private By newsletterCheckbox = By.name("newsletter");
    private By agreeCheckbox = By.name("agree");
    private By submitButton = By.cssSelector("input.btn.btn-primary");
    private By accountMenu = By.cssSelector("span.caret");
    private By registerLink = By.linkText("Register");

    public RegisterObject(WebDriver driver) {
        this.driver = driver;
    }

    public void goToRegisterPage() {
        driver.findElement(accountMenu).click();
        driver.findElement(registerLink).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void setDetails(String firstName, String lastName, String email, String phone, String password, String confirmPassword) {
        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(phoneField).sendKeys(phone);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(confirmPasswordField).sendKeys(confirmPassword);
    }

    public void subscribeToNewsletter() {
        driver.findElement(newsletterCheckbox).click();
    }

    public void submitForm() {
        driver.findElement(agreeCheckbox).click();
        driver.findElement(submitButton).click();
    }
}
