package testNG.homeWork;

import org.testng.annotations.Test;

import wrappers.LeafTapswrappers;

public class MergeLeadNotReady extends LeafTapswrappers {

	@Test(enabled = false)
	public void login() {

		clickByLink("Leads");
		clickByLink("Merge Leads");
		clickByXpath("(//img[@alt='Lookup'])[1]");
		switchToLastWindow();
		enterByXpath("//label[contains(text(),'Lead ID:')]/following::input", "1");
		clickByXpath("//button[contains(text(),'Find Leads')]");
		String capturedId = getTextByXpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a");
		System.out.println("Captured ID: " + capturedId);
		clickByXpathNoSnap("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a");
		switchToParentWindow();
		clickByXpath("(//img[@alt='Lookup'])[2]");
		switchToLastWindow();
		enterByXpath("//label[contains(text(),'Lead ID:')]/following::input", "1");
		clickByXpath("//button[contains(text(),'Find Leads')]");
		clickByXpathNoSnap("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[2]/a");
		switchToParentWindow();
		clickByLinkNoSnap("Merge");
		acceptAlert();
		clickByLink("Find Leads");
		enterByXpath("//label[contains(text(),'Lead ID:')]/following::input", capturedId);
		clickByXpath("//button[contains(text(),'Find Leads')]");
		verifyTextContainsByXpath("//div[contains(text(),'No records to display')]", "No records");
	}
}
