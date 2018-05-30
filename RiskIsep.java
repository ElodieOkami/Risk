import edu.princeton.cs.introcs.StdDraw;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;


public class RiskIsep {

	public static void main(String[] args) {
		int nbrJr = 0;
		
		Plateau.CreaCanvas();
		while (nbrJr == 0)
		{
			nbrJr = MenuJoueur();
			
		}
		//System.out.println(nbrJr);
	
		//Potentielle fonction de choix de carte
		
		String cartePng = "plateauElder.png";
		Mission.attributionMissions(nbrJr);
		CreaRegTer(cartePng, nbrJr);
		Unite.repartitionUnite(nbrJr);
		
		
	}
	
	public static int MenuJoueur() 
	{
		Plateau.afficheMenu();
		if(StdDraw.mousePressed())
		{
			double clickX=StdDraw.mouseX();
			double clickY=StdDraw.mouseY();		
			return Joueur.nombreJoueurs(clickX, clickY);
		}
		return 0;
	}
	
	public static void CreaRegTer(String cartePng, int nbrJr)
	{
		Plateau.affichePlateau(cartePng);					//Affiche l'image du plateau de jeu
		int idMax = Region.creationRegions(cartePng, nbrJr);			//Crée les Régions ainsi que les territoires
	}

}
