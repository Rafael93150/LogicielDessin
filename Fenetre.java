import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

@SuppressWarnings("serial")
public class Fenetre extends JFrame {
	
	// Variables globales
	ArrayList<Figure> listeFigures = new ArrayList<Figure>();
	ArrayList<Point> points = new ArrayList<Point>();
	ArrayList<Figure> apercu = new ArrayList<Figure>();
	
	private JPanel PanelDessin;
	private JButton boutonCercle = new JButton("Cercle");
	private JButton boutonEllipse = new JButton("Ellipse");
	private JButton boutonRectangle = new JButton("Rectangle");
	private JButton boutonTriangle = new JButton("Triangle");
	private JButton boutonSegment = new JButton("Segment");
	private JButton boutonTexte = new JButton("Ajouter");
	private JButton boutonCharger = new JButton("Charger");
	private JButton boutonSauvegarder = new JButton("Sauvegarder");
	private JButton boutonSupprimer = new JButton("Supprimer");
	private JButton boutonCouleur = new JButton("Couleur");
	private JButton boutonGomme = new JButton("Gomme");
	private JButton boutonRetour = new JButton("Retour");
	private JTextField choixRayon = new JTextField("50");
	private JTextField choixTexte = new JTextField(10);
	private JTextField choixTaille = new JTextField("20");
	private JTextField choixTaille2 = new JTextField("20");
	private CheckboxGroup groupe=new CheckboxGroup();  
    private Checkbox box1=new Checkbox("Plein",groupe,false);  
    private Checkbox box2=new Checkbox("Vide",groupe,true);
	
	private int r;
	private int numBout;
	private int mousex;
	private int mousey;
	private int mousex2;
	private int mousey2;
	private int mousexd;
	private int mouseyd;
	private String valRayon;
	private String txt;
	private Color couleur = (Color.BLACK);
	private Color couleurFond = Color.WHITE;
	
	

	// CONSTRUCTEUR
	
	public Fenetre () {}

	public Fenetre (String titre, int x, int y, int w, int h) {
		super(titre);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setExtendedState(Frame.MAXIMIZED_BOTH); // plein écran
		//this.setBounds(x,y,w,h);
		this.initialise();
		this.setVisible(true);
	}
	
	
	// GETTEURS
	
	public Color getCouleur() {
		Color couleur = this.couleur;
		return couleur;
	}
	
	public boolean getFigurePleine() {
		if (box2.getState()==true) {
			return false;
		}
		else {
			return true;
		}
	}
	
	// PANNEAUX
	
	// PanelNord
	public JPanel getPanelNord() {
		JPanel PanelNord = new JPanel();
		PanelNord.setLayout(new FlowLayout());
		PanelNord.add(boutonCharger);
		PanelNord.add(boutonSauvegarder);
		PanelNord.add(boutonSupprimer);
		PanelNord.add(boutonRetour);
		return PanelNord;
	}
	
	// PanelOuest
	public JTabbedPane getPanelOuest() { 
		JTabbedPane PanelOuest = new JTabbedPane();
		PanelOuest.add(getPanelDessin(), "Dessin");
		PanelOuest.add(getPanelTexte(), "Texte");
		return PanelOuest; 
	}
	
	// OngletDessin
	public JPanel getPanelDessin() {
		PanelDessin = new JPanel();
		PanelDessin.setLayout(new FlowLayout());
		PanelDessin.setPreferredSize(new Dimension(50, 50));
		boutonEllipse.setPreferredSize(new Dimension(112,30));
		PanelDessin.add(boutonEllipse);
		boutonCercle.setPreferredSize(new Dimension(80,30));
		PanelDessin.add(boutonCercle);
		choixRayon.setPreferredSize(new Dimension(28,30));
		PanelDessin.add(choixRayon);
		boutonRectangle.setPreferredSize(new Dimension(112,30));
		PanelDessin.add(boutonRectangle);
		boutonTriangle.setPreferredSize(new Dimension(112,30));
		PanelDessin.add(boutonTriangle);
		boutonSegment.setPreferredSize(new Dimension(112,30));
		PanelDessin.add(boutonSegment);
		boutonCouleur.setPreferredSize(new Dimension(112,30));
		PanelDessin.add(boutonCouleur);
	    PanelDessin.add(box1);  
	    PanelDessin.add(box2);
	    boutonGomme.setPreferredSize(new Dimension(80,30));
	    PanelDessin.add(boutonGomme);
	    choixTaille2.setPreferredSize(new Dimension(28,30));
	    PanelDessin.add(choixTaille2);
	    
		return PanelDessin; 
	}
	
