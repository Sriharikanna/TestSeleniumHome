package testNG.homeWork;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import wrappers.LeafTapswrappers;

public class Mergeleads extends LeafTapswrappers {

	@Test(dataProvider = "mleadsSource")
	public void login(String iD1, String iD2) {

		clickByLink("Leads");
		clickByLink("Merge Leads");
		clickByXpath("(//img[@alt='Lookup'])[1]");
		switchToLastWindow();
		enterByXpath("//label[contains(text(),'Lead ID:')]/following::input", iD1);
		clickByXpath("//button[contains(text(),'Find Leads')]");
		String capturedId = getTextByXpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a");
		System.out.println("Captured ID: " + capturedId);
		clickByXpathNoSnap("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a");
		switchToParentWindow();
		clickByXpath("(//img[@alt='Lookup'])[2]");
		switchToLastWindow();
		enterByXpath("//label[contains(text(),'Lead ID:')]/following::input", iD2);
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

	@DataProvider(name = "mleadsSource")
	public Object[][] mLeads() {
		Object[][] ml = new Object[1][2];
		ml[0][0] = "1";
		ml[0][1] = "1";
		return ml;

	}
}
