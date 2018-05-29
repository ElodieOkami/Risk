import java.util.Random;

public class Mission {
	String contenu;
	int idMission;
	
	
	//----------------------    Constructeur     ---------------------------//
	public Mission(String contenu,int idMission) {
		super();
		this.contenu = contenu;
		this.idMission = idMission;
	}

	//----------------------    Getters et Setters     ---------------------------//
	public String getContenu() {
		return contenu;
	}
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	
	//----------------------    Fonctions     ---------------------------//
	public static void attributionMissions()
	{
		// Définition des différentes missions 
		Mission mission1 = new Mission("Contrôler 3 régions et au moins 18 territoires",1);
		Mission mission2 = new Mission("Contrôler la plus grosse région + 1 autre région",2);
		Mission mission3 = new Mission("Conquérir tous les territoires",3);
		Mission mission4 = new Mission("Contrôler 30 territoires",4);
		Mission mission5 = new Mission("Contrôler 18 territoires avec au moins 2 armées",5);
		int nbrJoueur = RiskIsep.MenuJoueur(); // nombre de joueurs sur la partie actuelle 
		if (nbrJoueur != 0)
		{
		Random x = new Random(); 
		int xAlea = x.nextInt(nbrJoueur) + 1; // choix du numéro du joueur à détuire pour la mission 6
		Mission mission6 = new Mission("Détruire le joueur" + xAlea,6);
		}
		Mission mission7 = new Mission("Contrôler 24 territoires",7);
		Mission mission8 = new Mission("Contrôler 21 territoires",8);		
		
		
		//Attribution des missions selon le nombre de joueurs 
		if ( nbrJoueur == 1) // s'il y a 1 joueur on peut attribuer les missions 1 et 2 (une pour le joueur l'autre pour l'IA)
		{
			Random j1 = new Random(); 
			int j1Alea = j1.nextInt(2) + 1; // création d'un nombre aléatoire entre 1 et 2 
			Joueur.joueur1.idMission = j1Alea;
			System.out.println("Mission du joueur1: " + Joueur.joueur1.idMission);
		}
		
		if (nbrJoueur == 2) // s'il y a 2 joueurs on peut attribuer les missions 1 2 3 et 4 
		{
			Random j1 = new Random(); 
			int j1Alea = j1.nextInt(4) + 1; // création d'un nombre aléatoire entre 1 et 4 
			Random j2 = new Random() ;
			int j2Alea = j2.nextInt(4) + 1;
			Joueur.joueur1.idMission = j1Alea ;
			Joueur.joueur2.idMission = j2Alea ;
			System.out.println("Mission du joueur1: " + Joueur.joueur1.idMission  );
			System.out.println("Mission du joueur2: " + Joueur.joueur2.idMission  );
		}
		
		if (nbrJoueur == 3) // s'il y a 3 joueurs on peut attribuer les missions 1 2 3 4 5 et 6
		{
			Random j1 = new Random(); 
			int j1Alea = j1.nextInt(6) + 1;
			Random j2 = new Random() ;
			int j2Alea = j2.nextInt(6) + 1;
			Random j3 = new Random() ;
			int j3Alea = j3.nextInt(6) + 1;
			Joueur.joueur1.idMission = j1Alea ;
			Joueur.joueur2.idMission = j2Alea ;
			Joueur.joueur3.idMission = j3Alea ;
			System.out.println("Mission du joueur1: " + Joueur.joueur1.idMission  );
			System.out.println("Mission du joueur2: " + Joueur.joueur2.idMission  );
			System.out.println("Mission du joueur3: " + Joueur.joueur3.idMission  );
		}
		
		if (nbrJoueur == 4 | nbrJoueur == 5) // s'il y a 4 ou 5 joueurs on peut attribuer les missions 1 2 5 6 et 7
		{
			int[] tabl = {1, 2, 5, 6, 7};
			
			Random j1 = new Random(); 
			int j1Alea = j1.nextInt(5);
			j1Alea = tabl[j1Alea];
			
			Random j2 = new Random() ;
			int j2Alea = j2.nextInt(5);
			j2Alea = tabl[j2Alea];
			
			Random j3 = new Random() ;
			int j3Alea = j3.nextInt(5);
			j3Alea = tabl[j3Alea];
			
			Random j4 = new Random() ;
			int j4Alea = j4.nextInt(5);
			j4Alea = tabl[j4Alea];
			
			
			Joueur.joueur1.idMission = j1Alea ;
			Joueur.joueur2.idMission = j2Alea ;
			Joueur.joueur3.idMission = j3Alea ;
			Joueur.joueur4.idMission = j4Alea ;
			System.out.println("Mission du joueur1: " + Joueur.joueur1.idMission  );
			System.out.println("Mission du joueur2: " + Joueur.joueur2.idMission  );
			System.out.println("Mission du joueur3: " + Joueur.joueur3.idMission  );
			System.out.println("Mission du joueur4: " + Joueur.joueur4.idMission  );
			
			if(nbrJoueur == 5) // s'il y a 5 joueurs on peut attribuer les missions 1 2 5 6 et 7
			{
				Random j5 = new Random() ;
				int j5Alea = j5.nextInt(5);
				j5Alea = tabl[j5Alea];
				
				Joueur.joueur5.idMission = j5Alea ;
				System.out.println("Mission du joueur5: " + Joueur.joueur5.idMission  );
			}
		}
		
		if(nbrJoueur == 6) // s'il y a 6 joueurs on peut attribuer les missions 1 2 5 6 et 8
		{
			int[] tabl = {1, 2, 5, 6, 8};
			
			Random j1 = new Random(); 
			int j1Alea = j1.nextInt(5);
			j1Alea = tabl[j1Alea];
			
			Random j2 = new Random() ;
			int j2Alea = j2.nextInt(5);
			j2Alea = tabl[j2Alea];
			
			Random j3 = new Random() ;
			int j3Alea = j3.nextInt(5);
			j3Alea = tabl[j3Alea];
			
			Random j4 = new Random() ;
			int j4Alea = j4.nextInt(5);
			j4Alea = tabl[j4Alea];
			
			Random j5 = new Random() ;
			int j5Alea = j5.nextInt(5);
			j5Alea = tabl[j5Alea];
			
			Random j6 = new Random() ;
			int j6Alea = j6.nextInt(5);
			j6Alea = tabl[j6Alea];
			
			Joueur.joueur1.idMission = j1Alea ;
			Joueur.joueur2.idMission = j2Alea ;
			Joueur.joueur3.idMission = j3Alea ;
			Joueur.joueur4.idMission = j4Alea ;
			Joueur.joueur5.idMission = j5Alea ;
			Joueur.joueur6.idMission = j6Alea ;
			System.out.println("Mission du joueur1: " + Joueur.joueur1.idMission  );
			System.out.println("Mission du joueur2: " + Joueur.joueur2.idMission  );
			System.out.println("Mission du joueur3: " + Joueur.joueur3.idMission  );
			System.out.println("Mission du joueur4: " + Joueur.joueur4.idMission  );
			System.out.println("Mission du joueur5: " + Joueur.joueur5.idMission  );
			System.out.println("Mission du joueur6: " + Joueur.joueur6.idMission  );
			
		}
	}

	
}
