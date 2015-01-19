import java.awt.*;
import java.awt.event.*;
import java.util.*;;
import javax.swing.*;
import java.io.*;

public class CloudyCanvas{
    
    JFrame frame;
    JPanel panel;
    Random random;
    JScrollPane scrollPane;
    
    int maxSize;
    int minSize;
    
    int fmax;
    int fmin;
    
    FreqTree ft;
    WordTree wt;
    String wrds[];
    StringTokenizer st;
    
    String stop_wrds[]; //183
    
    
    CloudyCanvas(String title){
        
        frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        panel = new JPanel(new WrapLayout());
        
        random = new Random();
        
        scrollPane = new JScrollPane(panel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        frame.add(scrollPane);
        
        frame.setSize(500, 550);
        
        ft=new FreqTree();
        wt=new WordTree();
        
        stop_wrds=new String[183];
        
        fmax=-1;
        fmin=999999;
        
        try{
            loadStopWords();
        }
        catch(Exception e){}
        
    }
    
    /**
     * Adds the word to the JPanel. Takes input the string, font size, color.
     */
    void addWord(String wrd, int size, Color c){
        
        JLabel label=new JLabel(wrd);
        label.setForeground(c);
        label.setOpaque(false);
        label.setFont(label.getFont().deriveFont((float)size));
        panel.add(label);
        
        frame.setVisible(true);
        
    }
    
    
    /**
     * Makes the entire word cloud. Takes input the path, max and min font size.
     */
    void makeCloud(String path, int min, int max)throws IOException{
        maxSize=max;
        minSize=min;
        
        readFile(path);
        makeFreqTree();
        
        inOrderPrint(ft.root);
    }
    
    void readFile(String path)throws IOException{
        BufferedReader br=new BufferedReader(new FileReader(path));
        StringBuffer contents=new StringBuffer();
        String l="";
        while((l=br.readLine())!=null){
            contents.append(l);
            contents.append(" ");
        }
        
        String ct=contents.toString();
        st=new StringTokenizer(ct," '!.,()_-\":;0123456789\t\n");
        
    }
    
    void makeFreqTree(){
        
        while(st.hasMoreTokens()){
            String s=st.nextToken().toLowerCase();
            if(!isStopWord(s)){
                wt.addWord(s);
            }
        }
        
        ft=wt.makeFreqTree();
        
        wrds=ft.getWordList();
        
        getfmaxmin(ft.root);
    }
    
    
    void inOrderPrint(Node n){
        if(n!=null){
            inOrderPrint(n.left);
            addWord(n.wrd+" ",7+ConvertRange(n.freq),new Color((int)(10+Math.random()*245),(int)(10+Math.random()*245),(int)(10+Math.random()*245)));
            inOrderPrint(n.right);
        }
    }
    
    
    /**
     * Gets the min and max frequency in the FreqTree.
     */
    void getfmaxmin(Node n){
        if(n!=null){
            getfmaxmin(n.left);
            if(n.freq>fmax){
                fmax=n.freq;
            }
            if(n.freq<fmin){
                fmin=n.freq;
            }
            getfmaxmin(n.right);
        }
    }
    
    /**
     * Load stop words.
     */
    void loadStopWords()throws IOException{
        BufferedReader br=new BufferedReader(new FileReader("stop.txt"));
        for(int i=0;i<183;i++){
            stop_wrds[i]=br.readLine();
        }
    }
    
    /**
     * Returns true if the word is a stop word.
     */
    boolean isStopWord(String s){
        for(int i=0;i<stop_wrds.length;i++){
            if(stop_wrds[i].equals(s)){
                return true;
            }
        }
        return false;
    }
    
    /**
     * Converts range from fmin,fmax to minSize,maxSize
     */
    int ConvertRange(int value) {
        double scale = (double)(maxSize - minSize) / (fmax - fmin);
        return (int)(minSize + ((value - fmin) * scale));
    }
    
    //String[] getNodes(
    
    public static void main(){
        CloudyCanvas cp=new CloudyCanvas("US Constitution");
        try{
            //cp.makeCloud("D:\\usconst.txt",0,100);
            
            cp.minSize=0;
            cp.maxSize=100;
            //cp.readFile("usconst.txt");
            cp.readFile("D:\\apple.txt");
            cp.makeFreqTree();
            cp.inOrderPrint(cp.ft.root);
            


        }
        catch(Exception e){}
    }
    
}