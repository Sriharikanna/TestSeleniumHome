package seleniumlearning;

import org.openqa.selenium.chrome.ChromeDriver;

public class Alltypesoffunctions {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\selenium\\drivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://testleaf.herokuapp.com/home.html");
		driver.manage().window().maximize();
		System.err.println("************Performing actions in Edit page****************");
		driver.findElementByXPath("//h5[text()='Edit']").click();
		driver.findElementById("email").sendKeys("Srihari.muruhan@gmail.com");
		driver.findElementByXPath("//div[@class='example']/following::div/div/div/input").sendKeys("+Appended");
		driver.findElementByName("username").sendKeys("+Srihari");
		Thread.sleep(3000);
		// This is to get the value of the textbox
		System.out.println("Getting the value of the attribute");
		System.out.println(driver.findElementByName("username").getAttribute("value"));
		driver.findElementByXPath("(//input[@name='username'])[2]").clear();
		System.out.println("The textbox you're referring here is Disabled(False)/Enabled(True):" + "\""
				+ driver.findElementByXPath("//input[@disabled='true']").isEnabled() + "\"");
		Thread.sleep(2000);
		driver.navigate().back();
		System.err.println("************Performing actions in button page****************");
		driver.findElementByXPath("//h5[text()='Button']").click();
		System.out.println("Printing the location using getLocation "
				+ driver.findElementByXPath("//button[text()='Get Position']").getLocation());
		System.out.println("The color in rgb: "
				+ driver.findElementByXPath("//button[text()='What color am I?']").getCssValue("color"));
		System.out.println("The dimension of the button is: "
				+ driver.findElementByXPath("//button[text()='What is my size?']").getSize());
		// driver.close();

	}
}
