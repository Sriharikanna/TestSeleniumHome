package day1;

import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {
	public static void main(String[] args) {
		//Initialize the Driver path
		System.setProperty("webdriver.chrome.driver",
				"./drivers/chromedriver.exe");
		//Launch/Initialize Browser
		//ClassName obj = new ClassName();
		ChromeDriver driver = new ChromeDriver();
		//Launch the URL
		driver.get("http://leaftaps.com");
		//Maximize the browser
		Options opt = driver.manage();
		Window wn = opt.window();		
		wn.maximize();
		
		
		//.window().maximize();
		
		//Enter User Name
		WebElement txt = driver.findElementById("username");
		txt.sendKeys("DemoSalesManager");
		
		//.sendKeys("DemoSalesManager");
		//Enter Password
		driver.findElementById("password").sendKeys("crmsfa");
		//Click Login
		driver.findElementByClassName("decorativeSubmit").click();
		//Click CRM/SFA
		driver.findElementByLinkText("CRM/SFA").click();
		
		//Using Xpath
		//driver.findElementByXPath("//*[@id='sectionHeaderTitle_myHome']");
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
