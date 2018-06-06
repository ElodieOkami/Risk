import java.awt.Color;
import java.util.ArrayList;

import edu.princeton.cs.introcs.StdDraw;

public class RiskIsep {
	
	public static ArrayList <Region> listeRegions=new ArrayList<Region>();		//On créé ces listes en static pour pouvoir les réutiliser dans toute la classe
	public static ArrayList <Joueur> listeJoueurs=new ArrayList<Joueur>();
	
	public static void main(String[] args)
	{
		//- - - - - - -Initialisation- - - - - - -//
		int nbrJr = Initialisation.initialisationJoueur();			//nbrJr est le nombre de joueurs dans la partie
		String cartePng = Initialisation.initialisationJeu(nbrJr);	//cartePng est soit la carte "plateauElder.png"(tamriel) soit "plateauTerre.png"(Terre)
		
		//- - - - - - - - - Jeu - - - - - - - - -//
		Jeu.partieDeRisk(nbrJr);			//Début du vrai jeu
	}
	
		
	
	public static void creationRegions(String cartePng, int nbrJr, int idTerritoire)			//Crée les Régions ainsi que les territoires
	{
		
		ArrayList <Integer> JrFull = new ArrayList<Integer>();				//On créé une liste du nombre de territoire qu'a chaque joueur lors de l'attribution aléatoire
		for (int i=0; i<nbrJr; i++)
		{
			JrFull.add(0);													//Cette liste est initialement vide
		}
		
		ArrayList <Integer> listIdJoueur = new ArrayList<Integer>();				//On créé une liste de "l'id" de chaque joueur
		for (int i=0; i<nbrJr; i++)
		{
			listIdJoueur.add(i+1);													//Cette liste va de 1 au nombre de joueur
		}
		
		if (cartePng == "plateauElder.png")		//Si on utilise la carte TES
		{
			
			Region provincesImperiales = new Region("provincesImperiales", 11);			//On créé la région a l'aide du constructeur
			provincesImperiales.creaEtAttribTerritoires(idTerritoire, nbrJr, listIdJoueur, JrFull);	//On créé chaque territoire des régions et on les répartis aléatoirement parmi les joueurs.
			idTerritoire += provincesImperiales.getTaille()-1;								//On incrémente l'id du nombre de Territoires dans la région précédente
			listeRegions.add(provincesImperiales);											//On ajoute cette région à la liste des régions
			
			Region lenclume = new Region("lenclume", 5);
			lenclume.creaEtAttribTerritoires(idTerritoire, nbrJr, listIdJoueur, JrFull);
			idTerritoire += lenclume.getTaille();
			listeRegions.add(lenclume);
			
			Region cyrodiil = new Region("cyrodiil", 8);
			cyrodiil.creaEtAttribTerritoires(idTerritoire, nbrJr, listIdJoueur, JrFull);
			idTerritoire += cyrodiil.getTaille();
			listeRegions.add(cyrodiil);
			
			Region archipelAutomne = new Region("archipelAutomne", 3);
			archipelAutomne.creaEtAttribTerritoires(idTerritoire, nbrJr, listIdJoueur, JrFull);
			idTerritoire += archipelAutomne.getTaille();
			listeRegions.add(archipelAutomne);
			
			Region aldmeri = new Region("aldmeri", 5);
			aldmeri.creaEtAttribTerritoires(idTerritoire, nbrJr, listIdJoueur, JrFull);
			idTerritoire += aldmeri.getTaille();
			listeRegions.add(aldmeri);
			
			Region argonie = new Region("argonie", 10);
			argonie.creaEtAttribTerritoires(idTerritoire, nbrJr, listIdJoueur, JrFull);
			idTerritoire += argonie.getTaille();
			listeRegions.add(argonie);
		}
		
		else if (cartePng == "plateauTerre.png")
		{
			Region northAmerica = new Region("northAmerica",9);
			northAmerica.creaEtAttribTerritoires(idTerritoire, nbrJr, listIdJoueur, JrFull);
			idTerritoire += northAmerica.getTaille();
			listeRegions.add(northAmerica);
			
			Region southAmerica = new Region("southAmerica",4);
			southAmerica.creaEtAttribTerritoires(idTerritoire, nbrJr, listIdJoueur, JrFull);
			idTerritoire += southAmerica.getTaille();
			listeRegions.add(southAmerica);
			
			Region europe = new Region("europe",7);
			europe.creaEtAttribTerritoires(idTerritoire, nbrJr, listIdJoueur, JrFull);
			idTerritoire += europe.getTaille();
			listeRegions.add(europe);
			
			Region africa = new Region("africa",6);
			africa.creaEtAttribTerritoires(idTerritoire, nbrJr, listIdJoueur, JrFull);
			idTerritoire += africa.getTaille();
			listeRegions.add(africa);
			
			Region asia = new Region("asia",12);
			asia.creaEtAttribTerritoires(idTerritoire, nbrJr, listIdJoueur, JrFull);
			idTerritoire += asia.getTaille();
			listeRegions.add(asia);
			
			Region australia = new Region("australia",4);
			australia.creaEtAttribTerritoires(idTerritoire, nbrJr, listIdJoueur, JrFull);
			idTerritoire += australia.getTaille();
			listeRegions.add(australia);
		}
	}
	
