package seleniumlearning;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Crmsfa_create_contact {

	public static void main(String[] args) {
			//initialize chrome driver
				System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
				ChromeDriver driver = new ChromeDriver(); 
		//maximize browser
				driver.manage().window().maximize();
		//open Url
				driver.get("http://leaftaps.com/control/main");
		//enter the username
				driver.findElementById("username").sendKeys("DemoSalesManager");
				
		//enter the password
				driver.findElementById("password").sendKeys("crmsfa");
		//submit the login button
				driver.findElementByClassName("decorativeSubmit").click();
		//Click CRM/SFA
				driver.findElementByLinkText("CRM/SFA").click();
		//click contact
				driver.findElementByLinkText("Create Contact").click();
	    //create contact
				driver.findElementByXPath("//*[@id='firstNameField']").sendKeys("Raja");
				driver.findElementByXPath("//*[@id='lastNameField']").sendKeys("Kuna");
				driver.findElementById("createContactForm_firstNameLocal").sendKeys("R");
				driver.findElementById("createContactForm_lastNameLocal").sendKeys("K");
				driver.findElementById("createContactForm_personalTitle").sendKeys("T");
				driver.findElementById("createContactForm_generalProfTitle").sendKeys("Tester");
				driver.findElementById("createContactForm_departmentName").sendKeys("CTS");
				WebElement dDown6=driver.findElementById("createContactForm_preferredCurrencyUomId");
				Select preF =new Select (dDown6);
				preF.selectByValue("INR");
				driver.findElementById("createContactForm_description").sendKeys("Practising Selenium");
				driver.findElementById("createContactForm_importantNote").sendKeys("Testing on March");
				driver.findElementById("createContactForm_primaryPhoneCountryCode").sendKeys("2");
				driver.findElementById("createContactForm_primaryPhoneAreaCode").sendKeys("34");
				driver.findElementById("createContactForm_primaryPhoneNumber").sendKeys("3");
				driver.findElementById("createContactForm_primaryPhoneExtension").sendKeys("56");
				driver.findElementById("createContactForm_primaryPhoneAskForName").sendKeys("464");
				driver.findElementById("createContactForm_primaryEmail").sendKeys("raja@gmail.com");
				driver.findElementById("createContactForm_primaryPhoneAskForName").sendKeys("Raj");
				driver.findElementByXPath("//*[@id='generalToNameField']").sendKeys("Raja");
				driver.findElementById("createContactForm_generalAttnName").sendKeys("Listen");
				driver.findElementByXPath("//*[@id='createContactForm_generalAddress1']").sendKeys("2/715");
				driver.findElementByXPath("//*[@id='createContactForm_generalAddress2']").sendKeys("sethiathope");
				driver.findElementById("createContactForm_generalCity").sendKeys("chennai");
				driver.findElementById("createContactForm_generalStateProvinceGeoId").click();
				driver.findElementById("createContactForm_generalStateProvinceGeoId").sendKeys("Georgia");
				driver.findElementByXPath("//*[@id='createContactForm_generalPostalCode']").sendKeys("608702");
				driver.findElementById("createContactForm_generalCountryGeoId").click();
				driver.findElementById("createContactForm_generalCountryGeoId").sendKeys("Australia");
				driver.findElementById("createContactForm_generalPostalCodeExt").sendKeys("08");
				driver.findElementByName("submitButton").click();
				
	
	}

}
