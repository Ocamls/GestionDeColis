package colis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import chauffeur.Camion;
import chauffeur.Chauffeur;
import chauffeur.FeuilleDeRoute;
import chauffeur.Tournee;

public class Main {
	public static Tournee[] listeTournees = new Tournee[17];
	public static int nbTournees = 0; 
	
	public Main() {
		
	}
	public static void menuPp() {
		System.out.println("1- ACCÈS TOURNÉE ");
		System.out.println("2- ACCÈS COLIS ");
		System.out.println("0- QUITTER LE MENU PRINCIPAL");

		int userInputMenuPp = Integer.parseInt(inputOutput("Que voulez vous faire ?\n"));
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
		System.out.println("2- Afficher La feuille de route");
		System.out.println("3- Afficher les tournées ");
		System.out.println("0- Revenir au menu principal");

		int userInputMenu1SousMenu1 = Integer.parseInt(inputOutput(" "));

		switch (userInputMenu1SousMenu1) {
		case 1: {
			Tournee tournee = saisieInfosTournee();
			listeTournees[nbTournees] = tournee;
			nbTournees ++;
			System.out.println(tournee);
			menuPp();
			break;
		}
		case 2 :{
			//Il y a un bug entre les fonctions il faut résoudre le problème
//			FeuilleDeRoute feuille1 = new FeuilleDeRoute(tournee);
			// TODO Faire l'affichage de la feuille de route                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         
		}
		case 3 :{
			
		}
		case 0: {
			System.out.println("Vous venez de quitter le menu des Tournées vous allez revenir au menu principal\n");
			menuPp();
			break;
		}
		default: {
			System.out.println("Saisir un chiffre disponible");
			menuTournee();
		}
		}

	}

	public static void menuColis() {
		System.out.println("1- Ajouter un colis \n");
		System.out.println("2- Retirer un colis \n");
		System.out.println("3- Modifier un colis\n");
		System.out.println("4- Afficher la liste de tous les colis\n");
		System.out.println("5- Afficher la liste de tous les colis en fonction des tournées");
		System.out.println("0- revenir au menu principal");

		int userInputMenu1SousMenu2 = Integer
				.parseInt(inputOutput("Vous êtes dans le sous menu COLIS. \nQue voulez vous faire ?\n"));

		switch (userInputMenu1SousMenu2) {
		case 0: {
			System.out.println("Vous venez de quitter le menu des Colis vous allez revenir au menu principal\n");
			menuPp();
			break;
		}
		case 1: {
			Colis colis = saisieInfosColis();
			System.out.println(colis);
			
			menuColis();
			break;
		}
		case 4: {
			// TODO Il faut ici mettre la fonction qui permet l'affichage de la liste de
			// tous les colis enregistrés
		}
		case 5: {
			// TODO Il faut ici mettre la fonction qui permet l'affichage de la liste de
			// tous les colis enregistrés en fonction des tournées
		}

		default: {
			System.out.println("Il faut saisir une valeur disponible");
			menuPp();
			break;
		}
		}

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

	
	
	private static Colis saisieInfosColis() {

		// Adresse du destinataire (Adresse)

		// Saisie de l'adresse en elle même (String)
		String adrDest = inputOutput("Saisir l'adresse du destinataire \n");

		// Saisie de la Ville (String)
		String villeDest = inputOutput("Saisir la ville du destinataire \n");

		// Saisie du code postal (CodePostal)
		String cPDest = inputOutput("Saisir le code postal du  destinataire");

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
		String villeExp = inputOutput("Saisir lea ville de l'expéditeur\n");

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

		CodeBarre cB = new CodeBarre(123456789);
		/* ######################################################################### */

		Colis colis = new Colis(dest, exp, cB, poidsColis);
		/* ######################################################################### */

		return colis;
	}

	private static Tournee saisieInfosTournee() {
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

	public static void main(String[] args) {
		menuPp();

	}
}
