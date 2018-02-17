package com.crm.qa.utl;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.testbase.*;
public class DynamicXpath extends TestBase{
	public static void main(String[] args) {
	
			WebDriver driver;
			System.setProperty("webdriver.chrome.driver","E:\\drivers\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(4000,TimeUnit.SECONDS);
			driver.get("https://www.freecrm.com");
			driver.findElement(By.name("username1")).sendKeys("naveenk");;
			driver.findElement(By.name("password")).sendKeys("test@123");
			driver.findElement(By.xpath("//input[@value='Login']")).click();
			driver.switchTo().frame("mainpanel");
			driver.findElement(By.xpath("//a[text()='Contacts']")).click();
			driver.findElement((By.xpath("//a[text()='Alex Vank']/parent::td/preceding-sibling::td/input[@type='checkbox']"))).click();
		
	}

}
