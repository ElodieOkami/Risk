import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//Class permettant les �tapes d'initialisation c�d la cr�ations des objets dont on a besoin

public class Initialisation {

	
	public static String initialisationJeu() //Fonction appell�e par le Main
	{
		int nbrJr = 0;
		String cartePng = "nonselectionne";
		
		Plateau.CreaCanvas();
		
		
		while (nbrJr == 0) //S�l�ction du nombre de joueurs
		{
			nbrJr = Interface.MenuJoueur();
			
		}
		
		try {
		    Thread.sleep(150);
		} catch(InterruptedException e) {
		    System.out.println("got interrupted!");
		}
		
		while (cartePng == "nonselectionne")//Choix de la carte
		{		
			cartePng = Interface.MenuCarte();
		}
		
		try {
		    Thread.sleep(150);
		} catch(InterruptedException e) {
		    System.out.println("got interrupted!");
		}
		
		Plateau.affichePlateau(cartePng);
		Initialisation.attributionMissions(nbrJr);
		CreaRegTer(cartePng, nbrJr);
		Initialisation.repartitionUnite(nbrJr);
		
		return cartePng;
		
	}
	
	
	
	//Fonction de cr�ation de Joueurs
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
		//D�finition du contenu des missions et de leur contenu
		String mis1 = "Cont�ler 3 r�gions et au moins 18 territoires";
		String mis2 = "Contr�ler la plus grosse r�gion + 1 autre r�gion";
		String mis3 = "Conqu�rir tous les territoires";
		String mis4 = "Contr�ler 30 territoires";
		String mis5 = "Contr�ler 18 territoires avec au moins 2 arm�es";
		String mis6 = "D�truire le joueur";
		String mis7 = "Contr�ler 24 territoires";
		String mis8 = "Contr�ler 21 territoires";
		
		List<Mission> list = new ArrayList<Mission>();
		
		Mission mission1 = new Mission(mis1,1,0);
		Mission mission2 = new Mission(mis2,2,0);
		Mission mission3 = new Mission(mis3,3,0);
		Mission mission4 = new Mission(mis4,4,0);
		Mission mission5 = new Mission(mis5,5,0);
		Mission mission6 = new Mission(mis6,6,0);
		Mission mission7 = new Mission(mis7,7,0);
		Mission mission8 = new Mission(mis8,8,0);
		
		//On ajoute dans la liste les missions 1 et 2 qui sont disponible quelque soit le nombre de joueurs
		list.add(mission1);
		list.add(mission2);
		
		//On traite les diff�rents cas selon le nombre de joueurs sur la partie
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
	
