package dcll.jfri.projetConvertisseur;

import org.omg.CORBA.portable.InputStream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
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
    	
    
    	FileInputStream fichier=new FileInputStream("testxml.xml");
    	StringWriter writer=new StringWriter();
    	InputStreamReader streamReader=new InputStreamReader(fichier);
    	//le buffer permet le readline
    	BufferedReader buffer=new BufferedReader(streamReader);
    	String line="";
    	while ( null!=(line=buffer.readLine())){
    	  writer.write(line);
    	}
    	// Sortie finale dans le String
    	String jsonData=writer.toString();
    	
    	System.out.println(jsonData);
    	
    	XMLSerializer xmlSerializer = new XMLSerializer();
    	xmlSerializer.setTypeHintsEnabled( false ); 
    	JSON json = xmlSerializer.read( jsonData); 
    	
    	System.out.println( json.toString(2) );
    	
;
    	
    	

    	/*
		String jsonData1 = jsonData;
		
		XMLSerializer serializer = new XMLSerializer();
		serializer.setRootName("quiz");
        serializer.setSkipWhitespace(false);
        // Le type des objets ne seront pas affichÃ©s
        serializer.setTypeHintsEnabled(false);
        
		JSON jsonAconvertir = JSONSerializer.toJSON(jsonData1);

		 
    	

    	System.out.println( serializer.write(jsonAconvertir));  
    	/*json1.getJSONArray( "number" ).setExpandElements( true );  
    	xml1 = xmlSerializer1.write( json );  
    	System.out.println( xml1 );*/ 

    }
    
  
}
