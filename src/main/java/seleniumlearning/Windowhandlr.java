package seleniumlearning;
import java.util.Set;

import org.openqa.selenium.chrome.ChromeDriver;

public class Windowhandlr {
	public static void main(String[] args) {
		/*Driver Initialization*/
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\drivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://legacy.crystalcruises.com/");
		String parentwin = driver.getWindowHandle();
		driver.findElementByLinkText("GUEST CHECK-IN").click();
		System.out.println("The current window handle id: "+driver.getWindowHandle());
		System.out.println("All window handles : "+driver.getWindowHandles().size()+ " "+driver.getWindowHandles());
		/*Capturing all the window handler in SET class*/
		Set<String> allwindow = driver.getWindowHandles();
		System.out.println("The present opened window count:"+allwindow.size()+"  "+driver.getWindowHandles());
		for(String eachwindow:allwindow)
		{
			System.out.println(eachwindow);
			driver.switchTo().window(eachwindow);
			
		}		
		//driver.get("https://checkin.crystalcruises.com/");
		driver.findElementByLinkText("FAQs").click();
		allwindow = driver.getWindowHandles();
		System.out.println("Windows opened currently:"+ driver.getWindowHandles().size());
		System.out.println("Current focused window:"+driver.getWindowHandle());
		System.out.println("List of opened windows"+driver.getWindowHandles());
		//driver.findElementByLinkText("GUEST CHECK-IN").click();
		allwindow = driver.getWindowHandles();
		for(String eachwindow:allwindow)
		{
			driver.switchTo().window(eachwindow);
		}
		System.out.println("Current window focus:"+ driver.getWindowHandle());	
		/*Jump to parent window*/
		driver.switchTo().window(parentwin);
		System.out.println(driver.getTitle());
		//driver.close();
		
	}

}
