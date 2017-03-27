package seleniumlearning;

import org.junit.Test;

import wrappers.LeafTapswrappers;

public class Dummydeletecon extends LeafTapswrappers {

	@Test
	public void delcontact() throws InterruptedException {
		loginleaftaps();
		clickByXpath("//a[text()='Accounts']");
		clickByXpath("//a[text()='Find Accounts']");
		clickByXpath("//span[text()='Phone']");
		enterByXpath("//input[@name='phoneNumber']", "1");
		clickByXpath("//button[text()='Find Accounts']");
		Thread.sleep(3000);
		String AccountID = getTextByXpath("(//div[@unselectable='on']/a[@class='linktext'])[1]");
		clickByXpath("(//div[@unselectable='on']/a[@class='linktext'])[1]");
		int tablelen = listWebElements("//table[@class='contactTable']/tbody/tr");
		System.out.println("Table length :"+tablelen);
		for (int i = 1; i < tablelen ; i++) {
			clickByXpath("(//table[@class='contactTable']/tbody/tr/td/a)[2]/img");
			System.out.println("In loop");
			Thread.sleep(2000);
		}
		clickByXpath("//a[text()='Find Accounts']");
		enterByXpath("//input[@name='id']", AccountID);
		Thread.sleep(2000);
		clickByXpath("//button[text()='Find Accounts']");
		Thread.sleep(2000);
		clickByXpath("(//div[@unselectable='on']/a[@class='linktext'])[1]");
		verifyTextContainsByXpath("//div[text()='No contact information on file']", "No contact");
		closeBrowser();
	}
}
