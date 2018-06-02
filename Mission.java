
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

}
