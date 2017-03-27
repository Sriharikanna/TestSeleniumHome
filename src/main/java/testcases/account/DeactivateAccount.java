package testcases.account;

import org.junit.Test;

import wrappers.LeafTapswrappers;

public class DeactivateAccount extends LeafTapswrappers {
	@Test
	public void deactivateacc() {
		loginleaftaps();
		System.out.println("********************Deactivate Account*****************************");
		clickByXpath("//a[text()='Accounts']");
		clickByXpath("//a[text()='Find Accounts']");
		String acctodeactivate = getTextByXpath("(//div[@unselectable='on']/following::a[@class='linktext'])[1]");
		System.out.println("The account to be deactivated is: " + acctodeactivate);
		clickByXpath("(//div[@unselectable='on']/following::a[@class='linktext'])[1]");
		verifyTitle("Account Details");
		clickByXpathNoSnap("//a[text()='Deactivate Account']");
		acceptAlert();
		System.out.println("*******Your Account is successfully Deactivated************");
		verifyTextContainsByXpath("//span[contains(text(),'This account was deactivated')", "deactivated");
		clickByXpath("//a[text()='Find Accounts']");
		enterByXpath("//input[@name='id']", acctodeactivate);
		clickByXpath("//button[text()='Find Accounts']");
		verifyTextContainsByXpath("//div[text()='No records to display']", "No records");
		closeBrowser();
	}
}
