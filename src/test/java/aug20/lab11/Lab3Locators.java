package aug20.lab11;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



	public class Lab3Locators {
		WebDriver driver;

	    @FindBy(linkText = "Desktops")
	    public WebElement desktopsLink;

	    @FindBy(linkText = "Mac (1)")
	    public WebElement macLink;

	    @FindBy(id = "input-sort")
	    public WebElement sortDropdown;

	    @FindBy(xpath = "//option[.='Name (A - Z)']")
	    public WebElement sortNameAZ;

	    @FindBy(css = ".button-group > button:nth-child(1)")
	    public WebElement addToCartButton;

	    public Lab3Locators(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }
	}
