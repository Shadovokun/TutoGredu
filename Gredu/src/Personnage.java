
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
