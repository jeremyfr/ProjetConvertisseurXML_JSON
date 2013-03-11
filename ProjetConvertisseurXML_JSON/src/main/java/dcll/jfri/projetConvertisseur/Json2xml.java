package dcll.jfri.projetConvertisseur;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringWriter;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;


public class Json2xml extends IConvertisseur {

	
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
		
		JSONObject o;
		try {
			o = new JSONObject(contenu);
			
			return json2string(o);
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

		return "";
	}
	
	public String json2string(JSONObject o){
		JSONObject contenu;
		try {
			contenu = o.getJSONObject("question");
			if(!contenu.has("name"))
	            return "toto";
			
	        String stringName = "\n<name>";
	        stringName += XML.toString(contenu.get("name"));
	        stringName += "\n</name>";
	        System.out.println(stringName);
	        return stringName;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}
