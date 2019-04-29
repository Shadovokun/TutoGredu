import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



class TestPerso {

	Personnage perso1;
	Personnage perso2;
	Personnage perso3;
	@BeforeEach
	void setUpBeforeClass() throws Exception {
		perso1 = new Personnage("Gérard le Conquérant", Classe.Guerrier);
		perso2 = new Personnage("Michel le Faucon", Classe.Archer);
		perso3 = new Personnage("Gandoulf le Black", Classe.Mage);
	}

	@Test
	void testInit3Persos() {
		assertEquals(perso1.nom, "Gérard le Conquérant");
		assertEquals(perso1.classe, Classe.Guerrier);
		assertEquals(perso1.arme.getClass(), Epee.class);
		assertEquals(perso1.vie, 110);
		
		assertEquals(perso2.nom, "Michel le Faucon");
		assertEquals(perso2.classe, Classe.Archer);
		assertEquals(perso2.arme.getClass(), Arc.class);
		assertEquals(perso2.vie, 80);
		
		assertEquals(perso3.nom, "Gandoulf le Black");
		assertEquals(perso3.classe, Classe.Mage);
		assertEquals(perso3.arme.getClass(), Sceptre.class);
		assertEquals(perso3.vie, 90);
	}
	
	@Test
	void testDegats() {
		perso1.attaquer(perso2);
		perso2.attaquer(perso3);
		perso3.attaquer(perso1);
		
		assertEquals(perso2.vie, 68);
		assertEquals(perso3.vie, 80);
		assertEquals(perso1.vie, 95);
	}
	
	@Test
	void testAmeliorationArme() {
		assertEquals(perso1.arme.degats, 12);
		assertEquals(perso2.arme.degats, 10);
		assertEquals(perso3.arme.degats, 15);
		
		perso1.ameliorerArme();
		perso2.ameliorerArme();
		perso3.ameliorerArme();
		
		assertEquals(perso1.arme.degats, 17);
		assertEquals(perso2.arme.degats, 15);
		assertEquals(perso3.arme.degats, 20);
	}
	
	@Test
	void testMort() {
		for (int i = 0; i < 100; i++) {
			perso3.ameliorerArme();
		}
		
		perso3.attaquer(perso1);
		
		assertEquals(perso1.vie, 0);
		
	}
}
