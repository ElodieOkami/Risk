
public class Jeu {
	
	
	public static int partieDeRisk(int nbrJr, String cartePng) //Fonction appellée par le Main
	{
		int joueurGagnant =-1;
		while(joueurGagnant ==-1)
		{
			if (Interface.isIAneeded) //si c'est joueur vs IA
			{
				for (int i=0; i<nbrJr+1; i++)
				{
					if(i==0)
					{
						Tour.tour(i, cartePng);
					}
					else if (i==1)
					{
						System.out.println("tour de l'IA");
						Tour.tourIA(cartePng);
					}
				}	
			}
			else
			{
				for (int i=0; i<nbrJr; i++)
				{
					Tour.tour(i, cartePng);
				}			
			
			}
			
			joueurGagnant = RiskIsep.allRegionPoss(nbrJr);
		}
		Plateau.afficheGagnant(joueurGagnant);
		return joueurGagnant;
	}
	
	
	
	
}
