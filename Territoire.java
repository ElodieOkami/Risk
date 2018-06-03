public class Territoire {
	static int numero;			//Numéro dans la région
	static int proprietaire;	//Propriétaire de ce territoire
	static int id;		//id parmi les 42 du plateau
	
	
	//----------------------    Constructeur     ---------------------------//
	
	public Territoire(int numero, int id) {
		super();
		Territoire.numero = numero;
		Territoire.id = id;
	}

	
	//----------------------    Getters et Setters     ---------------------------//
	
	public static int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		Territoire.numero = numero;
	}
	public static int getProprietaire() {
		return proprietaire;
	}
	public void setProprietaire(int proprietaire) {
		Territoire.proprietaire = proprietaire;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
