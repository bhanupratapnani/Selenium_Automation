package Base;

import java.io.File;
import java.io.IOException;
import java.time.LocalTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TakeScreenshot {
	
	public static WebDriver driver;

	public static void screenshot(String name) throws IOException {
		
		TakesScreenshot tk=(TakesScreenshot) driver;
		File f=tk.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(f, new File("./screenshots/"+name+".png"));
	}
	
	public static void screenshot() throws IOException {
		
		String name=LocalTime.now().toString().substring(9, 15);
		
		TakesScreenshot tk=(TakesScreenshot)driver;
		File f=tk.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(f, new File("./screenshots/"+name+".png"));
	}

}
