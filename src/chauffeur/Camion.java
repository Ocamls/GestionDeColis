package chauffeur;

public class Camion {
	private String numeroIm;
	private int numeroDuCamion;
	private Chauffeur chauffeur;

 // creer une fonction qui permet de changer un colis de camion/ de chauffeur / de tournée
	public Camion(String numeroIm, int numeroDuCamion, Chauffeur chauffeur) {
		this.numeroIm = numeroIm;
		this.numeroDuCamion = numeroDuCamion;
		this.chauffeur = chauffeur;
	}
	public int getNumeroDuCamion() {
		return numeroDuCamion;
	}
	public String getNumeroIm() {
		return numeroIm;
	}
	@Override
	public String toString() {
		return "[ " + numeroIm + " ]" + "(" + numeroDuCamion + ")\n" + "Chauffeur : " + chauffeur.getNom() + " "+ chauffeur.getPrenom();  
	}


	public static void main(String[] args) {
		Chauffeur christopheC = new Chauffeur("Calmels", "Christophe", 56);
		Camion camion1 = new Camion("AA-000-AA", 1, christopheC);
		System.out.println(camion1);
	}

}
