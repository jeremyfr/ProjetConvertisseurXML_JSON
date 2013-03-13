package dcll.jfri.projetConvertisseur;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;
/**
 * Classe qui permet la conversion de JSON vers XML
 * La classe étend l'interface Convertisseur
 * et implémente sa méthode transform.
 */
public class Json2xml extends Convertisseur {
    /** Numero du groupe 1. */
    private static final int GROUP1 = 1;
    /** Numero du groupe 2. */
    private static final int GROUP2 = 2;
    /** Numero du groupe 3. */
    private static final int GROUP3 = 3;
    /** Numero du groupe 4. */
    private static final int GROUP4 = 4;
    /**
     * Ouvre le fichier dont l'adresse est spécifiée en argument,
     * puis transforme son contenu en string. Ce string est
     * ensuite transformé en JSONObject, parsé en XML, puis retourné
     * en string.
     * @param adresseSource final
     * @return string contenu du fichier converti en XML
     * @throws IOException exception levee lors erreur
     */
    public final String transform(final String adresseSource)
           throws IOException {
        //on met le contenu du fichier dans un String
        String contenu = lire(adresseSource);
        JSONObject o;
        try {
            //le contenu est placé dans un JSONObject
            o = new JSONObject(contenu);
            //return json2string(o);
            //on retourne le string parsé par XML
            return prettyPrintXMLAsString(XML.toString(o));
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "Erreur lors de la conversion";
    }

    /**
     * Indentation du texte du fichier xml cree a partir du fichier json.
     * @param xmlString , le texte a formater.
     * @return le texte formate genere.
     */
     // source :
     // http://tictechtoe-sounavo.blogspot.fr/2010/11/xml-preety-print
     //              -without-parsing.html
     public static String prettyPrintXMLAsString(final String xmlString) {
         // Suppression des nouvelles lignes crees
         xmlString.replaceAll("\n", "");
         StringBuffer xmlFinal = new StringBuffer();
         // Groupage des balises xml
Pattern p = Pattern.compile("(<[^/][^>]+>)?([^<]*)(</[^>]+>)?(<[^/][^>]+/>)?");
         Matcher m = p.matcher(xmlString);
         int tabCnt = 0;
         while (m.find()) {
     // Les groupes retournent null comme String si non trouve, donc remplace
             String str1, str2, str3, str4;
             if (null == m.group(GROUP1) || m.group().equals("null")) {
                 str1 = "";
             } else {
                 str1 = m.group(GROUP1);
             }
             if (null == m.group(GROUP2) || m.group().equals("null")) {
                 str2 = "";
             } else {
                 str2 = m.group(GROUP2);
             }
             if (null == m.group(GROUP3) || m.group().equals("null")) {
                 str3 = "";
             } else {
                 str3 = m.group(GROUP3);
             }
             if (null == m.group(GROUP4) || m.group().equals("null")) {
                 str4 = "";
             } else {
                 str4 = m.group(GROUP4);
             }

             printTabs(tabCnt, xmlFinal);
             if (!str1.equals("") && str3.equals("")) {
                 ++tabCnt;
             }
             if (str1.equals("") && !str3.equals("")) {
                 --tabCnt;
                 xmlFinal.deleteCharAt(xmlFinal.length() - 1);
             }
             xmlFinal.append(str1);
             xmlFinal.append(str2);
             xmlFinal.append(str3);
             /* Handle <mytag/> king of tags*/
             if (!str4.equals("")) {
                 xmlFinal.append("\n");
                 printTabs(tabCnt, xmlFinal);
                 xmlFinal.append(str4);
             }
             xmlFinal.append("\n");
        }
        return xmlFinal.toString();
    }

    /**
     * Creation des tabulations pour indentation.
     * @param cnt , le nombre de tabulations a creer.
     * @param buf , le texte a indenter.
     */
    private static void printTabs(final int cnt, final StringBuffer buf) {
        for (int i = 0; i < cnt; i++) {
            buf.append("\t");
        }
    }
}
