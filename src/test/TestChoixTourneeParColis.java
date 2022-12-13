package test;

import chauffeur.*;
import colis.*;

public class TestChoixTourneeParColis {
	private FeuilleDeRoute feuilleDeRoute1; 

	private Colis colis1;
	private Colis colis2; 
	private Colis colis3;
	
	
	public TestChoixTourneeParColis() {
	}
	
	private static  void miseEnPlace() {
		Chauffeur chauffeur = new Chauffeur("Calmels", "Christophe", 56);
		Camion camion = new Camion("AA-000-AA", 1, chauffeur);
		Tournee tournee = new Tournee("tournee", chauffeur, camion, 4);
		FeuilleDeRoute feuille  = new FeuilleDeRoute(tournee);
		
		Adresse adrDest1 = new Adresse("Caussade", "3 rue Louis Durey Pavillon G5", "82300");
		Destinataire dest1 = new Destinataire("Calmels","Océane",adrDest1,"0610908357");
		Adresse adrExp1 = new Adresse("Toulouse","118 route de Narbonne","31062");
		Expediteur exp1 = new Expediteur("Université Paul Sabatier", adrExp1, "0561556611");
		CodeBarre codeBarre1 = new CodeBarre(123456789);
		double poids1 = 1.0;
		Colis colis1 = new Colis(dest1, exp1, codeBarre1, poids1);
		
		Adresse adrDest2 = new Adresse("Caussade", "3 rue Louis Durey Pavillon G5", "82300");
		Destinataire dest2 = new Destinataire("Calmels","Océane",adrDest2,"0610908357");
		Adresse adrExp2 = new Adresse("Toulouse","118 route de Narbonne","31062");
		Expediteur exp2 = new Expediteur("Université Paul Sabatier", adrExp2, "0561556611");
		CodeBarre codeBarre2 = new CodeBarre(123456789);
		double poids2 = 1.0;
		Colis colis2 = new Colis(dest2, exp2, codeBarre2, poids2);
		
		Adresse adrDest3 = new Adresse("Caussade", "3 rue Louis Durey Pavillon G5", "82300");
		Destinataire dest3 = new Destinataire("Calmels","Océane",adrDest3,"0610908357");
		Adresse adrExp3 = new Adresse("Toulouse","118 route de Narbonne","31062");
		Expediteur exp3 = new Expediteur("Université Paul Sabatier", adrExp3, "0561556611");
		CodeBarre codeBarre3 = new CodeBarre(123456789);
		double poids3 = 1.0;
		Colis colis3 = new Colis(dest3, exp3, codeBarre3, poids3);
		
		feuille.ajouterUnColis(colis1);
		feuille.ajouterUnColis(colis2);
		feuille.ajouterUnColis(colis3);
		System.out.println(feuille);
	}
	
	public static void main(String[] args) {
		miseEnPlace();
	}

}
