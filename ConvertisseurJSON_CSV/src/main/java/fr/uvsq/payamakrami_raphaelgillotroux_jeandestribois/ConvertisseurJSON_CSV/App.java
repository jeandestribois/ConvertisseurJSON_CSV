package fr.uvsq.payamakrami_raphaelgillotroux_jeandestribois.ConvertisseurJSON_CSV;

import java.io.IOException;

/**
 * La classe App est la classe principale du principale du projet.
 * 
 * @author jean
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
    	Interface dialogue = new Interface();
    	dialogue.confFileChoice();
    	dialogue.conversionChoice();
    	dialogue.fileToReadChoice();
    	dialogue.fileToWriteChoice();
    	Convertisseur conv = new Convertisseur(dialogue.getFileToRead(), dialogue.getFileToWrite());
    	conv.convertirCsvToJson();
    }
}
