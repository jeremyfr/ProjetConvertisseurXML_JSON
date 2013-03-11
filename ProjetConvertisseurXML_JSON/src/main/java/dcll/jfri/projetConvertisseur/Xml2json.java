package dcll.jfri.projetConvertisseur;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringWriter;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

import net.sf.json.JSON;
import net.sf.json.xml.XMLSerializer;


public class Xml2json extends IConvertisseur {

	@Override
	public String transform(String adresseSource) throws IOException {

		//ouverture du fichier
		FileInputStream fichier=new FileInputStream(adresseSource);
		StringWriter writer=new StringWriter();
		InputStreamReader streamReader=new InputStreamReader(fichier);
		
		//le buffer permet le readline
		BufferedReader buffer=new BufferedReader(streamReader);
		String line="";
		try {
			//lecture du fichier
			while ( null != (line=buffer.readLine())){
				writer.write(line);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Contenu du fichier dans un String
		String contenu=writer.toString();
		buffer.close();
		
		/*XMLSerializer xmlSerializer = new XMLSerializer();
		xmlSerializer.setTypeHintsEnabled(false);
		JSON json = xmlSerializer.read(contenu);*/
		
		
		JSONObject o;
		try {
			o = XML.toJSONObject(contenu);
			return o.toString(2);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

}
