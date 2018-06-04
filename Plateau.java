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
	static Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
	final static int height = (int)dimension.getHeight();
    final static int width  = (int)dimension.getWidth();
    
	public static void CreaCanvas()
	{
		StdDraw.setCanvasSize(width,height);
		StdDraw.setXscale(0, width);
		StdDraw.setYscale(0, height);
	}

	public static void afficheMenuJoueur()	// Affiche le choix du nombre de joueurs en début de partie
	{
		String cartePng = "plateauMenu.png";
		
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
		StdDraw.setPenColor(50,100,255);				//Couleur du titre en bleu
		Font font = new Font("Arial", Font.BOLD, 60);	//En gros en gras
		StdDraw.setFont(font);
		
		StdDraw.text(width/2,height/1.1,"RiskIsep");
		
		StdDraw.setPenColor();							//Couleur en noir
		font = new Font("Arial", Font.PLAIN, 30);		//En plus petit et pas en gras
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
	
	
	public static void affichePointProprio(int idTerr, Color couleur)
	{
		if (idTerr==0)
		{
			StdDraw.setPenColor(couleur);
			StdDraw.filledCircle(width/3.3, height/1.18, 7);
			StdDraw.setPenColor();
			StdDraw.circle(width/3.3, height/1.18, 7);
		}
		if (idTerr==1)
		{
			StdDraw.setPenColor(couleur);
			StdDraw.filledCircle(width/2.45, height/1.18, 7);
			StdDraw.setPenColor();
			StdDraw.circle(width/2.45, height/1.18, 7);
		}
		if (idTerr==2)
		{
			StdDraw.setPenColor(couleur);
			StdDraw.filledCircle(width/2.21, height/1.27, 7);
			StdDraw.setPenColor();
			StdDraw.circle(width/2.21, height/1.27, 7);
		}
		if (idTerr==3)
		{
			StdDraw.setPenColor(couleur);
			StdDraw.filledCircle(width/2.17, height/1.13, 7);
			StdDraw.setPenColor();
			StdDraw.circle(width/2.17, height/1.13, 7);
		}
		if (idTerr==4)
		{
			StdDraw.setPenColor(couleur);
			StdDraw.filledCircle(width/2.03, height/1.385, 7);
			StdDraw.setPenColor();
			StdDraw.circle(width/2.03, height/1.385, 7);
		}
		if (idTerr==5)
		{
			StdDraw.setPenColor(couleur);
			StdDraw.filledCircle(width/1.83, height/1.288, 7);
			StdDraw.setPenColor();
			StdDraw.circle(width/1.83, height/1.288, 7);
		}
		if (idTerr==6)
		{
			StdDraw.setPenColor(couleur);
			StdDraw.filledCircle(width/1.83, height/1.38, 7);
			StdDraw.setPenColor();
			StdDraw.circle(width/1.83, height/1.38, 7);
		}
		if (idTerr==7)
		{
			StdDraw.setPenColor(couleur);
			StdDraw.filledCircle(width/1.68, height/1.39, 7);
			StdDraw.setPenColor();
			StdDraw.circle(width/1.68, height/1.39, 7);
		}
		if (idTerr==8)
		{
			StdDraw.setPenColor(couleur);
			StdDraw.filledCircle(width/1.71, height/1.277, 7);
			StdDraw.setPenColor();
			StdDraw.circle(width/1.71, height/1.277, 7);
		}
		if (idTerr==9)
		{
			StdDraw.setPenColor(couleur);
			StdDraw.filledCircle(width/1.72, height/1.19, 7);
			StdDraw.setPenColor();
			StdDraw.circle(width/1.72, height/1.19, 7);
		}
		if (idTerr==10)
		{
			StdDraw.setPenColor(couleur);
			StdDraw.filledCircle(width/1.875, height/1.168, 7);
			StdDraw.setPenColor();
			StdDraw.circle(width/1.875, height/1.168, 7);
		}
		if (idTerr==11)
		{
			StdDraw.setPenColor(couleur);
			StdDraw.filledCircle(width/3.5, height/1.5, 7);
			StdDraw.setPenColor();
			StdDraw.circle(width/3.5, height/1.5, 7);
		}
		
	}
	
	
	
	
	
}
