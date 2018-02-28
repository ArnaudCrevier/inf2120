package ca.uqam.inf2120.tp1.adt.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ca.uqam.inf2120.tp1.adt.*;
import ca.uqam.inf2120.tp1.adt.test.Membre;
import ca.uqam.inf2120.tp1.adt.impl.*;

public class EquipeImplTest {
	
	List<Membre> list;
	EquipeTda<Membre> equipe;
	EquipeTda<Membre> equipe1;
	Membre membre1;
	Membre membre2;
	Membre membre3;
	Membre membre4;
	Membre membre5;
	Membre membre6;

/*	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
*/
	
	@Before
	public void setUp() throws Exception {
		equipe = new EquipeImpl<Membre>();
		equipe1 = new EquipeImpl<Membre>();
		list = new ArrayList<>();
		membre1 = new Membre("Capt", "Reynolds", "Malcom");
		membre2 = new Membre("Muscle", "Cobb", "Jane");
		membre3 = new Membre("Companion", "Serra", "Inara");
		membre4 = new Membre("Mechanic", "Frye", "Kaylee");
		membre5 = new Membre("Pilot", "Washburne", "Hoban");
		membre6 = new Membre("Second", "Washburne", "Zoe");
		
	}

	@After
	public void tearDown() throws Exception {
		list.clear();
		equipe = null;
		equipe1 = null;
		membre1 = null;
		membre2 = null;
		membre3 = null;
		membre4 = null;
		membre5 = null;
		membre6 = null;
	}

	@Test
	public void testAjouterT() {
		
		boolean ajout = equipe.ajouter(membre1);
		
		assertEquals(true, ajout);
	}

	@Test
	public void testAjouterIntT() throws PositionException {
		
		boolean ajout;
		ajout = equipe.ajouter(membre1);
		ajout = equipe.ajouter(0, membre3);
		
		assertEquals(true, ajout);
	}

	@Test
	public void testAjouterEquipeTdaOfT() {
		boolean ajout;
		ajout = equipe.ajouter(membre1);
		ajout = equipe.ajouter(membre2);
		
		list = equipe1.ajouter(equipe);
		
		assertEquals(list, equipe1);
	}

	@Test
	public void testComparer() {
		fail("Not yet implemented");
	}

	@Test
	public void testEstMembre() {
		fail("Not yet implemented");
	}

	@Test
	public void testNbMembres() {
		fail("Not yet implemented");
	}

	@Test
	public void testRetirerT() {
		fail("Not yet implemented");
	}

	@Test
	public void testRetirerEquipeTdaOfT() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemplacer() {
		fail("Not yet implemented");
	}

	@Test
	public void testMembres() {
		fail("Not yet implemented");
	}

	@Test
	public void testEstVide() {
		fail("Not yet implemented");
	}

	@Test
	public void testVider() {
		fail("Not yet implemented");
	}

	@Test
	public void testIterateur() {
		fail("Not yet implemented");
	}

}
