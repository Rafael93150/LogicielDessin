import java.awt.Color;
import java.awt.Graphics;

public class AfficheTriangle {

	private Triangle t;
	
	public AfficheTriangle (Triangle t) {	
		this.t=t;
	}
	
	public void paintComponent(Graphics g) {
		int x1 = (int) t.getx1();
		int y1 = (int) t.gety1();
		int x2= (int) t.getx2();
		int y2 = (int) t.gety2();
		int x3 = (int) t.getx3();
		int y3 = (int) t.gety3();
		/*int x3 = x1 + (x2-x1)/2;
		int y3 = (int) (x1 - ((x2-x1) * (Math.sqrt(3)/2)));*/
		int[] x = {x1, x2, x3};
		int[] y = {y1, y2, y3};
		
		Color couleur = t.getcouleur();
		g.setColor(couleur);
		
		if (t.getplein()==false) {
			g.drawPolygon(x, y, 3);
		}
		else {
			g.fillPolygon(x, y, 3);
		}
	}
}
