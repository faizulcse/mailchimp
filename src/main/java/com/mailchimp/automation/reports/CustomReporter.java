package com.mailchimp.automation.reports;

import java.util.List;
import java.util.Map;


import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

import com.mailchimp.automation.util.*;

import com.mailchimp.automation.model.TestStatusReportModel;

import java.util.Date;

public class CustomReporter implements ITestListener, IReporter{
	protected PropertySettings pSettings = null;

	public void onFinish(ITestContext arg0) {
	}

	public void onStart(ITestContext context) {
		if (pSettings == null) {
			//pSettings = (PropertySettings) context.getAttribute("setting");
			pSettings = PropertySettings.getInstance();
		}
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
	}

	public void onTestStart(ITestResult arg0) {
	}

	public void onTestSuccess(ITestResult itr) {
		// String tcName = itr.getMethod().getMethodName();
		String msg = "";
		try {
			if (itr.getAttribute("msg") != null) {
				msg = itr.getAttribute("msg").toString();
				System.out.println(msg);
			}
		} catch (Exception e) {
		}

	}

	public void onTestFailure(ITestResult itr) {
		// String tcName = itr.getMethod().getMethodName();
		String msg = "";
		try {
			if (itr.getAttribute("msg") != null) {
				msg = itr.getAttribute("msg").toString();
				System.out.println(msg);
			}
		} catch (Exception e) {
		}
	}

	public void onTestSkipped(ITestResult itr) {
		try {
			System.out.println(itr.getAttribute("msg").toString());
		} catch (Exception e) {
		}
	}

	/**
	 * generate customize report overriding the testng generateReport() method
	 */
	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites,
			String outputDirectory) {

		String suiteWisereportSummary = "";
		String summaryReport = "\n***" + pSettings.getBaseUrl() + "***\n";
		String summaryLog = "";

		int totalPassed = 0;
		int totalSkipped = 0;
		int totalFailed = 0;
		int totalRun = 0;

		/* Iterating over each suite included in the test */
		for (ISuite suite : suites) {
			/* Following code gets the suite name */
			String suiteName = suite.getName();
			/* Getting the results for the said suite */
			Map<String, ISuiteResult> suiteResults = suite.getResults();

			suiteWisereportSummary += "\nTests suite '" + suiteName + "' for "
					+ pSettings.getBrowser() + " browser";
			suiteWisereportSummary += "\n===============================================================\n";

			String testName = "";
			for (Map.Entry<String, ISuiteResult> sr : suiteResults.entrySet()) {
				ITestContext tc = sr.getValue().getTestContext();
				testName = tc.getName();

				int testWisePassed = tc.getPassedTests().getAllResults().size();
				int testWiseSKipped = tc.getSkippedTests().getAllResults()
						.size();
				int testWiseFailed = tc.getFailedTests().getAllResults().size();
				int testWiseTotal = tc.getAllTestMethods().length;

				suiteWisereportSummary += "\nSummary for Test: " + testName
						+ "\n";
				suiteWisereportSummary += "-----------------------------------------------";
				suiteWisereportSummary += "\nPassed - " + testWisePassed;
				suiteWisereportSummary += "\nSkipped - " + testWiseSKipped;
				suiteWisereportSummary += "\nFailed - " + testWiseFailed;
				suiteWisereportSummary += "\nTotal test case run - "
						+ testWiseTotal + "\n";
				suiteWisereportSummary += "-----------------------------------------------";

				// counts suitewise passed, skipped, failed & total testcases
				totalPassed += testWisePassed;
				totalSkipped += testWiseSKipped;
				totalFailed += testWiseFailed;
				totalRun += testWiseTotal;

			}

			summaryReport += "\n==================================\n";
			summaryReport += "Test Result Summary: " + pSettings.getBrowser()
					+ " browser\n";
			summaryReport += "----------------------------------\n";
			summaryReport += "Total Passed: " + totalPassed;
			summaryReport += "\nTotal Skipped: " + totalSkipped;
			summaryReport += "\nTotal Failed: " + totalFailed;
			summaryReport += "\nTotal Run: " + totalRun;
			summaryReport += "\n==================================\n";
			summaryLog = suiteWisereportSummary + summaryReport;
		}
		System.out.println(summaryReport);
		CreateLogger.enterLogData(AppConstant.TEST_CACHE_PATH, summaryReport);
		logWrite(suites, summaryLog);
		
		TestStatusReportModel.setTotalPass(totalPassed);
		TestStatusReportModel.setTotalSkip(totalSkipped);
		TestStatusReportModel.setTotalFailed(totalFailed);
	
	}

	/**
	 * Writing log
	 */
	private void logWrite(List<ISuite> suites, String summaryLog) {
		String logSummary = "-----------------------" + new Date()
				+ "----------------------\n";

		for (ISuite suite : suites) {
			/* Following code gets the suite name */
			logSummary += "\nExecuted Suite Name : " + suite.getName() + "\n";
			/* Getting the results for the said suite */
			Map<String, ISuiteResult> suiteResults = suite.getResults();

			for (Map.Entry<String, ISuiteResult> sr : suiteResults.entrySet()) {
				// String testName = sr.getMethod().getMethodName();
				ITestContext tc = sr.getValue().getTestContext();
				logSummary += "\nExecuted Test Name : " + tc.getName() + "\n";

				logSummary += "\n----------------------------------\n";
				for (ITestResult t : tc.getPassedTests().getAllResults()) {
					logSummary += "\nExecuted TestCase Name : "
							+ t.getMethod().getMethodName()
							+ ", Status : Passed\n";
					try {
						logSummary += "Message: " + t.getAttribute("msg")
								+ "\n";
					} catch (Exception e) {
					}
				}
				logSummary += "\n----------------------------------\n";
				for (ITestResult t : tc.getFailedTests().getAllResults()) {
					logSummary += "\nExecuted TestCase Name : "
							+ t.getMethod().getMethodName()
							+ ", Status : Failed,"
							+ t.getMethod().getDescription() + "\n";
					try {
						logSummary += "Message: " + t.getAttribute("msg")
								+ "\n";
					} catch (Exception e) {
					}
				}
				logSummary += "\n----------------------------------\n";
				for (ITestResult t : tc.getSkippedTests().getAllResults()) {
					logSummary += "\nExecuted TestCase Name : "
							+ t.getMethod().getMethodName()
							+ ", Status : Skipped\n";
					try {
						logSummary += "Message: " + t.getAttribute("msg")
								+ "\n";
					} catch (Exception e) {
					}
				}
			}
		}

		logSummary = logSummary + "\n" + summaryLog
				+ "\n----------------------------------\n";
		CreateLogger.refreshLogData(AppConstant.TEST_LOG_PATH
				+ pSettings.getBrowser() + ".log");
		CreateLogger.enterLogData(
				AppConstant.TEST_LOG_PATH + pSettings.getBrowser() + ".log",
				logSummary);

	}

}
