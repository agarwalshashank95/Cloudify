import java.awt.*;
import javax.swing.*;
public class CloudyCanvasTrial {

  public static void main(String[] args){
      new CloudyCanvasTrial();
  }

  CloudyCanvasTrial(){
    JFrame frame = new JFrame();
    CloudyCanvasPrev cc=new CloudyCanvasPrev(400);
    frame.add(cc);
    frame.setSize(800, 800);
    frame.setVisible(true);
    //For setting resizeable
    //frame.setResizable(false);
    cc.init();
    
    Color c=new Color(0,0,0);
    for(int i=0;i<=10;i++){
        double d=Math.random();
        cc.addWord("end"+d,c,(int)(20*d));
    }
    cc.showFilled();
  }

}