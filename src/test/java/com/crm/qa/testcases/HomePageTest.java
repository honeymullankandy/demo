package com.crm.qa.testcases;
import static org.testng.Assert.assertEquals;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.crm.qa.pages.*;
import com.crm.qa.testbase.*;
import com.crm.qa.utl.*;
public class HomePageTest  extends TestBase{
	LoginPage log;
	HomePage home;
	ContactsPage contact;
	TestUtil testUtl;
	HomePageTest(){
		super();
		}
	@BeforeMethod
	public void Initialization() {
		try {
			initialization();
			log=new LoginPage();
			testUtl=new TestUtil();
			String uname=props.getProperty("username");
			String pwd=props.getProperty("password");
			Thread.sleep(2000);
			home=log.login(uname, pwd);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}	
	@Test(priority=1)
	public void titleTest() {
		String title=home.getHomepageTitle();
		Assert.assertEquals(title,"CRMPRO");
		
		}
	@Test(priority=2)
	public void loginUserTest() {
		testUtl.moveToFrame();
		String username=home.loginUser();
		Assert.assertEquals(username,"  User: Naveen K");
		}
	@Test(priority=3)
	public void contactLinkTest() {
		testUtl.moveToFrame();
		contact=home.clickOnContactLink();
		
	}
	@AfterMethod
	public void tearDown()
	   {
		driver.quit();
	   }
}
