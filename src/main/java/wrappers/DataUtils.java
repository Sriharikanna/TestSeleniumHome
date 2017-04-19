package wrappers;

import org.testng.annotations.DataProvider;

public class DataUtils {
	@DataProvider(name="datasource")
	public static Object[][] fetchData(){
		Object[][] testData = new Object[2][2];
		testData[0][0]="Gopi";
		testData[0][1]="Jayakumar";
		testData[1][0]="Babu";
		testData[1][1]="Manickam";
		return testData;	
	}

}
