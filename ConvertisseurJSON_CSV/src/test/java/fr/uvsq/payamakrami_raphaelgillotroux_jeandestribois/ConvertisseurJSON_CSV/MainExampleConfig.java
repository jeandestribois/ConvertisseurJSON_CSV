//import Convertisseur;


public class Main{
public static void main (String[] args){

	// Chemin a redefinir
	
	
	Convertisseur text2=new Convertisseur("C:/test.txt","csv","C:/config.txt");
	//System.out.println(text2);
	
	//System.out.println(text2.getConfig());
	
	//text2.getClefCible();
	
	
	
	
	text2.Converssion();
	
	System.out.println(text2.getConverti());
}
}