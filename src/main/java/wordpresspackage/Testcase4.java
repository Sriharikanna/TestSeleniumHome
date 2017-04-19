package wordpresspackage;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Testcase4 extends BaseClass

{
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
  }

