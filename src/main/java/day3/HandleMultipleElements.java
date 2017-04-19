package day3;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HandleMultipleElements {
	
	public static void main(String[] args) throws InterruptedException {
		
		//Initialize the Driver path
		System.setProperty("webdriver.chrome.driver",
				"./drivers/chromedriver.exe");

		// Launch browser
		ChromeDriver driver = new ChromeDriver();

		//Maximize the browser
		driver.manage().window().maximize();

		//Launch the URL
		driver.get("http://legacy.crystalcruises.com/Calendar.aspx");

		// Get all Get A Quote links
		List<WebElement> allQuote= driver.findElementsByLinkText("Get-a-Quote");
		
		// Find the Size
		
		System.out.println(allQuote.size());
		
		// Click on the 4th link
		
		allQuote.get(3).click();
		
		
		
		
	}
}
