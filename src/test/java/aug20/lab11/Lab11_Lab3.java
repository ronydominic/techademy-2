package aug20.lab11;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Lab11_Lab3 {
    private WebDriver driver;
    private Lab11_lab3_Actions lab3;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        lab3 = new Lab11_lab3_Actions(driver);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void lab3Flow() throws InterruptedException {
        lab3.openSite("https://tutorialsninja.com/demo/index.php?");
        lab3.goToMacSection();
        lab3.sortByNameAZ();
        lab3.addFirstProductToCart();

        Thread.sleep(3000);
    }
}
