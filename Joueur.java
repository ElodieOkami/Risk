	import java.awt.Color;
	import java.util.ArrayList;
	
	public class Joueur {
		int idJoueur;
		int nbrTerrCaptured;
		ArrayList<Unite> listeUnite = new ArrayList <Unite>();
		ArrayList<Territoire> listeTerrPoss = new ArrayList <Territoire>();
		String pseudo;
		Color couleur;
		
		public static final int[] listePuissanceSoldat = {1,2,3,4,5,6};
		public static final int[] listePuissanceCavalier = {2,3,4,5,6,7};
		public static final int[] listePuissanceCanon = {4,5,6,7,8,9};
		
		//----------------------    Constructeur     ---------------------------//
		
		public Joueur(int idJoueur,String pseudo, Color couleur) {
			super();
			this.idJoueur = idJoueur;
			this.pseudo = pseudo;
			this.couleur = couleur;
		}
	
		
		//----------------------    Getters et Setters     ---------------------------//
		public int getIdJoueur() {
			return idJoueur;
		}
		public void setIdJoueur(int idJoueur) {
			this.idJoueur = idJoueur;
		}
		public int getNbrTerrCaptured() {
			return nbrTerrCaptured;
		}
		public void setNbrTerrCaptured(int nbrTerrCaptured) {
			this.nbrTerrCaptured = nbrTerrCaptured;
		}
		public ArrayList<Unite> getListeUnite() {
			return listeUnite;
		}
		public void setListeUnite(ArrayList<Unite> listeUnite) {
			this.listeUnite = listeUnite;
		}
		public ArrayList<Territoire> getListeTerrPoss() {
			return listeTerrPoss;
		}
		public void setListeTerrPoss(ArrayList<Territoire> listeTerrPoss) {
			this.listeTerrPoss = listeTerrPoss;
		}
		public String getPseudo() {
			return pseudo;
		}
		public void setPseudo(String pseudo) {
			this.pseudo = pseudo;
		}
		public Color getCouleur() {
			return couleur;
		}
		public void setCouleur(Color couleur) {
			this.couleur = couleur;
		}
		
		
		
		//Etape 3 : Répartition d'un nombre de soldats pour chaque joueur
		

		public void repartitionUnite(int nbrJr)
		{
			switch(nbrJr) //On gère les différents cas
			{
			case 1 :
				for(int i = 0; i < 40; i++)
				{
					this.listeUnite.add(new Soldat(1, listePuissanceSoldat, 2, 1, 2, 2, -1, "soldat"));
				}
				//System.out.println("Le joueur et l'IA ont reçu 40 soldats");
				break;
			case 2 :
				for(int i = 0; i < 40; i++)
				{
					this.listeUnite.add(new Soldat(1, listePuissanceSoldat, 2, 1, 2, 2, -1, "soldat"));
				}
				//System.out.println("Les deux joueurs ont reçu 40 soldats");
				break;
			case 3 :
				for(int i = 0; i < 35; i++)
				{
					this.listeUnite.add(new Soldat(1, listePuissanceSoldat, 2, 1, 2, 2, -1, "soldat"));
				}
				//System.out.println("Les trois joueurs ont reçu 35 soldats");
				break;
			case 4 :
				for(int i = 0; i < 30; i++)
				{
					this.listeUnite.add(new Soldat(1, listePuissanceSoldat, 2, 1, 2, 2, -1, "soldat"));
				}
				//System.out.println("Les quatre joueurs ont reçu 30 soldats");
				break;
			case 5 :
				for(int i = 0; i < 25; i++)
				{
					this.listeUnite.add(new Soldat(1, listePuissanceSoldat, 2, 1, 2, 2, -1, "soldat"));
				}
				//System.out.println("Les cinq joueurs ont reçu 25 soldats");
				break;
			case 6 :
				for(int i = 0; i < 20; i++)
				{
					this.listeUnite.add(new Soldat(1, listePuissanceSoldat, 2, 1, 2, 2, -1, "soldat"));
				}
				//System.out.println("Les six joueurs ont reçu 20 soldats");
				break;
			}
		}
		
		public void rempliListTerrJoueur()
		{
			for (int i=0; i<6; i++)		//On parcours les régions
			{
				for (int j=0; j<RiskIsep.getRegion(i).getTerritoires().size(); j++)		//On parcours les téritoires de cette région
				{
					if (RiskIsep.getRegion(i).getTerritoires().get(j).getProprietaire() == this.getIdJoueur())
					{
						this.getListeTerrPoss().add(RiskIsep.getRegion(i).getTerritoires().get(j));
					}
				}
			}
		}
		
		public int placeSoldatParDefault(int numeroSoldat)
		{
			for (int i=0; i<this.getListeTerrPoss().size(); i++)
			{
				RiskIsep.regionClicked(this.getListeTerrPoss().get(i).getId()).getTerritoires().get(Territoire.territoireDsRegion(this.getListeTerrPoss().get(i).getId())).setNbrSoldat(RiskIsep.regionClicked(this.getListeTerrPoss().get(i).getId()).getTerritoires().get(Territoire.territoireDsRegion(this.getListeTerrPoss().get(i).getId())).getNbrSoldat()+1);	//Le territoire se voit automatiquement attribué un soldat 
				this.getListeUnite().get(numeroSoldat).setIdPosition(this.getListeTerrPoss().get(i).getId()); 	//On dit sur quel territoire le soldat a été placé
				numeroSoldat++;
			}
			return numeroSoldat;
		}
		
		public int receptionRenforts()
		{
			int renforts = 0;
			
			int renfTerr = (int)this.getListeTerrPoss().size()/3;
			int renfReg = returnRenfRegIfComplete(this.getIdJoueur());
			int renfCapture = returnRenfCapture(this.getNbrTerrCaptured());
			this.setNbrTerrCaptured(0);
			
			renforts = renfTerr+renfReg+renfCapture;
			return renforts;
		}
		
		private int returnRenfRegIfComplete(int idJoueur)
		{
			int renfReg=0;
			for (int i=0; i<6; i++)
			{
				boolean regionPossede = true;
				Region region = RiskIsep.getRegion(i);
				for (int j=0; j<region.getTerritoires().size(); j++)
				{
					if (region.getTerritoires().get(j).getProprietaire() != idJoueur)
					{
						regionPossede = false;
					}
				}
				if (regionPossede == true)
				{
					renfReg += (int)region.getTerritoires().size()/2;
				}
			}
			return renfReg;
		}
		
		private int returnRenfCapture(int terrCaptured)
		{
			int renfCapture = 0;
			if (terrCaptured==0)
			{
				return 0;
			}
			else
			{
				for (int i=0; i<terrCaptured; i++)
				{
					int r = (int)Math.round(Math.random());
					renfCapture += r;
				}
			}
			return renfCapture;
		}
		
		public void ajouterRenfortJoueur(String typeUnite, int idTerr)
		{
			if (typeUnite == "soldat")
			{
				this.listeUnite.add(new Soldat(1, listePuissanceSoldat, 2, 1, 2, 2, idTerr, "soldat"));
			}
			else if(typeUnite == "cavalier")
			{
				this.listeUnite.add(new Cavalier(3, listePuissanceCavalier, 1, 3, 3, 3, idTerr, "cavalier"));
			}
			else
			{
				this.listeUnite.add(new Canon(7, listePuissanceCanon, 3, 2, 1, 1, idTerr, "canon"));
			}
		}
		
		public int calculLimiteSoldats(int idTerrIni)
		{
			int limiteSoldats = 0;
			
			for (int i=0; i<this.getListeUnite().size(); i++)
			{
				if (this.getListeUnite().get(i).getIdPosition() == idTerrIni && this.getListeUnite().get(i).getMvtLeft() > 0 && this.getListeUnite().get(i).getType() == "soldat")
				{
					limiteSoldats++;
				}
			}
			return limiteSoldats;
		}
		
		public int calculLimiteCavaliers(int idTerrIni)
		{
			int limiteCavaliers = 0;
			
			for (int i=0; i<this.getListeUnite().size(); i++)
			{
				if (this.getListeUnite().get(i).getIdPosition() == idTerrIni && this.getListeUnite().get(i).getMvtLeft() > 0 && this.getListeUnite().get(i).getType() == "cavalier")
				{
					limiteCavaliers++;
				}
			}
			return limiteCavaliers;
		}
		
		public int calculLimiteCanons(int idTerrIni)
		{
			int limiteCanons = 0;
			
			for (int i=0; i<this.getListeUnite().size(); i++)
			{
				if (this.getListeUnite().get(i).getIdPosition() == idTerrIni && this.getListeUnite().get(i).getMvtLeft() > 0 && this.getListeUnite().get(i).getType() == "canon")
				{
					limiteCanons++;
				}
			}
			return limiteCanons;
		}
		
	}