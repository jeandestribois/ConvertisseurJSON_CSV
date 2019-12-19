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

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.type.MapType;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Cnv_JSON_to_CSV{
	
	private static ObjectMapper mapper = new ObjectMapper();
	 
	
	
	Cnv_JSON_to_CSV(){
		
	}
	
	/*
	public void parse(String json) throws JsonProcessingException, IOException  {
	       JsonFactory factory = new JsonFactory();

	       ObjectMapper mapper = new ObjectMapper(factory);
	       JsonNode rootNode = mapper.readTree(json);  

	       Iterator<Map.Entry<String,JsonNode>> fieldsIterator = rootNode.fields();
	       
	       System.out.println(rootNode.fields());
	       
	       while (fieldsIterator.hasNext()) {
	    	   
	           Map.Entry<String,JsonNode> field = fieldsIterator.next();
	           System.out.println("Key: " + field.getKey() + "\tValue:" + field.getValue());
	       }
	       
	       System.out.println("done?");
	}
	
	
	
    static JsonNode getExampleRoot() throws IOException {
        InputStream exampleInput = Cnv_JSON_to_CSV.class.getClassLoader().getResourceAsStream("JSON_file");
         
        JsonNode rootNode = mapper.readTree(exampleInput);
        
        System.out.println("$$$$$"+rootNode.size());
        return rootNode;
    }
    
    
    public JsonNode whenParsingJsonStringIntoJsonNode_thenCorrect(String jsonString ) 
    		  throws JsonParseException, IOException {
    		    String jsonStrin = "{\"employee\":{\"firstName\":\"Lokesh\",\"lastName\":\"Gupta\",\"website\":\"howtodoinjava.com\"}}";
    		 
    		    ObjectMapper mapper = new ObjectMapper();
    		    JsonNode node = mapper.readValue(jsonStrin, JsonNode.class);
    		    if (node.isObject()) {
    		        ObjectNode obj = mapper.convertValue(node, ObjectNode.class);
    		        if (obj.has("a")) {
    		            System.out.println("a=" + obj.get("a").asDouble());
    		        }
    		    }
    		    
    		    return node;
//    		    ObjectMapper mapper = new ObjectMapper();
//    		    JsonNode actualObj = mapper.readTree(jsonString);
//    		    
//    		    prettyPrintJsonString(actualObj);
//    		    
//    		    return actualObj;
    		 
    		    //assertNotNull(actualObj);
    		}
    
    public String prettyPrintJsonString(JsonNode jsonNode) {
    	System.out.println("$$$$$");
        try {
            ObjectMapper mapper = new ObjectMapper();
            Object json = mapper.readValue(jsonNode.toString(), Object.class);
            return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(json);
        } catch (Exception e) {
            return "Sorry, pretty print didn't work";
        }
    }
	
	*/
	public void converteur_J_C() throws IOException, ParseException{
	/*
		JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader("JSON_file"))
        {
        	JSONParser parser = new JSONParser();
        	Object obj  = parser.parse(reader);
        	JSONArray array = new JSONArray();
        	array.add(obj);
        	

        	System.out.println(array.size());
    */	
        	
        	
        	
        	try (InputStream is = new FileInputStream("JSON_file"))
        	{
	        	BufferedReader buf = new BufferedReader(new InputStreamReader(is));
	        	String line = buf.readLine(); StringBuilder sb = new StringBuilder();
	        	while(line != null){ sb.append(line).append("\n"); line = buf.readLine();
	        	}
	        	
	        	String json = sb.toString();
	
	        	ObjectMapper mapper = new ObjectMapper();
	        	MapType type = mapper.getTypeFactory().constructMapType(Map.class, String.class, Object.class);
	        	Map<String, Object> data = mapper.readValue(json, type);
	        	
	        	/*
	        	for(int i=0;i<array.size();i++){
	        	     //JSONObject site = (JSONObject)array.get(i); // Exception happens here.
	        	     System.out.println(array.get(i));
	        	     System.out.println();
	        	    }
	        	*/
	        	
	        	
	        	System.out.println();System.out.println();
	        	
	        	System.out.println("size of the tree :    "+data.size());
	        	
	        	System.out.println("keys are :   "+data.keySet());
	        	
	        	
	        	for (String k :data.keySet()) 
	        		System.out.println(data.get(k));
	        	
        	
             
	}
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
	

}
	
	
	private void printJSONOBject(JSONObject jsonObject) {
	    for (Object keyObj : jsonObject.keySet()) {
	        String key = (String) keyObj;
	        Object valObj = jsonObject.get(key);
	        if (valObj instanceof JSONObject) {
	            printJSONOBject((JSONObject) valObj);
	        } else {
	            System.out.println(key + " : " + valObj);
	        }
	    }
	}
}