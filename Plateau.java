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
		StdDraw.setCanvasSize(width,height);
		StdDraw.setXscale(0, width);
		StdDraw.setYscale(0, height);
	}

	public static void afficheMenuJoueur()	// Affiche le choix du nombre de joueurs en début de partie
	{
		String cartePng = "plateauMenu.png";
		Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int height = (int)dimension.getHeight();
		int width  = (int)dimension.getWidth();
		
		try {
	        StdDraw.clear();
	        BufferedImage image = ImageIO.read(new File(cartePng)); 
	        
	        double RapportE = (double)width/height;
	        double RapportI = (double) image.getWidth()/image.getHeight();
	        double scaleX;
	        double scaleY;
	        
	        if(RapportE>RapportI)
	        {
	        	scaleX = (double)image.getWidth()*height/image.getHeight();
	        	scaleY = (double)height;
	        }
	        else
	        {
	        	scaleY = (double)image.getHeight()*width/image.getWidth();
	        	scaleX = (double)width;
	        }		 
		
	        StdDraw.picture(width/2, height/2, cartePng, scaleX, scaleY);
	        
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
	
		StdDraw.setPenColor(Color.red);				//Couleur du titre en rouge
		Font font = new Font("Papyrus", Font.BOLD, 60);	//En gros en gras
		StdDraw.setFont(font);
		
		StdDraw.text(width/2,height/1.1,"Bienvenue dans RiskIsep");
		
		StdDraw.setPenColor();							//Couleur en noir
		font = new Font("Papyrus", Font.PLAIN, 40);		//En plus petit et pas en gras
		StdDraw.setFont(font);
		
		StdDraw.text(width/2, height/1.3, "Combien de joueurs êtes-vous ?");

		font = new Font("Times new roman", Font.PLAIN, 40);
		StdDraw.setFont(font);
		
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
				
		StdDraw.show(1);
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
		StdDraw.rectangle(width/2.3, height/1.5+5, width/25, 30);
		StdDraw.text(width/1.8, height/1.5, "Tamriel");
		StdDraw.rectangle(width/1.8, height/1.5+5, width/25, 30);
		
		StdDraw.show(1);
		StdDraw.clear();	
	}

	
	public static void affichePlateau(String cartePng)			//Affiche l'image du plateau de jeu
	{
		Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int height = (int)dimension.getHeight();
        int width  = (int)dimension.getWidth();
        
		try {
	        StdDraw.clear();
	        BufferedImage image = ImageIO.read(new File(cartePng)); 
	        
	        double RapportE = (double)width/height;
	        double RapportI = (double) image.getWidth()/image.getHeight();
	        double scaleX;
	        double scaleY;
	        
	        if(RapportE>RapportI)
	        {
	        	scaleX = (double)image.getWidth()*height/image.getHeight();
	        	scaleY = (double)height;
	        }
	        else
	        {
	        	scaleY = (double)image.getHeight()*width/image.getWidth();
	        	scaleX = (double)width;
	        }		 
		
	        StdDraw.picture(width/2, height/2, cartePng); //Rajouter ",scaleX ,scaleY" dans la parenthèse pour avoir du rescale mais perturbe les clics
	        StdDraw.show(1);
	        
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
	
	public static void afficheUnite()
	{
		
	}
	
}
