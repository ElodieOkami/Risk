import java.awt.Color;
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
	
	private void ajouterTerritoires(int numero, int id)			//Ajoute un territoire dans l'arryalist territoires
	{
		Territoire territoire = new Territoire(numero, id);
		this.listeTerritoires.add(territoire);
	}
		
		public void creaEtAttribTerritoires(int idTerritoire, int nbrJr, ArrayList <Integer> Joueur, ArrayList <Integer> JrFull)		//Création des territoires de chaque région et répartion aléatoire parmi les joueurs
		{
			int terParJr=(int)(42/nbrJr);		//Nombre de territoire arrondi que se verra attribué chaque joueur
			
			
			
			for (int i=1; i<this.getTaille()+1; i++)
			{
				this.ajouterTerritoires(i, idTerritoire);		//On ajoute le territoire dans l'arraylist territoires de cette région
				idTerritoire++;							//Le prochain territoire possède l'id suivant
				
				int j = (int)(Math.random()*(nbrJr-(nbrJr-Joueur.size()))+1);	//Nombre aléatoire entre 1 et le nbr de joueur pas encore full	
				this.listeTerritoires.get(i-1).setProprietaire(Joueur.get(j-1));		//On attribue le territoire à un joueur
				
				//System.out.println(this.getNom()+Territoire.getNumero() + " Id : " +this.listeTerritoires.get(i-1).getId() + " et Propri : " +this.listeTerritoires.get(i-1).getProprietaire());
				
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
				
			}
			
			
		}
		
		
		public void getPossesseurDsRegion()
		{
			int numPropri;
			int idTerr = 0;
			for (int i=0; i<this.getTaille(); i++)
			{
				numPropri = this.listeTerritoires.get(idTerr).getProprietaire();
				Color couleur = Initialisation.getCouleurPropri(numPropri);
				Plateau.affichePointProprio(idTerr, couleur);
				idTerr++;
			}
			
			
			
		}
		
	
	
	
}
