package seleniumlearning;

import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alertsample 
{
	
	public static void main(String[] args) 
	{
		/*Initialize chrome driver*/
		System.setProperty("webdriver.chrome.driver",
				"D:\\Selenium\\drivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.irctc.co.in/eticketing/loginHome.jsf");
		System.out.println(driver.getTitle());
		
		//Alert block
		
		//driver.findElementById("loginbutton").click();	
		
		//SendKeys to hit ENTER
		driver.findElementById("loginbutton").sendKeys(Keys.RETURN);
		
		// This will close the Alert (The alert here is a simple alert)
		driver.switchTo().alert().accept();
		// After accepting the alert if we try to print the title of alert it shows No Alert present exception
		/*driver.switchTo().alert().getText();*/
		// Close the current browser
		/*driver.close();*/
		
		
		
	}}
	

