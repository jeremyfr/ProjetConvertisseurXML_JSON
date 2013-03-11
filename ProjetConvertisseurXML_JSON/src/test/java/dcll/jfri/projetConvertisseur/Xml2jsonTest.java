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

public class Xml2jsonTest {

	protected Xml2json x2j;
	
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
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		x2j = new Xml2json();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {

		assertEquals(loadFile(Jtest.json), x2j.transform(Jtest.xml));
	}

}
