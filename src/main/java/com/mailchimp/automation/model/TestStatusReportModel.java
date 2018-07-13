package com.mailchimp.automation.model;

import java.util.HashMap;
import java.util.Map;

public class TestStatusReportModel {

	static int m_nTotalPass;
	static int m_nTotalSkip;
	static int m_nTotalFailed;
	
	static Map<String,String> mapCaseStatus = new HashMap<String,String>();

	
	public static void addTestStatus(String strTestName,String strStatus){
		mapCaseStatus.put(strTestName, strStatus);
	}
	
	public static void clearTestStatus(){
		mapCaseStatus.clear();
	}
	
	public static void setTotalPass(int nValue){
		m_nTotalPass = nValue;
	}
	
	public static void setTotalSkip(int nValue){
		m_nTotalSkip = nValue;
	}
	
	public static void setTotalFailed(int nValue){
		m_nTotalFailed = nValue;
	}
	
	public static int getTotalPass(){
		return m_nTotalPass;
	}
	
	public static int getTotalSkip(){
		return m_nTotalSkip;
	}
	
	public static int getTotalFailed(){
		return m_nTotalFailed;
	}
}
