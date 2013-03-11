package dcll.jfri.projetConvertisseur;

import static org.junit.Assert.*;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.StringWriter;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

/**
 * Json2xmlTest est le Junit qui permet de test les methodes
 * de la classe Json2xml
 * @author Charly Carrere
 * @version 1.0
 */
public class Json2xmlTest {

	/**
	 * Attribut de type Json2xml qui va me permettre de tester les methodes
	 */
	protected Json2xml j2x;
	
	/**
	 * Methode qui permet de recuperer le contenu d'un fichier
	 * dans un String. Cela va nous permettre de comparer deux fichiers entre eux.
	 * @param f
	 * @return contenu_du_fichier
	 */
	public static String loadFile(File f) {
		   try {
		      BufferedInputStream in = new BufferedInputStream(new FileInputStream(f));
		      StringWriter out = new StringWriter();
		      int b;
		       while ((b=in.read()) != -1)
		           out.write(b);
		      out.flush();
		      out.close();
		      in.close();
		      return out.toString();
		    }
		    catch (IOException ie)
		    {
		         ie.printStackTrace(); 
		    }
		return null;
	}
	
	/**
	 * Methode qui serra executer apres la classe.
	 * @throws Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * Methode qui est effectuee avant le test.
	 * On cree ici un objet de type Json2xml qui permettra d'utiliser
	 * la fonction transform()
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		j2x = new Json2xml();
	}

	/**
	 * Methode qui est executer apres le test
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Methode qui test si le fichier que l'on obtient lors de la transformation 
	 * Json a XML est identique.
	 * @throws IOException
	 */
	@Test
	public void test() throws IOException {

		assertEquals(loadFile(new File("Jtest.xml")), j2x.transform("Jtest.json"));
	}

}
