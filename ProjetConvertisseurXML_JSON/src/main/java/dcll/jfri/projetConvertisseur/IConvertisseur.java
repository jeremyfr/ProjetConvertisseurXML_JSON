/*
 * IConvertisseur.java                                               01/03/2013
 */
package dcll.jfri.projetConvertisseur;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Definit les fonctions à implementer dans les classes de conversion de
 * fichiers :
 * - "String transform(String adresseSource)"
 * La méthode d'enregistrement du fichier resultat est definie dans ce fichier.
 * @author Jérémy Fricou
 * @version 1.0
 */
abstract class IConvertisseur {

    /**
     * Conversion du contenu du fichier d'adresse passee en parametre.
     * La convertion sera differente suivant l'implementation definie.
     * @param adresseSource , l'adresse du fichier a convertir.
     * @return le contenu du fichier converti.
     * @throws IOException exception levee lors d'une erreur de parsing.
     */
    public abstract String transform(final String adresseSource)
    throws IOException;

    /**
     * Enregistrement du contenu du fichier converti dans un fichier resultat.
     * Ce fichier sera cree avec un nom ayant pour forme :
     *   nom_fichier.out.{xml,json}
     * @param contenu , le contenu du fichier resultat converti.
     * @param adresseResultat , l'adresse d'enregistrement du fichier resultat.
     */
    public void enregistrer(final String contenu,
                            final String adresseResultat) {
        // Creation du fichier resultat
        try {
            FileWriter file = new FileWriter(adresseResultat);
            BufferedWriter buffer = new BufferedWriter(file);
            PrintWriter pw = new PrintWriter(buffer);
            pw.print(contenu);
            pw.close();
            System.out.println("Fichier résultat créé");
        } catch (IOException e) {
            System.out.println("Problème à l’écriture du fichier");
            System.exit(0);
        }
    }
    
    /**
     * Lecture du contenu d'un fichier passé en
     * paramètre. Renvoi le contenu sous forme de string    
     * @param adresseSource , l'adresse du fichier en param
     * @return le contenu du fichier
     * @throws IOException 
     */
    public String lire(final String adresseSource) throws IOException {
    	//ouverture du fichier
        FileInputStream fichier = new FileInputStream(adresseSource);
        StringWriter writer = new StringWriter();
        InputStreamReader streamReader = new InputStreamReader(fichier);
        //le buffer permet le readline
        BufferedReader buffer = new BufferedReader(streamReader);
        String line = "";
        try {
            //lecture du fichier
            while (null != (line = buffer.readLine())) {
                writer.write(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //on met le contenu du fichier dans un String
        String contenu = writer.toString();
        //puis on ferme le buffer
        buffer.close();
        
        return contenu;
    }
    
}
