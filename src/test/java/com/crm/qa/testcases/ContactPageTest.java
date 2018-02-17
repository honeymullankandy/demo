package com.crm.qa.testcases;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.crm.qa.pages.*;
import com.crm.qa.testbase.*;
import com.crm.qa.utl.*;
public class ContactPageTest extends TestBase{
	LoginPage log;
	HomePage home;
	ContactsPage contact;
	TestUtil testUtl;
	ContactPageTest(){
		super();
		}
	@BeforeMethod
	public void Initialization() {
	
			initialization();
			log=new LoginPage();
			testUtl=new TestUtil();
			contact=new ContactsPage();
			String uname=props.getProperty("username");
			String pwd=props.getProperty("password");
			home=log.login(uname, pwd);
			testUtl.moveToFrame();
			contact=home.clickOnContactLink();
		
		}	
		@Test(priority=1)
	public void contactpageTest() {
		Assert.assertTrue(contact.contactpageTest());		
	}
	@Test(priority=2)
	public void contactListTest() {
		contact.selectContact("Alex Vank");
	}
	@DataProvider
	public Object[][] getCRMdata(){
		Object  data[][]=testUtl.getTestData("Contacts");
		return data;
	}
	
	@Test(priority=3,dataProvider="getCRMdata")
	public void clickOnNewContactTest(String title,String fname,String lname,String Compny) {
		home.clickOnNewContact();
		contact.NewContactTest(title,fname,lname,Compny);
	}
	//@Test(priority=4)
	//public void addContactTest() {
		
	//}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
		
}