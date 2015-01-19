class FreqTree{
    Node root;
    int nodes;
    String temp[];
    int counter;
    
    FreqTree(){
        root=null;
        nodes=0;
    }
    
    private void addWord(String s, int f, Node n){
        if(root==null){
            root=new Node(s,f);
            nodes++;
        }
        else{
            if(n.freq<=f){
                if(n.left!=null){
                    addWord(s,f,n.left);
                }
                else{
                    n.left=new Node(s,f);
                    nodes++;
                }
            }
            else if(n.freq>f){
                if(n.right!=null){
                    addWord(s,f,n.right);
                }
                else{
                    n.right=new Node(s,f);
                    nodes++;
                }
            }
        }
    }
    
    void addWord(String s,int f){
        addWord(s,f,root);
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