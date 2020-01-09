import java.awt.Color;
import java.io.Serializable;

@SuppressWarnings("serial")
public class Cercle implements Figure , Serializable{

	private int x1;
	private int y1;
	private int rayon;
	private Color couleur;
	private boolean plein;
	
	public Cercle() {
		
	}
	
	public Cercle(int x1, int y1, int rayon, Color couleur, boolean plein) {
		this.x1 = x1;
		this.y1 = y1;
		this.rayon = rayon;
		this.couleur = couleur;
		this.plein = plein;
	}
	
	public int getx1() {
		return this.x1;
	}
	
	public int gety1() {
		return this.y1;
	}
	
	public int getrayon() {
		return this.rayon;
	}
	
	public Color getcouleur() {
		return this.couleur;
	}
	
	public boolean getplein() {
		return this.plein;
	}
	
}
