package wrappers;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenericWrappers{

	public RemoteWebDriver driver;
	int i=1;

	public boolean invokeApp(String browser, String Url) {
		boolean bReturn = false;
		try {

			if(browser.equalsIgnoreCase("chrome")){
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--disable-extensions");
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				driver = new ChromeDriver(options);
			}else
			{
				System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");

				driver = new FirefoxDriver();
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get(Url);

			System.out.println("The browser:" + browser + " launched successfully");
			bReturn = true;

		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("The browser:" + browser + " could not be launched");
		}
		finally{
			takeSnap();
		}
		return bReturn;
	}

	/**
	 * This method will launch only firefox and maximise the browser and set the
	 * wait for 30 seconds and load the url
	 * @author Babu - TestLeaf
	 * @param url - The url with http or https
	 * 
	 */
	/**
	 * This method will enter the value to the text field using id attribute to locate
	 * 
	 * @param idValue - id of the webelement
	 * @param data - The data to be sent to the webelement
	 * @author Babu - TestLeaf
	 * @throws Exception 
	 * @throws IOException 
	 * @throws COSVisitorException 
	 */
	public boolean enterById(String idValue, String data) throws Exception{
		boolean bReturn = false;
		try {
			driver.findElement(By.id(idValue)).clear();
			driver.findElement(By.id(idValue)).sendKeys(data);	
			System.out.println("The data: "+data+" entered successfully in field :"+idValue);
			bReturn = true;

		} catch (Exception e) {
			System.err.println("The data: "+data+" could not be entered in the field :"+idValue);
			throw new Exception("TestCase Stop");


		}
		finally {
			takeSnap();
		}
		return bReturn;
	}


	/**
	 * This method will enter the value to the text field using name attribute to locate
	 * 
	 * @param nameValue - name of the webelement
	 * @param data - The data to be sent to the webelement
	 * @author Babu - TestLeaf
	 * @throws IOException 
	 * @throws COSVisitorException 
	 */
	public boolean enterByName(String nameValue, String data) {
		boolean bReturn = false;
		try {
			driver.findElement(By.name(nameValue)).clear();
			driver.findElement(By.name(nameValue)).sendKeys(data);	
			System.out.println("The data: "+data+" entered successfully in field :");
			bReturn = true;

		} catch (Exception e) {
			System.err.println("The data: "+data+" could not be entered in the field :");
		}
		finally {
			takeSnap();
		}
		return bReturn;
	}

	/**
	 * This method will enter the value to the text field using Xpath attribute to locate
	 * 
	 * @param XpathValue - Xpath of the webelement
	 * @param data - The data to be sent to the webelement
	 * @author Babu - TestLeaf
	 * @throws IOException 
	 * @throws COSVisitorException 
	 */
	public boolean enterByXpath(String XpathValue, String data) {
		boolean bReturn = false;
		try {
			driver.findElement(By.xpath(XpathValue)).clear();
			driver.findElement(By.xpath(XpathValue)).sendKeys(data);	
			System.out.println("The data: "+data+" entered successfully in field :"+XpathValue);
			bReturn = true;

		} catch (Exception e) {
			System.err.println("The data: "+data+" could not be entered in the field :"+XpathValue);
		}
		finally {
			takeSnap();
		}
		return bReturn;
	}

	public boolean enterByXpathWithEnter(String idValue, String data){
		boolean bReturn = false;
		try {
			driver.findElement(By.xpath(idValue)).clear();
			driver.findElement(By.xpath(idValue)).sendKeys(data, Keys.ENTER);	
			System.out.println("The data: "+data+" entered successfully in field :"+idValue);
			bReturn = true;

		} catch (Exception e) {
			System.err.println("The data: "+data+" could not be entered in the field :"+idValue);

		}
		finally {
			takeSnap();
		}
		return bReturn;
	}


	/**
	 * This method will verify the title of the browser 
	 * @param title - The expected title of the browser
	 * @author Babu - TestLeaf
	 */
	public boolean verifyTitle(String title){
		boolean bReturn = false;
		try{
			if (driver.getTitle().equalsIgnoreCase(title)){
				System.out.println("The title of the page matches with the value :"+title);
				bReturn = true;
			}else
				System.err.println("The title of the page:"+driver.getTitle()+" did not match with the value :"+title);

		}catch (Exception e) {
			System.err.println("The title did not match");
		}
		finally {
			takeSnap();
		}

		return bReturn;
	}

	/**
	 * This method will verify the given text
	 * @param xpath - The locator of the object in xpath
	 * @param text  - The text to be verified
	 * @author Babu - TestLeaf
	 */
	public boolean verifyTextByXpath(String xpath, String text){
		boolean bReturn = false;
		String sText = driver.findElementByXPath(xpath).getText();
		if (driver.findElementByXPath(xpath).getText().trim().equalsIgnoreCase(text)){
			System.out.println("The text: "+sText+" matches with the value :"+text);
			bReturn = true;
		}else{
			System.err.println("The text: "+sText+" did not match with the value :"+text);
		}
		return bReturn;
	}

	/**
	 * This method will verify the given text
	 * @param xpath - The locator of the object in xpath
	 * @param text  - The text to be verified
	 * @author Babu - TestLeaf
	 */
	public boolean verifyTextContainsByXpath(String xpath, String text){
		boolean bReturn = false;
		String sText = driver.findElementByXPath(xpath).getText();
		if (driver.findElementByXPath(xpath).getText().trim().contains(text)){
			System.out.println("The text: "+sText+" contains the value :"+text);
			bReturn = true;
		}else{
			System.err.println("The text: "+sText+" did not contain the value :"+text);
		}


		return bReturn;
	}

	public boolean verifyTextContainsById(String idValue, String text){
		boolean bReturn = false;
		String sText = driver.findElementById(idValue).getText();
		if (driver.findElementById(idValue).getText().trim().contains(text)){
			System.out.println("The text: "+sText+" contains the value :"+text);
			bReturn = true;
		}else{
			System.err.println("The text: "+sText+" did not contain the value :"+text);
		}


		return bReturn;
	}

	/**
	 * This method will click the element using id as locator
	 * @param id  The id (locator) of the element to be clicked
	 * @author Babu - TestLeaf
	 */
	public boolean clickById(String id) {
		boolean bReturn = false;
		try{
			driver.findElement(By.id(id)).click();
			System.out.println("The element with id: "+id+" is clicked.");

			bReturn = true;

		} catch (Exception e) {
			System.err.println("The element with id: "+id+" could not be clicked.");
		}finally {
			takeSnap();
		}
		return bReturn;
	}

	/**
	 * This method will click the element using id as locator
	 * @param id  The id (locator) of the element to be clicked
	 * @author Babu - TestLeaf
	 */
	public boolean clickByClassName(String classVal) {
		boolean bReturn = false;
		try{
			driver.findElement(By.className(classVal)).click();
			System.out.println("The element with class Name: "+classVal+" is clicked.");
			bReturn = true;

		} catch (Exception e) {
			System.err.println("The element with class Name: "+classVal+" could not be clicked.");
		}finally {
			takeSnap();
		}
		return bReturn;
	}
	/**
	 * This method will click the element using name as locator
	 * @param name  The name (locator) of the element to be clicked
	 * @author Babu - TestLeaf
	 */
	public boolean clickByName(String name) {
		boolean bReturn = false;
		try{
			new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.name(name)));

			driver.findElement(By.name(name)).click();
			System.out.println("The element with name: "+name+" is clicked.");

			bReturn = true;

		} catch (Exception e) {
			System.err.println("The element with name: "+name+" could not be clicked.");
		}finally {
			takeSnap();
		}
		return bReturn;
	}

	/**
	 * This method will click the element using link name as locator
	 * @param name  The link name (locator) of the element to be clicked
	 * @author Babu - TestLeaf
	 * @throws Exception 
	 */
	public boolean clickByLink(String name) throws Exception{
		boolean bReturn = false;
		try{
			new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.linkText(name)));
			driver.findElement(By.linkText(name)).click();
			System.out.println("The element with link name: "+name+" is clicked.");
			bReturn = true;
		} catch (Exception e) {
			System.err.println("The element with link name: "+name+" could not be clicked.");
			throw new Exception("Stop the TESt");
		}finally {
			takeSnap();
		}
		return bReturn;
	}

	public boolean clickByLinkNoSnap(String name) throws Exception{
		boolean bReturn = false;
		try{
			new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.linkText(name)));
			driver.findElement(By.linkText(name)).click();
			System.out.println("The element with link name: "+name+" is clicked.");	
			bReturn = true;

		} catch (Exception e) {
			System.err.println("The element with link name: "+name+" could not be clicked.");
			throw new Exception("Stop the TESt");
		}
		return bReturn;
	}

	/**
	 * This method will click the element using Partial link name as locator
	 * @param name  The link name (locator) of the element to be clicked
	 * @author Babu - TestLeaf
	 * @throws Exception 
	 */
	public boolean clickByPartialLink(String name) throws Exception{
		boolean bReturn = false;
		try{
			new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.partialLinkText(name)));
			driver.findElement(By.partialLinkText(name)).click();
			System.out.println("The element with link name: "+name+" is clicked.");

			bReturn = true;

		} catch (Exception e) {
			System.err.println("The element with link name: "+name+" could not be clicked.");
			throw new Exception("Stop the TESt");
		}finally {
			takeSnap();
		}
		return bReturn;
	}

	/**
	 * This method will click the element using xpath as locator
	 * @param xpathVal  The xpath (locator) of the element to be clicked
	 * @author Babu - TestLeaf
	 */
	public boolean clickByXpath(String xpathVal) {
		boolean bReturn = false;
		try{
			new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath(xpathVal)));
			driver.findElement(By.xpath(xpathVal)).click();
			System.out.println("The element : "+xpathVal+" is clicked.");

			bReturn = true;

		} catch (Exception e) {
			System.err.println("The element with xpath: "+xpathVal+" could not be clicked.");
		}finally {
			takeSnap();
		}
		return bReturn;
	}

	public boolean clickByXpathNoSnap(String xpathVal) {
		boolean bReturn = false;
		try{
			new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath(xpathVal)));
			driver.findElement(By.xpath(xpathVal)).click();
			System.out.println("The element : "+xpathVal+" is clicked.");

			bReturn = true;

		} catch (Exception e) {
			System.err.println("The element with xpath: "+xpathVal+" could not be clicked.");
		}
		return bReturn;
	}

	/**
	 * This method will mouse over on the element using xpath as locator
	 * @param xpathVal  The xpath (locator) of the element to be moused over
	 * @author Babu - TestLeaf
	 */
	public boolean mouseOverByXpath(String xpathVal) {
		boolean bReturn = false;
		try{
			new Actions(driver).moveToElement(driver.findElement(By.xpath(xpathVal))).build().perform();
			System.out.println("The mouse over by xpath : "+xpathVal+" is performed.");

			bReturn = true;

		} catch (Exception e) {
			System.err.println("The mouse over by xpath : "+xpathVal+" could not be performed.");
		}finally {
			takeSnap();
		}
		return bReturn;
	}

	/**
	 * This method will mouse over on the element using link name as locator
	 * @param xpathVal  The link name (locator) of the element to be moused over
	 * @author Babu - TestLeaf
	 */
	public boolean mouseOverByLinkText(String linkName) {
		boolean bReturn = false;
		try{
			new Actions(driver).moveToElement(driver.findElement(By.linkText(linkName))).build().perform();
			System.out.println("The mouse over by link : "+linkName+" is performed.");

			bReturn = true;

		} catch (Exception e) {
			System.err.println("The mouse over by link : "+linkName+" could not be performed.");
		}finally {
			takeSnap();
		}
		return bReturn;
	}

	public String getTextByXpath(String xpathVal){
		String bReturn = "";
		try{
			bReturn = driver.findElement(By.xpath(xpathVal)).getText();
			System.out.println(bReturn);
		} catch (Exception e) {
			System.err.println("The element with xpath: "+xpathVal+" could not be found.");
		}finally {
			takeSnap();
		}
		return bReturn; 
	}

	public String getAttributeById(String idValue, String value){
		String bReturn = "";
		try{
			bReturn = driver.findElement(By.id(idValue)).getAttribute(value);
		} catch (Exception e) {
			System.err.println("The element with Id: "+idValue+" could not be found.");
		}finally {
			takeSnap();
		}
		return bReturn; 
	}

	public boolean switchToFrame(String nameOrId) {
		boolean bReturn = false;
		try {
			driver.switchTo().frame(nameOrId);

			bReturn = true;
		} catch (WebDriverException e1) {
		}finally {
			takeSnap();
		}
		return bReturn;
	}

	public boolean switchToDefault() {
		boolean bReturn = false;
		try {
			driver.switchTo().defaultContent(); 
			bReturn = true;
		} catch (WebDriverException e1) {
		}
		finally {
			takeSnap();
		}
		return bReturn;
	}

	public boolean alertAccept(){
		boolean bReturn = false;

		try {
			driver.switchTo().alert().accept();
			bReturn = true;
		} catch (Exception e) {

		}
		finally {
			takeSnap();
		}
		return bReturn;

	}

	public String getTextAndAcceptAlert(){
		String sText = "";
		try{
			sText = driver.switchTo().alert().getText();
			alertAccept();
		} catch(Exception e){

		}
		finally {
			takeSnap();
		}

		return sText;
	}

	public boolean switchToLastWindow() {
		boolean bReturn = false;
		try {
			Set<String> wHandles = driver.getWindowHandles();
			for (String wHandle : wHandles) {
				driver.switchTo().window(wHandle);				
			}
			bReturn = true;
		} catch (Exception e) {

		}
		finally {
			takeSnap();
		}
		return bReturn;
	}

	public boolean switchToParentWindow() {
		boolean bReturn = false;
		try{
			Set<String> wHandles = driver.getWindowHandles();
			for (String wHandle : wHandles) {
				driver.switchTo().window(wHandle);
				break;
			}
			bReturn = true;
		}catch (Exception e) {

		}
		finally {
			takeSnap();
		}

		return bReturn;

	}

	public boolean waitUseThread(int time) {
		boolean bReturn = false;
		try {
			Thread.sleep(time);
			bReturn = true;
		} catch (Exception e) {

		}
		finally {
			takeSnap();
		}
		return bReturn;
	}

	public String getTextById(String idVal) {

		// TODO Auto-generated method stub
		return null;
	}

	public void verifyTextById(String id, String text) {

		try {
			String getText = driver.findElementById(id).getText();
			if(getText.equals(text)){
				System.out.println("The Text: "+text+ "matched with the Element");

			}
		} catch (NoSuchElementException e) {

			System.err.println("The Text: "+text+ "counld not matched");

		}
	}

	public String verifyAttributeTextById(String id, String value, String txt) {
		String getText = "";
		try {
			getText = driver.findElementById(id).getAttribute(value);
			if(getText.equals(txt)){
				System.out.println("The Text: "+value+ " matched with the Element");

			}
		} catch (NoSuchElementException e) {

			System.err.println("The Text: "+value+ " counld not matched");

		}
		return getText;
	}

	public boolean selectByIndexById(String id, int value) {
		boolean bReturn = false;
		try{
			new Select(driver.findElement(By.id(id))).selectByIndex(value);;
			System.out.println("The element with id: "+id+" is selected with value :"+value);

			bReturn = true;

		} catch (Exception e) {
			System.err.println("The value: "+value+" could not be selected.");
		}
		finally {
			takeSnap();
		}
		return bReturn;
	}

	public boolean selectByValueById(String id, String value) {
		boolean bReturn = false;
		try{
			new Select(driver.findElement(By.id(id))).selectByValue(value);
			System.out.println("The element with id: "+id+" is selected with value :"+value);

			bReturn = true;

		} catch (Exception e) {
			System.err.println("The value: "+value+" could not be selected.");
		}
		finally {
			takeSnap();
		}
		return bReturn;
	}

	/**
	 * This method will select the drop down value using id as locator
	 * @param id The id (locator) of the drop down element
	 * @param value The value to be selected (visibletext) from the dropdown 
	 * @author Babu - TestLeaf
	 */
	public boolean selectVisibileTextById(String id, String value) {
		boolean bReturn = false;
		try{
			new Select(driver.findElement(By.id(id))).selectByVisibleText(value);
			System.out.println("The element with id: "+id+" is selected with value :"+value);

			bReturn = true;

		} catch (Exception e) {
			System.err.println("The value: "+value+" could not be selected.");
		}
		finally {
			takeSnap();
		}
		return bReturn;
	}

	public void takeSnap() {
		File srcFile1 = driver.getScreenshotAs(OutputType.FILE);
		File destFile1 = new File("./snaps/snap"+i+".jpeg");

		try {
			FileUtils.copyFile(srcFile1, destFile1);
		} catch (IOException e) {

			System.err.println("There was IO Exception while taking the SnapShot");
		}
		i++;


	}

	/**
	 * This method will close all the browsers
	 * @author Babu - TestLeaf
	 */
	public void quitBrowser() {
		try {
			driver.close();
			System.out.println("Browser Closed");
		} catch (Exception e) {
			System.err.println("The browser:"+driver.getCapabilities().getBrowserName()+" could not be closed.");
		}

	}

}