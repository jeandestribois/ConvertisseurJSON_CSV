package fr.uvsq.payamakrami_raphaelgillotroux_jeandestribois.ConvertisseurJSON_CSV;



/**
 * La classe Cnv_JSON_to_CSV est la convertiseur de JSON a CSV.
 * 
 * 
 * @author Payam
 */
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



public class Cnv_JSON_to_CSV{
	
	Cnv_JSON_to_CSV(){
		
	}
	
	public void converteur_J_C() throws IOException, ParseException{
		
		JSONParser jsonParser = new JSONParser();
        
        try (FileReader reader = new FileReader("JSON_file"))
        {
        	JSONParser parser = new JSONParser();
        	Object obj  = parser.parse(reader);
        	JSONArray array = new JSONArray();
        	array.add(obj);
        	

        	System.out.println(array.size());
        	for(int i=0;i<array.size();i++){
        	     //JSONObject site = (JSONObject)array.get(i); // Exception happens here.
        	     System.out.println(array.get(i));
        	     System.out.println();
        	    }
            //System.out.println(array);
             
	}
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
	

}
}