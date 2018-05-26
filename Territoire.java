
public class Territoire {
	int numero;			//Numéro dans la région
	int proprietaire;	//Propriétaire de ce territoire
	int id;		//id parmi les 42 du plateau
	
	
	//----------------------    Constructeur     ---------------------------//
	
	public Territoire(int numero, int id) {
		super();
		this.numero = numero;
		this.id = id;
	}

	
	//----------------------    Getters et Setters     ---------------------------//
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public int getProprietaire() {
		return proprietaire;
	}
	public void setProprietaire(int proprietaire) {
		this.proprietaire = proprietaire;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}


	public static void attributionTerritoire(int idMax)
	{
		
	}
	
	
}
