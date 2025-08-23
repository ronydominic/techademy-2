package aug22;

import org.testng.annotations.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.openqa.selenium.support.PageFactory;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;

public class Lab16 {
	WebDriver driver;
	String projectpath = System.getProperty("user.dir");
  @Test(dataProvider = "dp")
  public void f(String firstname, String lastname, String email, String phone, String password, String confpass) {
  Lab16PageObjects obj =  PageFactory.initElements(driver,Lab16PageObjects.class );
  obj.accountreg();
  obj.registeruser(firstname, lastname, email, phone, password, confpass);
  obj.sucess();
  }
  @BeforeMethod
  public void beforeMethod() {
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
	  driver.get("https://tutorialsninja.com/demo/index.php?");
	  
  }

  @AfterMethod
  public void afterMethod() {
  }


  @DataProvider
  public Object[][] dp() throws ParserConfigurationException, SAXException, IOException {
	  String[][] data1 = new String[3][6];
	  File file=new File(projectpath+"\\userDataXML.xml");
	  DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	  DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	  Document doc = dBuilder.parse(file);
	  doc.getDocumentElement().normalize();
	  System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
	  
	  NodeList nList = doc.getElementsByTagName("user");
	  
	  for (int i = 0; i < nList.getLength(); i++) {
		     Node node = nList.item(i);
		 
		     if (node.getNodeType() == Node.ELEMENT_NODE) {
		         Element element = (Element) node;
		 
		        data1[i][0] = element.getElementsByTagName("firstname").item(0).getTextContent();
		        data1[i][1] = element.getElementsByTagName("lastname").item(0).getTextContent();
		        data1[i][2] = element.getElementsByTagName("email").item(0).getTextContent();
		        data1[i][3] = element.getElementsByTagName("phone").item(0).getTextContent();
		        data1[i][4] = element.getElementsByTagName("password").item(0).getTextContent();
		        data1[i][5] = element.getElementsByTagName("confpass").item(0).getTextContent();
		       
		         System.out.println("firstname: " +  data1[i][0]);
		         System.out.println("lastname: " +  data1[i][1]);
		         System.out.println("email: " +  data1[i][2]);
		         System.out.println("phone: " +  data1[i][3]);
		         System.out.println("password: " +  data1[i][4]);
		         System.out.println("confpass: " +  data1[i][5]);
		         
		     }
		}
	  
	  return data1;
    
  }
}