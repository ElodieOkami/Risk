import java.awt.Color;
import java.util.ArrayList;
import java.util.Comparator;

import edu.princeton.cs.introcs.StdDraw;

public class RiskIsep {
	
	public static ArrayList <Region> listeRegions=new ArrayList<Region>();		//On cr�� ces listes en static pour pouvoir les r�utiliser dans toute la classe
	public static ArrayList <Joueur> listeJoueurs=new ArrayList<Joueur>();
	
	public static void main(String[] args)
	{
		//- - - - - - -Initialisation- - - - - - -//
		int nbrJr = Initialisation.initialisationJoueur();			//nbrJr est le nombre de joueurs dans la partie
		String cartePng = Initialisation.initialisationJeu(nbrJr);	//cartePng est soit la carte "plateauElder.png"(tamriel) soit "plateauTerre.png"(Terre)
		
		//- - - - - - - - - Jeu - - - - - - - - -//
		Jeu.partieDeRisk(nbrJr, cartePng);			//D�but du vrai jeu
	}
	
		
	
	public static void creationRegions(String cartePng, int nbrJr, int idTerritoire)			//Cr�e les R�gions ainsi que les territoires
	{
		
		ArrayList <Integer> JrFull = new ArrayList<Integer>();				//On cr�� une liste du nombre de territoire qu'a chaque joueur lors de l'attribution al�atoire
		for (int i=0; i<nbrJr; i++)
		{
			JrFull.add(0);													//Cette liste est initialement vide
		}
		
		ArrayList <Integer> listIdJoueur = new ArrayList<Integer>();				//On cr�� une liste de "l'id" de chaque joueur
		for (int i=0; i<nbrJr; i++)
		{
			listIdJoueur.add(i);													//Cette liste va de 1 au nombre de joueur
		}
		
		if (cartePng == "plateauElder.png")		//Si on utilise la carte TES
		{
			
			Region provincesImperiales = new Region("provincesImperiales", 11);			//On cr�� la r�gion a l'aide du constructeur
			provincesImperiales.creaEtAttribTerritoires(idTerritoire, nbrJr, listIdJoueur, JrFull);	//On cr�� chaque territoire des r�gions et on les r�partis al�atoirement parmi les joueurs.
			idTerritoire += provincesImperiales.getTaille();								//On incr�mente l'id du nombre de Territoires dans la r�gion pr�c�dente
			listeRegions.add(provincesImperiales);											//On ajoute cette r�gion � la liste des r�gions
			
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
			Joueur joueur1 = new Joueur (0,"joueur"+1, Color.BLUE);		//On cr�� un objet joueur
			joueur1.repartitionUnite(nbrJr);							//On lui donne un certain nombre de soldat
			joueur1.rempliListTerrJoueur();								//On remplit la liste des territoires que poss�de le joueur
			listeJoueurs.add(joueur1);									//On ajoute ce joueur � la liste Joueur
			Joueur joueur2 = new Joueur (1,"joueur"+2, Color.RED);
			joueur2.repartitionUnite(nbrJr);
			joueur2.rempliListTerrJoueur();
			listeJoueurs.add(joueur2);
			
			if(nbrJr >=3)
			{
				Joueur joueur3 = new Joueur (2,"joueur"+3, Color.GREEN);
				joueur3.repartitionUnite(nbrJr);
				joueur3.rempliListTerrJoueur();
				listeJoueurs.add(joueur3);
				if(nbrJr >= 4)
				{
					Joueur joueur4 = new Joueur (3,"joueur"+4, Color.YELLOW);
					joueur4.repartitionUnite(nbrJr);
					joueur4.rempliListTerrJoueur();
					listeJoueurs.add(joueur4);
					if(nbrJr >=5)
					{
						Joueur joueur5 = new Joueur (4,"joueur"+5, Color.CYAN);
						joueur5.repartitionUnite(nbrJr);
						joueur5.rempliListTerrJoueur();
						listeJoueurs.add(joueur5);
						if(nbrJr == 6)
						{
							Joueur joueur6 = new Joueur (5,"joueur"+6, Color.MAGENTA);
							joueur6.repartitionUnite(nbrJr);
							joueur6.rempliListTerrJoueur();
							listeJoueurs.add(joueur6);
						}
					}
				}
			}
		//doubleCheckBonneAttriTerr(nbrJr);
	}
	
	public static Region getRegion(int i)		//Permet d'avoir acc�s aux infos de la listeRegion depuis toutes les classes (ATTENTION mais pas de modifier directement la liste)
	{
		return listeRegions.get(i);
	}
	
	public static void PossesseurTerris(String cartePng)		//Initialise l'affichage des points de couleur sur la carte
	{
		int idTerr = 0;
		if (cartePng == "plateauElder.png")
		{
			for (int i=0; i<6; i++)		//Pour chaque r�gion
			{	
				idTerr = listeRegions.get(i).getPossesseurDsRegion(idTerr, cartePng);		//On appelle la f� dans Region
			}
		}
	}
	
	public static Color getCouleurPropri(int idPropri)			//Ressort la couleur d'un joueur dans toutes les classes
	{
		return listeJoueurs.get(idPropri).getCouleur();
	}
	
	
	
	public static void placementUniteIni(int nbrJr, String cartePng)	//Placement des soldats re�us au d�but
	{
		int numeroJoueur;	//Num�ro du joueur (idJoueur+1)
		int soldatsRestants;	//Soldats restants � placer
		for (int i=0; i<nbrJr; i++)		//Pour chaque joueur
		{
			numeroJoueur=i+1;
			
			int idTerri = -1;
			int idSoldat=0;		//id du soldat parmis la liste des soldats du Joueur
			int nbrSoldats = listeJoueurs.get(i).getListeUnite().size();	//Nombre de soldats que poss�de le joueur
			
			idSoldat = listeJoueurs.get(i).placeSoldatParDefault(idSoldat);	//Place un soldat par territoire du joueur
			System.out.println("Par respect des r�gles, on place automatiquement un de vos soldats sur chacun de vos territoires : ");
			for (int j=0; j<idSoldat; j++)
			{
				System.out.println("Soldat plac� en "+ listeJoueurs.get(i).getListeUnite().get(j).getIdPosition());
			}
			soldatsRestants=nbrSoldats-idSoldat;	//Nombre de soldats restant � placer apr�s le placement automatique
			System.out.println("Joueur"+numeroJoueur+ "(" + listeJoueurs.get(i).getCouleur()+"), c'est � vous de placer vos "+soldatsRestants+ " soldats");
			
			while (listeJoueurs.get(i).getListeUnite().get(nbrSoldats-1).getIdPosition() == -1)		//Tant que le dernier soldat du soldat n'a pas �t� plac�
			{
				while(idTerri == -1)		//Tant que aucun territoire n'a �t� cliqu�
				{
					Plateau.afficheInfosArmees(cartePng);
					idTerri=Interface.lectureClic(cartePng);		//On regarde ou clic le joueur
					if (idTerri != -1 && regionClicked(idTerri).getTerritoires().get(Territoire.territoireDsRegion(idTerri)).getProprietaire() != listeJoueurs.get(i).getIdJoueur()) //Si on a cliqu� sur un territoire mais que ce territoire n'appartient pas au joueur
					{
						System.out.println("Veuillez cliquer sur un de vos territoires");
						idTerri = -1;
					}
					Plateau.actualiserTout(cartePng);
					Plateau.afficheInfosJoueurIni(cartePng, numeroJoueur,soldatsRestants);
					//RiskIsep.infosArmees(cartePng);
				}
				regionClicked(idTerri).getTerritoires().get(Territoire.territoireDsRegion(idTerri)).setNbrSoldat(regionClicked(idTerri).getTerritoires().get(Territoire.territoireDsRegion(idTerri)).getNbrSoldat()+1);	//Le territoire qui a �t� cliqu� gagne un soldat suppl�mentaire
				listeJoueurs.get(i).getListeUnite().get(idSoldat).setIdPosition(idTerri); 	//On dit sur quel territoire le soldat a �t� plac�
				soldatsRestants=nbrSoldats-(idSoldat+1);
				System.out.println("Soldat plac� sur le territoire " +regionClicked(idTerri).getTerritoires().get(Territoire.territoireDsRegion(idTerri)).getId()+". Plus que "+soldatsRestants+" soldats � placer");
				idTerri = -1; //On remet le territoire cliqu� � -1 pour recommencer la boucle while
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
	
	public static int[] nbrArmeesTot()
	{
		
		int[] tabNbrArmees = new int[42];
		int idTerr=0;
		for (int i=0 ; i<6 ; i++)
		{
			for (int j=0 ; j< listeRegions.get(i).getTerritoires().size(); j++)
			{
				tabNbrArmees[idTerr]= listeRegions.get(i).getTerritoires().get(j).getNbrSoldat()+listeRegions.get(i).getTerritoires().get(j).getNbrCaval()*3+listeRegions.get(i).getTerritoires().get(j).getNbrCanon()*7;
				idTerr++;
				
			}
		}
			
		return tabNbrArmees;
	}
	
	public static int[] nbrSoldat()
	{
		int[] tabNbrSoldat = new int[42];
		int idTerr=0;
		for (int i=0 ; i<6 ; i++)
		{
			for (int j=0 ; j< listeRegions.get(i).getTerritoires().size(); j++)
			{
				tabNbrSoldat[idTerr]= listeRegions.get(i).getTerritoires().get(j).getNbrSoldat();
				idTerr++;
			}
		}
		return tabNbrSoldat;
	}
	
	public static int[] nbrCavalier()
	{
		int[] tabNbrCavalier = new int[42];
		int idTerr=0;
		for (int i=0 ; i<6 ; i++)
		{
			for (int j=0 ; j< listeRegions.get(i).getTerritoires().size(); j++)
			{
				tabNbrCavalier[idTerr]= listeRegions.get(i).getTerritoires().get(j).getNbrCaval();
				idTerr++;
			}
		}
		return tabNbrCavalier;
	}
	
	public static int[] nbrCanon()
	{
		int[] tabNbrCanon = new int[42];
		int idTerr=0;
		for (int i=0 ; i<6 ; i++)
		{
			for (int j=0 ; j< listeRegions.get(i).getTerritoires().size(); j++)
			{
				tabNbrCanon[idTerr]= listeRegions.get(i).getTerritoires().get(j).getNbrCanon();
				idTerr++;
			}
		}
		return tabNbrCanon;
	}
	
	public static int allRegionPoss(int nbrJr)		//V�rifie si un des joueurs poss�de tous les territoires du jeu
	{
		for (int i=0; i<nbrJr; i++)				//Pour chaque joueur
		{
			if (listeJoueurs.get(i).getListeTerrPoss().size() == 42)	//Si un joueur poss�de tous les territoires
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
		Plateau.actualiserTout(cartePng);
		Plateau.actualiserInfoRenforts(cartePng, idJoueur, renforts);
		Plateau.afficheMessages("choixRenforts", 0);
		while (renforts >0)
		{
			Plateau.actualiserTout(cartePng);
			Plateau.actualiserInfoRenforts(cartePng, idJoueur, renforts);
			StdDraw.show();			
			
			typeUnite=Interface.boutonsUnitesRenfort();		//Appeler fonction clique bouton maya qui ressort soit "soldat", "cavalier", "canon" ou "s�lectionnez une unit� � placer avant de s�l�ctionner un territoire"
			renfEntreIf =renforts;
			//System.out.println("renforts restants pour Joueur"+idJoueur+ " "+ renforts);
			if (typeUnite == "soldat")
			{
				while (renfEntreIf == renforts)
				{
					if (typeUnite == "soldat")
					{
						Plateau.actualiserTout(cartePng);
						Plateau.actualiserInfoRenforts(cartePng, idJoueur, renforts);
						Plateau.afficherBoutonPressed(1);
						Plateau.afficheInfosArmees(cartePng);
						idTerri = Interface.lectureClic(cartePng);
						if (idTerri>=0)
						{
							if (regionClicked(idTerri).getTerritoires().get(Territoire.territoireDsRegion(idTerri)).getProprietaire() == listeJoueurs.get(idJoueur).getIdJoueur())
							{
								listeJoueurs.get(idJoueur).ajouterRenfortJoueur(typeUnite, idTerri);
								regionClicked(idTerri).ajouterRenfortRegion(typeUnite,idTerri);
								renforts= renforts-1;
							}
							else
							{
								System.out.println("Veuillez cliquer sur un de vos territoires");
							}
						}
					}
				}
			}
			else if (typeUnite == "cavalier")
			{
				if(renforts >=3)
				{
					while (renfEntreIf == renforts)
					{
						if (typeUnite == "cavalier")
						{
							Plateau.actualiserTout(cartePng);
							Plateau.actualiserInfoRenforts(cartePng, idJoueur, renforts);
							Plateau.afficherBoutonPressed(2);
							Plateau.afficheInfosArmees(cartePng);
							idTerri = Interface.lectureClic(cartePng);
							if (idTerri>=0)
							{
								if (regionClicked(idTerri).getTerritoires().get(Territoire.territoireDsRegion(idTerri)).getProprietaire() == listeJoueurs.get(idJoueur).getIdJoueur())
								{
									listeJoueurs.get(idJoueur).ajouterRenfortJoueur(typeUnite, idTerri);
									regionClicked(idTerri).ajouterRenfortRegion(typeUnite,idTerri);
									renforts -= 3;
								}
								else
								{
									System.out.println("Veuillez cliquer sur un de vos territoires");
								}
							}
						}
					}
				}
				else
				{
					System.out.println("Vous n'avez pas assez de renforts");
					Plateau.afficheMessages("renfort",0);
				}
				
			}
			else if (typeUnite =="canon")
			{
				if (renforts >=7)
				{
					while (renfEntreIf == renforts)
					{
						if (typeUnite =="canon")
						{
							Plateau.actualiserTout(cartePng);
							Plateau.actualiserInfoRenforts(cartePng, idJoueur, renforts);
							Plateau.afficherBoutonPressed(3);
							Plateau.afficheInfosArmees(cartePng);
							idTerri = Interface.lectureClic(cartePng);
							if (idTerri>=0)
							{
								if (regionClicked(idTerri).getTerritoires().get(Territoire.territoireDsRegion(idTerri)).getProprietaire() == listeJoueurs.get(idJoueur).getIdJoueur())
								{
									listeJoueurs.get(idJoueur).ajouterRenfortJoueur(typeUnite, idTerri);
									regionClicked(idTerri).ajouterRenfortRegion(typeUnite,idTerri);
									renforts -= 7;
								}
								else
								{
									System.out.println("Veuillez cliquer sur un de vos territoires");
								}
							}
						}
					}
				}
				else
				{
					System.out.println("Vous n'avez pas assez de renforts");
					Plateau.afficheMessages("renfort",0);
				}
			}
		}
		Plateau.actualiserTout(cartePng);
		Plateau.actualiserInfoRenforts(cartePng, idJoueur, renforts);
		StdDraw.show();
	}
	
		
	public static void deplacerSoldat(int nbrSoldatsDepl, int idTerrIni, int idTerrCible, int idJoueur, String cartePng)
	{
		int nbrSoldatTired = 0;
		int mvtLeft = 2;
		for (int i=0; i<nbrSoldatsDepl; i++)
		{
			//Cot� Territoire
			regionClicked(idTerrIni).getTerritoires().get(Territoire.territoireDsRegion(idTerrIni)).setNbrSoldat(regionClicked(idTerrIni).getTerritoires().get(Territoire.territoireDsRegion(idTerrIni)).getNbrSoldat()-1); //On retire un soldat dans le territoire de d�part
			regionClicked(idTerrCible).getTerritoires().get(Territoire.territoireDsRegion(idTerrCible)).setNbrSoldat(regionClicked(idTerrCible).getTerritoires().get(Territoire.territoireDsRegion(idTerrCible)).getNbrSoldat()+1);		//On rajoute un soldat dans le territoire cible
				
			//Cot� Unit�
			boolean soldatBouged = false;
			int j=0;
			while(soldatBouged== false)
			{
				if (listeJoueurs.get(idJoueur).getListeUnite().get(j).getType() == "soldat")	//Si l'unit� est un soldat
				{
					if (listeJoueurs.get(idJoueur).getListeUnite().get(j).getIdPosition()==idTerrIni && listeJoueurs.get(idJoueur).getListeUnite().get(j).getMvtLeft() == mvtLeft)	//Si l'unit� est sur le Territoire initial et qu'elle a le plus de d�placement left possible
					{
						listeJoueurs.get(idJoueur).getListeUnite().get(j).setIdPosition(idTerrCible);	//On le met sur le territoire cible
						listeJoueurs.get(idJoueur).getListeUnite().get(j).setMvtLeft(listeJoueurs.get(idJoueur).getListeUnite().get(j).getMvtLeft()-1);	//On lui retire un point de d�placement
						if(listeJoueurs.get(idJoueur).getListeUnite().get(j).getMvtLeft()==0)	//S'il ne peut plus bouger
						{
							nbrSoldatTired++;		//Il est �puis�
						}
						soldatBouged =true;	//On a efficacement boug� un soldat, on sort de la boucle, on passe au soldat suivant, s'il y en a un
					}
				}
				j++;
				if (j>=listeJoueurs.get(idJoueur).getListeUnite().size())	//Si on a parcouru toute la liste et qu'on a pas trouv� de soldat avec getmvtLeft() = mvtLeft
				{
					j=0;		//On re parcours la liste
					mvtLeft--;	//On cherche des soldats avec moins de mvt disponible
				}
			}
		}
		if (nbrSoldatTired >=1)
		{
			System.out.println("Ce d�placement a fatigu� " + nbrSoldatTired + " soldats, ils ne peuvent plus bouger ni attaquer pendant ce tour");
			Plateau.actualiserTout(cartePng);
			Plateau.afficheInfosJoueur(cartePng, idJoueur+1, 0);
			Plateau.afficheInfosSeDeplacer(cartePng);
			Plateau.afficheMessages("fatigue", nbrSoldatTired);
		}
	}
	
	
	public static void deplacerCavalier(int nbrCavalsDepl, int idTerrIni, int idTerrCible, int idJoueur, String cartePng)
	{
		int nbrCavalTired = 0;
		int mvtLeft = 3;
		for (int i=0; i<nbrCavalsDepl; i++)
		{
			//Cot� Territoire
			regionClicked(idTerrIni).getTerritoires().get(Territoire.territoireDsRegion(idTerrIni)).setNbrCaval(regionClicked(idTerrIni).getTerritoires().get(Territoire.territoireDsRegion(idTerrIni)).getNbrCaval()-1); //On retire un cavalier dans le territoire de d�part
			regionClicked(idTerrCible).getTerritoires().get(Territoire.territoireDsRegion(idTerrCible)).setNbrCaval(regionClicked(idTerrCible).getTerritoires().get(Territoire.territoireDsRegion(idTerrCible)).getNbrCaval()+1);		//On rajoute un cavalier dans le territoire cible
				
			//Cot� Unit�
			boolean cavalbouged = false;
			int j=0;
			while(cavalbouged== false)
			{
				if (listeJoueurs.get(idJoueur).getListeUnite().get(j).getType() == "cavalier")
				{
					if (listeJoueurs.get(idJoueur).getListeUnite().get(j).getIdPosition()==idTerrIni && listeJoueurs.get(idJoueur).getListeUnite().get(j).getMvtLeft() == mvtLeft)
					{
						listeJoueurs.get(idJoueur).getListeUnite().get(j).setIdPosition(idTerrCible);
						listeJoueurs.get(idJoueur).getListeUnite().get(j).setMvtLeft(listeJoueurs.get(idJoueur).getListeUnite().get(j).getMvtLeft()-1);
						if(listeJoueurs.get(idJoueur).getListeUnite().get(j).getMvtLeft()==0)
						{
							nbrCavalTired++;
						}
						cavalbouged =true;
					}
				}
				j++;
				if (j>=listeJoueurs.get(idJoueur).getListeUnite().size())	//Si on a parcouru toute la liste et qu'on a pas trouv� de cavalier avec getmvtLeft() = mvtLeft
				{
					j=0;		//On re parcours la liste
					mvtLeft--;	//On cherche des cavaliers avec moins de mvt disponible
				}
			}
		}
		if (nbrCavalTired >=1)
		{
			System.out.println("Ce d�placement a fatigu� " + nbrCavalTired + " magiciens, ils ne peuvent plus bouger ni attaquer pendant ce tour");
			Plateau.actualiserTout(cartePng);
			Plateau.afficheInfosJoueur(cartePng, idJoueur+1, 0);
			Plateau.afficheInfosSeDeplacer(cartePng);
			Plateau.afficheMessages("fatigue", nbrCavalTired);
		}
	}
	
	
	public static void deplacerCanon(int nbrCanonsDepl, int idTerrIni, int idTerrCible, int idJoueur, String cartePng)
	{
		int nbrCanonTired = 0;
		for (int i=0; i<nbrCanonsDepl; i++)
		{
			//Cot� Territoire
			regionClicked(idTerrIni).getTerritoires().get(Territoire.territoireDsRegion(idTerrIni)).setNbrCanon(regionClicked(idTerrIni).getTerritoires().get(Territoire.territoireDsRegion(idTerrIni)).getNbrCanon()-1); //On retire un soldat dans le territoire de d�part
			regionClicked(idTerrCible).getTerritoires().get(Territoire.territoireDsRegion(idTerrCible)).setNbrCanon(regionClicked(idTerrCible).getTerritoires().get(Territoire.territoireDsRegion(idTerrCible)).getNbrCanon()+1);		//On rajoute un soldat dans le territoire cible
				
			//Cot� Unit�
			boolean canonBouged = false;
			int j=0;
			while(canonBouged== false)
			{
				if (listeJoueurs.get(idJoueur).getListeUnite().get(j).getType() == "canon")
				{
					if (listeJoueurs.get(idJoueur).getListeUnite().get(j).getIdPosition()==idTerrIni)
					{
						listeJoueurs.get(idJoueur).getListeUnite().get(j).setIdPosition(idTerrCible);
						listeJoueurs.get(idJoueur).getListeUnite().get(j).setMvtLeft(listeJoueurs.get(idJoueur).getListeUnite().get(j).getMvtLeft()-1);
						nbrCanonTired++;
						canonBouged =true;
					}
				}
				j++;
			}
		}
		if (nbrCanonTired >=1)
		{
			System.out.println("Ce d�placement a fatigu� " + nbrCanonTired + " dragons, ils ne peuvent plus bouger ni attaquer pendant ce tour");
			Plateau.actualiserTout(cartePng);
			Plateau.afficheInfosJoueur(cartePng, idJoueur+1, 0);
			Plateau.afficheInfosSeDeplacer(cartePng);
			Plateau.afficheMessages("fatigue", nbrCanonTired);
		}
	}
	
	public static ArrayList<Unite> selectionDefense(int idTerrCible)
	{
		int idJoueurAttaqued = regionClicked(idTerrCible).getTerritoires().get(Territoire.territoireDsRegion(idTerrCible)).getProprietaire();
		int prioriteDefense = 1;
		ArrayList <Unite> listeUniteDefense = new ArrayList <Unite>();
		
		boolean isUniteTrouvee = false;
		while(isUniteTrouvee==false)
		{
			if (regionClicked(idTerrCible).getTerritoires().get(Territoire.territoireDsRegion(idTerrCible)).getNbrSoldat()+regionClicked(idTerrCible).getTerritoires().get(Territoire.territoireDsRegion(idTerrCible)).getNbrCaval()+regionClicked(idTerrCible).getTerritoires().get(Territoire.territoireDsRegion(idTerrCible)).getNbrCanon() ==1)
			{		//S'il n'y a qu'une seule unit� sur le territoire attaqu�
				for (int i=0; i<listeJoueurs.get(idJoueurAttaqued).getListeUnite().size(); i++)		//On parcourt la liste d'unit�s du joueur attaqu�
				{		
					if (listeJoueurs.get(idJoueurAttaqued).getListeUnite().get(i).getIdPosition() == idTerrCible)	//Si on trouve l'unite sur le territoire attaqu�
					{
						listeUniteDefense.add(listeJoueurs.get(idJoueurAttaqued).getListeUnite().get(i));		//On l'ajoute � la liste des d�fenseurs
						isUniteTrouvee = true;		//On a compl�t� la liste d'unit�s d�fendant
					}
				}
			}
			else
			{
				for(int i=0; i<listeJoueurs.get(idJoueurAttaqued).getListeUnite().size(); i++)
				{
					if (listeJoueurs.get(idJoueurAttaqued).getListeUnite().get(i).getIdPosition() == idTerrCible && listeJoueurs.get(idJoueurAttaqued).getListeUnite().get(i).getPrioriteDEF() == prioriteDefense)
					{		//Si on trouve une des unit� sur le territoire attaqu� et que elle a l'ordre de priorit� de d�fense le plus important parmi toutes les unit�s sur ce territoire
						if (listeUniteDefense.size() <2)
						{
							listeUniteDefense.add(listeJoueurs.get(idJoueurAttaqued).getListeUnite().get(i)); //Si la liste de d�fenseurs est incompl�te
						}
						else	//Si la liste de d�fenseurs est compl�te
						{
							isUniteTrouvee = true;	//On sort du while
						}
					}
				}			
			}
			prioriteDefense++;
		}
		return listeUniteDefense;		
	}
	
	public static ArrayList<Unite> creaArrayAttaquant(int idJoueurAttq, int idTerrIni, int nbrSoldatsAttq, int nbrCavalsAttq, int nbrCanonsAttq)
	{
		ArrayList <Unite> listeUniteAttaque = new ArrayList <Unite>();
		int mvtLeft = 2;
		if (nbrSoldatsAttq>0)	//On ajoute, s'il y en a, des soldats
		{
			for (int i=0; i<nbrSoldatsAttq; i++)
			{					
				boolean soldatAdded = false;
				int j=0;
				while(soldatAdded== false)
				{
					if (listeJoueurs.get(idJoueurAttq).getListeUnite().get(j).getType() == "soldat")	//Si l'unit� est un soldat
					{
						if (listeJoueurs.get(idJoueurAttq).getListeUnite().get(j).getIdPosition()==idTerrIni && listeJoueurs.get(idJoueurAttq).getListeUnite().get(j).getMvtLeft() == mvtLeft)	//Si l'unit� est sur le Territoire initial et qu'elle a le plus de d�placement left possible
						{
							listeUniteAttaque.add(listeJoueurs.get(idJoueurAttq).getListeUnite().get(j));//On l'ajoute � la liste des attaquants
							soldatAdded =true;	//On a efficacement s�lectionn� un soldat, on sort de la boucle, on passe au soldat suivant, s'il y en a un
						}
					}
					if (j>=listeJoueurs.get(idJoueurAttq).getListeUnite().size())	//Si on a parcouru toute la liste et qu'on a pas trouv� de soldat avec getmvtLeft() = mvtLeft
					{
						j=0;		//On re parcours la liste
						mvtLeft--;	//On cherche des soldats avec moins de mvt disponible
					}
					else
					{
						j++;
					}
				}
			}
		}
		mvtLeft =3;
		if (nbrCavalsAttq>0)	//On ajoute, s'il y en a, des cavaliers
		{
			for (int i=0; i<nbrCavalsAttq; i++)
			{					
				boolean cavalAdded = false;
				int j=0;
				while(cavalAdded== false)
				{
					if (listeJoueurs.get(idJoueurAttq).getListeUnite().get(j).getType() == "cavalier")	//Si l'unit� est un cavalier
					{
						if (listeJoueurs.get(idJoueurAttq).getListeUnite().get(j).getIdPosition()==idTerrIni && listeJoueurs.get(idJoueurAttq).getListeUnite().get(j).getMvtLeft() == mvtLeft)	//Si l'unit� est sur le Territoire initial et qu'elle a le plus de d�placement left possible
						{
							listeUniteAttaque.add(listeJoueurs.get(idJoueurAttq).getListeUnite().get(j));
							cavalAdded =true;	//On a efficacement s�lectionn� un cavalier, on sort de la boucle, on passe au soldat suivant, s'il y en a un
						}
					}
					if (j>=listeJoueurs.get(idJoueurAttq).getListeUnite().size())	//Si on a parcouru toute la liste et qu'on a pas trouv� de cavalier avec getmvtLeft() = mvtLeft
					{
						j=0;		//On re parcours la liste
						mvtLeft--;	//On cherche des cavaliers avec moins de mvt disponible
					}
					else
					{
						j++;
					}
				}
			}
		}
		if(nbrCanonsAttq>0)	//On ajoute, s'il y en a, des canons
		{
			for (int i=0; i<nbrCavalsAttq; i++)
			{					
				boolean canonAdded = false;
				int j=0;
				while(canonAdded== false)
				{
					if (listeJoueurs.get(idJoueurAttq).getListeUnite().get(j).getType() == "canon")	//Si l'unit� est un canon
					{
						if (listeJoueurs.get(idJoueurAttq).getListeUnite().get(j).getIdPosition()==idTerrIni)	//Si l'unit� est sur le Territoire initial 
						{
							listeUniteAttaque.add(listeJoueurs.get(idJoueurAttq).getListeUnite().get(j));
							canonAdded =true;	//On a efficacement s�lectionn� un canon, on sort de la boucle, on passe au soldat suivant, s'il y en a un
						}
					}
					j++;
				}
			}
		}		
		return listeUniteAttaque;
	}
	
	public static void bataille(int idJoueurAttq, int idTerrIni, int idTerrCible, ArrayList<Unite> listeUniteDefense, ArrayList<Unite> listeUniteAttaque)
	{
		int[] puissAttaq = new int[listeUniteAttaque.size()];
		int[] puissDef = new int[listeUniteDefense.size()];
		int[] victoire = new int[Math.min(listeUniteAttaque.size(), listeUniteDefense.size())]; //Victoire de Attaq=1, victoire de Def=2
		for (int i=0; i<listeUniteAttaque.size(); i++)
		{//On g�n�re un nombre al�atoire parmi la liste de puissance d'une unit� et on la met dans puissAttaq
			listeUniteAttaque.get(i).setPuissanceCombat((int) (Math.random()*(listeUniteAttaque.get(i).getPuissance()[5]-listeUniteAttaque.get(i).getPuissance()[0]+1))+listeUniteAttaque.get(i).getPuissance()[0]);
			puissAttaq[i] =(int) Math.random()*(listeUniteAttaque.get(i).getPuissance()[5]-listeUniteAttaque.get(i).getPuissance()[0]+1)+listeUniteAttaque.get(i).getPuissance()[0];
		}
		for (int i=0; i<listeUniteDefense.size(); i++)
		{
			listeUniteDefense.get(i).setPuissanceCombat((int) (Math.random()*(listeUniteDefense.get(i).getPuissance()[5]-listeUniteDefense.get(i).getPuissance()[0]+1))+listeUniteDefense.get(i).getPuissance()[0]);
			puissDef[i] =(int) Math.random()*(listeUniteDefense.get(i).getPuissance()[5]-listeUniteDefense.get(i).getPuissance()[0]+1)+listeUniteDefense.get(i).getPuissance()[0];
		}
		
		int[] puissAttaqTried = Unite.TriParSelection(puissAttaq);		//valeurs tri�es du plus grand au plus petit des puissances de l'attaque
		int[] puissDefTried = Unite.TriParSelection(puissDef);			//Same pour la d�fense
		
		int highestPatt = Unite.highestPrioATT(listeUniteAttaque);
		int highestPdef = Unite.highestPrioDEF(listeUniteDefense);
		
		ArrayList<Unite> listeAttaqueTried = new ArrayList<Unite>();
		ArrayList<Unite> listeDefenseTried = new ArrayList<Unite>();
		
		for (int i=0; i<puissAttaqTried.length; i++)
		{
			if (listeUniteAttaque.get(i).getPuissanceCombat()==puissAttaqTried[i])
			{
				for (int k=0; k<highestPatt; k++)
				{
					if (listeUniteAttaque.get(k).getPrioriteATT() == highestPatt)
					{
						listeAttaqueTried.add(listeUniteAttaque.get(i));
					}
				}
				
			}
		}
		 
		
		int[] attaqueATuer = new int[puissAttaq.length];
		int[] defenseATuer = new int[puissDef.length];
		int j=0;
		while(j<Math.min(listeUniteAttaque.size(), listeUniteDefense.size()))		//Tant que j (index) est inf�rieur au nombre de combats qu'il va y avoir
		{
			if (puissAttaqTried[j]>puissDefTried[j])
			{
				victoire[j]=1;		//Victoire de l'attaque
				attaqueATuer[j] = 0;
				defenseATuer[j] = 1;
			}
			else
			{
				victoire[j]=2;		//Victoire de la d�fense
				attaqueATuer[j] = 1;
				defenseATuer[j] = 0;
			}
		}
	}
	
	
	
}
