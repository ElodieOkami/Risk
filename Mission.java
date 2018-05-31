import java.util.Random;
import java.util.List;
import java.util.ListIterator;
import java.util.ArrayList;

public class Mission {
	String contenu;
	int idMission;
	
	
	//----------------------    Constructeur     ---------------------------//
	public Mission(String contenu,int idMission) {
		super();
		this.contenu = contenu;
		this.idMission = idMission;
	}

	//----------------------    Getters et Setters     ---------------------------//
	public String getContenu() {
		return contenu;
	}
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	
	//----------------------    Fonctions     ---------------------------//
	
	public static void attributionMissions(int nbrJr)
	{
		Random x = new Random(); 
		int xAlea = x.nextInt(nbrJr) + 1;
		String mission1 = "Contôler 3 régions et au moins 18 territoires";
		String mission2 = "Contrôler la plus grosse région + 1 autre région";
		String mission3 = "Conquérir tous les territoires";
		String mission4 = "Contrôler 30 territoires";
		String mission5 = "Contrôler 18 territoires avec au moins 2 armées";
		String mission6 = "Détruire le joueur" + xAlea;
		String mission7 = "Contrôler 24 territoires";
		String mission8 = "contrôler 21 territoires";
		List<String> list = new ArrayList<String>();
		
		list.add(mission1);
		list.add(mission2);
		
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
			
	public static void missionAlea (List<String> list, int nbrJr)
	{
		int l = list.size();
		for (int i=1; i<= nbrJr; i++) 
		{
			Random x = new Random();
			int xAlea = 1 + x.nextInt(l - 1);
			String mission = list.get(xAlea);;
			System.out.println("Mission joueur "+i+" : "+mission);
		}
	}

}


