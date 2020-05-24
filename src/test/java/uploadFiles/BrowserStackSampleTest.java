package uploadFiles;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BrowserStackSampleTest {
	public static String path = System.getProperty("user.dir");
	public static final String USERNAME = "anil689";
	public static final String AUTOMATE_KEY = "y7VmyckNGKCMssyp4xhm";
	public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
	public static void main(String[] args) throws Exception {
		DesiredCapabilities caps = new DesiredCapabilities();

		caps.setCapability("os", "Windows");
		caps.setCapability("os_version", "7");
		caps.setCapability("browser", "Chrome");
		caps.setCapability("browser_version", "81");

		caps.setCapability("name", "anil689's First Test");

		WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
		driver.get("https://www.naukri.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement upload = driver.findElement(By.cssSelector("#file_upload"));	
		LocalFileDetector detector = new LocalFileDetector();
		((RemoteWebElement)upload).setFileDetector(detector);
		upload.sendKeys(path+"\\src\\test\\java\\uploadFiles\\Files\\pic.png");
		String errorText = driver.findElement(By.cssSelector(".error-header .error")).getText();
		System.out.println(errorText);
		driver.quit();
	}
}
