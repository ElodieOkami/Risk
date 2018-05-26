import edu.princeton.cs.introcs.StdDraw;
import java.awt.Font;


public class RiskIsep {

	public static void main(String[] args) {
		
		String cartePng = "plateauElder.png";

		Plateau.affichePlateau(cartePng);
		
	}
	
	// Fonction pour définir les paramètres du début de jeu 
	
	public static void preparationCarte()
	{
		String cartePng = "plateauElder.png";
		if (cartePng == "plateauElder.png")
		{
			Region provincesImperiales = new Region("provincesImperiales", 11);
			provincesImperiales.creationTerritoires();
			Region lenclume = new Region("lenclume", 5);
			lenclume.creationTerritoires();
			Region cyrodiil = new Region("cyrodiil", 8);
			cyrodiil.creationTerritoires();
			Region archipelAutomne = new Region("archipelAutomne", 3);
			archipelAutomne.creationTerritoires();
			Region aldmeri = new Region("aldmeri", 5);
			aldmeri.creationTerritoires();
			Region argonie = new Region("argonie", 10);
			argonie.creationTerritoires();
		}
		
		
		
	}
	
	
	



}
