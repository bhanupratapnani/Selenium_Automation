package AllSolutions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.AllureReport;

public class ShadowDOM {

	WebDriver driver;

	@BeforeMethod
	public void Browser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test
	public void shadowdom() throws InterruptedException {
		// by using normal xpaths we cant find shadowDOM elements
		// so, by using css selectors and SearchContext interface we can automate
		// shadowDOM elements.

		driver.get("https://testautomationpractice.blogspot.com/");

		WebElement ele = driver.findElement(By.xpath("//*[@id=\"HTML16\"]/h2"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele);

		WebElement shadow = driver.findElement(By.cssSelector("#shadow_host"));
		SearchContext shadowRoot = shadow.getShadowRoot();

		shadowRoot.findElement(By.cssSelector("input[type='checkbox']")).click();

		shadowRoot.findElement(By.cssSelector("input[type='text']")).sendKeys("namastheee");

		shadowRoot.findElement(By.cssSelector("input[type='file']"))
				.sendKeys("C:\\Users\\ASUS\\Desktop\\damage\\image1.jpg");

		driver.findElement(By.partialLinkText("Youtube")).click();

		driver.navigate().back();

	}

	@AfterMethod
	public void close() {
		driver.close();
	}

	@AfterSuite
	public void Allurereport() {
		AllureReport.openAllureReport();
	}
}
