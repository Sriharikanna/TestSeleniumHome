package seleniumlearning;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
public class Irctc {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

				//initialize chrome driver
						System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
						ChromeDriver driver = new ChromeDriver(); 
				//maximize browser
						driver.manage().window().maximize();
				//launch the URL
						driver.get("https://www.irctc.co.in/eticketing/userSignUp.jsf");
				//implicit wait
						driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				//enter values for user name
						driver.findElementById("userRegistrationForm:userName").sendKeys("rajasekaran1101101");
				//enter password
						driver.findElementById("userRegistrationForm:password").sendKeys("Raja_2201R");
				//confirm password
						driver.findElementById("userRegistrationForm:confpasword").sendKeys("Raja_2201R");
				//Security question
						WebElement dDown =driver.findElementById("userRegistrationForm:securityQ");
						Select secD = new Select(dDown);
			
				//selecting an index
						secD.selectByIndex(1);
						Thread.sleep(2000);
				//security answer
						driver.findElementById("userRegistrationForm:securityAnswer").sendKeys("Kujaskvj");
				//selecting language
						WebElement dDown1=driver.findElementById("userRegistrationForm:prelan");
						Select langD = new Select (dDown1);
						langD.selectByValue("hi");
				//enter first name
						driver.findElementById("userRegistrationForm:firstName").sendKeys("Rajasekaran");
				//enter middle name
						driver.findElementById("userRegistrationForm:middleName").sendKeys("Rajasekaran");
				//enter last name
						driver.findElementById("userRegistrationForm:lastName").sendKeys("kunasekaran");
						
				//enter gender
						driver.findElementById("userRegistrationForm:gender:0").click();
				//enter marital status
						driver.findElementById("userRegistrationForm:maritalStatus:0").click();
						
				//select occupation
						WebElement dDown2=driver.findElementById("userRegistrationForm:occupation");
						Select occU = new Select(dDown2);
						occU.selectByVisibleText("SelfEmployed");
				//enter aadhar card number
						driver.findElementById("userRegistrationForm:uidno").sendKeys("835yhoe0");
				//enter pan card number
						driver.findElementById("userRegistrationForm:idno").sendKeys("BXFPK1243Q");
				//enter email
						driver.findElementById("userRegistrationForm:email").sendKeys("rajasekaran1101@gmail.com");
				//enter phone
						driver.findElementById("userRegistrationForm:mobile").sendKeys("9524888588");
				//enter nationality
						WebElement dDown3 =driver.findElementById("userRegistrationForm:nationalityId");
						Select natioN = new Select(dDown3);
						natioN.selectByValue("94");
				//enter residential address
				//enter flat/door/block no
						driver.findElementById("userRegistrationForm:address").sendKeys("2/715 east street");
				//enter street lane
						driver.findElementById("userRegistrationForm:street").sendKeys("east street, allur");
				//enter area
						driver.findElementById("userRegistrationForm:area").sendKeys("Sethiathope");
				//enter country
						
						WebElement dDown4=driver.findElementById("userRegistrationForm:countries");
						Select counT = new Select(dDown4);
						counT.selectByVisibleText("India");
				//enter pin code
						driver.findElementById("userRegistrationForm:pincode").sendKeys("608702");
				//enter state
						//driver.findElementById("userRegistrationForm:statesName").sendKeys("tamilnadu");
				//enter phone
						driver.findElementById("userRegistrationForm:maritalStatus:0").click();
								

	}

}
