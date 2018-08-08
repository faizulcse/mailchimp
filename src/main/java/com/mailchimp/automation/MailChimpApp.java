package com.mailchimp.automation;

import com.mailchimp.automation.util.PropertySettings;
import com.mailchimp.automation.util.SendMail;
import com.mailchimp.automation.suite.TestHelper;
import com.mailchimp.automation.suite.TestStarter;
import com.mailchimp.automation.model.TestStatusReportModel;

public class MailChimpApp {
	public static void main(String[] args) {
		
		System.out.println("Prepare Setting");
		PropertySettings.getInstance().loadData();

		System.out.println("Prepare Driver");
		TestHelper.getInstance().setUpDriver();
		TestHelper.getInstance().loadURL();

		System.out.println("Start Test");
		TestStarter testStarter = new TestStarter();
		testStarter.start();

//			int nFailCount = TestStatusReportModel.getTotalFailed();
//			if (nFailCount > 0) {
//				 SendMail.sendmail();			
//			}
//			else {
//				System.out.println("No fail");
//			}

		System.out.println("Stop Test");
		testStarter.stop();
	}
}
