package aug26Questions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Q3SearchProduct {
	WebDriver driver;
	
	@FindBy(xpath = "//*[@id='twotabsearchtextbox']")
	private WebElement searchbar;
	
	@FindBy(xpath = "//*[@id=\"nav-search-submit-button\"]")
	private WebElement searchButton;
	
	@FindBy(css = ".a-size-medium.a-spacing-none.a-color-base.a-text-normal")
	List<WebElement> products;
	
	public Q3SearchProduct(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void search(String product) {
		searchbar.clear();
		searchbar.sendKeys(product);
		searchButton.click();
		new WebDriverWait(driver, Duration.ofSeconds(6));
		
	}
	
	public void displayElements(int count) {
		for(int i = 0; i<5; i++) {
			System.out.println("Item " + (i+1));
			System.out.println(products.get(i).getText());
			System.out.println("--------------------------");
		}
	}
	
	

}
