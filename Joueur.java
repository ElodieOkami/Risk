import java.awt.Color;
import java.util.ArrayList;

public class Joueur {
	int idJoueur;
	ArrayList<Unite> listeUnite = new ArrayList <Unite>();
	String pseudo;
	Color couleur;
	
	//----------------------    Constructeur     ---------------------------//
	
	public Joueur(int idJoueur,String pseudo, Color couleur) {
		super();
		this.idJoueur = idJoueur;
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
	
	
	
	//Etape 3 : Répartition d'un nombre de soldats pour chaque joueur
	
	
	public void repartitionUnite(int nbrJr)
	{
		int[] listePuissanceSoldat = {1,2,3,4,5,6};
		switch(nbrJr) //On gère les différents cas
		{
		case 1 :
			for(int i = 0; i < 40; i++)
			{
				this.listeUnite.add(new Soldat(1, listePuissanceSoldat, 2, 1, 2, "Soldat"));
			}
			System.out.println("Le joueur et l'IA ont reçu 40 soldats");
			break;
		case 2 :
			for(int i = 0; i < 40; i++)
			{
				this.listeUnite.add(new Soldat(1, listePuissanceSoldat, 2, 1, 2, "Soldat"));
			}
			System.out.println("Les deux joueurs ont reçu 40 soldats");
			break;
		case 3 :
			for(int i = 0; i < 35; i++)
			{
				this.listeUnite.add(new Soldat(1, listePuissanceSoldat, 2, 1, 2, "Soldat"));
			}
			System.out.println("Les trois joueurs ont reçu 35 soldats");
			break;
		case 4 :
			for(int i = 0; i < 30; i++)
			{
				this.listeUnite.add(new Soldat(1, listePuissanceSoldat, 2, 1, 2, "Soldat"));
			}
			System.out.println("Les quatre joueurs ont reçu 30 soldats");
			break;
		case 5 :
			for(int i = 0; i < 25; i++)
			{
				this.listeUnite.add(new Soldat(1, listePuissanceSoldat, 2, 1, 2, "Soldat"));
			}
			System.out.println("Les cinq joueurs ont reçu 25 soldats");
			break;
		case 6 :
			for(int i = 0; i < 20; i++)
			{
				this.listeUnite.add(new Soldat(1, listePuissanceSoldat, 2, 1, 2, "Soldat"));
			}
			System.out.println("Les six joueurs ont reçu 20 soldats");
			break;
		}
	}
	
	public static void placerUniteIni(int nbrJr)
	{
		//System.out.println("Vous possédez " + this.listeUnite.size()+ " soldats, veuillez les placer sur vos territoires" );
	}
	
	
	
}
