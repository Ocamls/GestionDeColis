package colis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import chauffeur.*;

public class Main extends Saisie {

	public static Tournee[] listeTournees = new Tournee[17]; // liste contenant les tournées
	public static int nbTournees = 0; // nombre de tournées enregistrés 

	public static  Colis [] tousLesColis = new Colis[100]; // liste contenant les colis enregistrés 
	public static int nbTousLesColis; // nombre de colis enregistrés 

	// ##- Constructeur -## //
	public Main() {
	}

	// ##- Les menus -## //
	
	/*  Les fonctions menus sont des fonctions qui sont liés, elles permettent la navigation entre les différents points du système
	 * Le premier point est l'accès aux Tournées.
	 * Le deuxième point est l'accès aux colis.
	 * Si l'utilisateur saisie 0 il revient en arrière, s'il est déjà dans le menu principal, il se voit quitter le menu.
	 */
	public static void menuPp() {
		System.out.println("Que voulez vous faire ?\n");
		System.out.println("1- ACCÈS TOURNÉE ");
		System.out.println("2- ACCÈS COLIS ");
		System.out.println("0- QUITTER LE MENU PRINCIPAL");

		int userInputMenuPp = Integer.parseInt(inputOutput());
		switch (userInputMenuPp) {
		case 0: {
			break;
		}

		case 1: {
			menuTournee();
			break;
		}

		case 2: {
			menuColis();
			break;
		}
		default: {
			System.out.println("Erreur dans le choix du menu principal");
			menuPp();
			break;
		}
		}

	}

	public static void menuTournee() {
		System.out.println("Vous êtes dans le menu des TOURNÉES. \nQue voulez vous faire ?\n");
		System.out.println("1- Ajouter une tournée");
		System.out.println("2- Afficher les tournées ");
		System.out.println("3- Afficher La feuille de route");
		System.out.println("0- Revenir au menu principal");

		int userInputMenuTournee = Integer.parseInt(inputOutput());

		switch (userInputMenuTournee) {
		case 1: {
			Tournee tournee = saisieInfosTournee();
			listeTournees[nbTournees] = tournee;
			nbTournees++;
			System.out.println(tournee);
			menuTournee();
			break;
		}
		case 2: {
			if (nbTournees == 0) {
				System.out.println("Vous n'avez aucune tournée pour le moment");

			} else {
				System.out.println("Voici la liste de toutes les tournées\n");
				afficherLesTournees();
			}
			menuTournee();
			break;
		}
		case 3: {
			break;
		}
		case 0: {
			System.out.println("Vous venez de quitter le menu des Tournées vous allez revenir au menu principal\n");
			menuPp();
			break;
		}
		default: {
			System.out.println("Saisir un chiffre disponible");
			menuTournee();
			break;
		}
		}
	}
	
	public static void menuColis() {
		System.out.println("1- Ajouter un colis");
		System.out.println("2- Afficher la liste de tous les colis");
		System.out.println("3- Afficher la liste de tous les colis en fonction des tournées");
		System.out.println("0- revenir au menu principal");
		int userInputMenuColis = Integer
				.parseInt(inputOutput("Vous êtes dans le sous menu COLIS. \nQue voulez vous faire ?\n"));
		switch (userInputMenuColis) {
		case 0: {
			System.out.println("Vous venez de quitter le menu des Colis vous allez revenir au menu principal\n");
			menuPp();
			break;
		}
		case 1: {
			Colis colis = saisieInfosColis();
			System.out.println(colis);
			ajouterUnColis(colis);
			menuColis();
			break;
		}
		case 2: {
			//TODO faire une focntion qui permet seulement d'afficher les cases des colis qui ne sont pas vides 
			affichageDeTousLesColis();
			menuColis();
			break;
		}
		case 3: {
			// TODO Il faut ici mettre la fonction qui permet l'affichage de la liste de
			// tous les colis enregistrés en fonction des tournées
			String choixTourneeUserInput  = inputOutput("Saisir le nom de la Tournée dont vous voulez les colis :\n");
			while(tourneeDansLaListe(choixTourneeUserInput)== false) {
				choixTourneeUserInput = inputOutput("Re-Saisir le nom de la Tournee il faut qu'il soit déjà enregistré");
			}
			triColisPourUneTournee(choixTourneeUserInput);
			
			menuColis();
			break;
		}
		default: {
			System.out.println("Il faut saisir une valeur disponible");
			menuColis();
			break;
		}
		}
	}

