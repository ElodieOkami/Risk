import java.awt.Color;
import java.awt.Dimension;
import java.util.Random;



public class Joueur {
	int idJoueur;
	Unite [] listeUnite;
	String pseudo;
	Color couleur;
	int idMission;
	
	//----------------------    Constructeur     ---------------------------//
	
	public Joueur(int idJoueur, Unite[] listeUnite, String pseudo, Color couleur,int idMission) {
		super();
		this.idJoueur = idJoueur;
		this.listeUnite = listeUnite;
		this.pseudo = pseudo;
		this.couleur = couleur;
		this.idMission = idMission;
	}

	
	//----------------------    Getters et Setters     ---------------------------//
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
	public int getIdMission() {
		return idMission;
	}
	public void setIdMission(int idMission) {
		this.idMission = idMission;
	}
	public int getIdJoueur() {
		return idJoueur;
	}
	public void setIdJoueur(int idJoueur) {
		this.idJoueur = idJoueur;
	}
	
	

	//----------------------    Création des joueurs     ---------------------------//
	static Unite[] liste = {};
	static Joueur joueur1 = new Joueur(0, liste , "joueur1", Color.BLUE,0);
	static Joueur joueur2 = new Joueur(0, liste , "joueur2", Color.RED,0);
	static Joueur joueur3 = new Joueur(0, liste , "joueur3", Color.GREEN,0);
	static Joueur joueur4 = new Joueur(0, liste , "joueur4", Color.PINK,0);
	static Joueur joueur5 = new Joueur(0, liste , "joueur5", Color.YELLOW,0);
	static Joueur joueur6 = new Joueur(0, liste , "joueur6", Color.BLACK,0);
	
	
	//----------------------    Fonctions     ---------------------------//
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
					joueur1.idJoueur = 1;
					return 1;
				}
				
				else if (width/2.8-15 < clickX && clickX < width/2.8+15) 
				{
					joueur1.idJoueur = 1;
					joueur2.idJoueur = 2;
					return 2;
				}
				
				else if (width/2.2-15 < clickX && clickX < width/2.2+15)
				{
					joueur1.idJoueur = 1;
					joueur2.idJoueur = 2;
					joueur3.idJoueur = 3;
					return 3;
				}
				
				else if (width/1.8-15 < clickX && clickX < width/1.8+15)
				{
					joueur1.idJoueur = 1;
					joueur2.idJoueur = 2;
					joueur3.idJoueur = 3;
					joueur4.idJoueur = 4;
					return 4;
				}
				
				else if (width/1.55-15 < clickX && clickX < width/1.55+15)
				{
					joueur1.idJoueur = 1;
					joueur2.idJoueur = 2;
					joueur3.idJoueur = 3;
					joueur4.idJoueur = 4;
					joueur5.idJoueur = 5;
					return 5;
				}
				
				else if (width/1.35-15 < clickX && clickX < width/1.35+15)
				{
					joueur1.idJoueur = 1;
					joueur2.idJoueur = 2;
					joueur3.idJoueur = 3;
					joueur4.idJoueur = 4;
					joueur5.idJoueur = 5;
					joueur6.idJoueur = 6;
					return 6;
				}
			}
		return 0;
	}
	
}
