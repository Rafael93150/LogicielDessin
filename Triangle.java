import java.awt.Color;
import java.io.Serializable;

@SuppressWarnings("serial")
public class Triangle implements Figure , Serializable{
	
	private int x1;
	private int y1;
	private int x2;
	private int y2;
	private int x3;
	private int y3;
	private Color couleur;
	private boolean plein;
	
	public Triangle() {
		
	}
	
	public Triangle(int x1, int y1, int x2, int y2, int x3, int y3, Color couleur, boolean plein) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.x3 = x3;
		this.y3 = y3;
		this.couleur = couleur;
		this.plein = plein;
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
	
	public int getx3() {
		return this.x3;
	}
	
	public int gety3() {
		return this.y3;
	}
	
	public Color getcouleur() {
		return this.couleur;
	}
	
	public boolean getplein() {
		return this.plein;
	}
	
}
