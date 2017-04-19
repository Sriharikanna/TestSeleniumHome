package Attributes;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class InvocationTimeOut {
	@Test(invocationCount = 7,/*threadPoolSize = 2,*/ invocationTimeOut = 10000)
	/*
	 * This code will iterate for 7 times by using 3 browser, threadPoolSize is
	 * to mention how many browser should run in parallel manner. The
	 * invocationTimeOut is a condition to complete the entire test process in
	 * defined seconds basically it is calculated in milli seconds so here we
	 * defined as 30seconds.
	 */
	public void createLead() {
		// initialize chrome driver
		System.setProperty("webdriver.chrome.driver", "D:\\selenium\\drivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		// maximize browser
		//driver.manage().window().maximize();
		// open Url
		driver.get("http://leaftaps.com/control/main");
		// enter the username
		driver.findElementById("username").sendKeys("DemoSalesManager");

		// enter the password
		driver.findElementById("password").sendKeys("crmsfa");
		// submit the login button
		driver.findElementByClassName("decorativeSubmit").click();
		// Click CRM/SFA
		driver.findElementByLinkText("CRM/SFA").click();
		// click contact
		driver.findElementByLinkText("Create Contact").click();
		// create contact
		driver.findElementByXPath("//*[@id='firstNameField']").sendKeys("Shree");
		driver.findElementByXPath("//*[@id='lastNameField']").sendKeys("Kanna");
		driver.findElementById("createContactForm_firstNameLocal").sendKeys("S");
		driver.findElementById("createContactForm_lastNameLocal").sendKeys("K");
		driver.findElementById("createContactForm_personalTitle").sendKeys("Er.");
		driver.findElementById("createContactForm_generalProfTitle").sendKeys("AutomationExpert");
		driver.findElementById("createContactForm_departmentName").sendKeys("Amazon");
		WebElement dDown6 = driver.findElementById("createContactForm_preferredCurrencyUomId");
		Select preF = new Select(dDown6);
		preF.selectByValue("INR");
		driver.findElementById("createContactForm_description").sendKeys("Practising Selenium");
		driver.findElementById("createContactForm_importantNote").sendKeys("Testing on March");
		driver.findElementById("createContactForm_primaryPhoneCountryCode").sendKeys("2");
		driver.findElementById("createContactForm_primaryPhoneAreaCode").sendKeys("34");
		driver.findElementById("createContactForm_primaryPhoneNumber").sendKeys("3");
		driver.findElementById("createContactForm_primaryPhoneExtension").sendKeys("56");
		driver.findElementById("createContactForm_primaryPhoneAskForName").sendKeys("464");
		driver.findElementById("createContactForm_primaryEmail").sendKeys("viper@gmail.com");
		driver.findElementById("createContactForm_primaryPhoneAskForName").sendKeys("Shree");
		driver.findElementByXPath("//*[@id='generalToNameField']").sendKeys("Shree");
		driver.findElementById("createContactForm_generalAttnName").sendKeys("Listen");
		driver.findElementByXPath("//*[@id='createContactForm_generalAddress1']").sendKeys("2/715");
		driver.findElementByXPath("//*[@id='createContactForm_generalAddress2']").sendKeys("Chn");
		driver.findElementById("createContactForm_generalCity").sendKeys("chennai");
		driver.findElementById("createContactForm_generalStateProvinceGeoId").click();
		driver.findElementById("createContactForm_generalStateProvinceGeoId").sendKeys("Georgia");
		driver.findElementByXPath("//*[@id='createContactForm_generalPostalCode']").sendKeys("608702");
		driver.findElementById("createContactForm_generalCountryGeoId").click();
		driver.findElementById("createContactForm_generalCountryGeoId").sendKeys("Australia");
		driver.findElementById("createContactForm_generalPostalCodeExt").sendKeys("08");
		driver.findElementByName("submitButton").click();
		driver.close();

	}

}
