package colis;

public class Expediteur { 
	private String nomSociete;
	private Adresse adresse;
	private String numeroTelephone;
	
	public Expediteur(String nomSociete, Adresse adresse, String numeroTelephone ) {
		this.nomSociete = nomSociete;
		this.adresse = adresse;
		this.numeroTelephone = numeroTelephone;
	}
	
	@Override
	public String toString() {
		return nomSociete + " " + "\n" + adresse + "\n" + numeroTelephone;
	}
	
	public static void main(String[] args) {
		Adresse adresse2 = new Adresse("Toulouse", "118 route de Narbonne", 31000);
		Expediteur env1 = new Expediteur("Université Paul Sabatier III", adresse2,"0615148459");
		System.out.println(env1);
	}
		
}
	
	
	
	

