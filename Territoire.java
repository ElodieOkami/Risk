public class Territoire {
	public static int numero;			//Numéro dans la région
	public int proprietaire;	//Propriétaire de ce territoire
	public int id;		//id parmi les 42 du plateau
	public int nbrCanon;
	public int nbrCaval;
	public int nbrSoldat;
	
	
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
	public int getNbrCanon() {
		return nbrCanon;
	}
	public void setNbrCanon(int nbrCanon) {
		this.nbrCanon = nbrCanon;
	}
	public int getNbrCaval() {
		return nbrCaval;
	}
	public void setNbrCaval(int nbrCaval) {
		this.nbrCaval = nbrCaval;
	}
	public int getNbrSoldat() {
		return nbrSoldat;
	}
	public void setNbrSoldat(int nbrSoldat) {
		this.nbrSoldat = nbrSoldat;
	}
	
	

	public static int territoireDsRegion(int idTerri)
	{
		if (idTerri<11)
		{
			return idTerri;
		}
		else if (idTerri <16)
		{
			return idTerri-11;
		}
		else if (idTerri <24)
		{
			return idTerri-16;
		}
		else if (idTerri < 27)
		{
			return idTerri-24;
		}
		else if (idTerri < 32)
		{
			return idTerri-27;
		}
		else
		{
			return idTerri-32;
		} 
	}
	
}
