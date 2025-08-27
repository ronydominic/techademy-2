package aug26Questions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Q9ScreenShotObject {
	WebDriver driver;
	
	public Q9ScreenShotObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void takeScreenShot() throws IOException {
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("homepage.png"));
	}
}
