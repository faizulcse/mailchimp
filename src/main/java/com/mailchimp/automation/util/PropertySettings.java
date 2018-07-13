package com.mailchimp.automation.util;

import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;


public class PropertySettings {
	
	Properties prop = null;
	private Map<Integer, String> browserList;
	private String browser;
	private String baseUrl;
	private String creatorUser;
	private String creatorPass;
	private String mailFrom;
	private String user;
	private String pass;
	
	private String mailTo;
	private String mailPassword;
	private int waitTime;
	private int state;
	private boolean loged;
	private String testngxml;
	
	private String dbhost;
	private String reportTime; //yyyy-MM-dd-hh-mm-ss
	private String year;
	private String month;
	private WebDriver mDriver;
	//private SessionBean session;
	
	private String messageNotSupport = "NotSupportedInfoWillGoesHere";
	
	private static PropertySettings instance = null;
	
	public static PropertySettings getInstance() {
	      if(instance == null) {
	         instance = new PropertySettings();
	         instance.loadData();
	      }
	      return instance;
	   }
	/** 
	 * construct setting information
	 **/
	private PropertySettings(){
		
	}
	
	public void loadData() {
		try{
            prop = new Properties();
            String filePath = AppConstant.SETTING_PATH;
            prop.load(new FileInputStream(filePath));
            
            this.state = 0;
            this.loged = false;
            this.baseUrl = prop.getProperty("url");
            this.creatorUser = prop.getProperty("creatorUser");
            this.creatorPass = prop.getProperty("creatorPass");
            this.user = prop.getProperty("user");
            this.pass = prop.getProperty("pass");
            
            this.mailFrom = prop.getProperty("mailfrom");
            this.mailPassword = prop.getProperty("mailpass");
            this.mailTo = prop.getProperty("mailto");
            
            this.testngxml = prop.getProperty("testngxml");
            this.waitTime = Integer.parseInt(prop.getProperty("waitTime"));
            this.browser = prop.getProperty("browser");
            this.browserList = parseBrowserList(this.browser);
            this.browser = this.browserList.get(0);
            
            this.dbhost = prop.getProperty("dbhost");
            
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss");
			//System.out.println(sdf.format(new Date()));
            this.reportTime = sdf.format(new Date());
            SimpleDateFormat ydf = new SimpleDateFormat("yyyy");
            this.year = ydf.format(new Date());
            SimpleDateFormat mdf = new SimpleDateFormat("MMMM");
            this.month = mdf.format(new Date());
//            this.session = new SessionBean();
//            CreateLogger.refreshLogData(AppConstant.TEST_CACHE_PATH);
		}catch (Exception e) {           
           System.out.println(e.getMessage());
	    }
	}
	
	public Properties getProperties() {
		return prop;
	}
	
	
	/**
	 * @return the messageNotSupport
	 */
	public String getMessageNotSupport() {
		return messageNotSupport;
	}


	/**
	 * @return the reportTime
	 */
	public String getReportTime() {
		return reportTime;
	}


	/**
	 * @return the year
	 */
	public String getYear() {
		return year;
	}


	/**
	 * @return the month
	 */
	public String getMonth() {
		return month;
	}

	/**
	 * @return the dbhost
	 */
	public String getDbhost() {
		return dbhost;
	}

	/**
	 * @return the waitTime
	 */
	public int getWaitTime() {
		return waitTime;
	}

	/**
	 * @return the user
	 */
	public String getUser() {
		return user;
	}

	/**
	 * @return the pass
	 */
	public String getPass() {
		return pass;
	}

	
	/**
	 * @return the testngxml
	 */
	public String getTestngxml() {
		return testngxml;
	}

	/**
	 * @return the state
	 */
	public int getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(int state) {
		this.state = state;
	}

	/**
	 * @return the isLogedout
	 */
	public boolean getLoged() {
		return loged;
	}

	/**
	 * @param isLogedout the isLogedout to set
	 */
	public void setLoged(boolean loged) {
		this.loged = loged;
	}

	/**
	 * @return the browsers
	 */
	public String getBrowser() {
		return browser;
	}

	/**
	 * @param browser the browser to set
	 */
	public void setBrowser(String browser) {
		this.browser = browser;
	}

	/**
	 * @return the browserList
	 */
	public Map<Integer, String> getBrowserList() {
		return browserList;
	}
	
	/*
	 * prepare and return browser list
	 */
	private Map<Integer, String> parseBrowserList(String browsers) {
		Map<Integer, String> tmpBrowserList = new HashMap<Integer, String>();
		
		String [] temp = browsers.split(",");				
		int i = 0;
		for(String browserString : temp) {
			tmpBrowserList.put(i, browserString.trim());
			i++;
		}
		return tmpBrowserList;
	}
	
	/**
	 * @return the baseUrl
	 */
	public String getBaseUrl() {
		return baseUrl;
	}
	
	/**
	 * @return the creatorUser
	 */
	public String getCreatorUser() {
		return creatorUser;
	}
	
	/**
	 * @return the creatorPass
	 */
	public String getCreatorPass() {
		return creatorPass;
	}
	
	/**
	 * @return the mailFrom
	 */
	public String getMailFrom() {
		return mailFrom;
	}
	
	/**
	 * @return the mailTo
	 */
	public String getMailTo() {
		return mailTo;
	}
	
	/**
	 * @return the mailPassword
	 */
	public String getMailPassword() {
		return mailPassword;
	}
	
	/**
	 * To print setting information in terminal
	 */
	public void print(){
		System.out.println(getBrowser());
		System.out.println(getBaseUrl());
		System.out.println(getCreatorUser());
		System.out.println(getCreatorPass());
		System.out.println(getMailFrom());
		System.out.println(getMailPassword());
		System.out.println(getMailTo());
	}

	public void setWebDriver(WebDriver driver) {
		mDriver = driver;
	}
	
	public WebDriver getCurrentDriver() {
		return mDriver;
	}

}
