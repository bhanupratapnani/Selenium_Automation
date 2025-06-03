package AllSolutions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.AllureReport;

public class Tables {

	WebDriver driver;

	@BeforeMethod
	public void Browser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test
	public void StaticTable() {

		driver.get("https://testautomationpractice.blogspot.com/");

		List<WebElement> col = driver.findElements(By.xpath("//table[@name='BookTable']/tbody/tr/td"));
		// storing webelements in an array by using List.

		System.out.println(col.size()); // by using this, we can get elements available in table.

		for (WebElement data : col) // by using foreach loop we can get the data in webelements.
		{
			System.out.println(data.getText());
		}
	}

	@Test
	public void DynamicTable() {
		// in dynamic table we will get different data at each time.
		// in static table we will same data at each time.

		driver.get("https://testautomationpractice.blogspot.com/");

		List<WebElement> col = driver.findElements(By.xpath("//table[@id='taskTable']/tbody/tr/td"));

		System.out.println(col.size());
		System.out.println("=========");

		for (WebElement cell : col) {
			System.out.println(cell.getText());
		}
		System.out.println();
	}

	@Test
	public void DynamicPaginationTable() throws InterruptedException {

		// dynamic pagination table will have data with multiple pages
		// so, we have to retrive all the data from all the pages

		driver.get("https://testautomationpractice.blogspot.com/");

		List<WebElement> rows;
		List<WebElement> cells;

		int totalPages = driver.findElements(By.xpath("//ul[@id='pagination']/li/a")).size();

		for (int page = 1; page <= totalPages; page++) {
			Thread.sleep(1000);

			rows = driver.findElements(By.xpath("//table[@id='productTable']/tbody/tr"));

			for (WebElement row : rows) {
				cells = row.findElements(By.tagName("td"));

				for (WebElement cell : cells) {
					System.out.print(cell.getText() + "\t");
				}
				System.out.println();
			}
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
