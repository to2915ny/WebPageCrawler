package edu.handong.csee.java.webpagecrawler;

import java.net.*;
import java.util.ArrayList;
import java.io.*;

public class URLreader  {
	ArrayList<String> list = new ArrayList<String>();
	public void readURL() {
		
	try {
	 URL url = new URL("https://www.google.com/");
	
	
     BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

     String inputLine;
     
     while ((inputLine = in.readLine()) != null) {
    	 list.add(inputLine);
         System.out.println(inputLine);
     }
     in.close();
	}
	catch(IOException e) {
		System.err.println("Error: " + e);
	}
	}
	
	public ArrayList<String> getURL() {
		return list;
	}

}

