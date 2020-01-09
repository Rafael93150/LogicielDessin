import java.awt.Color;
import java.io.Serializable;

@SuppressWarnings("serial")
public class Texte implements Figure , Serializable {

	private int x1;
	private int y1;
	private Color couleur;
	private String txt;
	private int taille;
	
	public Texte() {
		
	}
	
	public Texte(String txt, int x1, int y1, int taille, Color couleur) {
		this.x1 = x1;
		this.y1 = y1;
		this.txt = txt;
		this.taille = taille;
		this.couleur = couleur;
	}
	
	public int getx1() {
		return this.x1;
	}
	
	public int gety1() {
		return this.y1;
	}
	
	public String gettxt() {
		return this.txt;
	}
	
	public int gettaille() {
		return this.taille;
	}
	
	public Color getcouleur() {
		return this.couleur;
	}

}
