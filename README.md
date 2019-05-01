# Java - Gredu !!

Le but de ce TP est de te familiariser avec la POO. Tu vas créer des classes et les utiliser pour gérer un jeu de combat.

- Au début, tu vas créer une classe `Personnage` (`Archer` avec pour arme un arc, `Guerrier` avec pour arme une épée ou `Mage` avec pour arme un sceptre).
- Il faudra ensuite que ce `Personnage` puisse se battre ! Il lui faudra donc une `Arme`.

## Consigne
### Partie Personnage

Un personnage devra pouvoir disposer d’un nom, d'une classe (`Archer`, `Guerrier` ou `Mage`), d’une arme et d’une vie.

Inutile de créer des classes `Archer`, `Guerrier` ou `Mage`. On va utiliser une énumération `Classe` qui représentera ces cas. 

Un personnage commencera à 100 points de vie, et s'il atteint 0, cela voudra dire que le personnage est mort.

Un personnage devra aussi pouvoir jouer un tour de jeu, recevoir des dégâts ou en infliger à son adversaire en l’attaquant ou encore améliorer son arme en augmentant la capacité des dégâts de l’arme.

Enfin, à chaque tour, j’aimerais que tu affiches le nom du personnage, sa jauge de vie et les dégâts que provoque son arme grâce à une méthode de la classe `Personnage`.

### Partie Arme

Cette classe est toute simple, elle servira juste à indiquer le nombre de dégâts que cette arme inflige. C’est avec ces dégâts que le personnage perd de la vie. Il existe donc les classes `Arc`, `Epee` et `Sceptre` qui hériteront de `Arme`. C'est dans ces trois dernières classes qu'il faudra préciser les dégâts. 

Il faudra donc définir une propriété `Arme` au `Personnage`. Puisque `Arc`, `Epee` et `Sceptre` hériteront de la classe `Arme` rien n'empêchera donc d'instancier un `Arc` ou une `Epee` sur le `Personnage` : l'héritage sert à cela. Ce genre de code est donc possible :
```java
Arme arme = new Epee();
```

## Correction

### Partie Arme

On crée une classe Arme qui est abstraite, pour s'en servir sur les 3 types d'armes qui suivront :

Arme.java
```java
public abstract class Arme {
	int degats;
}
```

On va ensuite définir une valeur dans chaque classe qui étend l'arme : 

Epee.java
```java
public class Epee extends Arme {

	public Epee() {
		this.degats = 12;
	}

}
```

Arc.java
```java
public class Arc extends Arme {

	public Arc() {
		this.degats = 10;
	}

}
```

Sceptre.java
```java
public class Sceptre extends Arme {

	public Sceptre() {
		this.degats = 15;
	}

}
```

### Partie Personnage

On crée une énumération pour définir les différentes classes que l'on veut voir apparaître sur la fiche de Personnage :

Classe.java
```java
public enum Classe {
	Guerrier,
	Archer,
	Mage;
}
```

On crée ensuite la classe Personnage avec quelques petites fonctions intéressantes :

Personnage.java
```java
public class Personnage {

	String nom;
    Classe classe;
    Arme arme;
    int vie;
    
	public Personnage(String nom, Classe classe) {
		this.nom = nom;
		this.classe = classe;
		
		switch(this.classe) {
		  	case Guerrier:
		  		this.arme = new Epee();
		  		this.vie = 110;
		  		break;
		  	case Archer:
		  		this.arme = new Arc();
		  		this.vie = 80;
		  		break;
		  	case Mage:
		  		this.arme = new Sceptre();
		  		this.vie = 90;
		  		break;
		}
		
		/* Le Switch permet de faire la même chose que ceci :
		
		if (classe == Classe.Guerrier) {
			this.arme = new Epee();
			this.vie = 110;
		} else if (classe == Classe.Archer) {
			this.arme = new Arc();
			this.vie = 80;
		} else if (classe == Classe.Mage) {
			this.arme = new Sceptre();
			this.vie = 90;
		}
		
		*/
	}
	    
	    void recevoir(int degats) {
	    	this.vie = this.vie - degats;
	        
	        // Si la valeur de this.vie est négative, on la met à 0 : le personnage est mort
	        if (this.vie < 0) {
	        	this.vie = 0;
	        }
	    }
	    
	    void attaquer(Personnage personnage) {
	        personnage.recevoir(this.arme.degats);
	    }
	    
		//Fonction pour améliorer l'arme et augmenter ses dégâts
	    void ameliorerArme() {
	        this.arme.degats += 5;
	    }
}
```

### Tests


A l'aide de JUnit (5, dans mon cas), on va faire quelques tests unitaires pour vérifier que tout va bien :
TestPerso.java
```java
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
```