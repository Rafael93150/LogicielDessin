import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class AfficheTexte {

	private Texte text;
	
	public AfficheTexte (Texte text) {	
		this.text=text;
	}
	
	public void paintComponent(Graphics g) {
		int x1 = text.getx1();
		int y1 = text.gety1();
		int taille = text.gettaille();
		String txt= text.gettxt();
		
		Color couleur = text.getcouleur();
		g.setColor(couleur);
		g.setFont(new Font("TimesRoman", Font.PLAIN, taille)); 
		g.drawString(txt, x1, y1);

	}
}
