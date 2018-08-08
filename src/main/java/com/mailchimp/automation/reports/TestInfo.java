package com.mailchimp.automation.reports;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface TestInfo {
   String tcName() default "";	
	String feature() default "";
	String expectedResult() default "";
}
