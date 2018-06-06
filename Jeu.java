

public class Jeu {
	
	
	public static int partieDeRisk(int nbrJr, String cartePng) //Fonction appellée par le Main
	{
		int joueurGagnant =-1;
		while(joueurGagnant ==-1)
		{
			for (int i=0; i<nbrJr; i++)
			{
				Plateau.affichePlateau(cartePng);
				RiskIsep.PossesseurTerris(cartePng);
				while(Interface.isFinDeTourPressed(i) == false)
				{
					Tour.tour(i);
				}
				
			}
			
			
			
			
			
			
			joueurGagnant = RiskIsep.allRegionPoss(nbrJr);
		}
		return joueurGagnant;
	}
	
	
	
	
}
