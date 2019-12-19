package fr.uvsq.payamakrami_raphaelgillotroux_jeandestribois.ConvertisseurJSON_CSV;
/**
 * La classe Cnv_CSV_to_JSON est la convertiseur de CSV a JSON.
 * 
 * 
 * @author Payam
 */


import java.io.FileReader;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSV;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;





public class Convertisseur {
	
	private ArrayList<String> Keys = new ArrayList<String>();
	
	
	private JSONObject ourObjects;
	private JSONArray allObjects;
	private FileReader fileToRead;
	private FileWriter fileToWrite;
	
	public Convertisseur(FileReader fileToRead, FileWriter fileToWrite) {
		this.ourObjects = new JSONObject();
		this.allObjects = new JSONArray();
		this.fileToRead = fileToRead;
		this.fileToWrite = fileToWrite;
	}
	
	
	
	public void convertirCsvToJson() throws IOException {
		  CSVReader reader=new CSVReader(this.fileToRead);
		  
		  CSV myfile;
		  
		  String[] nextLine;
		  List<String[]> allElements = reader.readAll();
		 
		  writeJson(allElements);
		}
	
	
	private void writeJson(List<String[]> allElements) throws IOException {
		int c=0;
		
		for (String[] arr : allElements) {
			if (c == 0) {
				for(int i=0; i<arr.length; i++) {
					Keys.add(arr[i]);
				}
				c++;
			}
			
			else {
				for(int i=0; i<arr.length; i++) {
					ourObjects.put(Keys.get(i), arr[i]);
					
				}
				System.out.println();
			}
			
			allObjects.add(ourObjects);
		}
		this.fileToWrite.write(allObjects.toJSONString());  
	}
}
