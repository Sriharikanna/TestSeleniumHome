package groups.hw;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import wrappers.LeafTapswrappers;

public class EditLead extends LeafTapswrappers {
	@Test(dataProvider = "eleadssource", groups = "Sanity", dependsOnGroups = { "Smoke" })
	public void editLeads(String fName, String title, String cName) throws InterruptedException {

		// Click on Leads Link
		clickByLink("Leads");
		// Click on Find Leads Link
		clickByLink("Find Leads");
		// Enter First Name
		enterByXpath("//span[text()='Name and ID']/following::input[@name='firstName']", fName);
		// Click on find Leads button
		clickByXpath("//button[text()='Find Leads']");
		// Click on the First Resulting Lead
		clickByXpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]");
		// Verify the Title of the Page
		verifyTitle(title);
		// Click on Edit Link
		clickByLink("Edit");
		// Enter the Company Name - Edit the Company Name
		enterById("updateLeadForm_companyName", cName);
		// Click on Update
		clickByXpath("//input[@value='Update']");
		// Verify the New Company Name
		System.out.println(cName);
		Thread.sleep(3000);
		verifyTextContainsByXpath("//span[@id='viewLead_companyName_sp']", cName);

	}

	@DataProvider(name = "eleadssource")
	public Object[][] eLeads() {

		Object[][] el = new Object[1][3];
		el[0][0] = "Srihari";
		el[0][1] = "View Lead | opentaps CRM";
		el[0][2] = "CTS";

		return el;

	}
}