	public static void creaJoueur(int nbrJr)
	{
			Joueur joueur1 = new Joueur (1,"joueur"+1, Color.BLUE);		//On créé un objet joueur
			joueur1.repartitionUnite(nbrJr);							//On lui donne un certain nombre de soldat
			joueur1.rempliListTerrJoueur();								//On remplit la liste des territoires que possède le joueur
			listeJoueurs.add(joueur1);									//On ajoute ce joueur à la liste Joueur
			Joueur joueur2 = new Joueur (2,"joueur"+2, Color.RED);
			joueur2.repartitionUnite(nbrJr);
			joueur2.rempliListTerrJoueur();
			listeJoueurs.add(joueur2);
			
			if(nbrJr >=3)
			{
				Joueur joueur3 = new Joueur (3,"joueur"+3, Color.GREEN);
				joueur3.repartitionUnite(nbrJr);
				joueur3.rempliListTerrJoueur();
				listeJoueurs.add(joueur3);
				if(nbrJr >= 4)
				{
					Joueur joueur4 = new Joueur (4,"joueur"+4, Color.YELLOW);
					joueur4.repartitionUnite(nbrJr);
					joueur4.rempliListTerrJoueur();
					listeJoueurs.add(joueur4);
					if(nbrJr >=5)
					{
						Joueur joueur5 = new Joueur (5,"joueur"+5, Color.CYAN);
						joueur5.repartitionUnite(nbrJr);
						joueur5.rempliListTerrJoueur();
						listeJoueurs.add(joueur5);
						if(nbrJr == 6)
						{
							Joueur joueur6 = new Joueur (6,"joueur"+6, Color.MAGENTA);
							joueur6.repartitionUnite(nbrJr);
							joueur6.rempliListTerrJoueur();
							listeJoueurs.add(joueur6);
						}
					}
				}
			}
	}
	
	public static Region getRegion(int i)		//Permet d'avoir accès aux infos de la listeRegion depuis toutes les classes
	{
		return listeRegions.get(i);
	}
	
	public static void PossesseurTerris(String cartePng)		//Initialise l'affichage des points de couleur sur la carte
	{
		int idTerr = 0;
		if (cartePng == "plateauElder.png")
		{
			for (int i=0; i<6; i++)		//Pour chaque région
			{	
				idTerr = listeRegions.get(i).getPossesseurDsRegion(idTerr);		//On appelle la f° dans Region
				StdDraw.show();
			}
		}
	}
	
	public static Color getCouleurPropri(int numPropri)			//Ressort la couleur d'un joueur dans toutes les classes
	{
		return listeJoueurs.get(numPropri-1).getCouleur();
	}
	
	
	
