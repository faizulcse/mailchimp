package com.mailchimp.automation;

import com.mailchimp.automation.suite.TestStarter;

public class MailChimpApp 
{
    public static void main( String[] args )
    {
    	System.out.println("Prepare Setting");
    	
    	TestStarter testStarter = new TestStarter();
		testStarter.start();
    }
}
