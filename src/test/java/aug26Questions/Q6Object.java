package aug26Questions;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Q6Object {
	WebDriver driver;
	
	@FindBy(css="#checkboxes input[type='checkbox']")
	List<WebElement> checkboxes;
	
	public Q6Object(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	 
	public void selectCheckBox() {
	       for (WebElement checkbox : checkboxes) {
	            if (!checkbox.isSelected()) {
	                checkbox.click();
	            }
	            
	        }
	        boolean sel = checkboxes.stream().allMatch(WebElement::isSelected);

	        if (sel) {
	            System.out.println("Both checkboxes are selected");
	        } else {
	            System.out.println("Both checkboxes are not selected");
	        }
	    }
		
	}

