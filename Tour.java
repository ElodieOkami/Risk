
	public class Tour {
		
		
	public static void tour(int idJoueur, String cartePng)
	{
		boolean tourPasFini = true;
		while(tourPasFini)
		{
			Plateau.afficheInfosJoueur(cartePng, idJoueur + 1);
			int renforts;
			renforts = RiskIsep.appelFonctionRenforts(idJoueur);
			RiskIsep.choixUniteEtPlacerRenforts(renforts, idJoueur, cartePng);
			
			String deplAttqTerm = Interface.whichButtonIsPressed();	//Mettre la	 fonction de Maya sur le choix du menu
			switch(deplAttqTerm)
			{
			case "deplacement" :
				Plateau.afficheInfosSeDeplacer(cartePng);
				//Territoire.deplacement(idJoueur, cartePng); //Fonction déplacement
				
				break;
			
			case "attaque":
								//Fonction attaque
				
				break;
				
			case "terminer":
								//Fonction fin de tour (juste break?)
				
				break;
			}
		}
		
		/*boolean tourPasFini = true;
		while(tourPasFini)
			{
				Plateau.afficheInfosJoueur(cartePng, idJoueur + 1);
			
				if(Interface.isRenfortPressed())
				{
					Plateau.afficheInfosRenforts(cartePng, idJoueur);
					
						int renforts;
						renforts = RiskIsep.appelFonctionRenforts(idJoueur);
						RiskIsep.choixUniteEtPlacerRenforts(renforts, idJoueur, cartePng); 
				}
				
				else if(Interface.isSeDeplacerPressed())
				{
					Plateau.afficheInfosSeDeplacer(cartePng, idJoueur);
					Territoire.deplacement(idJoueur, cartePng); //Fonction déplacement
					
					
				}
				
				else if(Interface.isAttaquerPressed())
				{
					Plateau.afficheInfosAttaquer(cartePng, idJoueur);
				}
				
				else if(Interface.isFinDeTourPressed())
				{
					tourPasFini = false;
				}
			}*/
				
				
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
