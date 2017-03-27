package oops;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TakeSnap {
	public static void main(String[] args) throws InterruptedException, IOException {
		//Initialize the Driver path
		System.setProperty("webdriver.chrome.driver",
				"./drivers/chromedriver.exe");

		//Launch/Initialize Browser
		//ClassName obj = new ClassName();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//Maximize the browser
		driver.manage().window().maximize();

		//Launch the URL
		driver.get("http://legacy.crystalcruises.com/");

		File src = 	driver.getScreenshotAs(OutputType.FILE);
		File destFile = new File("./snaps/snap1.jpg");
		FileUtils.copyFile(src, destFile);
		
		
		// click link
		driver.findElementByLinkText("GUEST CHECK-IN").click();

		Set<String> allWindow = driver.getWindowHandles();

		System.out.println(allWindow.size());

		System.out.println(driver.getTitle());

		// Switch to 2nd wimdow
		for (String eachWindow : allWindow) {

			System.out.println(eachWindow);	

			driver.switchTo().window(eachWindow);


		}	
		
		src = 	driver.getScreenshotAs(OutputType.FILE);
		destFile = new File("./snaps/snap2.jpg");
		FileUtils.copyFile(src, destFile);
		System.out.println(driver.getTitle());

		// Click here opens the 3rd window
		driver.findElementByLinkText("click here").click();

		allWindow = driver.getWindowHandles();

		// move to third window
		for (String eachWindow : allWindow){
			driver.switchTo().window(eachWindow);
		}	
		
		src = 	driver.getScreenshotAs(OutputType.FILE);
		destFile = new File("./snaps/snap3.jpg");
		FileUtils.copyFile(src, destFile);
		System.out.println(driver.getTitle());






































	}
}
