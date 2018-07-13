package com.mailchimp.automation.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShot {
	private static String screenshotsFolder = AppConstant.SCREEN_SHOT_DIR;

	private static String imageExtention = ".png";

	/*
	 * this method will take the driver screenshot
	 */
	public static void captureScreen(WebDriver driver, String screenshotFileName) {
		String screenshotsFile = screenshotsFolder + screenshotFileName
				+ imageExtention;
		// System.out.println(screenshotsFile);
		try {
			File screenShot = ((TakesScreenshot) driver)
					.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenShot, new File(screenshotsFile));
		} catch (IOException e) {
			CreateLogger.enterLogData(AppConstant.ERROR_LOG_PATH,
					e.getMessage() + "\n");
		}
	}

	public static void makeOutputDirectory() {
		PropertySettings setting = PropertySettings.getInstance();
		screenshotsFolder += setting.getBrowser() + "TestReport/"
				+ setting.getYear() + "/" + setting.getMonth() + "/"
				+ setting.getReportTime() + "/";

		File f = new File(screenshotsFolder);
		try {
			if (f.exists() == false) {
				f.mkdir();
				System.out.println("Directory Created");
			} else {
				System.out.println("Directory is not created");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
