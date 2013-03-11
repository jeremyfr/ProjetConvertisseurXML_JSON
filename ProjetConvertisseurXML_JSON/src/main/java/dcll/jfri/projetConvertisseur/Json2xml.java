package dcll.jfri.projetConvertisseur;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;
/**
 * Classe qui permet la conversion de JSON vers XML
 * La classe étend l'interface IConvertisseur
 * et implémente sa méthode transform.
 */
public class Json2xml extends IConvertisseur {
    /**
     * Ouvre le fichier dont l'adresse est spécifiée en argument,
     * puis transforme son contenu en string. Ce string est
     * ensuite transformé en JSONObject, parsé en XML, puis retourné
     * en string.
     * @param adresseSource final
     * @return string contenu du fichier converti en XML
     * @throws IOException sd
     */
    public String transform(String adresseSource) throws IOException {
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
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // Contenu du fichier dans un String
        String contenu = writer.toString();
        //puis on ferme le buffer
        buffer.close();
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
