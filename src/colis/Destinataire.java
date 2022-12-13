package colis;

public class Destinataire {
	private String nom;
	private String prenom; 
	private Adresse adresse;
	private String numeroTelephone;

	public Destinataire(String nom, String prenom, Adresse adresse, String numeroTelephone) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.numeroTelephone = numeroTelephone;
	}
	public Adresse getAdresse() {
		return adresse;
	}
	@Override
	public String toString() {
		return nom + " "+ prenom + " | " + adresse + " | "+ numeroTelephone ;
	}
	
	public static void main(String[] args) {
		Adresse adresse1 = new Adresse("Caussade", "19 rue Chanoine Galabert", "82300");
		Destinataire dest1 = new Destinataire("Calmels", "Christophe",adresse1,"0620212032");
		System.out.println(dest1);
	}
	
}