	// OngletTexte
	public JPanel getPanelTexte() {
		JPanel PanelTexte = new JPanel();
		PanelTexte.setLayout(new FlowLayout());
		PanelTexte.setPreferredSize(new Dimension(120, 50));
		choixTexte.setPreferredSize(new Dimension(112,30));
		choixTaille.setPreferredSize(new Dimension(28, 30));
		boutonTexte.setPreferredSize(new Dimension(80, 30));
		PanelTexte.add(choixTexte);
		PanelTexte.add(choixTaille);
		PanelTexte.add(boutonTexte);
		return PanelTexte;
	}
	
	

	// PanelCentre
	public class PanelCentre extends JPanel{
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			setBackground(couleurFond);
			
			getMouse gm = new getMouse();
			this.addMouseListener(gm);
			this.addMouseMotionListener(gm);
			
			//////// AFFICHAGE DE L'APERCU ////////////
			new AfficheTexte(new Texte("Aperçu", 10, 20, 15, Color.BLACK)).paintComponent(g);
			new AfficheSegment (new Segment (0,80,70,80,Color.BLACK)).paintComponent(g);
			new AfficheSegment (new Segment (70,0,70,80,Color.BLACK)).paintComponent(g);
			if (apercu.size()>0) {
				if ((apercu.get(0).getClass().getName()).equals("Ellipse")) {
				    AfficheEllipse affEllipse = new AfficheEllipse((Ellipse)apercu.get(0));
				    affEllipse.paintComponent(g);
				}
				if ((apercu.get(0).getClass().getName()).equals("Cercle")) {
			    	AfficheCercle affCercle = new AfficheCercle((Cercle)apercu.get(0));
			    	affCercle.paintComponent(g);
				}
				if ((apercu.get(0).getClass().getName()).equals("Rectangle")) {
				    AfficheRectangle affRect = new AfficheRectangle((Rectangle)apercu.get(0));
				    affRect.paintComponent(g);
				}		
				if ((apercu.get(0).getClass().getName()).equals("Triangle")) {
				    AfficheTriangle affTriangle = new AfficheTriangle((Triangle)apercu.get(0));
				    affTriangle.paintComponent(g);
				}
				if ((apercu.get(0).getClass().getName()).equals("Segment")) {
				    AfficheSegment affSegment = new AfficheSegment((Segment)apercu.get(0));
				    affSegment.paintComponent(g);
				}
				if ((apercu.get(0).getClass().getName()).equals("Texte")) {
				    AfficheTexte affTexte = new AfficheTexte((Texte)apercu.get(0));
				    affTexte.paintComponent(g);
				}
			}
			
