package Lead;



import org.testng.annotations.Test;

import wrappers.DataUtils;
import wrappers.LeafTapsWrapper;

public class CreateLead extends LeafTapsWrapper{
	
	@Test(dataProvider="datasource", dataProviderClass = DataUtils.class)
	public void createLead(String fName, String lName) throws Exception{
		clickByLink("Leads");
		clickByLink("Create Lead");
		enterById("createLeadForm_companyName","Qeagle");
		enterById("createLeadForm_firstName", fName);
		enterById("createLeadForm_lastName", lName);		
		enterById("createLeadForm_primaryEmail", "gopinath@testleaf.com");
		enterById("createLeadForm_primaryPhoneNumber", "9597704568");
		clickByName("submitButton");	
	}
	
	
	
	
	
	
	
	
	
}









