package dcll.jfri.projetConvertisseur;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

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
 * Application de conversion de fichier XML -> JSON et JSON -> XML.
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
        /*Menu menu = new Menu();
        menu.affiche();
        String resultatParsing = "";
        switch(menu.getAction()){
            // XML -> JSON
            case 0:
            	//resultatParsing = XmlToJson.transform(menu.getCheminSource());
            	resultatParsing = "";
            	break;
            // JSON -> XML
            case 1:
            	//resultatParsing = JsonToXml.transform(menu.getCheminSource());
            	resultatParsing = "";
            	break;
        }
        // Creation du fichier resultat
        try {
			FileWriter file = new FileWriter(menu.getCheminResultat());
			BufferedWriter buffer = new BufferedWriter(file);
			PrintWriter pw = new PrintWriter(buffer); 
			pw.print(resultatParsing);
			pw.close();
			System.out.println("Fichier créé");
		}catch(IOException e){
			System.out.println("Problème à l’écriture du fichier"); 
			System.exit(0); 
		}
    }
}
*/
		
		// DE XML A JSON...
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
    	

    	//DE JSON A XML...
    	XMLSerializer serializer = new XMLSerializer();
    	JSON json1 = JSONSerializer.toJSON( json.toString(2) );
    	//serializer.setRootName("SampleJSON");
    	serializer.setTypeHintsEnabled(false);
    	String xml = serializer.write( json1 );
    	//System.out.println(xml);
    	
    	try {
    		FileWriter file = new FileWriter("transformJson.json");
    		BufferedWriter buffer2 = new BufferedWriter(file);
    		PrintWriter pw = new PrintWriter(buffer2); 
    		pw.print(xml);
    		pw.close();
    		System.out.println("Fichier créé");
    		}catch(IOException e){
    		System.out.println("Problème à l’écriture du fichier"); 
    		System.exit(0); 
    		} 
    	



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