package AllSolutions;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import Base.AllureReport;

public class FileDownload {

	WebDriver driver;

	@Test
	public void DirectFileDownload() {
		
		//Basically downloading file is easy process as we just use click action.
		//due to the site design the code bacame such lengthy.
		//By just clicking on the download button we can directly download that file to the system.
		
		//Step 1: Opening browser & Entering into the Website.
		driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();

		//Step 2: Scrolling to the area where we need to Automation.
		WebElement ele = driver.findElement(By.xpath("//h2[text()='Footer Links']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele);
		
		//Step 3: Finding WebElements and by using click method download the file.
		driver.findElement(By.xpath("//a[text()='Download Files']")).click();

		driver.findElement(By.id("inputText"))
				.sendKeys("hi, Myself Bhanu pratap. i'm learning Web automation using selenium with Java");

		driver.findElement(By.id("generateTxt")).click();

		driver.findElement(By.id("txtDownloadLink"));

		driver.findElement(By.id("pdfDownloadLink"));
	}

	@Test
	public void BrowserFileDownload() throws InterruptedException {

		String downloadPath = "C:\\Users\\ASUS\\Downloads"; // pdf download location,

		ChromeOptions options = new ChromeOptions(); // Configure Chrome options to control chrome.

		// we have to set preferences for PDF downloading.
		Map<String, Object> prefs = new HashMap<>();
		prefs.put("download.default_directory", downloadPath);
		prefs.put("download.prompt_for_download", false);
		prefs.put("plugins.always_open_pdf_externally", true); // This will disable PDF viewer in browser

		options.setExperimentalOption("prefs", prefs);

		driver = new ChromeDriver(options); // Initialize WebDriver with options

		try {

			driver.get("https://testautomationpractice.blogspot.com/");

			WebElement ele = driver.findElement(By.xpath("//h2[text()='Footer Links']"));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", ele);

			driver.findElement(By.xpath("//a[text()='Download Files']")).click();

			driver.findElement(By.xpath("//button[text()='Download PDF File']")).click();

			Thread.sleep(5000); // Wait for download to complete.

		} catch (Exception e) {
			e.printStackTrace();
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