	// ##- Les colis Gestion -## //

	public static Colis saisieInfosColis() {

		// Adresse du destinataire (Adresse)

		// Saisie de l'adresse en elle même (String)
		String adrDest = inputOutput("Saisir l'adresse du destinataire \n");

		// Saisie de la Ville (String)
		String villeDest = inputOutput("Saisir la ville du destinataire \n");

		// Saisie du code postal (CodePostal)
		String cPDest = inputOutput("Saisir le code postal du  destinataire");
		while (trouverCodePostal(cPDest) == null) {
			System.out.println("Code Postal NON VALIDE\n");
			cPDest = inputOutput("Re-Saisir le code postal du  destinataire");

		}
		System.out.println("Code Postal VALIDE\n");

		/* ######################################################################### */
		Adresse adrCompleteDest = new Adresse(villeDest, adrDest, cPDest);
		/* ######################################################################### */

		// Information du destinataire (Destinataire)

		// Saisie du nom (String)
		String nomDest = inputOutput("Saisir le nom du Destinataire \n");

		// Saisie du prénom (String)
		String prenomDest = inputOutput("Saisir le prénom du Destinataire \n");

		// Saisie du numero de téléphone (String)
		String numeroTelephoneDest = inputOutput("Saisir le numéro de téléphone du destinataire");

		// Adresse de l'expéditeur (Adresse)

		// Saisie de l'adresse en elle même (String)
		String adrExp = inputOutput("Saisir l'adresse de l'expéditeur\n");

		// Saisie de la Ville (String)
		String villeExp = inputOutput("Saisir la ville de l'expéditeur\n");

		// Saisie du code postal (CodePostal)
		String cPExp = inputOutput("Saisir le code postal de l'expéditeur");

		/* ######################################################################### */
		Adresse adrCompleteExp = new Adresse(villeExp, adrExp, cPExp);
		/* ######################################################################### */

		// Informations de l'expéditeur ( Expediteur)

		// saisie du nom de la Société (String)
		String nomSociete = inputOutput("Saisir le nom de la société expéditrice");

		// saisie du numéro de téléphone de la société (String)
		String numeroTelephoneSociete = inputOutput("Saisir le numéro de téléphone de la société\n");

		// poids du colis

		// saisie du poids du colis (int)
		int poidsColis = Integer.parseInt(inputOutput("Saisir le poids du colis"));

		/* ######################################################################### */
		Destinataire dest = new Destinataire(nomDest, prenomDest, adrCompleteDest, numeroTelephoneDest);
		/* ######################################################################### */

		Expediteur exp = new Expediteur(nomSociete, adrCompleteExp, numeroTelephoneSociete);
		/* ######################################################################### */
		
		/* Les deux lignes suivante sont destinés à être modifiées. 
		 * En effet à terme le code devrait prendre en charge le scan des codes barres et
		 *  permettre l'automatisation de la saisie.
		 */
		String codeBarre = inputOutput("Saisir le code Barre"); 
		CodeBarre cB = new CodeBarre(codeBarre);
		/* ######################################################################### */

		Colis colis = new Colis(dest, exp, cB, poidsColis);
		/* ######################################################################### */

		return colis;
	}

	public static Colis[] ajouterUnColis(Colis colis) {
		if (trouverCodePostal(colis.getCodePostalDest()) != null) {
			tousLesColis[nbTousLesColis] = colis;	
			nbTousLesColis ++;
		}
		return tousLesColis;
	}
		
	public static void triColisPourUneTournee(String nomTournee) {
		for (int iColis=0 ; iColis< nbTousLesColis; iColis++) {
			if (trouverCodePostal(tousLesColis[iColis].getCodePostalDest()).equals(nomTournee)) {
				System.out.println(tousLesColis[iColis].caracteristiquesColis());
			}
		}
	}

	public static void affichageDeTousLesColis() {
		int i=0; 
		while(i<nbTousLesColis) {
			if (!(tousLesColis[i].equals(null))) {
				System.out.println(tousLesColis[i].caracteristiquesColis());
			}
			i ++; 
		}
	}
	
	// ##- Les Tournées Gestion -## //
	
