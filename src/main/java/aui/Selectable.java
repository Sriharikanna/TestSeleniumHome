package aui;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Selectable {

	public static void main(String[] args) throws InterruptedException {

		//		FirefoxDriver driver = new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();

		// Navigate to the url
		driver.get("http://jqueryui.com/selectable/");

		// Maximize the browser
		driver.manage().window().maximize();

		// Set default waiting time for finding an element (after the page loads)
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);		

		WebElement frame = driver.findElementByClassName("demo-frame");

		driver.switchTo().frame(frame);

		
		WebElement item1 = driver.findElementByXPath("//li[text()='Item 1']");

		WebElement item4 = driver.findElementByXPath("//li[text()='Item 4']");

		Actions builder = new Actions(driver);
		builder.clickAndHold(item1)
		.clickAndHold(item4)
		.release()
		.build()
		.perform();
		
		
	}

}































