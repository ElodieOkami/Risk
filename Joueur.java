import java.awt.Color;
import java.awt.Dimension;

import edu.princeton.cs.introcs.StdDraw;

public class Joueur {
	Unite [] listeUnite;
	String pseudo;
	Color couleur;
	
	// Constructeur
	public Joueur(Unite[] listeUnite, String pseudo, Color couleur) {
		super();
		this.listeUnite = listeUnite;
		this.pseudo = pseudo;
		this.couleur = couleur;
	}

	
	//Getters et Setters
	public Unite[] getListeUnite() {
		return listeUnite;
	}
	public void setListeUnite(Unite[] listeUnite) {
		this.listeUnite = listeUnite;
	}
	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	public Color getCouleur() {
		return couleur;
	}
	public void setCouleur(Color couleur) {
		this.couleur = couleur;
	}
	
	
	public static int nombreJoueurs(double clickX, double clickY)
	{
		Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int height = (int)dimension.getHeight();
		int width  = (int)dimension.getWidth();
		
			Unite[] liste = {};
			
			if(height/1.5-20 < clickY && clickY < height/1.5+20) 
			{
				if (width/3.9-15 < clickX && clickX < width/3.9+15) 
				{
					Joueur joueur1 = new Joueur( liste , "joueur1", Color.BLUE );
					//System.out.println("un joueur");
					return 1;
				}
				
				else if (width/2.8-15 < clickX && clickX < width/2.8+15) 
				{
					Joueur joueur1 = new Joueur( liste , "joueur1", Color.BLUE);
					Joueur joueur2 = new Joueur( liste , "joueur2", Color.RED);
					//System.out.println("deux joueur");
					return 2;
				}
				
				else if (width/2.2-15 < clickX && clickX < width/2.2+15)
				{
					Joueur joueur1 = new Joueur( liste , "joueur1", Color.BLUE);
					Joueur joueur2 = new Joueur( liste , "joueur2", Color.RED);
					Joueur joueur3 = new Joueur( liste , "joueur3", Color.GREEN);
					//System.out.println("trois joueur");
					return 3;
				}
				
				else if (width/1.8-15 < clickX && clickX < width/1.8+15)
				{
					Joueur joueur1 = new Joueur( liste , "joueur1", Color.BLUE);
					Joueur joueur2 = new Joueur( liste , "joueur2", Color.RED);
					Joueur joueur3 = new Joueur( liste , "joueur3", Color.GREEN);
					Joueur joueur4 = new Joueur( liste , "joueur4", Color.PINK);
					//System.out.println("quatre joueur");
					return 4;
				}
				
				else if (width/1.55-15 < clickX && clickX < width/1.55+15)
				{
					Joueur joueur1 = new Joueur( liste , "joueur1", Color.BLUE);
					Joueur joueur2 = new Joueur( liste , "joueur2", Color.RED);
					Joueur joueur3 = new Joueur( liste , "joueur3", Color.GREEN);
					Joueur joueur4 = new Joueur( liste , "joueur4", Color.PINK);
					Joueur joueur5 = new Joueur( liste , "joueur5", Color.YELLOW);
					//System.out.println("cinq joueur");
					return 5;
				}
				
				else if (width/1.35-15 < clickX && clickX < width/1.35+15)
				{
					Joueur joueur1 = new Joueur( liste , "joueur1", Color.BLUE);
					Joueur joueur2 = new Joueur( liste , "joueur2", Color.RED);
					Joueur joueur3 = new Joueur( liste , "joueur3", Color.GREEN);
					Joueur joueur4 = new Joueur( liste , "joueur4", Color.PINK);
					Joueur joueur5 = new Joueur( liste , "joueur5", Color.YELLOW);
					Joueur joueur6 = new Joueur( liste , "joueur6", Color.BLACK);
					//System.out.println("six joueur");
					return 6;
				}
		
			}
			
		return 0;	
	}
}
