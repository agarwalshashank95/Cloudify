class Rectangle{
    Point l1,l2;
    Point r1,r2;
    int x,y;
    int height,width;
    Rectangle(int x,int y, int width,int height){
        l1=new Point(x,y);
        l2=new Point(x,y+height);
        r1=new Point(x+width,y);
        r2=new Point(x+width,y+height);
        this.x=x;
        this.y=y;
        this.height=height;
        this.width=width;
    }
    
    void moveRel(int dx,int dy){
        x=x+dx;
        y=y+dy;
        l1.moveRel(dx,dy);
        l2.moveRel(dx,dy);
        r1.moveRel(dx,dy);
        r2.moveRel(dx,dy);
    }
    
    void moveAbs(int nx,int ny){
        int dx=nx-x;
        int dy=ny-y;
        moveRel(dx,dy);
    }
    
}