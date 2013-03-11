/*
 * App.java                                                          01/03/2013
 */
package dcll.jfri.projetConvertisseur;

import java.io.IOException;

/**
 * Application de conversion de fichier XML -> JSON et JSON -> XML
 * en ligne de commande.
 */
public class App {
	/**
	 * Conversion de fichier XML -> JSON et JSON -> XML.
	 * L'utilisateur choisit le fichier a convertir.
	 * Le fichier resultat se trouvera dans le meme repertoire que le fichier
	 * source, au format : nom_fichier.out.{xml,json}.
	 * @param args unused
	 */
    public static void main(String[] args) {
    	new IGMenu();
    }
}