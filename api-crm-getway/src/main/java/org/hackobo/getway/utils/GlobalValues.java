package org.hackobo.getway.utils;

public class GlobalValues {
	private static GlobalValues instance;
	
	public static GlobalValues getInstance() {
		if( instance == null ) {
			instance = new GlobalValues();
		}
		return instance;
	}
	
	
	
}
