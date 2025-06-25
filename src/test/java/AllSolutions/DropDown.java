package AllSolutions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.AllureReport;

public class DropDown {
	WebDriver driver;

	@BeforeMethod
	public void Browser() {
		driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
	}

	@Test
	public void dropdown() {
		WebElement ele = driver.findElement(By.xpath("//h2[text()='Scrolling DropDown']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele);

		/* If the dropdown box in <div> tag we can get text by just simple List and
		   foreach loop.
		   
		   Here this dropdown box mentioned in <div> tag.*/
		driver.findElement(By.id("comboBox")).click();

		List<WebElement> options = driver.findElements(By.xpath("//div[@id='dropdown']/div[@class='option']"));
		System.out.println(options.size());

		for (WebElement option : options) {
			System.out.println(option.getText() + " ");
		}
	}

	@Test
	public void selectdropdown() {
		WebElement ele = driver.findElement(By.id("country"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele);

		
		/* If the dropdown box in <select> tag we must use Select class And by using its
		 * methods we can get all the options in that dropdown.
		 
		 * here this dropdown mentioned in <select> tag
		 */

		WebElement drop = driver.findElement(By.id("country"));

		Select select = new Select(drop);
		List<WebElement> options = select.getOptions();

		for (WebElement option : options) {
			System.out.println(option.getText());
		}
	}

	@AfterMethod
	public void close() {
		driver.close();
	}

	@AfterSuite(enabled = false)
	public void Allurereport() {
		AllureReport.openAllureReport();

	}

}
