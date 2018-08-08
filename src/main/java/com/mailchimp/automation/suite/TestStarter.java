package com.mailchimp.automation.suite;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;

import com.mailchimp.automation.util.*;

/*
 * this class will help to execute test suite
 */
public class TestStarter {

	private List<String> suites;
	private TestListenerAdapter tla;
	private TestNG testng;

	public TestStarter() {
	}

	/** this will run the whole test suite */
	public void start() {
		testng = new TestNG();
		testng.setVerbose(0);
		try {
			suites = new ArrayList<String>();
			tla = new CustomTestListener();

			testng.setOutputDirectory(AppConstant.TESTNG_REPORT_DIR + PropertySettings.getInstance().getBrowser()
					+ "TestReport/" + PropertySettings.getInstance().getYear() + "/"
					+ PropertySettings.getInstance().getMonth() + "/" + PropertySettings.getInstance().getReportTime()); // yyyy-MM-dd-hh-mm-ss
			suites.add(AppConstant.TEST_SUITE_XML + PropertySettings.getInstance().getTestngxml());

			testng.setTestSuites(suites);
			testng.addListener(tla);
			testng.run();
		} catch (Exception ex) {
			// System.out.println(ex.getMessage());
			String errorMsg = "Error reported on: " + new Date() + "\nEither Testsuite '" + testng.getDefaultSuiteName()
					+ "' and TestCases in '" + testng.getDefaultTestName() + "' does not exist.\n";
			System.out.println(errorMsg);
			ex.printStackTrace();
			CreateLogger.enterLogData(AppConstant.ERROR_LOG_PATH, errorMsg);
		}

		// this.stop();
	}

	public void stop() {
		TestHelper.getInstance().cleanUpDriver();
	}

}
