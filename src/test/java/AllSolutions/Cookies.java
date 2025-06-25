package AllSolutions;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.AllureReport;

public class Cookies {
	
	WebDriver driver;

	@BeforeMethod
	public void Browser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	@Test
	public void cookie() 
	{
		driver.get("https://practice.expandtesting.com/");
		
		Set<Cookie> cookies = driver.manage().getCookies();
	
		for (Cookie cookie : cookies) {
		    System.out.println("Cookie Name: " + cookie.getName());
		    System.out.println("Cookie Value: " + cookie.getValue());
		    System.out.println("Domain: " + cookie.getDomain());
		    System.out.println("Path: " + cookie.getPath());
		    System.out.println("Expiry: " + cookie.getExpiry());
		    System.out.println("Is Secure: " + cookie.isSecure());
		    System.out.println("Is HttpOnly: " + cookie.isHttpOnly());
		    System.out.println("-----------------------------------");
		}
	}

	@AfterMethod
	public void close() {
		driver.close();
	}

	@AfterSuite(enabled=true)
	public void Allurereport() {
		AllureReport.openAllureReport();
	}

}
