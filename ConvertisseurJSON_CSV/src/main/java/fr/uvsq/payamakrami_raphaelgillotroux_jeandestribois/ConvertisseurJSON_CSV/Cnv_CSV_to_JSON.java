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
	double counter =0;
	
	JSONObject ourObjects = new JSONObject();
	JSONArray allObjects = new JSONArray();
	
	
	public void Cnv_CSV_to_JSON() {
		
	}
	
	
	
	public void converteur_C_J() throws IOException {
		  CSVReader reader=new CSVReader(new FileReader("CSV_file"));
		  
		  CSV myfile;
		  
		  String[] nextLine;
		  List<String[]> allElements = reader.readAll();
		  /*
		  System.out.println("size::::"+allElements.size());
		  
		  allElements.forEach(new Consumer<String[]>() {
			@Override
			public void accept(String[] arr) {
				System.out.println(arr[0]);
			}
		});
		  */
		  writeJson(allElements);
		  
		  nextLine=reader.readNext();
		  //allElements[0]= (String)nextLine;
		  //System.out.println("size of datas:"+nextLine.length);
/*		  
		  while ((nextLine=reader.readNext()) != null) {
		    System.out.println("!!!!!!: [" + nextLine[0] + "]\n******: ["+ nextLine[1]+ "]\n$$$$$$: ["+ nextLine[2]+ "]");
		    System.out.println();
		  }
		  
		  //List<String[]> allElements=reader.readAll();
		  
		  
		  File file = new File("Converted_from_CSV"); 
		  FileWriter converted = new FileWriter(file);
		  CSVWriter writer2 = new CSVWriter(converted); 
		  writer2.writeAll(allElements);
		  
		  writer2.close();
*/		  
		  
		  //writer2.writeAll(allElements);
		  System.out.println("\n\nGenerated CSV File\n\n");
		  //System.out.println(sw.toString());
		}
	
	
	private void writeJson(List<String[]> allElements) {

//		System.out.println("size::::"+allElements.size());
//		System.out.println(allElements.get(0).length);

		
		//System.out.println(Arrays.toString(allElements.get(0)));
		//final ArrayList<String> myKeys = new ArrayList<String>();
		
		int c=0;
		
		for (String[] arr : allElements) {
			if (c == 0) {
				//System.out.println("setting keeeeeeeeys");
				
				for(int i=0; i<arr.length; i++) {
					Keys.add(arr[i]);
				}
				c++;
			}
			
			else {
				for(int i=0; i<arr.length; i++) {
					//System.out.println(Keys.get(i)+"   AAANNDDD   "+ arr[i]);
					ourObjects.put(Keys.get(i), arr[i]);
					
				}
				System.out.println();
			}
			
			allObjects.add(ourObjects);
			System.out.println("current size is::::::::: "+allObjects.get(0).toString());
			
			System.out.println("****************");
			for (Object key:ourObjects.keySet())
				System.out.println(ourObjects.get(key));
			
		}
		

//		  for (int i=0;i<4;i++) {
//			  System.out.println("current size is::::::::: "+allObjects.get(i).toString());
//		  }
		  
		  try (FileWriter file = new FileWriter("Converted_from_CSV_to_JSON.json")) {
				 
	            file.write(allObjects.toJSONString());
	            //file.flush();
	 
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		  
		  
		  
		 
		  //System.out.println(myKeys.get(0));
		  
	}
	
	
	
	
	
	
	
	
	
	
	
	private static void parseEmployeeObject(JSONObject employee) 
    {
        //Get employee object within list
        JSONObject employeeObject = (JSONObject) employee.get("employee");
         
        //Get employee first name
        String firstName = (String) employeeObject.get("firstName");    
        System.out.println(firstName);
         
        //Get employee last name
        String lastName = (String) employeeObject.get("lastName");  
        System.out.println(lastName);
         
        //Get employee website name
        String website = (String) employeeObject.get("website");    
        System.out.println(website);
    }
}
	
	
