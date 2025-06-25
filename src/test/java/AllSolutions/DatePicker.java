package AllSolutions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.AllureReport;

public class DatePicker {

	WebDriver driver;

	@BeforeMethod
	public void Browser() {
		driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
	}

	// By using different methods we can choose date in datepickers.
	@Test
	public void date1() {
		// Here we are using general sendkeys method to enter date.
		WebElement date = driver.findElement(By.xpath("//input[@id='datepicker']"));
		date.sendKeys("12/12/2012");
		date.sendKeys(Keys.ENTER);
		
		driver.manage().logs().get(LogType.BROWSER).forEach(System.out::println);
	}

	@Test
	public void date2() {
		// Here we are using Select class to pick the month and year.
		// And click method to pick day.
		driver.findElement(By.xpath("//input[@id='txtDate']")).click();

		WebElement month = driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
		Select select = new Select(month);
		select.selectByVisibleText("Sep");

		WebElement year = driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
		Select select2 = new Select(year);
		select2.selectByVisibleText("2019");

		driver.findElement(By.xpath("//a[@data-date='9']")).click();
	}

	@Test
	public void date3() {
		// Here we are using JavascriptExecutor to enter date into input area.

		// For Start date.
		WebElement startdate = driver.findElement(By.id("start-date"));
		startdate.click();

		String datestarts = "2025-04-04";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value=arguments[1];", startdate, datestarts);
		
		// For End date.
		WebElement enddate = driver.findElement(By.id("end-date"));
		enddate.click();

		String dateends = "2025-05-05";
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].value=arguments[1];", enddate, dateends);

		// For Submit Button.
		driver.findElement(By.className("submit-btn")).click();
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
