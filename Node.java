class Node{
    int freq;
    String wrd;
    Node left;
    Node right;
    
    Node(String w,int f){
        wrd=w;
        freq=f;
        left=null;
        right=null;
    }
    
    void addFreq(int f){
        freq=freq+f;
    }
}