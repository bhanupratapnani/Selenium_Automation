package AllSolutions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.AllureReport;

public class MouseActions {

	Actions action;
	WebDriver driver;

	@BeforeMethod
	public void Browser() {
		driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
	}

	@Test
	public void doubleclick() {
		WebElement ele = driver.findElement(By.xpath("//h2[text()='Double Click']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele);

		action = new Actions(driver);
		WebElement Dclick = driver.findElement(By.xpath("//button[@ondblclick='myFunction1()']"));
		action.doubleClick(Dclick).build().perform();
		// In Actions we must and should mention .build().perform(); otherwise the code wouldn't run.
	}

	@Test
	public void contextclick() {
		WebElement ele = driver.findElement(By.xpath("//h2[text()='Double Click']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele);

		action = new Actions(driver);
		WebElement Cclick = driver.findElement(By.xpath("//button[@ondblclick='myFunction1()']"));
		action.contextClick(Cclick).build().perform();
	}

	@Test
	public void mouseover() {
		WebElement ele = driver.findElement(By.xpath("//h2[text()='Mouse Hover']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele);

		action = new Actions(driver);
		WebElement Mover = driver.findElement(By.xpath("//button[@class='dropbtn']"));
		action.moveToElement(Mover).build().perform();
	}

	@Test
	public void DragAndDrop() {
		WebElement ele = driver.findElement(By.xpath("//h2[text()='Drag and Drop']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele);

		WebElement drag = driver.findElement(By.xpath("//p[text()='Drag me to my target']"));
		WebElement drop = driver.findElement(By.xpath("//p[text()='Drop here']"));

		action = new Actions(driver);
		action.dragAndDrop(drag, drop).build().perform();
	}

	@Test
	public void slider() {
		WebElement ele = driver.findElement(By.xpath("//h2[text()='Slider']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele);

		WebElement slide = driver.findElement(By.xpath("(//span[@tabindex='0'])[1]"));

		action = new Actions(driver);

		action.clickAndHold(slide).moveByOffset(50, 0).release().perform();
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
