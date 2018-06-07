import java.awt.Color;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.imageio.ImageIO;
import edu.princeton.cs.introcs.StdDraw;

//Class permettant de récupérer et analyser des informations selaon la position des clics

public class Interface {
	
	static Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();		//Permet d'avoir la largeur et la hauteur d'un écran
	final static int height = (int)dimension.getHeight();								//hauteur
    final static int width  = (int)dimension.getWidth();								//largeur
    public static double clickXBoutonRenf = width/10;			//valeur initiale pour renfort soldat
	public static double clickYBoutonRenf = height/3.4;			//pareil

	static final int clicTropBas = 20; //A cause de la barre en haut de la fenêtre, tous les clics sont trop bas
	
	//Interface 1er Menu (séléction du nombre de joueurs)
	public static int MenuJoueur() 			
	{
		Plateau.afficheMenuJoueur();		//Visuel
		if(StdDraw.isMousePressed())
		{
			double clickX=StdDraw.mouseX();
			double clickY=StdDraw.mouseY()-clicTropBas;		
			return nombreJoueurs(clickX, clickY);		//Quel nombre de joueur a été cliqué
		}
		return 0;
	}
	
	public static int nombreJoueurs(double clickX, double clickY) //Quel nombre de joueur a été cliqué
	{					
			if(height/1.5-20 < clickY && clickY < height/1.5+20) 
			{
				if (width/3.9-15 < clickX && clickX < width/3.9+15) 
				{
					return 2; //2 car un joueur et une IA
				}
				
				else if (width/2.8-15 < clickX && clickX < width/2.8+15) 
				{
					return 2;
				}
				
				else if (width/2.2-15 < clickX && clickX < width/2.2+15)
				{
					return 3;
				}
				
				else if (width/1.8-15 < clickX && clickX < width/1.8+15)
				{
					return 4;
				}
				
				else if (width/1.55-15 < clickX && clickX < width/1.55+15)
				{
					return 5;
				}
				
				else if (width/1.35-15 < clickX && clickX < width/1.35+15)
				{
					return 6;
				}
			}
		return 0;
	}
	
	
	//Interface 2ème Menu (séléction de la carte)
	public static String MenuCarte() 
	{
		Plateau.afficheMenuCarte();		//Visuel
		if(StdDraw.isMousePressed())
		{
			double clickX=StdDraw.mouseX();
			double clickY=StdDraw.mouseY()-clicTropBas;
			int indice = choixCarte(clickX, clickY);		//Quelle carte a été cliquée
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
	
	public static int choixCarte(double clickX, double clickY)	//Quelle carte a été cliquée
	{
		
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
	public static BufferedImage buffImage(String cartePng)		//Fonction qui enregistre l'image dans le buffer (sert à l'obtention du RGB de où on clique)
	{
		try
		{
	        BufferedImage image = ImageIO.read(new File(cartePng));
	        return image;
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
		return null;
	}
	public static int lectureClic(String cartePng) {		//A partir de la couleur d'où on clique, ressort le territoire cliqué
	    	
		BufferedImage image =buffImage(cartePng);
	    Color couleur;
	        
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
	        
	        if (clickX<200)
	        {
	        	//System.out.println("Veuillez cliquez sur un des territoires en couleurs");
	        	return -1;
	        }
	        else if (clickX >1600)
	        {
	        	if (clickY>630)
	        	{
	        		
	        	}
	        	else if(clickY<300)
	        	{
	        		
	        	}
	        	else
	        	{
	        		System.out.println("Veuillez recliquer sur un bouton");
	        	}
	        	return -1;
	        }
	        else
	        {
	        			
	        	clickX = clickX-((width-image.getWidth())/2);
	        	clickY = clickY-((height-image.getHeight())/2);
	        			
	        	/*double multiX = scaleX/width;
	        	double multiY = scaleY/height;
	        	clickX = (int)(clickX*multiX);
	        	clickY = (int)(clickY*multiY);*/ //A travailler pour le rescale
	        			
	        	couleur = new Color(image.getRGB(clickX, image.getHeight()-clickY));	//Couleur aux coordonnées du clic
	        			
	        	//System.out.println("R = " + couleur.getRed());
	        	//System.out.println("G = " + couleur.getGreen());
	        	//System.out.println("B = " + couleur.getBlue());
	        	try {
	        		Thread.sleep(50);
	        	} catch(InterruptedException e) {
	        		System.out.println("Sommeil interrompu");
	        	}
	        	return correspondClic(cartePng, couleur);		//Return id territoire
	        
	        }
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
			
			if (R == 255 && G == 255 && B == 255)		//Si on clique sur du blanc
			{
				System.out.println("Veuillez cliquez sur un des territoires en couleurs");
				return -1;
			}
			
			else if (R == 168 && G == 168 && B == 168)		//Si on clique sur du gris
			{
				System.out.println("Cette zone est non habitable");
				return -1;
			}
			
			else
			{
				for (int i = 0; i<tabCoul.length; i++)
				{
					if (tabCoul[i][0] == R && tabCoul[i][1] == G && tabCoul[i][2] == B)
					{
						//System.out.println("Vous cliquez sur le territoire " + i);
						Plateau.afficheInfosArmees(cartePng,i);
						return i;
					}
				}
				System.out.println("Erreur, veuillez ré-essayer de cliquer sur un territoire");
			}
		}
		
		return -1;
		
	}
	
	public static int[][] creaTableauCouleurs(String cartePng)		//Table qui dit quelle couleur correspond à quel idTerritoire
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
	
	public static String whichButtonIsPressed()
	{
		while(isFinDeTourPressed())
		{
			return "terminer";
		}
		while(isAttaquerPressed())
		{
			return "attaque";
		}
		while(isRenfortPressed())
		{
			return "renfort";
		}
		while(isSeDeplacerPressed())
		{
			return "deplacement";
		}
		return "undefined";
	}
	
	public static boolean isFinDeTourPressed()
	{
		//si le joueur clique sur fin de Tour alors on return True
		if(StdDraw.isMousePressed())
		{
			double clickX=StdDraw.mouseX();
			double clickY=StdDraw.mouseY();		
			if(height/3.3-height/60 < clickY && clickY < height/3.3+height/60) 
			{
				if (width/1.1-width/25 < clickX && clickX < width/1.1+width/25) 
				{
					return true;
				}
			}
		}
		return false;
	}
	
	public static boolean isSeDeplacerPressed()
	{
		//si le joueur clique sur fin de Tour alors on return True
		if(StdDraw.isMousePressed())
		{
			double clickX=StdDraw.mouseX();
			double clickY=StdDraw.mouseY();		
			if(height/2.3-height/60 < clickY && clickY < height/2.3+height/60) 
			{
				if (width/1.1-width/25 < clickX && clickX < width/1.1+width/25) 
				{
					return true;
				}
			}
		}
		return false;
	}
	
	public static boolean isAttaquerPressed()
	{
		//si le joueur clique sur fin de Tour alors on return True
		if(StdDraw.isMousePressed())
		{
			double clickX=StdDraw.mouseX();
			double clickY=StdDraw.mouseY();		
			if(height/2.55-height/60 < clickY && clickY < height/2.55+height/60) 
			{
				if (width/1.1-width/25 < clickX && clickX < width/1.1+width/25) 
				{
					return true;
				}
			}
		}
		return false;
	}
	
	public static boolean isRenfortPressed()
	{
		if(StdDraw.isMousePressed())
		{
			double clickX=StdDraw.mouseX();
			double clickY=StdDraw.mouseY();		
			if(height/2.9-height/60 < clickY && clickY < height/2.9+height/60) 
			{
				if (width/1.1-width/25 < clickX && clickX < width/1.1+width/25) 
				{
					while(isFinRenfortPressed() == false)
					{
					return true;
					}
				}
			}
		}
		return false;
	}
	
	public static boolean isFinRenfortPressed()
	{
		//si le joueur clique sur fin Renfort alors on return True
		if(StdDraw.isMousePressed())
		{
			double clickX=StdDraw.mouseX();
			double clickY=StdDraw.mouseY();		
			if(height/5.8-height/60 < clickY && clickY < height/5.8+height/60) 
			{
				if (width/10-width/25 < clickX && clickX < width/10+width/25) 
				{
					return true;
				}
			}
		}
		return false;
	}
	
	public static String boutonsUnitesRenfort()
	{
		while(true)
		{
			if(StdDraw.isMousePressed())
			{
				clickXBoutonRenf=StdDraw.mouseX();
				clickYBoutonRenf=StdDraw.mouseY();
			}
			if(width/10-width/15 < clickXBoutonRenf && clickXBoutonRenf < width/10+width/15)  
			{
				if (height/3.5-height/100 < clickYBoutonRenf && clickYBoutonRenf < height/3.5+height/100) 
				{
					return "soldat";
				}
				if (height/4.25-height/100 < clickYBoutonRenf && clickYBoutonRenf < height/4.25+height/100) 
				{
					return "cavalier";
				}
				if (height/5.35-height/100 < clickYBoutonRenf && clickYBoutonRenf < height/5.35+height/100) 
				{
					return "canon";
				}
			}
			return "undefined";
		}
		
	}
	
	public static boolean isBoutonsUnitesRenfortPressed()
	{
		while(StdDraw.isMousePressed())
		{
			double clickX=StdDraw.mouseX();
			double clickY=StdDraw.mouseY();		
			if(width/10-width/25 < clickX && clickX < width/10+width/25)  
			{
				if (height/3.2 < clickY && clickY < height/5) 
				{
					return true;
				}
			}
		}
		return false;
	}
	
	public static int renfortSoldat()
	{
		if(StdDraw.isMousePressed())
		{
			double clickX=StdDraw.mouseX();
			double clickY=StdDraw.mouseY();		
			int nbrSoldat = 0;
			while(true)
			{
			if(width/10-width/25 < clickX && clickX < width/10+width/25)  
			{
				if (height/3.80-height/45 < clickY && clickY < height/3.8+height/30) 
				{
					nbrSoldat++;
				}
			}
			return nbrSoldat;
			}
		}
		return -1;
	}
	
	/* public static int renfortCavalier()
	{
		
	}
	
	public static int renfortCanon()
	{
		
	} */
	
}
