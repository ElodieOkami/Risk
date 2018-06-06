public class Territoire {
	public static int numero;			//Num�ro dans la r�gion
	public int proprietaire;	//Propri�taire de ce territoire
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
	
	public static void deplacement(int idJoueur, String cartePng)
	{
		int idTerrIni=-1;
		int idTerrCible = -1;
		int nbrSoldatsDepl=0;
		int nbrCavalsDepl=0;
		int nbrCanonsDepl=0;
		System.out.println("Veuillez s�lectionner le territoire d'o� vous voulez d�placer des unit�s");
		while(idTerrIni == -1)
		{
			idTerrIni = Interface.lectureClic(cartePng);
		}
		
		System.out.println("Veuillez s�lectionner le nombre d'unit�s � d�placer puis s�lectionnez le territoire o� vous souhaitez les envoyer");
		while(idTerrCible == -1)
		{
			nbrSoldatsDepl = Unite.nbrSoldatsDeplacer(cartePng);
			nbrCavalsDepl = Unite.nbrCavaliersDeplacer(cartePng);
			nbrCanonsDepl = Unite.nbrCanonsDeplacer(cartePng);
			
			idTerrCible = Interface.lectureClic(cartePng);
		}
		if(nbrSoldatsDepl==0 && nbrCavalsDepl==0 && nbrCanonsDepl==0)
		{
			System.out.println("Vous n'avez s�lectionn� aucune unit� � d�placer");
		}
		else if (matriceVoisins[idTerrIni][idTerrCible] != 1)
		{
			System.out.println("Veuillez d�placer vos unit�s case par case");
		}
		else
		{
			if(nbrSoldatsDepl !=0)
			{
				RiskIsep.deplacerSoldat(nbrSoldatsDepl, idTerrIni, idTerrCible, idJoueur);
			}
			if(nbrCavalsDepl !=0)
			{
				RiskIsep.deplacerCavalier(nbrCavalsDepl, idTerrIni, idTerrCible, idJoueur);
			}
			if(nbrCanonsDepl !=0)
			{
				RiskIsep.deplacerCanon(nbrCanonsDepl, idTerrIni, idTerrCible, idJoueur);
			}
		}
		
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
	
	
	final static int[][] matriceVoisins= //matrice adjancente d�ffinissant les pays voisins
		{
			{0,1,0,0,0,0,0,0,0,0,0, 1,0,0,0,0, 0,0,0,0,0,0,0,0, 0,0,0, 0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0},
			{1,0,1,1,0,0,0,0,0,0,0, 0,1,1,0,0, 0,0,0,0,0,0,0,0, 0,0,0, 0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0},
			{0,1,0,1,1,1,0,0,0,0,0, 0,0,1,0,0, 0,0,0,0,0,0,0,0, 0,0,0, 0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0},
			{0,1,1,0,0,1,0,0,0,0,1, 0,0,0,0,0, 0,0,0,0,0,0,0,0, 0,0,0, 0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0},
			{0,0,1,0,0,1,1,0,0,0,0, 0,0,1,0,0, 0,0,1,0,0,0,0,0, 0,0,0, 0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0},
			{0,0,1,1,1,0,1,1,1,1,1, 0,0,0,0,0, 0,0,0,0,0,0,0,0, 0,0,0, 0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,1,1,0,1,1,0,0, 0,0,0,0,0, 0,0,1,1,0,0,0,0, 0,0,0, 0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,1,0,1,0,0, 0,0,0,0,0, 0,0,0,1,0,0,0,0, 0,0,0, 0,0,0,0,0, 1,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,1,1,1,0,1,1, 0,0,0,0,0, 0,0,0,0,0,0,0,0, 0,0,0, 0,0,0,0,0, 1,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,1,0,0,1,0,1, 0,0,0,0,0, 0,0,0,0,0,0,0,0, 0,0,0, 0,0,0,0,0, 1,0,0,0,0,0,0,0,0,0},
			{0,0,0,1,0,1,0,0,1,1,0, 0,0,0,0,0, 0,0,0,0,0,0,0,0, 0,0,0, 0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0},
				
			{1,0,0,0,0,0,0,0,0,0,0,	0,1,0,0,0, 0,0,0,0,0,0,0,0, 0,1,0, 0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0},
			{0,1,0,0,0,0,0,0,0,0,0, 1,0,1,1,1, 0,0,0,0,0,0,0,0, 0,0,0, 0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0},
			{0,1,1,0,1,0,0,0,0,0,0, 0,1,0,1,0, 0,0,1,0,0,0,0,0, 0,0,0, 0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0, 0,1,1,0,1, 0,0,1,0,0,0,0,0, 0,0,0, 0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0, 0,1,0,1,0, 1,1,1,0,0,0,0,0, 0,0,0, 0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0},
																																																			
			{0,0,0,0,0,0,0,0,0,0,0, 0,0,0,0,1, 0,1,0,0,0,0,0,0, 0,0,0, 1,0,0,0,0, 0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0, 0,0,0,0,1, 1,0,1,0,0,0,1,1, 0,0,0, 1,0,1,0,0, 0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,1,0,1,0,0,0,0, 0,0,1,1,1, 0,1,0,1,0,0,0,0, 0,0,0, 0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,1,1,0,0,0, 0,0,0,0,0, 0,0,1,0,1,0,0,1, 0,0,0, 0,0,0,0,0, 1,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0, 0,0,0,1,0,1,0,1, 0,0,0, 0,0,0,0,0, 1,1,0,0,1,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0, 0,0,0,0,1,0,0,0, 0,0,0, 0,0,0,0,0, 0,0,0,0,1,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0, 0,1,0,0,0,0,0,0, 0,0,0, 0,0,1,1,1, 0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0, 0,1,0,1,1,0,0,0, 0,0,0, 0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0},
																																																		
			{0,0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0, 0,0,0,0,0,0,0,0, 0,1,1, 0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0, 1,0,0,0,0, 0,0,0,0,0,0,0,0, 1,0,1, 0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0, 0,0,0,0,0,0,0,0, 1,1,0, 1,0,0,0,0, 0,0,0,0,0,0,0,0,0,0},
																																																				
			{0,0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0, 1,1,0,0,0,0,0,0, 0,0,1, 0,1,1,0,0, 0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0, 0,0,0,0,0,0,0,0, 0,0,0, 1,0,1,0,0, 0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0, 0,1,0,0,0,0,1,0, 0,0,0, 1,1,0,1,1, 0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0, 0,0,0,0,0,0,0,0, 0,0,0, 0,1,1,0,1, 0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0, 0,0,0,0,0,0,1,0, 0,0,0, 0,0,1,1,0, 0,0,0,0,0,0,0,0,0,0},
																																																				
			{0,0,0,1,0,0,0,1,1,1,0, 0,0,0,0,0, 0,0,0,1,1,0,0,0, 0,0,0, 0,0,0,0,0, 0,1,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0, 0,0,0,0,1,0,0,0, 0,0,0, 0,0,0,0,0, 1,0,1,1,1,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0, 0,0,0,0,0,0,0,0, 0,0,0, 0,0,0,0,0, 0,1,0,0,0,0,0,0,0,1},
			{0,0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0, 0,0,0,0,0,0,0,0, 0,0,0, 0,0,0,0,0, 0,1,0,0,1,1,1,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0, 0,0,0,0,1,1,0,0, 0,0,0, 0,0,0,0,0, 0,1,0,1,0,1,0,1,0,0},
			{0,0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0, 0,0,0,0,0,0,0,0, 0,0,0, 0,0,0,0,0, 0,0,0,1,1,0,1,1,0,0},
			{0,0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0, 0,0,0,0,0,0,0,0, 0,0,0, 0,0,0,0,0, 0,0,0,1,0,1,0,1,0,0},
			{0,0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0, 0,0,0,0,0,0,0,0, 0,0,0, 0,0,0,0,0, 0,0,0,0,1,1,1,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0, 0,0,0,0,0,0,0,0, 0,0,0, 0,0,0,0,0, 0,0,1,0,0,0,0,0,0,1},
			{0,0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0, 0,0,0,0,0,0,0,0, 0,0,0, 0,0,0,0,0, 0,0,1,0,0,0,0,0,1,0},			
		};
}