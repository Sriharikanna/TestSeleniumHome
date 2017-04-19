package wordpresspackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


public class BaseClass {
	  WebDriver driver;
	  
  @BeforeClass
  @Parameters("browser")
  public void Multibrowserinitalisation (String BrowserName) throws Exception {
	  
	if (BrowserName.equalsIgnoreCase("ie"))
					{

		  Reporter.log ("****IE Browser initialisation****", true);
		System.setProperty("webdriver.ie.driver","D:\\SeleniumIE\\IEDriverServer.exe");	
		 driver =  new InternetExplorerDriver();
		 Thread.sleep(5000);
		 Reporter.log ("****IE Browser Launched ****", true);
			}
	
	else if (BrowserName.equalsIgnoreCase("chrome"))
	{
	  
	  Reporter.log ("****Chrome Browser initialisation****", true);
	  System.setProperty("webdriver.chrome.driver","D:\\Selenium\\drivers\\chromedriver.exe");
	 driver = new ChromeDriver();
	 Thread.sleep(5000);
	 Reporter.log ("****Chrome Browser  launched****", true); 
	}
	
	Reporter.log("*** MAXIMIZE WINDOW and Launching url ***", true);
	 
	driver.manage().window().maximize();
	 driver.get("http://demosite.center/wordpress/wp-login.php");
	 Thread.sleep(2000);
	 
		Reporter.log("*** URL LAUNCHED  ***", true);
	}
  

  @AfterClass
  public void afterMethod() {
	  	
	  driver.close();
	  Reporter.log ("****Browser close ****", true);
  }

}
