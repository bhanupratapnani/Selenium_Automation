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

public class IFrame {
	WebDriver driver;

	@BeforeMethod
	public void Browser() {
		driver = new ChromeDriver();
		driver.get("https://practice.expandtesting.com/iframe");
		driver.manage().window().maximize();
	}
	@Test
	public void frame() 
	{
		//it will switch to iframe, in frame brackets we should mention id of the that iframe.
		driver.switchTo().frame("mce_0_ifr");	
		
		WebElement ele=driver.findElement(By.id("tinymce"));	//enters into frame
		
		ele.clear();
		ele.sendKeys("Automation Testing");
		
		driver.switchTo().defaultContent();	//exit from frame
		
		WebElement ele2=driver.findElement(By.xpath("//*[h4]"));

		System.out.println("footer: "+ele2.getText());
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
