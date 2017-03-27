package testNG.homeWork;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import wrappers.LeafTapswrappers;

public class CreateLead extends LeafTapswrappers {
	@Test(dataProvider = "createLeadData")
	public void creteLead(String cName, String fName, String lName, String pId, String dataSId, String cId, String fNL,
			String lNL, String pTitle, String gTitle, String dName, String annualR, String currency) {

		// Click on Create Lead
		clickByLink("Create Lead");
		// Enter Company Name
		enterById("createLeadForm_companyName", cName);
		// Enter First Name
		enterById("createLeadForm_firstName", fName);
		// Enter Last Name
		enterById("createLeadForm_lastName", lName);
		// Enter Parent Id
		enterById("createLeadForm_parentPartyId", pId);
		// Select Source Drop Down
		selectVisibileTextById("createLeadForm_dataSourceId", dataSId);
		// Select MArketing Campaign Drop down
		selectVisibileTextById("createLeadForm_marketingCampaignId", cId);
		// Enter First name Local
		enterById("createLeadForm_firstNameLocal", fNL);
		// Enter Last Name Local
		enterById("createLeadForm_lastNameLocal", lNL);
		// Enter Salutation
		enterById("createLeadForm_personalTitle", pTitle);
		// Enter Title
		enterById("createLeadForm_generalProfTitle", gTitle);
		// Place Holder for D.O.B
		// Enter Department
		enterById("createLeadForm_departmentName", dName);
		// Enter Annual Revenue
		enterById("createLeadForm_annualRevenue", annualR);
		// Select Industry
		selectVisibileTextById("createLeadForm_currencyUomId", currency);
		// Click Create Lead Button
		clickByClassName("smallSubmit");
		System.out.println("CREATE LEAD USING WRAPPERS: TEST COMPLETED SUCCESSFULLY");

	}

	@DataProvider(name = "createLeadData")
	public Object[][] createLeadRepo() {

		Object[][] clr = new Object[1][13];

		clr[0][0] = "Cognizant Techn..Sol..";
		clr[0][1] = "Srihari";
		clr[0][2] = "M";
		clr[0][3] = "17865";
		clr[0][4] = "Conference";
		clr[0][5] = "Automobile";
		clr[0][6] = "First Name Local";
		clr[0][7] = "Last Name Local";
		clr[0][8] = "Mr.";
		clr[0][9] = "Er.";
		clr[0][10] = "My Dept";
		clr[0][11] = "120000";
		clr[0][12] = "INR - Indian Rupee";

		return clr;

	}
}
