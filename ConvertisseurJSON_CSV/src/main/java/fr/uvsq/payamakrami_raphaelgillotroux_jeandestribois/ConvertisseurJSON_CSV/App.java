package fr.uvsq.payamakrami_raphaelgillotroux_jeandestribois.ConvertisseurJSON_CSV;

import java.io.IOException;
import org.json.simple.parser.ParseException;

/**
 * La classe App est la classe principale du principale du projet.
 * 
 * @author Payam
 *
 */
public class App 
{
	
    public static void main( String[] args ) throws IOException, ParseException
    {

    	
    	System.out.println("FAIRE LE FICHIER CSV");
    	
    	Cnv_CSV_to_JSON c = new Cnv_CSV_to_JSON();
    	c.converteur_C_J();
    	
    	
    	
    	System.out.println("FAIRE LE FICHIER JSON");
    	
    	Cnv_JSON_to_CSV j = new Cnv_JSON_to_CSV();
    	j.converteur_J_C();
    }
    
}
