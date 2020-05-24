package jdk1_8_WithSelenium;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RetrievingTextFromAListOfWebElements {
	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@Test
	public void traditionalWay() {
		List<WebElement> allProductNameElement = driver.findElements(By.xpath("//ul[contains(@class,'active')]//a[@class='product-name']"));
		// Print count of product found
		System.out.println("Total product found : "+allProductNameElement.size());
		// Logic to iterate webelement to retrieve text and store
		List<String> allProductNames = new ArrayList<>();
		for(WebElement ele:allProductNameElement ) {
			String name = ele.getText().trim();
			allProductNames.add(name);
		}

		// Printing product names
		System.out.println("All product names are : ");
		for(String s :allProductNames)
		{
			System.out.println(s);
		}
	}


	@Test
	public void RetrieveTextFromListOfElementUsingStreamAPI() {
		List<String> allProductNames = new ArrayList<>();
		// Locating all product names at home page
		/*
		 * We do not need to store list of web elements as well. We can get the stream of found web elements
		 * and apply aggregate function forEach(). Logic behind forEach is to get the text of each web element
		 * and add to list. We are using lambda expression inside forEach.  
		 */
		driver.findElements(By.xpath("//ul[contains(@class,'active')]//a[@class='product-name']"))
		.stream()
		.forEach(product -> System.out.println(allProductNames.add(product.getText())));
		// Print count of product found
		System.out.println("Total product found : "+allProductNames.size());
		// Printing product names
		System.out.println("All product names are : ");
		allProductNames.forEach(name -> System.out.println(name));

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
