
public class Jeu {
	
	
	public static int initialisationJoueur(int nbrJr) //Fonction appellée par le Main
	{
		int joueurGagnant =-1;
		while(joueurGagnant ==-1)
		{
			
			
			
			
			
			
			
			joueurGagnant = RiskIsep.allRegionPoss(nbrJr);
		}
		return joueurGagnant;
	}
	
	
	
	
}
