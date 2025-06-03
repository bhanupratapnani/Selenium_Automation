package AllSolutions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.AllureReport;

public class FileUpload {

	WebDriver driver;

	@BeforeMethod
	public void Browser() {
		driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
	}

	@Test
	public void SingleFileUpload() 
	{
		WebElement file=driver.findElement(By.xpath("(//input[@type='file'])[1]"));
		
		file.sendKeys("C:\\Users\\ASUS\\Desktop\\damage\\Computer-test-keyboard.jpg");
		
		driver.findElement(By.xpath("//button[text()='Upload Single File']")).click();
	}
	
	@Test
	public void MultipleFileUpload() 
	{
		WebElement files = driver.findElement(By.xpath("(//input[@type='file'])[2]"));

		//By storing file paths in string we can upload multiple files at a time.
        String filePath1 = "C:\\Users\\ASUS\\Desktop\\damage\\Computer-test-keyboard.jpg";
        String filePath2 = "C:\\Users\\ASUS\\Desktop\\damage\\th.jpg";
        
        files.sendKeys(filePath1 + "\n" + filePath2);  // /n => new line

        driver.findElement(By.xpath("//button[text()='Upload Multiple Files']")).click(); 	
	}

	@AfterMethod
	public void close() {
		driver.close();
	}

	@AfterSuite(enabled=false)
	public void Allurereport() {
		AllureReport.openAllureReport();

	}	
	

}
