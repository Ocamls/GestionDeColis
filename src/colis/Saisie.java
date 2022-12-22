package colis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Saisie {
	
	public Saisie() {
		
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

}
