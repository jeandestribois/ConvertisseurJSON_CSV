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
import java.util.List;

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
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.Charset;



public class Cnv_CSV_to_JSON {
	
	public static void main(String[] args) throws IOException {
		  CSVReader reader=new CSVReader(new FileReader("CSV_file"));
		  
		  CSV myfile;
		  
		  String[] nextLine;
		  
		  while ((nextLine=reader.readNext()) != null) {
		    System.out.println("!!!!!!: [" + nextLine[0] + "]\n******: ["+ nextLine[1]+ "]\n$$$$$$: ["+ nextLine[2]+ "]");
		    System.out.println();
		  }
		  
		  CSVReader reader2=new CSVReader(new FileReader("CSV_file"));
		  List<String[]> allElements=reader2.readAll();
		  
		  
		  File file = new File("Converted_from_CSV"); 
		  FileWriter converted = new FileWriter(file);
		  CSVWriter writer2 = new CSVWriter(converted); 
		  writer2.writeAll(allElements);
		  
		  writer2.close();
		  
		  //writer2.writeAll(allElements);
		  System.out.println("\n\nGenerated CSV File:\n\n");
		  //System.out.println(sw.toString());
		}
	
	
}