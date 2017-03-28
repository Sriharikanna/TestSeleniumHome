package testNG.homeWork;

import org.testng.annotations.Test;

import wrappers.LeafTapswrappers;

public class DupLeadWithInvoCountTimeOut extends LeafTapswrappers {

	@Test(invocationCount = 2, timeOut = 120000)
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
		verifyTitle("Duplicate Lead | opentaps CRM");
		clickByXpath("//input[@value='Create Lead']");
		verifyTextByXpath("//span[@id='viewLead_firstName_sp']", gettext);
	}

}
