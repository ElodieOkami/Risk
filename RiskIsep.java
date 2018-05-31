import edu.princeton.cs.introcs.StdDraw;


public class RiskIsep {

	public static void main(String[] args) {
		int nbrJr = 0;
		String cartePng = "nonselectionne";
		
		Plateau.CreaCanvas();
		
		while (nbrJr == 0) //Séléction du nombre de joueurs
		{
			nbrJr = MenuJoueur();
			
		}

		
		while (cartePng == "nonselectionne")//Choix de la carte
		{
			cartePng = MenuCarte();
		}
		
		Mission.attributionMissions(nbrJr);
		CreaRegTer(cartePng, nbrJr);
		Unite.repartitionUnite(nbrJr);
		
		
		
		
		
	}
	
	public static int MenuJoueur() 
	{
		Plateau.afficheMenuJoueur();
		if(StdDraw.mousePressed())
		{
			double clickX=StdDraw.mouseX();
			double clickY=StdDraw.mouseY();		
			return Joueur.nombreJoueurs(clickX, clickY);
		}
		return 0;
	}
	
	public static String MenuCarte() 
	{
		Plateau.afficheMenuCarte();
		String carte = "noMap.png";
		if(StdDraw.mousePressed())
		{
			double clickX=StdDraw.mouseX();
			double clickY=StdDraw.mouseY();
			int indice = Plateau.choixCarte(clickX, clickY);
			if(indice == 1)
			{
				carte = "plateauTerre.png";
			}
			else if(indice == 2)
			{
				carte = "plateauElder.png";
			}
		}
		return carte;
		
	}
	
	public static void CreaRegTer(String cartePng, int nbrJr)
	{
		Plateau.affichePlateau(cartePng);					//Affiche l'image du plateau de jeu
		int idMax = Region.creationRegions(cartePng, nbrJr);			//Crée les Régions ainsi que les territoires
	}
	

}
