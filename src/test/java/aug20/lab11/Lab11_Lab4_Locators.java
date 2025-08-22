package aug20.lab11;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Lab11_Lab4_Locators {
    WebDriver driver;

    @FindBy(linkText = "Desktops")
    public WebElement desktopsLink;

    @FindBy(linkText = "Mac (1)")
    public WebElement macLink;

    @FindBy(id = "input-sort")
    public WebElement sortDropdown;

    @FindBy(xpath = "//*[@id='input-sort']/option[2]")
    public WebElement sortOption2;

    @FindBy(css = ".button-group > button:nth-child(1)")
    public WebElement addToCartButton;

    @FindBy(css = ".fa-shopping-cart")
    public WebElement shoppingCartIcon;

    @FindBy(name = "search")
    public WebElement searchBox;

    @FindBy(css = "#search > span > button")
    public WebElement searchButton;

    @FindBy(id = "input-search")
    public WebElement inputSearch;

    @FindBy(id = "description")
    public WebElement descriptionCheckbox;

    @FindBy(id = "button-search")
    public WebElement buttonSearch;

    public Lab11_Lab4_Locators(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
