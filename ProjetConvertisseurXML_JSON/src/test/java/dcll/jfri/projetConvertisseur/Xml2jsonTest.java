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
 * Xml2jsonTest est le Junit qui permet de test les methodes
 * de la classe Xml2json
 * @author Charly Carrere
 * @version 1.0
 */
public class Xml2jsonTest {

	/**
	 * Attribut de type Xml2json qui va me permettre de tester les methodes
	 */
	protected Xml2json x2j;
	
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
	 * On cree ici un objet de type Xml2json qui permettra d'utiliser
	 * la fonction transform()
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		x2j = new Xml2json();
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
	 * XML a Json est identique.
	 * @throws IOException
	 */
	@Test
	public void test() throws IOException {

		assertEquals(loadFile(new File("Jtest.json")), x2j.transform("Jtest.xml"));
	}

}
