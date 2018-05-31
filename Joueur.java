import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

public class Joueur {
	int idJoueur;
	static ArrayList<Unite> listeUnite = new ArrayList <Unite>();
	String pseudo;
	Color couleur;
	
	//----------------------    Constructeur     ---------------------------//
	
	public Joueur(int idJoueur, ArrayList<Unite> listeUnite, String pseudo, Color couleur) {
		super();
		this.idJoueur = idJoueur;
		this.listeUnite = listeUnite;
		this.pseudo = pseudo;
		this.couleur = couleur;
	}

	
	//----------------------    Getters et Setters     ---------------------------//
	public int getIdJoueur() {
		return idJoueur;
	}
	public void setIdJoueur(int idJoueur) {
		this.idJoueur = idJoueur;
	}
	public ArrayList<Unite> getListeUnite() {
		return listeUnite;
	}
	public void setListeUnite(ArrayList<Unite> listeUnite) {
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
	
	
	//----------------------    Fonctions     ---------------------------//
	public static void creaJoueur(int nbrJr)
	{
		Color[] list = { Color.BLUE, Color.RED, Color.GREEN, Color.PINK, Color.YELLOW, Color.BLACK};
		
		for (int i = 0; i <= nbrJr-1 ; i++)
		{
			Joueur joueur = new Joueur (i+1, listeUnite ,"joueur" + i+1, list[i]);
		}
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
					creaJoueur(1);
					return 1;
				}
				
				else if (width/2.8-15 < clickX && clickX < width/2.8+15) 
				{
					creaJoueur(2);
					return 2;
				}
				
				else if (width/2.2-15 < clickX && clickX < width/2.2+15)
				{
					creaJoueur(3);
					return 3;
				}
				
				else if (width/1.8-15 < clickX && clickX < width/1.8+15)
				{
					creaJoueur(4);
					return 4;
				}
				
				else if (width/1.55-15 < clickX && clickX < width/1.55+15)
				{
					creaJoueur(5);
					return 5;
				}
				
				else if (width/1.35-15 < clickX && clickX < width/1.35+15)
				{
					creaJoueur(6);
					return 6;
				}
			}
		return 0;
	}
	
}
