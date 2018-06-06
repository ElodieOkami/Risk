import edu.princeton.cs.introcs.StdDraw;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.awt.Color;
import java.awt.Dimension;

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
				
		StdDraw.text(width/2, height/1.3, "Choix de la carte :");
		
		font = new Font("Times New Roman", Font.PLAIN, 30);		//En plus petit et pas en gras
		StdDraw.setFont(font);
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
	
	public static void afficheInfosIni(String cartePng, int nbrJoueur)
	{		
		if(cartePng == "plateauElder.png")
		{
			StdDraw.picture(width/9.5, height/1.17, "infosTer.png");
			Font font = new Font("Papyrus",Font.ITALIC, 15);
			StdDraw.setFont(font);
			StdDraw.text(width/9.5, height/1.15, "Cliquez sur vos territoires pour");
			StdDraw.text(width/9.5, height/1.20, "placer vos armées non placées");
			
			StdDraw.picture(width/1.1, height/2, "infosJoueur.png");
			font = new Font("Papyrus", Font.BOLD, 20);		//En plus petit et pas en gras
			StdDraw.setFont(font);
			StdDraw.text(width/1.1, height/1.35 , " Au tour du");
			StdDraw.picture(width/1.1, height/1.49, "playerBlue.png");
			StdDraw.text(width/1.1, height/1.6 , "Joueur 1");
			StdDraw.show();
		}
	}
	
	public static void affichePointProprio(int idTerr, Color couleur)
	{
		if (idTerr==0)
		{
			StdDraw.setPenColor(couleur);
			StdDraw.filledCircle(width/3.3, height/1.18, 6);
			StdDraw.setPenColor();
			StdDraw.circle(width/3.3, height/1.18, 6);
		}
		if (idTerr==1)
		{
			StdDraw.setPenColor(couleur);
			StdDraw.filledCircle(width/2.45, height/1.18, 6);
			StdDraw.setPenColor();
			StdDraw.circle(width/2.45, height/1.18, 6);
		}
		if (idTerr==2)
		{
			StdDraw.setPenColor(couleur);
			StdDraw.filledCircle(width/2.21, height/1.27, 6);
			StdDraw.setPenColor();
			StdDraw.circle(width/2.21, height/1.27, 6);
		}
		if (idTerr==3)
		{
			StdDraw.setPenColor(couleur);
			StdDraw.filledCircle(width/2.17, height/1.13, 6);
			StdDraw.setPenColor();
			StdDraw.circle(width/2.17, height/1.13, 6);
		}
		if (idTerr==4)
		{
			StdDraw.setPenColor(couleur);
			StdDraw.filledCircle(width/2.03, height/1.385, 6);
			StdDraw.setPenColor();
			StdDraw.circle(width/2.03, height/1.385, 6);
		}
		if (idTerr==5)
		{
			StdDraw.setPenColor(couleur);
			StdDraw.filledCircle(width/1.83, height/1.288, 6);
			StdDraw.setPenColor();
			StdDraw.circle(width/1.83, height/1.288, 6);
		}
		if (idTerr==6)
		{
			StdDraw.setPenColor(couleur);
			StdDraw.filledCircle(width/1.83, height/1.38, 6);
			StdDraw.setPenColor();
			StdDraw.circle(width/1.83, height/1.38, 6);
		}
		if (idTerr==7)
		{
			StdDraw.setPenColor(couleur);
			StdDraw.filledCircle(width/1.68, height/1.39, 6);
			StdDraw.setPenColor();
			StdDraw.circle(width/1.68, height/1.39, 6);
		}
		if (idTerr==8)
		{
			StdDraw.setPenColor(couleur);
			StdDraw.filledCircle(width/1.71, height/1.277, 6);
			StdDraw.setPenColor();
			StdDraw.circle(width/1.71, height/1.277, 6);
		}
		if (idTerr==9)
		{
			StdDraw.setPenColor(couleur);
			StdDraw.filledCircle(width/1.72, height/1.19, 6);
			StdDraw.setPenColor();
			StdDraw.circle(width/1.72, height/1.19, 6);
		}
		if (idTerr==10)
		{
			StdDraw.setPenColor(couleur);
			StdDraw.filledCircle(width/1.875, height/1.168, 6);
			StdDraw.setPenColor();
			StdDraw.circle(width/1.875, height/1.168, 6);
		}
		if (idTerr==11)
		{
			StdDraw.setPenColor(couleur);
			StdDraw.filledCircle(width/3.845, height/1.58, 6);
			StdDraw.setPenColor();
			StdDraw.circle(width/3.845, height/1.58, 6);
		}
		if (idTerr==12)
		{
			StdDraw.setPenColor(couleur);
			StdDraw.filledCircle(width/3.12, height/1.42, 6);
			StdDraw.setPenColor();
			StdDraw.circle(width/3.12, height/1.42, 6);
		}
		if (idTerr==13)
		{
			StdDraw.setPenColor(couleur);
			StdDraw.filledCircle(width/2.57, height/1.31, 6);
			StdDraw.setPenColor();
			StdDraw.circle(width/2.57, height/1.31, 6);
		}
		if (idTerr==14)
		{
			StdDraw.setPenColor(couleur);
			StdDraw.filledCircle(width/2.175, height/1.59, 6);
			StdDraw.setPenColor();
			StdDraw.circle(width/2.175, height/1.59, 6);
		}
		if (idTerr==15)
		{
			StdDraw.setPenColor(couleur);
			StdDraw.filledCircle(width/2.31, height/1.77, 6);
			StdDraw.setPenColor();
			StdDraw.circle(width/2.31, height/1.77, 6);
		}
		if (idTerr==16)
		{
			StdDraw.setPenColor(couleur);
			StdDraw.filledCircle(width/2.37, height/1.99, 6);
			StdDraw.setPenColor();
			StdDraw.circle(width/2.37, height/1.99, 6);
		}
		if (idTerr==17)
		{
			StdDraw.setPenColor(couleur);
			StdDraw.filledCircle(width/2, height/1.95, 6);
			StdDraw.setPenColor();
			StdDraw.circle(width/2, height/1.95, 6);
		}
		if (idTerr==18)
		{
			StdDraw.setPenColor(couleur);
			StdDraw.filledCircle(width/1.92, height/1.52, 6);
			StdDraw.setPenColor();
			StdDraw.circle(width/1.92, height/1.52, 6);
		}
		if (idTerr==19)
		{
			StdDraw.setPenColor(couleur);
			StdDraw.filledCircle(width/1.665, height/1.575, 6);
			StdDraw.setPenColor();
			StdDraw.circle(width/1.665, height/1.575, 6);
		}
		if (idTerr==20)
		{
			StdDraw.setPenColor(couleur);
			StdDraw.filledCircle(width/1.6, height/1.85, 6);
			StdDraw.setPenColor();
			StdDraw.circle(width/1.6, height/1.85, 6);
		}
		if (idTerr==21)
		{
			StdDraw.setPenColor(couleur);
			StdDraw.filledCircle(width/1.53, height/2.55, 6);
			StdDraw.setPenColor();
			StdDraw.circle(width/1.53, height/2.55, 6);
		}
		if (idTerr==22)
		{
			StdDraw.setPenColor(couleur);
			StdDraw.filledCircle(width/1.823, height/2.2, 6);
			StdDraw.setPenColor();
			StdDraw.circle(width/1.823, height/2.2, 6);
		}
		if (idTerr==23)
		{
			StdDraw.setPenColor(couleur);
			StdDraw.filledCircle(width/1.825, height/1.9, 6);
			StdDraw.setPenColor();
			StdDraw.circle(width/1.825, height/1.9, 6);
		}
		if (idTerr==24)
		{
			StdDraw.setPenColor(couleur);
			StdDraw.filledCircle(width/3.75, height/4.8, 6);
			StdDraw.setPenColor();
			StdDraw.circle(width/3.75, height/4.8, 6);
		}
		if (idTerr==25)
		{
			StdDraw.setPenColor(couleur);
			StdDraw.filledCircle(width/4.15, height/3.2, 6);
			StdDraw.setPenColor();
			StdDraw.circle(width/4.15, height/3.2, 6);
		}
		if (idTerr==26)
		{
			StdDraw.setPenColor(couleur);
			StdDraw.filledCircle(width/3.65, height/3.02, 6);
			StdDraw.setPenColor();
			StdDraw.circle(width/3.65, height/3.02, 6);
		}
		if (idTerr==27)
		{
			StdDraw.setPenColor(couleur);
			StdDraw.filledCircle(width/2.1, height/2.55, 6);
			StdDraw.setPenColor();
			StdDraw.circle(width/2.1, height/2.55, 6);
		}
		if (idTerr==28)
		{
			StdDraw.setPenColor(couleur);
			StdDraw.filledCircle(width/2.16, height/3.3, 6);
			StdDraw.setPenColor();
			StdDraw.circle(width/2.16, height/3.3, 6);
		}
		if (idTerr==29)
		{
			StdDraw.setPenColor(couleur);
			StdDraw.filledCircle(width/1.98, height/2.6, 6);
			StdDraw.setPenColor();
			StdDraw.circle(width/1.98, height/2.6, 6);
		}
		if (idTerr==30)
		{
			StdDraw.setPenColor(couleur);
			StdDraw.filledCircle(width/1.78, height/3.9, 6);
			StdDraw.setPenColor();
			StdDraw.circle(width/1.78, height/3.9, 6);
		}
		if (idTerr==31)
		{
			StdDraw.setPenColor(couleur);
			StdDraw.filledCircle(width/1.77, height/2.87, 6);
			StdDraw.setPenColor();
			StdDraw.circle(width/1.77, height/2.87, 6);
		}
		if (idTerr==32)
		{
			StdDraw.setPenColor(couleur);
			StdDraw.filledCircle(width/1.63, height/1.21, 6);
			StdDraw.setPenColor();
			StdDraw.circle(width/1.63, height/1.21, 6);
		}
		if (idTerr==33)
		{
			StdDraw.setPenColor(couleur);
			StdDraw.filledCircle(width/1.463, height/1.78, 6);
			StdDraw.setPenColor();
			StdDraw.circle(width/1.463, height/1.78, 6);
		}
		if (idTerr==34)
		{
			StdDraw.setPenColor(couleur);
			StdDraw.filledCircle(width/1.285, height/1.275, 6);
			StdDraw.setPenColor();
			StdDraw.circle(width/1.285, height/1.275, 6);
		}
		if (idTerr==35)
		{
			StdDraw.setPenColor(couleur);
			StdDraw.filledCircle(width/1.335, height/2.57, 6);
			StdDraw.setPenColor();
			StdDraw.circle(width/1.335, height/2.57, 6);
		}
		if (idTerr==36)
		{
			StdDraw.setPenColor(couleur);
			StdDraw.filledCircle(width/1.425, height/2.57, 6);
			StdDraw.setPenColor();
			StdDraw.circle(width/1.425, height/2.57, 6);
		}
		if (idTerr==37)
		{
			StdDraw.setPenColor(couleur);
			StdDraw.filledCircle(width/1.47, height/4.6, 6);
			StdDraw.setPenColor();
			StdDraw.circle(width/1.47, height/4.6, 6);
		}
		if (idTerr==38)
		{
			StdDraw.setPenColor(couleur);
			StdDraw.filledCircle(width/1.35, height/6, 6);
			StdDraw.setPenColor();
			StdDraw.circle(width/1.35, height/6, 6);
		}
		if (idTerr==39)
		{
			StdDraw.setPenColor(couleur);
			StdDraw.filledCircle(width/1.47, height/7, 6);
			StdDraw.setPenColor();
			StdDraw.circle(width/1.47, height/7, 6);
		}
		if (idTerr==40)
		{
			StdDraw.setPenColor(couleur);
			StdDraw.filledCircle(width/1.215, height/1.183, 6);
			StdDraw.setPenColor();
			StdDraw.circle(width/1.215, height/1.183, 6);
		}
		if (idTerr==41)
		{
			StdDraw.setPenColor(couleur);
			StdDraw.filledCircle(width/1.355, height/1.135, 6);
			StdDraw.setPenColor();
			StdDraw.circle(width/1.355, height/1.135, 6);
		}
	}

}