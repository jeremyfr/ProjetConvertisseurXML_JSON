package dcll.jfri.projetConvertisseur;

import org.omg.CORBA.portable.InputStream;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.sf.json.JSON;
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
    	
    	
    	XMLSerializer xmlSerializer = new XMLSerializer();  
    	JSON json = xmlSerializer.read( xml );  
    	System.out.println( json.toString(2) );  

    }
}
