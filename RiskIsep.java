
public class RiskIsep {

	public static void main(String[] args) {
		Jeu();
		//new Panel();
	}
	
	public static void Jeu()
	{
		String cartePng = Initialisation.initialisationJeu();
		
		
		
		while(true)
		{
			//Region.appelAfficheProprio(cartePng);
			Interface.lectureClic(cartePng);
		}
		//Tour.Tour(); (pour la future class tour)
	}
	

}
