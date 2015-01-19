class WordTree{
    Node root;
    FreqTree ft; 
    int nodes;
    int counter;
    String temp[];
    
    WordTree(){
        root=null;
        ft=new FreqTree();
        nodes=0;
    }
    
    private void addWord(String s, Node n){
        if(root==null){
            root=new Node(s,1);
            nodes++;
        }
        else{
            if(s.compareTo(n.wrd)<0){
                if(n.left!=null){
                    addWord(s,n.left);
                }
                else{
                    n.left=new Node(s,1);
                    nodes++;
                }
            }
            else if(s.compareTo(n.wrd)>0){
                if(n.right!=null){
                    addWord(s,n.right);
                }
                else{
                    n.right=new Node(s,1);
                    nodes++;
                }
            }
            else if(s.compareTo(n.wrd)==0){
                n.addFreq(1);
            }
        }
    }
    
    void addWord(String s){
        addWord(s,root);
    }
    
    private void inOrderTraverse(Node n){
        if(n!=null){
            inOrderTraverse(n.left);
            System.out.println(n.wrd+" - "+n.freq);
            inOrderTraverse(n.right);
        }
    }
    
    void inOrderTraverse(){
        inOrderTraverse(root);
    }
    
    void makeFreqTree(Node n){
        if(n!=null){
            makeFreqTree(n.left);
            ft.addWord(n.wrd,n.freq);
            makeFreqTree(n.right);
        }
    }
    
    FreqTree makeFreqTree(){
        makeFreqTree(root);
        return ft;
    }
    
    String[] getWordList(){
        temp=new String[nodes];
        counter=0;
        inOrderMakeArray(root);
        return temp;
    }
    
    void inOrderMakeArray(Node n){
        if(n!=null){
            inOrderMakeArray(n.left);
            temp[counter++]=n.wrd+"-"+n.freq;
            inOrderMakeArray(n.right);
        }
    }
}