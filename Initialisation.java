import java.awt.Color;
import java.util.ArrayList;

import edu.princeton.cs.introcs.StdDraw;

//Class permettant les étapes d'initialisation càd la créations des objets dont on a besoin

public class Initialisation {

	
	public static int initialisationJoueur() //Fonction appellée par le Main
	{
		int nbrJr = 0;		
		Plateau.CreaCanvas();				//Création d'un canvas adapté à la taille de la fenêtre
		
		while (nbrJr == 0) 					//Séléction du nombre de joueurs
		{
			nbrJr = Interface.MenuJoueur();
		}
		
		try {
		    Thread.sleep(150);
		} catch(InterruptedException e) {
		    System.out.println("Sommeil interrompu");
		}
		return nbrJr;
	}
	public static String initialisationJeu(int nbrJr)
	{
		String cartePng = "nonselectionne";
		
		while (cartePng == "nonselectionne")//Choix de la carte
		{		
			cartePng = Interface.MenuCarte();
		}
		
		try {
		    Thread.sleep(150);
		} catch(InterruptedException e) {
		    System.out.println("Sommeil interrompu");
		}
		
		Plateau.affichePlateau(cartePng);
		Mission.attributionMissions(nbrJr);
		Region.CreaRegTer(cartePng, nbrJr);
		RiskIsep.creaJoueur(nbrJr);
		RiskIsep.PossesseurTerris(cartePng);
		RiskIsep.placementUniteIni(nbrJr, cartePng);	
		return cartePng;
	}

}
