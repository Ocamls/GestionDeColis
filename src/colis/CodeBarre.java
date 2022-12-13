package colis;

public class CodeBarre {
	private int numCodeBarre; 
	
	public CodeBarre(int numCodeBarre) {
		this.numCodeBarre = numCodeBarre;
	}
	
	@Override
	public String toString() {
		return " " + numCodeBarre ;
	}
	
	public static void main(String[] args) {
		CodeBarre code1 = new CodeBarre(745932242);
		System.out.println(code1);
		
	}

}
