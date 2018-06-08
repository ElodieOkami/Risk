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
	
	public static void affichePointProprio(int idTerr, Color couleur, String cartePng)
	{
		int[] nbrArmees = RiskIsep.nbrArmeesTot();
		Font font = new Font("Arial",Font.PLAIN, 16);
		if (idTerr==0)
		{
			StdDraw.setPenColor(couleur);
			StdDraw.filledCircle(width/3.3, height/1.18, 6);
			StdDraw.setPenColor();
			StdDraw.circle(width/3.3, height/1.18, 6);
			StdDraw.setFont(font);
			StdDraw.text(width/3.9, height/1.3, "" +  nbrArmees[0]);
		}
		if (idTerr==1)
		{
			StdDraw.setPenColor(couleur);
			StdDraw.filledCircle(width/2.45, height/1.18, 6);
			StdDraw.setPenColor();
			StdDraw.circle(width/2.45, height/1.18, 6);
			StdDraw.setFont(font);
			StdDraw.text(width/2.9, height/1.3, "" +  nbrArmees[1]);
		}
		if (idTerr==2)
		{
			StdDraw.setPenColor(couleur);
			StdDraw.filledCircle(width/2.21, height/1.27, 6);
			StdDraw.setPenColor();
			StdDraw.circle(width/2.21, height/1.27, 6);
			StdDraw.setFont(font);
			StdDraw.text(width/2.32, height/1.3, "" +  nbrArmees[2]);
			
		}
		if (idTerr==3)
		{
			StdDraw.setPenColor(couleur);
			StdDraw.filledCircle(width/2.17, height/1.13, 6);
			StdDraw.setPenColor();
			StdDraw.circle(width/2.17, height/1.13, 6);
			StdDraw.setFont(font);
			StdDraw.text(width/2.19, height/1.22, "" +  nbrArmees[3]);
		}
		if (idTerr==4)
		{
			StdDraw.setPenColor(couleur);
			StdDraw.filledCircle(width/2.03, height/1.385, 6);
			StdDraw.setPenColor();
			StdDraw.circle(width/2.03, height/1.385, 6);
			StdDraw.setFont(font);
			StdDraw.text(width/2.1, height/1.43, "" +  nbrArmees[4]);
		}
		if (idTerr==5)
		{
			StdDraw.setPenColor(couleur);
			StdDraw.filledCircle(width/1.83, height/1.288, 6);
			StdDraw.setPenColor();
			StdDraw.circle(width/1.83, height/1.288, 6);
			StdDraw.setFont(font);
			StdDraw.text(width/1.95, height/1.320, "" +  nbrArmees[5]);
		}
		if (idTerr==6)
		{
			StdDraw.setPenColor(couleur);
			StdDraw.filledCircle(width/1.83, height/1.38, 6);
			StdDraw.setPenColor();
			StdDraw.circle(width/1.83, height/1.38, 6);
			StdDraw.setFont(font);
			StdDraw.text(width/1.9, height/1.43, "" +  nbrArmees[6]);
		}
		if (idTerr==7)
		{
			StdDraw.setPenColor(couleur);
			StdDraw.filledCircle(width/1.68, height/1.39, 6);
			StdDraw.setPenColor();
			StdDraw.circle(width/1.68, height/1.39, 6);
			StdDraw.setFont(font);
			StdDraw.text(width/1.73, height/1.45, "" +  nbrArmees[7]);
		}
		if (idTerr==8)
		{
			StdDraw.setPenColor(couleur);
			StdDraw.filledCircle(width/1.71, height/1.277, 6);
			StdDraw.setPenColor();
			StdDraw.circle(width/1.71, height/1.277, 6);
			StdDraw.setFont(font);
			StdDraw.text(width/1.74, height/1.32, "" +  nbrArmees[8]);
		}
		if (idTerr==9)
		{
			StdDraw.setPenColor(couleur);
			StdDraw.filledCircle(width/1.72, height/1.19, 6);
			StdDraw.setPenColor();
			StdDraw.circle(width/1.72, height/1.19, 6);
			StdDraw.setFont(font);
			StdDraw.text(width/1.78, height/1.22, "" +  nbrArmees[9]);
		}
		if (idTerr==10)
		{
			StdDraw.setPenColor(couleur);
			StdDraw.filledCircle(width/1.875, height/1.168, 6);
			StdDraw.setPenColor();
			StdDraw.circle(width/1.875, height/1.168, 6);
			StdDraw.setFont(font);
			StdDraw.text(width/1.92, height/1.22, "" +  nbrArmees[10]);
		}
		if (idTerr==11)
		{
			StdDraw.setPenColor(couleur);
			StdDraw.filledCircle(width/3.845, height/1.58, 6);
			StdDraw.setPenColor();
			StdDraw.circle(width/3.845, height/1.58, 6);
			StdDraw.setFont(font);
			StdDraw.text(width/4.2, height/1.77, "" +  nbrArmees[11]);
		}
		if (idTerr==12)
		{
			StdDraw.setPenColor(couleur);
			StdDraw.filledCircle(width/3.12, height/1.42, 6);
			StdDraw.setPenColor();
			StdDraw.circle(width/3.12, height/1.42, 6);
			StdDraw.setFont(font);
			StdDraw.text(width/3.3, height/1.65, "" +  nbrArmees[12]);
		}
		if (idTerr==13)
		{
			StdDraw.setPenColor(couleur);
			StdDraw.filledCircle(width/2.57, height/1.31, 6);
			StdDraw.setPenColor();
			StdDraw.circle(width/2.57, height/1.31, 6);
			StdDraw.setFont(font);
			StdDraw.text(width/2.57, height/1.45, "" +  nbrArmees[13]);
		}
		if (idTerr==14)
		{
			StdDraw.setPenColor(couleur);
			StdDraw.filledCircle(width/2.175, height/1.59, 6);
			StdDraw.setPenColor();
			StdDraw.circle(width/2.175, height/1.59, 6);
			StdDraw.setFont(font);
			StdDraw.text(width/2.37, height/1.67, "" +  nbrArmees[14]);
		}
		if (idTerr==15)
		{
			StdDraw.setPenColor(couleur);
			StdDraw.filledCircle(width/2.31, height/1.77, 6);
			StdDraw.setPenColor();
			StdDraw.circle(width/2.31, height/1.77, 6);
			StdDraw.setFont(font);
			StdDraw.text(width/2.55, height/1.92, "" +  nbrArmees[15]);
		}
		if (idTerr==16)
		{
			StdDraw.setPenColor(couleur);
			StdDraw.filledCircle(width/2.37, height/1.99, 6);
			StdDraw.setPenColor();
			StdDraw.circle(width/2.37, height/1.99, 6);
			StdDraw.setFont(font);
			StdDraw.text(width/2.45, height/2.23, "" +  nbrArmees[16]);
		}
		if (idTerr==17)
		{
			StdDraw.setPenColor(couleur);
			StdDraw.filledCircle(width/2, height/1.95, 6);
			StdDraw.setPenColor();
			StdDraw.circle(width/2, height/1.95, 6);
			StdDraw.setFont(font);
			StdDraw.text(width/2.1, height/2.16, "" +  nbrArmees[17]);
		}
		if (idTerr==18)
		{
			StdDraw.setPenColor(couleur);
			StdDraw.filledCircle(width/1.92, height/1.52, 6);
			StdDraw.setPenColor();
			StdDraw.circle(width/1.92, height/1.52, 6);
			StdDraw.setFont(font);
			StdDraw.text(width/2.02, height/1.68, "" +  nbrArmees[18]);
		}
		if (idTerr==19)
		{
			StdDraw.setPenColor(couleur);
			StdDraw.filledCircle(width/1.665, height/1.575, 6);
			StdDraw.setPenColor();
			StdDraw.circle(width/1.665, height/1.575, 6);
			StdDraw.setFont(font);
			StdDraw.text(width/1.73, height/1.7, "" +  nbrArmees[19]);
		}
		if (idTerr==20)
		{
			StdDraw.setPenColor(couleur);
			StdDraw.filledCircle(width/1.6, height/1.85, 6);
			StdDraw.setPenColor();
			StdDraw.circle(width/1.6, height/1.85, 6);
			StdDraw.setFont(font);
			StdDraw.text(width/1.63, height/2.1, "" +  nbrArmees[20]);
		}
		if (idTerr==21)
		{
			StdDraw.setPenColor(couleur);
			StdDraw.filledCircle(width/1.53, height/2.55, 6);
			StdDraw.setPenColor();
			StdDraw.circle(width/1.53, height/2.55, 6);
			StdDraw.setFont(font);
			StdDraw.text(width/1.61, height/3, "" +  nbrArmees[21]);
		}
		if (idTerr==22)
		{
			StdDraw.setPenColor(couleur);
			StdDraw.filledCircle(width/1.823, height/2.2, 6);
			StdDraw.setPenColor();
			StdDraw.circle(width/1.823, height/2.2, 6);
			StdDraw.setFont(font);
			StdDraw.text(width/1.84, height/2.4, "" +  nbrArmees[22]);
		}
		if (idTerr==23)
		{
			StdDraw.setPenColor(couleur);
			StdDraw.filledCircle(width/1.825, height/1.9, 6);
			StdDraw.setPenColor();
			StdDraw.circle(width/1.825, height/1.9, 6);StdDraw.setFont(font);
			StdDraw.text(width/1.86, height/1.93, "" +  nbrArmees[23]);
		}
		if (idTerr==24)
		{
			StdDraw.setPenColor(couleur);
			StdDraw.filledCircle(width/3.75, height/4.8, 6);
			StdDraw.setPenColor();
			StdDraw.circle(width/3.75, height/4.8, 6);
			StdDraw.setFont(font);
			StdDraw.text(width/4.1, height/6.5, "" +  nbrArmees[24]);
		}
		if (idTerr==25)
		{
			StdDraw.setPenColor(couleur);
			StdDraw.filledCircle(width/4.15, height/3.2, 6);
			StdDraw.setPenColor();
			StdDraw.circle(width/4.15, height/3.2, 6);
			StdDraw.setFont(font);
			StdDraw.text(width/4.1, height/3.9, "" +  nbrArmees[25]);
		}
		if (idTerr==26)
		{
			StdDraw.setPenColor(couleur);
			StdDraw.filledCircle(width/3.65, height/3.02, 6);
			StdDraw.setPenColor();
			StdDraw.circle(width/3.65, height/3.02, 6);
			StdDraw.setFont(font);
			StdDraw.text(width/3.25, height/4.6, "" +  nbrArmees[26]);
		}
		if (idTerr==27)
		{
			StdDraw.setPenColor(couleur);
			StdDraw.filledCircle(width/2.1, height/2.55, 6);
			StdDraw.setPenColor();
			StdDraw.circle(width/2.1, height/2.55, 6);
			StdDraw.setFont(font);
			StdDraw.text(width/2.4, height/3.3, "" +  nbrArmees[27]);
		}
		if (idTerr==28)
		{
			StdDraw.setPenColor(couleur);
			StdDraw.filledCircle(width/2.16, height/3.3, 6);
			StdDraw.setPenColor();
			StdDraw.circle(width/2.16, height/3.3, 6);
			StdDraw.setFont(font);
			StdDraw.text(width/2.25, height/4.3, "" +  nbrArmees[28]);
		}
		if (idTerr==29)
		{
			StdDraw.setPenColor(couleur);
			StdDraw.filledCircle(width/1.98, height/2.6, 6);
			StdDraw.setPenColor();
			StdDraw.circle(width/1.98, height/2.6, 6);
			StdDraw.setFont(font);
			StdDraw.text(width/2.05, height/3.2, "" +  nbrArmees[29]);
		}
		if (idTerr==30)
		{
			StdDraw.setPenColor(couleur);
			StdDraw.filledCircle(width/1.78, height/3.9, 6);
			StdDraw.setPenColor();
			StdDraw.circle(width/1.78, height/3.9, 6);
			StdDraw.setFont(font);
			StdDraw.text(width/1.9, height/5.1, "" +  nbrArmees[30]);
		}
		if (idTerr==31)
		{
			StdDraw.setPenColor(couleur);
			StdDraw.filledCircle(width/1.77, height/2.87, 6);
			StdDraw.setPenColor();
			StdDraw.circle(width/1.77, height/2.87, 6);
			StdDraw.setFont(font);
			StdDraw.text(width/1.85, height/3.2, "" +  nbrArmees[31]);
		}
		if (idTerr==32)
		{
			StdDraw.setPenColor(couleur);
			StdDraw.filledCircle(width/1.63, height/1.21, 6);
			StdDraw.setPenColor();
			StdDraw.circle(width/1.63, height/1.21, 6);
			StdDraw.setFont(font);
			StdDraw.text(width/1.6, height/1.45, "" +  nbrArmees[32]);
		}
		if (idTerr==33)
		{
			StdDraw.setPenColor(couleur);
			StdDraw.filledCircle(width/1.463, height/1.78, 6);
			StdDraw.setPenColor();
			StdDraw.circle(width/1.463, height/1.78, 6);
			StdDraw.setFont(font);
			StdDraw.text(width/1.43, height/2.2, "" +  nbrArmees[33]);
		}
		if (idTerr==34)
		{
			StdDraw.setPenColor(couleur);
			StdDraw.filledCircle(width/1.285, height/1.275, 6);
			StdDraw.setPenColor();
			StdDraw.circle(width/1.285, height/1.275, 6);
			StdDraw.setFont(font);
			StdDraw.text(width/1.305, height/1.7, "" +  nbrArmees[34]);
		}
		if (idTerr==35)
		{
			StdDraw.setPenColor(couleur);
			StdDraw.filledCircle(width/1.335, height/2.57, 6);
			StdDraw.setPenColor();
			StdDraw.circle(width/1.335, height/2.57, 6);
			StdDraw.setFont(font);
			StdDraw.text(width/1.38, height/3.2, "" +  nbrArmees[35]);
		}
		if (idTerr==36)
		{
			StdDraw.setPenColor(couleur);
			StdDraw.filledCircle(width/1.425, height/2.57, 6);
			StdDraw.setPenColor();
			StdDraw.circle(width/1.425, height/2.57, 6);
			StdDraw.setFont(font);
			StdDraw.text(width/1.49, height/3.2, "" +  nbrArmees[36]);
		}
		if (idTerr==37)
		{
			StdDraw.setPenColor(couleur);
			StdDraw.filledCircle(width/1.47, height/4.6, 6);
			StdDraw.setPenColor();
			StdDraw.circle(width/1.47, height/4.6, 6);
			StdDraw.setFont(font);
			StdDraw.text(width/1.49, height/5, "" +  nbrArmees[37]);
		}
		if (idTerr==38)
		{
			StdDraw.setPenColor(couleur);
			StdDraw.filledCircle(width/1.35, height/6, 6);
			StdDraw.setPenColor();
			StdDraw.circle(width/1.35, height/6, 6);
			StdDraw.setFont(font);
			StdDraw.text(width/1.4, height/6.3, "" +  nbrArmees[38]);
		}
		if (idTerr==39)
		{
			StdDraw.setPenColor(couleur);
			StdDraw.filledCircle(width/1.47, height/7, 6);
			StdDraw.setPenColor();
			StdDraw.circle(width/1.47, height/7, 6);
			StdDraw.setFont(font);
			StdDraw.text(width/1.53, height/7.6, "" +  nbrArmees[39]);
		}
		if (idTerr==40)
		{
			StdDraw.setPenColor(couleur);
			StdDraw.filledCircle(width/1.215, height/1.183, 6);
			StdDraw.setPenColor();
			StdDraw.circle(width/1.215, height/1.183, 6);
			StdDraw.setFont(font);
			StdDraw.text(width/1.25, height/1.2, "" +  nbrArmees[40]);
		}
		if (idTerr==41)
		{
			StdDraw.setPenColor(couleur);
			StdDraw.filledCircle(width/1.355, height/1.135, 6);
			StdDraw.setPenColor();
			StdDraw.circle(width/1.355, height/1.135, 6);
			StdDraw.setFont(font);
			StdDraw.text(width/1.4, height/1.15, "" +  nbrArmees[41]);
		}
	}
	
	public static void actualiserInfoRenforts(String cartePng, int idJoueur, int renforts)
	{
		afficheInfosJoueur(cartePng, idJoueur+1, renforts);
		afficheInfosRenforts(cartePng, idJoueur, renforts);
	
	}
	
	public static void actualiserTout(String cartePng)
	{
		StdDraw.clear();
		StdDraw.picture(width/2, height/2, cartePng);
		RiskIsep.PossesseurTerris(cartePng);
	}
	
	public static void afficheMessages(String info, int nbr)
	{
		if (info == "couleur")
		{
			Font font = new Font("Papyrus",Font.PLAIN, 16);
			StdDraw.setFont(font);
			StdDraw.text(width/9.5, height/1.15, "Veuillez cliquez sur un ");
			StdDraw.text(width/9.5, height/1.20, "des territoires en couleurs");
			StdDraw.show(1500);
		}
		
		else if (info == "inhabitable")
		{
			Font font = new Font("Papyrus",Font.PLAIN, 16);
			StdDraw.setFont(font);
			StdDraw.text(width/9.5, height/1.15, "Cette zone est non habitable ");
			StdDraw.show(1500);
		}
		
		else if (info == "erreur")
		{
			Font font = new Font("Papyrus",Font.PLAIN, 16);
			StdDraw.setFont(font);
			StdDraw.text(width/9.5, height/1.15, "Erreur, veuillez ré-essayer");
			StdDraw.text(width/9.5, height/1.20, "de cliquer sur un territoire");	
			StdDraw.show(1500);
		}
				
		else if (info == "renfort")
		{
			Font font = new Font("Papyrus",Font.PLAIN, 16);
			StdDraw.setFont(font);
			StdDraw.text(width/9.5, height/1.15, "Vous n'avez pas assez de renforts");
			//StdDraw.text(width/9.5, height/1.20, "un de vos territoires");	
			StdDraw.show(1500);
		}
		
		else if (info == "bouton")
		{
			Font font = new Font("Papyrus",Font.PLAIN, 16);
			StdDraw.setFont(font);
			StdDraw.text(width/9.5, height/1.15, "Veuillez recliquer sur un bouton");
			//StdDraw.text(width/9.5, height/1.20, "un de vos territoires");	
			StdDraw.show(1500);
		}
		
		else if (info == "fatigue")
		{
			Font font = new Font("Papyrus",Font.PLAIN, 16);
			StdDraw.setFont(font);
			StdDraw.text(width/9.5, height/1.15, "Ce déplacement a fatigué une ou plusieurs unités ");
			StdDraw.text(width/9.5, height/1.20, "elles ne peuvent plus bouger pendant ce tour");	
			StdDraw.show(2000);
		}
		
		else if (info == "soldats")
		{
			Font font = new Font("Papyrus",Font.PLAIN, 16);
			StdDraw.setFont(font);
			StdDraw.text(width/9.5, height/1.15, "Ce déplacement a fatigué" + nbr + "soldats, ");
			StdDraw.text(width/9.5, height/1.20, "il ne peut plus bouger pendant ce tour");	
			StdDraw.show(2000);
		}
		
		else if (info == "magicien")
		{
			Font font = new Font("Papyrus",Font.PLAIN, 16);
			StdDraw.setFont(font);
			StdDraw.text(width/9.5, height/1.15, "Ce déplacement a fatigué"+ nbr + "magicien, ");
			StdDraw.text(width/9.5, height/1.20, "il ne peut plus bouger pendant ce tour");	
			StdDraw.show(2000);
		}
		
		else if (info == "magiciens")
		{
			Font font = new Font("Papyrus",Font.PLAIN, 16);
			StdDraw.setFont(font);
			StdDraw.text(width/9.5, height/1.15, "Ce déplacement a fatigué"+ nbr + "magiciens, ");
			StdDraw.text(width/9.5, height/1.20, "il ne peut plus bouger pendant ce tour");	
			StdDraw.show(2000);
		}
		
		else if (info == "dragon")
		{
			Font font = new Font("Papyrus",Font.PLAIN, 16);
			StdDraw.setFont(font);
			StdDraw.text(width/9.5, height/1.15, "Ce déplacement a fatigué"+ nbr + "dragon, ");
			StdDraw.text(width/9.5, height/1.20, "il ne peut plus bouger pendant ce tour");	
			StdDraw.show(2000);
		}
		
		else if (info == "dragons")
		{
			Font font = new Font("Papyrus",Font.PLAIN, 16);
			StdDraw.setFont(font);
			StdDraw.text(width/9.5, height/1.15, "Ce déplacement a fatigué"+ nbr + "dragons, ");
			StdDraw.text(width/9.5, height/1.20, "il ne peut plus bouger pendant ce tour");	
			StdDraw.show(2000);
		}
		else if(info == "deplacerIni")
		{
			Font font = new Font("Papyrus",Font.PLAIN, 16);
			StdDraw.setFont(font);
			StdDraw.text(width/9.5, height/1.15, "Sélectionnez le territoire dont vous");
			StdDraw.text(width/9.5, height/1.20, "voulez déplacer des joueurs.");	
			StdDraw.show(1500);
		}
		else if(info == "selectTerrEtUnite")
		{
			Font font = new Font("Papyrus",Font.PLAIN, 16);
			StdDraw.setFont(font);
			StdDraw.text(width/9.5, height/1.15, "Sélectionnez les unités que vous souhaitez");
			StdDraw.text(width/9.5, height/1.20, "déplacer puis cliquez sur le Territoire cible.");	
			StdDraw.show(2000);
		}
		else if(info == "choixRenforts")
		{
			Font font = new Font("Papyrus",Font.PLAIN, 16);
			StdDraw.setFont(font);
			StdDraw.text(width/9.5, height/1.15, "Placez vos renforts avant d'effectuer d'autre actions.");
			StdDraw.text(width/9.5, height/1.20, "Sélectionnez les en bas à gauche puis placez-les.");	
			StdDraw.show(2000);
		}
		else if (info == "aucuneUnite")
		{
			Font font = new Font("Papyrus",Font.PLAIN, 16);
			StdDraw.setFont(font);
			StdDraw.text(width/9.5, height/1.15, "Vous n'avez pas séléctionné d'unités.");
			StdDraw.text(width/9.5, height/1.20, "Sélectionnez les en bas à gauche puis placez-les.");	
			StdDraw.show(2000);
		}
		else if (info == "caseParCase")
		{
			Font font = new Font("Papyrus",Font.PLAIN, 16);
			StdDraw.setFont(font);
			StdDraw.text(width/9.5, height/1.15, "Veuillez déplacer vos unités cases par cases.");
			StdDraw.show(2000);
		}
		else if (info == "terriEnnemi")
		{
			Font font = new Font("Papyrus",Font.PLAIN, 16);
			StdDraw.setFont(font);
			StdDraw.text(width/9.5, height/1.15, "Ce territoire ne vous appartient pas, utilisez ");
			StdDraw.text(width/9.5, height/1.20, "l'option Attaquer du menu pour l'attaquer.");
			StdDraw.show(2000);
		}
		else if (info == "pasToutDunCoup")
		{
			Font font = new Font("Papyrus",Font.PLAIN, 16);
			StdDraw.setFont(font);
			StdDraw.text(width/9.5, height/1.15, "Vous ne pouvez pas retirer toutes les unités");
			StdDraw.text(width/9.5, height/1.20, "d'un territoire. Il faut en laisser au moins une");
			StdDraw.show(2000);
		}
		else if (info == "tousFatigues")
		{
			Font font = new Font("Papyrus",Font.PLAIN, 16);
			StdDraw.setFont(font);
			StdDraw.text(width/9.5, height/1.15, "Toutes les unités de ce territoire sont fatigués.");
			StdDraw.text(width/9.5, height/1.20, "Elle ne peuvent plus bouger ni attaquer ce tour-ci.");
			StdDraw.show(2000);
		}
		else if (info == "attaquerIni")
		{
			Font font = new Font("Papyrus",Font.PLAIN, 16);
			StdDraw.setFont(font);
			StdDraw.text(width/9.5, height/1.15, "Veuillez sélectionner le territoire d'où");
			StdDraw.text(width/9.5, height/1.20, "vous voulez attaquer");
			StdDraw.show(2000);
		}
		else if (info == "selectTerrEtUnite2")
		{
			Font font = new Font("Papyrus",Font.PLAIN, 16);
			StdDraw.setFont(font);
			StdDraw.text(width/9.5, height/1.15, "Sélectionnez les unités partant en bataille et");
			StdDraw.text(width/9.5, height/1.20, "cliquez sur le territoire que vous voulez attaquer");
			StdDraw.show(2000);
		}
		else if (info == "attaqueVoisin")
		{
			Font font = new Font("Papyrus",Font.PLAIN, 16);
			StdDraw.setFont(font);
			StdDraw.text(width/9.5, height/1.15, "Veuillez attaquer un territoire voisin au vôtre");
			StdDraw.show(2000);
		}
		else if (info == "terriAllie")
		{
			Font font = new Font("Papyrus",Font.PLAIN, 16);
			StdDraw.setFont(font);
			StdDraw.text(width/9.5, height/1.15, "Ce territoire vous appartient, utilisez l'option");
			StdDraw.text(width/9.5, height/1.20, "Se deplacer du menu pour y envoyer des unités.");
			StdDraw.show(2000);
		}
		else if (info == "pasPlusDe3")
		{
			Font font = new Font("Papyrus",Font.PLAIN, 16);
			StdDraw.setFont(font);
			StdDraw.text(width/9.5, height/1.15, "Vous ne pouvez pas attaquer avec");
			StdDraw.text(width/9.5, height/1.20, "plus de 3 soldtats en même temps");
			StdDraw.show(2000);
		}
		
	}
	
	public static void afficheInfosTerritoires(String cartePng)
	{		
		StdDraw.picture(width/9.5, height/1.17, "infosTer.png");
		Font font = new Font("Papyrus",Font.PLAIN, 14);
		StdDraw.setFont(font);
		StdDraw.text(width/9.5, height/1.15, "Sélectionner un territoire");
		StdDraw.setFont(font);
		StdDraw.text(width/9.5, height/1.20, "pour afficher son nombre d'armées");	
		StdDraw.show();

		
		//Plateau.afficheInfos();
		//Plateau.afficheInfoJoueur();
		//Plateau.afficheInfosTerritoire();
	}
	
	public static void afficheInfosArmees(String cartePng)
	{
		int idTerri = Interface.lectureHover(cartePng);
		if (idTerri!=-1)
		{
			//StdDraw.clear();
			int[] tabNbrSoldat = RiskIsep.nbrSoldat();
			int[] tabNbrCavalier = RiskIsep.nbrCavalier();
			int[] tabNbrCanon = RiskIsep.nbrCanon();
			int nbrSoldat = tabNbrSoldat[idTerri];
			int nbrCavalier = tabNbrCavalier[idTerri];
			int nbrCanon = tabNbrCanon[idTerri];
			Font font = new Font("Papyrus",Font.PLAIN, 14);
			StdDraw.setFont(font);
			StdDraw.text(width/11, height/1.10, "Soldats : " + nbrSoldat );
			StdDraw.text(width/11, height/1.15, "Magiciens : " + nbrCavalier);
			StdDraw.text(width/11, height/1.20, "Dragons : " + nbrCanon);
		}
		StdDraw.show();
	}
	
	public static String playerToken(int numeroJoueur)
	{
		String token = "notoken";
		if(numeroJoueur == 1)
		{
			token = "playerBlue.png";
		}
		else if(numeroJoueur == 2)
		{
			token = "playerRed.png";
		}
		else if(numeroJoueur == 3)
		{
			token = "playerGreen.png";
		}
		else if(numeroJoueur == 4)
		{
			token = "playerYellow.png";
		}
		else if(numeroJoueur == 5)
		{
			token = "playerCyan.png";
		}
		
		else if(numeroJoueur == 6)
		{
			token = "playerMagenta.png";
		}
		return token;
	}
	
	public static void afficheInfosJoueurIni(String cartePng, int numeroJoueur, int soldatsRestants)
	{		
		if(cartePng == "plateauElder.png")
		{
			StdDraw.picture(width/9.5, height/1.17, "infosTer.png");
			StdDraw.picture(width/1.1, height/2, "infosJoueur.png");
			
			Font font = new Font("Papyrus", Font.BOLD, 20);
			StdDraw.setFont(font);
			StdDraw.text(width/1.1, height/1.35 , " Au tour du");
			StdDraw.picture(width/1.1, height/1.49, playerToken(numeroJoueur));
			StdDraw.text(width/1.1, height/1.6 , "Joueur " + numeroJoueur);
			
			font = new Font("Papyrus",Font.ITALIC, 13);
			StdDraw.setFont(font);
			StdDraw.text(width/1.1, height/1.70 , "Sur chacun de vos territoires");
			StdDraw.text(width/1.1, height/1.80, "on place 1 de vos soldats");
			StdDraw.text(width/1.1, height/1.95 , "Cliquez sur vos territoires pour");
			StdDraw.text(width/1.1, height/2.05 , "placer vos armées non placées");
			StdDraw.text(width/1.1, height/2.30, "Encore " + soldatsRestants + " soldats à placer");
			
		}
	}
	
	public static void afficheInfosJoueur(String cartePng, int numeroJoueur, int renforts)
	{
		if(cartePng == "plateauElder.png")
		{
			StdDraw.picture(width/1.1, height/2, "infosJoueur.png");
			StdDraw.picture(width/9.5, height/1.17, "infosTer.png");
			
			Font font = new Font("Papyrus", Font.BOLD, 20);	
			StdDraw.setFont(font);
			StdDraw.text(width/1.1, height/1.35 , " Au tour du");
			StdDraw.picture(width/1.1, height/1.49, playerToken(numeroJoueur));
			StdDraw.text(width/1.1, height/1.6 , "Joueur " + numeroJoueur);
			font = new Font("Papyrus", Font.BOLD, 14);		
			StdDraw.setFont(font);
			Joueur joueur = RiskIsep.listeJoueurs.get(numeroJoueur-1);
			//Infos
			StdDraw.text(width/1.1, height/1.75 , "Soldats : " + Tour.nombreSoldatJoueur(joueur));
			StdDraw.text(width/1.1, height/1.85, "Magiciens : " + Tour.nombreCavalierJoueur(joueur));
			StdDraw.text(width/1.1, height/1.95 , "Dragons : " + Tour.nombreCanonJoueur(joueur));
			StdDraw.text(width/1.1, height/2.05 , "Renforts : " + renforts);
		
			//Boutons
			StdDraw.text(width/1.1, height/2.4 , "Se déplacer");
			StdDraw.rectangle(width/1.1, height/2.4 , 50, 11);
			StdDraw.text(width/1.1, height/2.65 , "Attaquer");
			StdDraw.rectangle(width/1.1, height/2.67 , 50, 11);

			StdDraw.text(width/1.1, height/3.3 , "Fin de tour");
			StdDraw.rectangle(width/1.1, height/3.35 , 50, 11);
		}
	}
	
	public static void afficheInfosRenforts(String cartePng, int idJoueur, int renforts)
	{
		if(cartePng == "plateauElder.png")
		{
			Joueur joueur = RiskIsep.listeJoueurs.get(idJoueur);
			StdDraw.picture(width/10, height/3.4, "infosBoutons.png");
			Font font = new Font("Papyrus", Font.ITALIC, 13);	
			StdDraw.setFont(font);
			StdDraw.text(width/10, height/2.4 , "Renforts : " + renforts);
			StdDraw.text(width/10, height/2.6 , "Cliquez sur un bouton");
			StdDraw.text(width/10, height/2.75 , "puis sur un territoire");
			StdDraw.text(width/10, height/2.9,  "pour ajouter et placer");
			StdDraw.text(width/10, height/3.05,  "votre nouvelle armée");
			
			StdDraw.text(width/10, height/3.7,  "Soldat : 1");
			StdDraw.rectangle(width/10, height/3.7, 50, 11);
			StdDraw.text(width/10, height/4.45,  "Magicien : 3");
			StdDraw.rectangle(width/10, height/4.45, 50, 11);
			StdDraw.text(width/10, height/5.5,  "Dragon : 7");
			StdDraw.rectangle(width/10, height/5.5, 50, 11);
		}
	}
	
	public static void afficherBoutonPressed(int i)
	{
		if (i==1)
		{
			StdDraw.setPenColor(209,173,124);
			StdDraw.filledRectangle(width/10, height/3.7, 50, 11);
			StdDraw.setPenColor();
			StdDraw.text(width/10, height/3.7,  "Soldat : 1");
			StdDraw.rectangle(width/10, height/3.7, 50, 11);
		}
		if (i==2)
		{
			StdDraw.setPenColor(209,173,124);
			StdDraw.filledRectangle(width/10, height/4.45, 50, 11);
			StdDraw.setPenColor();
			StdDraw.text(width/10, height/4.45,  "Magicien : 3");
			StdDraw.rectangle(width/10, height/4.45, 50, 11);
		}
		if (i==3)
		{
			StdDraw.setPenColor(209,173,124);
			StdDraw.filledRectangle(width/10, height/5.5, 50, 11);
			StdDraw.setPenColor();
			StdDraw.text(width/10, height/5.5,  "Dragon : 7");
			StdDraw.rectangle(width/10, height/5.5, 50, 11);
		}
	}
	
	public static void afficheInfosAttaquer(String cartePng)
	{
		if(cartePng == "plateauElder.png")
		{
			StdDraw.picture(width/10, height/3.4, "infosBoutons.png");
			StdDraw.show();
		}
	}
	
	public static void afficheInfosSeDeplacer(String cartePng)
	{
		if(cartePng == "plateauElder.png")
		{
			StdDraw.picture(width/10, height/3.4, "infosBoutons.png");
			
			Font font = new Font("Papyrus", Font.ITALIC, 15);	
			StdDraw.setFont(font);
			StdDraw.text(width/10, height/2.4 , "Déplacements");
		
			StdDraw.text(width/13.8, height/3.0,  "Soldats :");
			StdDraw.text(width/9.9, height/3.0, "+");
			StdDraw.text(width/9, height/3.0, "-");
			StdDraw.text(width/13.8, height/3.4,  "Magiciens :");
			StdDraw.text(width/9.9, height/3.4, "+");
			StdDraw.text(width/9, height/3.4, "-");
			StdDraw.text(width/13.8, height/4.0,  "Dragons");
			StdDraw.text(width/9.9, height/4.0, "+");
			StdDraw.text(width/9, height/4.0, "-");
		}
	}
	public static void afficheInfosAttaquer2(String cartePng)
	{
		if(cartePng == "plateauElder.png")
		{
			StdDraw.picture(width/10, height/3.4, "infosBoutons.png");
			
			Font font = new Font("Papyrus", Font.ITALIC, 15);	
			StdDraw.setFont(font);
			StdDraw.text(width/10, height/2.4 , "Attaque");
		
			StdDraw.text(width/13.8, height/3.0,  "Soldats :");
			StdDraw.text(width/9.9, height/3.0, "+");
			StdDraw.text(width/9, height/3.0, "-");
			StdDraw.text(width/13.8, height/3.4,  "Magiciens :");
			StdDraw.text(width/9.9, height/3.4, "+");
			StdDraw.text(width/9, height/3.4, "-");
			StdDraw.text(width/13.8, height/4.0,  "Dragons");
			StdDraw.text(width/9.9, height/4.0, "+");
			StdDraw.text(width/9, height/4.0, "-");
		}
	}
	
	public static void afficheNbrSoldatsRenforts(int nombreSoldats)
	{
		StdDraw.text(width/8.1, height/3.0, " "+nombreSoldats);
	}
	
	public static void afficheNbrCavalsRenforts(int nombreCavals)
	{
		StdDraw.text(width/8.1, height/3.4, " "+nombreCavals);
	}
	
	public static void afficheNbrCanonsRenforts(int nombreCanons)
	{
		StdDraw.text(width/8.1, height/4.0, " "+nombreCanons);
	}

}	