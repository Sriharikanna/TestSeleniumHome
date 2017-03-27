package wrappers;

import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class LeafTapswrappers extends GenericWrappers {
	//@Parameters({"browser","url","uname","pwd"})
	@BeforeMethod(groups = "commonforall")
	public void loginleaftaps(/*@Optional("firefox")String browser,String url,String uname, String pwd*/) {
		//invokeApp(browser, url);
		invokeApp("chrome", "http://www.leaftaps.com");
		//enterById("username", uname);
		enterById("username", "DemoSalesManager");
		//enterById("password", pwd);
		enterById("password", "crmsfa");
		clickByClassName("decorativeSubmit");
		clickByLink("CRM/SFA");

	}

	public int listWebElements(String xpathVal) {
		int sizeoflst = 0;
		try {
			List<WebElement> element = driver.findElementsByXPath(xpathVal);
			System.out.println("Below are the WebElements Located" + element);
			sizeoflst = element.size();
			System.out.println("Size of the List :" + sizeoflst);
		} catch (NoSuchElementException e) {
			System.err.println("ListWebElements Method- No Such Element Exception");
		} catch (NotFoundException e) {
			System.err.println("ListWebElements Method- Not found Exception");
		} catch (WebDriverException e) {
			System.err.println("ListWebElements Method- WebDriver Exception");
		} catch (Exception e) {
			System.err.println("ListWebElements Method- Exception Unknown..Check Below Stacktrace");
			e.printStackTrace();
		} finally {
			takeSnap();
		}
		return sizeoflst;
	}

	public void selectIndexByXpath(String xpath, int value) {
		try {
			WebElement webel = driver.findElementByXPath(xpath);
			Select ddown = new Select(webel);
			ddown.selectByIndex(value);
			System.out.println(
					"selectIndexByXpath - The element" + value + " is successfully selected using select index");
		} catch (NoSuchElementException e) {
			System.err.println("selectIndexByXpath Method- No Such Element Exception");
		} catch (NotFoundException e) {
			System.err.println("selectIndexByXpath Method- Not found Exception");
		} catch (WebDriverException e) {
			System.err.println("selectIndexByXpath Method- WebDriver Exception");
		} catch (Exception e) {
			System.err.println("selectIndexByXpath Method- Exception Unknown..Check Below Stacktrace");
			e.printStackTrace();
		} finally {
			takeSnap();
		}
	}

	public void selectIndexByName(String name, int value) {
		try {
			WebElement webel = driver.findElementByName(name);
			Select ddown = new Select(webel);
			ddown.selectByIndex(value);
			System.out.println(
					"selectIndexByName - The element" + value + " is successfully selected using select index");
		} catch (NoSuchElementException e) {
			System.err.println("selectIndexByName Method- No Such Element Exception");
		} catch (NotFoundException e) {
			System.err.println("selectIndexByName Method- Not found Exception");
		} catch (WebDriverException e) {
			System.err.println("selectIndexByName Method- WebDriver Exception");
		} catch (Exception e) {
			System.err.println("selectIndexByName Method- Exception Unknown..Check Below Stacktrace");
			e.printStackTrace();
		} finally {
			takeSnap();
		}
	}

	public void selectVisibleTextByName(String name, String value) {
		try {
			WebElement webel = driver.findElementByName(name);
			Select ddown = new Select(webel);
			ddown.selectByVisibleText(value);
			System.out.println("selectVisibleTextByName - The element " + value
					+ " is successfully selected using select Visible Text");
		} catch (NoSuchElementException e) {
			System.err.println("selectVisibleTextByName Method- No Such Element Exception");
		} catch (NotFoundException e) {
			System.err.println("selectVisibleTextByName Method- Not found Exception");
		} catch (WebDriverException e) {
			System.err.println("selectVisibleTextByName Method- WebDriver Exception");
		} catch (Exception e) {
			System.err.println("selectVisibleTextByName Method- Exception Unknown..Check Below Stacktrace");
			e.printStackTrace();
		} finally {
			takeSnap();
		}
	}

	public String getCurrentUrl() {
		String currUrl = null;
		try {
			currUrl = driver.getCurrentUrl();
			System.out.println("Your Current Browser URL: " + currUrl);
		} catch (NoSuchElementException e) {
			System.err.println("selectValueByName Method- No Such Element Exception");
		} catch (NotFoundException e) {
			System.err.println("selectValueByName Method- Not found Exception");
		} catch (WebDriverException e) {
			System.err.println("selectValueByName Method- WebDriver Exception");
		} catch (Exception e) {
			System.err.println("selectValueByName Method- Exception Unknown..Check Below Stacktrace");
			e.printStackTrace();
		} finally {
			takeSnap();
		}
		return currUrl;
	}

	@AfterMethod(groups = "commonforall")
	public void closeBrowserLeafTaps() {
		try {
			driver.close();
		} catch (NoSuchElementException e) {
			System.err.println("closeBrowserLeafTaps Method- No Such Element Exception");
		} catch (NotFoundException e) {
			System.err.println("closeBrowserLeafTaps Method- Not found Exception");
		} catch (WebDriverException e) {
			System.err.println("closeBrowserLeafTaps Method- WebDriver Exception");
		} catch (Exception e) {
			System.err.println("closeBrowserLeafTaps Method- Exception Unknown..Check Below Stacktrace");
			e.printStackTrace();
		}
	}

}