package com.app.eyemanage.utility;

public class Utils {
	
	public Utils() {
		// TODO Auto-generated constructor stub
	}
	
	public static boolean validatePass(String pass,String cnfPass) {
		
		return pass.equals(cnfPass);
	}

}
