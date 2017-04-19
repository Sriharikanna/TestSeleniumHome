package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.LeafTapsWrappers;

public class ViewLeadPage extends LeafTapsWrappers {

	public ViewLeadPage(RemoteWebDriver driver, ExtentTest test) {

		this.driver =driver;
		this.test = test;
		if (!verifyTitle("View Lead | opentaps CRM")) {
			reportStep("The page you landed is not a CreateLead Page", "FAIL");
		}
	}
	
}
