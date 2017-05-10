package practising.Selenium.april;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebtableTestLeaf {
	RemoteWebDriver driver;

	@BeforeMethod
	public void invokeBrowser() {
		System.setProperty("webdriver.chrome.driver", "D:/Selenium/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://testleaf.herokuapp.com/");
	}

	@Test
	public void readTable() {
		driver.findElementByXPath("//h5[text()='Table']").click();
		WebElement table = driver.findElementByTagName("table");
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		System.out.println("Printing table row Size :" + rows.size());
		List<WebElement> columns = rows.get(0).findElements(By.tagName("th"));
		System.out.println("Printing table column size :" + columns.size());
		System.out.println("******************PRINTING TABLE DATA******************************");

		// Printing table data
		for (int i = 0; i < rows.size(); i++) {

			columns = rows.get(i).findElements(By.tagName("td"));

			for (int j = 0; j < columns.size(); j++) {
				System.out.println(columns.get(j).getText());
			}
		}

		// Selecting the checkbox [ vital task for the least completed progress]

		System.out.println("*************Selecting the checkbox of Least Completed Progress*******************");
		
	}

	@AfterMethod
	public void browserClose() {
		driver.close();
	}
}
