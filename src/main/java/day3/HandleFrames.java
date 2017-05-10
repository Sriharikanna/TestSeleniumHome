package day3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HandleFrames {
	public static void main(String[] args) throws InterruptedException {
		// Initialize the Driver path
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");

		// Launch/Initialize Browser
		// ClassName obj = new ClassName();
		ChromeDriver driver = new ChromeDriver();

		/*
		 * System.setProperty("webdriver.gecko.driver",
		 * "./drivers/geckodriver.exe");
		 * 
		 * //Launch/Initialize Browser //ClassName obj = new ClassName();
		 * FirefoxDriver driver = new FirefoxDriver();
		 */
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// Maximize the browser
		driver.manage().window().maximize();

		// Launch the URL
		driver.get("http://jqueryui.com/droppable/");

		WebElement demo = driver.findElementByClassName("demo-frame");

		driver.switchTo().frame(demo);

		System.out.println(driver.findElementByXPath("//*[@id='draggable']/p").getText());

		// Come out of the Frame
		driver.switchTo().defaultContent();

		driver.findElementByLinkText("Download").click();

	}
}
