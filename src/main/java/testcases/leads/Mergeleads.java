package testcases.leads;



import org.junit.Test;

import wrappers.GenericWrappers;

public class Mergeleads extends GenericWrappers {

	@Test
	public void login(){
		
		invokeApp("chrome", "http://leaftaps.com");
		enterById("username", "DemoSalesManager");
		enterById("password", "crmsfa");
		clickByClassName("decorativeSubmit");
		clickByXpath("//*[@id='button']/a/img");
		clickByLink("Leads");
		clickByLink("Merge Leads");
		clickByXpath("(//img[@alt='Lookup'])[1]");
		switchToLastWindow();
		enterByXpath("//label[contains(text(),'Lead ID:')]/following::input","1");
		clickByXpath("//button[contains(text(),'Find Leads')]");
		clickByXpathNoSnap("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a");
		switchToParentWindow();
		String text = getTextByXpath("ComboBox_partyIdFrom");
		System.out.println(text);
		clickByXpath("(//img[@alt='Lookup'])[2]");
		switchToLastWindow();
		enterByXpath("//label[contains(text(),'Lead ID:')]/following::input", "1");
		clickByXpath("//button[contains(text(),'Find Leads')]");
		clickByXpathNoSnap("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[2]/a");
		switchToParentWindow( );
		clickByLinkNoSnap("Merge");
		acceptAlert();
		clickByLink("Find Leads");
		enterByXpath("//label[contains(text(),'Lead ID:')]/following::input", "1");
		clickByXpath("//button[contains(text(),'Find Leads')]");
		verifyTextByXpath("//div[contains(text()", text);
		closeBrowser();		
	}	
}
