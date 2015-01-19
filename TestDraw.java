import java.awt.*;
import java.io.*;
import java.util.*;
class TestDraw{
    Random r;
    
    TestDraw(){
        r=new Random();
        StdDraw.setScale(0, 300);
    }
    
    void plotGaussianRandom(){
        int x=getGaussian(150,(int)(0.4*150));
        int y=getGaussian(150,(int)(0.4*150));
        StdDraw.filledCircle(x, y, 1);
    }
    
    public static void main()throws IOException{
        TestDraw td=new TestDraw();
        for(int i=1;i<=10000;i++){
            td.plotGaussianRandom();
        }
        StdDraw.text(0,0,"ABCDE");
    }
    
    int getGaussian(int mean,int variance){
        return (int)(mean + r.nextGaussian() * variance);
    }
}