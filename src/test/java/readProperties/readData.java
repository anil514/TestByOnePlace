package readProperties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class readData {
	//public static String path = System.getProperty("user.dir");
	public static String path = System.getProperty("user.dir");
	public static Properties prop;
	public static WebDriver driver;

	public static void main(String[] args) {
		prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream(path+"\\src\\test\\java\\readProperties\\config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		//System.setProperty("webdriver.chrome.driver", path+"\\Drivers\\chromedriver.exe");
		//driver = new ChromeDriver();
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		//WebDriverManager.firefoxdriver().setup();
		//ChromeOptions options = new ChromeOptions();
		//options.setPageLoadStrategy(PageLoadStrategy.EAGER);
		//driver = new FirefoxDriver();
		driver.get(prop.getProperty("url"));
		System.out.println(driver.getTitle());
		driver.close();

	}

}
