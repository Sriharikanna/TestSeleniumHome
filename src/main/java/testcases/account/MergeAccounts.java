package testcases.account;

import org.junit.Test;

import wrappers.LeafTapswrappers;

public class MergeAccounts extends LeafTapswrappers {
	@Test
	public void Merge_Accounts() throws InterruptedException {
		System.out.println("*****************Merge Accounts*******************");
		loginleaftaps();
		clickByXpath("//a[text()='Accounts']");
		clickByXpath("(//ul[@class='shortcuts']//following::li)[4]/a");
		clickByXpath("//input[@id='partyIdFrom']/following::img");
		switchToLastWindow();
		enterByXpath("//input[@name='id']", "1");
		clickByXpath("//button[text()='Find Accounts']");
		Thread.sleep(6000);
		String S = getTextByXpath("(//div[@unselectable='on']/a[@class='linktext'])[1]");
		System.out.println("The first account ID which is about to merge is: "+S);
		Thread.sleep(5000);
		clickByXpathNoSnap("(//div[@unselectable='on']/a[@class='linktext'])[1]");
		Thread.sleep(2000);
		switchToParentWindow();
		Thread.sleep(4000);
		clickByXpath("//input[@name='partyIdTo']/following::img[1]");
		switchToLastWindow();
		enterByXpath("//input[@name='id']", "1");
		clickByXpath("//button[text()='Find Accounts']");
		Thread.sleep(3000);
		clickByXpathNoSnap("(//table[@class='x-grid3-row-table']/tbody/tr/td[1]/div/a)[2]");
		switchToParentWindow();
		clickByXpathNoSnap("//a[text()='Merge']");
		acceptAlert();
		clickByXpath("//a[text()='Find Accounts']");
		enterByXpath("//input[@name='id']", S);
		clickByXpath("//button[text()='Find Accounts']");
		verifyTextContainsByXpath("//div[text()='No records to display']", "No records");
		closeBrowser();

	}
}
