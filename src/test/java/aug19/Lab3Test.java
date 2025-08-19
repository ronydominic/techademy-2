package aug19;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterMethod;
import org.testng.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.JavascriptExecutor;

import java.util.HashMap;
import java.util.Map;

public class Lab3Test {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;

    @Parameters("browser")

    @BeforeMethod
    public void setUp(String browser) {
    	if(browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();

    	}
    	
    	else if (browser.equalsIgnoreCase("edge")) {
    		driver = new EdgeDriver();
    	}
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void lab3() {
        driver.get("https://tutorialsninja.com/demo/index.php?");
        driver.manage().window().setSize(new Dimension(1552, 832));
        
        driver.findElement(By.linkText("Desktops")).click();
        driver.findElement(By.linkText("Mac (1)")).click();
        driver.findElement(By.id("input-sort")).click();

        WebElement dropdown = driver.findElement(By.id("input-sort"));
        dropdown.findElement(By.xpath("//option[. = 'Name (A - Z)']")).click();

        WebElement element = driver.findElement(By.cssSelector(".button-group > button:nth-child(1)"));
        Actions builder = new Actions(driver);
        builder.moveToElement(element).perform();

        WebElement body = driver.findElement(By.tagName("body"));
        builder.moveToElement(body, 0, 0).perform();

        driver.findElement(By.cssSelector(".button-group > button:nth-child(1)")).click();

        try {
            Thread.sleep(5000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
