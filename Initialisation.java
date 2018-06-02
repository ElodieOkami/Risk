import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//Class permettant les étapes d'initialisation càd la créations des objets dont on a besoin

public class Initialisation {

	
	//Fonction de création de Joueurs
	public static void creaJoueur(int nbrJr)
	{
		ArrayList<Unite> listeUnite = new ArrayList <Unite>();
		Color[] list = { Color.BLUE, Color.RED, Color.GREEN, Color.PINK, Color.YELLOW, Color.BLACK};
		
		for (int i = 0; i <= nbrJr-1 ; i++)
		{
			Joueur joueur = new Joueur (i+1, listeUnite ,"joueur" + i+1, list[i]);
		}
	}
	
	
	//Etape 1 : Attribution des missions
	public static void attributionMissions(int nbrJr)
	{
		//Définition du contenu des missions
		String mission1 = "Contôler 3 régions et au moins 18 territoires";
		String mission2 = "Contrôler la plus grosse région + 1 autre région";
		String mission3 = "Conquérir tous les territoires";
		String mission4 = "Contrôler 30 territoires";
		String mission5 = "Contrôler 18 territoires avec au moins 2 armées";
		String mission6 = "Détruire le joueur";
		String mission7 = "Contrôler 24 territoires";
		String mission8 = "contrôler 21 territoires";
		List<String> list = new ArrayList<String>();
		
		//On ajoute dans la liste les missions 1 et 2 qui sont disponible quelque soit le nombre de joueurs
		list.add(mission1);
		list.add(mission2);
		
		//On traite les différents cas selon le nombre de joueurs sur la partie
		if (nbrJr ==1)
		{
			missionAlea(list, nbrJr);
		}
		
		if (nbrJr == 2)
		{
			list.add(mission3);
			list.add(mission4);
			missionAlea(list, nbrJr);
		}
			
		if (nbrJr == 3)
		{
			list.add(mission3);
			list.add(mission4);
			list.add(mission5);
			list.add(mission6);
			missionAlea(list, nbrJr);
		}	
		
		if(nbrJr == 4)
		{
			list.add(mission5);
			list.add(mission6);
			list.add(mission7);
			missionAlea(list, nbrJr);
		}
			
		if (nbrJr == 5)
		{
			list.add(mission5);
			list.add(mission6);
			list.add(mission7);
			missionAlea(list, nbrJr);
		}
			
		if (nbrJr == 6)
		{
			list.add(mission5);
			list.add(mission6);
			list.add(mission8);
			missionAlea(list, nbrJr);	
		}
	}
	
