import edu.princeton.cs.introcs.StdDraw;

public class Tour {
		
		
	public static void tour(int idJoueur, String cartePng)
	{
		boolean tourPasFini = true;
		
			int renforts;
			renforts = RiskIsep.appelFonctionRenforts(idJoueur);
			RiskIsep.choixUniteEtPlacerRenforts(renforts, idJoueur, cartePng);
			Plateau.actualiserTout(cartePng);
			Plateau.actualiserInfoRenforts(cartePng, idJoueur, 0);
			StdDraw.show();
			String deplAttqTerm="undefined";
			
			while(tourPasFini)
			{
				while (deplAttqTerm == "undefined")
				{
					StdDraw.clear();
					Plateau.actualiserTout(cartePng);
					Plateau.afficheInfosJoueur(cartePng, idJoueur+1, 0);
					Plateau.afficheInfosArmees(cartePng);
					deplAttqTerm = Interface.whichButtonIsPressed();	//Mettre la	 fonction de Maya sur le choix du menu
					//On fait rien, on attend juste pour passer à la suite
				}
				
				switch(deplAttqTerm)
				{
				case "deplacement" :
					StdDraw.clear();
					Plateau.actualiserTout(cartePng);
					Plateau.afficheInfosJoueur(cartePng, idJoueur+1, 0);
					Plateau.afficheInfosSeDeplacer(cartePng);
					
					Territoire.deplacement(idJoueur, cartePng); //Fonction déplacement
					
					deplAttqTerm = "undefined";
					break;
				
				case "attaque":
					StdDraw.clear();
					Plateau.actualiserTout(cartePng);
					Plateau.afficheInfosJoueur(cartePng, idJoueur+1, 0);
					Plateau.afficheInfosAttaquer2(cartePng);
					
					Territoire.attaque(idJoueur, cartePng);
					
					deplAttqTerm = "undefined";
					break;
					
				case "terminer":
									//Fonction fin de tour (juste break?)
					tourPasFini = false;
					break;
				}
		}
		
			
	}  
  
	
	
	
	
	// Fonction qui vérifie si la mission de joueur qui vient de finir son tour a été accomplie
	public static void verifMission()
	{
		
	}
	

	public static int nombreSoldatJoueur(Joueur joueur) //renvoie le nombre de soldats d'un joueur
		{
			int compteur = 0;
			int nbrUnites = joueur.getListeUnite().size();
			for(int i = 0; i < nbrUnites; i++)
			{
				if(joueur.getListeUnite().get(i).type == "soldat")
					{
						compteur = compteur + 1;
					}
			}
			return compteur;
		}
		
		public static int nombreCavalierJoueur(Joueur joueur) //renvoie le nombre de cavaliers d'un joueur
		{
			int compteur = 0;
			int nbrUnites = joueur.getListeUnite().size();
			for(int i = 0; i < nbrUnites; i++)
			{
				if(joueur.getListeUnite().get(i).type == "cavalier")
					{
						compteur = compteur + 1;
					}
			}
			return compteur;
		}
		
		public static int nombreCanonJoueur(Joueur joueur) //renvoie le nombre de canons d'un joueur
		{
			int compteur = 0;
			int nbrUnites = joueur.getListeUnite().size();
			for(int i = 0; i < nbrUnites; i++)
			{
				if(joueur.getListeUnite().get(i).type == "canon")
					{
						compteur = compteur + 1;
					}
			}
			return compteur;
		}
		
	

}