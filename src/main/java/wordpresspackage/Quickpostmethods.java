package wordpresspackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Quickpostmethods {
	WebDriver driver;
	
	By Title = By.id("title");
	By content = By.id("content");
	By tagsinput = By.id("tags-input");
	By savepost = By.id("save-post");
	
	public Quickpostmethods (WebDriver driver)
	{
		this.driver=driver;
	}
	
	public Quickpostmethods EnterTitle (String title)
	{
		driver.findElement(Title).sendKeys(title);
		return this;
	}
	
	public  Quickpostmethods Entercontent (String Content)
	{
		driver.findElement(content).sendKeys(Content);
		return this;
	}
	
	public Quickpostmethods Entertagsinput (String Tagname)
	{
		driver.findElement(tagsinput).sendKeys(Tagname);
		return this;
	}
	public  Quickpostmethods savepost ()
	{
		driver.findElement(savepost).click();
		return this;
	}
	

}