	//Fonction permettant d'attribuer aléatoirement la mission selon la liste des missions disponibles et le nombre de joueurs
	public static void missionAlea (List<String> list, int nbrJr)
	{
		int l = list.size(); //Nombre de missions disponibles
		for (int i=1; i<= nbrJr; i++) //Tant que tous les joueurs non pas eu leur mission
		{
			Random x = new Random();
			int xAlea = x.nextInt(l - 1) + 1;
			String mission = list.get(xAlea);
			if (mission == "Détruire le joueur") // Si la mission est "détruire le joueur" on doit choisir le numéro du joueur à détruir
			{
				Random r = new Random();
				int j = r.nextInt(nbrJr - 2) + 1;
				while (j==i)  //Cela ne peut pas être le joueur lui-même
				{
					r = new Random();
					j = r.nextInt(nbrJr - 2) + 1;
				}
				mission = "Détruire le joueur "+j;
			}
			System.out.println("Mission joueur "+i+" : "+mission);
			
		}
	}
	
	
	//Etape 2 : Création et Attributions des régions et territoires
	public static int creationRegions(String cartePng, int nbrJr)			//Crée les Régions ainsi que les territoires
	{
		int id = 0;								//id d'un unique territoire
		
		ArrayList <Integer> JrFull = new ArrayList<Integer>();				//On créé une liste du nombre de territoire qu'a chaque joueur lors de l'attribution aléatoire
		for (int i=0; i<nbrJr; i++)
		{
			JrFull.add(0);													//Cette liste est initialement vide
		}
		
		ArrayList <Integer> Joueur = new ArrayList<Integer>();				//On créé une liste de "l'id" de chaque joueur
		for (int i=0; i<nbrJr; i++)
		{
			Joueur.add(i+1);													//Cette liste va de 1 au nombre de joueur
		}
		System.out.println("Nombre de joueurs: " + Joueur.get(nbrJr-1));
		
		if (cartePng == "plateauElder.png")		//Si on utilise la carte TES
		{
			
			Region provincesImperiales = new Region("provincesImperiales", 11);			//On créé la région a l'aide du constructeur
			id = creaEtAttribTerritoires(provincesImperiales, id, nbrJr, Joueur, JrFull);	//On créé chaque territoire des régions et on les répartis aléatoirement parmi les joueurs.
			Region lenclume = new Region("lenclume", 5);
			id = creaEtAttribTerritoires(lenclume, id, nbrJr, Joueur, JrFull);
			Region cyrodiil = new Region("cyrodiil", 8);
			id = creaEtAttribTerritoires(cyrodiil, id, nbrJr, Joueur, JrFull);
			Region archipelAutomne = new Region("archipelAutomne", 3);
			id = creaEtAttribTerritoires(archipelAutomne, id, nbrJr, Joueur, JrFull);
			Region aldmeri = new Region("aldmeri", 5);
			id = creaEtAttribTerritoires(aldmeri, id, nbrJr, Joueur, JrFull);
			Region argonie = new Region("argonie", 10);
			id = creaEtAttribTerritoires(argonie, id, nbrJr, Joueur, JrFull);
		}
		
		else if (cartePng == "plateauTerre.png")
		{
			Region northAmerica = new Region("northAmerica",9);
			id = creaEtAttribTerritoires(northAmerica, id, nbrJr, Joueur, JrFull);
			Region southAmerica = new Region("southAmerica",4);
			id = creaEtAttribTerritoires(southAmerica, id, nbrJr, Joueur, JrFull);
			Region europe = new Region("europe",7);
			id = creaEtAttribTerritoires(europe, id, nbrJr, Joueur, JrFull);
			Region africa = new Region("africa",6);
			id = creaEtAttribTerritoires(africa, id, nbrJr, Joueur, JrFull);
			Region asia = new Region("asia",12);
			id = creaEtAttribTerritoires(asia, id, nbrJr, Joueur, JrFull);
			Region australia = new Region("australia",4);
			id = creaEtAttribTerritoires(australia, id, nbrJr, Joueur, JrFull);
		}
		return id;
	}
	
	private static void ajouterTerritoires(int numero, int id)			//Ajoute un territoire dans l'arryalist territoires
	{
		Territoire territoire = new Territoire(numero, id);
		Region.listeTerritoires.add(territoire);
	}
	
	
	public static int creaEtAttribTerritoires(Region region, int id, int nbrJr, ArrayList <Integer> Joueur, ArrayList <Integer> JrFull)		//Création des territoires de chaque région et répartion aléatoire parmi les joueurs
	{
		int terParJr=(int)(42/nbrJr);		//Nombre de territoire arrondi que se verra attribué chaque joueur
		
		
		
		for (int i=1; i<region.getTaille()+1; i++)
		{
			ajouterTerritoires(i, id);		//On ajoute le territoire dans l'arraylist territoires de cette région
			id++;							//Le prochain territoire possède l'id suivant
			
			int j = (int)(Math.random()*(nbrJr-(nbrJr-Joueur.size()))+1);	//Nombre aléatoire entre 1 et le nbr de joueur pas encore full	
			Region.listeTerritoires.get(i-1).setProprietaire(Joueur.get(j-1));		//On attribue le territoire à un joueur
			System.out.println(Region.getNom()+Region.listeTerritoires.get(i-1).getNumero() + " Id : " +Region.listeTerritoires.get(i-1).getId() + " et Propri : " +Region.listeTerritoires.get(i-1).getProprietaire());
			
			JrFull.set(j-1, (1+JrFull.get(j-1)));	//On augmente la quantité de territoire que possède le joueur
			if (JrFull.get(j-1)==terParJr)			//Si le joueur possède le nombre max de territoires
			{
				Joueur.remove(j-1);					//On supprime ce joueur des candidats
				if (Joueur.isEmpty())				//Si on a plus aucun candidat
				{
					for (int z=0; z<42-id; z++)		//Jusqu'à ce qu'on atteigne le nombre total de territoires
					{
						JrFull.set(z, JrFull.get(z)-1); //On recrée de l'espace pour les candidats par ordre croissant  
					}
				}
			}
			//System.out.println(Joueur.get(j-1));
		}
		return id;
		
	}
	
