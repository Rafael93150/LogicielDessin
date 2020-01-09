import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class AfficheCercle extends JPanel implements AfficheFigure{
	
	private Cercle c;
	
	public AfficheCercle(Cercle c) {	
		this.c=c;
	}
	
	public void paintComponent(Graphics g) {
		int x = c.getx1()-c.getrayon();
		int y = c.gety1()-c.getrayon();
		int largeur = 2*c.getrayon();
		int hauteur = 2*c.getrayon();
		Color couleur = c.getcouleur();
		g.setColor(couleur);
		
		if (c.getplein()==false) {
			g.drawOval(x, y, largeur, hauteur);
		}
		else {
			g.fillOval(x, y, largeur, hauteur);
		}
	}
	
}
