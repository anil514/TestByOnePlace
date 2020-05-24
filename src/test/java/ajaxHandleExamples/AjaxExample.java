package ajaxHandleExamples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AjaxExample {
	WebDriver driver;
	WebDriverWait wait;

	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx");		
	}

	@Test
	public void test_AjaxExample() {
		/*Wait for grid to appear*/
		By container = By.cssSelector(".demo-container");
		wait = new WebDriverWait(driver, 5);
		//wait.until(ExpectedConditions.presenceOfElementLocated(container));
		wait.until(ExpectedConditions.presenceOfElementLocated(container));

		/*Get the text before performing an ajax call*/
		WebElement noDatesTextElement = driver.findElement(By.xpath("//div[@class='RadAjaxPanel']/span"));
		String textBeforeAjaxCall = noDatesTextElement.getText().trim();
		System.out.println(textBeforeAjaxCall);

		/*Click on the date*/
		driver.findElement(By.linkText("1")).click();

		/*Wait for loader to disappear */
		// To find Press F8 or fn+F8 in keyword that will pause script execution
		By loader = By.className("raDiv");
		wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));

		/*Get the text after ajax call*/
		WebElement selectedDatesTextElement = driver.findElement(By.xpath("//div[@class='RadAjaxPanel']/span"));
		wait.until(ExpectedConditions.visibilityOf(selectedDatesTextElement));
		String textAfterAjaxCall = selectedDatesTextElement.getText().trim();
		System.out.println(textAfterAjaxCall);

		/*Verify both texts before ajax call and after ajax call text.*/
		Assert.assertNotEquals(textBeforeAjaxCall, textAfterAjaxCall);

		String expectedTextAfterAjaxCall = "Friday, May 1, 2020";

		/*Verify expected text with text updated after ajax call*/
		Assert.assertEquals(textAfterAjaxCall, expectedTextAfterAjaxCall);
	}
	
	@AfterMethod
	public void tearDoen() {
		driver.quit();
	}
}
