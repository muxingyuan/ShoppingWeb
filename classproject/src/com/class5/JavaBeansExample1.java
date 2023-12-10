package com.class5;

import java.io.Serializable;

public class JavaBeansExample1 implements Serializable {

	private String level = "half-backed";
	private String goesWith = "hot dogs";
	
	public String getLevel(){
		return(level);
	}
	
	public void setLevel (String newLevel) {
		level = newLevel;
	}
	
	public String getGoesWith(){
		return(goesWith);		
	}
	
	public void getGoesWith(String dish){
		goesWith = dish;
	}
}
