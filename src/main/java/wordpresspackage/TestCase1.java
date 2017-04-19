package wordpresspackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class TestCase1 
{
    
 WebDriver driver;
  
  @BeforeTest
  
  
  public void beforeMethod() throws Exception {
	  
	  Reporter.log("*** Browser initalisation ***", true);
	  
	  System.setProperty("webdriver.chrome.driver","D:\\SeleniumChrome\\chromedriver.exe");
		 driver = new ChromeDriver();
		 driver.get("http://demosite.center/wordpress/wp-login.php");
		 Thread.sleep(2000);
		 
		 Reporter.log("*** URL Launched ***", true);
  }
  
  @Test
  public void Logincredentials ()  {
	  
	  Reporter.log("*** Enter Valid Credentials ***", true);
	  
	  new Loginmethods(driver)
	  .EnterUsername("admin")
	  .EnterPassword("demo123")
	  .ClickLogin_Button();
	  
	  Reporter.log("*** Login Successful ***", true);
}

  @AfterTest
  public void afterMethod() {
  
	
	  
  driver.quit();
  
  Reporter.log("*** Browser Closed ***", true);
  
 
  }
  
}
