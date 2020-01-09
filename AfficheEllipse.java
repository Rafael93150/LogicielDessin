import java.awt.Color;
import java.awt.Graphics;

public class AfficheEllipse {

	private Ellipse e;
	
	public AfficheEllipse (Ellipse e) {	
		this.e=e;
	}
	
	public void paintComponent(Graphics g) {
		int x = e.getx1();
		int y = e.gety1();
		int largeur = e.getl();
		int hauteur = e.geth();
		Color couleur = e.getcouleur();
		g.setColor(couleur);
		
		if (e.getplein()==false) {
			g.drawOval(x, y, largeur, hauteur);
		}
		else {
			g.fillOval(x, y, largeur, hauteur);
		}
	}
}
