package com.crm.qa.pages;
import com.crm.qa.testbase.TestBase;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.eclipse.jetty.util.annotation.Name;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
public class ContactsPage extends TestBase{
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactlabel;
	
	@FindBy(name="title")
	WebElement title;
	
	@FindBy(name="first_name")
	WebElement firstname;
	
	@FindBy(name="surname")
	WebElement surname;
	
	@FindBy(name="client_lookup")
	WebElement comapny;
	
	@FindBy(xpath="//input[@value='Save']")
	WebElement save;
	
	
	//input[@name='']
	
	public ContactsPage(){
		PageFactory.initElements(driver,this);
	}
	public void selectContact(String name) {
		driver.findElement((By.xpath("//a[text()='"+name+"']/parent::td/preceding-sibling::td/input[@type='checkbox']"))).click();
	}
	public boolean contactpageTest()
	{
		return contactlabel.isDisplayed();
	}
	public void NewContactTest(String Title,String Firstname,String Lastname,String Company)
	{
		try {
			Select select=new Select(title);
			select.selectByVisibleText(Title);
			firstname.sendKeys(Firstname);
			surname.sendKeys(Lastname);
			comapny.sendKeys(Company);
			Thread.sleep(3000);
			save.click();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
    }
}
	
