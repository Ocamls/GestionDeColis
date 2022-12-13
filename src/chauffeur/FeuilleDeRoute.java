package chauffeur;

import java.util.Arrays;

import colis.Adresse;
import colis.CodeBarre;
import colis.Colis;
import colis.Destinataire;
import colis.Expediteur;

public class FeuilleDeRoute {
	private Tournee tournee; 
	private String[] colisDuJour = new String[100];
	private int nbColisDuJour;
	
	public FeuilleDeRoute(Tournee tournee) {
		this.tournee = tournee;
	} 
	
	public Tournee getTournee() {
		return tournee;
	}
	public String[] ajouterUnColis(Colis colis ) {
		this.colisDuJour[nbColisDuJour] = colis.caracteristiquesColis() ; 
		nbColisDuJour ++; 
		return colisDuJour;
	}
	
	
	@Override
	public String toString() {
		return tournee.caracteristiquesTournee() + "\n" + Arrays.toString(colisDuJour);
	}
	
	public static void main(String[] args) {
		Chauffeur christopheC = new Chauffeur("Calmels", "Christophe", 56);
		Camion camion1 = new Camion("AA-000-AA", 1, christopheC);

		Tournee souillac = new Tournee("SOUILLAC",christopheC, camion1, 3);
		souillac.saisirCPs(3);
		
		FeuilleDeRoute f1 = new FeuilleDeRoute(souillac);
//		System.out.println(f1);
		
		Adresse adresse1 = new Adresse("Caussade", "19 rue Chanoine Galabert", "82300");
		Destinataire dest1 = new Destinataire("Calmels", "Christophe",adresse1,"0620212032");
		
		CodeBarre code1 = new CodeBarre(745932242);

		Adresse adresse2 = new Adresse("Toulouse", "118 route de Narbonne", "31000");
		Expediteur env1 = new Expediteur("Université Paul Sabatier III", adresse2,"0615148459");
		
		Colis colis = new Colis(dest1, env1, code1,5);
		f1.ajouterUnColis(colis);
		System.out.println(f1);
	}
	

}
