
import java.io.*;


public class Convertisseur {
	private String source;
	private String converti;
	private String format;
	
	
	private String configuration;
	private String clefCible[];
	private String regleCible[];
	
	
	
	public Convertisseur(String nomFichierSource, String format,String nomFichierConfig){
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
		
		
		String configuration="";
		try{
			InputStream flux2=new FileInputStream(nomFichierConfig); 
			InputStreamReader lecture2=new InputStreamReader(flux2);
			BufferedReader buff2=new BufferedReader(lecture2);
			String ligne2;
			while ((ligne2=buff2.readLine())!=null){
				configuration+=ligne2+"\n";
				//System.out.println(ligne);
		}
			buff2.close(); 
		}		
		catch (Exception e){
			System.out.println(e.toString());
			}
		
		this.configuration=configuration;
		
		String ligne[] = configuration.split("\n");
		
		
		this.regleCible=new String [ligne.length];
		this.clefCible=new String [ligne.length];
		for(int i=0;i<ligne.length;i++){
			this.clefCible[i]=ligne[i].split(":")[0];
			this.regleCible[i]=ligne[i].split(":")[1];
		}
		
		
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
	
	public String getConfig(){
		return this.configuration;
	}
	
	public void getClefCible(){
		for(int i=0;i<this.clefCible.length;i++){
			System.out.println(this.clefCible[i]);
			
			System.out.println(this.regleCible[i]);
		}

	}
	
	
	
	public void Converssion(){
		String converti="";
		if (this.format.compareTo("csv")==0){
			converti="[\n";
			String ligne[] = this.source.split("\n");
			
			String cleSource[]=ligne[0].split(",");
			String cle[]=this.clefCible;
			
			
			for (int i=1;i<ligne.length;i++){
				String donnee[]=ligne[i].split(",");
				
				//System.out.println(ligne[i]);
				
				converti+="{ \n";
				
				// On analyse chacune des règles de notre fichier config
				
				for(int j=0;j<this.regleCible.length;j++){
					String regle[]=this.regleCible[j].split("\\|");
					
					converti+='"'+cle[j]+'"'+": "+'"';
					
					for(int k=0;k<regle.length;k++){
						int indice = 0;
						
						
						// On recherche l'indice de la cle source correspondante
						
						
						
						
						for(int l=0;l<cleSource.length;l++){
							System.out.println(regle[k]+" "+(cleSource[l]));
							if(regle[k].compareTo(cleSource[l])==0){
								indice=l;
								}	
						}
					
						
						converti+=donnee[indice];
						}
					
					converti+='"';
					
					if (j != regle.length-1){
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