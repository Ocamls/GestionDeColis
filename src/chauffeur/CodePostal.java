package chauffeur;

import java.io.*;
import java.util.*;

public class CodePostal {
	private int numero;
	private static int nbCodePostauxMax = 10;
	private String[] cPs = new String[nbCodePostauxMax];
	private int nbCodePostaux;

	public CodePostal(int numero) {
		this.numero = numero;
	}

//	public String[] ajouterCP(int numero) {
//		if (numero == 0) {
//			System.out.println("Erreur pour ajouter un code postal il en faut au moins 1");
//		} else if (numero > nbCodePostauxMax || nbCodePostaux > nbCodePostauxMax) {
//			System.out.println("Vous ne pouvez pas mettre plus de " + nbCodePostauxMax + "dans une tournée");
//		} else {
//			for (int i = 0; i < numero; i++) {
//				Scanner scanner = new Scanner(System.in);
//				String cP = scanner.nextLine();
//				cPs[i] = cP;
//				scanner.close();
//				nbCodePostaux++;
//
//			}
//		}
//		return cPs;
//	}

	@Override
	public String toString() {
		return "Il y a " + numero + " CP";
	}

	public static void main(String[] args) {

		CodePostal cP1 = new CodePostal(3);
		System.out.println(cP1);
		String[] cPs = new String[nbCodePostauxMax];
		

	}

}
