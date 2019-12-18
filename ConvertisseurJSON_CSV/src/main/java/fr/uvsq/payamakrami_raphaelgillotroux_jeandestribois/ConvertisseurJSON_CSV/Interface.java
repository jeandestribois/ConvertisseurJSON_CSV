package fr.uvsq.payamakrami_raphaelgillotroux_jeandestribois.ConvertisseurJSON_CSV;

import java.util.Scanner;
import java.io.*;

/**
 * Cette classe s'occupe de gérer les interactions avec l'utilisateur.
 * 
 * @author jean
 */


public class Interface {
	/**
	 * Attribut permettant à recevoir l'entrée standard.
	 */
	private Scanner scan;
	
	/**
	 * Attribut stockant le chemin du fichier de configuration. 
	 */
	private FileReader confFile;
	
	/**
	 * Attribut stockant le sens de conversion désiré.
	 */
	private String conversionChoice;
	
	/**
	 * Attribut stockant le chemin du fichier à écrire.
	 */
	private FileWriter fileToWrite;
	
	/**
	 * Constructeur de cette classe qui affiche un message de bienvenue.
	 * <p>
	 * Il met la valeur de l'attribut "conf_file" à la valeur du chemin du fichier de 
	 * configuration par défaut.
	 */
	Interface() {
		System.out.println("\n\n\n\n\n\nBonjour, bienvenue dans ce convertisseur JSON-CSV / CSV-JSON !");
		try {
			this.confFile = new FileReader("pom.xml"); 
		}
		catch(FileNotFoundException e) {
			System.out.println("Erreur : " + e.getMessage());
			System.exit(1);
		}
		this.scan = new Scanner(System.in);
	}
	
	/**
	 *  Méthode permettant à l'utilisateur de choisir le fichier de configuration par défaut
	 * ou utiliser un autre fichier.
	 */
	public void confFileChoice() {
		System.out.println("\nSouhaitez vous utiliser le fichier de configuration par défaut ? [o/n]");
		String answer = new String(this.scan.nextLine());
		
		while(answer.compareTo("o")!=0 && answer.compareTo("n")!=0) {
			System.out.println("La réponse donnée n'est pas accepté, veuillez réessayer");
			System.out.println("\nSouhaitez vous utiliser le fichier de configuration par défaut ? [o/n]");
			answer = this.scan.nextLine();
			System.out.println(answer);
		}
		
		if(answer.compareTo("n")==0) {
			System.out.println("Veuillez saisir le chemin du fichier de configuration à utiliser");
			try {
				this.confFile = new FileReader(scan.nextLine());
			}
			catch(FileNotFoundException e) {
				System.out.println("Erreur : " + e.getMessage());
				System.exit(1);
			}
		}
	}
	
	/**
	 * Méthode permettant à l'utilisateur de renseigner dans quel sens il souhaite
	 * effectuer la transaction.
	 */
	public void conversionChoice()
	{
		System.out.println("\nTapez <jc> si vous souhaitez effectuer la conversion d'un fichier JSON "
				+ "à un fichier CSV\nTapez <cj> sinon");
		String answer = new String(this.scan.nextLine());
		
		while(answer.compareTo("jc")!=0 && answer.compareTo("cj")!=0) {
			System.out.println("La réponse donnée n'est pas accepté, veuillez réessayer");
			System.out.println("\nTapez <jc> si vous souhaitez effectuer la conversion d'un fichier JSON"
					+ "à un fichier CSV\nTapez <cj> sinon");
			answer = this.scan.nextLine();
			System.out.println(answer);
		}
		this.conversionChoice = answer;
	}
	
	/**
	 * Méthode permettant à l'utilisateur de choisir dans quel fichier sera écrit la conversion
	 */
	public void fileToWriteChoice() {
		System.out.println("Veuillez saisir le chemin du fichier à écrire");
		try {
			this.fileToWrite = new FileWriter(this.scan.nextLine());
		}
		catch(IOException e) {
			System.out.println("Erreur : " + e.getMessage());
			System.exit(1);
		}
	}
	
	/**
	 * Méthode renvoyant l'attribut "confFile".
	 */
	public FileReader getConfFile() {
		return this.confFile;
	}
	
	/**
	 * Méthode renvoyant l'attribut "conversionChoice"
	 */
	public String getConversionChoice() {
		return this.conversionChoice;
	}
	
	/**
	 * Méthode renvoyant l'attribut "fileToWrite"
	 */
	public FileWriter getFileToWrite() {
		return this.fileToWrite;
	}
}
