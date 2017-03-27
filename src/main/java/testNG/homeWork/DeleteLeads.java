package testNG.homeWork;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import wrappers.LeafTapswrappers;

public class DeleteLeads extends LeafTapswrappers {
	@Test(dataProvider = "sourceOfdata")
	public void deleteLeads(String phone, String data) {

		// Click on Leads Link
		clickByLink("Leads");
		// Click on find Leads Link
		clickByLink("Find Leads");
		// Click on Phone Tab
		clickByXpath("//span[text()='Phone']");
		// Enter Phone Number
		enterByXpath("//input[@name='phoneNumber']", phone);
		// Click on Find Leads button
		clickByXpath("//button[text()='Find Leads']");
		// Get the Lead ID in a variable
		String LeadId = getTextByXpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]");
		// Click on first resulting Lead
		clickByXpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]");
		// Click on Delete Tab
		clickByXpath("//a[text()='Delete']");
		// Click Find Leads
		clickByLink("Find Leads");
		// Enter the Saved Lead Id
		enterByXpath("//span[text()='Name and ID']/following::input[@name='id']", LeadId);
		// Click on Find Leads
		clickByXpath("//button[text()='Find Leads']");
		// Verify No Records found text
		verifyTextByXpath("//div[text()='No records to display']", data);

		System.out.println("DELETE LEAD COMPLETED SUCCESFULLY");
	}

	@DataProvider(name = "sourceOfdata")
	public Object[][] deleteLead() {
		Object[][] dl = new Object[1][2];
		dl[0][0] = "123";
		dl[0][1] = "No records to display";
		return dl;

	}

}
