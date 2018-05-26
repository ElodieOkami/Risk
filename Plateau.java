import edu.princeton.cs.introcs.StdDraw;
import java.awt.Dimension;
import java.util.ArrayList;

public class Plateau
{

	public static void affichePlateau(String cartePng)
	{
		Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int height = (int)dimension.getHeight();
		int width  = (int)dimension.getWidth();
		StdDraw.setCanvasSize(width,height-100);
		StdDraw.setXscale(0, width);
		StdDraw.setYscale(0, height);
		
		StdDraw.picture(width/2, height/2, cartePng);
	}
	
	
	
}
