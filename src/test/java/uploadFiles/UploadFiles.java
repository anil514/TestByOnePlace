package uploadFiles;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UploadFiles {
	public static String path = System.getProperty("user.dir");
	@Test
	public void uploadFile1() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.naukri.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement upload = driver.findElement(By.cssSelector("#file_upload"));	
		upload.sendKeys(path+"\\src\\test\\java\\uploadFiles\\Files\\pic.png");
		String errorText = driver.findElement(By.cssSelector(".error-header .error")).getText();
		System.out.println(errorText);
		driver.close();
	}

	@Test
	 void headLessMode() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions op = new ChromeOptions();
		//op.setHeadless(true);
		//op.addArguments("headless");
		op.addArguments("--headless", "--disable-gpu", "--window-size=1250,700","--ignore-certificate-errors");
       // op.addArguments("window-size=1200x600");
		WebDriver driver = new ChromeDriver(op);	
		//driver.manage().window().maximize();
		driver.get("https://www.naukri.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println(driver.getTitle());
		WebElement upload = driver.findElement(By.cssSelector("#file_upload"));	
		upload.sendKeys(path+"\\src\\test\\java\\uploadFiles\\Files\\pic.png");
		String errorText = driver.findElement(By.cssSelector(".error-header .error")).getText();
		System.out.println(errorText);
		driver.close();
	}

}
