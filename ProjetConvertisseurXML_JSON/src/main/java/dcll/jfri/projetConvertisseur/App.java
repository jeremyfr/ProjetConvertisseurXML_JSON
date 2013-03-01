package dcll.jfri.projetConvertisseur;

import org.omg.CORBA.portable.InputStream;

import java.io.BufferedWriter;
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
    public static void main( String[] args )
    {
    	String xml = "<o number=\"1\"> first<string>json</string> <array>  <e>1</e><e>true</e></array> </o>";
    	System.out.println( xml );
    	InputStream isXML = (InputStream) App.class.getResourceAsStream("testxml.xml");
    	XMLSerializer xmlSerializer = new XMLSerializer();
    	xmlSerializer.setTypeHintsEnabled( false ); 
    	JSON json = xmlSerializer.read( xml ); 
    	
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
}
