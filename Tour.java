
public class Tour {
	
  public static void tour()
  {
    
  }  
    
  // Fonction pour vérifier si le joueur à gagné la partie 
	//A mettre à la fin de chaque tour
	public static boolean verifGagnant(int numJr) // numJr = joueur qui vient de finir son tour
	{
		int nbrTer = 0;
		for (int i = 1; i <= 42; i++)  // on parcours les 42 territoires 
		{
			if (Territoire.getNumero() == i & Territoire.getProprietaire() == numJr ) //et on vérifie s'ils appartiennent tous au même joueur
			{
				nbrTer = nbrTer + 1;
			}
		}
		
		if (nbrTer == 42) // on vérifie si le joueur à les 42 territoires 
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
	
	// Fonction qui vérifie si la mission de joueur qui vient de finir son tour a été accomplie
	public static void verifMission()
	{
		
	}
}
