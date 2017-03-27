package testNG.homeWork;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import wrappers.LeafTapswrappers;

public class Duplicatelead extends LeafTapswrappers {

	@Test(dataProvider="duplicateData")
	public void duplicateleads(String email, String title) {
		System.out.println("***************Duplicate Leads**********************");
		clickByXpath("//a[text()='Leads']");
		clickByXpath("//ul[@class='shortcuts']/li[3]/a ");
		clickByXpath("//span[text()='Email']");
		enterByXpath("//input[@name='emailAddress']", email);
		clickByXpath("//em[@unselectable='on']/following::button[text()='Find Leads']");
		String gettext = getTextByXpath("(//div[@unselectable='on']/a[@class='linktext'])[2]/following::a[1]");
		System.out.println("The text captured from the previous method " + gettext);
		clickByXpath("(//div[@unselectable='on']/a[@class='linktext'])[2]/following::a[1]");
		clickByXpath("//div[@class='frameSectionExtra']/a[text()='Duplicate Lead']");
		verifyTitle(title);
		clickByXpath("//input[@value='Create Lead']");
		verifyTextByXpath("//span[@id='viewLead_firstName_sp']", gettext);
	}

	@DataProvider(name = "duplicateData")
	public Object[][] dupLeads() {
		Object[][] dupl = new Object[1][2];
		dupl[0][0] = "test@test.com";
		dupl[0][1] = "Duplicate Lead | opentaps CRM";
		return dupl;

	}

}
