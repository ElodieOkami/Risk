public class Unite {
	int cout;
	int[] puissance;
	int prioriteATT;
	int prioriteDEF;
	int mvtTour;
	int idPosition;
	String type;
	
	//Constructeurs
	public Unite(int cout, int[] puissance, int prioriteATT, int prioriteDEF, int mvtTour, int idPosition, String type) {
		super();
		this.cout = cout;
		this.puissance = puissance;
		this.prioriteATT = prioriteATT;
		this.prioriteDEF = prioriteDEF;
		this.mvtTour = mvtTour;
		this.idPosition = idPosition;
		this.type = type;
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
	public int getIdPosition() {
		return idPosition;
	}
	public void setIdPosition(int idPosition) {
		this.idPosition = idPosition;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
	
	
}
