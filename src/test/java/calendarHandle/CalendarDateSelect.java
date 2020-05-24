package calendarHandle;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalendarDateSelect {
	public static WebDriver driver;
	static String date = "Jul 21 2020";
	static String month = "May";

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.get("https://www.makemytrip.com");
		//String target = driver.findElement(By.xpath("//div[contains(@aria-label, 'Jul 21 2020') and @class = 'DayPicker-Day']")).getText();
		
		
		
		driver.findElement(By.xpath("//span[text() = 'DEPARTURE']")).click();
		String givenMonth = driver.findElement(By.xpath("//div[contains(text(),'May 2020')]")).getText();
		//List<WebElement>all = driver.findElements(By.xpath("//div[contains(text(),'2020')]"));
		//System.out.println(all.size());
	//	List<WebElement>allDates = driver.findElements(By.xpath("//div[@class = 'dateInnerCell']"));
		//System.out.println(allDates.size());
		
		if(!givenMonth.equalsIgnoreCase(month)) {
			driver.findElement(By.xpath("//span[@class = 'DayPicker-NavButton DayPicker-NavButton--next']")).click();
			driver.findElement(By.xpath("//div[contains(@aria-label, 'Jul 21 2020') and @class = 'DayPicker-Day']")).click();
		}else {
			driver.findElement(By.xpath("//div[contains(@aria-label, 'Jun 21 2020') and @class = 'DayPicker-Day']")).click();
		}

	}	

}
