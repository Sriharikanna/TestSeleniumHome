package wordpresspackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;




public class Loginmethods {
	WebDriver driver;
	
	
	By Username = By.id("user_login");
	By Password = By.xpath("//*[@id='user_pass']");
	By Login_Button = By.id("wp-submit");
	
	public Loginmethods (WebDriver driver)
	{
		this.driver=driver;
	}
	
	public Loginmethods EnterUsername (String UID)
	{
		driver.findElement(Username).sendKeys(UID);
		return this;
	}

	public Loginmethods EnterPassword (String PWD)
	{
		driver.findElement(Password).sendKeys(PWD);
		return this;
	}
	
	public Quickpostmethods ClickLogin_Button ()
	{
		driver.findElement(Login_Button).click();
		return new Quickpostmethods(driver);
		
	}

}
