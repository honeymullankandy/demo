package com.crm.qa.pages;
import com.crm.qa.testbase.TestBase;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.eclipse.jetty.util.annotation.Name;
import org.openqa.selenium.support.PageFactory;
import com.crm.qa.utl.TestUtil;
public class HomePage extends TestBase {
	//OR
		@FindBy(xpath="//a[text()='Contacts']")
		WebElement contactPage;
		@FindBy(xpath="//a[text()='Deals']")
		WebElement dealPage;
		@FindBy(xpath="//a[text()='Tasks']")
		WebElement taskPage;
		@FindBy(xpath="//td[contains(text(),'User')]")
		WebElement Loginuser;
		@FindBy(xpath="//a[@title='New Contact']")
		WebElement contactNew;
		TestUtil testUtl;
		public HomePage() {
			PageFactory.initElements(driver,this);
			}
		public String loginUser() {
			return Loginuser.getText();
		}
		public String getHomepageTitle() {
			return driver.getTitle();
		}
		public ContactsPage clickOnContactLink() {
			contactPage.click();
			return new ContactsPage();
			
		}
		public DealsPage clickOnDealLink() {
			dealPage.click();
			return new DealsPage();
			
		}
		public TaskPage clickOnTaskLink() {
			taskPage.click();
			return new TaskPage();
			
		}
		public void clickOnNewContact() {
			Actions act=new Actions(driver);
			act.moveToElement(contactPage).build().perform();
			contactNew.click();
			
		}
		
		}
		

		

