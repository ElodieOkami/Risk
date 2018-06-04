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
	public static int lectureClic(String cartePng) {
	    try {
	        BufferedImage image = ImageIO.read(new File(cartePng));    
	        Color couleur;
	        
	        Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
			int height = (int)dimension.getHeight();
			int width  = (int)dimension.getWidth();
			
	        if(StdDraw.isMousePressed())
	        		{        			
	        			/*double RapportE = (double)width/height;
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
	        	        }		*/ //A travailler pour le rescale
	        	        
	        	        int clickX=(int) StdDraw.mouseX();
	        			int clickY=(int) StdDraw.mouseY()-clicTropBas;
	        			
	        			clickX = clickX-((width-image.getWidth())/2);
	        			clickY = clickY-((height-image.getHeight())/2);
	        			
	        			/*double multiX = scaleX/width;
	        			double multiY = scaleY/height;
	        			clickX = (int)(clickX*multiX);
	        			clickY = (int)(clickY*multiY);*/ //A travailler pour le rescale
	        			
	        			
	        			couleur = new Color(image.getRGB(clickX, image.getHeight()-clickY));
	        			
	        			System.out.println("R = " + couleur.getRed());
	        			System.out.println("G = " + couleur.getGreen());
	        			System.out.println("B = " + couleur.getBlue());
	        			return correspondClic(cartePng, couleur);
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
	    return -1;
	}
	
	private static int correspondClic(String cartePng, Color couleur)
	{
		if (cartePng == "plateauElder.png")
		{
			int tabCoul[][] = creaTableauCouleurs(cartePng);
			
			int R = couleur.getRed();
			int G = couleur.getGreen();
			int B = couleur.getBlue();
			
			if (R == 255 && G == 255 && B == 255)
			{
				System.out.println("Veuillez cliquez sur un des 42 territoires en couleurs");
				return -1;
			}
			
			else if (R == 168 && G == 168 && B == 168)
			{
				System.out.println("Cette zone est non habitable");
				return -2;
			}
			
			else
			{
				for (int i = 0; i<tabCoul.length; i++)
				{
					if (tabCoul[i][0] == R && tabCoul[i][1] == G && tabCoul[i][2] == B)
					{
						System.out.println("Vous cliquez sur le territoire " + i);
						return i;
					}
				}
				System.out.println("Erreur, veuillez ré-essayer de cliquer sur un territoire");
			}
			return -3;
		}
		
		return -4;
		
	}
	
	public static int[][] creaTableauCouleurs(String cartePng)
	{
		
		if (cartePng == "plateauElder.png")
		{
					int[][] tabCoul = {
					{255, 197, 218}, {212, 181, 192}, {198, 134, 157},
					{161, 121, 135}, {224, 116, 154}, {169, 89, 117},
					{154, 48, 85},   {207, 49, 104},  {125, 6, 48},
					{66, 23, 38},    {106, 44, 66},
					
					{206, 221, 161}, {168, 185, 117}, {126, 143, 74},
					{153, 160, 131}, {166, 196, 76},
				
					{236, 175, 175}, {225, 122 ,122}, {184, 61, 61},
					{138, 79, 79},   {87, 0, 0},      {78, 40, 40},
					{144, 0, 0},     {209, 11, 11},
				
					{126, 131, 180}, {45, 52, 133},   {70, 73, 119},
				
					{126, 169, 180}, {49, 151, 177}, {67, 114, 126},
					{16, 83, 100},   {119, 206, 227},
				
					{64, 82, 78},    {95, 122, 116},  {27, 113, 94},
					{42, 169, 141},  {133, 171, 163}, {165, 213, 203},
					{52, 210, 175},  {190, 255, 241}, {15, 65, 54},
					{0, 255, 199}
					};
					return tabCoul;
		}
		else
		{
			
		}
		int[][] tabVide = new int[2][3];
		return tabVide;
	}	
	
	
}
