import java.util.ArrayList;

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
	
	public static void deplacement(int idJoueur, String cartePng)
	{
		int idTerrIni=-1;			//id du territoire source
		int idTerrCible = -1;		//id du territoire cible
		int nbrSoldatsDepl=0;		//nombre de soldtats à déplacer
		int nbrCavalsDepl=0;		//nbr de cavaliers
		int nbrCanonsDepl=0;		//canons
		System.out.println("Veuillez sélectionner le territoire d'où vous voulez déplacer des unités");
		while(idTerrIni == -1)		//Tant qu'on ne clique pas sur un territoire
		{
			idTerrIni = Interface.lectureClic(cartePng);		//On lit le territoire ou on clique
		}
		
		System.out.println("Veuillez sélectionner le nombre d'unités à déplacer puis sélectionnez le territoire où vous souhaitez les envoyer");
		while(idTerrCible == -1)
		{
			nbrSoldatsDepl = Unite.nbrSoldatsDeplacer(cartePng);
			nbrCavalsDepl = Unite.nbrCavaliersDeplacer(cartePng);
			nbrCanonsDepl = Unite.nbrCanonsDeplacer(cartePng);
			
			idTerrCible = Interface.lectureClic(cartePng);
		}
		if(nbrSoldatsDepl==0 && nbrCavalsDepl==0 && nbrCanonsDepl==0)		//Si aucune unité n'est sélectionnée
		{
			System.out.println("Vous n'avez sélectionné aucune unité à déplacer");
		}
		else if (matriceVoisins[idTerrIni][idTerrCible] != 1)		//Si les territoires ne sont pas voisins
		{
			System.out.println("Veuillez déplacer vos unités case par case");
		}
		else if (RiskIsep.regionClicked(idTerrIni).getTerritoires().get(idTerrIni).getProprietaire() != RiskIsep.regionClicked(idTerrCible).getTerritoires().get(idTerrCible).getProprietaire()) //Si on cherche a aller sur un territoire ennemi
		{
			System.out.println("Ce territoire ne vous appartient pas, utilisez l'option Attaquer du menu pour l'attaquer.");
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
	
	public static void attaque(int idJoueurAttq, String cartePng)
	{
		int idTerrIni=-1;
		int idTerrCible = -1;
		int nbrSoldatsAttq=0;
		int nbrCavalsAttq=0;
		int nbrCanonsAttq=0;
		System.out.println("Veuillez sélectionner le territoire d'où vous voulez attaquer");
		while(idTerrIni == -1)
		{
			idTerrIni = Interface.lectureClic(cartePng);
		}
		
		System.out.println("Veuillez sélectionner le nombre d'unités attaquantes (maximum 3) puis sélectionnez le territoire où vous souhaitez les envoyer");
		while(idTerrCible == -1)
		{
			nbrSoldatsAttq = Unite.nbrSoldatsDeplacer(cartePng);
			nbrCavalsAttq = Unite.nbrCavaliersDeplacer(cartePng);
			nbrCanonsAttq = Unite.nbrCanonsDeplacer(cartePng);
			
			idTerrCible = Interface.lectureClic(cartePng);
		}
		if (nbrSoldatsAttq+nbrCavalsAttq+nbrCanonsAttq > 3)		//Si on envoie plus de 3 unités au combat
		{
			System.out.println("Vous ne pouvez pas envoyer plus de 3 unités au combat en même temps");
		}
		else if (RiskIsep.regionClicked(idTerrIni).getTerritoires().get(idTerrIni).getNbrSoldat()-nbrSoldatsAttq==0 && RiskIsep.regionClicked(idTerrIni).getTerritoires().get(idTerrIni).getNbrCaval()-nbrCavalsAttq==0 && RiskIsep.regionClicked(idTerrIni).getTerritoires().get(idTerrIni).getNbrCanon()-nbrCanonsAttq==0)
		{			//Si toutes les unités du TerrIni particpent au combat 
			System.out.println("Vous ne pouvez pas envoyer toutes les unités d'un territoire au combat. Il doit au moins en rester une sur votre territoire.");
		}
		else if (matriceVoisins[idTerrIni][idTerrCible] != 1)
		{
			System.out.println("Vous ne pouvez attaquer qu'un territoire voisin");
		}
		else if (RiskIsep.regionClicked(idTerrIni).getTerritoires().get(idTerrIni).getProprietaire() == RiskIsep.regionClicked(idTerrCible).getTerritoires().get(idTerrCible).getProprietaire()) //Si on cherche a attaquer un de ses propres territoires
		{
			System.out.println("Ce territoire vous appartient déjà, utilisez l'option Déplacer du menu pour y envoyer des troupes.");
		}
		else
		{
			ArrayList <Unite> listeUniteDefense = new ArrayList <Unite>();
			ArrayList <Unite> listeUniteAttaque = new ArrayList <Unite>();
			listeUniteDefense = RiskIsep.selectionDefense(idTerrCible);
			listeUniteAttaque = RiskIsep.creaArrayAttaquant(idJoueurAttq, idTerrIni, nbrSoldatsAttq, nbrCavalsAttq, nbrCanonsAttq);
			//RiskIsep.bataille(idJoueurAttq, idTerrIni, idTerrCible, listeUniteDefense, listeUniteAttaque)
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
	
	
	final static int[][] matriceVoisins= //matrice adjancente déffinissant les pays voisins
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
