import java.util.ArrayList;

public class Region {
	
	public String nom;				//Nom de la région
	public int taille;				//Nombre de territoires dans cette région
	ArrayList <Territoire> listeTerritoires=new ArrayList<Territoire>();		//Liste des territoires dans cette région
	
	
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
		return listeTerritoires;
	}
	public void setTerritoires(ArrayList<Territoire> listeTerritoires) {
		this.listeTerritoires = listeTerritoires;
	}
		
	
	
	public static int creationRegions(String cartePng, int nbrJr, int idTerritoire)			//Crée les Régions ainsi que les territoires
	{
		
		ArrayList <Integer> JrFull = new ArrayList<Integer>();				//On créé une liste du nombre de territoire qu'a chaque joueur lors de l'attribution aléatoire
		for (int i=0; i<nbrJr; i++)
		{
			JrFull.add(0);													//Cette liste est initialement vide
		}
		
		ArrayList <Integer> Joueur = new ArrayList<Integer>();				//On créé une liste de "l'id" de chaque joueur
		for (int i=0; i<nbrJr; i++)
		{
			Joueur.add(i+1);													//Cette liste va de 1 au nombre de joueur
		}
		//System.out.println("Nombre de joueurs: " + Joueur.get(nbrJr-1));
		
		if (cartePng == "plateauElder.png")		//Si on utilise la carte TES
		{
			
			Region provincesImperiales = new Region("provincesImperiales", 11);			//On créé la région a l'aide du constructeur
			provincesImperiales.creaEtAttribTerritoires(provincesImperiales, idTerritoire, nbrJr, Joueur, JrFull);	//On créé chaque territoire des régions et on les répartis aléatoirement parmi les joueurs.
			idTerritoire += provincesImperiales.getTaille();
			Region lenclume = new Region("lenclume", 5);
			lenclume.creaEtAttribTerritoires(lenclume, idTerritoire, nbrJr, Joueur, JrFull);
			idTerritoire += lenclume.getTaille();
			Region cyrodiil = new Region("cyrodiil", 8);
			cyrodiil.creaEtAttribTerritoires(cyrodiil, idTerritoire, nbrJr, Joueur, JrFull);
			idTerritoire += cyrodiil.getTaille();
			Region archipelAutomne = new Region("archipelAutomne", 3);
			archipelAutomne.creaEtAttribTerritoires(archipelAutomne, idTerritoire, nbrJr, Joueur, JrFull);
			idTerritoire += archipelAutomne.getTaille();
			Region aldmeri = new Region("aldmeri", 5);
			aldmeri.creaEtAttribTerritoires(aldmeri, idTerritoire, nbrJr, Joueur, JrFull);
			idTerritoire += aldmeri.getTaille();
			Region argonie = new Region("argonie", 10);
			argonie.creaEtAttribTerritoires(argonie, idTerritoire, nbrJr, Joueur, JrFull);
			idTerritoire += argonie.getTaille();
			
		}
		
		else if (cartePng == "plateauTerre.png")
		{
			Region northAmerica = new Region("northAmerica",9);
			northAmerica.creaEtAttribTerritoires(northAmerica, idTerritoire, nbrJr, Joueur, JrFull);
			idTerritoire += northAmerica.getTaille();
			Region southAmerica = new Region("southAmerica",4);
			southAmerica.creaEtAttribTerritoires(southAmerica, idTerritoire, nbrJr, Joueur, JrFull);
			idTerritoire += southAmerica.getTaille();
			Region europe = new Region("europe",7);
			europe.creaEtAttribTerritoires(europe, idTerritoire, nbrJr, Joueur, JrFull);
			idTerritoire += europe.getTaille();
			Region africa = new Region("africa",6);
			africa.creaEtAttribTerritoires(africa, idTerritoire, nbrJr, Joueur, JrFull);
			idTerritoire += africa.getTaille();
			Region asia = new Region("asia",12);
			asia.creaEtAttribTerritoires(asia, idTerritoire, nbrJr, Joueur, JrFull);
			idTerritoire += asia.getTaille();
			Region australia = new Region("australia",4);
			australia.creaEtAttribTerritoires(australia, idTerritoire, nbrJr, Joueur, JrFull);
			idTerritoire += australia.getTaille();
		}
		return idTerritoire;
	}
	
	private void ajouterTerritoires(int numero, int id)			//Ajoute un territoire dans l'arryalist territoires
	{
		Territoire territoire = new Territoire(numero, id);
		this.listeTerritoires.add(territoire);
	}
	
	
		public int creaEtAttribTerritoires(Region region, int id, int nbrJr, ArrayList <Integer> Joueur, ArrayList <Integer> JrFull)		//Création des territoires de chaque région et répartion aléatoire parmi les joueurs
		{
			int terParJr=(int)(42/nbrJr);		//Nombre de territoire arrondi que se verra attribué chaque joueur
			
			
			
			for (int i=1; i<region.getTaille()+1; i++)
			{
				this.ajouterTerritoires(i, id);		//On ajoute le territoire dans l'arraylist territoires de cette région
				id++;							//Le prochain territoire possède l'id suivant
				
				int j = (int)(Math.random()*(nbrJr-(nbrJr-Joueur.size()))+1);	//Nombre aléatoire entre 1 et le nbr de joueur pas encore full	
				this.listeTerritoires.get(i-1).setProprietaire(Joueur.get(j-1));		//On attribue le territoire à un joueur
				
				//System.out.println(Region.getNom()+Territoire.getNumero() + " Id : " +Region.listeTerritoires.get(i-1).getId() + " et Propri : " +Territoire.getProprietaire());
				
				JrFull.set(j-1, (1+JrFull.get(j-1)));	//On augmente la quantité de territoire que possède le joueur
				if (JrFull.get(j-1)==terParJr)			//Si le joueur possède le nombre max de territoires
				{
					Joueur.remove(j-1);					//On supprime ce joueur des candidats
					JrFull.remove(j-1);
					if (Joueur.isEmpty())				//Si on a plus aucun candidat
					{
						
						for (int z=0; z<nbrJr; z++)		//Jusqu'à ce qu'on atteigne le nombre total de joueurs
						{
							Joueur.add(z, z+1);			//On recréé chaque candidat
							JrFull.add(z, terParJr-1); 	//On recréé un d'espace pour chaque candidat
						}
					}
				}
				//System.out.println(Joueur.get(j-1));
			}
			return id;
			
		}
		
		public static void CreaRegTer(String cartePng, int nbrJr)
		{
			Plateau.affichePlateau(cartePng);					//Affiche l'image du plateau de jeu
			int idTerritoire=0;
			int idMax = creationRegions(cartePng, nbrJr, idTerritoire);			//Crée les Régions ainsi que les territoires
		}
	
	
	
}
