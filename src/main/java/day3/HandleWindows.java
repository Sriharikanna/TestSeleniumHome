package day3;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HandleWindows {
	public static void main(String[] args) throws InterruptedException {
		//Initialize the Driver path
		System.setProperty("webdriver.chrome.driver",
				"./drivers/chromedriver.exe");

		//Launch/Initialize Browser
		//ClassName obj = new ClassName();
		ChromeDriver driver = new ChromeDriver();

		/*System.setProperty("webdriver.gecko.driver",
				"./drivers/geckodriver.exe");

		//Launch/Initialize Browser
		//ClassName obj = new ClassName();
		FirefoxDriver driver = new FirefoxDriver();*/
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//Maximize the browser
		driver.manage().window().maximize();

		//Launch the URL
		driver.get("http://legacy.crystalcruises.com/");
		
		// click link
		driver.findElementByLinkText("GUEST CHECK-IN").click();
		
		Set<String> allWindow = driver.getWindowHandles();
		
		System.out.println(allWindow.size());
		
		System.out.println(driver.getTitle());
		
		for (String eachWindow : allWindow) {
			
			System.out.println(eachWindow);	
			
			driver.switchTo().window(eachWindow);
			
			
		}		
		System.out.println(driver.getTitle());
		
		driver.findElementByLinkText("click here").click();
		
		System.out.println(allWindow.size());
		
		allWindow = driver.getWindowHandles();
		
		System.out.println(allWindow.size());
		
		System.out.println(driver.getTitle());
	
		int i=1;
		for (String eachWindow : allWindow) {
			
			System.out.println(eachWindow);	
			
			driver.switchTo().window(eachWindow);
			if(i==1){
				break;
			}
			i++;
			
		}		
		System.out.println(driver.getTitle());
		
	//	driver.quit();
		
	//	foreach
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		














	}
}
