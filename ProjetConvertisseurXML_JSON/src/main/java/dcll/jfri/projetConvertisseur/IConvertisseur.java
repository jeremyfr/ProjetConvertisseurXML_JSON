/*
 * IConvertisseur.java                                               01/03/2013
 */
package dcll.jfri.projetConvertisseur;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

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
     * Conversion du contenu du fichier dont l'adresse est passee en parametre.
     * La convertion sera differente suivant l'implementation definie.
     * @param adresseSource, l'adresse du fichier a convertir.
     * @return le contenu du fichier converti.
     * @throws IOException
     */
    public abstract String transform(String adresseSource) throws IOException;

    /**
     * Enregistrement du contenu du fichier converti dans un fichier resultat.
     * Ce fichier sera cree avec un nom ayant pour forme :
     *   nom_fichier.out.{xml,json}
     * @param contenu, le contenu du fichier resultat converti.
     * @param adresseResultat, l'adresse d'enregistrement du fichier resultat.
     */
    public void enregistrer(String contenu, String adresseResultat) {
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
}
