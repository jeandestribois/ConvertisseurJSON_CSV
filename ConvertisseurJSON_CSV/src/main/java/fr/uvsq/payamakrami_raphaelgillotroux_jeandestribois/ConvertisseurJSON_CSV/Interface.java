package fr.uvsq.payamakrami_raphaelgillotroux_jeandestribois.ConvertisseurJSON_CSV;

import java.util.Scanner;

/**
 * Cette classe s'occupe de gérer les interactions avec l'utilisateur.
 * 
 * @author jean
 *
 */


public class Interface {
	/**
	 * Attribut stockant le chemin du fichier de configuration. 
	 */
	private String conf_file_path;
	
	/**
	 * Constructeur de cette classe qui affiche un message de bienvenue.
	 * <p>
	 * Il met la valeur de l'attribut "conf_file_path" à la valeur du chemin du fichier de 
	 * configuration par défaut.
	 */
	Interface() {
		System.out.println("\n\n\n\n\n\nBonjour, bienvenue dans ce convertisseur JSON-CSV / CSV-JSON !");
		this.conf_file_path = new String("conf_file_default"); 
	}
	
	/**
	 *  Méthode permettant à l'utilisateur de choisir le fichier de configuration par défaut
	 * ou utiliser un autre fichier.
	 */
	public void confFileChoice() {
		Scanner scan = new Scanner(System.in);
		System.out.println("\nSouhaitez vous utiliser le fichier de configuration par défaut ? [o/n]");
		String answer = new String(scan.nextLine());
		
		while(answer.compareTo("o")!=0 && answer.compareTo("n")!=0) {
			System.out.println("La réponse donnée n'est pas accepté, veuillez réessayer");
			System.out.println("\nSouhaitez vous utiliser le fichier de configuration par défaut ? [o/n]");
			answer = scan.nextLine();
			System.out.println(answer);
		}
		
		if(answer.compareTo("n")==0) {
			System.out.println("Veuillez saisir le chemin du fichier de configuration à utiliser");
			answer = scan.nextLine();
			this.conf_file_path = answer;
		}
		scan.close();
	}
}
