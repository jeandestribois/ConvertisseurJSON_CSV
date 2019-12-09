package fr.uvsq.payamakrami_raphaelgillotroux_jeandestribois.ConvertisseurJSON_CSV;

import java.io.*;

/**
 * La classe Convertisseur est la classe appelé pour effectuer les différentes conversion souhaité.
 * 
 * @author raphael
 *
 */



public class Convertisseur {
	private String source;
	private String converti;
	private String format;
	
	public Convertisseur(String nomFichierSource, String format){
		String concatenation="";
		try{
			InputStream flux=new FileInputStream(nomFichierSource); 
			InputStreamReader lecture=new InputStreamReader(flux);
			BufferedReader buff=new BufferedReader(lecture);
			String ligne;
			while ((ligne=buff.readLine())!=null){
				concatenation+=ligne+"\n";
				//System.out.println(ligne);
		}
			buff.close(); 
		}		
		catch (Exception e){
			System.out.println(e.toString());
			}
				

		this.source=concatenation;
		this.converti="";
		
		
		// Trouvé un moyen d'empêcher l'instanciation si non vérifier
		
		
		if(format != "csv" && format != "json"){
			System.out.println("Format non supporté");
		}
		else{
			this.format=format;
		}
	    }
		
	public String toString(){
		return this.source;
	}
	
	public void Converssion(){
		String converti="";
		if (this.format.compareTo("csv")==0){
			converti="[\n";
			String ligne[] = this.source.split("\n");
			
			String cle[]=ligne[0].split(",");
			
			for (int i=1;i<ligne.length;i++){
				String donnee[]=ligne[i].split(",");
				
				//System.out.println(ligne[i]);
				
				converti+="{ \n";
				
				for (int j=0;j<donnee.length;j++){
					
					//System.out.println(donnee[j]);
					
					converti+='"'+cle[j]+'"'+": "+'"'+donnee[j]+'"';
					
					if (j != donnee.length-1){
						converti+=",\n";
					}
					else{
						converti+="\n";
					}
					
					}
					
				if (i != ligne.length-1){
						converti+="},\n";
					}
				else{
						converti+="}\n";
					}

			}

			
			converti+="]";
			//System.out.println(converti);
			this.converti=converti;
		}
		
		
		else{
		
			String cle="";
			String ligne[] = this.source.split("\\{");
			for (int i=1;i<ligne.length;i++){
				String donnee[]=ligne[i].split("\\}");
				for (int j=0;j<donnee.length-1;j++){
					
					//System.out.println(donnee[j]);
					
					String donnee2[]=donnee[j].split(",");
					
					for(int k =0; k<donnee2.length;k++){
						String donnee3[]=donnee2[k].split(":");
						
						//for(int l =0; l<donnee3.length;l++){
						//	System.out.println(donnee3[l]);
						//}
						

						
						if (i==1){
							cle+=donnee3[0].replaceAll("\"","").replaceAll(" ","").replaceAll("\n","");
							if (k != donnee2.length-1){
							cle+=",";
						}
						}
						
						converti+=donnee3[1].replaceAll("\"","").replaceAll(" ","");
;
						
						if (k != donnee2.length-1){
						converti+=",";
						}
						//System.out.println(donnee3[1]);
						
							
					}
				
				}

			}
			//System.out.println(cle+"\n"+converti);
			this.converti=cle+"\n"+converti;
		}
	}
	
	public String getConverti(){
		return this.converti;
	}
}