	public static void placementUniteIni(int nbrJr, String cartePng)	//Placement des soldats reçus au début
	{
		int numeroJoueur;	//Numéro du joueur (idJoueur+1)
		int soldatsRestants;	//Soldats restants à placer
		for (int i=0; i<nbrJr; i++)		//Pour chaque joueur
		{
			numeroJoueur=i+1;
			
			int idTerri = -1;
			int idSoldat=0;		//id du soldat parmis la liste des soldats du Joueur
			int nbrSoldats = listeJoueurs.get(i).getListeUnite().size();	//Nombre de soldats que possède le joueur
			
			idSoldat = listeJoueurs.get(i).placeSoldatParDefault(idSoldat);	//Place un soldat par territoire du joueur
			System.out.println("Par respect des règles, on place automatiquement un de vos soldats sur chacun de vos territoires : ");
			for (int j=0; j<idSoldat; j++)
			{
				System.out.println("Soldat placé en "+ listeJoueurs.get(i).getListeUnite().get(j).getIdPosition());
			}
			soldatsRestants=nbrSoldats-idSoldat;	//Nombre de soldats restant à placer après le placement automatique
			System.out.println("Joueur"+numeroJoueur+ "(" + listeJoueurs.get(i).getCouleur()+"), c'est à vous de placer vos "+soldatsRestants+ " soldats");
			
			while (listeJoueurs.get(i).getListeUnite().get(nbrSoldats-1).getIdPosition() == -1)		//Tant que le dernier soldat du soldat n'a pas été placé
			{
				while(idTerri == -1)		//Tant que aucun territoire n'a été cliqué
				{
					idTerri=Interface.lectureClic(cartePng);		//On regarde ou clic le joueur
					if (idTerri != -1 && regionClicked(idTerri).listeTerritoires.get(Territoire.territoireDsRegion(idTerri)).getProprietaire() != listeJoueurs.get(i).getIdJoueur()) //Si on a cliqué sur un territoire mais que ce territoire n'appartient pas au joueur
					{
						System.out.println("Veuillez cliquer sur un de vos territoires");
						idTerri = -1;
					}
				}
				regionClicked(idTerri).listeTerritoires.get(Territoire.territoireDsRegion(idTerri)).setNbrSoldat(regionClicked(idTerri).listeTerritoires.get(Territoire.territoireDsRegion(idTerri)).getNbrSoldat()+1);	//Le territoire qui a été cliqué gagne un soldat supplémentaire
				listeJoueurs.get(i).getListeUnite().get(idSoldat).setIdPosition(idTerri); 	//On dit sur quel territoire le soldat a été placé
				soldatsRestants=nbrSoldats-(idSoldat+1);
				System.out.println("Soldat placé sur le territoire " +regionClicked(idTerri).listeTerritoires.get(Territoire.territoireDsRegion(idTerri)).getId()+". Plus que "+soldatsRestants+" soldats à placer");
				idTerri = -1; //On remet le territoire cliqué à -1 pour recommencer la boucle while
				idSoldat++; //On passe au soldat suivant
			}
		}
	}
	
	public static Region regionClicked(int idTerri)
	{
		if (idTerri<11)
		{
			return listeRegions.get(0);					
		}
		else if (idTerri <16)
		{
			return listeRegions.get(1);
		}
		else if (idTerri <24)
		{
			return listeRegions.get(2);
		}
		else if (idTerri < 27)
		{
			return listeRegions.get(3);
		}
		else if (idTerri < 32)
		{
			return listeRegions.get(4);
		}
		else
		{
			return listeRegions.get(5);
		}
	}
	
	public static int allRegionPoss(int nbrJr)		//Vérifie si un des joueurs possède tous les territoires du jeu
	{
		for (int i=0; i<nbrJr; i++)				//Pour chaque joueur
		{
			if (listeJoueurs.get(i).getListeTerrPoss().size() == 42)	//Si un joueur possède tous les territoires
			{
				System.out.println("Victoire du Joueur "+i+1);
				return i;
			}
		}
		return -1;
	}
	
	public static int appelFonctionRenforts(int idJoueur) //Appelle la fonction renforts dans Joueur
	{
		int renforts = listeJoueurs.get(idJoueur).receptionRenforts();
		return renforts;
	}
	
	public static void choixUniteEtPlacerRenforts(int renforts, int idJoueur, String cartePng)
	{
		String typeUnite;
		int renfEntreIf;
		int idTerri;
		while (renforts >0)
		{
			typeUnite="Soldat";		//Appeler fonction clique bouton maya qui ressort soit "soldat", "cavalier", "canon" ou "sélectionnez une unité à placer avant de séléctionner un territoire"
			renfEntreIf =renforts;
			if (typeUnite == "soldat")
			{
				while (renfEntreIf == renforts)
				{
					idTerri = Interface.lectureClic(cartePng);
					listeJoueurs.get(idJoueur).ajouterRenfortJoueur(typeUnite, idTerri);
					regionClicked(idTerri).ajouterRenfortRegion(typeUnite,idTerri);
					renforts--;
				}
			}
			else if (typeUnite == "cavalier" && renforts>=3)
			{
				while (renfEntreIf == renforts)
				{
					idTerri = Interface.lectureClic(cartePng);
					listeJoueurs.get(idJoueur).ajouterRenfortJoueur(typeUnite, idTerri);
					regionClicked(idTerri).ajouterRenfortRegion(typeUnite,idTerri);
					renforts -= 3;
				}
			}
			else if (typeUnite =="canon" && renforts>=7)
			{
				while (renfEntreIf == renforts)
				{
					idTerri = Interface.lectureClic(cartePng);
					listeJoueurs.get(idJoueur).ajouterRenfortJoueur(typeUnite, idTerri);
					regionClicked(idTerri).ajouterRenfortRegion(typeUnite,idTerri);
					renforts -= 7;
				}
			}
			
		}
	}
	

}
