import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.Font;
import java.awt.*;

import java.io.*;

public class TestDrawing {
  String s;
  public static void main(String[] args) throws IOException{
      new TestDrawing();
  }

  TestDrawing() throws IOException{
    JFrame frame = new JFrame();
    MyComponent c=new MyComponent();
    frame.add(c);

    frame.setSize(300, 300);
    frame.setVisible(true);
    //For setting resizeable
    frame.setResizable(false);
    System.out.println("Enter :");
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    s=br.readLine();
    Font        defaultFont = new Font("Helvetica", Font.PLAIN, 200);
    FontMetrics fontMetrics =  c.getFontMetrics(defaultFont) ;
    System.out.println(fontMetrics.getHeight());
    while(!s.equals("end")){
        c.paint(c.getGraphics(),s);
        s=br.readLine();
    }
  }

}

class MyComponent extends JComponent {
  public void paint(Graphics g,String s) {
    Graphics2D g2d = (Graphics2D) g;
    
    g2d.setFont(new Font("Ubuntu Mono",Font.PLAIN,35));
    FontMetrics fontMetrics = g2d.getFontMetrics();
    g2d.setColor(new Color(10,200,75));
    
    int width = fontMetrics.stringWidth(s);
    int height = fontMetrics.getHeight();
    System.out.println(width);
    System.out.println(height);
    //g2d.drawString(s,(getWidth()-width)/2,(getHeight()-height)/2);
    g2d.drawString(s,0,10);
  }

}