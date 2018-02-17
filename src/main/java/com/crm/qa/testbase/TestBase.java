package com.crm.qa.testbase;
import java.io.FileInputStream;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.crm.qa.utl.WebEventListener;
public class TestBase {
	public static WebDriver driver;
	public static Properties props;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	public TestBase() {
		try {
			FileInputStream fin=new FileInputStream("C:\\Users\\USER\\eclipse-workspace\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			props=new Properties();
			props.load(fin);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public static void initialization() {
		String BrowserName=props.getProperty("browser");
		if(BrowserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","E:\\drivers\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		    e_driver = new EventFiringWebDriver(driver);
		    // Now create object of EventListerHandler to register it with EventFiringWebDriver
		    eventListener = new WebEventListener();
		    e_driver.register(eventListener);
		    driver = e_driver;
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(4000,TimeUnit.SECONDS);
		    driver.get(props.getProperty("url"));
			
	}

}
