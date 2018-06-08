import java.awt.Color;
import java.util.ArrayList;

public class Region {
	
	public String nom;				//Nom de la r�gion
	public int taille;				//Nombre de territoires dans cette r�gion
	ArrayList <Territoire> listeTerritoires=new ArrayList<Territoire>();		//Liste des territoires dans cette r�gion
	
	
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
		this.getTerritoires().add(territoire);
	}
		
	public void creaEtAttribTerritoires(int idTerritoire, int nbrJr, ArrayList <Integer> listIdJoueur, ArrayList <Integer> JrFull)		//Cr�ation des territoires de chaque r�gion et r�partion al�atoire parmi les joueurs
	{
		int terParJr=(int)(42/nbrJr);		//Nombre de territoire arrondi que se verra attribu� chaque joueur
			
			
			
		for (int i=1; i<this.getTaille()+1; i++)
		{
			this.ajouterTerritoires(i, idTerritoire);		//On ajoute le territoire dans l'arraylist territoires de cette r�gion
			idTerritoire++;							//Le prochain territoire poss�de l'id suivant
				
			int j = (int)(Math.random()*(nbrJr-(nbrJr-listIdJoueur.size()))+1);	//Nombre al�atoire entre 1 et le nbr de joueur pas encore full	
			this.getTerritoires().get(i-1).setProprietaire(listIdJoueur.get(j-1));		//On attribue le territoire � un joueur
				
			//System.out.println(this.getNom()+Territoire.getNumero() + " Id : " +this.listeTerritoires.get(i-1).getId() + " et Propri : " +this.listeTerritoires.get(i-1).getProprietaire());
				
			JrFull.set(j-1, (1+JrFull.get(j-1)));	//On augmente la quantit� de territoire que poss�de le joueur
			if (JrFull.get(j-1)==terParJr)			//Si le joueur poss�de le nombre max de territoires
			{
				listIdJoueur.remove(j-1);					//On supprime ce joueur des candidats
				JrFull.remove(j-1);
				if (listIdJoueur.isEmpty())				//Si on a plus aucun candidat
				{
						
					for (int z=0; z<nbrJr; z++)		//Jusqu'� ce qu'on atteigne le nombre total de joueurs
					{
						listIdJoueur.add(z, z);			//On recr�� chaque candidat
						JrFull.add(z, terParJr-1); 	//On recr�� un d'espace pour chaque candidat
					}
				}
			}
		}
	}
		
		
	public int getPossesseurDsRegion(int idTerr, String cartePng)
	{
		int idPropri;
			
		for (int i=0; i<this.getTerritoires().size(); i++)	//Pour chaque territoire de la R�gion
		{
			idPropri = this.getTerritoires().get(i).getProprietaire();		//Ressort le proprietaire de chaque territoire de la R�gion
			Color couleur = RiskIsep.getCouleurPropri(idPropri);		//Ressort la couleur de ce propri�taire
			Plateau.affichePointProprio(idTerr, couleur, cartePng);				//Affiche un point de la couleur du joueur sur le territoire qu'il occupe 
			idTerr++;
		}
		return idTerr;
	}
		
	public static void CreaRegTer(String cartePng, int nbrJr)
	{
		int idTerritoire=0;
		RiskIsep.creationRegions(cartePng, nbrJr, idTerritoire);			//Cr�e les R�gions ainsi que les territoires
	}
	
	public void ajouterRenfortRegion(String typeUnite, int idTerr)
	{
		if (typeUnite == "soldat")
		{
			this.getTerritoires().get(Territoire.territoireDsRegion(idTerr)).setNbrSoldat(this.listeTerritoires.get(Territoire.territoireDsRegion(idTerr)).getNbrSoldat()+1);
		}
		else if (typeUnite == "cavalier")
		{
			this.getTerritoires().get(Territoire.territoireDsRegion(idTerr)).setNbrCaval(this.listeTerritoires.get(Territoire.territoireDsRegion(idTerr)).getNbrCaval()+1);
		}
		else if (typeUnite == "canon")
		{
			this.getTerritoires().get(Territoire.territoireDsRegion(idTerr)).setNbrCanon(this.listeTerritoires.get(Territoire.territoireDsRegion(idTerr)).getNbrCanon()+1);
		}
	}

}