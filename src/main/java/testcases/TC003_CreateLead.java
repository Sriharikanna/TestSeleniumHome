package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.LoginPage;
import wrappers.LeafTapsWrappers;

public class TC003_CreateLead extends LeafTapsWrappers {

	@BeforeClass
	public void setData() {
		testCaseName = "CreateLead";
		testDescription = "Creating Lead...";
		browserName = "chrome";
		dataSheetName = "TC003";
		category = "Sanity";
		authors = "Srihari M";
	}

	@Test(dataProvider = "fetchData")
	public void createLead(String userName, String password, String companyName, String firstName, String lastName) {
		new LoginPage(driver, test).enterUserName(userName).enterPassword(password).clickLogin().clickCrmsfa()
				.clickCreateLeadLink().enterCompanyName(companyName).enterFirstName(firstName).enterLastName(lastName)
				.clickCreateLeadButton();
		// .closeBrowser();

	}

}
