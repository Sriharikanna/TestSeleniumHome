package seleniumlearning;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Gettextexample {
	public static void main(String[] args) throws InterruptedException {
		/* Driver Initialization */
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\drivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/crmsfa/control/createAccountForm");
		driver.findElementByName("USERNAME").sendKeys("DemoSalesManager");
		driver.findElementByName("PASSWORD").sendKeys("crmsfa");
		driver.findElementByClassName("loginButton").click();
		/*
		 * // System.out.println(driver.findElementByXPath("(//div[@class='
		 * tabletext']/b[text()='Phone // Number'])[1]").getText());
		 * 
		 * @SuppressWarnings("unchecked") List<WebElement> element =
		 * driver.findElementsByXPath(
		 * "(//table[@class='contactTable'])/tbody/tr");
		 * 
		 * System.out.println(element.size());
		 * System.out.println(driver.getCurrentUrl()); String url =
		 * driver.getCurrentUrl(); String accNumber =
		 * url.substring(url.lastIndexOf("=") + 1);
		 * System.out.println(accNumber);
		 */
		Thread.sleep(5000);
		WebElement webel = driver.findElementByName("industryEnumId");
		Select ddown = new Select(webel);
		ddown.selectByVisibleText("Aerospace");
		System.out.println(driver.findElementByName("industryEnumId").isDisplayed());
		System.out.println(driver.findElementByName("industryEnumId").isEnabled());
		System.out.println(driver.findElementByName("industryEnumId").isSelected());
		WebDriverWait wait= new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(By.name("industryEnumId")));
		wait.until(ExpectedConditions.elementToBeClickable(By.name("industryEnumId"))).click();
		// driver.close();
	}
}
