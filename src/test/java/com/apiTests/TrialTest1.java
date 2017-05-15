package com.apiTests;
import java.io.IOException;

import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.*;

//need check below website later
//http://sahajamit.github.io/Cucumber-JVM-with-TestNG/

public class TrialTest1 {
	static String root = "https://jsonplaceholder.typicode.com";
	
		//	+ "/posts";
	    // +  "/posts/1"
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//create client
		HttpClient client = new HttpClient();
		
		//create method
		GetMethod method = new GetMethod(root+"/posts/1");
		
		int statusCode;
		try {
			//execute method
			statusCode = client.executeMethod(method);
			
			if(statusCode != HttpStatus.SC_OK){
				System.out.println("method failed!"+method.getStatusLine());
			}
			
			//get the content
			byte[] responseBody  =method.getResponseBody();
			
			System.out.println(method.getStatusLine()+"\nThe content is:\n"+new String(responseBody));
			
		} catch (HttpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			method.releaseConnection();
		}
			

	}

}
