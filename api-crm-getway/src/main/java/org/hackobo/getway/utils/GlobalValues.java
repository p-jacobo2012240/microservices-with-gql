package org.hackobo.getway.utils;

public class GlobalValues {
	private static GlobalValues instance;
	
	public static GlobalValues getInstance() {
		if( instance == null ) {
			instance = new GlobalValues();
		}
		return instance;
	}
	
	//geneal values
	private static final String API_CRM = "http://localhost:8001/api/v1";
	
	
	
}
