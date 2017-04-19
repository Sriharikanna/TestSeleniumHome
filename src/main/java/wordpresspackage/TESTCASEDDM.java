package wordpresspackage;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class TESTCASEDDM extends BaseClass {

	@Test(dataProvider = "fetchdata", dependsOnMethods = { "Loginintotheapplication" })
	public void AddingnewPost(String title, String content, String tag) {
		new WrapperClass(driver).entertitle(title).entercontent(content).entertag(tag).savepost();
	}

	@DataProvider(name = "fetchdata")
	public Object[][] passdata() {
		ApachiPOI config = new ApachiPOI();
		int rows = config.getRowCount(0);
		int columnlength = config.sheet.getRow(0).getLastCellNum();
		Object[][] data = new Object[rows][2];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columnlength; i++) {
				data[i][j] = config.getData(0, i, j);
			}

		}

		return data;
	}

	/*
	 * new WrapperClass(driver) .entertagname("Tagname")
	 * .enterslugname("slugname") .enterDescription("Desc") .clicknewtag();
	 */

	@Test
	public void Loginintotheapplication() {

		new WrapperClass(driver).enterusername("admin").enterpass("demo123").clickloginbutton();

	}

	/*
	 * @Test (priority=1)
	 * 
	 * public void Createpost () { new WrapperClass(driver) .entertitle(
	 * "Test automation") .entercontent("TestAutomation") .entertag("First")
	 * .savepost();
	 * 
	 * 
	 * }
	 */

	/*
	 * @Test (priority = 3) public void selecttags () { new WrapperClass(driver)
	 * .CickPost() .Clicktag(); }
	 */

}
