package edu.handong.csee.java.webpagecrawler;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.ArrayList;

public class HTMLsave {
	
	
	
	public void writeFile(ArrayList <String>url,String dest) {
		String fileName = dest+"/outputResult.html";
		Writer outPut= null;
		ArrayList<String>list = url;
		try {
			outPut = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName), "UTF-8"));
			


		} catch(FileNotFoundException e) {
			System.out.println("Error occured to open " + fileName);
			System.exit(0);
		}
		catch(UnsupportedEncodingException e) {
			System.out.println("File not in UTF-8");
			System.exit(0);
		}
		try {
		for(String line : url) {

			outPut.write(line);
			
		}
		outPut.close();
		}catch(IOException e) {
			System.out.println("Error occured to write " + fileName);
			System.exit(0);
		}
		
		
		
		
		
	}
}
