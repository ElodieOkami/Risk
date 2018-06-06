import java.awt.Color;
import java.util.ArrayList;

import edu.princeton.cs.introcs.StdDraw;

//Class permettant les �tapes d'initialisation c�d la cr�ations des objets dont on a besoin

public class Initialisation {

	
	public static int initialisationJoueur() //Fonction appell�e par le Main
	{
		int nbrJr = 0;		
		Plateau.CreaCanvas();				//Cr�ation d'un canvas adapt� � la taille de la fen�tre
		
		while (nbrJr == 0) 					//S�l�ction du nombre de joueurs
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
		Plateau.afficheInfosIni(cartePng, nbrJr);
		RiskIsep.placementUniteIni(nbrJr, cartePng);	
		return cartePng;
	}
	
}