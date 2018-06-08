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
		boolean tousFatigues = true;
		System.out.println("Veuillez sélectionner le territoire d'où vous voulez déplacer des unités");
		Plateau.afficheMessages("deplacerIni", 0);
		while(idTerrIni == -1)		//Tant qu'on ne clique pas sur un territoire
		{
			Plateau.actualiserTout(cartePng);
			Plateau.afficheInfosJoueur(cartePng, idJoueur+1, 0);
			Plateau.afficheInfosSeDeplacer(cartePng);
			Plateau.afficheInfosArmees(cartePng);
			idTerrIni = Interface.lectureClic(cartePng);		//On lit le territoire ou on clique
			try {
        		Thread.sleep(100);
        	} catch(InterruptedException e) {
        		System.out.println("Sommeil interrompu");
        	}
		}
		for (int i=0; i<RiskIsep.listeJoueurs.get(idJoueur).getListeUnite().size(); i++)
		{
			if (RiskIsep.listeJoueurs.get(idJoueur).getListeUnite().get(i).getMvtLeft() > 0 && RiskIsep.listeJoueurs.get(idJoueur).getListeUnite().get(i).getIdPosition() == idTerrIni)
			{
				tousFatigues = false;
			}
		}
		if (tousFatigues)
		{
			Plateau.actualiserTout(cartePng);
			Plateau.afficheInfosJoueur(cartePng, idJoueur+1, 0);
			Plateau.afficheInfosSeDeplacer(cartePng);
			Plateau.afficheMessages("tousFatigues", 0);
		}
		else
		{		
			int limiteSoldats = RiskIsep.listeJoueurs.get(idJoueur).calculLimiteSoldats(idTerrIni);
			int limiteCavaliers = RiskIsep.listeJoueurs.get(idJoueur).calculLimiteCavaliers(idTerrIni);
			int limiteCanons = RiskIsep.listeJoueurs.get(idJoueur).calculLimiteCanons(idTerrIni);
			Plateau.actualiserTout(cartePng);
			Plateau.afficheInfosJoueur(cartePng, idJoueur+1, 0);
			Plateau.afficheInfosSeDeplacer(cartePng);
			Plateau.afficheNbrSoldatsRenforts(nbrSoldatsDepl);
			Plateau.afficheNbrCavalsRenforts(nbrCavalsDepl);
			Plateau.afficheNbrCanonsRenforts(nbrCanonsDepl);
			Plateau.afficheMessages("selectTerrEtUnite", 0);
			System.out.println("Veuillez sélectionner le nombre d'unités à déplacer puis sélectionnez le territoire où vous souhaitez les envoyer");
			while(idTerrCible == -1)
			{
				Plateau.actualiserTout(cartePng);
				Plateau.afficheInfosJoueur(cartePng, idJoueur+1, 0);
				Plateau.afficheInfosSeDeplacer(cartePng);
				Plateau.afficheNbrSoldatsRenforts(nbrSoldatsDepl);
				Plateau.afficheNbrCavalsRenforts(nbrCavalsDepl);
				Plateau.afficheNbrCanonsRenforts(nbrCanonsDepl);
				Plateau.afficheInfosArmees(cartePng);
				try {
	        		Thread.sleep(70);
	        	} catch(InterruptedException e) {
	        		System.out.println("Sommeil interrompu");
	        	}
				nbrSoldatsDepl = Interface.nbrSoldatsDeplacer(cartePng, limiteSoldats, nbrSoldatsDepl);
				nbrCavalsDepl = Interface.nbrCavaliersDeplacer(cartePng, limiteCavaliers, nbrCavalsDepl);
				nbrCanonsDepl = Interface.nbrCanonsDeplacer(cartePng, limiteCanons, nbrCanonsDepl);
				
				idTerrCible = Interface.lectureClic(cartePng);
			}
			if(nbrSoldatsDepl==0 && nbrCavalsDepl==0 && nbrCanonsDepl==0)		//Si aucune unité n'est sélectionnée
			{
				Plateau.actualiserTout(cartePng);
				Plateau.afficheInfosJoueur(cartePng, idJoueur+1, 0);
				Plateau.afficheInfosSeDeplacer(cartePng);
				Plateau.afficheMessages("aucuneUnite", 0);
				System.out.println("Vous n'avez sélectionné aucune unité à déplacer");
			}
			if(RiskIsep.regionClicked(idTerrIni).getTerritoires().get(Territoire.territoireDsRegion(idTerrIni)).getNbrSoldat() == nbrSoldatsDepl && RiskIsep.regionClicked(idTerrIni).getTerritoires().get(Territoire.territoireDsRegion(idTerrIni)).getNbrCaval() == nbrCavalsDepl && RiskIsep.regionClicked(idTerrIni).getTerritoires().get(Territoire.territoireDsRegion(idTerrIni)).getNbrCanon() == nbrCanonsDepl)
			{		//Si on cherche à bouger toutes les unités d'un territoire
				Plateau.actualiserTout(cartePng);
				Plateau.afficheInfosJoueur(cartePng, idJoueur+1, 0);
				Plateau.afficheInfosSeDeplacer(cartePng);
				Plateau.afficheMessages("pasToutDunCoup", 0);
				System.out.println("Veuillez déplacer vos unités case par case");
			}
			else if (matriceVoisins[idTerrIni][idTerrCible] != 1)		//Si les territoires ne sont pas voisins
			{
				Plateau.actualiserTout(cartePng);
				Plateau.afficheInfosJoueur(cartePng, idJoueur+1, 0);
				Plateau.afficheInfosSeDeplacer(cartePng);
				Plateau.afficheMessages("caseParCase", 0);
				System.out.println("Veuillez déplacer vos unités case par case");
			}
			else if (RiskIsep.regionClicked(idTerrIni).getTerritoires().get(Territoire.territoireDsRegion(idTerrIni)).getProprietaire() != RiskIsep.regionClicked(idTerrCible).getTerritoires().get(Territoire.territoireDsRegion(idTerrCible)).getProprietaire()) //Si on cherche a aller sur un territoire ennemi
			{
				Plateau.actualiserTout(cartePng);
				Plateau.afficheInfosJoueur(cartePng, idJoueur+1, 0);
				Plateau.afficheInfosSeDeplacer(cartePng);
				Plateau.afficheMessages("terriEnnemi", 0);
				System.out.println("Ce territoire ne vous appartient pas, utilisez l'option Attaquer du menu pour l'attaquer.");
			}
			else
			{
				if(nbrSoldatsDepl !=0)
				{
					RiskIsep.deplacerSoldat(nbrSoldatsDepl, idTerrIni, idTerrCible, idJoueur, cartePng);
				}
				if(nbrCavalsDepl !=0)
				{
					RiskIsep.deplacerCavalier(nbrCavalsDepl, idTerrIni, idTerrCible, idJoueur, cartePng);
				}
				if(nbrCanonsDepl !=0)
				{
					RiskIsep.deplacerCanon(nbrCanonsDepl, idTerrIni, idTerrCible, idJoueur, cartePng);
				}
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
		
		int limiteSoldats = RiskIsep.listeJoueurs.get(idJoueurAttq).calculLimiteSoldats(idTerrIni);
		int limiteCavaliers = RiskIsep.listeJoueurs.get(idJoueurAttq).calculLimiteCavaliers(idTerrIni);
		int limiteCanons = RiskIsep.listeJoueurs.get(idJoueurAttq).calculLimiteCanons(idTerrIni);
		System.out.println("Veuillez sélectionner le nombre d'unités attaquantes (maximum 3) puis sélectionnez le territoire où vous souhaitez les envoyer");
		while(idTerrCible == -1)
		{
			//nbrSoldatsAttq = Interface.nbrSoldatsDeplacer(cartePng, limiteSoldats);
			//nbrCavalsAttq = Interface.nbrCavaliersDeplacer(cartePng, limiteCavaliers);
			//nbrCanonsAttq = Interface.nbrCanonsDeplacer(cartePng, limiteCanons);
			
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