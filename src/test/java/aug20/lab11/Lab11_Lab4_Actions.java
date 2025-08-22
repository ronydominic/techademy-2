package aug20.lab11;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class Lab11_Lab4_Actions {
    private WebDriver driver;
    private Lab11_Lab4_Locators locators;

    public Lab11_Lab4_Actions(WebDriver driver) {
        this.driver = driver;
        locators = new Lab11_Lab4_Locators(driver);
    }

    public void openSite(String url) {
        driver.get(url);
    }

    public void verifyHomePageTitle() {
        Assert.assertEquals(driver.getTitle(), "Your Store");
    }

    public void goToMacSection() {
        locators.desktopsLink.click();
        locators.macLink.click();
        Assert.assertEquals(driver.getTitle(), "Mac");
    }

    public void sortProducts() {
        locators.sortDropdown.click();
        locators.sortOption2.click();
    }

    public void addFirstProductToCart() {
        Actions actions = new Actions(driver);
        actions.moveToElement(locators.addToCartButton).perform();
        locators.addToCartButton.click();
    }

    public void hoverShoppingCart() {
        Actions actions = new Actions(driver);
        actions.moveToElement(locators.shoppingCartIcon).perform();
    }

    public void searchProduct(String keyword) {
        locators.searchBox.clear();
        locators.searchBox.sendKeys(keyword);
        locators.searchButton.click();
    }

    public void advancedSearch(String keyword) {
        locators.inputSearch.clear();
        locators.inputSearch.sendKeys(keyword);
        locators.descriptionCheckbox.click();
        locators.buttonSearch.click();
    }
}
