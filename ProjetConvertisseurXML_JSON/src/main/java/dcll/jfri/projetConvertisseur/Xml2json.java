package dcll.jfri.projetConvertisseur;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;
/**
 * Classe permettant la conversion de XML vers JSON
 * La classe étend l'interface IConvertisseur et
 * implémente sa méthode transform.
 */
public class Xml2json extends IConvertisseur {
    @Override
    /**
     * Ouvre le fichier dont l'adresse est spécifiée en argument,
     * puis transforme
     * son contenu en string. Ce string est ensuite transformé
     * en JSONObject, puis retourné en string
     * @param string adresseSource.
     * @return string contenu du fichier converti en JSON
     * @throws IOException sd
     */
    public String transform(final String adresseSource) throws IOException {
        //on met le contenu du fichier dans un String
        String contenu = lire(adresseSource);
        //le contenu est placé dans un JSONObject
        JSONObject o;
        try {
            o = XML.toJSONObject(contenu);
            //le JSONObject est retourné sous forme de string
            return o.toString(2);
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "Erreur lors de la conversion";
    }
}
