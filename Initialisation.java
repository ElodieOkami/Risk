import java.awt.Color;
import java.util.ArrayList;

import edu.princeton.cs.introcs.StdDraw;

//Class permettant les étapes d'initialisation càd la créations des objets dont on a besoin

public class Initialisation {

	static ArrayList <Region> listeRegions=new ArrayList<Region>();
	static ArrayList <Joueur> listeJoueurs=new ArrayList<Joueur>();
	
	
	public static String initialisationJeu() //Fonction appellée par le Main
	{
		int nbrJr = 0;
		String cartePng = "nonselectionne";
		
		Plateau.CreaCanvas();				//Création d'un canvas adapté à la taille de la fenêtre
		
		
		while (nbrJr == 0) 					//Séléction du nombre de joueurs
		{
			nbrJr = Interface.MenuJoueur();
		}
		
		try {
		    Thread.sleep(150);
		} catch(InterruptedException e) {
		    System.out.println("Sommeil interrompu");
		}
		
		while (cartePng == "nonselectionne")//Choix de la carte
		{		
			cartePng = Interface.MenuCarte();
		}
		
		try {
		    Thread.sleep(150);
		} catch(InterruptedException e) {
		    System.out.println("Sommeil interrompu");
		}
		
		Plateau.affichePlateau(cartePng);
		Mission.attributionMissions(nbrJr);
		Initialisation.CreaRegTer(cartePng, nbrJr);
		Initialisation.creaJoueur(nbrJr);
		Initialisation.affichePossesseurTerris(cartePng);
		
		
		return cartePng;
	}
	
	public static void CreaRegTer(String cartePng, int nbrJr)
	{
		int idTerritoire=0;
		creationRegions(cartePng, nbrJr, idTerritoire);			//Crée les Régions ainsi que les territoires
	}
	
	
	public static void creationRegions(String cartePng, int nbrJr, int idTerritoire)			//Crée les Régions ainsi que les territoires
	{
		
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
		//System.out.println("Nombre de joueurs: " + Joueur.get(nbrJr-1));
		
		if (cartePng == "plateauElder.png")		//Si on utilise la carte TES
		{
			
			Region provincesImperiales = new Region("provincesImperiales", 11);			//On créé la région a l'aide du constructeur
			provincesImperiales.creaEtAttribTerritoires(idTerritoire, nbrJr, Joueur, JrFull);	//On créé chaque territoire des régions et on les répartis aléatoirement parmi les joueurs.
			idTerritoire += provincesImperiales.getTaille()-1;								//On incrémente l'id du nombre de Territoires dans la région précédente
			listeRegions.add(provincesImperiales);											//On ajoute cette région à la liste des régions
			
			Region lenclume = new Region("lenclume", 5);
			lenclume.creaEtAttribTerritoires(idTerritoire, nbrJr, Joueur, JrFull);
			idTerritoire += lenclume.getTaille();
			listeRegions.add(lenclume);
			
			Region cyrodiil = new Region("cyrodiil", 8);
			cyrodiil.creaEtAttribTerritoires(idTerritoire, nbrJr, Joueur, JrFull);
			idTerritoire += cyrodiil.getTaille();
			listeRegions.add(cyrodiil);
			
			Region archipelAutomne = new Region("archipelAutomne", 3);
			archipelAutomne.creaEtAttribTerritoires(idTerritoire, nbrJr, Joueur, JrFull);
			idTerritoire += archipelAutomne.getTaille();
			listeRegions.add(archipelAutomne);
			
			Region aldmeri = new Region("aldmeri", 5);
			aldmeri.creaEtAttribTerritoires(idTerritoire, nbrJr, Joueur, JrFull);
			idTerritoire += aldmeri.getTaille();
			listeRegions.add(aldmeri);
			
			Region argonie = new Region("argonie", 10);
			argonie.creaEtAttribTerritoires(idTerritoire, nbrJr, Joueur, JrFull);
			idTerritoire += argonie.getTaille();
			listeRegions.add(argonie);
		}
		
		else if (cartePng == "plateauTerre.png")
		{
			Region northAmerica = new Region("northAmerica",9);
			northAmerica.creaEtAttribTerritoires(idTerritoire, nbrJr, Joueur, JrFull);
			idTerritoire += northAmerica.getTaille();
			listeRegions.add(northAmerica);
			
			Region southAmerica = new Region("southAmerica",4);
			southAmerica.creaEtAttribTerritoires(idTerritoire, nbrJr, Joueur, JrFull);
			idTerritoire += southAmerica.getTaille();
			listeRegions.add(southAmerica);
			
			Region europe = new Region("europe",7);
			europe.creaEtAttribTerritoires(idTerritoire, nbrJr, Joueur, JrFull);
			idTerritoire += europe.getTaille();
			listeRegions.add(europe);
			
			Region africa = new Region("africa",6);
			africa.creaEtAttribTerritoires(idTerritoire, nbrJr, Joueur, JrFull);
			idTerritoire += africa.getTaille();
			listeRegions.add(africa);
			
			Region asia = new Region("asia",12);
			asia.creaEtAttribTerritoires(idTerritoire, nbrJr, Joueur, JrFull);
			idTerritoire += asia.getTaille();
			listeRegions.add(asia);
			
			Region australia = new Region("australia",4);
			australia.creaEtAttribTerritoires(idTerritoire, nbrJr, Joueur, JrFull);
			idTerritoire += australia.getTaille();
			listeRegions.add(australia);
		}
	}
	
	public static void creaJoueur(int nbrJr)
	{
			Joueur joueur1 = new Joueur (1,"joueur"+1, Color.BLUE);		//On créé un objet joueur
			joueur1.repartitionUnite(nbrJr);							//On lui donne un certain nombre de soldat
			listeJoueurs.add(joueur1);									//On ajoute ce joueur à la liste Joueur
			Joueur joueur2 = new Joueur (2,"joueur"+2, Color.RED);
			joueur2.repartitionUnite(nbrJr);
			listeJoueurs.add(joueur2);
			
			if(nbrJr >=3)
			{
				Joueur joueur3 = new Joueur (3,"joueur"+3, Color.GREEN);
				joueur3.repartitionUnite(nbrJr);
				listeJoueurs.add(joueur3);
				if(nbrJr >= 4)
				{
					Joueur joueur4 = new Joueur (4,"joueur"+4, Color.YELLOW);
					joueur4.repartitionUnite(nbrJr);
					listeJoueurs.add(joueur4);
					if(nbrJr >=5)
					{
						Joueur joueur5 = new Joueur (5,"joueur"+5, Color.CYAN);
						joueur5.repartitionUnite(nbrJr);
						listeJoueurs.add(joueur5);
						if(nbrJr == 6)
						{
							Joueur joueur6 = new Joueur (6,"joueur"+6, Color.MAGENTA);
							joueur6.repartitionUnite(nbrJr);
							listeJoueurs.add(joueur6);
						}
					}
				}
			}
	}
	
	public static void affichePossesseurTerris(String cartePng)
	{
		int idTerr = 0;
		if (cartePng == "plateauElder.png")
		{
			for (int i=0; i<6; i++)
			{
				System.out.println();
				idTerr = listeRegions.get(i).getPossesseurDsRegion(idTerr);
				StdDraw.show();
			}
		}
	}
	
	public static Color getCouleurPropri(int numPropri)
	{
		return listeJoueurs.get(numPropri-1).getCouleur();
	}
	
}
