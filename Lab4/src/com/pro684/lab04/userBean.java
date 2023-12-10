package com.pro684.lab04;

import java.io.Serializable;

public class userBean implements Serializable {

	private String name = "unknown";
	private String address = "unknown";
	private String education = "unknown";
	
	public String getName(){
		return(name);
	}
	
	public void setName (String newname) {
		this.name = newname;
	}
	
	public String getAddress(){
		return(address);
	}
	
	public void setAddress (String newaddress) {
		this.address = newaddress;
	}

	public String getEducation(){
		return(education);
	}
	
	public void setEducation (String neweducation) {
		this.education = neweducation;
	}

}
