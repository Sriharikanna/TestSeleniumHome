package day3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HandleAlert {
	public static void main(String[] args) throws InterruptedException {
		//Initialize the Driver path
		System.setProperty("webdriver.chrome.driver",
				"D:\\Selenium\\drivers\\chromedriver.exe");

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
		driver.get("https://www.irctc.co.in/eticketing/loginHome.jsf");
		
		driver.findElementById("loginbutton").click();
		
		/*Alert  alt = driver.switchTo().alert();
		
		System.out.println(alt.getText());
		
		alt.accept();*/
		
		System.out.println(driver.getTitle());
		
		driver.close();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		














	}
}
