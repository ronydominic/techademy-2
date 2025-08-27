package aug26Questions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Q4Object {

	@FindBy(name = "my-select")
	WebElement dropdown;
	
	WebDriver driver;
	
	public Q4Object(WebDriver driver ) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	public void selectDropdown() {
		
		Select select = new Select(dropdown);
		select.selectByIndex(2);
		if(select.getFirstSelectedOption().getText().equals( "Two")) {
			System.out.println("Verified option 2");
		}
	}
}
