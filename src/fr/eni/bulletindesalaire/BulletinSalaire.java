package fr.eni.bulletindesalaire;

import java.text.DecimalFormat;
import java.util.Scanner;

public class BulletinSalaire {

	private static Scanner scanner;
	
	
	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		
		DecimalFormat df = new DecimalFormat("#.##"); // affichage decimal
		
		int statut = 0;
		String grade;
		/* affichage des saisie*/
		System.out.println(" ");
		System.out.println("                                   *****  Informations à saisir *****     ");
		System.out.println(" ");
		System.out.println("NOM : ");
		String nom = scanner.nextLine();
		System.out.println("Prénom :");
		String prenom = scanner.nextLine();
		System.out.println("Saisisez le numéro correspondant au statut :");
		System.out.println("1 : Employé");
		System.out.println("2 : Agent de maitrise");
		System.out.println("3 : cadre");
		statut = scanner.nextInt();
		// choix statut
		switch (statut) {
		case 1: grade = "Employé"; break;
		case 2 : grade = "Agent de maitrise";break;
		case 3 : grade = "Cadre";break;
		default: grade = "saisie incorrect";break;
		}
		System.out.println("Saisir le nombre d'heures effectuées :");
		int nbHeures = scanner.nextInt();
		System.out.println( "Saisir le taux horaire : ");
		float tauxHoraire = scanner.nextFloat();
		System.out.println("Nombre d'enfant :");
		int nbEnfant = scanner.nextInt();
		/* calcul nombres d'heures travaillées*/
		int nbHeuresSansMajoration = 0;
		int nbHeuresSupSup = 0;
		int nbHeuresSup = 0;
		int pallierHeuresSupSup = 180;
		int pallierHeuresSansMajoration = 169;
		//calcul repartition des heures
		nbHeuresSansMajoration = nbHeures - nbHeuresSupSup - nbHeuresSup;
		nbHeuresSup = nbHeures - nbHeuresSupSup - pallierHeuresSansMajoration;
		nbHeuresSupSup = nbHeures - pallierHeuresSupSup;
		//calcul montant des heures
		float montantHeuresSupSup = 0.00f;
		float montantHeuresSup = 0.00f;
		float montantHeuresSansMajoration = 0.00f;
		float majHeuresSupSup = (tauxHoraire * 60.0f)/100.00f;
		float majHeuresSup = (tauxHoraire* 50.0f)/100.00f;
		montantHeuresSupSup = (nbHeuresSupSup * (tauxHoraire + majHeuresSupSup));
		montantHeuresSup = nbHeuresSup * (tauxHoraire + majHeuresSup );
		montantHeuresSansMajoration = nbHeuresSansMajoration * tauxHoraire;
		// calcul salaire Brut
	    float salaireBrut = 0.00f;
		salaireBrut = (float) (montantHeuresSupSup +  montantHeuresSup + montantHeuresSansMajoration);
		 // affichage de l'en-tête
		System.out.println("______________________________________________________________________________________________________");
		System.out.println(" ");
		System.out.println("                                       BULLETIN DE SALIARE");
		System.out.println(" ");
		System.out.println("______________________________________________________________________________________________________");
		System.out.println(nom);
		System.out.println(prenom);
		System.out.println("Statut :" + grade);
	    System.out.println("Taux horaire : " + tauxHoraire + " %");
	    System.out.println(" ");
		//affichage des heures + montant des heures sup
		System.out.println("          *****  Répartition des heures travaillées  *****");
		System.out.println(" ");
		System.out.println("                                                          Heures         Montant");
		System.out.println(" ");
		System.out.println("Nombre d'heures sans majoration :                            " + nbHeuresSansMajoration + "           " +df.format(montantHeuresSansMajoration) + " €" );
		System.out.println("Nombre d'heures supplémentaires majorées à 50 % :             " + nbHeuresSup + "           " + df.format(montantHeuresSup) + " €" );
		System.out.println("Nombre des heures supplémentaires majorées à 60 % :           " + nbHeuresSupSup +"           " + df.format(montantHeuresSupSup) + " €");
		System.out.println(" ");
		System.out.println("                   *****  Salaire Brut  *****");
		System.out.println(" ");
		/* Affichage salaire brut */
		System.out.println("Salaire brut :                                                              " + salaireBrut );
		System.out.println(" ");
		System.out.println("          *****  Prélèvement des cotisations  *****");
		System.out.println(" ");
		/* calcul salaire net*/
		float detteSociale = (float) (salaireBrut * 3.49/100);
		float socialeGen =  (float) (salaireBrut * 6.15/100) ;
		float assuranceMal =  (float) (salaireBrut * 0.95f/100);
		float assuranceVeil =  (float) (salaireBrut * 8.44/100);
		float assuranceCho =  (float) (salaireBrut * 3.05/100);
		float retraiteComp =  (float) (salaireBrut * 3.81/100);
		float cotisationAgff = (float) (salaireBrut * 1.02/100);
		System.out.println("Contribution de rembooursement de la dette sociale :                        " + df.format(detteSociale) + " €");
		System.out.println("Contribution Sociale généralisée non imposable :                            " + df.format(socialeGen) + " €");
		System.out.println("Assurance maladie :                                                         " + df.format(assuranceMal) + " €");
		System.out.println("Assurance veillesse :                                                       " + df.format(assuranceVeil) + " €");
		System.out.println("Assurance chômage :                                                         " + df.format(assuranceCho) + " €");
		System.out.println("retraite Complémentaire (IRCEM) :                                           " + df.format(retraiteComp) + " €");
		System.out.println("Cotisation AGFF :                                                           " + df.format(cotisationAgff) + " €");
		float totalCotisations = cotisationAgff + retraiteComp + assuranceCho + assuranceVeil + assuranceMal + assuranceVeil + assuranceCho + retraiteComp + cotisationAgff;
		float totalSalaireNet = salaireBrut - totalCotisations;
		System.out.println(" ");
		System.out.println( "Total des cotisations                                                       "+ df.format(totalCotisations));
		/* calcul prime familiale */
		System.out.println(" ");
        int primeEnfant =0;
		switch (nbEnfant) 
			{
		case 1 : primeEnfant = 20; break;
		case 2 : primeEnfant = 50; break;
		case 3 : primeEnfant = 70 + ((nbEnfant - 2) * 20); break;
		case 0 : primeEnfant = 0; break;
		}
		System.out.println("Prime familiale :                                                            " + primeEnfant + " €" );
		System.out.println(" ");
		/* calcul du salaire à verser */
		int salaireVerse = (int) (totalSalaireNet + primeEnfant);
		System.out.println("                                                                            ********");
	    System.out.println("Salaire net :                                                                 " + df.format(salaireVerse) + "€" );
	    System.out.println("                                                                            ********");
		}
} 		








