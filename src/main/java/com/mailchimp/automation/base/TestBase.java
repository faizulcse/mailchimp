package com.mailchimp.automation.base;


import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.mailchimp.automation.util.*;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	public TestBase(){
		prop = PropertySettings.getInstance().getProperties();
	}
	
	public static void initialization(){
		String osName = prop.getProperty("os");
		String browserName = prop.getProperty("browser");
		
		if(osName.equals("windows")) {
			if(browserName.equals("chrome")){
				System.setProperty("webdriver.chrome.driver", AppConstant.CHROME_DRIVER_WINDOWS);	
				driver = new ChromeDriver(); 
			}
			else if(browserName.equals("firefox")){
			System.setProperty("webdriver.gecko.driver", AppConstant.FIRE_FOX_DRIVER_WINDOWS);	
				driver = new FirefoxDriver(); 
			}
		}
		else if(osName.equals("mac")) {
			if(browserName.equals("chrome")){
				System.setProperty("webdriver.chrome.driver", AppConstant.CHROME_DRIVER_MAC);	
				driver = new ChromeDriver(); 
			}
			else if(browserName.equals("firefox")){
			System.setProperty("webdriver.gecko.driver", AppConstant.FIRE_FOX_DRIVER_MAC);	
				driver = new FirefoxDriver(); 
			}
		}
				
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		PropertySettings.getInstance().setWebDriver(driver);
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		//driver.manage().timeouts().pageLoadTimeout(AppConstant.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(AppConstant.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	}
	
}
