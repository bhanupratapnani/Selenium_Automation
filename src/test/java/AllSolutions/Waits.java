package AllSolutions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.AllureReport;

public class Waits {
	WebDriver driver;

	@BeforeMethod
	public void Browser() {
		driver = new ChromeDriver();
		driver.get("https://blazedemo.com/login");
		driver.manage().window().maximize();
	}

	@Test
	public void implicitwait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	//implicit wait

		driver.findElement(By.id("email")).sendKeys("yourgmailid@gmail.com");	//username
		driver.findElement(By.id("password")).sendKeys("aleluyaaaaaa");	//password
		driver.findElement(By.className("btn btn-primary")).click();	//login button
	}
	
	//	implicit wait will apply on all element available in a class
	//	explicit wait will work with only one element which is mentioned in it.
	//	fluent wait also applies on a particular webelement and also we can iterate that action.
	
	@Test
	public void explicitwait() {

		driver.findElement(By.id("email")).sendKeys("yourgmailid@gmail.com");		//username

		WebDriverWait expli = new WebDriverWait(driver, Duration.ofSeconds(5));	//explicit wait on password
		expli.until(ExpectedConditions.presenceOfElementLocated(By.id("password"))).sendKeys("beuefifdjcwicjnwei");

		driver.findElement(By.className("btn btn-primary")).click();	//login button
	}

	@Test
	public void fluentwait() {
		
		driver.findElement(By.id("email")).sendKeys("yourgmailid@gmail.com");	//username
		driver.findElement(By.id("password")).sendKeys("aleluyaaaaaa");	//password
		
		FluentWait<WebDriver> flue = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(5));	//fluent wait on login button
		flue.until(ExpectedConditions.presenceOfElementLocated(By.className("btn btn-primary"))).click();
		
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
