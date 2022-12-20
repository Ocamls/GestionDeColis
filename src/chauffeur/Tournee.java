package chauffeur;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import colis.*;

public class Tournee {
	private String nom;
	private Chauffeur chauffeur;
	private Camion camion;
	private static final int nbCodePostauxMax = 4;
	private int nbCPs = 0;
	private String[] cPs = new String[nbCodePostauxMax];
	private int nbCodePostaux;

	public Tournee(String nom, Chauffeur chauffeur, Camion camion, int nbCodePostaux) {
		this.nom = nom;
		this.chauffeur = chauffeur;
		this.camion = camion;
		this.nbCodePostaux = nbCodePostaux;
	}

	public static String inputOutput(String message) {
		System.out.println(message);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String returnString = "";
		try {
			returnString = br.readLine();
		} catch (IOException e) {
			System.out.println("Error reading in value");
		}
		return returnString;
	}

	public String[] saisirCPs(int nbCodePostaux) {
		System.out.println("Vous allez saisir les codes postaux pour la tournée de " + nom + ": \n");
		for (int i = 0; i < nbCodePostaux; i++) {
			cPs[nbCPs] = inputOutput("Saisir un code Postal");
			nbCPs++;
		}
		return cPs;
	}

	public String[] getcPs() {
		return cPs;
	}
	public String getNom() {
		return nom;
	}
	
	public String caracteristiquesTournee() {
		return chauffeur.getNom() + " " + chauffeur.getPrenom() + " conduit : " + camion.getNumeroIm() + " pour la tournée : "+ getNom();
		}

	@Override
	public String toString() {
		return "Tournée : " + nom + "\n" + "Camion : " + camion + "\n" + "Nombre de code postaux dans cette tournée :"
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
		System.out.println(souillac + "\n");

//		Tournee cahors = new Tournee("Cahors", antoineD, camion2, 1);
//		cahors.saisirCPs(cahors.nbCodePostaux);
//		System.out.println(cahors + "\n");
//
//		Tournee figeac = new Tournee("Figeac", cedricD, camion3, 1);
//		figeac.saisirCPs(figeac.nbCodePostaux);
//		System.out.println(figeac + "\n");
//
//		Tournee luzech = new Tournee("Luzech", christopheP, camion4, 4);
//		luzech.saisirCPs(luzech.nbCodePostaux);
//		System.out.println(luzech + "\n");
		
		System.out.println(souillac.caracteristiquesTournee());
		
		
	}
}
