package edu.handong.csee.java.webpagecrawler;

import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.io.*;

public class URLreader  {
	ArrayList<String> list = new ArrayList<String>();
	public void readURL(String path) {
		
	try {
	 URL url = new URL(path);
	
	
     BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream(),"UTF-8"));

     String inputLine;
     
     while ((inputLine = in.readLine()) != null) {
    	 list.add(inputLine);
         //System.out.println(inputLine);
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

