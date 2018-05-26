
import java.util.Random;

public class Mission {
	String contenu;
	
	//Constructeur
	public Mission(String contenu) {
		super();
		this.contenu = contenu;
	}

	//Getters et Setters
	public String getContenu() {
		return contenu;
	}
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}


	//Fonctions 
	
	public void defMissions() {
		int nbrJoueur = RiskIsep.lancementJeu();
		Mission mission1 = new Mission("Contrôler 3 régions et au moins 18 territoires");
		Mission mission2 = new Mission("Contrôler la plus grosse région + 1 autre région");
		Mission mission3 = new Mission("Conquérir tous les territoires");
		Mission mission4 = new Mission("Contrôler 30 territoires");
		Mission mission5 = new Mission("Contrôler 18 territoires avec au moins 2 armées");
		Random x = new Random();
		int xAlea = x.nextInt(nbrJoueur) + 1;
		Mission mission6 = new Mission("Détruire le joueur" + xAlea);
		Mission mission7 = new Mission("Contrôler 24 territoires");
		Mission mission8 = new Mission("Contrôler 21 territoires");		
	}
	
	public void attributionMissions()//non finie
	{
		int nbrJoueur = RiskIsep.lancementJeu();
	
		if ( nbrJoueur == 2 || nbrJoueur == 3  ) // si il y a 2 ou 3 joueurs on peut attribuer entre les missions 1 2 3 et 4
		{
			
		}
		
		if (nbrJoueur >= 3 ) // s'il y a plus de 3 joueurs --> missions 1 2 3 4 5 6
		{


		}
		
		if (nbrJoueur == 4 || nbrJoueur == 5  ) // s'il y a 4 ou 5 joueurs --> missions 1 à 7
		{
			
		}
		
		if (nbrJoueur == 6) // s'il y a 6 joueurs --> missions 1 à 8
		{
		
		}
		
		else // s'il y a 1 ou 2 joueurs --> missions 1 et 2
		{
			
		}
	}


	
}
