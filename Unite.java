public class Unite {
	int cout;
	int[] puissance;
	int prioriteATT;
	int prioriteDEF;
	int mvtTour;
	String token;
	
	//Constructeurs
	public Unite(int cout, int[] puissance, int prioriteATT, int prioriteDEF, int mvtTour, String token) {
		super();
		this.cout = cout;
		this.puissance = puissance;
		this.prioriteATT = prioriteATT;
		this.prioriteDEF = prioriteDEF;
		this.mvtTour = mvtTour;
		this.token = token;
	}

	//Getters et Setters
	public int getCout() {
		return cout;
	}
	public void setCout(int cout) {
		this.cout = cout;
	}
	public int[] getPuissance() {
		return puissance;
	}
	public void setPuissance(int[] puissance) {
		this.puissance = puissance;
	}
	public int getPrioriteATT() {
		return prioriteATT;
	}
	public void setPrioriteATT(int prioriteATT) {
		this.prioriteATT = prioriteATT;
	}
	public int getPrioriteDEF() {
		return prioriteDEF;
	}
	public void setPrioriteDEF(int prioriteDEF) {
		this.prioriteDEF = prioriteDEF;
	}
	public int getMvtTour() {
		return mvtTour;
	}
	public void setMvtTour(int mvtTour) {
		this.mvtTour = mvtTour;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}

//Fonctions

	public static void repartitionUnite(int nbrJr)
	{
		int[] listePuissanceSoldat = {1,2,3,4,5,6};
		switch(nbrJr) //On gère les différents cas
		{
		case 1 :
			System.out.println("1 joueur");
			break;
		case 2 :
			for(int i = 0; i < 40; i++)
			{
				Joueur.listeUnite.add(new Soldat(1, listePuissanceSoldat, 2, 1, 2, "Soldat"));
			}
			System.out.println("Les deux joueurs ont reçu 40 soldats");
			break;
		case 3 :
			for(int i = 0; i < 35; i++)
			{
				Joueur.listeUnite.add(new Soldat(1, listePuissanceSoldat, 2, 1, 2, "Soldat"));
			}
			System.out.println("Les trois joueurs ont reçu 35 soldats");
			break;
		case 4 :
			for(int i = 0; i < 30; i++)
			{
				Joueur.listeUnite.add(new Soldat(1, listePuissanceSoldat, 2, 1, 2, "Soldat"));
			}
			System.out.println("Les quatre joueurs ont reçu 30 soldats");
			break;
		case 5 :
			for(int i = 0; i < 25; i++)
			{
				Joueur.listeUnite.add(new Soldat(1, listePuissanceSoldat, 2, 1, 2, "Soldat"));
			}
			System.out.println("Les cinq joueurs ont reçu 25 soldats");
			break;
		case 6 :
			for(int i = 0; i < 20; i++)
			{
				Joueur.listeUnite.add(new Soldat(1, listePuissanceSoldat, 2, 1, 2, "Soldat"));
			}
			System.out.println("Les six joueurs ont reçu 20 soldats");
			break;
		}
	}
	
}
