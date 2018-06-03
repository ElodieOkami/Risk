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
	
	
}
