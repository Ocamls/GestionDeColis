package chauffeur;


import java.util.Arrays;

import colis.*;

public class Tournee extends Saisie{
	private String nom;
	private Chauffeur chauffeur;
	private Camion camion;
	private static final int NBCODEPOSTAUXMAX = 4;
	private int nbCPs = 0;
	private String[] cPs = new String[NBCODEPOSTAUXMAX];
	private int nbCodePostaux;
	
	private String[] colisDuJour = new String[20];
	private int nbColisDuJour;

	public Tournee(String nom, Chauffeur chauffeur, Camion camion, int nbCodePostaux) {
		this.nom = nom;
		this.chauffeur = chauffeur;
		this.camion = camion;
		this.nbCodePostaux = nbCodePostaux;
	}
	// ##- Les getter -## // 
	public String[] getcPs() {
		return cPs;
	}

	public String getNom() {
		return nom;
	}
	
	public int getNbCodePostaux() {
		return nbCodePostaux;
	}
	
	public int getNbCPs() {
		return nbCPs;
	}
	
	// ##- Les setter -## // 
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public void setNbCodePostaux(int nbCodePostaux) {
		this.nbCodePostaux = nbCodePostaux;
	}
	
	// ##- Les méthodes -## //
	
	
	public String[] saisirCPs(int nbCodePostaux) {
		System.out.println("Vous allez saisir les codes postaux pour la tournée de " + nom + ": \n");
		for (int i = 0; i < nbCodePostaux; i++) {
			cPs[nbCPs] = inputOutput("Saisir un code Postal");
			nbCPs++;
		}
		return cPs;
	}

	public String caracteristiqueTournee() {
		return chauffeur.getNom() +" " + chauffeur.getPrenom()+ " "+camion.getNumeroIm();
	}
	
	public String feuilleDeRoute(){
		return caracteristiqueTournee() + " \n" +  Arrays.toString(colisDuJour);
		
	}
	/* Cette fonction ressemble à la fonction trouverCodePostal sauf que 
	 * la fonction trouverCodePostal permet de chez dans la liste de toutes les tournées initialisé 
	 * càd que si le code postal ne se trouve dans aucune des tournées il ne peut pas être initialisé 
	 * Je vais donc voir si il ne faut pas que je supprime la focntion en dessous
	 */
	public boolean codePostalDedans(String codePostal) {
		for (int i = 0; i < getNbCodePostaux(); i++) {
			if (codePostal.equals(getcPs()[i])) {
				return true; 
			}
		}
		return false; 
	}
	public void afficherListeDeColis() {
		for (int i=0; i<nbColisDuJour; i++) {
			if (colisDuJour[i]!=null) {
				System.out.println(colisDuJour[i]);
			}
		}
	}

	public String[] ajouterUnColis(Colis colis) {
		if (codePostalDedans(colis.getCodePostalDest())) {
			this.colisDuJour[nbColisDuJour] = colis.caracteristiquesColis();
			nbColisDuJour++;
			return colisDuJour;
		}
		else {
			return colisDuJour;
		}
	}
	
	// ##- La méthode de saisie -## // 
	

	
	@Override
	public String toString() { 
		return "Tournée : " + nom + "\n" + "Camion : " + camion +"\n" + "Nombre de code postaux dans cette tournée :"
				+ nbCodePostaux + " " + Arrays.toString(cPs);
	}

	public static void main(String[] args) { 
		Chauffeur christopheC = new Chauffeur("Calmels", "Christophe", 56);
//		Chauffeur antoineD = new Chauffeur("Devals", "Antoine", 32);
//		Chauffeur cedricD = new Chauffeur("Diogo", "Cedric", 25);
//		Chauffeur christopheP = new Chauffeur("Perrin", "Christophe", 37);

		Camion camion1 = new Camion("AA-000-AA", 1, christopheC);
//		Camion camion2 = new Camion("BB-111-BB", 2, antoineD);
//		Camion camion3 = new Camion("CC-222-CC", 3, cedricD);
//		Camion camion4 = new Camion("DD-333-DD", 4, christopheP);

		Tournee souillac = new Tournee("Souillac", christopheC, camion1, 3);
		souillac.saisirCPs(souillac.nbCodePostaux);
//		System.out.println(souillac + "\n");

//		Tournee cahors = new Tournee("Cahors", antoineD, camion2, 1);
//		cahors.saisirCPs(cahors.nbCodePostaux);
//		System.out.println(cahors + "\n");

//		Tournee figeac = new Tournee("Figeac", cedricD, camion3, 1);
//		figeac.saisirCPs(figeac.nbCodePostaux);
//		System.out.println(figeac + "\n");

//		Tournee luzech = new Tournee("Luzech", christopheP, camion4, 4);
//		luzech.saisirCPs(luzech.nbCodePostaux);
//		System.out.println(luzech + "\n");
		
		System.out.println(souillac.feuilleDeRoute());
		

	}
}
