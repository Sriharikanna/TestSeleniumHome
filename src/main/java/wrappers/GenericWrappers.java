package wrappers;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.OutputType;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

public class GenericWrappers implements Wrappers {

	// Declaration of Global variables
	RemoteWebDriver driver;
	int i = 1;
	// to capture root parent window
	String parentwindow;

	// Initialize the browser and load the URL
	public void invokeApp(String browser, String url) {

		try {
			if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", "D:\\selenium\\drivers\\chromedriver.exe");
				driver = new ChromeDriver();
			} else if (browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", "D:\\selenium\\drivers\\geckodriver.exe");
				driver = new FirefoxDriver();
			}
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.get(url);
			// Getting handle of initial window
			parentwindow = driver.getWindowHandle();
			System.out.println("The handle of the parent Window: " + parentwindow);
			System.out.println("invokeApp " + "The Browser " + "\"" + browser + "\"" + " is Launched");
		} catch (NoSuchWindowException e) {
			System.err.println("invokeApp Method- WebDriver Exception..");
		} catch (WebDriverException e) {
			System.err.println("invokeApp Method- WebDriver Exception..");
		} catch (Exception e) {
			System.err.println("invokeApp Method- Exception Unknown..Check Below Stacktrace");
			e.printStackTrace();
		} finally {
			takeSnap();
		}

	}

	// SendKeys by ID
	public void enterById(String idValue, String data) {
		try {
			driver.findElementById(idValue).clear();
			driver.findElementById(idValue).sendKeys(data);
			System.out.println("enterById " + "Your text " + "\"" + data + "\"" + " is entered");
		} catch (NoSuchElementException e) {
			System.err.println("enterById Method- No Such Element Exception");
		} catch (NotFoundException e) {
			System.err.println("enterById Method- Not found Exception");
		} catch (WebDriverException e) {
			System.err.println("enterById Method- WebDriver Exception");
		} catch (Exception e) {
			System.err.println("enterById Method- Exception Unknown..Check Below Stacktrace");
			e.printStackTrace();
		} finally {
			takeSnap();
		}
	}

	// SendKeys by Name
	public void enterByName(String nameValue, String data) {
		try {
			driver.findElementByName(nameValue).clear();
			driver.findElementById(nameValue).sendKeys(data);
			System.out.println("enterByName - Your Text is entered with data :" + "\"" + data + "\"");
		} catch (NoSuchElementException e) {
			System.err.println("enterByName Method- No Such Element Exception");
		} catch (NotFoundException e) {
			System.err.println("enterByName Method- Not found Exception");
		} catch (WebDriverException e) {
			System.err.println("enterByName Method- WebDriver Exception");
		} catch (Exception e) {
			System.err.println("enterByName Method- Exception Unknown..Check Below Stacktrace");
			e.printStackTrace();
		} finally {
			takeSnap();
		}
	}

	// SendKeys by Xpath
	public void enterByXpath(String xpathValue, String data) {
		try {
			driver.findElementByXPath(xpathValue).clear();
			driver.findElementByXPath(xpathValue).sendKeys(data);
			System.out.println("enterByXpath -  Your text is entered with data :" + "\"" + data + "\"");
		} catch (NoSuchElementException e) {
			System.err.println("enterByXpath Method- No Such Element Exception");
		} catch (NotFoundException e) {
			System.err.println("enterByXpath Method- Not found Exception");
		} catch (WebDriverException e) {
			System.err.println("enterByXpath Method- WebDriver Exception");
		} catch (Exception e) {
			System.err.println("enterByXpath Method- Exception Unknown..Check Below Stacktrace");
			e.printStackTrace();
		} finally {
			takeSnap();
		}

	}

	// Verify title by comparing given text with get title
	public boolean verifyTitle(String title) {
		boolean bReturn = false;
		try {
			if (driver.getTitle().contains(title)) {
				System.out.println("You're landed in the page where your title looks similar");
				System.out.println("verifyTitle <<->> Given title header is ::" + "\"" + title + "\""
						+ ":: Retrieved Title ::" + driver.getTitle());
				bReturn = true;
			}
		} catch (NoSuchElementException e) {
			System.err.println("verifyTitle Method- No Such Element Exception");
		} catch (NotFoundException e) {
			System.err.println("verifyTitle Method- Not found Exception");
		} catch (WebDriverException e) {
			System.err.println("verifyTitle Method- WebDriver Exception");
		} catch (Exception e) {
			System.err.println("verifyTitle Method- Exception Unknown..Check Below Stacktrace");
			e.printStackTrace();
		} finally {
			takeSnap();
		}
		return bReturn;
	}

	// Verify text by the given text and get text by ID
	public void verifyTextById(String id, String text) {
		try {
			if (driver.findElementByLinkText(id).getText().equals(text)) {
				System.out.println("verifyTextById - Your " + "\"" + text + "\"" + "is available");
			} else {
				System.out.println("verifyTextById -Your " + "\"" + text + "\"" + "is Not available");
			}
		} catch (NoSuchElementException e) {
			System.err.println("verifyTextById Method- No Such Element Exception");
		} catch (NotFoundException e) {
			System.err.println("verifyTextById Method- Not found Exception");
		} catch (WebDriverException e) {
			System.err.println("verifyTextById Method- WebDriver Exception");
		} catch (Exception e) {
			System.err.println("verifyTextById Method- Exception Unknown..Check Below Stacktrace");
			e.printStackTrace();
		} finally {
			takeSnap();
		}
	}

	// Verify text by the given text and get text by Xpath
	public void verifyTextByXpath(String xpath, String text) {
		try {
			if (driver.findElementByXPath(xpath).getText().equals(text)) {
				System.out.println("verifyTextByXpath - Your " + "\"" + text + "\"" + " Is Available");
			} else {
				System.out.println("verifyTextByXpath - Your " + "\"" + text + "\"" + " Is Not Available");
			}
		} catch (NoSuchElementException e) {
			System.err.println("verifyTextByXpath Method- No Such Element Exception");
		} catch (NotFoundException e) {
			System.err.println("verifyTextByXpath Method- Not found Exception");
		} catch (WebDriverException e) {
			System.err.println("verifyTextByXpath Method- WebDriver Exception");
		} catch (Exception e) {
			System.err.println("verifyTextByXpath Method- Exception Unknown..Check Below Stacktrace");
			e.printStackTrace();
		} finally {
			takeSnap();
		}
	}

	/*
	 * Verify text using "contains" method comparison would be with the given
	 * text and get text by Xpath
	 */
	public void verifyTextContainsByXpath(String xpath, String text) {
		try {
			String rwdriver = driver.findElementByXPath(xpath).getText();
			if (rwdriver.contains(text)) {
				System.out.println("verifyTextContainsByXpath - Your text " + "\"" + text + "\"" + " Is Available");
			} else
				System.out.println("verifyTextContainsByXpath - Your text " + text + " Is Not Available");
		} catch (NoSuchElementException e) {
			System.err.println("verifyTextContainsByXpath Method- No Such Element Exception");
		} catch (NotFoundException e) {
			System.err.println("verifyTextContainsByXpath Method- Not found Exception");
		} catch (WebDriverException e) {
			System.err.println("verifyTextContainsByXpath Method- WebDriver Exception");
		} catch (Exception e) {
			System.err.println("verifyTextContainsByXpath Method- Exception Unknown..Check Below Stacktrace");
			e.printStackTrace();
		} finally {
			takeSnap();
		}
	}

	// Click by ID
	public void clickById(String id) {
		try {
			driver.findElementById(id).click();
			System.out.println("clickById - The located item is clicked");
		} catch (NoSuchElementException e) {
			System.err.println("clickById Method- No Such Element Exception");
		} catch (NotFoundException e) {
			System.err.println("clickById Method- Not found Exception");
		} catch (WebDriverException e) {
			System.err.println("clickById Method- WebDriver Exception");
		} catch (Exception e) {
			System.err.println("clickById Method- Exception Unknown..Check Below Stacktrace");
			e.printStackTrace();
		} finally {
			takeSnap();
		}
	}

	// Click by ClassName
	public void clickByClassName(String classVal) {
		try {
			driver.findElementByClassName(classVal).click();
			System.out.println("clickByClassName - The button is clicked");
		} catch (NoSuchElementException e) {
			System.err.println("clickByClassName Method- No Such Element Exception");
		} catch (NotFoundException e) {
			System.err.println("clickByClassName Method- Not found Exception");
		} catch (WebDriverException e) {
			System.err.println("clickByClassName Method- WebDriver Exception");
		} catch (Exception e) {
			System.err.println("clickByClassName Method- Exception Unknown..Check Below Stacktrace");
			e.printStackTrace();
		} finally {
			takeSnap();
		}
	}

	// Click By Name
	public void clickByName(String name) {
		try {
			driver.findElementByName(name).click();
			System.out.println("clickByName - The element you're referring here is clicked");
		} catch (NoSuchElementException e) {
			System.err.println("clickByClassName Method- No Such Element Exception");
		} catch (NotFoundException e) {
			System.err.println("clickByClassName Method- Not found Exception");
		} catch (WebDriverException e) {
			System.err.println("clickByClassName Method- WebDriver Exception");
		} catch (Exception e) {
			System.err.println("clickByClassName Method- Exception Unknown..Check Below Stacktrace");
			e.printStackTrace();
		} finally {
			takeSnap();
		}
	}

	// Click By Link
	public void clickByLink(String name) {
		try {
			driver.findElementByLinkText(name).click();
			System.out.println("clickByLink - The item located is clicked");
		} catch (NoSuchElementException e) {
			System.err.println("clickByLink Method- No Such Element Exception");
			throw new RuntimeException();
		} catch (NotFoundException e) {
			System.err.println("clickByLink Method- Not found Exception");
			throw new RuntimeException();
		} catch (WebDriverException e) {
			System.err.println("clickByLink Method- WebDriver Exception");
			throw new RuntimeException();
		} catch (Exception e) {
			System.err.println("clickByLink Method- Exception Unknown..Check Below Stacktrace");
			e.printStackTrace();
			throw new RuntimeException();
		} finally {
			takeSnap();
		}
	}

	// Click By Link No snap
	public void clickByLinkNoSnap(String name) {
		try {
			driver.findElementByLinkText(name).click();
			System.out.println("clickByLinkNoSnap - The item located is clicked");
		} catch (NoSuchElementException e) {
			System.err.println("clickByLinkNoSnap Method- No Such Element Exception");
		} catch (NotFoundException e) {
			System.err.println("clickByLinkNoSnap Method- Not found Exception");
		} catch (WebDriverException e) {
			System.err.println("clickByLinkNoSnap Method- WebDriver Exception");
		} catch (Exception e) {
			System.err.println("clickByLinkNoSnap Method- Exception Unknown..Check Below Stacktrace");
			e.printStackTrace();
		}
	}

	// Click BY Xpath
	public void clickByXpath(String xpathVal) {

		try {
			driver.findElementByXPath(xpathVal).click();
			System.out.println("clickByXpath - The item located is clicked");
		} catch (NoSuchElementException e) {
			System.err.println("clickByXpath Method- No Such Element Exception");
		} catch (NotFoundException e) {
			System.err.println("clickByXpath Method- Not found Exception");
		} catch (WebDriverException e) {
			System.err.println("clickByXpath Method- WebDriver Exception");
		} catch (Exception e) {
			System.err.println("clickByXpath Method- Exception Unknown..Check Below Stacktrace");
			e.printStackTrace();
		} finally {
			takeSnap();
		}
	}

	// Click BY Xpath No Snap
	public void clickByXpathNoSnap(String xpathVal) {
		try {
			driver.findElementByXPath(xpathVal).click();
			System.out.println("clickByXpathNoSnap - The item located is clicked");
		} catch (NoSuchElementException e) {
			System.err.println("clickByXpathNoSnap Method- No Such Element Exception");
		} catch (NotFoundException e) {
			System.err.println("clickByXpathNoSnap Method- Not found Exception");
		} catch (WebDriverException e) {
			System.err.println("clickByXpathNoSnap Method- WebDriver Exception");
		} catch (Exception e) {
			System.err.println("clickByXpathNoSnap Method- Exception Unknown..Check Below Stacktrace");
			e.printStackTrace();
		}
	}

	// Getting text by ID
	public String getTextById(String idVal) {
		try {
			System.out.println("getTextById - " + driver.findElementById(idVal).getText());
		} catch (NoSuchElementException e) {
			System.err.println("getTextById Method- No Such Element Exception");
		} catch (NotFoundException e) {
			System.err.println("getTextById Method- Not found Exception");
		} catch (WebDriverException e) {
			System.err.println("getTextById Method- WebDriver Exception");
		} catch (Exception e) {
			System.err.println("getTextById Method- Exception Unknown..Check Below Stacktrace");
			e.printStackTrace();
		} finally {
			takeSnap();
		}
		return null;
	}

	// Getting text using XPath
	public String getTextByXpath(String xpathVal) {
		String gettext = null;
		try {
			gettext = driver.findElementByXPath(xpathVal).getText();
			System.out.println("getTextByXpath - The value you're looking for is: " + "\""
					+ driver.findElementByXPath(xpathVal).getText() + "\"");
		} catch (NoSuchElementException e) {
			System.err.println("getTextByXpath Method- No Such Element Exception");
		} catch (NotFoundException e) {
			System.err.println("getTextByXpath Method- Not found Exception");
		} catch (WebDriverException e) {
			System.err.println("getTextByXpath Method- WebDriver Exception");
		} catch (Exception e) {
			System.err.println("getTextByXpath Method- Exception Unknown..Check Below Stacktrace");
			e.printStackTrace();
		} finally {
			takeSnap();
		}
		return gettext;
	}

	// Selecting the visible text from drop down
	public void selectVisibileTextById(String id, String value) {
		try {
			WebElement webel = driver.findElementById(id);
			Select ddown = new Select(webel);
			ddown.selectByVisibleText(value);
			System.out.println("selectVisibileTextById - You are visible text " + "\"" + value + "\"" + " is selected");
		} catch (NoSuchElementException e) {
			System.err.println("selectVisibileTextById Method- No Such Element Exception");
		} catch (NotFoundException e) {
			System.err.println("selectVisibileTextById Method- Not found Exception");
		} catch (WebDriverException e) {
			System.err.println("selectVisibileTextById Method- WebDriver Exception");
		} catch (Exception e) {
			System.err.println("selectVisibileTextById Method- Exception Unknown..Check Below Stacktrace");
			e.printStackTrace();
		} finally {
			takeSnap();
		}
	}

	// Selecting text by Index from drop down
	public void selectIndexById(String id, int value) {
		try {
			WebElement webel = driver.findElementById(id);
			Select ddown = new Select(webel);
			ddown.selectByIndex(value);
			System.out.println("selectIndexById - The element" + "\"" + value + "\""
					+ " is successfully selected using select index");
		} catch (NoSuchElementException e) {
			System.err.println("selectIndexById Method- No Such Element Exception");
		} catch (NotFoundException e) {
			System.err.println("selectIndexById Method- Not found Exception");
		} catch (WebDriverException e) {
			System.err.println("selectIndexById Method- WebDriver Exception");
		} catch (Exception e) {
			System.err.println("selectIndexById Method- Exception Unknown..Check Below Stacktrace");
			e.printStackTrace();
		} finally {
			takeSnap();
		}
	}

	// Switch to parents window
	public void switchToParentWindow() {
		try {
			driver.switchTo().window(parentwindow);
			System.out.println("switchToParentWindow - You're in parent window - " + parentwindow);
		} catch (NoSuchElementException e) {
			System.err.println("switchToParentWindow Method- No Such Element Exception");
		} catch (NoSuchWindowException e) {
			System.err.println("switchToParentWindow Method- No Such Window Exception");
		} catch (NotFoundException e) {
			System.err.println("switchToParentWindow Method- Not found Exception");
		} catch (WebDriverException e) {
			System.err.println("switchToParentWindow Method- WebDriver Exception");
		} catch (Exception e) {
			System.err.println("switchToParentWindow Method- Exception Unknown..Check Below Stacktrace");
			e.printStackTrace();
		} finally {
			takeSnap();
		}
	}

	// Switch to Last window
	public void switchToLastWindow() {
		try {
			Set<String> allwindow = driver.getWindowHandles();
			System.out.println("switchToLastWindow - And the size of window is" + driver.getWindowHandles().size());
			System.out.println("Below are the list of handles available currently..." + driver.getWindowHandles());
			for (String currntwin : allwindow) {
				driver.switchTo().window(currntwin);
			}
			System.out.println("switchToLastWindow - Current focus window" + driver.getWindowHandle());
		} catch (NoSuchElementException e) {
			System.err.println("selectIndexById Method- No Such Element Exception");
		} catch (NoSuchWindowException e) {
			System.err.println("switchToParentWindow Method- No Such Window Exception");
		} catch (NotFoundException e) {
			System.err.println("selectIndexById Method- Not found Exception");
		} catch (WebDriverException e) {
			System.err.println("selectIndexById Method- WebDriver Exception");
		} catch (Exception e) {
			System.err.println("selectIndexById Method- Exception Unknown..Check Below Stacktrace");
			e.printStackTrace();
		} finally {
			takeSnap();
		}
	}

	// Accept alert - Means hit okay to the alert
	public void acceptAlert() {
		try {
			driver.switchTo().alert().accept();
			System.out.println("You Accepted the alert");
		} catch (NoAlertPresentException e) {
			System.err.println("acceptAlert Method- WebDriver Exception");
		} catch (Exception e) {
			System.err.println("acceptAlert Method- Exception Unknown..Check Below Stacktrace");
			e.printStackTrace();
		}
	}

	// Dismiss alert - Means cancel the alert
	public void dismissAlert() {
		try {
			driver.switchTo().alert().dismiss();
			System.out.println("Dismiss Alert");
		} catch (NoAlertPresentException e) {
			System.err.println("dismissAlert Method- WebDriver Exception");
		} catch (Exception e) {
			System.err.println("dismissAlert Method- Exception Unknown..Check Below Stacktrace");
			e.printStackTrace();
		}
	}

	// Get the text from the alert window
	public String getAlertText() {
		try {
			driver.switchTo().alert();
			System.out.println("getAlertText - Your Alert text: " + "\"" + driver.switchTo().alert().getText() + "\"");
		} catch (NoAlertPresentException e) {
			System.err.println("getAlertText Method- WebDriver Exception");
		} catch (Exception e) {
			System.err.println("getAlertText Method- Exception Unknown..Check Below Stacktrace");
			e.printStackTrace();
		}
		return null;
	}

	// This method will take snaps whenever its called
	public void takeSnap() {
		File src = driver.getScreenshotAs(OutputType.FILE);

		File destFile = new File("./snaps/snap" + i + ".jpg");
		try {
			FileUtils.copyFile(src, destFile);
		} catch (IOException e) {

			e.printStackTrace();
		}
		i++;
	}

	// Close browser
	public void closeBrowser() {
		try {
			driver.close();
			System.out.println("Close browser");
		} catch (WebDriverException e) {
			System.err.println("closeBrowser Method- WebDriver Exception");
		} catch (Exception e) {
			System.err.println("closeBrowser Method- Exception Unknown..Check Below Stacktrace");
			e.printStackTrace();
		}
	}

	// Close all browser
	public void closeAllBrowsers() {
		try {
			driver.quit();
			System.out.println("Close All browser");
		} catch (WebDriverException e) {
			System.err.println("closeAllBrowsers Method- WebDriver Exception");
		} catch (Exception e) {
			System.err.println("closeAllBrowsers Method- Exception Unknown..Check Below Stacktrace");
			e.printStackTrace();
		}
	}

}
