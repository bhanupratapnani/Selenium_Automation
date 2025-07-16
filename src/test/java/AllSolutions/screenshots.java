package AllSolutions;

import java.io.File;
import java.io.IOException;
import java.time.LocalTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import Base.AllureReport;

public class screenshots {

	WebDriver driver;

	@BeforeMethod
	public void Browser() {
		driver = new ChromeDriver();
		driver.get("https://blazedemo.com/login");
		driver.manage().window().maximize();
	}

	@Test
	public void screenshotByTime() throws IOException {

		String name = LocalTime.now().toString().substring(9, 12);
		System.out.println(name);
		// we can use "name" as input to screenshot name.

		TakesScreenshot tk = (TakesScreenshot) driver;
		File f = tk.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(f, new File("./screenshots/" +name+ ".png"));
	}
	
	@Test
	public void screenshotByFaker() throws IOException 
	{
		Faker fa = new Faker();
		System.out.println(fa.animal().name());
		/* by using faker class we can use its methods to 
		   automatically generate names
		   for our screenshot name.  */
		
		TakesScreenshot tk = (TakesScreenshot) driver;
		File f = tk.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(f, new File("./screenshots/" + fa.funnyName().name() + ".png"));
	}
	
	@Test
	public void screenshot(String name) throws IOException 
	{
		// By using DataTypes we can manually assaign names for screenshots
		TakesScreenshot tk = (TakesScreenshot) driver;
		File f = tk.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(f, new File("./screenshots/" +name+ ".png"));	
	}
	
	@Test
	public void screenshot2(String filename) throws IOException 
	{
		TakesScreenshot tk = (TakesScreenshot) driver;
		File Source = tk.getScreenshotAs(OutputType.FILE);
		File Destination = new File("./screenshots/" +filename+ ".png");
		FileUtils.copyFile(Source, Destination);
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
