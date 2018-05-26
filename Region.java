import java.util.ArrayList;

public class Region {
	String nom;
	int taille;
	ArrayList <Territoire> territoires=new ArrayList<Territoire>();
	
	//Constructeur
	public Region(String nom, int taille) {
		super();
		this.nom = nom;
		this.taille = taille;
	}

	//Getters et Setters 
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getTaille() {
		return taille;
	}
	public void setTaille(int taille) {
		this.taille = taille;
	}
	public ArrayList<Territoire> getTerritoires() {
		return territoires;
	}
	public void setTerritoires(ArrayList<Territoire> territoires) {
		this.territoires = territoires;
	}

	
	
	private void ajouterTerritoires(int numero)
	{
		Territoire territoire = new Territoire(numero);
		this.territoires.add(territoire);
	}
	
	
	public void creationTerritoires()
	{
		for (int i=0; i<getTaille(); i++)
		{
			ajouterTerritoires(i);
		}
	}
	
	
}
