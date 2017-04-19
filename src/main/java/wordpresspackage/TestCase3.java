package wordpresspackage;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestCase3 extends BaseClass
{
  @Test
  public void VerifyValidCredentials () 
  
  {
	  
	  Reporter.log("*** Enter Valid Credentials ***", true);
	  
	  new Loginmethods(driver)
	  .EnterUsername("admin")
	  .EnterPassword("demo123")
	  .ClickLogin_Button();
	  
	  Reporter.log("*** Login Successful ***", true);
}
  
}
