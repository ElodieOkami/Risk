import java.util.ArrayList;

public class Region {
	String nom;				//Nom de la région
	int taille;				//Nombre de territoires dans cette région
	ArrayList <Territoire> territoires=new ArrayList<Territoire>();		//Liste des territoires dans cette région
	
	
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
		return territoires;
	}
	public void setTerritoires(ArrayList<Territoire> territoires) {
		this.territoires = territoires;
	}
	
	
	

	public static int creationRegions(String cartePng, int nbrJr)			//Crée les Régions ainsi que les territoires
	{
		int id = 0;								//id d'un unique territoire
		
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
		System.out.println("Nombre de joueurs: " + Joueur.get(nbrJr-1));
		
		if (cartePng == "plateauElder.png")		//Si on utilise la carte Skyrim
		{
			
			Region provincesImperiales = new Region("provincesImperiales", 11);			//On créé la région a l'aide du constructeur
			id = provincesImperiales.creaEtAttribTerritoires(id, nbrJr, Joueur, JrFull);	//On créé chaque territoire des régions et on les répartis aléatoirement parmi les joueurs.
			Region lenclume = new Region("lenclume", 5);
			id = lenclume.creaEtAttribTerritoires(id, nbrJr, Joueur, JrFull);
			Region cyrodiil = new Region("cyrodiil", 8);
			id = cyrodiil.creaEtAttribTerritoires(id, nbrJr, Joueur, JrFull);
			Region archipelAutomne = new Region("archipelAutomne", 3);
			id = archipelAutomne.creaEtAttribTerritoires(id, nbrJr, Joueur, JrFull);
			Region aldmeri = new Region("aldmeri", 5);
			id = aldmeri.creaEtAttribTerritoires(id, nbrJr, Joueur, JrFull);
			Region argonie = new Region("argonie", 10);
			id = argonie.creaEtAttribTerritoires(id, nbrJr, Joueur, JrFull);
			
			return id;
		}
		
		else
		{
			return id;
		}
	}
	
	private void ajouterTerritoires(int numero, int id)			//Ajoute un territoire dans l'arryalist territoires
	{
		Territoire territoire = new Territoire(numero, id);
		this.territoires.add(territoire);
	}
	
	
	public int creaEtAttribTerritoires(int id, int nbrJr, ArrayList <Integer> Joueur, ArrayList <Integer> JrFull)		//Création des territoires de chaque région et répartion aléatoire parmi les joueurs
	{
		int terParJr=(int)(42/nbrJr);		//Nombre de territoire arrondi que se verra attribué chaque joueur
		
		
		
		for (int i=1; i<getTaille()+1; i++)
		{
			ajouterTerritoires(i, id);		//On ajoute le territoire dans l'arraylist territoires de cette région
			id++;							//Le prochain territoire possède l'id suivant
			
			int j = (int)(Math.random()*(nbrJr-(nbrJr-Joueur.size()))+1);	//Nombre aléatoire entre 1 et le nbr de joueur pas encore full	
			this.territoires.get(i-1).setProprietaire(Joueur.get(j-1));		//On attribue le territoire à un joueur
			System.out.println(this.getNom()+this.territoires.get(i-1).getNumero() + " Id : " +this.territoires.get(i-1).getId() + " et Propri : " +this.territoires.get(i-1).getProprietaire());
			
			JrFull.set(j-1, (1+JrFull.get(j-1)));	//On augmente la quantité de territoire que possède le joueur
			if (JrFull.get(j-1)==terParJr)			//Si le joueur possède le nombre max de territoires
			{
				Joueur.remove(j-1);					//On supprime ce joueur des candidats
				if (Joueur.isEmpty())				//Si on a plus aucun candidat
				{
					for (int z=0; z<42-id; z++)		//Jusqu'à ce qu'on atteigne le nombre total de territoires
					{
						JrFull.set(z, JrFull.get(z)-1); //On recrée de l'espace pour les candidats par ordre croissant  
					}
				}
			}
			//System.out.println(Joueur.get(j-1));
		}
		return id;
		
	}
	
	
	
	
}