	public static void CreaRegTer(String cartePng, int nbrJr)
	{
		Plateau.affichePlateau(cartePng);					//Affiche l'image du plateau de jeu
		int idMax = creationRegions(cartePng, nbrJr);			//Crée les Régions ainsi que les territoires
	}
	
	
		//Etape 3 : Répartition d'un nombre de soldats pour chaque joueur
		public static void repartitionUnite(int nbrJr)
		{
			int[] listePuissanceSoldat = {1,2,3,4,5,6};
			switch(nbrJr) //On gère les différents cas
			{
			case 1 :
				for(int i = 0; i < 40; i++)
				{
					Joueur.listeUnite.add(new Soldat(1, listePuissanceSoldat, 2, 1, 2, "Soldat"));
				}
				System.out.println("Le joueur et l'IA ont reçu 40 soldats");
				break;
			case 2 :
				for(int i = 0; i < 40; i++)
				{
					Joueur.listeUnite.add(new Soldat(1, listePuissanceSoldat, 2, 1, 2, "Soldat"));
				}
				System.out.println("Les deux joueurs ont reçu 40 soldats");
				break;
			case 3 :
				for(int i = 0; i < 35; i++)
				{
					Joueur.listeUnite.add(new Soldat(1, listePuissanceSoldat, 2, 1, 2, "Soldat"));
				}
				System.out.println("Les trois joueurs ont reçu 35 soldats");
				break;
			case 4 :
				for(int i = 0; i < 30; i++)
				{
					Joueur.listeUnite.add(new Soldat(1, listePuissanceSoldat, 2, 1, 2, "Soldat"));
				}
				System.out.println("Les quatre joueurs ont reçu 30 soldats");
				break;
			case 5 :
				for(int i = 0; i < 25; i++)
				{
					Joueur.listeUnite.add(new Soldat(1, listePuissanceSoldat, 2, 1, 2, "Soldat"));
				}
				System.out.println("Les cinq joueurs ont reçu 25 soldats");
				break;
			case 6 :
				for(int i = 0; i < 20; i++)
				{
					Joueur.listeUnite.add(new Soldat(1, listePuissanceSoldat, 2, 1, 2, "Soldat"));
				}
				System.out.println("Les six joueurs ont reçu 20 soldats");
				break;
			}
		}
		

		public static void initialisationJeu()
		{
			int nbrJr = 0;
			String cartePng = "nonselectionne";
			
			Plateau.CreaCanvas();
			
			
			while (nbrJr == 0) //Séléction du nombre de joueurs
			{
				nbrJr = Interface.MenuJoueur();
				
			}

			
			while (cartePng == "nonselectionne")//Choix de la carte
			{		
				cartePng = Interface.MenuCarte();
			}
			
			Plateau.affichePlateau(cartePng);
			Initialisation.attributionMissions(nbrJr);
			CreaRegTer(cartePng, nbrJr);
			Initialisation.repartitionUnite(nbrJr);
		}
}
