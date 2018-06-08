import java.util.ArrayList;

public class Unite implements Comparable{
	int cout;
	int[] puissance;
	int puissanceCombat;
	int prioriteATT;
	int prioriteDEF;
	int mvtTour;
	int mvtLeft;
	int idPosition;
	String type;
	
	//Constructeurs
	public Unite(int cout, int[] puissance, int prioriteATT, int prioriteDEF, int mvtTour, int mvtLeft, int idPosition, String type) {
		super();
		this.cout = cout;
		this.puissance = puissance;
		this.prioriteATT = prioriteATT;
		this.prioriteDEF = prioriteDEF;
		this.mvtTour = mvtTour;
		this.mvtLeft = mvtLeft;
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
	public int getPuissanceCombat() {
		return puissanceCombat;
	}
	public void setPuissanceCombat(int puissanceCombat) {
		this.puissanceCombat = puissanceCombat;
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
	public int getMvtLeft() {
		return mvtLeft;
	}
	public void setMvtLeft(int mvtLeft) {
		this.mvtLeft = mvtLeft;
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
	
	
	@Override
	public int compareTo(Unite comparestu)
	{
		int comparePuiss=((Unite)comparestu).getPuissanceCombat();
		return comparePuiss-this.puissanceCombat;
	}
	
	@Override
	public String toString()
	{
		return "[ cout=" + cout + ", puissance=" + puissance + ", prioriteATT=" + prioriteATT + ", prioriteDEF=" + ", mvtTour=" + mvtTour + ", mvtLeft=" + mvtLeft + ", idPosition=" + idPosition + ", type=" + type + "]";
		}

	public static int[] TriParSelection(int[] S)
	{
		System.out.println("Table avant le tri : ");
		PrintTab(S);
		int indice;
		
		for (int i=0; i<S.length; i++)
		{
			indice = IndiceMin(S, i);
			if (i!=indice)
			{
				S=Permuter(S, i, indice);
			}
		}
		System.out.println();
		System.out.println();
		System.out.println("Table après le tri : ");
		PrintTab(S);
		return S;
	}
	
	public static int[] Permuter(int S[], int i, int j)
	{
		int tmp = S[i];
		S[i] = S[j];
		S[j] = tmp;
		return S;
	}
	
	public static void PrintTab(int tab[])
	{
		for (int i=0; i<tab.length; i++)
		{
			System.out.print(tab[i]+" ");
		}
	}
	
	public static int IndiceMin(int S[], int rang)
	{
		int indice = rang;
		for (int i=rang+1; i<S.length; i++)
		{
			if (S[i]<S[indice])
			{
				indice = i;
			}
		}
		return indice;
	}
	
	public static int highestPrioATT(ArrayList<Unite> liste)
	{
		int highestPatt = 3;
		for (int i=0; i<liste.size();i++)
		{
			if (highestPatt >liste.get(i).getPrioriteATT())
			{
				highestPatt = liste.get(i).getPrioriteATT();
			}
		}
		return highestPatt;
	}
	
	public static int highestPrioDEF(ArrayList<Unite> liste)
	{
		int highestPdef = 3;
		for (int i=0; i<liste.size();i++)
		{
			if (highestPdef >liste.get(i).getPrioriteDEF())
			{
				highestPdef = liste.get(i).getPrioriteDEF();
			}
		}
		return highestPdef;
	}
	
	
}