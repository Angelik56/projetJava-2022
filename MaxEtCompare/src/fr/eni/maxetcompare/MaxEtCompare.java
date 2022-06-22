package fr.eni.maxetcompare;

public class MaxEtCompare {

	public static void main(String[] args) {
		
		int a =5;
		int b = 10;

		int c = plusGrand(a,b);
		int d = comparaison (a,b);
		
		System.out.println("Le chiffre le plus grand : " + c);
		
		System.out.println("Résultat de la comparaison : " + d);
	}

	public static int plusGrand (int a, int b) {
		
		int resultat;
		
		if (a>b) {
			resultat = a;
		}
		else {
			resultat = b;}
			
	 return resultat;
	
	} 

	public static int comparaison(int a, int b){
		
		int resultat = 0;
		
		if (a == b) {
			resultat = 0;
		}
		if (a>b) {
			resultat = 1;
		}
		if (a<b) {
			resultat = -1;
		}
	return resultat;
	}
}

