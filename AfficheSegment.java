import java.awt.Color;
import java.awt.Graphics;

public class AfficheSegment {
	
private Segment s;
	
	public AfficheSegment (Segment s) {	
		this.s=s;
	}
	
	public void paintComponent(Graphics g) {
		int x1 = s.getx1();
		int y1 = s.gety1();
		int x2= s.getx2();
		int y2 = s.gety2();
		
		Color couleur = s.getcouleur();
		g.setColor(couleur);
		
		g.drawLine(x1, y1, x2, y2);

	}
}
