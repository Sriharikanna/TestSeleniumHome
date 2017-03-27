package atClass.week4;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



import wrappers.LeafTapswrappers;

public class DataProviders extends LeafTapswrappers {

	@Test(dataProvider = "datasource")
	public void createLead(String fName, String lName) throws Exception {
		clickByLink("Leads");
		clickByLink("Create Lead");
		enterById("createLeadForm_companyName", "Qeagle");
		enterById("createLeadForm_firstName", fName);
		enterById("createLeadForm_lastName", lName);
		enterById("createLeadForm_primaryEmail", "gopinath@testleaf.com");
		enterById("createLeadForm_primaryPhoneNumber", "9597704568");
		clickByName("submitButton");
	}

	@DataProvider(name = "datasource")
	public static Object[][] fetchData() {
		Object[][] testData = new Object[1][2];
		// Here Object[1][2], [1] defines the times to be executed. [2] defines
		// the how many columns to be passed
		testData[0][0] = "Gopi";
		testData[0][1] = "Jayakumar";
		/*
		 * testData[1][0]="Babu"; testData[1][1]="Manickam";
		 */
		return testData;
	}
}