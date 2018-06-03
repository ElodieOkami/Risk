import java.util.ArrayList;

public class Region {
	static String nom;				//Nom de la région
	static int taille;				//Nombre de territoires dans cette région
	static ArrayList <Territoire> listeTerritoires=new ArrayList<Territoire>();		//Liste des territoires dans cette région
	
	
	//----------------------    Constructeur     ---------------------------//
	
	public Region(String nom, int taille) {
		super();
		Region.nom = nom;
		Region.taille = taille;
	}

	//----------------------    Getters et Setters     ---------------------------//
	
	public static String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		Region.nom = nom;
	}
	public int getTaille() {
		return taille;
	}
	public void setTaille(int taille) {
		Region.taille = taille;
	}
	public ArrayList<Territoire> getTerritoires() {
		return listeTerritoires;
	}
	public void setTerritoires(ArrayList<Territoire> listeTerritoires) {
		Region.listeTerritoires = listeTerritoires;
	}
		
}
