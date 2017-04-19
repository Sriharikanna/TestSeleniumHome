package wordpresspackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WrapperClass   {

	  
	WebDriver driver;
	By Username = By.id("user_login");
	By Password = By.xpath("//*[@id='user_pass']");
	By Login_Button = By.id("wp-submit");
	By Title = By.id("title");
	By contents = By.id("content");
	By tagsinput = By.id("tags-input");
	By savepost = By.id("save-post");
	By Post = By.xpath("//[@id='menu-posts']/a");
	By Tags = By.xpath("//[@id='menu-posts']/div[3]/div/ul/li[4]/a");
	By tagname = By.id("tag-name");
	By Slug = By.id("tag-slug");
	By Description = By.id("tag-description");
	By addnewtag = By.id("submit");
			
	
	
	public WrapperClass (WebDriver driver)
	{
		this.driver=driver;
	}
	
public WrapperClass enterusername (String UID)
{
	driver.findElement(Username).sendKeys(UID);
	return this;
}

public WrapperClass enterpass (String pass)
{
	driver.findElement (Password).sendKeys(pass);
	return this;
}

public WrapperClass clickloginbutton ()
{
	driver.findElement(Login_Button).click();
	return this;
	}
public WrapperClass entertitle (String title)
{
	driver.findElement(Title).sendKeys(title);
	return this;
}
public WrapperClass entercontent (String content)
{
	driver.findElement(contents).sendKeys(content);
	return this;
	
}
public WrapperClass entertag (String tag)
{
	driver.findElement(tagsinput).sendKeys(tag);
	return this;
	}
public WrapperClass savepost ()
{
	driver.findElement(savepost).click();
	return this;
}

public WrapperClass CickPost ()
{
	driver.findElement(Post).click();
	return this;
}

public WrapperClass Clicktag()
{
	driver.findElement(Tags).click();
	return this;
}

public WrapperClass entertagname (String Tagname)
{
	driver.findElement(tagname).sendKeys(Tagname);
	return this;
}
public WrapperClass enterslugname (String slugname)
{
	driver.findElement(Slug).sendKeys(slugname);
	return this;
}
public WrapperClass enterDescription (String Desc)
{
	driver.findElement(Description).sendKeys(Desc);
	return this;
	
}
public WrapperClass clicknewtag ()
{
	driver.findElement(addnewtag).click();
		return this;
	
}
}

