package com.automation.v1.utilities;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.testng.annotations.Test;

public class BrokenLinkVerification {
	
	private static URL myurl;
	
	public static boolean LinkVerification(String url) throws IOException {
		
		myurl=new URL(url);
		
		HttpURLConnection connection=(HttpURLConnection)myurl.openConnection();
		
		connection.connect();
		
		if(connection.getResponseCode()>=400) {
			return false;
		}
		else
			return true;
		
		
		
		
		
	}

}
