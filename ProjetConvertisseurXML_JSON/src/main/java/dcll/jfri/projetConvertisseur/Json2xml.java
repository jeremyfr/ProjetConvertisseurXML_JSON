package dcll.jfri.projetConvertisseur;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;
/**
 * Classe qui permet la conversion de JSON vers XML
 * La classe étend l'interface Convertisseur
 * et implémente sa méthode transform.
 */
public class Json2xml extends Convertisseur {
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
            return XML.toString(o);
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "Erreur lors de la conversion";
    }
}
