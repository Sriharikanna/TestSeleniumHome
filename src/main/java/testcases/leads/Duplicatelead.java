package testcases.leads;

import org.junit.Test;

import wrappers.LeafTapswrappers;

public class Duplicatelead extends LeafTapswrappers {
	@Test
	public void duplicateleads() {
		System.out.println("***************Duplicate Leads**********************");
		loginleaftaps();
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
		closeBrowser();
	}
}
