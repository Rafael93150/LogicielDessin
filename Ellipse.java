import java.awt.Color;
import java.io.Serializable;

@SuppressWarnings("serial")
public class Ellipse implements Figure , Serializable{

	private int x1;
	private int y1;
	private int l;
	private int h;
	private Color couleur;
	private boolean plein;
	
	public Ellipse() {
		
	}
	
	public Ellipse(int x1, int y1, int l, int h, Color couleur, boolean plein) {
		this.x1 = x1;
		this.y1 = y1;
		this.l = l;
		this.h = h;
		this.couleur = couleur;
		this.plein = plein;
	}
	
	public int getx1() {
		return this.x1;
	}
	
	public int gety1() {
		return this.y1;
	}
	
	public int getl() {
		return this.l;
	}
	
	public int geth() {
		return this.h;
	}
	
	public Color getcouleur() {
		return this.couleur;
	}
	
	public boolean getplein() {
		return this.plein;
	}
}
