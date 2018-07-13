package com.mailchimp.automation.model;

public class LeadersInfo {

	String mName;
	String mDesignation;
	String mDescription;
	
	public LeadersInfo(String mName, String mDesignation, String mDescription) {
		super();
		this.mName = mName;
		this.mDesignation = mDesignation;
		this.mDescription = mDescription;
	}
	
	public String getName() {
		return mName;
	}

	public void setName(String mName) {
		this.mName = mName;
	}
	
	public String getDesignation() {
		return mDesignation;
	}
	
	public void setDesignation(String mDesignation) {
		this.mDesignation = mDesignation;
	}
	
	public String getDescription() {
		return mDescription;
	}
	
	public void setDescription(String mDescription) {
		this.mDescription = mDescription;
	}
	
	@Override
	public String toString() {
		String data = getName() + "," + getDesignation() + "," + getDescription();
		
		return data;
	}

	
}
