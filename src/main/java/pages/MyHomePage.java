package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.LeafTapsWrappers;

public class MyHomePage extends LeafTapsWrappers {
	public MyHomePage(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;

		if (!verifyTitle("My Home | opentaps CRM")) {
			reportStep("This is not Login Page", "FAIL");
		}
	}

	public CreateLeadPage clickCreateLeadLink() {
		clickByLink(prop.getProperty("MyHomePage.ClickCreateLead.Linktext"));
		return new CreateLeadPage(driver, test);
	}
}
