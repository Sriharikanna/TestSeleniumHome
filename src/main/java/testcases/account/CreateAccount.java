package testcases.account;

import org.junit.Test;

import wrappers.LeafTapswrappers;

public class CreateAccount extends LeafTapswrappers {
@Test
	public void createAcc() throws InterruptedException {
		loginleaftaps();
		System.err.println("****************Create New Account**************");
		clickByXpath("//a[text()='Accounts']");
		clickByXpath("//a[text()='Create Account']");
		String accountName, industry, currency, source, campaign, phone, mail, country, state, city;
		accountName = "Duke";
		city = "Salem";
		industry = "Aerospace";
		currency = "INR - Indian Rupee";
		source = "Cold Call";
		campaign = "Automobile";
		phone = "9176620082";
		mail = "testmail@sri.com";
		country = "India";
		state = "TAMILNADU";
		// Enter Account Name
		enterByXpath("//input[@id='accountName']", accountName);
		// Select industry
		selectVisibleTextByName("industryEnumId", industry);
		// Select Currency
		selectVisibleTextByName("currencyUomId", currency);
		// Select Source
		selectVisibleTextByName("dataSourceId", source);
		// Select Campaign
		selectVisibleTextByName("marketingCampaignId", campaign);
		// Enter phone
		enterByXpath("//input[@id='primaryPhoneNumber']", phone);
		// Enter city
		enterById("generalCity", city);
		// Enter email
		enterByXpath("//input[@id='primaryEmail']", mail);
		// Select Country
		selectVisibleTextByName("generalCountryGeoId", country);
		// select state
		selectVisibleTextByName("generalStateProvinceGeoId", state);
		clickByClassName("smallSubmit");
		Thread.sleep(3000);
		// TO capture the new account ID
		String currUrl = getCurrentUrl();
		String genAcc = currUrl.substring(currUrl.lastIndexOf("=") + 1);
		System.out.println("Your Account ID for the created Account: " + genAcc);
		// Click find account link
		clickByXpath("//a[text()='Find Accounts']");
		// enter account ID
		enterByXpath("//input[@name='id']", genAcc);
		// click find account
		clickByXpath("//button[text()='Find Accounts']");
		// click the first resulting link
		Thread.sleep(3000);
		clickByXpath("(//div[@unselectable='on']/following::a[@class='linktext'])[1]");
		// Verification of saved fields
		verifyTextByXpath("//table[@class='fourColumnForm']/tbody/tr[3]/following::span[2]", industry);
		verifyTextByXpath("//table[@class='fourColumnForm']/tbody/tr[10]/following::span[2]", campaign);
		verifyTextByXpath("//table[@class='fourColumnForm']/tbody/tr[9]/following::span[2]", source);
		verifyTextContainsByXpath("//table[@class='fourColumnForm']/tbody/tr[2]/following::span[3]", currency.substring(0, 3));
		verifyTextByXpath("//table[@class='contactTable']/tbody/tr[2]/td[2]/div/a", mail);
		verifyTextByXpath("//table[@class='contactTable']/tbody/tr[3]/td[2]/div", phone);
		closeBrowser();
	}
}
