import edu.princeton.cs.introcs.StdDraw;
import java.awt.Font;
import java.awt.Dimension;
import java.util.ArrayList;

public class Plateau
{
	public static void CreaCanvas()
	{
		Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int height = (int)dimension.getHeight();
		int width  = (int)dimension.getWidth();
		StdDraw.setCanvasSize(width,height-100);
		StdDraw.setXscale(0, width);
		StdDraw.setYscale(0, height);
	}

	public static void afficheMenu()	// Affiche le choix du nombre de joueurs en début de partie
	{
		Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int height = (int)dimension.getHeight();
		int width  = (int)dimension.getWidth();
		
		StdDraw.setPenColor(50,100,255);				//Couleur du titre en bleu
		Font font = new Font("Arial", Font.BOLD, 60);	//En gros en gras
		StdDraw.setFont(font);
		
		StdDraw.text(width/2,height/1.1,"RiskIsep");
		
		StdDraw.setPenColor();							//Couleur en noir
		font = new Font("Arial", Font.PLAIN, 40);		//En plus petit et pas en gras
		StdDraw.setFont(font);
				
		StdDraw.text(width/2, height/1.3, "Nombre de joueur :");
		StdDraw.text(width/3.9, height/1.5, "1");
		StdDraw.circle(width/3.9, height/1.5+5, 20);
		StdDraw.text(width/2.8, height/1.5, "2");
		StdDraw.circle(width/2.8, height/1.5+5, 20);
		StdDraw.text(width/2.2, height/1.5, "3");
		StdDraw.circle(width/2.2, height/1.5+5, 20);
		StdDraw.text(width/1.8, height/1.5, "4");
		StdDraw.circle(width/1.8, height/1.5+5, 20);
		StdDraw.text(width/1.55, height/1.5, "5");
		StdDraw.circle(width/1.55, height/1.5+5, 20);
		StdDraw.text(width/1.35, height/1.5, "6");
		StdDraw.circle(width/1.35, height/1.5+5, 20);
				
		StdDraw.show(50);
		StdDraw.clear();
	}
	
	public static void affichePlateau(String cartePng)			//Affiche l'image du plateau de jeu
	{
		Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int height = (int)dimension.getHeight();
		int width  = (int)dimension.getWidth();
		
		StdDraw.picture(width/2, height/2, cartePng);
	}
	
	public static void afficheUnite()
	{
		
	}
	
}
