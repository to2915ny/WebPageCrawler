package edu.handong.csee.java.webpagecrawler;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class HTMLsave {
	
	
	
	public void writeFile(ArrayList <String>url,String dest) {
		String fileName = dest+"/outputResult.html";
		PrintWriter output = null;
		ArrayList<String>list = url;
		try {
			output = new PrintWriter(fileName);



		} catch(FileNotFoundException e) {
			System.out.println("Error occured to open " + fileName);
			System.exit(0);
		}
		for(int i=0; i<list.size(); i++) {

			output.print(list.get(i));
			
		}
		output.close();
		
		
		
	}
}
