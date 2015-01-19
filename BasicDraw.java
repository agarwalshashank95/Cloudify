import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.Font;

public class BasicDraw {
  public static void main(String[] args) {
    new BasicDraw();
  }

  BasicDraw() {
    JFrame frame = new JFrame();
    frame.add(new MyComponent());

    frame.setSize(300, 300);
    frame.setVisible(true);
    //For setting resizeable
    frame.setResizable(false);
  }

}

class MyComponent extends JComponent {
  public void paint(Graphics g) {
    Graphics2D g2d = (Graphics2D) g;
    
    g2d.setFont(new Font("SansSerif",Font.PLAIN,35));
    FontMetrics fontMetrics = g2d.getFontMetrics();

    int width = fontMetrics.stringWidth("ABCDE");
    int height = fontMetrics.getHeight();
    System.out.println(width);
    System.out.println(height);
    g2d.drawString("ABCDE",(300-width)/2,(300+height)/2);
  }

}