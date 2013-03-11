package dcll.jfri.projetConvertisseur;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

/**
 * MenuTest est le Junit qui permet de test les methodes
 * de la classe Menu
 * @author Charly Carrere
 * @version 1.0
 */
public class MenuTest {
	
	/**
	 * Attribut d'un Menu qui va me permettre de tester les methodes
	 */
	protected Menu menu;
	
	/**
	 * Methode qui est execute apres la classe.
	 * @throws Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * Methode qui est execute avant les Tests.
	 * On cree ici un objet de type Menu afin de pouvoir
	 * tester ses differentes methodes.
	 */
	@Before
	public void setUp() {
		menu = new Menu();
	}

	/**
	 * Methode qui serra execte apres les tests.
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test de la methode getCheminSource
	 * @throws Exception
	 */
	@Test
	public void testCheminSource() throws Exception {
		assertEquals(null, menu.getCheminSource());
	}
	
	/**
	 * Test de la methode getAction
	 * @throws Exception
	 */
	@Test
	public void testAction() throws Exception {
		assertEquals(-1, menu.getAction());
	}
	
	/**
	 * Test de la methode getCheminResultat
	 * @throws Exception
	 */
	@Test
	public void testCheminResultat() throws Exception {
		assertEquals(null, menu.getCheminResultat());
	}

}
