package colis;

public class Colis {
	private Destinataire destinataire;
	private Expediteur envoyeur; 
	private CodeBarre codeBarre; 
	private double poids; // approxiamtif ou précis//

	public Colis(Destinataire destinataire, Expediteur envoyeur, CodeBarre codeBarre, double poids) {
		this.destinataire = destinataire;
		this.envoyeur = envoyeur;
		this.codeBarre = codeBarre;
		this.poids = poids;
	}

	@Override
	public String toString() {
		return "descriptif du colis \n######################################\n" +codeBarre + "\n" + destinataire + " \n" + "\n" + envoyeur + " \n###################################### \n" + "son poids est de : " + poids + "\n"  ;
	}

	public static void main(String[] args) {
		Adresse adresse1 = new Adresse("Caussade", "19 rue Chanoine Galabert", 82300);
		Destinataire dest1 = new Destinataire("Calmels", "Christophe",adresse1,"0620212032");
		
		CodeBarre code1 = new CodeBarre(745932242);

		Adresse adresse2 = new Adresse("Toulouse", "118 route de Narbonne", 31000);
		Expediteur env1 = new Expediteur("Université Paul Sabatier III", adresse2,"0615148459");
		
		Colis colis1 = new Colis(dest1, env1, code1,5);
		System.out.println(colis1);
	}

}
