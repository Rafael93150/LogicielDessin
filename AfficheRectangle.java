import java.awt.Color;
import java.awt.Graphics;

public class AfficheRectangle {

	private Rectangle r;
	
	public AfficheRectangle (Rectangle r) {	
		this.r=r;
	}
	
	public void paintComponent(Graphics g) {
		int x = r.getx1();
		int y = r.gety1();
		int largeur = r.getl();
		int hauteur = r.geth();
		Color couleur = r.getcouleur();
		g.setColor(couleur);
		
		if (r.getplein()==false) {
			g.drawRect(x, y, largeur, hauteur);
		}
		else {
			g.fillRect(x, y, largeur, hauteur);
		}
	}
}