	public static Tournee saisieInfosTournee() {
		// Saisie du chauffeur
		// Saisie du nom
		String nomChauf = inputOutput("Saisir le nom du Chauffeur\n");
		// Saisie du prenom
		String prenomChauf = inputOutput("Saisir le prénom du Chauffeur\n");
		// Saisie de l'age
		int ageChauffeur = Integer.parseInt(inputOutput("Saisir l'âge du chauffeur\n"));

		Chauffeur chauffeur = new Chauffeur(nomChauf, prenomChauf, ageChauffeur);

		// Saisie du camion
		// Saisie du numéro d'immatriculation
		String numeroIm = inputOutput("Saisir le numéro d'immatriculation du camion\n");
		// Saisie du numéro du camion dans la société
		int numeroDuCamion = Integer.parseInt(inputOutput("Saisir le numéro du camion dans la société\n"));
		// Saisie du chauffeur
		Camion camion = new Camion(numeroIm, numeroDuCamion, chauffeur);

		// Saisie de la Tournee

		// Saisie du nom de la tournée
		String nomTournee = inputOutput("Saisir le nom de la Tournée\n");

		// Saisie du nombre de code postaux
		int nbCPs = Integer.parseInt(inputOutput("Saisir le nombre de codes postaux qu'il y a dans la tournée\n "));
		// Saisie de la liste de code Postaux
		Tournee tournee = new Tournee(nomTournee, chauffeur, camion, nbCPs);
//		String[] cPs = new String[nbCPs];
		tournee.saisirCPs(nbCPs);

		return tournee;

	}

	public static void afficherLesTournees() {
		for (int i = 0; i < nbTournees; i++) {
			System.out.println(listeTournees[i].getNom() + Arrays.toString(listeTournees[i].getcPs()));
		}
	}

	public static String trouverCodePostal(String codePostalColis) {
		for (int i = 0; i < nbTournees; i++) {
			int longueurDeLaListeDeCodePostaux = listeTournees[i].getNbCPs();
			for (int y = 0; y < longueurDeLaListeDeCodePostaux; y++) {
				if (codePostalColis.equals(listeTournees[i].getcPs()[y])) {
					return listeTournees[i].getNom();
				}
			}
		}
		return null;
	}

	public static boolean tourneeDansLaListe(String nomDeLaTournee) {
		boolean etat = false;
		for(int i=0; i<nbTournees; i++ ) {
			if (listeTournees[i].getNom().equals(nomDeLaTournee)) {
				etat = true; 
				break; 
			}
		}
		return etat; 
	}
	// ##- La saisie fonction modifié par rapport à la classe mère saisie -## //
	
	public static String inputOutput() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String returnString = "";
		try {
			returnString = br.readLine();
		} catch (IOException e) {
			System.out.println("Error reading in value");
		}
		return returnString;
	}
	
	public static void main(String[] args) {
		
		Chauffeur christopheC = new Chauffeur("Calmels", "Christophe", 56);
		Camion camion1 = new Camion("AA-000-AA", 1, christopheC);
		Tournee souillac = new Tournee("Souillac", christopheC, camion1, 3);
		souillac.saisirCPs(souillac.nbCodePostaux);
		listeTournees[nbTournees] = souillac;
		nbTournees ++; 
		
		Adresse adresse1 = new Adresse("Caussade", "19 rue Chanoine Galabert", "46100");
		Destinataire dest1 = new Destinataire("Calmels", "Christophe", adresse1, "0620212032");
		CodeBarre code1 = new CodeBarre("1597532486");
		Adresse adresseExp1 = new Adresse("Toulouse", "118 route de Narbonne", "31000");
		Expediteur env1 = new Expediteur("Université Paul Sabatier III", adresseExp1, "0615148459");
		Colis colis1 = new Colis(dest1, env1, code1, 5);
//		System.out.println(colis1);
		ajouterUnColis(colis1);
//		System.out.println(Arrays.toString(tousLesColis));

		
		
		Adresse adresseDest2 = new Adresse("Cahors", "19 place Gabetta", "46200");
		Destinataire dest2 = new Destinataire("Calmels", "Christophe", adresseDest2, "0620212032");
		CodeBarre code2 = new CodeBarre("161514121311");
		Adresse adresseExp2 = new Adresse("Toulouse", "118 route de Narbonne", "31000");
		Expediteur env2 = new Expediteur("Université Paul Sabatier III", adresseExp2, "0615148459");
		Colis colis2 = new Colis(dest2, env2, code2, 5);
		ajouterUnColis(colis2);
//		System.out.println(colis2);
//		System.out.println(Arrays.toString(tousLesColis));
		menuPp();

	}
}
