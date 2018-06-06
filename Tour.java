
	public class Tour {
		
		
	public static void tour(int idJoueur, String cartePng)
	{
			int renforts;
			renforts = RiskIsep.appelFonctionRenforts(idJoueur);
			RiskIsep.choixUniteEtPlacerRenforts(renforts, idJoueur, cartePng);
			
			String deplAttqTerm = "deplacement";	//Mettre la	 fonction de Maya sur le choix du menu
			switch(deplAttqTerm)
			{
			case "deplacement" :
				Territoire.deplacement(idJoueur, cartePng); //Fonction déplacement
				
				break;
			
			case "attaque":
								//Fonction attaque
				
				break;
				
			case "terminer":
								//Fonction fin de tour (juste break?)
				
				break;
			}
	}  
  
	
	
	
	
	// Fonction qui vérifie si la mission de joueur qui vient de finir son tour a été accomplie
	public static void verifMission()
	{
		
	}
	
	

}