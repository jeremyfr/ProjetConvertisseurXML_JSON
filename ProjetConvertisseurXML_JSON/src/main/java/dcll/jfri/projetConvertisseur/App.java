package dcll.jfri.projetConvertisseur;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Application de conversion de fichier XML -> JSON et JSON -> XML.
 */
public class App 
{
    public static void main( String[] args )
    {
        Menu menu = new Menu();
        menu.affiche();
        String resultatParsing = "";
        switch(menu.getAction()){
            // XML -> JSON
            case 0:
            	//resultatParsing = XmlToJson.transform(menu.getCheminSource());
            	resultatParsing = "";
            	break;
            // JSON -> XML
            case 1:
            	//resultatParsing = JsonToXml.transform(menu.getCheminSource());
            	resultatParsing = "";
            	break;
        }
        // Creation du fichier resultat
        try {
			FileWriter file = new FileWriter(menu.getCheminResultat());
			BufferedWriter buffer = new BufferedWriter(file);
			PrintWriter pw = new PrintWriter(buffer); 
			pw.print(resultatParsing);
			pw.close();
			System.out.println("Fichier créé");
		}catch(IOException e){
			System.out.println("Problème à l’écriture du fichier"); 
			System.exit(0); 
		}
    }
}