package com.mailchimp.automation;

import com.mailchimp.automation.util.SendMail;
import com.mailchimp.automation.suite.TestStarter;
import com.mailchimp.automation.model.TestStatusReportModel;

public class MailChimpApp 
{
    public static void main( String[] args )
    {
    	System.out.println("Prepare Setting");
    	
    	TestStarter testStarter = new TestStarter();
		testStarter.start();
		
//		int nFailCount = TestStatusReportModel.getTotalFailed();
//		if (nFailCount > 0) {
//			 SendMail.sendmail();			
//		}
//		else {
//			System.out.println("No fail");
//		}
    }
}
