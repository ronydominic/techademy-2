package aug20.lab11;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class Lab11_lab3_Actions {

    private WebDriver driver;
    private Lab3Locators locators;   // PageFactory locators

    public Lab11_lab3_Actions(WebDriver driver) {
        this.driver = driver;
        locators = new Lab3Locators(driver);  // initialize PageFactory locators
    }

    public void openSite(String url) {
        driver.get(url);
    }

    public void goToMacSection() {
        locators.desktopsLink.click();
        locators.macLink.click();
    }

    public void sortByNameAZ() {
        locators.sortDropdown.click();
        locators.sortNameAZ.click();
    }

    public void addFirstProductToCart() {
        Actions actions = new Actions(driver);
        actions.moveToElement(locators.addToCartButton).perform();
        locators.addToCartButton.click();
    }
}
