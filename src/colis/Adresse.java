package colis;

import chauffeur.CodePostal;

public class Adresse {
	private String ville;
	private String indications; 
	private int cP;
	
	public Adresse(String ville, String indications, int cP) {	
		this.ville = ville;
		this.indications = indications;
		this.cP = cP;
	} 
	
	@Override
	public String toString() {
		return indications + " " + ville + " " + cP;
	}
	
	

}
