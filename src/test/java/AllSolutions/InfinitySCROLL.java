package AllSolutions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.AllureReport;

public class InfinitySCROLL {

	WebDriver driver;

	@BeforeMethod
	public void Browser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test
	public void InfinityScroll() throws InterruptedException {
		driver.get("http://the-internet.herokuapp.com/infinite_scroll");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		long lastHeight = (long) js.executeScript("return document.body.scrollHeight");
		while (true) {
			js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
			Thread.sleep(3000);
			long newHeight = (long) js.executeScript("return document.body.scrollHeight");
			if (newHeight == lastHeight) {
				break;
			}
			lastHeight = newHeight;
		}
		System.out.println("All content loaded.");

	}

	@Test
	public void InfinityScroll2() throws InterruptedException {
		// scrolling to a particular paragraph in infinityscroll page

		driver.get("http://the-internet.herokuapp.com/infinite_scroll");

		for (int i = 1; i <= 5; i++) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
			Thread.sleep(3000);
			System.out.println(i);
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
