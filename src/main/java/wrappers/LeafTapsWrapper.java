package wrappers;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class LeafTapsWrapper extends GenericWrappers {
	@Parameters({"browser", "appURL", "userName", "password"})
	@BeforeMethod()
	public void login(@Optional ("chrome")String browser, String url, String uName, String pwd) throws Exception {
		invokeApp(browser, url);
		enterById("username", uName);
		enterById("password", pwd);
		clickByClassName("decorativeSubmit");
		clickByLink("CRM/SFA");
		
		
		
		
		
		
		
		
		
	}
	
	@AfterMethod()
	public void closeBrowser(){
		quitBrowser();
	}
}
