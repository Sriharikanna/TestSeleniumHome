package atClass.week4;

import org.testng.annotations.Test;

import wrappers.LeafTapswrappers;

public class AllMethod extends LeafTapswrappers {

	@Test
	public void createLead() throws Exception {

		clickByLink("Leads");
		clickByLink("Create Lead");
		enterById("createLeadForm_companyName", "Qeagle");
		enterById("createLeadForm_firstName", "Gopinath");
		enterById("createLeadForm_lastName", "Jayakumar");
		enterById("createLeadForm_primaryEmail", "gopinath@testleaf.com");
		enterById("createLeadForm_primaryPhoneNumber", "9597704568");
		clickByName("submitButton");

	}

	@Test
	public void editLead() throws Exception {
		clickByLink("Leads");
		clickByLink("Find Leads");
		enterByXpath("(//input[@name='firstName'])[3]", "Gopinath");
		clickByXpath("//button[contains(text(),'Find Leads')]");
		Thread.sleep(3000);
		clickByXpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a");
		verifyTitle("View Lead | opentaps CRM");
		clickByXpath("//a[contains(text(),'Edit')]");
		selectVisibileTextById("updateLeadForm_industryEnumId", "Computer Software");
		clickByXpath("//input[@class='smallSubmit']");
	}

	@Test
	public void mergeLead() throws Exception {
		clickByLink("Leads");
		clickByLink("Merge Leads");
		clickByXpath("(//img[@alt='Lookup'])[1]");
		switchToLastWindow();
		enterByName("firstName", "Gopinath");
		clickByXpath("//button[contains(text(),'Find Leads')]");
		Thread.sleep(2000);
		String sText = getTextByXpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a");
		System.out.println(sText);
		clickByXpathNoSnap("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a");
		switchToParentWindow();
		clickByXpath("(//img[@alt='Lookup'])[2]");
		switchToLastWindow();
		enterByName("firstName", "Babu");
		clickByXpath("//button[contains(text(),'Find Leads')]");
		Thread.sleep(2000);
		clickByXpathNoSnap("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a");
		switchToParentWindow();
		clickByLinkNoSnap("Merge");
		acceptAlert();
		clickByLink("Find Leads");
		enterByXpath("//label[contains(text(),'Lead ID:')]/following::input", sText);
		clickByXpath("//button[contains(text(),'Find Leads')]");
		Thread.sleep(2000);
		verifyTextContainsByXpath("//div[@class='x-paging-info']", "No records to display");

	}

	@Test
	public void deleteLeads() {
		// Click on Leads Link
		clickByLink("Leads");
		// Click on find Leads Link
		clickByLink("Find Leads");
		// Click on Phone Tab
		clickByXpath("//span[text()='Phone']");
		// Enter Phone Number
		enterByXpath("//input[@name='phoneNumber']", "9941586323");
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
		verifyTextByXpath("//div[text()='No records to display']", "No records to display");
		System.out.println("DELETE LEAD COMPLETED SUCCESFULLY");
	}

	@Test
	public void duplicateleads() {
		System.out.println("***************Duplicate Leads**********************");
		clickByXpath("//a[text()='Leads']");
		clickByXpath("//ul[@class='shortcuts']/li[3]/a ");
		clickByXpath("//span[text()='Email']");
		enterByXpath("//input[@name='emailAddress']", "test@test.com");
		clickByXpath("//em[@unselectable='on']/following::button[text()='Find Leads']");
		String gettext = getTextByXpath("(//div[@unselectable='on']/a[@class='linktext'])[2]/following::a[1]");
		System.out.println("The text captured from the previous method " + gettext);
		clickByXpath("(//div[@unselectable='on']/a[@class='linktext'])[2]/following::a[1]");
		clickByXpath("//div[@class='frameSectionExtra']/a[text()='Duplicate Lead']");
		verifyTitle("Duplicate Lead");
		clickByXpath("//input[@value='Create Lead']");
		verifyTextByXpath("//span[@id='viewLead_firstName_sp']", gettext);
	}
}