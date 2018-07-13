package com.mailchimp.automation;

import com.mailchimp.automation.suite.TestStarter;
import com.mailchimp.automation.util.PropertySettings;

public class MailChimpApp 
{
    public static void main( String[] args )
    {
    	System.out.println("Prepare Setting");
    	
    	TestStarter testStarter = new TestStarter();
		testStarter.start();
    }
}
