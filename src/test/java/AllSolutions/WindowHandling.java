package AllSolutions;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.AllureReport;

public class WindowHandling {
	WebDriver driver;

	@BeforeMethod
	public void Browser() {
		driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
	}

	@Test
	public void nextwindow() throws InterruptedException {
		
		driver.findElement(By.xpath("//button[text()='New Tab']")).click();

		String cw = driver.getWindowHandle();

		Set<String> windows = driver.getWindowHandles();

		List<String> list = new ArrayList<>(windows);

		for (int i = 1; i < list.size(); i++) {

			String nw = list.get(i);

			driver.switchTo().window(nw);

			Thread.sleep(3000);

//			driver.switchTo().window(cw);

			System.out.println(cw);
			System.out.println(nw);
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
