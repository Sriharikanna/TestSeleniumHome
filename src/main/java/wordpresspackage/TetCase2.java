package wordpresspackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class TetCase2 {
	
	 WebDriver driver;
	 
	 @BeforeTest
	  public void beforeTest() throws Exception  {
		 
		  Reporter.log("*** Browser initalisation ***", true);
		  
		 
		  System.setProperty("webdriver.chrome.driver","D:\\SeleniumChrome\\chromedriver.exe");
			 driver = new ChromeDriver();
			 driver.get("http://demosite.center/wordpress/wp-login.php");
			 Thread.sleep(2000);
			 
			 Reporter.log("*** URL Launched ***", true);
	  }
	 
  @Test (priority=0)
  public void LoginCredentials () {
	  
	  Reporter.log("*** Enter Valid Credentials ***", true);
  
	  new Loginmethods(driver)
	  .EnterUsername("admin")
	  .EnterPassword("demo123")
	  .ClickLogin_Button();
	  Reporter.log("*** Login Successful ***", true);
	  
  }
  
  
  @Test (priority=1)
  
  public void createpostmethod ()
  {
	  Reporter.log("*** Create and save post ***", true);
	  
	  new Quickpostmethods(driver)
	  .EnterTitle("Test")
	  .Entercontent("Test")
	  .Entertagsinput("Test")
	  .savepost();
	  
	  Reporter.log("*** Post is saved ***", true);
  }
  
  
  
	  
	   

  @AfterTest
  public void afterTest() {
	  
	  driver.quit();
	  
	  Reporter.log("*** Browser Closed ***", true);
  }

}
