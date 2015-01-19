import javax.swing.*;
import java.awt.*;
import java.util.*;

class CloudyCanvasPrev extends JComponent{
    
    Random r;
    boolean filled[][];
    int w,h;
    Rectangle string;
    
    Font f;
    FontMetrics fontMetrics;
    
    Graphics g;
    
    CloudyCanvasPrev(int wid){
        r=new Random();
        w=wid;
        h=wid;
        filled=new boolean[2*h][2*h];

    }
    
    void init(){
        g=getGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0,0,w,w);
        g.setColor(Color.BLACK);
        for(int i=0;i<w;i++){
            for(int j=0;j<w;j++){
                filled[i][j]=false;
                  
            }
        }
    }
    
    public void paint(Graphics g,String s, Color c, int x, int y){
        g.setColor(c);
        g.drawString(s,x,y);
    }
    
    void addWord(String s, Color c, int size){
        if(size==0) return;
        
        /**
        boolean painted=false;
        
        f=new Font("SansSerif",Font.PLAIN,size);
        g.setFont(f);
        fontMetrics=g.getFontMetrics();
        
        string=new Rectangle(w/2,h/2,fontMetrics.getHeight(),fontMetrics.stringWidth(s));
        System.out.println(size+" inside addWord)");
        for(int i=0;i<=35;i++){
            int x=getGaussian(mean,varx);
            int y=getGaussian(mean,vary);
            string.moveAbs(x,y);
            if(isFree(string)){
                fillRect(string);
                paint(g,s,c,x,y);
                return;
            }
        }
        **/
        
        //addWord(s, c, size-1);
        f=new Font("SansSerif",Font.PLAIN,size);
        g.setFont(f);
        fontMetrics=g.getFontMetrics();
        System.out.println(fontMetrics.stringWidth(s));
        int x=(int)(w*Math.random());
        int y=(int)(w*Math.random());
        string=new Rectangle(x,y-fontMetrics.getHeight(),fontMetrics.getHeight(),fontMetrics.stringWidth(s));
        fillRect(string);
        paint(g,s,c,x,y);
            
    }
    
    boolean isFree(Rectangle r){
        
        if(r.r2.x >w || r.r2.y >w) return false;
        return !(filled[r.l1.x][r.l1.y] ||
                 filled[r.l2.x][r.l2.y] ||
                 filled[r.r1.x][r.r1.y] ||
                 filled[r.r2.x][r.r2.y]);
    }
    
    void fillRect(Rectangle r){
        
        for(int y=r.y;y<r.y+r.width;y++){
            for(int x=r.x;x<r.x+r.height;x++){
                filled[x][y]=true;
            }
        }
        
    }
    
    void showFilled(){
        g.setColor(Color.RED);
        for(int i=0;i<w;i++){
            for(int j=0;j<w;j++){
                if(filled[i][j]){
                    g.drawLine(i,j,i+1,j+1);
                }
            }
        }
    }
        
        
}