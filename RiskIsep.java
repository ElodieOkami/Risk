
public class RiskIsep {

	public static void main(String[] args) {
		Jeu();
		
	}
	
	public static void Jeu()
	{
		String cartePng = Initialisation.initialisationJeu();
		
		while(true)
		{
		Interface.lectureClic(cartePng);
		}
		//Tour.Tour(); (pour la future class tour)
	}
	

}
