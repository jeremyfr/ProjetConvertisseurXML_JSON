package dcll.jfri.projetConvertisseur;

import org.omg.CORBA.portable.InputStream;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.sf.json.JSON;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import net.sf.json.xml.XMLSerializer;

import org.apache.commons.io.IOUtils;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {

		
		// DE JSON A XML...
		// Location du fichier JSon a convertir

    	
    	/*String xml = "<o number=\"1\"> first<string>json</string> <array>  <e>1</e><e>true</e></array> </o>";
    	System.out.println( xml );
    	java.io.InputStream is = App.class.getResourceAsStream("testxml.txt");
    	String jsonData = IOUtils.toString(is);  */   
    	
    	String jsonData = recupStringFichier("C:\\Utilisateurs\\Helene\\Téléchargements\\quiz-moodle-exemple.xml");
    	
    	System.out.println(jsonData);
    	
    	
    	
    	//String xmlAconvertir = IOUtils.toString(isXML);
    	
    	//System.out.println( is );
    	
    	XMLSerializer xmlSerializer = new XMLSerializer();
    	xmlSerializer.setTypeHintsEnabled( false ); 
    	JSON json = xmlSerializer.read( jsonData); 
    	
    	System.out.println( json.toString(2) );  
    	
    	//String str = json.toString(2);  
    	//JSONObject json1 = (JSONObject) JSONSerializer.toJSON( str );
    	JSONObject json1 = (JSONObject) json;
    	XMLSerializer xmlSerializer1 = new XMLSerializer();  
    	xmlSerializer1.setTypeHintsEnabled( false );  
    	
    	String xml1 = xmlSerializer1.write( json1 );  
    	System.out.println( xml1 );  
    	/*json1.getJSONArray( "number" ).setExpandElements( true );  
    	xml1 = xmlSerializer1.write( json );  
    	System.out.println( xml1 );*/ 

    }
    
    public static String recupStringFichier(String nomFichier) {
    	String retour;
    try{
    	File f = new File(nomFichier);
        byte[] buffer = new byte[(int)f.length()];
        DataInputStream in = new DataInputStream(new FileInputStream(f));
        in.readFully(buffer);
        in.close();
    	retour = new String(buffer);
            return retour;
        } catch (FileNotFoundException e) {
            System.out.println("Impossible de lire le fichier "+nomFichier+" ! " +e);
            return "";
        } catch (IOException e) {
        	System.out.println("Erreur de lecture !" +e);
        	return "";
        }
    }
}
