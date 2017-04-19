package seleniumlearning;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGClass {

	public ChromeDriver driver;

	@BeforeMethod
	public void beforeM() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "D:\\selenium\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.get("http://testleaf.herokuapp.com");
	}

	@Test
	public void main1() throws InterruptedException {
		driver.findElementByXPath("//h5[@class='wp-categories-title']/following::img[7]").click();
		driver.findElementByXPath("//input[@type='checkbox'][1]").click();
		if (driver.findElementByXPath("//div[@class='example'][1]").isSelected()) {
			System.out.println("Confirmed selenium is selected");
		} else {
			System.out.println("selenium is not selected");
		}

		Select listbox = new Select(driver.findElement(By.xpath("//select[@name='FromLB']")));
		listbox.deselectAll();

	}
}
