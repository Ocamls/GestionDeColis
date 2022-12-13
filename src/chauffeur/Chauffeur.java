package chauffeur;

/* Il s'agit de la class qui gère les chauffeurs */
public class Chauffeur {
	private String nom; 
	private String prenom; 
	private int age;
	private Camion camion;
	private Tournee tournee; 
	
	public Chauffeur(String nom, String prenom, int age) {
		this.nom = nom; 
		this.prenom = prenom; 
		this.age = age; 
		
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public int getAge() {
		return age;
	}
	
	@Override
	public String toString() {
		return nom + " " + prenom + " " + age + " ans";
	}

	public static void main(String[] args) {
		Chauffeur christopheC = new Chauffeur("Calmels", "Christophe", 56);
		Chauffeur antoineD = new Chauffeur("Devals", "Antoine", 32);
		Chauffeur cedricD = new Chauffeur("Diogo", "Cedric", 25);
		Chauffeur christopheP = new Chauffeur("Perrin", "Christophe", 37);
		System.out.println(christopheC);
		System.out.println(antoineD);
		System.out.println(cedricD);
		System.out.println(christopheP);
	}

}
