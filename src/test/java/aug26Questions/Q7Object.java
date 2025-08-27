package aug26Questions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Q7Object {
	String x;
	WebDriver driver;
	@FindBy(id = "table1")
	WebElement table1;
	List<WebElement> rows;
	
	
	
	
	public Q7Object(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void readTable() {
		rows = table1.findElements(By.tagName("tr"));
		rows.remove(0);
	}
	
	public void printNames() {
		for(WebElement row: rows) {
			List<WebElement> cols = row.findElements(By.tagName("td"));
			String lastName = cols.get(0).getText();
			String firstName = cols.get(1).getText();
			System.out.println(firstName + " " + lastName);
		}
		
	}
	
	public void findEmail(String name) {
		for(WebElement row: rows) {
			List<WebElement> cols = row.findElements(By.tagName("td"));
			String firstName = cols.get(1).getText().trim();
			if(firstName.equalsIgnoreCase(name)) {
				System.out.println(cols.get(2).getText());
				
			} 
		}
	}
	
	

}
