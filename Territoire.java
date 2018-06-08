import java.util.ArrayList;
import java.util.Random;

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
			{							//On enlève l'appel de tousFatigue dès qu'on trouve une unité non fatigué
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
	
	public static void deplacementIA(int idJoueur, String cartePng)
	{
		int idTerrIni=-1;			//id du territoire source
		int idTerrCible = -1;		//id du territoire cible
		int nbrSoldatsDepl=0;		//nombre de soldtats à déplacer
		int nbrCavalsDepl=0;		//nbr de cavaliers
		int nbrCanonsDepl=0;		//canons
		boolean tousFatigues = true;
		//Etape séléction territoire
		Plateau.afficheMessages("choixIA", 0);
		while(idTerrIni == -1)		//Tant qu'un territoire n'est pas séléctionné
		{
			Plateau.actualiserTout(cartePng);
			Plateau.afficheInfosJoueur(cartePng, idJoueur+1, 0);
			Plateau.afficheInfosSeDeplacer(cartePng);
			Plateau.afficheInfosArmees(cartePng);
			
			Joueur joueur = RiskIsep.listeJoueurs.get(1);
			int limite = joueur.listeTerrPoss.size();
			Random y = new Random();
			int yAlea = y.nextInt(limite);
			idTerrIni=joueur.listeTerrPoss.get(yAlea).getId();	//On choisit un id d'un territoire possédé par l'IA au hasard
			
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
			Plateau.afficheMessages("choixIA", 0);
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
			Plateau.afficheMessages("choixIA", 0);
			//Etape séléction nbre d'unité puis territoire cible
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
				//l'IA déplace 1 soldat seulement 
				nbrSoldatsDepl = 1;
				nbrCavalsDepl = 0;
				nbrCanonsDepl = 0;
				
				//Elle choisit un id Cible
				for(int k =0; k<42; k++)
				{
					if(matriceVoisins[idTerrIni][k] == 1)
					{
						Joueur joueur = RiskIsep.listeJoueurs.get(1);
						int limite = joueur.listeTerrPoss.size();
						for(int j =0; j< limite;j++)
						{
							if(joueur.listeTerrPoss.get(j).getId() == k )
							{
								idTerrCible=k;
							}
						}
					}
				}
			}
			if(nbrSoldatsDepl==0 && nbrCavalsDepl==0 && nbrCanonsDepl==0)		//Si aucune unité n'est sélectionnée
			{
				Plateau.actualiserTout(cartePng);
				Plateau.afficheInfosJoueur(cartePng, idJoueur+1, 0);
				Plateau.afficheInfosSeDeplacer(cartePng);
				Plateau.afficheMessages("choixIA", 0);
			}
			if(RiskIsep.regionClicked(idTerrIni).getTerritoires().get(Territoire.territoireDsRegion(idTerrIni)).getNbrSoldat() == nbrSoldatsDepl && RiskIsep.regionClicked(idTerrIni).getTerritoires().get(Territoire.territoireDsRegion(idTerrIni)).getNbrCaval() == nbrCavalsDepl && RiskIsep.regionClicked(idTerrIni).getTerritoires().get(Territoire.territoireDsRegion(idTerrIni)).getNbrCanon() == nbrCanonsDepl)
			{		//Si on cherche à bouger toutes les unités d'un territoire
				Plateau.actualiserTout(cartePng);
				Plateau.afficheInfosJoueur(cartePng, idJoueur+1, 0);
				Plateau.afficheInfosSeDeplacer(cartePng);
				Plateau.afficheMessages("choixIA", 0);
				System.out.println("Veuillez déplacer vos unités case par case");
			}
			else if (matriceVoisins[idTerrIni][idTerrCible] != 1)		//Si les territoires ne sont pas voisins
			{
				Plateau.actualiserTout(cartePng);
				Plateau.afficheInfosJoueur(cartePng, idJoueur+1, 0);
				Plateau.afficheInfosSeDeplacer(cartePng);
				Plateau.afficheMessages("choixIA", 0);
				System.out.println("Veuillez déplacer vos unités case par case");
			}
			else if (RiskIsep.regionClicked(idTerrIni).getTerritoires().get(Territoire.territoireDsRegion(idTerrIni)).getProprietaire() != RiskIsep.regionClicked(idTerrCible).getTerritoires().get(Territoire.territoireDsRegion(idTerrCible)).getProprietaire()) //Si on cherche a aller sur un territoire ennemi
			{
				Plateau.actualiserTout(cartePng);
				Plateau.afficheInfosJoueur(cartePng, idJoueur+1, 0);
				Plateau.afficheInfosSeDeplacer(cartePng);
				Plateau.afficheMessages("choixIA", 0);
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
		int idTerrIni=-1;			//id du territoire source
		int idTerrCible = -1;		//id du territoire cible
		int nbrSoldatsAttq=0;		//nombre de soldtats à déplacer
		int nbrCavalsAttq=0;		//nbr de cavaliers
		int nbrCanonsAttq=0;		//canons
		boolean tousFatigues = true;
		System.out.println("Veuillez sélectionner le territoire d'où vous voulez attaquer");
		Plateau.afficheMessages("attaquerIni", 0);
		while(idTerrIni == -1)		//Tant qu'on ne clique pas sur un territoire
		{
			Plateau.actualiserTout(cartePng);
			Plateau.afficheInfosJoueur(cartePng, idJoueurAttq+1, 0);
			Plateau.afficheInfosAttaquer2(cartePng);
			Plateau.afficheInfosArmees(cartePng);
			idTerrIni = Interface.lectureClic(cartePng);		//On lit le territoire ou on clique
			try {
        		Thread.sleep(50);
        	} catch(InterruptedException e) {
        		System.out.println("Sommeil interrompu");
        	}
		}
		for (int i=0; i<RiskIsep.listeJoueurs.get(idJoueurAttq).getListeUnite().size(); i++)
		{
			if (RiskIsep.listeJoueurs.get(idJoueurAttq).getListeUnite().get(i).getMvtLeft() > 0 && RiskIsep.listeJoueurs.get(idJoueurAttq).getListeUnite().get(i).getIdPosition() == idTerrIni)		
			{
				tousFatigues = false;
			}
		}
		if (tousFatigues)
		{
			Plateau.actualiserTout(cartePng);
			Plateau.afficheInfosJoueur(cartePng, idJoueurAttq+1, 0);
			Plateau.afficheInfosAttaquer2(cartePng);
			Plateau.afficheMessages("tousFatigues", 0);
		}
		else
		{		
			int limiteSoldats = RiskIsep.listeJoueurs.get(idJoueurAttq).calculLimiteSoldats(idTerrIni);
			int limiteCavaliers = RiskIsep.listeJoueurs.get(idJoueurAttq).calculLimiteCavaliers(idTerrIni);
			int limiteCanons = RiskIsep.listeJoueurs.get(idJoueurAttq).calculLimiteCanons(idTerrIni);
			Plateau.actualiserTout(cartePng);
			Plateau.afficheInfosJoueur(cartePng, idJoueurAttq+1, 0);
			Plateau.afficheInfosAttaquer2(cartePng);
			Plateau.afficheNbrSoldatsRenforts(nbrSoldatsAttq);
			Plateau.afficheNbrCavalsRenforts(nbrCavalsAttq);
			Plateau.afficheNbrCanonsRenforts(nbrCanonsAttq);
			Plateau.afficheMessages("selectTerrEtUnite2", 0);
			System.out.println("Veuillez sélectionner les unités partant en guerre et cliquez sur le territoire où vous souhaitez les envoyer");
			while(idTerrCible == -1)
			{
				Plateau.actualiserTout(cartePng);
				Plateau.afficheInfosJoueur(cartePng, idJoueurAttq+1, 0);
				Plateau.afficheInfosAttaquer2(cartePng);
				Plateau.afficheNbrSoldatsRenforts(nbrSoldatsAttq);
				Plateau.afficheNbrCavalsRenforts(nbrCavalsAttq);
				Plateau.afficheNbrCanonsRenforts(nbrCanonsAttq);
				Plateau.afficheInfosArmees(cartePng);
				try {
	        		Thread.sleep(70);
	        	} catch(InterruptedException e) {
	        		System.out.println("Sommeil interrompu");
	        	}
				nbrSoldatsAttq = Interface.nbrSoldatsDeplacer(cartePng, limiteSoldats, nbrSoldatsAttq);
				nbrCavalsAttq = Interface.nbrCavaliersDeplacer(cartePng, limiteCavaliers, nbrCavalsAttq);
				nbrCanonsAttq = Interface.nbrCanonsDeplacer(cartePng, limiteCanons, nbrCanonsAttq);
				
				idTerrCible = Interface.lectureClic(cartePng);
			}
			if(nbrSoldatsAttq==0 && nbrCavalsAttq==0 && nbrCanonsAttq==0)		//Si aucune unité n'est sélectionnée
			{
				Plateau.actualiserTout(cartePng);
				Plateau.afficheInfosJoueur(cartePng, idJoueurAttq+1, 0);
				Plateau.afficheInfosAttaquer2(cartePng);
				Plateau.afficheMessages("aucuneUnite", 0);
				System.out.println("Vous n'avez sélectionné aucune unité à déplacer");
			}
			else if (idJoueurAttq==RiskIsep.regionClicked(idTerrCible).getTerritoires().get(territoireDsRegion(idTerrCible)).getProprietaire())
			{
				Plateau.actualiserTout(cartePng);
				Plateau.afficheInfosJoueur(cartePng, idJoueurAttq+1, 0);
				Plateau.afficheInfosAttaquer2(cartePng);
				Plateau.afficheMessages("terriAllie",0);
			}
			else if(nbrSoldatsAttq+nbrCavalsAttq+nbrCanonsAttq>3)
			{
				Plateau.actualiserTout(cartePng);
				Plateau.afficheInfosJoueur(cartePng, idJoueurAttq+1, 0);
				Plateau.afficheInfosAttaquer2(cartePng);
				Plateau.afficheMessages("pasPlusDe3", 0);
			}
			else if(RiskIsep.regionClicked(idTerrIni).getTerritoires().get(Territoire.territoireDsRegion(idTerrIni)).getNbrSoldat() == nbrSoldatsAttq && RiskIsep.regionClicked(idTerrIni).getTerritoires().get(Territoire.territoireDsRegion(idTerrIni)).getNbrCaval() == nbrCavalsAttq && RiskIsep.regionClicked(idTerrIni).getTerritoires().get(Territoire.territoireDsRegion(idTerrIni)).getNbrCanon() == nbrCanonsAttq)
			{		//Si on cherche à bouger toutes les unités d'un territoire
				Plateau.actualiserTout(cartePng);
				Plateau.afficheInfosJoueur(cartePng, idJoueurAttq+1, 0);
				Plateau.afficheInfosAttaquer2(cartePng);
				Plateau.afficheMessages("pasToutDunCoup", 0);
				System.out.println("PasToutDunCoup");
			}
			else if (matriceVoisins[idTerrIni][idTerrCible] != 1)		//Si les territoires ne sont pas voisins
			{
				Plateau.actualiserTout(cartePng);
				Plateau.afficheInfosJoueur(cartePng, idJoueurAttq+1, 0);
				Plateau.afficheInfosAttaquer2(cartePng);
				Plateau.afficheMessages("attaqueVoisin", 0);
				System.out.println("Veuillez attaquer un voisin");
			}
			else if (RiskIsep.regionClicked(idTerrIni).getTerritoires().get(Territoire.territoireDsRegion(idTerrIni)).getProprietaire() == RiskIsep.regionClicked(idTerrCible).getTerritoires().get(Territoire.territoireDsRegion(idTerrCible)).getProprietaire()) //Si on cherche a aller sur un territoire ennemi
			{
				Plateau.actualiserTout(cartePng);
				Plateau.afficheInfosJoueur(cartePng, idJoueurAttq+1, 0);
				Plateau.afficheInfosAttaquer2(cartePng);
				Plateau.afficheMessages("terriAllie", 0);
				System.out.println("Ce territoire vous appartient, utilisez l'option Se deplacer du menu pour y envoyer des unités.");
			}
			else
			{
				
				ArrayList <Unite>listeUniteDefense = RiskIsep.selectionDefense(idTerrCible);
				ArrayList <Unite>listeUniteAttaque = RiskIsep.creaArrayAttaquant(idJoueurAttq, idTerrIni, nbrSoldatsAttq, nbrCavalsAttq, nbrCanonsAttq);
				
				boolean isVictoire = RiskIsep.bataille(idJoueurAttq, idTerrIni, idTerrCible, listeUniteDefense,listeUniteAttaque);
				if(isVictoire && RiskIsep.regionClicked(idTerrCible).getTerritoires().get(Territoire.territoireDsRegion(idTerrCible)).getNbrCanon()+RiskIsep.regionClicked(idTerrCible).getTerritoires().get(Territoire.territoireDsRegion(idTerrCible)).getNbrCaval()+RiskIsep.regionClicked(idTerrCible).getTerritoires().get(Territoire.territoireDsRegion(idTerrCible)).getNbrSoldat() == 0)
				{
					int idJoueurDef = RiskIsep.regionClicked(idTerrCible).getTerritoires().get(Territoire.territoireDsRegion(idTerrCible)).getProprietaire();
					RiskIsep.changePossesseurTerr(idTerrCible, idJoueurAttq, idJoueurDef);
					if(nbrSoldatsAttq !=0)
					{
						RiskIsep.deplacerSoldat(nbrSoldatsAttq, idTerrIni, idTerrCible, idJoueurAttq, cartePng);
					}
					if(nbrCavalsAttq !=0)
					{
						RiskIsep.deplacerCavalier(nbrCavalsAttq, idTerrIni, idTerrCible, idJoueurAttq, cartePng);
					}
					if(nbrCanonsAttq !=0)
					{
						RiskIsep.deplacerCanon(nbrCanonsAttq, idTerrIni, idTerrCible, idJoueurAttq, cartePng);
					}
				}
			}
		}
		
		
	}
	
	public static void attaqueIA(int idJoueurAttq, String cartePng)
	{
		int idTerrIni=-1;			//id du territoire source
		int idTerrCible = -1;		//id du territoire cible
		int nbrSoldatsAttq=0;		//nombre de soldtats à déplacer
		int nbrCavalsAttq=0;		//nbr de cavaliers
		int nbrCanonsAttq=0;		//canons
		boolean tousFatigues = true;
		Plateau.afficheMessages("choixIA", 0);
		while(idTerrIni == -1)		//Tant qu'un territoire n'est pas séléctionné
		{
			Plateau.actualiserTout(cartePng);
			Plateau.afficheInfosJoueur(cartePng, idJoueurAttq+1, 0);
			Plateau.afficheInfosAttaquer2(cartePng);
			Plateau.afficheInfosArmees(cartePng);
			//Choix du territoire initial
			Joueur joueur = RiskIsep.listeJoueurs.get(1);
			int limite = joueur.listeTerrPoss.size();
			Random y = new Random();
			int yAlea = y.nextInt(limite);
			idTerrIni=joueur.listeTerrPoss.get(yAlea).getId();	//On choisit un id d'un territoire possédé par l'IA au hasard
			try {
        		Thread.sleep(50);
        	} catch(InterruptedException e) {
        		System.out.println("Sommeil interrompu");
        	}
		}
		for (int i=0; i<RiskIsep.listeJoueurs.get(idJoueurAttq).getListeUnite().size(); i++)
		{
			if (RiskIsep.listeJoueurs.get(idJoueurAttq).getListeUnite().get(i).getMvtLeft() > 0 && RiskIsep.listeJoueurs.get(idJoueurAttq).getListeUnite().get(i).getIdPosition() == idTerrIni)		
			{
				tousFatigues = false;
			}
		}
		if (tousFatigues)
		{
			Plateau.actualiserTout(cartePng);
			Plateau.afficheInfosJoueur(cartePng, idJoueurAttq+1, 0);
			Plateau.afficheInfosAttaquer2(cartePng);
			Plateau.afficheMessages("choixIA", 0);
		}
		else
		{		
			int limiteSoldats = RiskIsep.listeJoueurs.get(idJoueurAttq).calculLimiteSoldats(idTerrIni);
			int limiteCavaliers = RiskIsep.listeJoueurs.get(idJoueurAttq).calculLimiteCavaliers(idTerrIni);
			int limiteCanons = RiskIsep.listeJoueurs.get(idJoueurAttq).calculLimiteCanons(idTerrIni);
			Plateau.actualiserTout(cartePng);
			Plateau.afficheInfosJoueur(cartePng, idJoueurAttq+1, 0);
			Plateau.afficheInfosAttaquer2(cartePng);
			Plateau.afficheNbrSoldatsRenforts(nbrSoldatsAttq);
			Plateau.afficheNbrCavalsRenforts(nbrCavalsAttq);
			Plateau.afficheNbrCanonsRenforts(nbrCanonsAttq);
			Plateau.afficheMessages("choixIA", 0);
			//Etape séléction unité puis séléction territoire cible
			while(idTerrCible == -1)
			{
				Plateau.actualiserTout(cartePng);
				Plateau.afficheInfosJoueur(cartePng, idJoueurAttq+1, 0);
				Plateau.afficheInfosAttaquer2(cartePng);
				Plateau.afficheNbrSoldatsRenforts(nbrSoldatsAttq);
				Plateau.afficheNbrCavalsRenforts(nbrCavalsAttq);
				Plateau.afficheNbrCanonsRenforts(nbrCanonsAttq);
				Plateau.afficheInfosArmees(cartePng);
				try {
	        		Thread.sleep(70);
	        	} catch(InterruptedException e) {
	        		System.out.println("Sommeil interrompu");
	        	}
				//Elle attaque avec 1 soldat
				nbrSoldatsAttq = 1;
				nbrCavalsAttq = 0;
				nbrCanonsAttq = 0;
				
				//Elle choisit un id Cible
				for(int k =0; k<42; k++)
				{
					if(matriceVoisins[idTerrIni][k] == 1)
					{
						Joueur joueur = RiskIsep.listeJoueurs.get(0);
						int limite = joueur.listeTerrPoss.size();
						for(int j =0; j< limite;j++)
						{
							if(joueur.listeTerrPoss.get(j).getId() == k )
							{
								idTerrCible=k;
							}
						}
					}
				}
			}
			if(nbrSoldatsAttq==0 && nbrCavalsAttq==0 && nbrCanonsAttq==0)		//Si aucune unité n'est sélectionnée
			{
				Plateau.actualiserTout(cartePng);
				Plateau.afficheInfosJoueur(cartePng, idJoueurAttq+1, 0);
				Plateau.afficheInfosAttaquer2(cartePng);
				Plateau.afficheMessages("choixIa", 0);
			}
			else if (idJoueurAttq==RiskIsep.regionClicked(idTerrCible).getTerritoires().get(territoireDsRegion(idTerrCible)).getProprietaire())
			{
				Plateau.actualiserTout(cartePng);
				Plateau.afficheInfosJoueur(cartePng, idJoueurAttq+1, 0);
				Plateau.afficheInfosAttaquer2(cartePng);
				Plateau.afficheMessages("choixIA",0);
			}
			else if(nbrSoldatsAttq+nbrCavalsAttq+nbrCanonsAttq>3)
			{
				Plateau.actualiserTout(cartePng);
				Plateau.afficheInfosJoueur(cartePng, idJoueurAttq+1, 0);
				Plateau.afficheInfosAttaquer2(cartePng);
				Plateau.afficheMessages("choixIA", 0);
			}
			else if(RiskIsep.regionClicked(idTerrIni).getTerritoires().get(Territoire.territoireDsRegion(idTerrIni)).getNbrSoldat() == nbrSoldatsAttq && RiskIsep.regionClicked(idTerrIni).getTerritoires().get(Territoire.territoireDsRegion(idTerrIni)).getNbrCaval() == nbrCavalsAttq && RiskIsep.regionClicked(idTerrIni).getTerritoires().get(Territoire.territoireDsRegion(idTerrIni)).getNbrCanon() == nbrCanonsAttq)
			{		//Si on cherche à bouger toutes les unités d'un territoire
				Plateau.actualiserTout(cartePng);
				Plateau.afficheInfosJoueur(cartePng, idJoueurAttq+1, 0);
				Plateau.afficheInfosAttaquer2(cartePng);
				Plateau.afficheMessages("choixIA", 0);
			}
			else if (matriceVoisins[idTerrIni][idTerrCible] != 1)		//Si les territoires ne sont pas voisins
			{
				Plateau.actualiserTout(cartePng);
				Plateau.afficheInfosJoueur(cartePng, idJoueurAttq+1, 0);
				Plateau.afficheInfosAttaquer2(cartePng);
				Plateau.afficheMessages("choixIA", 0);
			}
			else if (RiskIsep.regionClicked(idTerrIni).getTerritoires().get(Territoire.territoireDsRegion(idTerrIni)).getProprietaire() == RiskIsep.regionClicked(idTerrCible).getTerritoires().get(Territoire.territoireDsRegion(idTerrCible)).getProprietaire()) //Si on cherche a aller sur un territoire ennemi
			{
				Plateau.actualiserTout(cartePng);
				Plateau.afficheInfosJoueur(cartePng, idJoueurAttq+1, 0);
				Plateau.afficheInfosAttaquer2(cartePng);
				Plateau.afficheMessages("choixIA", 0);
			}
			else
			{
				
				ArrayList <Unite>listeUniteDefense = RiskIsep.selectionDefense(idTerrCible);
				ArrayList <Unite>listeUniteAttaque = RiskIsep.creaArrayAttaquant(idJoueurAttq, idTerrIni, nbrSoldatsAttq, nbrCavalsAttq, nbrCanonsAttq);
				
				boolean isVictoire = RiskIsep.bataille(idJoueurAttq, idTerrIni, idTerrCible, listeUniteDefense,listeUniteAttaque);
				if(isVictoire && RiskIsep.regionClicked(idTerrCible).getTerritoires().get(Territoire.territoireDsRegion(idTerrCible)).getNbrCanon()+RiskIsep.regionClicked(idTerrCible).getTerritoires().get(Territoire.territoireDsRegion(idTerrCible)).getNbrCaval()+RiskIsep.regionClicked(idTerrCible).getTerritoires().get(Territoire.territoireDsRegion(idTerrCible)).getNbrSoldat() == 0)
				{
					int idJoueurDef = RiskIsep.regionClicked(idTerrCible).getTerritoires().get(Territoire.territoireDsRegion(idTerrCible)).getProprietaire();
					RiskIsep.changePossesseurTerr(idTerrCible, idJoueurAttq, idJoueurDef);
					if(nbrSoldatsAttq !=0)
					{
						RiskIsep.deplacerSoldat(nbrSoldatsAttq, idTerrIni, idTerrCible, idJoueurAttq, cartePng);
					}
					if(nbrCavalsAttq !=0)
					{
						RiskIsep.deplacerCavalier(nbrCavalsAttq, idTerrIni, idTerrCible, idJoueurAttq, cartePng);
					}
					if(nbrCanonsAttq !=0)
					{
						RiskIsep.deplacerCanon(nbrCanonsAttq, idTerrIni, idTerrCible, idJoueurAttq, cartePng);
					}
				}
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
