package com.crm.qa.pages;
import com.crm.qa.testbase.TestBase;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import org.eclipse.jetty.util.annotation.Name;
import org.openqa.selenium.support.PageFactory;
public class LoginPage extends TestBase {
	//OR
	@FindBy(xpath="//input[@name='username']")
	WebElement username;
	@FindBy(name="password")
	WebElement passwd;
	
	@FindBy(xpath="//button[text()='Sign Up']")
	WebElement SignUpbutn;
	@FindBy(xpath="//input[@value='Login']")
	WebElement Login;
    public LoginPage() {
    	PageFactory.initElements(driver,this);
    }
    public String loginTitle() {
    	return driver.getTitle();
    }
	public HomePage login(String userName,String pwd) {
		username.sendKeys(userName);
		passwd.sendKeys(pwd);
		Login.click();
		return new HomePage();
	}
	public void signup() {
		SignUpbutn.click();
	}
	}