	//Fonction permettant d'attribuer al�atoirement la mission selon la liste des missions disponibles et le nombre de joueurs
	public static void missionAlea (List<Mission> list, int nbrJr)
	{
		int l = list.size(); //Nombre de missions disponibles
		for (int i=1; i<= nbrJr; i++) //Tant que tous les joueurs non pas eu leur mission
		{
			Random x = new Random();
			int xAlea = x.nextInt(l) ;
			Mission mission = list.get(xAlea);
			
			if(mission.contenu != "D�truire le joueur")
			{
				System.out.println("Mission joueur "+i+" : "+mission.contenu);
			}
			
			else  if (mission.contenu == "D�truire le joueur") // Si la mission est "d�truire le joueur" on doit choisir le num�ro du joueur � d�truir
			{
				Random r = new Random();
				int j = r.nextInt(nbrJr)+1;
				while (j==i)   //Cela ne peut pas �tre le joueur lui-m�me
				{
					r = new Random();
					j = r.nextInt(nbrJr)+1;
				}
				System.out.println("Mission joueur "+i+" : "+mission.contenu +j);
			}
				
		}
	}
	
	
	//Etape 2 : Cr�ation et Attributions des r�gions et territoires
	public static int creationRegions(String cartePng, int nbrJr)			//Cr�e les R�gions ainsi que les territoires
	{
		int id = 0;								//id d'un unique territoire
		
		ArrayList <Integer> JrFull = new ArrayList<Integer>();				//On cr�� une liste du nombre de territoire qu'a chaque joueur lors de l'attribution al�atoire
		for (int i=0; i<nbrJr; i++)
		{
			JrFull.add(0);													//Cette liste est initialement vide
		}
		
		ArrayList <Integer> Joueur = new ArrayList<Integer>();				//On cr�� une liste de "l'id" de chaque joueur
		for (int i=0; i<nbrJr; i++)
		{
			Joueur.add(i+1);													//Cette liste va de 1 au nombre de joueur
		}
		//System.out.println("Nombre de joueurs: " + Joueur.get(nbrJr-1));
		
		if (cartePng == "plateauElder.png")		//Si on utilise la carte TES
		{
			
			Region provincesImperiales = new Region("provincesImperiales", 11);			//On cr�� la r�gion a l'aide du constructeur
			id = creaEtAttribTerritoires(provincesImperiales, id, nbrJr, Joueur, JrFull);	//On cr�� chaque territoire des r�gions et on les r�partis al�atoirement parmi les joueurs.
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
	
	
	public static int creaEtAttribTerritoires(Region region, int id, int nbrJr, ArrayList <Integer> Joueur, ArrayList <Integer> JrFull)		//Cr�ation des territoires de chaque r�gion et r�partion al�atoire parmi les joueurs
	{
		int terParJr=(int)(42/nbrJr);		//Nombre de territoire arrondi que se verra attribu� chaque joueur
		
		
		
		for (int i=1; i<region.getTaille()+1; i++)
		{
			ajouterTerritoires(i, id);		//On ajoute le territoire dans l'arraylist territoires de cette r�gion
			id++;							//Le prochain territoire poss�de l'id suivant
			
			int j = (int)(Math.random()*(nbrJr-(nbrJr-Joueur.size()))+1);	//Nombre al�atoire entre 1 et le nbr de joueur pas encore full	
			Region.listeTerritoires.get(i-1).setProprietaire(Joueur.get(j-1));		//On attribue le territoire � un joueur
			
			//System.out.println(Region.getNom()+Territoire.getNumero() + " Id : " +Region.listeTerritoires.get(i-1).getId() + " et Propri : " +Territoire.getProprietaire());
			
			JrFull.set(j-1, (1+JrFull.get(j-1)));	//On augmente la quantit� de territoire que poss�de le joueur
			if (JrFull.get(j-1)==terParJr)			//Si le joueur poss�de le nombre max de territoires
			{
				Joueur.remove(j-1);					//On supprime ce joueur des candidats
				JrFull.remove(j-1);
				if (Joueur.isEmpty())				//Si on a plus aucun candidat
				{
					
					for (int z=0; z<nbrJr; z++)		//Jusqu'� ce qu'on atteigne le nombre total de joueurs
					{
						Joueur.add(z, z+1);			//On recr�� chaque candidat
						JrFull.add(z, terParJr-1); 	//On recr�� un d'espace pour chaque candidat
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
		int idMax = creationRegions(cartePng, nbrJr);			//Cr�e les R�gions ainsi que les territoires
	}
	
	
		//Etape 3 : R�partition d'un nombre de soldats pour chaque joueur
		public static void repartitionUnite(int nbrJr)
		{
			int[] listePuissanceSoldat = {1,2,3,4,5,6};
			switch(nbrJr) //On g�re les diff�rents cas
			{
			case 1 :
				for(int i = 0; i < 40; i++)
				{
					Joueur.listeUnite.add(new Soldat(1, listePuissanceSoldat, 2, 1, 2, "Soldat"));
				}
				System.out.println("Le joueur et l'IA ont re�u 40 soldats");
				break;
			case 2 :
				for(int i = 0; i < 40; i++)
				{
					Joueur.listeUnite.add(new Soldat(1, listePuissanceSoldat, 2, 1, 2, "Soldat"));
				}
				System.out.println("Les deux joueurs ont re�u 40 soldats");
				break;
			case 3 :
				for(int i = 0; i < 35; i++)
				{
					Joueur.listeUnite.add(new Soldat(1, listePuissanceSoldat, 2, 1, 2, "Soldat"));
				}
				System.out.println("Les trois joueurs ont re�u 35 soldats");
				break;
			case 4 :
				for(int i = 0; i < 30; i++)
				{
					Joueur.listeUnite.add(new Soldat(1, listePuissanceSoldat, 2, 1, 2, "Soldat"));
				}
				System.out.println("Les quatre joueurs ont re�u 30 soldats");
				break;
			case 5 :
				for(int i = 0; i < 25; i++)
				{
					Joueur.listeUnite.add(new Soldat(1, listePuissanceSoldat, 2, 1, 2, "Soldat"));
				}
				System.out.println("Les cinq joueurs ont re�u 25 soldats");
				break;
			case 6 :
				for(int i = 0; i < 20; i++)
				{
					Joueur.listeUnite.add(new Soldat(1, listePuissanceSoldat, 2, 1, 2, "Soldat"));
				}
				System.out.println("Les six joueurs ont re�u 20 soldats");
				break;
			}
		}
		

		
}