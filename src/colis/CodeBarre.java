package colis;

/* 
 * Cette class ne semble pas complète en effet elle va subir des améliorations 
 * Le but prinicpal est de finir avec une class capable de scanner les code Barre 
 * pour permettre de saisir directement les informations avec une douchette 
 * (un scanner de code barre comme dans les magasins)
 */

public class CodeBarre {
	private String numCodeBarre; 
	
	public CodeBarre(String numCodeBarre) {
		this.numCodeBarre = numCodeBarre;
	}
	
	@Override
	public String toString() {
		return " " + numCodeBarre ;
	}
	
	public static void main(String[] args) {
		CodeBarre code1 = new CodeBarre("7531592468");
		System.out.println(code1);
		
	}

}
