import java.awt.Color;

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
	
}
