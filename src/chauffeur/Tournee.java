package chauffeur;

public class Tournee {
	private String nom;
	private Chauffeur chauffeur; 
	private Camion camion; 
//	private CodePostal cP;
	private int nbCodePostaux=0;
//	private CodePostal[] cPs = new CodePostal[10];

		
	
	public Tournee(String nom, Chauffeur chauffeur, Camion camion, int nbCodePostaux) {
		this.nom = nom;
		this.chauffeur = chauffeur;
		this.camion = camion;
		this.nbCodePostaux = nbCodePostaux;
	}
//	public CodePostal[] ajouterCP(CodePostal cP) {
//		this.cPs[nbCodePostaux] = cP;
//		nbCodePostaux ++;
//		return cPs;
//	}

	@Override
	public String toString() {
		return "Tournée : " + nom + "\n" +  "Camion : " + camion + "\n" + "Nombre de code postaux dans cette tournée :" + nbCodePostaux; 
	}

	public static void main(String[] args) {
		Chauffeur christopheC = new Chauffeur("Calmels", "Christophe", 56);
		Chauffeur antoineD = new Chauffeur("Devals", "Antoine", 32);
		Chauffeur cedricD = new Chauffeur("Diogo", "Cedric", 25);
		Chauffeur christopheP = new Chauffeur("Perrin", "Christophe", 37);
		
		Camion camion1 = new Camion("AA-000-AA", 1, christopheC);
		Camion camion2 = new Camion("BB-111-BB", 2, antoineD);
		Camion camion3 = new Camion("CC-222-CC", 3, cedricD);
		Camion camion4 = new Camion("DD-333-DD", 4, christopheP);
		
		

		Tournee cahors = new Tournee("Cahors", antoineD, camion2,1);
		System.out.println(cahors+ "\n");
		Tournee souillac = new Tournee("Souillac", christopheC, camion1, 3);
		System.out.println(souillac+ "\n");
		Tournee figeac = new Tournee("Figeac",cedricD,camion3,1);
		System.out.println(figeac + "\n");
		Tournee luzech = new Tournee("Luzech", christopheP, camion4, 4);
		System.out.println(luzech+ "\n");
		
		
	}

}
