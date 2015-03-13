package com.sorting;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class clsProduct {
	public String product_name;
	public String manufacturer;
	public String model;
	public String family;
	public String announced_date;
	public String str_json;
	
	private ArrayList<String> arlist=new ArrayList<String>();
	
	public void getValues(String s)
	{
		str_json=s.trim();
		try {
			JSONParser parser=new JSONParser();		
			JSONObject obj = (JSONObject) parser.parse(s);
			try{
				product_name=(String) obj.get("product_name");
				product_name=product_name.replace("_"," ");
				product_name=product_name.trim();
			}catch(Exception e){}
			
			try{
				manufacturer=(String) obj.get("manufacturer");
				manufacturer=manufacturer.replace("_"," ");
				manufacturer=manufacturer.trim();
			}catch(Exception e){}

			try{
				model=(String) obj.get("model");
				model=model.replace("_"," ");
				model=model.trim();
			}catch(Exception e){}
			
			try{
				family=(String) obj.get("family");
				family=family.replace("_"," ");
				family=family.trim();
			}catch(Exception e){}
			
			try{
				announced_date=(String) obj.get("announced_date");
				announced_date=announced_date.replace("_"," ");
				announced_date=announced_date.trim();
			}catch(Exception e){}
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	
	public void addStr(String lst)
	{
		try {
			arlist.add(lst);			
		}catch(Exception e){}
	}
	
	public String toString()
	{
		String sret="{\"product_name\":"+"\""+product_name+"\"";
		sret=sret+",\"listings\":[";
		try{
			sret=sret+arlist.get(0);
			for(int i=1;i<arlist.size();i++){
				sret=sret+","+arlist.get(i);
			}
			
		}catch(Exception e){}
		sret=sret+"]}";
		return sret;
	}
	
	public static  void getFromFile(ArrayList<clsProduct> products)
	{
		BufferedReader reader = null;
		FileReader fr=null;
		try{
			String fpath="src\\com\\text\\products.txt";
			fr=new FileReader(fpath);
			reader = new BufferedReader(fr);
			String line = null;		
			
			if( products ==null){
				products= new ArrayList<clsProduct>();
			}
			
	        while ( (line = reader.readLine()) != null) {
	        	clsProduct cp=new clsProduct();
	        	if(line.trim().length()>0){
	        		cp.getValues(line);
	        		products.add(cp);
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
