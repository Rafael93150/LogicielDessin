import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class PanelCercle extends JPanel{
  public void paintComponent(Graphics g){
    super.paintComponent(g);
    g.drawOval(50, 50, 100, 50);
  }
}
