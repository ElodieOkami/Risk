import edu.princeton.cs.introcs.StdDraw;
import java.awt.Font;


public class RiskIsep {

	public static void main(String[] args) {
		
		String cartePng = "plateauElder.png";

		Plateau.affichePlateau(cartePng);					//Affiche l'image du plateau de jeu
		int idMax = Region.creationRegions(cartePng);			//Crée les Régions ainsi que les territoires
		Territoire.attributionTerritoire(idMax);			//Attribue les territoires aléatoirement aux différents joueurs
		
	}
	
	public static int lancementJeu() 
	{
		// Affiche du choix du nombre de joueurs en début de partie
		StdDraw.clear();
		
		StdDraw.setXscale(0,50);
		StdDraw.setYscale(0,50);
		
		
		StdDraw.text(25,45,"RiskIsep");
		
		StdDraw.text(10, 35, "Nombre de joueur :");
		StdDraw.text(20, 35, "1");
		StdDraw.circle(20, 35, 1);
		StdDraw.text(25, 35, "2");
		StdDraw.circle(25, 35, 1);
		StdDraw.text(30, 35, "3");
		StdDraw.circle(30, 35, 1);
		StdDraw.text(35, 35, "4");
		StdDraw.circle(35, 35, 1);
		StdDraw.text(40, 35, "5");
		StdDraw.circle(40, 35, 1);
		StdDraw.text(45, 35, "6");
		StdDraw.circle(45, 35, 1);
		
		StdDraw.show(20);
		
		
		if(StdDraw.mousePressed())
		{
			
			double clickX=StdDraw.mouseX();
			double clickY=StdDraw.mouseY();
			Unite[] liste = {};
			
			if(34 < clickY && clickY < 36) 
			{
				if (19 < clickX && clickX < 21) 
				{
					Joueur joueur1 = new Joueur( liste , "joueur1", Color.BLUE );
					System.out.println("un joueur");
					return 1;
				}
				
				else if (24 < clickX && clickX < 26) 
				{
					Joueur joueur1 = new Joueur( liste , "joueur1", Color.BLUE);
					Joueur joueur2 = new Joueur( liste , "joueur2", Color.RED);
					System.out.println("deux joueur");
					return 2;
				}
				
				else if (29 < clickX && clickX < 31)
				{
					Joueur joueur1 = new Joueur( liste , "joueur1", Color.BLUE);
					Joueur joueur2 = new Joueur( liste , "joueur2", Color.RED);
					Joueur joueur3 = new Joueur( liste , "joueur3", Color.GREEN);
					System.out.println("trois joueur");
					return 3;
				}
				
				else if (34 < clickX && clickX < 36)
				{
					Joueur joueur1 = new Joueur( liste , "joueur1", Color.BLUE);
					Joueur joueur2 = new Joueur( liste , "joueur2", Color.RED);
					Joueur joueur3 = new Joueur( liste , "joueur3", Color.GREEN);
					Joueur joueur4 = new Joueur( liste , "joueur4", Color.PINK);
					System.out.println("quatre joueur");
					return 4;
				}
				
				else if (39 < clickX && clickX < 41)
				{
					Joueur joueur1 = new Joueur( liste , "joueur1", Color.BLUE);
					Joueur joueur2 = new Joueur( liste , "joueur2", Color.RED);
					Joueur joueur3 = new Joueur( liste , "joueur3", Color.GREEN);
					Joueur joueur4 = new Joueur( liste , "joueur4", Color.PINK);
					Joueur joueur5 = new Joueur( liste , "joueur5", Color.YELLOW);
					System.out.println("cinq joueur");
					return 5;
				}
				
				else if (44 < clickX && clickX < 46)
				{
					Joueur joueur1 = new Joueur( liste , "joueur1", Color.BLUE);
					Joueur joueur2 = new Joueur( liste , "joueur2", Color.RED);
					Joueur joueur3 = new Joueur( liste , "joueur3", Color.GREEN);
					Joueur joueur4 = new Joueur( liste , "joueur4", Color.PINK);
					Joueur joueur5 = new Joueur( liste , "joueur5", Color.YELLOW);
					Joueur joueur6 = new Joueur( liste , "joueur6", Color.BLACK);
					System.out.println("six joueur");
					return 6;
				}
		
			}
			
		}
		return 0;	
	}
	
	


}
