import java.util.ArrayList;

public class Region {
	String nom;				//Nom de la région
	int taille;				//Nombre de territoires dans cette région
	ArrayList <Territoire> territoires=new ArrayList<Territoire>();		//Liste des territoires dans cette région
	
	
	//----------------------    Constructeur     ---------------------------//
	
	public Region(String nom, int taille) {
		super();
		this.nom = nom;
		this.taille = taille;
	}

	//----------------------    Getters et Setters     ---------------------------//
	
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
	
	
	

	public static int creationRegions(String cartePng)			//Crée les Régions ainsi que les territoires
	{
		int id = 0;								//id d'un unique territoire
		
		if (cartePng == "plateauElder.png")		//Si on utilise la carte Skyrim
		{
			
			Region provincesImperiales = new Region("provincesImperiales", 11);
			id = provincesImperiales.creationTerritoires(id);
			Region lenclume = new Region("lenclume", 5);
			id = lenclume.creationTerritoires(id);
			Region cyrodiil = new Region("cyrodiil", 8);
			id = cyrodiil.creationTerritoires(id);
			Region archipelAutomne = new Region("archipelAutomne", 3);
			id = archipelAutomne.creationTerritoires(id);
			Region aldmeri = new Region("aldmeri", 5);
			id = aldmeri.creationTerritoires(id);
			Region argonie = new Region("argonie", 10);
			id = argonie.creationTerritoires(id);
			
			return id;
		}
		
		else
		{
			return id;
		}
	}
	
	private void ajouterTerritoires(int numero, int id)
	{
		Territoire territoire = new Territoire(numero, id);
		this.territoires.add(territoire);
	}
	
	
	public int creationTerritoires(int id)
	{
		for (int i=1; i<getTaille()+1; i++)
		{
			ajouterTerritoires(i, id);
			id++;
			System.out.println(this.getNom()+territoires.get(i-1).getNumero() + " : " +territoires.get(i-1).getId());
		}
		return id;
		
	}
	
	
}
