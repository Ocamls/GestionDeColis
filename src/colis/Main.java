package colis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import chauffeur.Camion;
import chauffeur.Chauffeur;
import chauffeur.Tournee;

public class Main {

	public static void menu() {
		// Menu d'affichage de base //
		System.out.println("1- Ajouter un tournée");
		System.out.println("2- Ajouter un colis");
		System.out.println("3- Enlever un colis");
		System.out.println("4- Modifier un colis ");
		System.out.println("0- Quitter");
		/* TODO Faire un double menu une première partie pour
		 * les tournées et une deuxième partie pour les colis
		 * et à l'interieur de chaque menu un autre menu qui permet de toucher à l'objet choisi */
		// TODO Faire l'input de l'utilisateur pour le choix dans le menu
		

		System.out.println("Saisir le menu que vous voulez !");
		int userInput = Integer.parseInt(inputOutput("Que voulez vous faire ?\n"));

		switch (userInput) {
			case 0:{
				System.out.println("Vous venez de quitter le menu :)\n");
				break;
			}
			case 1: {
				Tournee tournee = saisieInfosTournee();
				System.out.println(tournee);
				menu();
				break;
			}
			case 2: {
				Colis colis = saisieInfosColis();
				menu();
				System.out.println(colis);
				break;
			}
			default:{
				System.out.println("Il faut saisir une valeur disponible");
				menu();
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
		//Saisie du chauffeur
		//Saisie du nom
		String nomChauf = inputOutput("Saisir le nom du Chauffeur\n");
		//Saisie du prenom
		String prenomChauf = inputOutput("Saisir le prénom du Chauffeur\n");
		//Saisie de l'age
		int ageChauffeur = Integer.parseInt(inputOutput("Saisir l'âge du chauffeur\n"));
		
		Chauffeur chauffeur = new Chauffeur(nomChauf, prenomChauf, ageChauffeur);
		
		// Saisie du camion
		//Saisie du numéro d'immatriculation
		String numeroIm = inputOutput("Saisir le numéro d'immatriculation du camion\n");
		//Saisie du numéro du camion dans la société
		int numeroDuCamion = Integer.parseInt(inputOutput("Saisir le numéro du camion dans la société\n"));
		//Saisie du chauffeur
		Camion camion = new Camion(numeroIm, numeroDuCamion, chauffeur);		
		
		// Saisie de la Tournee
		
		//Saisie du nom de la tournée
		String nomTournee = inputOutput("Saisir le nom de la Tournée\n");
		
		//Saisie du nombre de code postaux
		int nbCPs = Integer.parseInt(inputOutput("Saisir le nombre de codes postaux qu'il y a dans la tournée\n "));
		//Saisie de la liste de code Postaux
		Tournee tournee = new Tournee(nomTournee, chauffeur, camion, nbCPs);
		String[] cPs = new String[nbCPs];
		tournee.saisirCPs(nbCPs);
		
		return tournee;
		
	}
	public static void main(String[] args) {
		menu();

	}
}
