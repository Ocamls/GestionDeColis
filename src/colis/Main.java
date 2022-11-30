package colis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	private Colis colis;

	public static void menu() {
		//Menu d'affichage de base //
		System.out.println("1- Ajouter un colis");
		System.out.println("2- Ajouter un tournée");

		// TODO Faire l'input de l'utilisateur pour le choix dans le menu 
		
		System.out.println("Saisir le menu que vous voulez !");
		int userInput = Integer.parseInt(inputOutput("Que voulez vous faire ?\n"));
		
		switch (userInput) {
			case 1: {
				System.out.println("Passage dans le switch avec la valeur 1 ");
				// TODO Faire en sorte de saisir un colis
				Colis colis =saisieInfosColis();
				System.out.println(colis);
				break;
			}
			case 2: {
				System.out.println("Passage dans le switch avec la valeur 2 ");
	
				// TODO Faire en sorte de saisir une Tournée
				break;
			}
			default:
				System.out.println("Il faut saisir une valeur entre 1 et 2");
				break;
			}

	}	



    private static String inputOutput(String message) {
        System.out.println(message);
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String returnString = "";
	    try {
	        returnString = br.readLine();
	    }
	    catch (IOException e){
	        System.out.println("Error reading in value");
	    }
	    return returnString;
    }

	private static Colis saisieInfosColis() {

		// Adresse du destinataire (Adresse)
		
		// Saisie de l'adresse en elle même (String)
		String adrDest =  inputOutput("Saisir l'adresse du destinataire \n");
		
		// Saisie de la Ville (String)
		String villeDest =  inputOutput("Saisir la ville du destinataire \n");

		// Saisie du code postal (CodePostal)		
		/* TODO class CodePostal à finir, essayer de faire un tableau de code Postal 
		 * Pour le moment je mettre un code postal par def ATTENTION */
		
		/* #########################################################################*/
		Adresse adrCompleteDest = new Adresse(villeDest, villeDest, 46000);
		/* #########################################################################*/

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
		/* TODO class CodePostal à finir, essayer de faire un tableau de code Postal 
		 * Pour le moment je mettre un code postal par def ATTENTION */
		
		/* #########################################################################*/
		Adresse adrCompleteExp = new Adresse(villeExp, villeExp, 82000);
		/* #########################################################################*/
		
		// Informations de l'expéditeur ( Expediteur)
		
		// saisie du nom de la Société (String)
		String nomSociete = inputOutput("Saisir le nom de la société expéditrice");
		
		// saisie du numéro de téléphone de la société (String)
		String numeroTelephoneSociete = inputOutput("Saisir le numéro de téléphone de la société\n");

		// poids du colis
		
		// saisie du poids du colis (int)
		int poidsColis = Integer.parseInt(inputOutput("Saisir le poids du colis"));
		
		/* #########################################################################*/
		Destinataire dest = new Destinataire(nomDest, prenomDest, adrCompleteDest, numeroTelephoneDest);
		/* #########################################################################*/

		Expediteur exp = new Expediteur(nomSociete,adrCompleteExp , numeroTelephoneSociete);
		/* #########################################################################*/

		CodeBarre cB = new CodeBarre(123456789);
		/* #########################################################################*/

		Colis colis = new Colis(dest, exp, cB , poidsColis);
		/* #########################################################################*/

		return colis; 
	}

	public static void main(String[] args) {
		menu();


	}
}
