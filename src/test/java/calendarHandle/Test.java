package calendarHandle;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test {
	public static String targetMonth = "January 2021";
	public static String targetDate = "Jan 09 2021";
	
	 
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://www.makemytrip.com");
		driver.findElement(By.xpath("//span[text() = 'DEPARTURE']")).click();
		//List<WebElement>all = driver.findElements(By.xpath("//div[contains(text(),'2020')]"));
		for(int i =0; i<12; i++) {
			WebElement all = driver.findElement(By.xpath("//div[@class ='DayPicker-Caption']"));
			String month = all.getText();
			System.out.println(month);
			if(!month.equalsIgnoreCase(targetMonth)) {
				driver.findElement(By.xpath("//span[@class = 'DayPicker-NavButton DayPicker-NavButton--next']")).click();				
			}else {
				//System.out.println("found");
				break;
			}

		}
		driver.findElement(By.xpath("//div[contains(@aria-label, '"+targetDate+"') and @class = 'DayPicker-Day']")).click();
	}

}
