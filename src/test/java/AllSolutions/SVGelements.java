package AllSolutions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.AllureReport;

public class SVGelements {

	WebDriver driver;

	@BeforeMethod
	public void Browser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test
	public void svgelements() {
		driver.get("https://testautomationpractice.blogspot.com/");

		WebElement svg = driver.findElement(By.xpath("//h2[text()='SVG Elements']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", svg);

		WebElement red = driver.findElement(By.xpath("//*[name()='circle' and @fill='red']"));
		WebElement green = driver.findElement(By.xpath("//*[name()='rect' and @fill='green']"));
		WebElement blue = driver.findElement(By.xpath("//*[name()='polygon' and @fill='blue']"));

		System.out.println("red " + (red != null));
		System.out.println("green " + (green != null));
		System.out.println("blue " + (blue != null));

		System.out.println(red.getSize());
		System.out.println(green.getSize());
		System.out.println(blue.getSize());

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
