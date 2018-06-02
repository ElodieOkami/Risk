import java.awt.Color;
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
		Joueur.listeUnite = listeUnite;
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
	
}
