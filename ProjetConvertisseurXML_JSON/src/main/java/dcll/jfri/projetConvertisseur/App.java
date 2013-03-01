package dcll.jfri.projetConvertisseur;

import net.sf.json.JSON;
import net.sf.json.xml.XMLSerializer;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	XMLSerializer serializer = new XMLSerializer();
    	serializer.setTypeHintsEnabled(false);

    	JSON jsonRepresentation = serializer.readFromFile( "file.xml" );

    	String xml = serializer.write( jsonRepresentation );
    	System.out.println(xml);

    }
}