			//////// AFFICHAGE DU DESSIN /////////////
			for(int i=0; i <listeFigures.size();i++){
				
				if ((listeFigures.get(i).getClass().getName()).equals("Ellipse")) {
				    AfficheEllipse affEllipse = new AfficheEllipse((Ellipse)listeFigures.get(i));
				    affEllipse.paintComponent(g);
				}
				if ((listeFigures.get(i).getClass().getName()).equals("Cercle")) {
				    AfficheCercle affCercle = new AfficheCercle((Cercle)listeFigures.get(i));
				    affCercle.paintComponent(g);
				}
				if ((listeFigures.get(i).getClass().getName()).equals("Rectangle")) {
				    AfficheRectangle affRect = new AfficheRectangle((Rectangle)listeFigures.get(i));
				    affRect.paintComponent(g);
				}
				if ((listeFigures.get(i).getClass().getName()).equals("Triangle")) {
				    AfficheTriangle affTriangle = new AfficheTriangle((Triangle)listeFigures.get(i));
				    affTriangle.paintComponent(g);
				}
				if ((listeFigures.get(i).getClass().getName()).equals("Segment")) {
				    AfficheSegment affSegment = new AfficheSegment((Segment)listeFigures.get(i));
				    affSegment.paintComponent(g);
				}
				if ((listeFigures.get(i).getClass().getName()).equals("Texte")) {
				    AfficheTexte affTexte = new AfficheTexte((Texte)listeFigures.get(i));
				    affTexte.paintComponent(g);
				}
			}
		}
	}
	
	
	
	
	
	
	public void initialise(){
		this.add(getPanelOuest(),BorderLayout.WEST);
		this.add(getPanelNord(),BorderLayout.NORTH);

		listeFigures.add(new Cercle(0,0,0,couleurFond,false)); // Pour que la liste ne soit pas vide pour que les conditions contre le bug de MouseListener fonctionnent.
		PanelCentre pan = new PanelCentre();
		this.add(pan, BorderLayout.CENTER);
		
	    BoutonListener button = new BoutonListener();
	    
	    boutonCouleur.addActionListener(button);
	    boutonSupprimer.addActionListener(button);
	    boutonRetour.addActionListener(button);
	    boutonEllipse.addActionListener(button);
	    boutonCercle.addActionListener(button);
	    boutonRectangle.addActionListener(button);
	    boutonTriangle.addActionListener(button);
	    boutonSegment.addActionListener(button);
	    boutonTexte.addActionListener(button);
	    boutonSauvegarder.addActionListener(button);
	    boutonCharger.addActionListener(button);
	    boutonGomme.addActionListener(button);
	    
	    
	    
	    //pan.setFocusable(true);
	    //pan.requestFocus();
	    //pan.addKeyListener(Touche);
	}
	
	
	
	
	
	
	
	// LISTENERS
	
	class BoutonListener implements ActionListener{
		public void actionPerformed (ActionEvent e) {
			if (apercu.size()>0) {
				apercu.clear();
			}
			if (e.getActionCommand()=="Ellipse") {
				numBout = 1;
				apercu.add(new Ellipse(10,35,40,30,couleur,getFigurePleine()));
			}
			if (e.getActionCommand()=="Cercle") {
				numBout = 2;
				apercu.add(new Cercle(30,50,20,couleur,getFigurePleine()));
			}
			if (e.getActionCommand()=="Rectangle") {
				numBout = 3;
				apercu.add(new Rectangle(10,30,40,30,couleur,getFigurePleine()));
			}
			if (e.getActionCommand()=="Triangle") {
				numBout = 4;
				apercu.add(new Triangle(10,70,60,70,35,30,couleur,getFigurePleine()));
			}
			if (e.getActionCommand()=="Segment") {
				numBout = 5;
				apercu.add(new Segment(10,50,50,50,couleur));
			}
			if (e.getActionCommand()=="Ajouter") {
				numBout = 6;
				apercu.add(new Texte("texte",15,50,17,couleur));
			}
			if (e.getActionCommand()=="Supprimer") {
				listeFigures.clear();
				listeFigures.add(new Cercle(10,10,10,couleurFond,false));
			}
			if (e.getActionCommand()=="Retour") {
				if (listeFigures.size()>0)
					listeFigures.remove(listeFigures.get(listeFigures.size()-1));
				if(listeFigures.size() == 0)
					listeFigures.add(new Cercle(0,0,0,couleurFond,true)); // Pour éviter de garder la liste vide (à cause de la correction du bug de la souris)
					
			}
			if (e.getActionCommand()=="Sauvegarder") {
				for(int i=0; i <listeFigures.size();i++){
					Sauvegarde sauv = new Sauvegarde();
					sauv.sauvegarde(listeFigures);
				}
			}
			if (e.getActionCommand()=="Charger") {
				Charge charge = new Charge();
				listeFigures = charge.charge("sauvegarde");
			}
			if (e.getActionCommand()=="Gomme") {
				numBout = 7;
			}
			if (e.getActionCommand()=="Couleur") {
				couleur = JColorChooser.showDialog(null,"Choisissez une couleur", couleur);
				boutonCouleur.setBackground(couleur);
			}
			repaint();
		}
	}
	
	
	class getMouse implements MouseListener, MouseMotionListener {
		public void mousePressed (MouseEvent e) {
			mousex = e.getX();
			mousey = e.getY();
			
			if (numBout == 2) {
				valRayon = choixRayon.getText();
				r = Integer.parseInt(valRayon);
				// Corrige l'ajout de plusieurs figures dans l'arraylist en supprimant la derniere si elle est identique
				if (listeFigures.get(listeFigures.size()-1).getx1() != mousex || listeFigures.get(listeFigures.size()-1).gety1() != mousey)
				listeFigures.add(new Cercle(mousex, mousey, r, couleur, getFigurePleine()));
			}
			if (numBout == 4) {
				if (points.size() == 0) {
					points.add(new Point(mousex, mousey));
				}
				else {
					if (points.get(points.size()-1).getX() != mousex) {
						points.add(new Point(mousex, mousey));
					}
				}
				if (points.size()==3){
					listeFigures.add(new Triangle((int) points.get(0).getX(), (int) points.get(0).getY() ,(int) points.get(1).getX() ,(int) points.get(1).getY() ,(int) points.get(2).getX() ,(int) points.get(2).getY() ,couleur,getFigurePleine()));
					points.clear();
					numBout = 0;
				}
			}
			
			if (numBout == 6) {
				txt = choixTexte.getText();
				String t = choixTaille.getText();
				int taille = Integer.parseInt(t);
				if (listeFigures.get(listeFigures.size()-1).getx1() != mousex || listeFigures.get(listeFigures.size()-1).gety1() != mousey) //correction de bug de souris
				listeFigures.add(new Texte(txt, mousex, mousey, taille, couleur));
			}
			repaint();
			
		}
		
		public void mouseReleased (MouseEvent e) {
			//r = Math.abs((mousex2 + mousey2)-(mousex + mousey));
			mousex2 = e.getX();
			mousey2 = e.getY();
		
			if (numBout == 1) {
				int h = Math.abs(mousey - mousey2);
				int l = Math.abs(mousex - mousex2);
				if (mousey - mousey2 > 0) mousey = mousey - h;
				if (mousex - mousex2 > 0) mousex = mousex - l;
				if (listeFigures.get(listeFigures.size()-1).getx1() != mousex || listeFigures.get(listeFigures.size()-1).gety1() != mousey) //correction de bug de souris
				listeFigures.add(new Ellipse(mousex, mousey, l, h, couleur, getFigurePleine()));
			}
			if (numBout == 3) {
				int h = Math.abs(mousey - mousey2);
				int l = Math.abs(mousex - mousex2);
				if (mousey - mousey2 > 0) mousey = mousey - h;
				if (mousex - mousex2 > 0) mousex = mousex - l;
				if (listeFigures.get(listeFigures.size()-1).getx1() != mousex || listeFigures.get(listeFigures.size()-1).gety1() != mousey) //correction de bug de souris
				listeFigures.add(new Rectangle(mousex, mousey, l, h, couleur, getFigurePleine()));
			}
			if (numBout == 5) {
				if (listeFigures.get(listeFigures.size()-1).getx1() != mousex || listeFigures.get(listeFigures.size()-1).gety1() != mousey) //correction de bug de souris
				listeFigures.add(new Segment(mousex, mousey, mousex2, mousey2, couleur));
			}
			repaint();
		}
		
		public void mouseDragged (MouseEvent e) {
			mousexd = e.getX();
			mouseyd = e.getY();
			
			if (numBout == 7) {
				String t2 = choixTaille2.getText();
				int taille2 = Integer.parseInt(t2);
				if (listeFigures.get(listeFigures.size()-1).getx1() != mousexd || listeFigures.get(listeFigures.size()-1).gety1() != mouseyd) //correction bug de souris
				listeFigures.add(new Cercle(mousexd, mouseyd, taille2, couleurFond, true));
			}
			
			repaint();
			
		}

		public void mouseMoved(MouseEvent arg0) {}
		public void mouseClicked(MouseEvent arg0) {}
		public void mouseEntered(MouseEvent arg0) {}
		public void mouseExited(MouseEvent arg0) {}


	}
	
		////// CLAVIER /////
		/*KeyListener Touche = new KeyListener();		
		public void keyPressed(KeyEvent e) {
			 if (e.getKeyChar() == 'c') {
				 listeFigures.add(new Cercle(600,600,300,couleur));
				 repaint();
			 }
		 }
		public void keyReleased(KeyEvent e) {
		}
		public void keyTyped(KeyEvent e) {
		}*/
	
	
	// Main
	public static void main(String[] args) {
		new Fenetre ("Dessin", 0, 0, Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height);
	}
	
}