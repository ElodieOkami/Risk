import edu.princeton.cs.introcs.StdDraw;
import java.awt.Font;


public class RiskIsep {

	public static void main(String[] args) {
		
		String cartePng = "plateauElder.png";

		Plateau.affichePlateau(cartePng);					//Affiche l'image du plateau de jeu
		int idMax = Region.creationRegions(cartePng);			//Crée les Régions ainsi que les territoires
		Territoire.attributionTerritoire(idMax);			//Attribue les territoires aléatoirement aux différents joueurs
		
	}
	
	// Fonction pour définir les paramètres du début de jeu 
	
	


}
