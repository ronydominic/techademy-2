package aug21.lab12;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Lab12 {


	  @Test
	  public void f() throws IOException {
		  Properties prob=new Properties();
		  String path=System.getProperty("user.dir");
		  FileInputStream fis=new FileInputStream(path+"\\configuration\\config.properties");
		  prob.load(fis);
		  WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
		    driver.get(prob.getProperty("URL"));

		    driver.findElement(By.linkText(prob.getProperty("PC_TYPE"))).click();
		    driver.findElement(By.linkText(prob.getProperty("MAC"))).click();

		    driver.findElement(By.id(prob.getProperty("SORT_OPTION"))).click();

		    driver.findElement(By.cssSelector(prob.getProperty("NAME_SORT"))).click();
		    driver.findElement(By.cssSelector(prob.getProperty("ADD_TO_CART"))).click();

		    
		    driver.findElement(By.name(prob.getProperty("SEARCH_BAR"))).click();
		    driver.findElement(By.name(prob.getProperty("SEARCH_BAR"))).sendKeys("Mobile");
		    driver.findElement(By.xpath(prob.getProperty("SEARCH_BUTTON"))).click();
		    
		    
		    driver.findElement(By.name(prob.getProperty("DESCRIPTION"))).click();
		    driver.findElement(By.id(prob.getProperty("BUTTON_SEARCH"))).click();
		    driver.findElement(By.name(prob.getProperty("SEARCH_BAR"))).clear();
		    driver.findElement(By.name(prob.getProperty("SEARCH_BAR"))).click();
		    driver.findElement(By.name(prob.getProperty("SEARCH_BAR"))).sendKeys("Monitors");
		    driver.findElement(By.xpath(prob.getProperty("SEARCH_BUTTON"))).click();
		    driver.close();
	  }
	}