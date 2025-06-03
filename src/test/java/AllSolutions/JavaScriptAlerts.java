package AllSolutions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.AllureReport;

public class JavaScriptAlerts {

	WebDriver driver;

	@BeforeMethod
	public void Browser() {
		driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
	}

	@Test
	public void SimpleAlert() {
		driver.findElement(By.id("alertBtn")).click();
		driver.switchTo().alert().accept();
	}

	@Test
	public void ConformationAlert() {
		driver.findElement(By.id("confirmBtn")).click();
		driver.switchTo().alert().accept();
	}

	@Test
	public void PromptAlert() {
		driver.findElement(By.id("promptBtn")).click();
		driver.switchTo().alert().sendKeys("Automation Tester");
		driver.switchTo().alert().accept();

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
