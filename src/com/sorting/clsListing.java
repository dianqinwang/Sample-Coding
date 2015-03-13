package com.sorting;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class clsListing {
	public String title;
	public String manufacturer;
	public String currency;
	public String price;
	public String str_json;

	public void getValues(String s)
	{
		str_json=s.trim();
		try {
			JSONParser parser=new JSONParser();		
			JSONObject obj = (JSONObject) parser.parse(s);
			try{
				title=(String) obj.get("title");
				title=title.replace("_"," ");
				title=title.trim();
			}catch(Exception e){}
			
			try{
				manufacturer=(String) obj.get("manufacturer");
				manufacturer=manufacturer.replace("_"," ");
				manufacturer=manufacturer.trim();
			}catch(Exception e){}

			try{
				currency=(String) obj.get("currency");
				currency=currency.replace("_"," ");
				currency=currency.trim();
			}catch(Exception e){}
			
			try{
				price=(String) obj.get("price");
				price=price.replace("_"," ");
				price=price.trim();
			}catch(Exception e){}
		
						
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	public static  void getFromFile(ArrayList<clsListing> listings)
	{
		BufferedReader reader = null;
		FileReader fr=null;
		try{
			String fpath="src\\com\\text\\listings.txt";
			fr=new FileReader(fpath);
			reader = new BufferedReader(fr);
			String line = null;		
			
			if( listings ==null){
				listings= new ArrayList<clsListing>();
			}
			
	        while ( (line = reader.readLine()) != null) {
	        	clsListing cp=new clsListing();
	        	if(line.trim().length()>0){
	        		cp.getValues(line);
	        		listings.add(cp);
	        	};
	        }
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		try {
			reader.close();
			fr.close();		
		} catch (IOException e) {}  
	}	
}
