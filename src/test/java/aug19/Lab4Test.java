package aug19;

import static org.testng.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Lab4Test {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;
    @Parameters("browser")
    
    @BeforeMethod
    	public void setUp(String browser) {
        	if(browser.equalsIgnoreCase("chrome")) {
                driver = new ChromeDriver();

        	}
        	
        	else if (browser.equalsIgnoreCase(browser)) {
        		driver = new EdgeDriver();
        	}        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void lab4() {
        driver.get("https://tutorialsninja.com/demo/index.php?");
        driver.manage().window().setSize(new Dimension(1552, 832));

        // Title check
        assertEquals(driver.getTitle(), "Your Store");

        driver.findElement(By.linkText("Desktops")).click();
        driver.findElement(By.linkText("Mac (1)")).click();
        assertEquals(driver.getTitle(), "Mac");

        driver.findElement(By.linkText("-Mac (1)")).click();
        driver.findElement(By.id("input-sort")).click();
        {
            WebElement dropdown = driver.findElement(By.id("input-sort"));
            dropdown.findElement(By.xpath("//*[@id=\"input-sort\"]/option[2]")).click();
        }
        {
            WebElement element = driver.findElement(By.cssSelector(".button-group > button:nth-child(1)"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
        }
        driver.findElement(By.cssSelector(".button-group > button:nth-child(1)")).click();
        {
            WebElement element = driver.findElement(By.tagName("body"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element, 0, 0).perform();
        }
        {
            WebElement element = driver.findElement(By.cssSelector(".fa-shopping-cart"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
        }
        {
            WebElement element = driver.findElement(By.tagName("body"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element, 0, 0).perform();
        }
        {
            WebElement element = driver.findElement(By.cssSelector(".button-group > button:nth-child(1)"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
        }
        {
            WebElement element = driver.findElement(By.tagName("body"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element, 0, 0).perform();
        }
        driver.findElement(By.name("search")).click();
        driver.findElement(By.name("search")).sendKeys("Monitors");
        driver.findElement(By.cssSelector("#search > span > button")).click();
        driver.findElement(By.id("input-search")).click();
        driver.findElement(By.id("input-search")).sendKeys(" ");
        driver.findElement(By.id("description")).click();
        driver.findElement(By.id("button-search")).click();
    }
}
