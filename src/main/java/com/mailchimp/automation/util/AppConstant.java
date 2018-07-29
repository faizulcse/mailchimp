package com.mailchimp.automation.util;

public class AppConstant {
	private AppConstant () { } // prevents instantiation
	
	public static final String CURRENT_DIR = System.getProperty("user.dir");
	
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 20;
	
	public static final String CHROME_DRIVER_MAC = CURRENT_DIR+"//driver//chromedriver";
	public static final String CHROME_DRIVER_WINDOWS = CURRENT_DIR+"//driver//chromedriver.exe";
	
	public static final String FIRE_FOX_DRIVER_MAC = CURRENT_DIR+"//driver//geckodriver";
	public static final String FIRE_FOX_DRIVER_WINDOWS = CURRENT_DIR+"//driver//geckodriver.exe";
	
	public static final String SETTING_PATH = CURRENT_DIR+"//config//setting.conf";
	public static final String TEST_SUITE_XML = CURRENT_DIR+"//config//";
	public static final String CSV_FILE_PATH = CURRENT_DIR+"//data//";
	
	public static final String ERROR_LOG_PATH = CURRENT_DIR+"//assets//log//error.log";
	public static final String TEST_LOG_PATH = CURRENT_DIR+"//assets//log//";
	public static final String SCREEN_SHOT_DIR = CURRENT_DIR+"//assets//screenshots//";
	public static final String TESTNG_REPORT_DIR = CURRENT_DIR+"//assets//";
	
	public static final String PATH_TEST_DATA = CURRENT_DIR+"//data//";
	public static final String FILE_TEST_DATA = "LeadershipData.xlsx";
}
