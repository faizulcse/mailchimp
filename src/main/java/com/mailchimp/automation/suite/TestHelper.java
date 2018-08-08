package com.mailchimp.automation.suite;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.mailchimp.automation.util.AppConstant;
import com.mailchimp.automation.util.PropertySettings;
import com.mailchimp.automation.util.WebEventListener;


public class TestHelper {
	public static WebDriver mDriver=null;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	private TestHelper(){
		
	}
	
	private static TestHelper instance = null;
	
	public static TestHelper getInstance() {
		if(instance == null) {
			instance = new TestHelper();
			prop = PropertySettings.getInstance().getProperties();
	  	}
	  	return instance;
	}
	
	public void setUpDriver() {
		String osName = prop.getProperty("os");
		String browserName = prop.getProperty("browser");
		
		if(osName.equals("windows")) {
			if(browserName.equals("chrome")){
				System.setProperty("webdriver.chrome.driver", AppConstant.CHROME_DRIVER_WINDOWS);	
				mDriver = new ChromeDriver(); 
			}
			else if(browserName.equals("firefox")){
				System.setProperty("webdriver.gecko.driver", AppConstant.FIRE_FOX_DRIVER_WINDOWS);	
				mDriver = new FirefoxDriver(); 
			}
		}
		else if(osName.equals("mac")) {
			if(browserName.equals("chrome")){
				System.setProperty("webdriver.chrome.driver", AppConstant.CHROME_DRIVER_MAC);	
				mDriver = new ChromeDriver(); 
			}
			else if(browserName.equals("firefox")){
				System.setProperty("webdriver.gecko.driver", AppConstant.FIRE_FOX_DRIVER_MAC);	
				mDriver = new FirefoxDriver(); 
			}
		}else {
			System.err.println("\nUnknown Browser :: either no such browser installed or browser string is invalid.\n");
			System.exit(0);
		}
				
		e_driver = new EventFiringWebDriver(mDriver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		mDriver = e_driver;
	}
	
	public void loadURL() {
		if(null != mDriver) {
			mDriver.manage().window().maximize();
			mDriver.manage().deleteAllCookies();
			//mDriver.manage().timeouts().pageLoadTimeout(AppConstant.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			mDriver.manage().timeouts().implicitlyWait(AppConstant.IMPLICIT_WAIT, TimeUnit.SECONDS);
			
			mDriver.get(prop.getProperty("url"));
		}
	}
	
	public void cleanUpDriver() {
		if(null != mDriver) {
			mDriver.quit();
			mDriver = null;
		}
	}
	
	public void setWebDriver(WebDriver driver) {
		mDriver = driver;
	}
	
	public WebDriver getCurrentDriver() {
		if(mDriver == null) {
			setUpDriver();
		}
		
		return mDriver;
	}

}
