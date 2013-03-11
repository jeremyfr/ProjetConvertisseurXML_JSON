/*
 * App.java                                                          01/03/2013
 */
package dcll.jfri.projetConvertisseur;

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
    	// Affichage du menu permettant de choisir le type de conversion et
    	// le fichier a convertir.
        Menu menu = new Menu();
        menu.affiche();
        // Conversion du fichier source suivant le type de conversion desiree.
        IConvertisseur convert = null;
        String resultatParsing = "";
        switch(menu.getAction()) {
            // XML -> JSON
            case 0:
              // convert = new XmlToJson();
              //resultatParsing = XmlToJson.transform(menu.getCheminSource());
            	break;
            // JSON -> XML
            case 1:
               // convert = new JsonToXml();
               //resultatParsing = JsonToXml.transform(menu.getCheminSource());
            	break;
            default:
            	System.out.println("Erreur de fontionnement de l'application");
        }
        // Creation et enregistrement du fichier resultat converti
        convert.enregistrer(resultatParsing, menu.getCheminResultat());
    }
}