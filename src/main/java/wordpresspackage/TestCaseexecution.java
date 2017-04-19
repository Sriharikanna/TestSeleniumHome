package wordpresspackage;


import org.testng.annotations.Test;

public class TestCaseexecution extends BaseClass {
	

	

  @Test (priority=0)
  public void Loginintotheapplication () {
	  
	 new WrapperClass(driver)
	 .enterusername("admin")
	 .enterpass("demo123")
	 .clickloginbutton();
	 
	
  }
  
  @Test (priority=1)
  
  public void Createpost ()
  {
	  new WrapperClass(driver)
	 .entertitle("Test automation")
	  .entercontent("TestAutomation")
	 .entertag("First")
	 .savepost();
	  
	 
  }
	  
	  
	  
  
}
