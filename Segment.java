import java.awt.Color;
import java.io.Serializable;

@SuppressWarnings("serial")
public class Segment implements Figure , Serializable{

	private int x1;
	private int y1;
	private int x2;
	private int y2;
	private Color couleur;
	private boolean plein;
	
	public Segment() {
		
	}
	
	public Segment(int x1, int y1, int x2, int y2, Color couleur) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.couleur = couleur;
	}
	
	public int getx1() {
		return this.x1;
	}
	
	public int gety1() {
		return this.y1;
	}
	
	public int getx2() {
		return this.x2;
	}
	
	public int gety2() {
		return this.y2;
	}
	
	public Color getcouleur() {
		return this.couleur;
	}
	
	public boolean getplein() {
		return this.plein;
	}
	
}
