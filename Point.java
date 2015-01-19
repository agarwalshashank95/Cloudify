class Point{
    int x,y;
    
    Point(int xx,int yy){
        x=xx;
        y=yy;
    }
    
    void moveAbs(int nx,int ny){
        x=nx;
        y=ny;
    }
    
    void moveRel(int dx,int dy){
        x=x+dx;
        y=y+dy;
    }
}
        