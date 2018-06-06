import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Mission {
	String contenu;
	int idMission;
	int proprietaire;
	
	
	//----------------------    Constructeur     ---------------------------//
	public Mission(String contenu,int idMission,int proprietaire) {
		super();
		this.contenu = contenu;
		this.idMission = idMission;
		this.proprietaire = proprietaire; 
	}

	//----------------------    Getters et Setters     ---------------------------//
	public String getContenu() {
		return contenu;
	}
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
	public int getIdMission() {
		return idMission;
	}
	public void setIdMission(int idMission) {
		this.idMission = idMission;
	}
	public int getProprietaire() {
		return proprietaire;
	}
	public void setProprietaire(int proprietaire) {
		this.proprietaire = proprietaire;
	}
	
	public static void attributionMissions(int nbrJr)		//ATTENTION la fonction print juste des messages, elle n'associe aucune mission
	{
		//Définition du contenu des missions et de leur contenu
		String mis1 = "Contôler 3 régions et au moins 18 territoires";
		String mis2 = "Contrôler la plus grosse région + 1 autre région";
		String mis3 = "Conquérir tous les territoires";
		String mis4 = "Contrôler 30 territoires";
		String mis5 = "Contrôler 18 territoires avec au moins 2 armées";
		String mis6 = "Détruire le joueur";
		String mis7 = "Contrôler 24 territoires";
		String mis8 = "Contrôler 21 territoires";
		
		List<Mission> list = new ArrayList<Mission>();
		
		Mission mission1 = new Mission(mis1,1,0);
		Mission mission2 = new Mission(mis2,2,0);
		Mission mission3 = new Mission(mis3,3,0);
		Mission mission4 = new Mission(mis4,4,0);
		Mission mission5 = new Mission(mis5,5,0);
		Mission mission6 = new Mission(mis6,6,0);
		Mission mission7 = new Mission(mis7,7,0);
		Mission mission8 = new Mission(mis8,8,0);
		
		//On ajoute dans la liste les missions 1 et 2 qui sont disponible quelque soit le nombre de joueurs
		list.add(mission1);
		list.add(mission2);
		
		//On traite les différents cas selon le nombre de joueurs sur la partie
		if (nbrJr ==1)
		{
			missionAlea(list, nbrJr);
		}
		
		if (nbrJr == 2)
		{
			list.add(mission3);
			list.add(mission4);
			missionAlea(list, nbrJr);
		}
			
		if (nbrJr == 3)
		{
			list.add(mission3);
			list.add(mission4);
			list.add(mission5);
			list.add(mission6);
			missionAlea(list, nbrJr);
		}	
		
		if(nbrJr == 4)
		{
			list.add(mission5);
			list.add(mission6);
			list.add(mission7);
			missionAlea(list, nbrJr);
		}
			
		if (nbrJr == 5)
		{
			list.add(mission5);
			list.add(mission6);
			list.add(mission7);
			missionAlea(list, nbrJr);
		}
			
		if (nbrJr == 6)
		{
			list.add(mission5);
			list.add(mission6);
			list.add(mission8);
			missionAlea(list, nbrJr);	
		}
	}
	
	//Fonction permettant d'attribuer aléatoirement la mission selon la liste des missions disponibles et le nombre de joueurs
	public static void missionAlea (List<Mission> list, int nbrJr)
	{
		int l = list.size(); //Nombre de missions disponibles
		for (int i=1; i<= nbrJr; i++) //Tant que tous les joueurs non pas eu leur mission
		{
			Random x = new Random();
			int xAlea = x.nextInt(l) ;
			Mission mission = list.get(xAlea);
			
			if(mission.contenu != "Détruire le joueur")
			{
				//System.out.println("Mission joueur "+i+" : "+mission.contenu);
			}
			
			else if (mission.contenu == "Détruire le joueur") // Si la mission est "détruire le joueur" on doit choisir le numéro du joueur à détruir
			{
				Random r = new Random();
				int j = r.nextInt(nbrJr)+1;
				while (j==i)   //Cela ne peut pas être le joueur lui-même
				{
					r = new Random();
					j = r.nextInt(nbrJr)+1;
				}
				//System.out.println("Mission joueur "+i+" : "+mission.contenu +j);
			}
				
		}
	}
}