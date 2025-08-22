package aug20.lab11;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Lab11_Lab4 {
    private WebDriver driver;
    private Lab11_Lab4_Actions lab4;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        lab4 = new Lab11_Lab4_Actions(driver);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void lab4Flow() throws InterruptedException {
        lab4.openSite("https://tutorialsninja.com/demo/index.php?");
        lab4.verifyHomePageTitle();

        lab4.goToMacSection();
        lab4.sortProducts();
        lab4.addFirstProductToCart();
        lab4.hoverShoppingCart();

        lab4.searchProduct("Monitors");
        lab4.advancedSearch(" ");
        
        Thread.sleep(3000); // observe result
    }
}
