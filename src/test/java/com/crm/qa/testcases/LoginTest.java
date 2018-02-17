package com.crm.qa.testcases;
import static org.testng.Assert.assertEquals;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.crm.qa.pages.*;
import com.crm.qa.testbase.*;
public class LoginTest extends TestBase{
	LoginPage log;
	LoginTest(){
		super(); 
	}
	@BeforeMethod
	public void Initialization() {
		initialization();
		log=new LoginPage();
		
	}
	@Test
	public void LogincaseTest() {
		String uname=props.getProperty("username");
		String pwd=props.getProperty("password");
		HomePage home=log.login(uname, pwd);
		
	}
	@Test
	public void titleTest() {
		String Title=log.loginTitle();
		Assert.assertEquals(Title,"#1 Free CRM for Any Business: Online Customer Relationship Software");
	}
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	}
	
