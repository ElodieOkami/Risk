public class Territoire {
	public static int numero;			//Numéro dans la région
	public int proprietaire;	//Propriétaire de ce territoire
	public int id;		//id parmi les 42 du plateau
	
	
	//----------------------    Constructeur     ---------------------------//
	
	public Territoire(int numero, int id) {
		super();
		Territoire.numero = numero;
		this.id = id;
	}

	
	//----------------------    Getters et Setters     ---------------------------//
	
	public static int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		Territoire.numero = numero;
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
	
	
	
}
