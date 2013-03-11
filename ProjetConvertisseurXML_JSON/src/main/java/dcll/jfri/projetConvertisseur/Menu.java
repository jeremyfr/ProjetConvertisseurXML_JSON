/*
 * Menu.java                                                         01/03/2013
 */
package dcll.jfri.projetConvertisseur;

import java.io.File;
import java.util.Scanner;

/**
 * Menu affiche lors du lancement du programe.
 * Demande de l'action a executer : XML -> JSON ou JSON -> XML.
 * Puis, demande du chemin du fichier à convertir.
 * Le fichier converti sera placé dans le meme repertoire que le fichier source
 * et nommé ainsi : 
 *  - nom_fichier.xml -> nom_fichier.out.json
 *  - nom fichier.json -> nom_fichier.out.xml
 * @author Jérémy Fricou
 * @version 1.0
 */
public class Menu {
    /** XML -> JSON */
    private static int XML2JSON = 0;
    /** JSON -> XML */
    private static int JSON2XML = 1;
    
    /** Action a executer */
    private int action;
    /** Chemin du fichier a convertir */
    private String cheminSource;
    /** Chemin du fichier resultat */
    private String cheminResultat;
    
    /**
     * Constructeur par defaut d'un Menu
     * Initialisation des variables
     */
    public Menu(){
        action = -1;
        cheminSource = cheminResultat = null;
    }
    
    /**
     * Affichage des informations sur le programme et demande des informations
     * necessaires au bon fontionnement du programme.
     */
    public void affiche() {
        System.out.println("****************************************");
        System.out.println("******* Convertisseur XML - JSON *******");
        System.out.println("****************************************");
        Scanner clavier = new Scanner(System.in);
        action(clavier);
        fichier(clavier);
        resultat();
        System.out.println();
        clavier.close();
    }

    /**
     * Creation du nom du fichier resultat a creer.
     * nom_fichier.xml -> nom_fichier.out.json
     * nom_fichier.json -> nom_fichier.out.xml
     */
    private void resultat() {
        cheminResultat = cheminSource.substring(0,cheminSource.lastIndexOf('.')
                                                                          - 1);
        String extension = cheminSource.substring(cheminSource.lastIndexOf('.')
                                                    + 1,cheminSource.length());
        extension = extension.equals("xml") ? "json" 
        		                            : "xml";
        cheminResultat += ".out."+extension;
        System.out.println("****************************************");
        System.out.println("Le fichier resultat " + cheminResultat + " sera "
                     + "placé dans le meme repertoire que le fichier source.");
    }

    /**
     * Demande de l'action que l'utilisateur veut faire :
     *  - convertir de XML a JSON.
     *  - convertir de JSON a XML.
     * @param clavier, l'entree clavier de l'utilisateur.
     */
    public void action(Scanner clavier) {
        boolean ok;
        // Recommence tant que que l'action n'est pas valable
        do {
            System.out.println("Que voulez-vous faire ?");
  System.out.println("Taper 1 pour convertir un fichier xml en fichier json.");
  System.out.println("Taper 2 pour convertir un fichier json en fichier xml.");
            ok = clavier.hasNextInt();
            if (ok) {
                action = clavier.nextInt() - 1;
                if ( !(ok = ( action == 0 || action == 1) ) ) {
                    System.out.println("Action non reconnue");
                    System.out.println("********************");
                }
            } else {
                System.out.println("Action non reconnue");
                System.out.println("********************");
            }
            clavier.nextLine();
        } while(!ok);
    }
    
    /**
     * Demande du chemin du fichier que l'utilisateur veut convertir.
     * @param clavier, l'entree clavier de l'utilisateur.
     */
    private void fichier(Scanner clavier) {
        boolean ok;
        String extension;
        File f;
     // Recommence tant que que l'action n'est pas valable
        do {
        	ok = true;
            System.out.print("Indiquer le chemin du fichier ");
            System.out.print(action == XML2JSON ? "xml": "json");
            System.out.println(" que vous voulez convertir :");
            cheminSource = clavier.nextLine();
            
            // Verification de l'extension du fichier
            extension = cheminSource;
            if (cheminSource.contains(".")) {
                extension = cheminSource.substring(
                 cheminSource.lastIndexOf('.') + 1, cheminSource.length());
            }else{
                ok = false;
            	System.out.println("Le chemin specifie est incorrect.");
                System.out.println("*********************************");
            }
            if ( ok && !( (action == XML2JSON && extension.equals("xml")
                      || action == JSON2XML && extension.equals("json")) ) ) {
            	ok = false;
System.out.println("Le fichier specifié est incompatible pour la conversion.");
System.out.println("********************************************************");
            }
            // Verification de l'existence du fichier
            f = new File(cheminSource);
            if (ok && !f.exists()) {
            	ok = false;
     System.out.println("Le fichier n'existe pas ou le chemin est incorrect.");
     System.out.println("***************************************************");
            }
        } while(!ok);
    }

    /**
     * Accesseur de l'action a realiser : 
     * 1 pour convertir un fichier xml en fichier json.
     * 2 pour convertir un fichier json en fichier xml.
     * @return l'action a realiser.
     */
    public final int getAction() {
        return action;
    }

    /**
     * Accesseur du chemin du fichier converti.
     * @return le chemin du fichier converti.
     */
    public final  String getCheminSource() {
        return cheminSource;
    }
    
    /**
     * Accesseur du chemin du fichier a convertir.
     * @return le chemin du fichier a convertir.
     */
    public final String getCheminResultat() {
        return cheminResultat;
    }
}
