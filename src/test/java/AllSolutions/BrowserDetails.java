package AllSolutions;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class BrowserDetails {

	WebDriver driver;
	
	@Test
	public void browser() 
	{
		driver=new ChromeDriver();
		
		    // Get browser capabilities
		    Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();
		   
		    System.out.println("Browser Name: " + caps.getBrowserName());
		    System.out.println("Browser Version: " + caps.getBrowserVersion());
		    System.out.println("Browser Capabilities: "+caps.getCapabilityNames());
		    System.out.println("Browser Platform: "+caps.getPlatformName());
		    
		    driver.close();
	}
	
}
