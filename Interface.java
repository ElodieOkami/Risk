import java.awt.Color;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.imageio.ImageIO;
import edu.princeton.cs.introcs.StdDraw;

//Class permettant de récupérer et analyser des informations selon la position des clics

public class Interface {

	static final int clicTropBas = 20; //A cause de la barre en haut de la fenêtre, tous les clics sont trop bas
	
	//Interface 1er Menu (séléction du nombre de joueurs)
	public static int MenuJoueur() 
	{
		Plateau.afficheMenuJoueur();
		if(StdDraw.isMousePressed())
		{
			double clickX=StdDraw.mouseX();
			double clickY=StdDraw.mouseY()-clicTropBas;		
			return nombreJoueurs(clickX, clickY);
		}
		return 0;
	}
	
	public static int nombreJoueurs(double clickX, double clickY)
	{
		Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int height = (int)dimension.getHeight();
		int width  = (int)dimension.getWidth();
					
			if(height/1.5-20 < clickY && clickY < height/1.5+20) 
			{
				if (width/3.9-15 < clickX && clickX < width/3.9+15) 
				{
					Initialisation.creaJoueur(1);
					return 1;
				}
				
				else if (width/2.8-15 < clickX && clickX < width/2.8+15) 
				{
					Initialisation.creaJoueur(2);
					return 2;
				}
				
				else if (width/2.2-15 < clickX && clickX < width/2.2+15)
				{
					Initialisation.creaJoueur(3);
					return 3;
				}
				
				else if (width/1.8-15 < clickX && clickX < width/1.8+15)
				{
					Initialisation.creaJoueur(4);
					return 4;
				}
				
				else if (width/1.55-15 < clickX && clickX < width/1.55+15)
				{
					Initialisation.creaJoueur(5);
					return 5;
				}
				
				else if (width/1.35-15 < clickX && clickX < width/1.35+15)
				{
					Initialisation.creaJoueur(6);
					return 6;
				}
			}
		return 0;
	}
	
	
	//Interface 2ème Menu (séléction de la carte)
	public static String MenuCarte() 
	{
		Plateau.afficheMenuCarte();
		if(StdDraw.isMousePressed())
		{
			double clickX=StdDraw.mouseX();
			double clickY=StdDraw.mouseY()-clicTropBas;
			int indice = choixCarte(clickX, clickY);
			if(indice == 1)
			{
				return "plateauTerre.png";
			}
			else if(indice == 2)
			{
				return "plateauElder.png";
			}
		}
		return "nonselectionne";
	}
	
	public static int choixCarte(double clickX, double clickY)
	{
		Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int height = (int)dimension.getHeight();
		int width  = (int)dimension.getWidth();
		
		
		if(height/1.5-height/45 < clickY && clickY < height/1.5+height/30) 
		{
			if (width/2.3-width/25 < clickX && clickX < width/2.3+width/25) 
			{
				return 1;
			}
			
			else if (width/1.8-width/25 < clickX && clickX < width/1.8+width/25) 
			{
				return 2;
			}
		}
		return 0;
	}
	
	//Jeu
	public static void lectureClic(String cartePng) {
	    try {
	        BufferedImage image = ImageIO.read(new File(cartePng));    
	        Color couleur;
	        
	        Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
			int height = (int)dimension.getHeight();
			int width  = (int)dimension.getWidth();
			
	        if(StdDraw.isMousePressed())
	        		{
	        			int clickX=(int) StdDraw.mouseX();
	        			int clickY=(int) StdDraw.mouseY()-clicTropBas;
	        			
	        			clickX = clickX-((width-image.getWidth())/2);
	        			clickY = clickY-((height-image.getHeight())/2);
	        			
	        			System.out.println(clickX);
	        			System.out.println(image.getHeight()-clickY);
	        			
	        			couleur = new Color(image.getRGB(clickX, image.getHeight()-clickY));
	        			
	        			System.out.println("R = " + couleur.getRed());
	        			System.out.println("G = " + couleur.getGreen());
	        			System.out.println("B = " + couleur.getBlue());
	        			System.out.println(couleur.getRGB());
	        			correspondClic(cartePng, couleur);
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
	
	public static void correspondClic(String cartePng, Color couleur)
	{
		if (cartePng == "plateauElder.png")
		{
			
		}
	}
	
	public static void ifClicCouleur()
	{
		
	}
	
	
}