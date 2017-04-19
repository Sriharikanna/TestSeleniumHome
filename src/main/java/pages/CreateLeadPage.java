package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.LeafTapsWrappers;

public class CreateLeadPage extends LeafTapsWrappers {

	public CreateLeadPage(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
		/*if (!verifyTitle("Create Lead | opentaps CRM")) {
			reportStep("The page you landed is not a CreateLead Page", "FAIL");
		}*/
	}

	public CreateLeadPage enterCompanyName(String companyName) {
		enterById(/*prop.getProperty("CreateLead.CompanyName.Id")*/"createLeadForm_companyName", companyName);
		return this;
	}

	public CreateLeadPage enterFirstName(String firstName) {
		enterByXpath(prop.getProperty("CreateLead.FirstName.Xpath"), firstName);
		return this;
	}

	public CreateLeadPage enterLastName(String lastName) {
		enterByXpath(prop.getProperty("CreateLead.LastName.Xpath"), lastName);
		return this;
	}

	public ViewLeadPage clickCreateLeadButton() {
		clickByName(prop.getProperty("CreateLead.Submit.Name"));
		return new ViewLeadPage(driver, test);
	}

}
