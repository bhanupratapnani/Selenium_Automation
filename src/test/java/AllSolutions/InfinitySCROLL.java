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
		driver.get("http://the-internet.herokuapp.com/infinite_scroll");
		driver.manage().window().maximize();
	}

	@Test
	public void InfinityScroll() throws Exception {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		long lastHeight = (long) js.executeScript("return document.body.scrollHeight");
		while (true) {
			// this scroll command will scroll untill the page end.
			js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
			Thread.sleep(3000);
			long newHeight = (long) js.executeScript("return document.body.scrollHeight");
			if (newHeight == lastHeight) {
				break;
			}
			lastHeight = newHeight;

			// = Assaign a value. (Assignment Operator)
			// == Compares the values. (Equality Operator)
		}
		System.out.println("All content loaded.");
	}

	@Test
	public void InfinityScroll2() throws Exception {
		
		// scrolling to a particular paragraph in infinityscroll page
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

	@AfterSuite
	public void Allurereport() {
		AllureReport.openAllureReport();

	}
}
