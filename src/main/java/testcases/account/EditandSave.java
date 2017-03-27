package testcases.account;

import org.junit.Test;

import wrappers.LeafTapswrappers;

public class EditandSave extends LeafTapswrappers{
@Test
	public void editSave() throws InterruptedException
	{
		String accountName = "hariAccount";
		loginleaftaps();
		System.err.println("*****************Edit & Save Account*********************");
		clickByXpath("//a[text()='Accounts']");
		clickByXpath("//a[text()='Find Accounts']");
		enterByXpath("//input[@name='id']", "1");
		clickByXpath("//button[text()='Find Accounts']");
		Thread.sleep(2000);
		clickByXpath("(//div[@unselectable='on']/following::a[@class='linktext'])[1]");
		verifyTitle("Account Details");
		clickByXpath("//a[text()='Edit']");
		enterByXpath("//input[@id='accountName']", accountName);
		clickByXpath("//input[@value='Save']");
		verifyTextContainsByXpath("(//table[@class='fourColumnForm']/tbody/tr/td/following-sibling::*/span)[1]", accountName);
		closeBrowser();
		
	}
}
