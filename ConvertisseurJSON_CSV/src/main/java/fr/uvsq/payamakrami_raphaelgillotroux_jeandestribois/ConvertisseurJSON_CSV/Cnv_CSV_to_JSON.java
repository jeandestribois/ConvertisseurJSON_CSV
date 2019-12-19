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
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;
import au.com.bytecode.opencsv.CSV;


import static au.com.bytecode.opencsv.CSVParser.DEFAULT_ESCAPE_CHARACTER;
import static au.com.bytecode.opencsv.CSVParser.DEFAULT_IGNORE_LEADING_WHITESPACE;
import static au.com.bytecode.opencsv.CSVParser.DEFAULT_QUOTE_CHARACTER;
import static au.com.bytecode.opencsv.CSVParser.DEFAULT_SEPARATOR;
import static au.com.bytecode.opencsv.CSVParser.DEFAULT_STRICT_QUOTES;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.Charset;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;




public class Cnv_CSV_to_JSON {
	
	ArrayList<String> Keys = new ArrayList<String>();
	
	
	JSONObject ourObjects = new JSONObject();
	JSONArray allObjects = new JSONArray();
	
	
	public void Cnv_CSV_to_JSON() {
		
	}
	
	
	
	public void converteur_C_J() throws IOException {
		  CSVReader reader=new CSVReader(new FileReader("CSV_file")); //lire le fichier CSV
		  
		  CSV myfile;
		  
		  String[] nextLine;
		  List<String[]> allElements = reader.readAll();			// enregistrer les lignes du fichier CSV
	

		  writeJson(allElements);
		  
		}
	
	
	private void writeJson(List<String[]> allElements) {

		int c=0;
		
		for (String[] arr : allElements) {
			
			if (c == 0) {								//lire qu'une seule fois la 1ere ligne: enregistrer les cles 
				for(int i=0; i<arr.length; i++) {
					Keys.add(arr[i]);
				}
				c++;
			}
			
			else {										//ajouter chaque valeur a ca cle correspondante
				for(int i=0; i<arr.length; i++) { 
					ourObjects.put(Keys.get(i), arr[i]);
					
				}
				System.out.println();
			
			
			allObjects.add(ourObjects);
			
			ourObjects = new JSONObject();
			
//			for (int i=0;i<allObjects.size();i++) {
//				  System.out.println("current array is::::::::: "+allObjects.get(i).toString());
//			  }
			
			
//			System.out.println("****************");
//			for (Object key:ourObjects.keySet())
//				System.out.println(ourObjects.get(key));
			
			}
			
			 
			
		}
		

//		  for (int i=0;i<allObjects.size();i++) {
//			  System.out.println("current size is::::::::: "+allObjects.get(i).toString());
//		  }
		  
		  try (FileWriter file = new FileWriter("Converted_from_CSV_to_JSON")) {
				 
	            file.write(allObjects.toJSONString());
	            file.flush();
	 
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		  
		  
		  
		 
		  //System.out.println(myKeys.get(0));
		  
	}
}
	
	
