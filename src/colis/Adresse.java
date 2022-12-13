package colis;


public class Adresse {
	private String ville;
	private String indications; 
	private String cP;
	
	public Adresse(String ville, String indications, String cP) {	
		this.ville = ville;
		this.indications = indications;
		this.cP = cP;
	} 
	public String getcP() {
		return cP;
	}
	@Override
	public String toString() {
		return indications + " " + ville + " " + cP;
	}
	
	public static void main(String[] args) {
		Adresse adr = new Adresse("Caussade", "19 rue Chanoine Galabert", "82300");
		System.out.println(adr);
	}
	

}
