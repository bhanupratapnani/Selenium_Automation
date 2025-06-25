package AllSolutions;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class ChromeoptionsTypes {

	@Test
	public void Headless() {

		/*
		 * When to Use Headless?
		 * 
		 * 1.Running tests in CI/CD (e.g., Jenkins, GitHub Actions).
		 * 
		 * 2.Faster execution (no GUI rendering).
		 * 
		 * 3.Scraping data without visual interference.
		 */

		ChromeOptions options = new ChromeOptions();

		options.addArguments("--headless=new"); // Selenium 4.8+ (new headless mode)
		options.addArguments("--window-size=1920,1080"); // Set aspect ratio

		WebDriver driver = new ChromeDriver(options);

		driver.get("https://testautomationpractice.blogspot.com/");

		WebElement date = driver.findElement(By.xpath("//input[@id='datepicker']"));
		date.sendKeys("12/12/2012");
		date.sendKeys(Keys.ENTER);
	}

	@Test
	public void incognito() {

		// to change browser into incognito mode.

		ChromeOptions options = new ChromeOptions();

		options.addArguments("--incognito");

		WebDriver driver = new ChromeDriver(options);

		driver.get("https://testautomationpractice.blogspot.com/");

		WebElement date = driver.findElement(By.xpath("//input[@id='datepicker']"));
		date.sendKeys("12/12/2012");
		date.sendKeys(Keys.ENTER);
	}

	@Test
	public void AutomationDialogue() {

		ChromeOptions options = new ChromeOptions();

		// To remove "this browser is automating" message.

		options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
		options.setExperimentalOption("useAutomationExtension", false);
		
		WebDriver driver = new ChromeDriver(options);

		driver.get("https://testautomationpractice.blogspot.com/");

		WebElement date = driver.findElement(By.xpath("//input[@id='datepicker']"));
		date.sendKeys("12/12/2012");
		date.sendKeys(Keys.ENTER);
	}

	@Test
	public void DisablePopups() {

		// Create preferences map
		Map<String, Object> prefs = new HashMap<>();

		// 1 = Allow, 2 = Block
		prefs.put("profile.default_content_setting_values.popups", 2);

		// Add preferences to ChromeOptions
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);

		// Launch Chrome with options
		WebDriver driver = new ChromeDriver(options);

		// Open a test page
		driver.get("https://practice.expandtesting.com/");

	}
	@Test
	public void BrowserMaximiseAtStart() 
	{
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		
		WebDriver driver = new ChromeDriver(options);
		
		driver.get("https://blazedemo.com/login");
	}
	@Test
	public void All() 
	{
		ChromeOptions options=new ChromeOptions();			//Gets all methods of ChromeOptions.
		
		options.addArguments("--start-maximized");			//Maximises window.
//		options.addArguments("--headless");					//Makes headless operation.
		options.addArguments("--incognito");					//Runs in incognito mode.
		options.addArguments("--disable-notifications");		//Disables notifications.
		
		options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
		options.setExperimentalOption("useAutomationExtension", false);  //no automation dialogue box.
		
		WebDriver driver = new ChromeDriver(options);		//Opens browser with ChromeOptions features.

		driver.get("https://testautomationpractice.blogspot.com/");

		WebElement date = driver.findElement(By.xpath("//input[@id='datepicker']"));
		date.sendKeys("12/12/2012");
		date.sendKeys(Keys.ENTER);

	}

}
