import edu.princeton.cs.introcs.StdDraw;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.imageio.ImageIO;

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

	public static void afficheMenuJoueur()	// Affiche le choix du nombre de joueurs en début de partie
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
	
	public static void afficheMenuCarte()
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
				
		StdDraw.text(width/2, height/1.3, "Choix de la carte :");
		StdDraw.text(width/2.3, height/1.5, "Terre");
		StdDraw.rectangle(width/2.3, height/1.5+5, 75, 30);
		StdDraw.text(width/1.8, height/1.5, "Tamriel");
		StdDraw.rectangle(width/1.8, height/1.5+5, 75, 30);
		
		StdDraw.show(50);
		StdDraw.clear();	
	}
	
	public static int choixCarte(double clickX, double clickY)
	{
		Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int height = (int)dimension.getHeight();
		int width  = (int)dimension.getWidth();
		System.out.println("height = "+ height + " width = " + width);
		
		
		if(height/1.5-30 < clickY && clickY < height/1.5+30) 
		{
			System.out.println("height ok");
			if (width/2.3-30 < clickX && clickX < width/2.3+30) 
			{
				System.out.println("width gauche ok");
				return 1;
			}
			
			else if (width/1.8-30 < clickX && clickX < width/1.8+30) 
			{
				System.out.println("width droite ok");
				return 2;
			}
		}
		return 0;
	}
	
	public static void affichePlateau(String cartePng)			//Affiche l'image du plateau de jeu
	{
		StdDraw.clear();
		Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int height = (int)dimension.getHeight();
		int width  = (int)dimension.getWidth();
		
		StdDraw.picture(width/2, height/2, cartePng);
		StdDraw.show();
	}
	
	public static void afficheUnite()
	{
		
	}
	
	public void lectureImage(String cartePng) {
	    try {
	        BufferedImage image = ImageIO.read(new File(cartePng));
	         
	        int largeurImage = image.getWidth();
	        int hauteurImage = image.getHeight();
	         
	        Color couleur;
	        for(int colonne = 0; colonne < largeurImage; colonne++){
	            for(int ligne = 0; ligne < hauteurImage; ligne++){
	                couleur = new Color(image.getRGB(colonne, ligne), false);
	                // Traitement ici
	            }
	        }
	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	public static void lectureClic(String cartePng) {
	    try {
	        BufferedImage image = ImageIO.read(new File(cartePng));    
	        Color couleur;
	        if(StdDraw.mousePressed())
	        		{
	        			int clickX=(int) StdDraw.mouseX();
	        			int clickY=(int) StdDraw.mouseY();
	        			couleur = new Color(image.getRGB(clickX, clickY));
	        			System.out.println(couleur);
	        		}
	            }
	    catch (FileNotFoundException e) 
	    {
	        e.printStackTrace();
	    } 
	    catch (IOException e) 
	    {
	        e.printStackTrace();
	    } 
	    catch (Exception e) 
	    {
	        e.printStackTrace();
	    }
	}
}
